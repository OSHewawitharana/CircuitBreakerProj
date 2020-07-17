package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TestConfig {

        @Bean
        @ConditionalOnMissingBean(name = "restTemplate")
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
}
