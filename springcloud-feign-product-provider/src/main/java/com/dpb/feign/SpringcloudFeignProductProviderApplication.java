package com.dpb.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringcloudFeignProductProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudFeignProductProviderApplication.class, args);
    }

}
