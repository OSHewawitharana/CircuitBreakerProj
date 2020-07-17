package com.example.demo.controller;

import com.example.demo.connector.TestingConnector;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestingController {

    @Autowired
    TestingConnector testConnector;

    @GetMapping(value = "/testing")
    @CircuitBreaker(name = "ratingService", fallbackMethod = "getFallbackRatings")
    public String testMethod() {
        return testConnector.testMethod();
    }

    public String getFallbackRatings(Exception ex) {
        return "Failed";
    }


}
