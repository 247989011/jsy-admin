package com.macro.mall.service.impl;

import com.macro.mall.mapper.UmsMemberMapper;
import com.macro.mall.model.UmsMember;
import com.macro.mall.model.UmsMemberExample;
import com.macro.mall.service.OmsOrderLogisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单模块-订单物流Service实现类
 */
@Service
@Slf4j
public class OmsOrderLogisticsServiceImpl implements OmsOrderLogisticsService {
    @Autowired
    private UmsMemberMapper memberMapper;
    @Override
    public List<UmsMember> listDeliveryStaff() {
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andIsDeliveryStaffEqualTo("1");
        return memberMapper.selectByExample(example);
    }
}
