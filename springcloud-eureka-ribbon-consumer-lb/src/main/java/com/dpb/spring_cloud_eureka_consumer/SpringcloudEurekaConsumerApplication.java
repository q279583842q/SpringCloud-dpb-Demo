package com.dpb.spring_cloud_eureka_consumer;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class SpringcloudEurekaConsumerApplication {
    /**
     * 显示实例化 负载均衡的策略对象，那么默认的轮询策略就会失效
     * @return
     */
/*    @Bean
    public RandomRule createRule(){
        return new RandomRule();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaConsumerApplication.class, args);
    }

}
