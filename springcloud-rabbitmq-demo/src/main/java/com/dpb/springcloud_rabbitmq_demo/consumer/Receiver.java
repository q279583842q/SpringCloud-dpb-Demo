package com.dpb.springcloud_rabbitmq_demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud-rabbitmq-demo
 * @description: 消费者
 * @author: 波波烤鸭
 * @create: 2019-05-21 23:26
 */
@Component
public class Receiver {

    /**
     * 接收消息的方法，采用消息队列监听机制
     * @param msg
     */
    @RabbitListener(queues = "${mq.queue.name}")
    public void process(String msg){
        System.out.println("recevier:"+msg);
    }
}
