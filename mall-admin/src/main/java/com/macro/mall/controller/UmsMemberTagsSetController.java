package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.UmsMemberTagsDTO;
import com.macro.mall.model.UmsMemberTags;
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
 * 会员标签设置管理Controller
 * Created by ruiwu.xu on 2019/01/02.
 */
@Controller
@Api(tags = "客户模块-客户标签设置管理",description = "客户标签设置管理:UmsMemberTagsSetController",position = 20)
@RequestMapping("/member/tagsSet")
public class UmsMemberTagsSetController {

    @Autowired
    private UmsTagsService umsTagsService;

    @ApiOperation("增加会员分类标签(批量)")
    @RequestMapping(value = "/set/{memberId}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:tagsSet:set')")
    public CommonResult setMemberTags(@PathVariable(name = "memberId") Long memberId,
                                @RequestBody List<UmsMemberTags> listMemberTags) {
        int count = umsTagsService.addMemberTagsList(memberId, listMemberTags);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除会员分类标签(批量)")
    @RequestMapping(value = "/delete/{memberId}", method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:tagsSet:delete')")
    public CommonResult deleteMemberTags(@PathVariable(name = "memberId") Long memberId,
                                      @RequestBody List<Long> tagIds) {
        int count = umsTagsService.deleteMemberTagsList(memberId, tagIds);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("查询会员标签(ALL)")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberTagsDTO.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/list/{memberId}",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:tagsSet')")
    public CommonResult listMemberTags(@PathVariable(name = "memberId") Long memberId){
        UmsMemberTagsDTO umsMemberTagsDTO = umsTagsService.listMemberTags(memberId);
        return new CommonResult().success(umsMemberTagsDTO);
    }
}
