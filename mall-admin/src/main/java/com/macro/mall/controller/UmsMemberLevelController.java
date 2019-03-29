package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.UmsMemberLevel;
import com.macro.mall.service.UmsMemberLevelService;
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
 * 客户管理-会员等级管理Controller
 * @date 2019-01-09 23:49:57
 * @author panqq
 */
@Controller
@Api(tags = "客户管理-会员等级管理",description = "会员等级管理:UmsMemberLevelController",position = 20)
@RequestMapping("/member/level")
public class UmsMemberLevelController {
    @Autowired
    private UmsMemberLevelService memberLevelService;
    @RequestMapping(value = "/list/{defaultStatus}",method = RequestMethod.GET)
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberLevel.class,
            message="状态200的data格式说明：data返回值为列表")})
    @ApiOperation("查询所有会员等级(0 - 默认等级, 1 - 非默认等级)")
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:level')")
    public Object list(@PathVariable("defaultStatus") Integer defaultStatus){
        List<UmsMemberLevel> memberLevelList = memberLevelService.list(defaultStatus);
        return new CommonResult().success(memberLevelList);
    }

    @ApiOperation("查询等级列表(分页/条件)")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberLevel.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:level')")
    public CommonResult page(@RequestParam(value = "name",required = false, defaultValue = "") String name,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<UmsMemberLevel> memberLevels = memberLevelService.page(name,pageSize,pageNum);
        return new CommonResult().pageSuccess(memberLevels);
    }

    @ApiOperation("查询等级信息(ALL)")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberLevel.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:level')")
    public CommonResult allList(){
        List<UmsMemberLevel> memberLevelList = memberLevelService.listAll();
        return new CommonResult().success(memberLevelList);
    }

    @ApiOperation("查询等级信息(by id)")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberLevel.class,
            message="状态200的data格式说明：data返回值为单个对象")})
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:level')")
    public CommonResult get(@PathVariable(name = "id") Long id){
        UmsMemberLevel memberLevel = memberLevelService.selectMemberLevelById(id);
        return new CommonResult().success(memberLevel);
    }

    @ApiOperation("添加等级")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:level:add')")
    public CommonResult add(@RequestBody UmsMemberLevel memberLevel) {
        int count = memberLevelService.create(memberLevel);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("编辑指定的等级信息")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:add')")
    public CommonResult update(@PathVariable(name = "id") Long id, @RequestBody UmsMemberLevel memberLevel){
        Boolean flag = memberLevelService.update(id,memberLevel);
        if(flag){
            return new CommonResult().success(flag);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除指定的等级信息")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:level:delete')")
    public CommonResult delete(@PathVariable(name = "id") Long id){
        int count = memberLevelService.delete(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
}
