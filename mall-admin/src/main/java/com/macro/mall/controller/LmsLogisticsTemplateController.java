package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.LmsLogisticsTemplate;
import com.macro.mall.service.LmsLogisticsTemplateService;
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
 * 物流模块Controller
 * Created by ruiwu.xu on 2019/01/05.
 */
@Controller
@Api(tags = "物流模块-物流模板",description = "物流模板:LmsLogisticsTemplateController",position = 72)
@RequestMapping("/logistics/template")
public class LmsLogisticsTemplateController {
    @Autowired
    private LmsLogisticsTemplateService logisticsTemplateService;

    @ApiOperation("添加物流模板")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:template:add')")
    public CommonResult add(@RequestBody LmsLogisticsTemplate logisticsTemplate){
        int count = logisticsTemplateService.create(logisticsTemplate);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("更新物流模板")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST, name="物流模板ID")
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:template:update')")
    public CommonResult update(@PathVariable("id") Long id, @RequestBody LmsLogisticsTemplate logisticsTemplate){
        int count = logisticsTemplateService.update(id, logisticsTemplate);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("逻辑删除物流模板")
    @RequestMapping(value = "/logic/delete/{id}",method = RequestMethod.POST, name = "物流模板ID")
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:template:delete')")
    public CommonResult logicDelete(@PathVariable("id") Long id){
        int count = logisticsTemplateService.logicDelete(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("物理删除物流模板")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST, name = "物流模板ID")
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:template:delete')")
    public CommonResult delete(@PathVariable("id") Long id){
        int count = logisticsTemplateService.delete(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询物流模板(单个)")
    @ApiResponses({@ApiResponse(code = 201, response = LmsLogisticsTemplate.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET, name = "物流模板ID")
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:template')")
    public CommonResult get(@PathVariable("id") Long id){
        LmsLogisticsTemplate logisticsTemplate = logisticsTemplateService.getItem(id);
        return new CommonResult().success(logisticsTemplate);
    }

    @ApiOperation("查询物流模板(分页)")
    @ApiResponses({@ApiResponse(code = 201, response = LmsLogisticsTemplate.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:template')")
    public CommonResult page(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        List<LmsLogisticsTemplate> logisticsTemplateList = logisticsTemplateService.page(name, pageSize, pageNum);
        return new CommonResult().pageSuccess(logisticsTemplateList);
    }
}
