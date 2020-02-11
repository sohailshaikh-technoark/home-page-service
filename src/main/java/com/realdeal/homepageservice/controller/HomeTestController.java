//package com.realdeal.homepageservice.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController("test")
//public class HomeTestController {
//
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping("contact")
//    private String contact() {
//
//        String a = restTemplate.getForObject("http://dhara-api-gateway/api/contact", String.class);
//        return a;
//    }
//
//    @GetMapping
//    private String test() {
//
//        return "Hello World from home";
//    }
//}
