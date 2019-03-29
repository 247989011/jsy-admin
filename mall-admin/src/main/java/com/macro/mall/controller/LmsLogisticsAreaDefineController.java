package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.LmsLogisticsAreaDefine;
import com.macro.mall.model.LmsLogisticsMode;
import com.macro.mall.model.LmsLogisticsTemplate;
import com.macro.mall.service.LmsLogisticsAreaDefineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物流方式Controller
 * Created by ruiwu.xu on 2019/01/05.
 */
@Api(tags = "物流模块-物流地区",description = "物流地区:LmsLogisticsAreaDefineController",position = 72)
@Slf4j
@Controller
@RequestMapping("/logistics/area")
public class LmsLogisticsAreaDefineController {
    @Autowired
    private LmsLogisticsAreaDefineService  lmsLogisticsAreaDefineService;

    @ApiOperation("增加物流地区")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:area:add')")
    public CommonResult add(@RequestBody LmsLogisticsAreaDefine lmsLogisticsAreaDefine){
        int count = lmsLogisticsAreaDefineService.add(lmsLogisticsAreaDefine);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("更新物流地区")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:area:update')")
    public CommonResult update(@RequestBody LmsLogisticsAreaDefine lmsLogisticsAreaDefine){
        int count = lmsLogisticsAreaDefineService.update(lmsLogisticsAreaDefine);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除物流地区")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:area:delete')")
    public CommonResult delete(@PathVariable("id") Long id){
        int count = lmsLogisticsAreaDefineService.delete(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询物流地区")
    @ApiResponses({@ApiResponse(code = 201, response = LmsLogisticsMode.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:area')")
    public CommonResult page(@RequestParam(value = "name", required = false, defaultValue="") String name,
                             @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        List<LmsLogisticsAreaDefine> lmsLogisticsAreaDefineList =
                lmsLogisticsAreaDefineService.list(name, pageSize, pageNum);
        return new CommonResult().pageSuccess(lmsLogisticsAreaDefineList);
    }

    @ApiOperation("查询物流地区(单个)")
    @ApiResponses({@ApiResponse(code = 201, response = LmsLogisticsTemplate.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET, name = "物流模板ID")
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logisticsArea')")
    public CommonResult get(@PathVariable("id") Long id){
        LmsLogisticsAreaDefine logisticsAreaDefine = lmsLogisticsAreaDefineService.getItem(id);
        return new CommonResult().success(logisticsAreaDefine);
    }
}
