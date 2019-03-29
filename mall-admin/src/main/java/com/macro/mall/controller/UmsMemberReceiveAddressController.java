package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.UmsMemberReceiveAddress;
import com.macro.mall.service.UmsMemberReceiveAddressService;
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
 * 会员收货地址管理Controller
 * Created by macro on 2018/8/28.
 */
@Controller
@Api(tags = "客户模块-客户收货地址管理", description = "客户收货地址管理:UmsMemberReceiveAddressController")
@Slf4j
@RequestMapping("/member/address")
public class UmsMemberReceiveAddressController {
    @Autowired
    private UmsMemberReceiveAddressService memberReceiveAddressService;
    @ApiOperation("添加收货地址")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:address:add')")
    public CommonResult add(@RequestBody UmsMemberReceiveAddress address) {
        int count = memberReceiveAddressService.add(address);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除收货地址")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:address:delete')")
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
    //@PreAuthorize("hasAuthority('ums:member:address:update')")
    public CommonResult update(@PathVariable Long id,@RequestBody UmsMemberReceiveAddress address) {
        int count = memberReceiveAddressService.update(id,address);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("分页查询系统所有收货地址")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberReceiveAddress.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:address')")
    public CommonResult page(@RequestParam(value = "name", required = false,defaultValue = "") String name,
                             @RequestParam(name="pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsMemberReceiveAddress> addressList = memberReceiveAddressService.page(name, pageSize, pageNum);
        return new CommonResult().pageSuccess(addressList);
    }

    @ApiOperation("显示客户所有的收货地址")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberReceiveAddress.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list/{memberId}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:address')")
    public CommonResult list(@PathVariable("memberId") Long memberId) {
        List<UmsMemberReceiveAddress> addressList = memberReceiveAddressService.list(memberId);
        return new CommonResult().success(addressList);
    }

    @ApiOperation("显示收货地址详情")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberReceiveAddress.class,
            message="状态200的data格式说明：data返回值为单个对象")})
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:address')")
    public CommonResult getItem(@PathVariable Long id) {
        UmsMemberReceiveAddress address = memberReceiveAddressService.getItem(id);
        return new CommonResult().success(address);
    }
}
