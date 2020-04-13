package cn.controller;

import cn.util.HttpClientHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserController {
    @Resource
    private HttpClientHelper httpClientHelper;

    private String clientUrl="http://localhost:9006";
    @GetMapping("/user")
    public Authentication getUser(Authentication authentication){
        return authentication;
    }

    @GetMapping("/call/client2/users/{id}")
    public Object callClient2GetUser(@PathVariable Integer id){
        return httpClientHelper.get(clientUrl+"/api/users/"+id, Map.class);
    }
    @GetMapping("/call/client2/users")
    public Object callClient2GetUsers(){
        return httpClientHelper.get(clientUrl+"/api/users", List.class);
    }
}
