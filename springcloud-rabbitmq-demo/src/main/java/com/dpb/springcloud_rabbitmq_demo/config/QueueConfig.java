package com.dpb.springcloud_rabbitmq_demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcloud-rabbitmq-demo
 * @description: 创建消息队列
 * @author: 波波烤鸭
 * @create: 2019-05-21 23:18
 */
@Configuration
public class QueueConfig {
    @Value("${mq.queue.name}")
    private String queueName;

    @Bean
    public Queue createQueue(){
        return new Queue(queueName);
    }
}
