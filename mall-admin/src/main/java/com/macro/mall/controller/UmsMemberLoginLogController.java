package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.UmsMemberLoginLogDto;
import com.macro.mall.service.UmsMemberLoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员跟踪日志Controller
 * Created by ruiwu.xu on 2019/01/02.
 */
@Controller
@Api(tags = "客户模块-客户登录日志",description = "客户登录日志:UmsMemberLoginLogController",position = 20)
@RequestMapping("/member/login/log")
public class UmsMemberLoginLogController {

    @Autowired
    private UmsMemberLoginLogService  umsMemberLoginLogService;

    @ApiOperation("分页查询会员的登录日志(by 客户姓名 )")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberLoginLogDto.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:login:log')")
    public CommonResult page(@RequestParam(name = "name", required = false, defaultValue = "") String name,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                             @RequestParam(name = "pageNum", required =  false, defaultValue = "5") Integer pageNum){
        List<UmsMemberLoginLogDto> memberLoginLogDtoList = umsMemberLoginLogService.page(name, pageSize, pageNum);
        return new CommonResult().pageSuccess(memberLoginLogDtoList);
    }
}
