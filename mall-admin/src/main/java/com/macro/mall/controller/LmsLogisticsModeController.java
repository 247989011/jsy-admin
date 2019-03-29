package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.LmsLogisticsMode;
import com.macro.mall.service.LmsLogisticsModeService;
import com.macro.mall.vo.UmsMemberVo;
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
@Controller
@Api(tags = "物流模块-物流方式",description = "物流方式:LmsLogisticsModeController",position = 72)
@Slf4j
@RequestMapping("/logistics/mode")
public class LmsLogisticsModeController {
    @Autowired
    private LmsLogisticsModeService logisticsModeService;

    @ApiOperation("增加物流方式")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:mode:add')")
    public CommonResult add(@RequestBody LmsLogisticsMode lmsLogisticsMode){
        int count = logisticsModeService.add(lmsLogisticsMode);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("更新物流方式")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:mode:update')")
    public CommonResult update(@RequestBody LmsLogisticsMode lmsLogisticsMode){
        int count = logisticsModeService.update(lmsLogisticsMode);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("逻辑删除物流方式")
    @RequestMapping(value = "/logic/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:mode:delete')")
    public CommonResult logicDelete(@PathVariable("id") Long id){
        int count = logisticsModeService.logicDelete(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询物流方式")
    @ApiResponses({@ApiResponse(code = 201, response = LmsLogisticsMode.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:mode')")
    public CommonResult page(@RequestParam(value = "name", required = false, defaultValue = "") String name,
                             @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
         List<LmsLogisticsMode> logisticsModeList = logisticsModeService.page(name, pageSize, pageNum);
        return new CommonResult().pageSuccess(logisticsModeList);
    }

    @ApiOperation("查询物流方式(by ID)")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberVo.class,
            message = "状态200的data格式说明：data返回值为单个对象")})
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('lms:logistics:mode')")
    public CommonResult get(@PathVariable(name = "id") Long id) {
        LmsLogisticsMode mode = logisticsModeService.selectModeById(id);
        return new CommonResult().success(mode);
    }
}
