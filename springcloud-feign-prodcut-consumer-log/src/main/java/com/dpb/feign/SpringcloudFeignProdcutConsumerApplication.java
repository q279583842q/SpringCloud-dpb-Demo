package com.dpb.feign;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudFeignProdcutConsumerApplication {

    /**
     * NONE:不记录任何信息，默认值
     * BASIC:记录请求方法、请求 URL、状态码和用时
     * HEADERS:在 BASIC 基础上再记录一些常用信息
     * FULL:记录请求和相应的所有信息
     * @return
     */
    @Bean
    public Logger.Level getLogger(){
        return Logger.Level.FULL;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudFeignProdcutConsumerApplication.class, args);
    }

}
