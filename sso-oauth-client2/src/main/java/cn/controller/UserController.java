package cn.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    @RequestMapping("/user")
    public Authentication getUser(Authentication authentication) {
        return authentication;
    }

    @RequestMapping("users/{id}")
    public Object get(@PathVariable Integer id) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("username", "张三");
        user.put("gender", "男");
        return user;
    }

    @RequestMapping("/users")
    public Object getUsers() {
        Map<String, Object> user = new HashMap<>();
        user.put("id", 1);
        user.put("username", "张三");
        user.put("gender", "男");
        Map<String, Object> user1 = new HashMap<>();
        user1.put("id", 2);
        user1.put("username", "李四");
        user1.put("gender", "女");
        List<Map<String, Object>> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        return users;
    }
}
