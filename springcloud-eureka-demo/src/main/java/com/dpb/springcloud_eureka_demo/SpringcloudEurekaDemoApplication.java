package com.dpb.springcloud_eureka_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringcloudEurekaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaDemoApplication.class, args);
    }

}
