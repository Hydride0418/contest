package yjp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/api/test")
    public String get(){
        System.out.println("ssssssssssss");
        return "zszxz";
    }
}