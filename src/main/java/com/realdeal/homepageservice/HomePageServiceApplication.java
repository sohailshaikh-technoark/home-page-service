package com.realdeal.homepageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient
//@EnableCircuitBreaker
public class HomePageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomePageServiceApplication.class, args);
    }


    // @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
