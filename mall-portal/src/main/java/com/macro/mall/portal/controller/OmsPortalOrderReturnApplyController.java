package com.macro.mall.portal.controller;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.OmsOrderReturnApplyParam;
import com.macro.mall.portal.service.OmsPortalOrderReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 申请退货管理Controller
 * Created by macro on 2018/10/17.
 */
@Controller
@Api(tags = "订单模块-申请退货管理(弃用)", description = "申请退货管理:OmsPortalOrderReturnApplyController")
@ApiIgnore
@RequestMapping("/returnApply")
@Deprecated
public class OmsPortalOrderReturnApplyController {
    @Autowired
    private OmsPortalOrderReturnApplyService returnApplyService;

    @ApiOperation("申请退货")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody OmsOrderReturnApplyParam returnApply) {
        int count = returnApplyService.create(returnApply);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
}
