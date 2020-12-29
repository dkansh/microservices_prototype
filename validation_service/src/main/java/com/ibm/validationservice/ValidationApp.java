package com.ibm.validationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ValidationApp {
    public static void main(String[] args) {
        SpringApplication.run(ValidationApp.class, args);
    }

}
