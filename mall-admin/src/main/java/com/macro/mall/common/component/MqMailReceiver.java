package com.macro.mall.common.component;

import com.macro.mall.common.mapper.MmsMailSendLogMapper;
import com.macro.mall.common.model.MmsMailSendLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 取消订单消息的处理者
 * Created by ruiwu.xu on 2019/01/06.
 */
@Component
@RabbitListener(queues = "mall.mail")
@Slf4j
public class MqMailReceiver {
    @Autowired
    private  JavaMailSender jms;
    @Autowired
    private MmsMailSendLogMapper mmsMailSendLogMapper;

    @RabbitHandler
    public void handle(SimpleMailMessage simpleMailMessage){
        MmsMailSendLog mmsMailSendLog = new MmsMailSendLog();

        simpleMailMessage.setBcc(simpleMailMessage.getFrom());
        simpleMailMessage.setCc(simpleMailMessage.getFrom());

        StringBuffer sTemp = new StringBuffer();
        for (String s : simpleMailMessage.getCc()) {
            sTemp.append(s);
        }
        mmsMailSendLog.setCc(sTemp.toString());

        StringBuffer sTemp1 = new StringBuffer();
        for (String s : simpleMailMessage.getBcc()) {
            sTemp1.append(s);
        }
        mmsMailSendLog.setBcc(sTemp1.toString());

        mmsMailSendLog.setReplyto(simpleMailMessage.getReplyTo());

        StringBuffer sTemp2 = new StringBuffer();
        for (String s : simpleMailMessage.getTo()) {
            sTemp2.append(s);
        }
        mmsMailSendLog.setToAddr(sTemp2.toString());

        mmsMailSendLog.setFromAddr(simpleMailMessage.getFrom());
        mmsMailSendLog.setSubject(simpleMailMessage.getSubject());
        mmsMailSendLog.setSendDate(simpleMailMessage.getSentDate());
        mmsMailSendLog.setText(simpleMailMessage.getText());
        mmsMailSendLog.setLastCreateId(simpleMailMessage.getFrom());
        mmsMailSendLog.setLastUpdateId(simpleMailMessage.getFrom());
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        mmsMailSendLog.setLastCreateTime(df.format(new Date()));// new Date()为获取当前系统时间
        mmsMailSendLog.setLastUpdateTime(df.format(new Date()));// new Date()为获取当前系统时间

        try {
            jms.send(simpleMailMessage);
            mmsMailSendLog.setSendStatus("00"); //00 - 发送成功
            mmsMailSendLogMapper.insert(mmsMailSendLog);
        }catch (MailException e){
            mmsMailSendLog.setSendStatus("01"); //00 - 发送失败
            mmsMailSendLogMapper.insert(mmsMailSendLog);
            log.error("邮件发送失败:", e);
            return ;
        }
        log.info("成功获取并发送邮件 simpleMailMessage:{}",simpleMailMessage.toString());
    }
}
