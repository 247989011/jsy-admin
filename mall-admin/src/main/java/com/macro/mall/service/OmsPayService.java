package com.macro.mall.service;

import com.macro.mall.dto.PaymsPayTemplateModeRelationDto;
import com.macro.mall.model.PaymsPayMode;
import com.macro.mall.model.PaymsPayTemplate;

import java.util.List;

/**
 * 订单支付Service
 * Created by macro on 2018/10/11.
 */
public interface OmsPayService {
    /**
     * 增加系统的支付模板
     */
    int addPayTeamplate(PaymsPayTemplate payTemplate);

    /**
     * 更新系统的支付模板
     */
    int updatePayTeamplate(PaymsPayTemplate payTemplate);

    /**
     * 删除系统的支付模板(物理删)
     */
    int deletePayTeamplate(Long id);

    /**
     * 查询系统的支付模板
     */
    List<PaymsPayTemplate> listPayTeamplateAll();

    /**
     * 设置系支付模板的支付方式
     */
    int addPayModeOfPayTemplate(Long templateId, List<PaymsPayMode> listPaymsPayMode);

    /**
     * 设置系支付模板的支付方式
     */
    int deletePayModeOfPayTemplate(Long templateId, List<Long> ids);

    /**
     * 查询系支付模板的支付方式
     */
    List<PaymsPayTemplateModeRelationDto> listPayModeOfPayTeamplate(Long templateId);

    /**
     * 增加系统支付方式
     */
    int addPayMode(PaymsPayMode paymsPayMode);

    /**
     * 更新系统支付方式
     */
    int updatePayMode(PaymsPayMode paymsPayMode);

    /**
     * 删除系统支付方式
     */
    int deletePayMode(Long id);

    /**
     * 查询系统支付方式
     */
    List<PaymsPayMode> listPayModeAll();
}
