package com.example.smartserver.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "你好，这是来自 Java 后端的响应！";
    }
}
