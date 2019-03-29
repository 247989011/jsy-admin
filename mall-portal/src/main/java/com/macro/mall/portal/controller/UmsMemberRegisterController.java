package com.macro.mall.portal.controller;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.LoginParam;
import com.macro.mall.portal.service.UmsMemberRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 会员登录注册管理Controller
 * Created by macro on 2018/8/3.
 */
@Api(tags = "客户模块-登录注册管理", description = "登录注册管理:UmsMemberController")
@Controller
@RequestMapping("/sso")
public class UmsMemberRegisterController {
    @Autowired
    private UmsMemberRegisterService memberService;

    @ApiOperation(value = "登录以后返回token")
    @ApiResponses({@ApiResponse(code = 201, response = Map.class,
            message="状态200的data格式说明：data返回值为MAP")})
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody LoginParam loginParam,
                              BindingResult result) {
        return memberService.login(loginParam.getEmail(), loginParam.getPassword());
    }

    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestParam String mail,
                           @RequestParam String password,
                           @RequestParam String phone,
                           @RequestParam String authCode) {
        return memberService.register(mail, password, phone, authCode);
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public Object getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public Object updatePassword(@RequestParam String telephone,
                                 @RequestParam String password,
                                 @RequestParam String authCode) {
        return memberService.updatePassword(telephone,password,authCode);
    }
}
