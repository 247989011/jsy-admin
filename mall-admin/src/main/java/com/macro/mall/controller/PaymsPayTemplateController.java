package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.PaymsPayTemplateModeRelationDto;
import com.macro.mall.model.PaymsPayMode;
import com.macro.mall.model.PaymsPayTemplate;
import com.macro.mall.service.OmsPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单管理Controller
 * Created by macro on 2018/10/11.
 */
@Api(tags = "支付模块-支付模板", description = "支付模板:PaymsPayTemplateController",position = 50)
@Controller
@RequestMapping("/pay/template")
public class PaymsPayTemplateController {
    @Autowired
    private OmsPayService omsPayService;

    @ApiOperation("增加支付模板")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('payms:pay:template:add')")
    public CommonResult add(@RequestBody PaymsPayTemplate payTemplate) {
        int count = omsPayService.addPayTeamplate(payTemplate);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("更新支付模板")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('payms:pay:template:update')")
    public CommonResult update(@RequestBody PaymsPayTemplate payTemplate) {
        int count = omsPayService.updatePayTeamplate(payTemplate);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除支付模板(物理删)")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('payms:pay:template:delete')")
    public CommonResult delete(@PathVariable("id") Long id) {
        int count = omsPayService.deletePayTeamplate(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询支付模板(ALL)")
    @ApiResponses({@ApiResponse(code = 201, response = PaymsPayTemplate.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('payms:pay:template')")
    public CommonResult list() {
        List<PaymsPayTemplate> payTemplateList = omsPayService.listPayTeamplateAll();
        return new CommonResult().success(payTemplateList);
    }

    @ApiOperation("增加支付模板的支付方式")
    @RequestMapping(value = "/mode/add/{templateId}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('payms:pay:template:mode:add')")
    public CommonResult addPayModeOfPayTemplate(@PathVariable("templateId") Long templateId,
                                                @RequestBody List<PaymsPayMode> listPaymsPayMode) {
        int count = omsPayService.addPayModeOfPayTemplate(templateId, listPaymsPayMode);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除支付模板的支付方式(物理删)")
    @RequestMapping(value = "/mode/batch/delete/{templateId}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('payms:pay:template:mode:delete')")
    public CommonResult batchDeletePayModeOfPayTeamplate(@PathVariable("templateId") Long templateId,
                                                         @RequestBody List<Long> ids) {
        int count = omsPayService.deletePayModeOfPayTemplate(templateId, ids);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询支付模板的支付方式(ALL)")
    @ApiResponses({@ApiResponse(code = 201, response = PaymsPayTemplateModeRelationDto.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/mode/list/{templateId}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('payms:pay:template:mode')")
    public CommonResult listPayModeOfPayTeamplate(@PathVariable("templateId") Long templateId) {
        List<PaymsPayTemplateModeRelationDto> paymsPayModeDtoList = omsPayService.listPayModeOfPayTeamplate(templateId);
        return new CommonResult().success(paymsPayModeDtoList);
    }
}
