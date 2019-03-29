package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.LmsLogisticsQueryParamDto;
import com.macro.mall.model.LmsLogisticsCharge;
import com.macro.mall.service.LmsLogisticsChargeService;
import com.macro.mall.vo.LmsLogisticsChargeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物流模块Controller
 * Created by ruiwu.xu on 2019/01/05.
 */
@Api(tags = "物流模块-物流费用(物流模板与物流方式关系)",description = "物流费用(物流模板与物流方式关系):LmsLogisticsChargeController",position = 72)
@Slf4j
@Controller
@RequestMapping("/logistics/charge")
public class LmsLogisticsChargeController {
    @Autowired
    private LmsLogisticsChargeService logisticsChargeService;

    @ApiOperation("增加物流费用")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:charge:add')")
    public CommonResult add(@RequestBody LmsLogisticsCharge lmsLogisticsCharge){
        int count = logisticsChargeService.add(lmsLogisticsCharge);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("更新物流费用")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST, name="物流费用主键ID")
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:charge:update')")
    public CommonResult update(@PathVariable("id") Long id, @RequestBody LmsLogisticsCharge logisticsCharge){
        int count = logisticsChargeService.update(id, logisticsCharge);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询物流费用")
    @ApiResponses({@ApiResponse(code = 201, response = LmsLogisticsChargeVo.class,
            message="状态200的data格式说明：data返回值为对象")})
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:charge')")
    public CommonResult page(@RequestParam(required = false) LmsLogisticsQueryParamDto logisticsQueryParamDto,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<LmsLogisticsChargeVo>  logisticsChargeVoList = logisticsChargeService.page(logisticsQueryParamDto,
                pageSize, pageNum);
        return new CommonResult().success(logisticsChargeVoList);
    }

    @ApiOperation("查询物流费用")
    @ApiResponses({@ApiResponse(code = 201, response = LmsLogisticsCharge.class,
            message="状态200的data格式说明：data返回值为对象")})
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:charge')")
    public CommonResult get(@PathVariable("id") Long id){
        LmsLogisticsCharge logisticsCharge = logisticsChargeService.getItem(id);
        return new CommonResult().success(logisticsCharge);
    }

    @ApiOperation("删除物流费用")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE, name="物流费用主键ID")
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:charge:delete')")
    public CommonResult delete(@PathVariable("id") Long id){
        int count = logisticsChargeService.delete(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
}
