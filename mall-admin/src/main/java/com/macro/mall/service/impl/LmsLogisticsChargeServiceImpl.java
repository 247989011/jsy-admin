package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dto.LmsLogisticsQueryParamDto;
import com.macro.mall.mapper.LmsLogisticsChargeMapper;
import com.macro.mall.model.LmsLogisticsCharge;
import com.macro.mall.model.LmsLogisticsChargeExample;
import com.macro.mall.service.LmsLogisticsChargeService;
import com.macro.mall.vo.LmsLogisticsChargeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单管理Service实现类
 * Created by macro on 2018/10/11.
 */
@Service
public class LmsLogisticsChargeServiceImpl implements LmsLogisticsChargeService {

    @Autowired
    LmsLogisticsChargeMapper lmsLogisticsChargeMapper;

    /**
     * 添加物流费用配置
     *
     * @param logisticsCharge
     */
    @Override
    public int add(LmsLogisticsCharge logisticsCharge) {
        return lmsLogisticsChargeMapper.insert(logisticsCharge);
    }

    /**
     * 修改物流费用配置
     *
     * @param id
     * @param logisticsCharge
     */
    @Override
    public int update(Long id, LmsLogisticsCharge logisticsCharge) {
        return lmsLogisticsChargeMapper.updateByPrimaryKey(logisticsCharge);
    }

    /**
     * 修改物流费用
     * @param id
     */
    @Override
    public int delete(Long id){
        return lmsLogisticsChargeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 获取物流费用配置详情
     *
     * @param id
     */
    @Override
    public LmsLogisticsCharge getItem(Long id) {
        return lmsLogisticsChargeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<LmsLogisticsChargeVo> page(LmsLogisticsQueryParamDto logisticsQueryParamDto,
                                           Integer pageSize, Integer pageNum) {
        //设置分页
        PageHelper.startPage(pageNum, pageSize);
        //TODO 简单做, 需调整
        List<LmsLogisticsChargeVo>  logisticsChargeVoList = new ArrayList<LmsLogisticsChargeVo>();
        LmsLogisticsChargeExample example = new LmsLogisticsChargeExample();
        List<LmsLogisticsCharge> logisticsChargeList  = lmsLogisticsChargeMapper.selectByExample(example);
        for (LmsLogisticsCharge logisticsCharge : logisticsChargeList) {
            LmsLogisticsChargeVo logisticsChargeVo = new LmsLogisticsChargeVo();
            BeanUtils.copyProperties(logisticsCharge, logisticsChargeVo);
            logisticsChargeVoList.add(logisticsChargeVo);
        }
        return logisticsChargeVoList;
    }
}
