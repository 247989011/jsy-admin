package com.macro.mall.admin.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import com.macro.mall.admin.dto.UmsAdminLoginParam;
import com.macro.mall.admin.dto.UserDTO;
import com.macro.mall.admin.dto.UserInfo;
import com.macro.mall.admin.model.SysUser;
import com.macro.mall.admin.model.SysUserRole;
import com.macro.mall.admin.service.SysUserRoleService;
import com.macro.mall.admin.service.SysUserService;
import com.macro.mall.admin.vo.UserVO;
import com.macro.mall.common.constant.CommonConstant;
import com.macro.mall.common.controller.BaseController;
import com.macro.mall.common.domain.CommonResult;
import com.xiaoleilu.hutool.io.FileUtil;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "后台账户权限-后台账户管理",description = "后台账户管理:UserController",position = 100)
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController extends BaseController {
   // private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();
   @Autowired
   private PasswordEncoder passwordEncoder;

    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysUserRoleService userRoleService;
    //    @Autowired
//    private FdfsPropertiesConfig fdfsPropertiesConfig;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "登录以后返回token")
    @ApiResponses({@ApiResponse(code = 201, response = Map.class,
            message="状态200的data格式说明：data返回值为MAP")})
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        return userService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return new CommonResult().success(null);
    }

    @ApiOperation(value = "刷新token")
    @ApiResponses({@ApiResponse(code = 201, response = Map.class,
            message="状态200的data格式说明：data返回值为MAP")})
    @RequestMapping(value = "/token/refresh", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        //TODO 如何操作？？？
        String refreshToken = userService.refreshToken(token);
        if (refreshToken == null) {
            return new CommonResult().failed();
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return new CommonResult().success(tokenMap);
    }

    /**
     * 获取当前用户信息（角色、权限）
     * 并且异步初始化用户部门信息
     *
     * @param principal 当前用户信息
     *
     * @return 用户名
     */
    @ApiOperation(value = "获取当前用户信息(角色、权限)")
    @ApiResponses({@ApiResponse(code = 201, response = UserInfo.class,
            message="状态200的data格式说明：data返回值为对象")})
    @GetMapping("/info")
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('info')")
    public CommonResult user(Principal principal) {
        String  username = principal.getName();
        UserInfo userInfo = userService.findUserInfo(username);
        if(userInfo == null){
            return new CommonResult().failed();
        }
        return new CommonResult().success(userInfo);
    }

    /**
     * 通过ID查询当前用户信息
     *
     * @param id ID
     *
     * @return 用户信息
     */
    @ApiOperation(value = "通过ID查询当前用户信息")
    @ApiResponses({@ApiResponse(code = 201, response = UserVO.class,
            message="状态200的data格式说明：data返回值为对象")})
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult user(@PathVariable Integer id) {
        UserVO  userVo= userService.selectUserVoById(id);
        if (userVo == null){
            return new CommonResult().failed();
        }
        return new CommonResult().success(userVo);
    }

    /**
     * 删除用户信息
     *
     * @param id ID
     *
     * @return R
     */
    @ApiOperation(value = "删除用户", notes = "根据ID删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType = "path")
    @DeleteMapping("/{id}")
    @ResponseBody
    public CommonResult userDel(@PathVariable Integer id) {
        SysUser sysUser = userService.getById(id);
        Boolean b = userService.deleteUserById(sysUser);
        if(b.booleanValue() == false){
            return new CommonResult().failed();
        }
        return new CommonResult().success(b);
    }

    /**
     * 添加用户
     *
     * @param userDto 用户信息
     *
     * @return success/false
     */
    @ApiOperation(value = "添加用户")
    @PostMapping
    @ResponseBody
    //@PreAuthorize("hasAuthority('admin:user')")
    public CommonResult user(@RequestBody UserDTO userDto) {
        log.debug("userDto ={} ", userDto.toString());
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDto, sysUser);
        log.debug("sysUser = {}", sysUser.toString());
        sysUser.setDelFlag(CommonConstant.STATUS_NORMAL);
        //将密码进行加密操作
        log.debug("加密前的密码 = {}", sysUser.getPassword());
       // String md5Password = passwordEncoder.encodePassword(sysUser.getPassword(), null);
        String md5Password = passwordEncoder.encode(sysUser.getPassword());
        log.debug("加密后的密码 = {}", md5Password);
        sysUser.setPassword(md5Password);
        userService.save(sysUser);

        for (Integer roleId : userDto.getRole()) {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(sysUser.getUserId());
            userRole.setRoleId(roleId);
            userRoleService.save(userRole);
        }

//        userDto.getRole().forEach(roleId -> {
//            SysUserRole userRole = new SysUserRole();
//            userRole.setUserId(sysUser.getUserId());
//            userRole.setRoleId(roleId);
//            userRole.insert();
//        });

        return new CommonResult().success(null);
    }

    /**
     * 更新用户信息
     *
     * @param userDto 用户信息
     *
     * @return R
     */
    @ApiOperation(value = "更新用户信息")
    @PutMapping
    @ResponseBody
    public CommonResult userUpdate(@RequestBody UserDTO userDto) {
        Boolean b = userService.updateUser(userDto);
        if(b.booleanValue() == false){
            return  new CommonResult().failed();
        }
        return  new CommonResult().success(b);
    }

    /**
     * 通过用户名查询用户及其角色信息
     *
     * @param username 用户名
     *
     * @return UseVo 对象
     */
    @ApiOperation(value = "通过用户名查询用户及其角色信息")
    @ApiResponses({@ApiResponse(code = 201, response = UserVO.class,
            message="状态200的data格式说明：data返回值为对象")})
    @GetMapping("/findUserByUsername/{username}")
    @ResponseBody
    public CommonResult findUserByUsername(@PathVariable String username) {
        UserVO userVO = userService.findUserByUsername(username);
        return new CommonResult().success(userVO);
    }

    /**
     * 通过手机号查询用户及其角色信息
     *
     * @param mobile 手机号
     *
     * @return UseVo 对象
     */
    @ApiOperation(value = "通过用户名查询用户及其角色信息")
    @ApiResponses({@ApiResponse(code = 201, response = UserVO.class,
            message="状态200的data格式说明：data返回值为对象")})
    @GetMapping("/findUserByMobile/{mobile}")
    @ResponseBody
    public CommonResult findUserByMobile(@PathVariable String mobile) {
        return new CommonResult().success(userService.findUserByMobile(mobile));
    }

    /**
     * 通过OpenId查询
     *
     * @param openId openid
     *
     * @return 对象
     */
    @ApiOperation(value = "通过OpenId查询")
    @ApiResponses({@ApiResponse(code = 201, response = UserVO.class,
            message="状态200的data格式说明：data返回值为对象")})
    @GetMapping("/findUserByOpenId/{openId}")
    @ResponseBody
    public CommonResult findUserByOpenId(@PathVariable String openId) {
        return new  CommonResult().success(userService.findUserByOpenId(openId));
    }

    /**
     * 分页查询用户
     *
     * @param page 参数集
     * @param userDTO 用户信息
     *
     * @return 用户集合
     */
    @ApiOperation(value = "分页查询用户")
    @ApiResponses({@ApiResponse(code = 201, response = Page.class,
            message="状态200的data格式说明：data返回值为对象")})
    @RequestMapping("/userPage")
    @ResponseBody
    public CommonResult userPage(Page page, UserDTO userDTO) {
        return  new CommonResult().success(userService.getUserWithRolePage(page, userDTO));
    }


    /**
     * 查询所有的用户信息
     * @return 用户集合
     */
    @ApiOperation(value = "查询所有的后台用户信息")
    @ApiResponses({@ApiResponse(code = 201, response = UserVO.class,
            message="状态200的data格式说明：data返回值为对象")})
    @RequestMapping("/list")
    @ResponseBody
    public CommonResult list() {
        List<UserVO> userVOList = userService.listAllUser();
        return new CommonResult().success(userVOList);
    }

    /**
     * 上传用户头像 TODO
     * (多机部署有问题，建议使用独立的文件服务器)
     *
     * @param file 资源
     * @return filename map
     */
    @ApiOperation(value = "上传用户头像")
    @ApiResponses({@ApiResponse(code = 201, response = Map.class,
            message="状态200的data格式说明：data返回值为对象")})
    @PostMapping("/upload")
    public CommonResult upload(@RequestParam("file") MultipartFile file) {
        String fileExt = FileUtil.extName(file.getOriginalFilename());
        Map<String, String> resultMap = new HashMap<>(1);
        try {
            //TODO  建议存储在OSS上
            StorePath storePath = fastFileStorageClient.uploadFile(file.getBytes(), fileExt);
            //resultMap.put("filename", fdfsPropertiesConfig.getFileHost() + storePath.getFullPath());
        } catch (IOException e) {
            logger.error("文件上传异常", e);
            throw new RuntimeException(e);
        }
        return new CommonResult().success(resultMap);
    }

    /**
     * 修改个人信息
     *
     * @param userDto userDto
     * @param principal  登录用户信息
     *
     * @return success/false
     */
    @ApiOperation(value = "修改个人信息")
    @ApiResponses({@ApiResponse(code = 201, response = R.class,
            message="状态200的data格式说明：data返回值为对象")})
    @PutMapping("/editInfo")
    @ResponseBody
    public CommonResult  editInfo(@RequestBody UserDTO userDto,Principal principal) {
        String  username = principal.getName();
        UserVO userVO = userService.findUserByUsername(username);
        return new CommonResult().success(userService.updateUserInfo(userDto, userVO));
    }
}
