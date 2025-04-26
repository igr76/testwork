package org.example.testwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
public class TestWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestWorkApplication.class, args);
    }

}
