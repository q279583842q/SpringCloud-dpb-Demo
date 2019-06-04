package com.dpb.springcloud_eureka_server_ha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringcloudEurekaServerHaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaServerHaApplication.class, args);
    }

}
