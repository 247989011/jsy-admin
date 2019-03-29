package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.LmsLogisticsAreaDefineMapper;
import com.macro.mall.model.LmsLogisticsAreaDefine;
import com.macro.mall.model.LmsLogisticsAreaDefineExample;
import com.macro.mall.service.LmsLogisticsAreaDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单管理Service实现类
 * Created by macro on 2018/10/11.
 */
@Service
public class LmsLogisticsAreaDefineServiceImpl implements LmsLogisticsAreaDefineService {
    @Autowired
    private LmsLogisticsAreaDefineMapper lmsLogisticsAreaDefineMapper;

    /**
     * 查询物流地区
     *
     * @param keyName
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<LmsLogisticsAreaDefine> list(String keyName, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        String keyNameCondi = "%" + keyName + "%";
        LmsLogisticsAreaDefineExample example = new LmsLogisticsAreaDefineExample();
        LmsLogisticsAreaDefineExample.Criteria criteria = example.createCriteria();
        //中文名
        criteria.andAreaNameCnLike(keyNameCondi);
        //英文名
        example.or(example.createCriteria().andAreaNameEnLike(keyNameCondi));
        //类型
        example.or(example.createCriteria().andAreaTypeLike(keyNameCondi));

        return lmsLogisticsAreaDefineMapper.selectByExample(example);
    }

    /**
     * 增加物流地区
     *
     * @param lmsLogisticsAreaDefine
     */
    @Override
    public int add(LmsLogisticsAreaDefine lmsLogisticsAreaDefine) {
        return lmsLogisticsAreaDefineMapper.insert(lmsLogisticsAreaDefine);
    }

    /**
     * 更新物流地区
     *
     * @param lmsLogisticsAreaDefine
     */
    @Override
    public int update(LmsLogisticsAreaDefine lmsLogisticsAreaDefine) {
        return lmsLogisticsAreaDefineMapper.updateByPrimaryKey(lmsLogisticsAreaDefine);
    }

    /**
     * 删除物流地区
     *
     * @param id
     */
    @Override
    public int delete(Long id) {
        return lmsLogisticsAreaDefineMapper.deleteByPrimaryKey(id);
    }

    @Override
    public LmsLogisticsAreaDefine getItem(Long id) {
        return lmsLogisticsAreaDefineMapper.selectByPrimaryKey(id);
    }
}
