package com.macro.mall.common.component;

import com.macro.mall.common.domain.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息的发出者
 * Created by ruiwu.xu on 2019/01/16.
 */
@Component
public class MqMailSender {
    private static Logger LOGGER =LoggerFactory.getLogger(MqMailSender.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(SimpleMailMessage simpleMailMessage, final long delayTimes){
        //给延迟队列发送消息
        amqpTemplate.convertAndSend(QueueEnum.QUEUE_MAIL.getExchange(), QueueEnum.QUEUE_MAIL.getRouteKey(), simpleMailMessage, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //给消息设置延迟毫秒值
                message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                return message;
            }
        });

        LOGGER.info("send MQ simpleMailMessage:{}", simpleMailMessage);
    }
}
