package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.model.UmsPermission;
import com.macro.mall.model.UmsRole;
import com.macro.mall.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * 后台用户角色管理
 * Created by macro on 2018/9/30.
 */
@Api(tags = "后台账户权限-后台用户角色管理(已弃用)", description = "后台用户角色管理:UmsRoleController",position = 4)
@ApiIgnore
@Controller
@RequestMapping("/ums/role")
@Deprecated
public class UmsRoleController {
    @Autowired
    private UmsRoleService roleService;

    @ApiOperation("获取角色")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult get(@PathVariable Long id) {
        UmsRole role = roleService.get(id);
        return new CommonResult().success(role);
    }

    @ApiOperation("添加角色")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsRole role) {
        int count = roleService.create(role);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("修改角色")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody UmsRole role) {
        int count = roleService.update(id,role);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("批量删除角色")
    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = roleService.batchDelete(ids);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
    @ApiOperation("删除角色")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = roleService.delete(id);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
    @ApiOperation("获取相应角色权限")
    @RequestMapping(value = "/permission/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getPermissionList(@PathVariable Long roleId) {
        List<UmsPermission> permissionList =roleService.getPermissionList(roleId);
        return new CommonResult().success(permissionList);
    }

    @ApiOperation("修改角色权限")
    @RequestMapping(value = "/permission/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePermission(@RequestParam Long roleId,
                                   @RequestParam("permissionIds") List<Long> permissionIds) {
        int count = roleService.updatePermission(roleId,permissionIds);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult list(){
        List<UmsRole> roleList = roleService.list();
        return new CommonResult().pageSuccess(roleList);
    }
    /**
     * 返回角色关联的菜单id集合
     *
     * @param roleId 角色id
     * @return 属性集合
     */
    @ApiOperation("角色关联的菜单id集合")
    @RequestMapping(value = "/menus/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult roleMenuIds(@PathVariable("id") Long roleId) {
        List<UmsPermission> menus = roleService.findMenuByRoleId(roleId);
        List<Long> menuList = new ArrayList<Long>();
        for (UmsPermission menuVo : menus) {
            menuList.add(menuVo.getId());
        }
        return new CommonResult().success(menuList);
    }
}
