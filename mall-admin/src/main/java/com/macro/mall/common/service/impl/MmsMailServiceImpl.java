package com.macro.mall.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.common.mapper.MmsMailSendLogMapper;
import com.macro.mall.common.model.MmsMailSendLog;
import com.macro.mall.common.service.MmsMailService;
import org.springframework.stereotype.Service;

/**
 * 邮件Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class MmsMailServiceImpl extends ServiceImpl<MmsMailSendLogMapper,MmsMailSendLog> implements MmsMailService {

}
