package com.macro.mall.portal.controller;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.MemberDetails;
import com.macro.mall.portal.service.UmsMemberReceiveAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * 会员收货地址管理Controller
 * Created by macro on 2018/8/28.
 */
@Controller
@Api(tags = "客户模块-收货地址管理", description = "收货地址管理:UmsMemberReceiveAddressController")
@RequestMapping("/member/address")
public class UmsMemberReceiveAddressController {
    @Autowired
    private UmsMemberReceiveAddressService memberReceiveAddressService;

    @ApiOperation("添加收货地址,成功返回地址ID")
    @ApiResponses({@ApiResponse(code = 201, response = Long.class,
            message="状态200的data格式说明：返回值地址ID")})
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody UmsMemberReceiveAddress address) {
        UmsMemberReceiveAddress addressTemp = memberReceiveAddressService.add(address);
        if(addressTemp != null){
            //成功返回地址ID
            return new CommonResult().success(addressTemp.getId());
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除收货地址")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = memberReceiveAddressService.delete(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("修改收货地址")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,@RequestBody UmsMemberReceiveAddress address) {
        int count = memberReceiveAddressService.update(id,address);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }


    @ApiOperation("显示收货地址详情")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberReceiveAddress.class,
            message="状态200的data格式说明：data返回值为单个对象")})
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getItem(@PathVariable Long id) {
        UmsMemberReceiveAddress address = memberReceiveAddressService.getItem(id);
        return new CommonResult().success(address);
    }

    @ApiOperation("获取客户所有的收货地址")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberReceiveAddress.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(Principal principal) {
        List<UmsMemberReceiveAddress> addressList = memberReceiveAddressService.list(((MemberDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUmsMember().getId());
        return new CommonResult().success(addressList);
    }

    @ApiOperation("获取客户默认的收货地址")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberReceiveAddress.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/get/default", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getDefault(Principal principal) {
        UmsMemberReceiveAddress umsMemberReceiveAddress = memberReceiveAddressService.getDefault(((MemberDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUmsMember().getId());
        return new CommonResult().success(umsMemberReceiveAddress);
    }



}
