package com.dpb.rabbitmq_direct_consumer.reciver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmq-direct-consumer
 * @description: Info处理
 * @author: 波波烤鸭
 * @create: 2019-05-23 20:40
 */
@Component
@RabbitListener(
        bindings=@QueueBinding(
                value=@Queue(value="${mq.config.queue.info}",autoDelete="true"),
                exchange=@Exchange(value="${mq.config.exchange}",type= ExchangeTypes.DIRECT),
                key="${mq.config.queue.info.routing.key}"
        )
)
public class InfoReciver {
    /**
     * 接收消息的方法。采用消息队列监听机制
     * @param msg
     */
    @RabbitHandler
    public void process(String msg){
        System.out.println("Info........receiver: "+msg);
    }
}
