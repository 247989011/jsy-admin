package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.LmsLogisticsTemplateMapper;
import com.macro.mall.model.LmsLogisticsTemplate;
import com.macro.mall.model.LmsLogisticsTemplateExample;
import com.macro.mall.service.LmsLogisticsTemplateService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单管理Service实现类
 * Created by macro on 2018/10/11.
 */
@Service
public class LmsLogisticsTemplateServiceImpl implements LmsLogisticsTemplateService {
    @Autowired
    private LmsLogisticsTemplateMapper lmsLogisticsTemplateMapper;

    /**
     * 添加物流模板
     *
     * @param logisticsTemplate
     */
    @Override
    public int create(LmsLogisticsTemplate logisticsTemplate) {
        return lmsLogisticsTemplateMapper.insert(logisticsTemplate);
    }

    /**
     * 修改物流模板信息
     *
     * @param id
     * @param logisticsTemplate
     */
    @Override
    public int update(Long id, LmsLogisticsTemplate logisticsTemplate) {
        return lmsLogisticsTemplateMapper.updateByPrimaryKey(logisticsTemplate);
    }

    /**
     * 修改物流模板状态(00-正常、01-弃用)
     *
     * @param id
     * @param status
     */
    @Override
    public int updateStatus(Long id, String status) {
        LmsLogisticsTemplate lmsLogisticsTemplate = new LmsLogisticsTemplate();
        lmsLogisticsTemplate.setId(id);
        lmsLogisticsTemplate.setTemplateStatus(status);
        return lmsLogisticsTemplateMapper.updateByPrimaryKey(lmsLogisticsTemplate);
    }

    /**
     * 逻辑删除物流模板
     *
     * @param id
     */
    @Override
    public int logicDelete(Long id) {
        LmsLogisticsTemplate lmsLogisticsTemplate = new LmsLogisticsTemplate();
        lmsLogisticsTemplate.setId(id);
        lmsLogisticsTemplate.setTemplateStatus(LOGISTICS_TEMPLATE_STATUS_DISUSE_01);
        return lmsLogisticsTemplateMapper.updateByPrimaryKey(lmsLogisticsTemplate);
    }

    /**
     * 物理删除物流模板
     *
     * @param id
     */
    @Override
    public int delete(Long id) {
        return lmsLogisticsTemplateMapper.deleteByPrimaryKey(id);
    }

    /**
     * 获取物流模板详情
     *
     * @param id
     */
    @Override
    public LmsLogisticsTemplate getItem(Long id) {
        return lmsLogisticsTemplateMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询物流模板(分页)
     *
     * @param templateName
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<LmsLogisticsTemplate> page(String templateName, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isEmpty(templateName)) {
            templateName = "";
        }
        templateName = "%" + templateName +"%";
        LmsLogisticsTemplateExample example = new LmsLogisticsTemplateExample();
        LmsLogisticsTemplateExample.Criteria criteria = example.createCriteria();
        criteria.andTemplateNameLike(templateName);
        criteria.andTemplateStatusEqualTo(LOGISTICS_TEMPLATE_STATUS_INUSE_00);

        return lmsLogisticsTemplateMapper.selectByExample(example);
    }
}
