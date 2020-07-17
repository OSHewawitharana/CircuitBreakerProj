package com.example.demo.connector;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;

@Component
@CircuitBreaker(name = "ratingService")
public class TestingConnector {

    @Autowired
    RestTemplate restTemplate;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger("trace");

    public String testMethod() {

        URI uri = UriComponentsBuilder.fromUriString("http://localhost:7083/api/standing-order/contractId/32928636")
                .buildAndExpand(Collections.emptyMap()).toUri();
        String resCode = "";
//        try {
            resCode = restTemplate.getForObject(uri, String.class);
            if (!StringUtils.isEmpty(resCode)) resCode = resCode.replace("\n", "");
            logger.debug("changeMobileData [{}] response [{}]",uri, resCode);

//        } catch (Exception ex) {
//            logger.error("changeMobileData {}", ex);
//        }

        return resCode;
    }

}
