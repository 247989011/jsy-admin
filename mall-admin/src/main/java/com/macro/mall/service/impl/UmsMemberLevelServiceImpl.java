package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.UmsMemberLevelMapper;
import com.macro.mall.model.UmsMemberLevel;
import com.macro.mall.model.UmsMemberLevelExample;
import com.macro.mall.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 会员等级管理Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService{
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }


    @Override
    public List<UmsMemberLevel> page(String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        UmsMemberLevelExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
            //example.or(example.createCriteria().andNickNameLike("%" + name + "%"));
        }
        example.setOrderByClause("name asc");
        return memberLevelMapper.selectByExample(example);
    }

    @Override
    public List<UmsMemberLevel> listAll() {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        return memberLevelMapper.selectByExample(example);
    }

    @Override
    public UmsMemberLevel selectMemberLevelById(Long id) {
        return memberLevelMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Long id, UmsMemberLevel memberLevel) {
        int i = memberLevelMapper.updateByPrimaryKeySelective(memberLevel);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int delete(Long id) {
        return memberLevelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int create(UmsMemberLevel memberLevel) {
        return memberLevelMapper.insertSelective(memberLevel);
    }
}
