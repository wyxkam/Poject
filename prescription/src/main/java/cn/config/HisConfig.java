package cn.config;

import cn.http.HttpClientHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class HisConfig {
    @Bean
    HttpClientHelper httpClientHelper(HttpServletRequest request) {
        return new HttpClientHelper(request);
    }
}
