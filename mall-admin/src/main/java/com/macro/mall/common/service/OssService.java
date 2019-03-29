package com.macro.mall.common.service;

import com.macro.mall.common.dto.OssCallbackResult;
import com.macro.mall.common.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss上传管理Service
 * Created by macro on 2018/5/17.
 */
public interface OssService {
    OssPolicyResult policy();
    OssCallbackResult callback(HttpServletRequest request);
}
