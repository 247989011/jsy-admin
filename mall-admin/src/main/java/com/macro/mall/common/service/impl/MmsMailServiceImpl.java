package com.macro.mall.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.common.mapper.MmsMailSendLogMapper;
import com.macro.mall.common.model.MmsMailSendLog;
import com.macro.mall.common.model.MmsMailSendLogExample;
import com.macro.mall.common.service.MmsMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 邮件Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class MmsMailServiceImpl implements MmsMailService {
    @Autowired
    private MmsMailSendLogMapper mmsMailSendLogMapper;

    @Override
    public List<MmsMailSendLog> page(String name, Integer pageNum, Integer pageSize) {
        //设置分页查询
        PageHelper.startPage(pageNum, pageSize);

        //处理关键字
        StringBuffer nameHandle = new StringBuffer();
        nameHandle.append("%").append(name).append("%");

        //查询符合条件的关键字
        MmsMailSendLogExample example = new MmsMailSendLogExample();
        MmsMailSendLogExample.Criteria criteria1 = example.createCriteria();
        MmsMailSendLogExample.Criteria criteria2 = example.createCriteria();
        criteria1.andFromAddrLike(nameHandle.toString());
        example.or(criteria2.andToAddrLike(nameHandle.toString()));

        return  mmsMailSendLogMapper.selectByExample(example);
    }
}
