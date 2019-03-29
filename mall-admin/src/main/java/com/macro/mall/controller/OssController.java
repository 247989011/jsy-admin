package com.macro.mall.controller;


import com.macro.mall.domain.CommonResult;
import com.macro.mall.dto.OssCallbackResult;
import com.macro.mall.dto.OssPolicyResult;
import com.macro.mall.service.impl.OssServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Oss相关操作接口
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "存储模块-Oss管理",description = "Oss管理:OssController",position = 100)
@RequestMapping("/aliyun/oss")
public class OssController {
	@Autowired
	private OssServiceImpl ossService;

	@ApiOperation(value = "oss上传签名生成")
	@RequestMapping(value = "/policy",method = RequestMethod.GET)
	@ResponseBody
	//@PreAuthorize("hasAuthority('oss:aliyun:oss:policy')")
	public CommonResult policy() {
		OssPolicyResult result = ossService.policy();
		return new CommonResult().success(result);
	}

	@ApiOperation(value = "oss上传成功回调")
	@RequestMapping(value = "callback",method = RequestMethod.POST)
	@ResponseBody
	//@PreAuthorize("hasAuthority('oss:aliyun:oss:callback')")
	public CommonResult callback(HttpServletRequest request) {
		OssCallbackResult ossCallbackResult = ossService.callback(request);
		return new CommonResult().success(ossCallbackResult);
	}

}
