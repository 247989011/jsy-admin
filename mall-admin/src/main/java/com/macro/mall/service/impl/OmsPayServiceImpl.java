package com.macro.mall.service.impl;

import com.macro.mall.dto.PaymsPayTemplateModeRelationDto;
import com.macro.mall.mapper.PaymsPayModeMapper;
import com.macro.mall.mapper.PaymsPayTemplateMapper;
import com.macro.mall.mapper.PaymsPayTemplateModeRelationMapper;
import com.macro.mall.model.*;
import com.macro.mall.service.OmsPayService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单支付Service实现类
 * Created by macro on 2018/10/11.
 */
@Service
public class OmsPayServiceImpl implements OmsPayService {
    @Autowired
    private PaymsPayModeMapper pymsPayModeMapper;
    @Autowired
    private PaymsPayTemplateModeRelationMapper paymsPayTemplateModeRelationMapper;
    @Autowired
    private PaymsPayTemplateMapper paymsPayTemplateMapper;

    @Override
    public int addPayTeamplate(PaymsPayTemplate payTemplate) {
        return paymsPayTemplateMapper.insert(payTemplate);
    }

    @Override
    public List<PaymsPayTemplate> listPayTeamplateAll() {
        return paymsPayTemplateMapper.selectByExample(null);
    }

    @Override
    public int addPayMode(PaymsPayMode paymsPayMode) {
        return  pymsPayModeMapper.insert(paymsPayMode);
    }

    @Override
    public List<PaymsPayMode> listPayModeAll() {
        return pymsPayModeMapper.selectByExample(null);
    }

    @Override
    public int addPayModeOfPayTemplate(Long templateId, List<PaymsPayMode> paymsPayModeList) {
        for (PaymsPayMode e : paymsPayModeList) {
            PaymsPayTemplateModeRelation paymsPayTemplateModeRelation = new PaymsPayTemplateModeRelation();
            paymsPayTemplateModeRelation.setTemplateId(templateId);
            paymsPayTemplateModeRelation.setModeId(e.getId());
            paymsPayTemplateModeRelation.setLastCreateId("admin");
            paymsPayTemplateModeRelation.setLastCreateTime(new Date());
            paymsPayTemplateModeRelation.setLastUpdateId("admin");
            paymsPayTemplateModeRelation.setLastUpdateTime(new Date());
            if(paymsPayTemplateModeRelationMapper.insert(paymsPayTemplateModeRelation)<0){
                return -1;
            }
        }
        return 0;
    }

    @Override
    public List<PaymsPayTemplateModeRelationDto> listPayModeOfPayTeamplate(Long templateId) {
        //获取支付模板关联的支付模式ID
        PaymsPayTemplateModeRelationExample example = new PaymsPayTemplateModeRelationExample();
        example.createCriteria().andTemplateIdEqualTo(templateId);
        List<PaymsPayTemplateModeRelation> paymsPayTemplateModeRelationList = paymsPayTemplateModeRelationMapper.selectByExample(example);
        PaymsPayModeExample paymsPayModeExample = new PaymsPayModeExample();
        for (PaymsPayTemplateModeRelation e : paymsPayTemplateModeRelationList) {
            paymsPayModeExample.or(paymsPayModeExample.createCriteria().andIdEqualTo(e.getModeId()));
        }
        List<PaymsPayMode>  paymsPayModeList = pymsPayModeMapper.selectByExample(paymsPayModeExample);

        //查询支付模板关联的支付模式
        List<PaymsPayTemplateModeRelationDto> paymsPayModeTemplateDtoList = new ArrayList<PaymsPayTemplateModeRelationDto>();
        for (PaymsPayMode e : paymsPayModeList) {
            PaymsPayTemplateModeRelationDto paymsPayModeTemplateDto = new PaymsPayTemplateModeRelationDto();
            paymsPayModeTemplateDto.setTemplateId(templateId);
            BeanUtils.copyProperties(e, paymsPayModeTemplateDto);
            paymsPayModeTemplateDtoList.add(paymsPayModeTemplateDto);
        }

        //返回查询结果
        return paymsPayModeTemplateDtoList;
    }


    @Override
    public int updatePayTeamplate(PaymsPayTemplate payTemplate) {
        return paymsPayTemplateMapper.updateByPrimaryKey(payTemplate);
    }

    @Override
    public int deletePayTeamplate(Long id) {
        return paymsPayTemplateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deletePayModeOfPayTemplate(Long templateId, List<Long> ids) {
        for (Long id : ids) {
           if(paymsPayTemplateModeRelationMapper.deleteByPrimaryKey(id) < 0){
               return -1;
           }
        }
        return 0;
    }

    @Override
    public int updatePayMode(PaymsPayMode paymsPayMode) {
        return pymsPayModeMapper.updateByPrimaryKey(paymsPayMode);
    }

    @Override
    public int deletePayMode(Long id) {
        return pymsPayModeMapper.deleteByPrimaryKey(id);
    }
}
