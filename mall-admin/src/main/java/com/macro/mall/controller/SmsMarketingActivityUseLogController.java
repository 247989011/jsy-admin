package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.SmsMarketingActivities;
import com.macro.mall.model.SmsMarketingActivityUseLog;
import com.macro.mall.service.SmsMarketingActivityUseLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 营销活动Controller
 * Created by ruiwu.xu on 2019/01/05.
 */
@Api(tags = "营销模块-营销活动的使用日志",description = "营销活动的使用日志:SmsMarketingActivityUseLogController",position = 72)
@Controller
@RequestMapping("/marketingActivity/useLog")
public class SmsMarketingActivityUseLogController {
    @Autowired
    private SmsMarketingActivityUseLogService smsMarketingActivityUseLogService;

    @ApiOperation("查询营销活动的使用日志(分页查询)")
    @ApiResponses({@ApiResponse(code = 201, response = SmsMarketingActivities.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity:useLog')")
    public CommonResult page(@RequestParam(value = "name",required = false, defaultValue = "") String name,
                          @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                          @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
        List<SmsMarketingActivityUseLog>  marketingActivityUseLogList = smsMarketingActivityUseLogService.page(name,pageSize,pageNum);
        return new CommonResult().pageSuccess(marketingActivityUseLogList);
    }
}
