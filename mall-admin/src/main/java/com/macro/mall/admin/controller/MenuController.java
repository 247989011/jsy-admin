package com.macro.mall.admin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.macro.mall.common.domain.CommonResult;
import com.macro.mall.common.util.TreeUtil;
import com.macro.mall.admin.dto.MenuTree;
import com.macro.mall.admin.model.SysMenu;
import com.macro.mall.admin.service.SysMenuService;
import com.macro.mall.admin.service.SysUserService;
import com.macro.mall.common.constant.CommonConstant;
import com.macro.mall.common.util.R;
import com.macro.mall.admin.vo.MenuVO;
import com.macro.mall.admin.vo.UserVO;
import com.macro.mall.common.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lengleng
 * @date 2017/10/31
 */
//@RestController
//@RequestMapping("/menu")
@Api(tags = "后台账户权限-菜单管理", description = "菜单管理:MenuController",position = 100)
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysUserService sysUserService;
    /**
     * 通过角色名称查询用户菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    @ApiOperation("通过角色名称查询用户菜单")
    @ApiResponses({@ApiResponse(code = 201, response = MenuVO.class,
            message="状态200的data格式说明：data返回值为列表")})
    @GetMapping("/findMenuByRole/{role}")
    @ResponseBody
    public  CommonResult  findMenuByRole(@PathVariable String role) {
        return  new CommonResult().success(sysMenuService.findMenuByRoleName(role));
    }

    /**
     * 返回当前用户的树形菜单集合
     *
     * @param principal
     * @return 当前用户的树形菜单
     */
    @ApiOperation("返回当前用户的树形菜单集合")
    @ApiResponses({@ApiResponse(code = 201, response = MenuTree.class,
            message="状态200的data格式说明：data返回值为列表")})
    @GetMapping(value = "/userMenu")
    @ResponseBody
    public CommonResult userMenu(Principal principal) {
        String  username = principal.getName();
        UserVO userVO = sysUserService.findUserByUsername(username);

        // 获取符合条件得菜单
        Set<MenuVO> all = new HashSet<>();
        userVO.getRoleList().forEach(role -> all.addAll(sysMenuService.findMenuByRoleName(role.getRoleCode())));

        List<MenuTree> menuTreeList = all.stream().filter(vo -> CommonConstant.MENU
                .equals(vo.getType()))
                .map(MenuTree::new)
                .sorted(Comparator.comparingInt(MenuTree::getSort))
                .collect(Collectors.toList());
        return new CommonResult().success(TreeUtil.bulid(menuTreeList, -1));
    }

    /**
     * 返回树形菜单集合
     *
     * @return 树形菜单
     */
    @ApiOperation("返回树形菜单集合")
    @ApiResponses({@ApiResponse(code = 201, response = MenuTree.class,
            message="状态200的data格式说明：data返回值为列表")})
    @GetMapping(value = "/allTree")
    @ResponseBody
    public CommonResult getTree() {
        SysMenu condition = new SysMenu();
        condition.setDelFlag(CommonConstant.STATUS_NORMAL);
        return  new CommonResult().success(TreeUtil.bulidTree(sysMenuService.selectList(new EntityWrapper<>(condition)), -1));
    }

    /**
     * 返回角色的菜单集合
     *
     * @param roleName 角色名称
     * @return 属性集合
     */
    @ApiOperation("返回角色的菜单集合")
    @ApiResponses({@ApiResponse(code = 201, response = Integer.class,
            message="状态200的data格式说明：data返回值为列表")})
    @GetMapping("/roleTree/{roleName}")
    @ResponseBody
    public CommonResult roleTree(@PathVariable String roleName) {
        List<MenuVO> menus = sysMenuService.findMenuByRoleName(roleName);
        List<Integer> menuList = new ArrayList<>();
        for (MenuVO menuVo : menus) {
            menuList.add(menuVo.getMenuId());
        }
        return new CommonResult().success(menuList);
    }

    /**
     * 通过ID查询菜单的详细信息
     *
     * @param id 菜单ID
     * @return 菜单详细信息
     */
    @ApiOperation("返回角色的菜单集合")
    @ApiResponses({@ApiResponse(code = 201, response = SysMenu.class,
            message="状态200的data格式说明：data返回值为列表")})
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult menu(@PathVariable Integer id) {
        return new CommonResult().success(sysMenuService.selectById(id));
    }

    /**
     * 新增菜单
     *
     * @param sysMenu 菜单信息
     * @return success/false
     */
    @ApiOperation("新增菜单")
    @ApiResponses({@ApiResponse(code = 201, response = R.class,
            message="状态200的data格式说明：data返回值为对象")})
    @PostMapping
    @ResponseBody
    public CommonResult menu(@RequestBody SysMenu sysMenu) {
        return  new CommonResult().success(new R<>(sysMenuService.insert(sysMenu)));
    }

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return success/false
     * TODO  级联删除下级节点
     */
    @ApiOperation("删除菜单")
    @ApiResponses({@ApiResponse(code = 201, response = R.class,
            message="状态200的data格式说明：data返回值为对象")})
    @DeleteMapping("/{id}")
    @ResponseBody
    public CommonResult menuDel(@PathVariable Integer id) {
        return  new CommonResult().success(new R<>(sysMenuService.deleteMenu(id)));
    }

    @ApiOperation("更新菜单")
    @ApiResponses({@ApiResponse(code = 201, response = R.class,
            message="状态200的data格式说明：data返回值为对象")})
    @PutMapping
    @ResponseBody
    public CommonResult menuUpdate(@RequestBody SysMenu sysMenu) {
        return new CommonResult().success(new R<>(sysMenuService.updateMenuById(sysMenu)));
    }
}
