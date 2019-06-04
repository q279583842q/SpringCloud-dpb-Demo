package com.dpb.rabbitmq_direct_consumer.reciver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmq-direct-consumer
 * @description: Error处理
 * @author: 波波烤鸭
 * @create: 2019-05-23 20:39
 */
@Component
@RabbitListener(
        bindings=@QueueBinding(
                value=@Queue(value="${mq.config.queue.error}",autoDelete="true"),
                exchange=@Exchange(value="${mq.config.exchange}",type= ExchangeTypes.DIRECT),
                key="${mq.config.queue.error.routing.key}"
        )
)
public class ErrorReciver {

    /**
     * 接收消息的方法。采用消息队列监听机制
     * @param msg
     */
    @RabbitHandler
    public void process(String msg){
        System.out.println("Error..........receiver: "+msg);
        throw new RuntimeException("异常发生了....");
    }
}
