package com.example.sprintrabbitmq.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/")
public class HomeController {

    @GetMapping("/test")
    public Map<String,String> test() {
        return Map.of("Test", "test");
    }


}
