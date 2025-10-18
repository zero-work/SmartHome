package com.example.smartserver.controller;

import com.example.smartserver.entity.User;
import com.example.smartserver.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 登录接口
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) {
            return Map.of("status", "success", "message", "登录成功");
        } else {
            return Map.of("status", "fail", "message", "用户名或密码错误");
        }
    }
}