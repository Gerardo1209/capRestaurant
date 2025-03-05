package com.capgemini.bootcamp.java.excerciseone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public String test(){
        return "Testing complete";
    }

    @PostMapping("/")
    public String testPost(){
        return "Test post";
    }
}
