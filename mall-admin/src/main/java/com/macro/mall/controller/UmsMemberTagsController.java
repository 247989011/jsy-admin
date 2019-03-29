package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.UmsTags;
import com.macro.mall.service.UmsTagsService;
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
 * 会员标签管理Controller
 * Created by ruiwu.xu on 2019/01/02.
 */
@Api(tags = "客户模块-客户标签库管理",description = "客户标签库管理:UmsMemberTagsController",position = 20)
@Controller
@RequestMapping("/member/tags")
public class UmsMemberTagsController {

    @Autowired
    private UmsTagsService umsTagsService;

    @ApiOperation("添加分类标签")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:tags:add')")
    public CommonResult add(@RequestBody UmsTags umsTags) {
        int count = umsTagsService.add(umsTags);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("编辑分类标签")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:tags:update')")
    public CommonResult update(@PathVariable(name = "id", required = true) Long id, @RequestBody UmsTags umsTags) {
        int count = umsTagsService.update(id, umsTags);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除分类标签")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:tags:delete')")
    public CommonResult delete(@PathVariable(name = "id") Long id){
        int count = umsTagsService.delete(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询分类标签(by标签名)")
    @ApiResponses({@ApiResponse(code = 201, response = UmsTags.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:tags')")
    public CommonResult page(@RequestParam(name = "name", required = false, defaultValue = "") String name,
                             @RequestParam(name="pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        List<UmsTags> umsTagsList = umsTagsService.page(name, pageNum, pageSize);
        return new CommonResult().pageSuccess(umsTagsList);
    }

    @ApiOperation("查询分类标签(ALL)")
    @ApiResponses({@ApiResponse(code = 201, response = UmsTags.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:tags')")
    public CommonResult allList(){
        List<UmsTags> umsTagsList = umsTagsService.list();
        return new CommonResult().success(umsTagsList);
    }

    @ApiOperation("查询分类标签(by id)")
    @ApiResponses({@ApiResponse(code = 201, response = UmsTags.class,
            message="状态200的data格式说明：data返回值为单个对象")})
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:tags')")
    public CommonResult get(@PathVariable("id") Long id){
        UmsTags umsTags = umsTagsService.selectById(id);
        return new CommonResult().success(umsTags);
    }
}
