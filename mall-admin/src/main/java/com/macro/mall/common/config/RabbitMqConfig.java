package com.macro.mall.common.config;

import com.macro.mall.common.domain.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列配置
 * Created by macro on 2018/9/14.
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 邮件消息实际消费队列所绑定的交换机
     */
    @Bean
    DirectExchange mailDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_MAIL.getExchange())
                .durable(true)
                .build();
    }


    /**
     * 订单实际消费队列
     */
    @Bean
    public Queue mailQueue() {
        return new Queue(QueueEnum.QUEUE_MAIL.getName());
    }

    /**
     * 将订单队列绑定到交换机
     */
    @Bean
    Binding orderBinding(DirectExchange mailDirect,Queue mailQueue){
        return BindingBuilder
                .bind(mailQueue)
                .to(mailDirect)
                .with(QueueEnum.QUEUE_MAIL.getRouteKey());
    }

}
