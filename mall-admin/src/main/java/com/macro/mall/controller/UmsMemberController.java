package com.macro.mall.controller;

import com.macro.mall.component.ReadMemberExcel;
import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.UmsMemberDTO;
import com.macro.mall.model.UmsMember;
import com.macro.mall.service.UmsMemberService;
import com.macro.mall.vo.UmsMemberVo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 客户管理-会员信息管理Controller
 * Created by ruiwu.xu on 2019/01/02.
 */
@Api(tags = "客户模块-会员信息管理", description = "会员信息管理:UmsMemberController", position = 20)
@Controller
@RequestMapping("/member")
@Slf4j
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @Autowired
    private ReadMemberExcel readMemberExcel;

    @ApiOperation("增加会员(excel)")
    @RequestMapping(value = "/excelUpload", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:excelUpload')")
    public CommonResult excelUpload(@RequestParam("excelFileName") String excelFileName,
                                    @RequestParam("import") @ApiParam(value = "上传的文件", required = true)
                                            MultipartFile file) {
        log.debug("开始excel导入会员={}", excelFileName);
        List<UmsMember> memberList = readMemberExcel.getExcelInfo(excelFileName, file);
        if (memberList == null || memberList.size() == 0 ) {
            return new CommonResult().failed();
        }
        log.debug("memberList={}", memberList.toString());
        int count = umsMemberService.add(memberList);
        if (count > 0) {
            log.debug("excel导入会员成功");
            return new CommonResult().success(null);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("增加会员(批量)")
    @RequestMapping(value = "/batch/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:add')")
    public CommonResult batchAdd(@RequestBody List<UmsMember> listMember) {
        int count = umsMemberService.add(listMember);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("增加会员(单个)")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:add')")
    public CommonResult add(@RequestBody UmsMember member) {
        int count = umsMemberService.add(member);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询会员(分页)")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMember.class,
            message = "状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member')")
    public CommonResult page(@RequestParam(value = "name", required = false, defaultValue = "") String name,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsMemberVo> listUmsMember = umsMemberService.list(name, pageSize, pageNum);
        return new CommonResult().pageSuccess(listUmsMember);
    }

    @ApiOperation("查询会员(by 业务员ID)")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberVo.class,
            message = "状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member')")
    public CommonResult listMemberOfAdmin(@PathVariable(name = "adminId") Long adminId) {
        List<UmsMemberVo> memberVoList = umsMemberService.selectUmsMemberVoByAdminId(adminId);
        return new CommonResult().success(memberVoList);
    }

    @ApiOperation("查询会员(by ID)")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberVo.class,
            message = "状态200的data格式说明：data返回值为单个对象")})
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member')")
    public CommonResult get(@PathVariable(name = "id") Long id) {
        UmsMemberVo memberVo = umsMemberService.selectUmsMemberVoById(id);
        return new CommonResult().success(memberVo);
    }


    @ApiOperation("更新会员(by ID)")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:update')")
    public CommonResult update(@PathVariable(name = "id") Long id,
                                     @RequestBody UmsMemberDTO memberDTO) {
        int count = umsMemberService.update(id, memberDTO);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除会员(by ID)")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:delete')")
    public CommonResult delete(@PathVariable(name = "id") Long id) {
        int count = umsMemberService.delete(id);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
}
