package com.macro.mall.common.service;

import com.macro.mall.common.model.MmsMailSendLog;

import java.util.List;

/**
 * 邮件管理Service
 * Created by ruiwu.xu on 2019/01/30.
 */
public interface MmsMailService {
    List<MmsMailSendLog> page(String name, Integer pageNum, Integer pageSize);
}
