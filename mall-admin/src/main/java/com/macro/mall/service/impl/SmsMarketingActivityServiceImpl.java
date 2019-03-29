package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dto.SmsMarketingActivitiesDto;
import com.macro.mall.mapper.*;
import com.macro.mall.model.*;
import com.macro.mall.service.SmsMarketingActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 营销活动Service实现类
 * Created by macro on 2018/11/16.
 */
@Service
@Slf4j
public class SmsMarketingActivityServiceImpl implements SmsMarketingActivityService {
    @Autowired
    private SmsMarketingActivitiesMapper  marketingActivitiesMapper;
    @Autowired
    private SmsMarketingActivityRuleMapper marketingActivityRuleMapper;
    @Autowired
    private SmsMarketingActivityProductCategoryRelationMapper marketingActivityProductCategoryRelationMapper;
    @Autowired
    private SmsMarketingActivityProductRelationMapper marketingActivityProductRelationMapper;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private  PmsProductCategoryMapper productCategoryMapper;

    /**
     * 添加营销活动
     *
     * @param marketingActivities
     */
    @Override
    public int add(SmsMarketingActivities marketingActivities) {
        return marketingActivitiesMapper.insert(marketingActivities);
    }

    @Override
    public int addV2(SmsMarketingActivitiesDto marketingActivitiesDto) {
        //登记营销活动基本信息
        SmsMarketingActivities marketingActivities = new SmsMarketingActivities();
        BeanUtils.copyProperties(marketingActivitiesDto, marketingActivities);
        marketingActivities.setLastCreateId("admin");
        marketingActivities.setLastCreateTime(new Date());
        marketingActivities.setLastUpdateId("admin");
        marketingActivities.setLastUpdateTime(new Date());
        if(marketingActivitiesMapper.insert(marketingActivities) < 0){
            log.error("增加营销活动基本信息失败{}", marketingActivities);
            return -1;
        }

        //登记营销活动对应的规则信息
        SmsMarketingActivityRule marketingActivityRule = new SmsMarketingActivityRule();
        marketingActivityRule.setLastCreateId("admin");
        marketingActivityRule.setLastCreateTime(new Date());
        marketingActivityRule.setLastUpdateId("admin");
        marketingActivityRule.setLastUpdateTime(new Date());

        BeanUtils.copyProperties(marketingActivitiesDto, marketingActivityRule);
        if(marketingActivityRuleMapper.insert(marketingActivityRule) < 0){
            log.error("增加营销活动基本信息失败{}", marketingActivityRule);
            return -1;
        }

        //登记营销活动关联的商品分类
        for (Long productCategoryId : marketingActivitiesDto.getProductCategoryIds()) {
            SmsMarketingActivityProductCategoryRelation categoryRelation =
                    new SmsMarketingActivityProductCategoryRelation();
            categoryRelation.setActivityId(marketingActivitiesDto.getId());
            categoryRelation.setProductCategoryId(productCategoryId);
            //获取产品分类信息
            PmsProductCategory productCategory = productCategoryMapper.selectByPrimaryKey(productCategoryId);
            if(productCategory == null){
                log.error("获取产品分类信息失败{}", productCategoryId);
                return -1;
            }
            categoryRelation.setProductCategoryName(productCategory.getName());
            categoryRelation.setLastCreateId("admin");
            categoryRelation.setLastCreateTime(new Date());
            categoryRelation.setLastUpdateId("admin");
            categoryRelation.setLastUpdateTime(new Date());
            if(marketingActivityProductCategoryRelationMapper.insertSelective(categoryRelation) < 0){
                log.error("添加营销活动的产品分类信息失败{}", categoryRelation);
                return  -1;
            }
        }

        //登记营销活动关联的商品
        for (Long productId : marketingActivitiesDto.getProductIds()) {
            SmsMarketingActivityProductRelation productRelation =
                    new SmsMarketingActivityProductRelation();
            productRelation.setActivityId(marketingActivitiesDto.getId());
            productRelation.setProductId(productId);
            //查询商品信息
            PmsProduct product= productMapper.selectByPrimaryKey(productId);
            if(product == null){
                log.error("获取产品信息失败{}", productId);
                return -1;
            }
            productRelation.setProductName(product.getName());
            productRelation.setProductSn(product.getProductSn());
            productRelation.setLastCreateId("admin");
            productRelation.setLastCreateTime(new Date());
            productRelation.setLastUpdateId("admin");
            productRelation.setLastUpdateTime(new Date());
            if(marketingActivityProductRelationMapper.insertSelective(productRelation) <0){
                log.error("添加营销活动商品信息失败{}", productRelation);
                return -1;
            }
        }

        return 1;
    }

    /**
     * 修改指定营销活动
     *
     * @param id
     * @param marketingActivities
     */
    @Override
    public int update(Long id, SmsMarketingActivities marketingActivities) {
        return marketingActivitiesMapper.updateByPrimaryKey(marketingActivities);
    }

    /**
     * 删除单个活动
     *
     * @param id
     */
    @Override
    public int delete(Long id) {
        return marketingActivitiesMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改营销活动状态
     *
     * @param id
     * @param activityState
     */
    @Override
    public int updateStatus(Long id, String activityState) {
        SmsMarketingActivities record = new SmsMarketingActivities();
        record.setId(id);
        record.setActivityState(activityState);
        return marketingActivitiesMapper.updateByPrimaryKey(record);
    }

    /**
     * 获取营销活动详询信息
     *
     * @param id
     */
    @Override
    public SmsMarketingActivities getItem(Long id) {
        return marketingActivitiesMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询活动
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<SmsMarketingActivities> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        SmsMarketingActivitiesExample smsMarketingActivitiesExample = new SmsMarketingActivitiesExample();
        SmsMarketingActivitiesExample.Criteria criteria  = smsMarketingActivitiesExample.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andActivityNameLike("%" + keyword + "%");
            smsMarketingActivitiesExample.or(smsMarketingActivitiesExample.createCriteria().
                    andActivityDescriptionLike("%" + keyword + "%"));
        }
        return marketingActivitiesMapper.selectByExample(smsMarketingActivitiesExample);
    }
}
