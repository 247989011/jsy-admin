package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.SmsMarketingActivityRule;
import com.macro.mall.service.SmsMarketingActivityRuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 营销活动规则Controller
 * Created by ruiwu.xu on 2019/01/05
 */

@Api(tags = "营销模块-营销活动规则",description = "营销活动规则:SmsMarketingActivityRuleController",position = 73)
@Controller
@RequestMapping("/marketingActivity/rule")
public class SmsMarketingActivityRuleController {
    @Autowired
    private SmsMarketingActivityRuleService marketingActivityRuleService;

    @ApiOperation("添加营销活动规则")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity:rule:add')")
    public CommonResult add(@RequestBody SmsMarketingActivityRule marketingActivityRule){
        int count = marketingActivityRuleService.create(marketingActivityRule);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("更新营销活动规则(by id)")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity:rule:update')")
    public CommonResult update(@PathVariable Long id, @RequestBody SmsMarketingActivityRule marketingActivityRule){
        int count = marketingActivityRuleService.update(id,marketingActivityRule);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除营销活动规则(by id)")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity:rule:delete')")
    public CommonResult delete(@PathVariable Long id){
        int count = marketingActivityRuleService.delete(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询营销活动规则(by id)")
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity:rule')")
    public CommonResult getItem(@PathVariable Long id){
        SmsMarketingActivityRule marketingActivityRule = marketingActivityRuleService.getItem(id);
        return new CommonResult().success(marketingActivityRuleService);
    }
}
