package com.macro.mall.controller;

import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.UmsMemberTraceLogsDto;
import com.macro.mall.model.UmsMemberTraceLogs;
import com.macro.mall.service.UmsMemberLogsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * 会员跟踪日志Controller
 * Created by ruiwu.xu on 2019/01/02.
 */
@Controller
@Api(tags = "客户模块-客户跟踪日志",description = "客户跟踪日志:UmsMemberLogsController",position = 20)
@RequestMapping("/member/log")
public class UmsMemberLogsController {
    @Autowired
    private UmsMemberLogsService  umsMemberLogsService;

    @ApiOperation("增加会员的跟踪日志(多条)")
    @RequestMapping(value = "/batch/add/{memberId}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:log:add')")
    public CommonResult batchAdd(@PathVariable(name = "memberId") Long memberId,
                            @RequestBody List<UmsMemberTraceLogs> listMemberTraceLogs) {
        int count = umsMemberLogsService.add(memberId, listMemberTraceLogs);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("增加会员的跟踪日志(单条)")
    @RequestMapping(value = "/add/{memberId}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:log:add')")
    public CommonResult add(@PathVariable(name = "memberId", required=true) Long memberId,
                            @RequestBody UmsMemberTraceLogs memberTraceLogs) {
        int count = umsMemberLogsService.add(memberId, memberTraceLogs);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("根据id 获取客户跟踪日志信息")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberTraceLogsDto.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/get/{id}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:log:get')")
    public CommonResult get(@PathVariable(name = "id") Long id) {
        UmsMemberTraceLogsDto umsMemberTraceLogsDto = umsMemberLogsService.get(id);
        return new CommonResult().success(umsMemberTraceLogsDto);
    }


    @ApiOperation("分页查询会员的跟踪日志(by memberId)")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberTraceLogsDto.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page/{memberId}",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:log')")
    public CommonResult page(@PathVariable(name = "memberId") Long memberId,
                       @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                       @RequestParam(name = "pageNum", required =  false, defaultValue = "1") Integer pageNum){
        List<UmsMemberTraceLogsDto> umsMemberTraceLogsDtoList = umsMemberLogsService.page(memberId, pageSize, pageNum);
        return new CommonResult().pageSuccess(umsMemberTraceLogsDtoList);
    }


    @ApiOperation("分页查询会员的跟踪日志(by name)")
    @ApiResponses({@ApiResponse(code = 201, response = UmsMemberTraceLogsDto.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:log')")
    public CommonResult page(@RequestParam(name = "name", required = false, defaultValue = "") String name,
                             @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        List<UmsMemberTraceLogsDto> memberTraceLogsDtoList = umsMemberLogsService.page(name, pageSize, pageNum);
        return new CommonResult().pageSuccess(memberTraceLogsDtoList);
    }

    @ApiOperation("编辑会员的跟踪日志")
    @RequestMapping(value = "/update/{traceLogsId}", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:log:update')")
    public CommonResult update(@PathVariable(name = "traceLogsId") Long traceLogsId,
                               @RequestBody UmsMemberTraceLogs memberTraceLogs, Principal principal) {

        //组装参数
        List<UmsMemberTraceLogs>  memberTraceLogsList = new ArrayList<UmsMemberTraceLogs>();
        memberTraceLogsList.add(memberTraceLogs);

        //更新客户跟踪日志
        Long tmepLong = 0l;
        int count = umsMemberLogsService.update(tmepLong, memberTraceLogsList);
        if(count>=0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("删除会员的跟踪日志")
    @RequestMapping(value = "/delete/{traceLogsId}", method = RequestMethod.DELETE)
    @ResponseBody
    //@PreAuthorize("hasAuthority('ums:member:log:delete')")
    public CommonResult batchDelete(@PathVariable("traceLogsId") Long traceLogsId) {
        //组装参数
        List<Long> traceLogsIdList = new ArrayList<Long>();
        traceLogsIdList.add(traceLogsId);

        //删除客户的跟踪日志
        int count = umsMemberLogsService.delete(traceLogsIdList);
        if(count>=0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
}
}
