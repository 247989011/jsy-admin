package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.SmsMarketingActivitiesDto;
import com.macro.mall.model.SmsMarketingActivities;
import com.macro.mall.service.SmsMarketingActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 营销活动Controller
 * Created by ruiwu.xu on 2019/01/05.
 */
@Api(tags = "营销模块-营销活动",description = "营销活动:SmsMarketingActivityController",position = 72)
@Controller
@RequestMapping("/marketingActivity")
public class SmsMarketingActivityController {
    @Autowired
    private SmsMarketingActivityService marketingActivityService;

    @ApiOperation("添加营销活动")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity:add')")
    public CommonResult add(@RequestBody SmsMarketingActivities marketingActivities){
        int count = marketingActivityService.add(marketingActivities);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("添加营销活动v2")
    @RequestMapping(value = "/add/v2",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity:add')")
    public CommonResult addV2(@RequestBody SmsMarketingActivitiesDto marketingActivitiesDto){
        int count = marketingActivityService.addV2(marketingActivitiesDto);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("编辑营销活动(by id)")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity:update')")
    public CommonResult update(@PathVariable(name = "id") Long id,
                         @RequestBody SmsMarketingActivities marketingActivities){
        int count = marketingActivityService.update(id, marketingActivities);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("更新营销活动状态(by id)")
    @RequestMapping(value = "/update/status/{id}",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity:update')")
    public CommonResult updateStatus(@PathVariable(name = "id") Long id,
                                     @RequestParam(name = "活动状态(00 - 活动开始;01 - 活动结束)") String status){
        int count = marketingActivityService.updateStatus(id, status);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除营销活动(by id)")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity:delete')")
    public CommonResult delete(@PathVariable Long id){
        int count = marketingActivityService.delete(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询营销活动的详情(by id)")
    @ApiResponses({@ApiResponse(code = 201, response = SmsMarketingActivities.class,
            message="状态200的data格式说明：data返回值为单个对象")})
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity')")
    public CommonResult get(@PathVariable Long id){
        SmsMarketingActivities marketingActivities = marketingActivityService.getItem(id);
        return new CommonResult().success(marketingActivities);
    }

    @ApiOperation("查询营销活动(分页查询)")
    @ApiResponses({@ApiResponse(code = 201, response = SmsMarketingActivities.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity')")
    public CommonResult page(@RequestParam(value = "name",required = false, defaultValue = "")String name,
                          @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                          @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
        List<SmsMarketingActivities> marketingActivitiesList = marketingActivityService.list(name,pageSize,pageNum);
        return new CommonResult().pageSuccess(marketingActivitiesList);
    }
}
