package com.macro.mall.portal.service;

import com.macro.mall.portal.dto.OssCallbackResult;
import com.macro.mall.portal.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss上传管理Service
 * Created by macro on 2018/5/17.
 */
public interface OssService {
    OssPolicyResult policy();
    OssCallbackResult callback(HttpServletRequest request);
}
