package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.LmsLogisticsModeMapper;
import com.macro.mall.model.LmsLogisticsMode;
import com.macro.mall.model.LmsLogisticsModeExample;
import com.macro.mall.service.LmsLogisticsModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单管理Service实现类
 * Created by macro on 2018/10/11.
 */
@Service
public class LmsLogisticsModelServiceImpl implements LmsLogisticsModeService {
    @Autowired
    private LmsLogisticsModeMapper lmsLogisticsModeMapper;


    /**
     * 获取符合条件的物流方式
     *
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<LmsLogisticsMode> page(String logisticsModeName, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        logisticsModeName = "%" + logisticsModeName +"%";
        LmsLogisticsModeExample example = new LmsLogisticsModeExample();
        LmsLogisticsModeExample.Criteria criteria = example.createCriteria();
        criteria.andLogisticsModeNameLike(logisticsModeName);
        criteria.andLogisticsModeStatusEqualTo(LOGISTICS_MODE_STATUS_INUSE_00);
        return lmsLogisticsModeMapper.selectByExample(example);
    }

    /**
     * 增加物流方式
     *
     * @param lmsLogisticsMode
     */
    @Override
    public int add(LmsLogisticsMode lmsLogisticsMode) {
        return lmsLogisticsModeMapper.insert(lmsLogisticsMode);
    }

    /**
     * 更新物流方式
     *
     * @param lmsLogisticsMode
     */
    @Override
    public int update(LmsLogisticsMode lmsLogisticsMode) {

        return lmsLogisticsModeMapper.updateByPrimaryKey(lmsLogisticsMode);
    }

    /**
     * 更新物流方式状态: 00 - 在用 01 - 弃用
     *
     * @param id
     * @param logisticsModeStatus
     */
    @Override
    public int updateStatus(Long id, String logisticsModeStatus) {
        LmsLogisticsMode lmsLogisticsMode = new LmsLogisticsMode();
        lmsLogisticsMode.setId(id);
        lmsLogisticsMode.setLogisticsModeStatus(logisticsModeStatus);
        return lmsLogisticsModeMapper.updateByPrimaryKey(lmsLogisticsMode);
    }

    /**
     * 更新物流方式状态: 00 - 在用 01 - 弃用
     * @param id
     */
    @Override
    public int logicDelete(Long id) {
        LmsLogisticsMode lmsLogisticsMode = new LmsLogisticsMode();
        lmsLogisticsMode.setId(id);
        lmsLogisticsMode.setLogisticsModeStatus(LOGISTICS_MODE_STATUS_DISUSE_01);
        return lmsLogisticsModeMapper.updateByPrimaryKey(lmsLogisticsMode);
    }

    @Override
    public int delete(Long id) {
        return lmsLogisticsModeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public LmsLogisticsMode selectModeById(Long id) {
        return lmsLogisticsModeMapper.selectByPrimaryKey(id);
    }
}
