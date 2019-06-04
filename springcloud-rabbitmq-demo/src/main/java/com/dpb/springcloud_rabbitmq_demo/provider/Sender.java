package com.dpb.springcloud_rabbitmq_demo.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud-rabbitmq-demo
 * @description: 消息的发送者
 * @author: 波波烤鸭
 * @create: 2019-05-21 23:23
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitAmqpTemplate;

    @Value("${mq.queue.name}")
    private String queueName;

    /**
     * 创建发送消息的方法
     */
    public void send(String msg){
        // 参数： 队列名称 和 消息内容
        rabbitAmqpTemplate.convertAndSend("hello-queue",msg);
    }

}
