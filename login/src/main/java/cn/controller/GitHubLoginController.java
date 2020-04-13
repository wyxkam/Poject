package cn.controller;

import cn.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Map;

@Controller
@Slf4j
public class GitHubLoginController {

    @Value("${github.url}")
    private String serverUrl;
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    /**
     * 第一步，获取code(授权码)
     */
    @GetMapping("/github")
    public void getcode(HttpServletResponse response) {
        try {
            String url = serverUrl + "/oauth/authorize?client_id=" + clientId
                    + "&state=STATE&redirect_uri=" + URLEncoder.encode(redirectUri, "utf-8");
            response.sendRedirect(url);
        } catch (Exception e) {
            log.error("获取授权码失败:", e);
        }
    }

    //回调地址
    @RequestMapping("/githubLogin")
    public String callback(String code, String state, Model model, HttpServletRequest req) throws Exception {

        if (!StringUtils.isEmpty(code) && !StringUtils.isEmpty(state)) {
            String token_url = serverUrl + "/oauth/access_token?client_id=" + clientId +
                    "&client_secret=" + clientSecret + "&code=" + code + "&redirect_uri=" + redirectUri;
//            String token_url = GitHubConstant.TOKEN_URL.replace("CODE", code);
            //得到的responseStr是一个字符串需要将它解析放到map中
            String responseStr = HttpClientUtils.doGet(token_url);
            // 调用方法从map中获得返回的--》 令牌
            String token = HttpClientUtils.getMap(responseStr).get("access_token");
            //根据token发送请求获取登录人的信息  ，通过令牌去获得用户信息
            String userinfo_url = "https://api.github.com/user?access_token=" + token;
//            String userinfo_url = GitHubConstant.USER_INFO_URL.replace("TOKEN", token);
            responseStr = HttpClientUtils.doGet(userinfo_url);
            Map<String, String> responseMap = HttpClientUtils.getMapByJson(responseStr);
            model.addAttribute("data", responseMap);
            return "/index1";
        }
        return "/error";
    }
}

    /**
     * 第二步，根据code换取access_token(自动回调的地址,要在第三方平台上登记)
     *//*
    @SuppressWarnings("unchecked")
    @GetMapping("/githubLogin")
    public String callback(String code, String state, Model model) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClientBuilder.create().build();

            HttpPost httpPost = new HttpPost(serverUrl + "/oauth/access_token");
            //构造post参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
//            list.add(new BasicNameValuePair("grant_type", "authorization_code"));
            list.add(new BasicNameValuePair("code", code));
            list.add(new BasicNameValuePair("client_id", clientId));
            list.add(new BasicNameValuePair("redirect_uri", redirectUri));
            list.add(new BasicNameValuePair("client_secret", clientSecret));
            list.add(new BasicNameValuePair("state", state));
            HttpEntity entity = new UrlEncodedFormEntity(list);
            httpPost.setEntity(entity);
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36");
            //发送请求，获取响应
            response = httpClient.execute(httpPost);
            String result =EntityUtils.toString(response.getEntity());
            log.info("响应结果:{}",result);
            //根据http状态码判断是否成功
            if(response.getStatusLine().getStatusCode()==200) {
                Map<String, String> tokenObject = new HashMap<String, String>();
                ObjectMapper om = new ObjectMapper();
                tokenObject = om.readValue(result, Map.class);
                log.info(tokenObject.toString());
                String access_token = tokenObject.get("access_token");
                return "redirect:/getGitHubUser?access_token=" + access_token;
            } else {
                log.error("获取access_token失败:");
            }
        } catch (Exception e) {
            log.error("获取access_token失败:", e);
        } finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return "error";
    }
    *//**
     * 第三步，根据access_token获取服务器上授权开放的资源，这里是获取码云的用户信息
     *//*
    @SuppressWarnings("unchecked")
    @GetMapping("/getGitHubUser")
    public String getuser(String access_token, String state, Model model) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClientBuilder.create().build();

            HttpGet httpGet = new HttpGet("https://api.github.com/user?access_token=" + access_token);
            httpGet.addHeader("Content-Type", "application/json");
            httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36");
            //发送请求，获取响应
            response = httpClient.execute(httpGet);
            String result = EntityUtils.toString(response.getEntity());
            log.info("响应结果:{}",result);
            //根据http状态码判断是否成功
            if(response.getStatusLine().getStatusCode()==200) {
                Map<String, String> userObject = new HashMap<String, String>();
                ObjectMapper om = new ObjectMapper();
                userObject = om.readValue(result, Map.class);
                log.info(userObject.toString());
                model.addAttribute("data", userObject);
            } else {
                log.error("获取用户信息失败:");
            }
        } catch (Exception e) {
            log.error("获取用户信息失败:", e);
        } finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return "index";
    }*/

   /* GitHubConstant
    // 这里填写在GitHub上注册应用时候获得 CLIENT ID
    public static final String CLIENT_ID = "a00e66509ded17e42c83";
    //这里填写在GitHub上注册应用时候获得 CLIENT_SECRET
    public static final String CLIENT_SECRET = "c6dff266bf5702722aa8b719d14991864220f6ce";
    // 回调路径
    public static final String CALLBACK = "http://wyxwyx.natapp1.cc/githubLogin";

    //获取code的url
    public static final String CODE_URL = "https://github.com/login/oauth/authorize?client_id=" + CLIENT_ID + "&state=STATE&redirect_uri=" + CALLBACK + "";
    //获取token的url
    public static final String TOKEN_URL = "https://github.com/login/oauth/access_token?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&code=CODE&redirect_uri=" + CALLBACK + "";
    //获取用户信息的url
    public static final String USER_INFO_URL = "https://api.github.com/user?access_token=TOKEN";*/


