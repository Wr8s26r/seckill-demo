package com.study.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test(Model model) {
        // 手动添加 java.version 到 Model
        String javaVersion = System.getProperty("java.version");
        model.addAttribute("javaVersion", javaVersion);
        return "test";
    }
}

