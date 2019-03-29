/*
* 消息模块Controller
* */
package com.macro.mall.controller;

import com.macro.mall.component.MqMailSender;
import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.MmsMailSendLog;
import com.macro.mall.service.MmsMailService;
import com.macro.mall.util.MailUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "消息模块-邮件发送",description = "邮件发送:MmsMailController",position = 72)
@Slf4j
@Controller
@RequestMapping("/mail")
public class MmsMailController {
    @Autowired
    private  MqMailSender mqMailSender;
    @Autowired
    private MmsMailService mmsMailService;

    //邮件发送延时毫秒数
    private final long delayTimes = 1000*5;

    @ApiOperation("发送邮件")
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('mms:mail:send')")
    public CommonResult send(@RequestBody SimpleMailMessage simpleMailMessage) {
       if(!MailUtil.checkEmailFormat(simpleMailMessage.getFrom()) ||
               !MailUtil.checkEmailFormat(simpleMailMessage.getReplyTo()) ){
           return new CommonResult().failed(500, "邮箱格式不正确或为空!");
       }
        for (String s : simpleMailMessage.getTo()) {
            if(!MailUtil.checkEmailFormat(s)){
                return new CommonResult().failed(500, "邮箱格式不正确或为空!");
            }
        }

        for (String s : simpleMailMessage.getBcc()) {
            if(!MailUtil.checkEmailFormat(s)){
                simpleMailMessage.setBcc(simpleMailMessage.getFrom());
            }
        }

        for (String s : simpleMailMessage.getCc()) {
            if(!MailUtil.checkEmailFormat(s)){
                simpleMailMessage.setCc(simpleMailMessage.getFrom());
            }
        }

        try {
            mqMailSender.sendMessage(simpleMailMessage, delayTimes);
        }catch(AmqpException e){
            log.error("消息队列发送失败", e);
        }
        return new CommonResult().success(null);
    }

    @ApiOperation("分页查询已发送的邮件信息")
    @ApiResponses({@ApiResponse(code = 201, response = MmsMailSendLog.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('mms:mail')")
    public CommonResult page(@RequestParam(value = "name", required = false, defaultValue = "") String name,
                             @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        List<MmsMailSendLog> mmsMailSendLogList = mmsMailService.page(name, pageNum, pageSize);
        return new CommonResult().pageSuccess(mmsMailSendLogList);
    }
}
