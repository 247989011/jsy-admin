package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.SmsMarketingActivityProductRelationDTO;
import com.macro.mall.model.SmsMarketingActivityProductRelation;
import com.macro.mall.service.SmsMarketingActivityProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 营销活动关联商品Controller
 * Created by ruiwu.xu on 2019/01/05.
 */
@Api(tags = "营销模块-营销活动关联的商品",description = "营销活动关联的商品:SmsMarketingActivityProductController",position = 74)
@Controller
@RequestMapping("/marketingActivity/product")
public class SmsMarketingActivityProductController {
    @Autowired
    private SmsMarketingActivityProductService  marketingActivityProductService;

    @ApiOperation("添加营销活动关联的商品(批量)")
    @RequestMapping(value = "/relation/batch/add",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity:product:relation:add')")
    public CommonResult batchAdd(@RequestBody List<SmsMarketingActivityProductRelation>
                                                 marketingActivityProductRelationList){
        int count = marketingActivityProductService.batchAdd(marketingActivityProductRelationList);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除营销活动关联的商品(批量)")
    @RequestMapping(value = "/relation/batch/delete",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity:product:relation:delete')")
    public CommonResult batchDelete(@RequestBody List<Long> ids){
        int count = marketingActivityProductService.batchDelete(ids);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询营销活动关联的商品(批量)")
    @ApiResponses({@ApiResponse(code = 201, response = SmsMarketingActivityProductRelationDTO.class,
            message="状态200的data格式说明：data返回值为对象")})
    @RequestMapping(value = "/relation/page/{activityId}",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('sms:marketingActivity:product:relation')")
    public CommonResult page(@PathVariable("activityId") Long activityId,
                                            @RequestParam(value = "pageNum",defaultValue = "1") Integer  pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize ){
        List<SmsMarketingActivityProductRelationDTO> marketingActivityProductRelationDTOList =
                marketingActivityProductService.page(activityId, pageNum, pageSize);
        return new CommonResult().pageSuccess(marketingActivityProductRelationDTOList);
    }
}
