package com.macro.mall.portal.service.impl;

import com.macro.mall.mapper.*;
import com.macro.mall.model.*;
import com.macro.mall.portal.domain.OmsPortalMarketingActivityDo;
import com.macro.mall.portal.domain.OmsPortalMarketingActivityWithProductIdDo;
import com.macro.mall.portal.service.OmsPortalMarketingActivityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 会员关注Service实现类
 * Created by macro on 2018/8/2.
 */
@Service
public class OmsPortalMarketingActivityServiceImpl implements OmsPortalMarketingActivityService {
    @Autowired
    private SmsMarketingActivitiesMapper marketingActivitiesMapper;
    @Autowired
    private SmsMarketingActivityRuleMapper marketingActivityRuleMapper;
    @Autowired
    private  SmsMarketingActivityProductRelationMapper marketingActivityProductRelationMapper;
    @Autowired
    private SmsMarketingActivityProductCategoryRelationMapper marketingActivityProductCategoryRelationMapper;
    @Autowired
    private PmsProductMapper productMapper;

    @Override
    public List<OmsPortalMarketingActivityDo> listGeneralMarketingActivity() {
        //定义返回值
        List<OmsPortalMarketingActivityDo> activityDtoList = new ArrayList<OmsPortalMarketingActivityDo>();

        //获取全场通用的活动规则
        SmsMarketingActivityRuleExample ruleExample = new SmsMarketingActivityRuleExample();
        ruleExample.createCriteria().andUseTypeEqualTo("0"); //0 - 全场通用
        List<SmsMarketingActivityRule>  ruleList = marketingActivityRuleMapper.selectByExample(ruleExample);

        //获取全场通用的而且正在使用的营销活动信息
        for (SmsMarketingActivityRule e : ruleList) {

            SmsMarketingActivitiesExample activitiesExample = new SmsMarketingActivitiesExample();
            activitiesExample.createCriteria().andIdEqualTo(e.getActivityId()).andActivityBeginTimeLessThan(new Date()).
                    andActivityEndTimeLessThan(new Date());
            SmsMarketingActivities activities = marketingActivitiesMapper.selectByExample(activitiesExample).get(0);
            if(activities != null){
                OmsPortalMarketingActivityDo activityDto = new OmsPortalMarketingActivityDo();
                BeanUtils.copyProperties(activities, activityDto);
                activityDto.setSmsMarketingActivityRule(e);
                activityDtoList.add(activityDto);
            }

        }

        //返回查询结果
        return activityDtoList;
    }

    /**
     * 商品参加的非全场通用的正式进行的营销活动
     *
     * @param productId
     */
    @Override
    public List<OmsPortalMarketingActivityWithProductIdDo> listAppointMarketingActivity(Long productId) {
        //定义返回结果
        List<OmsPortalMarketingActivityWithProductIdDo> marketingActivityWithProductIdDtoList =
                new ArrayList<OmsPortalMarketingActivityWithProductIdDo>();

        //从商品ID获取参加的所有营销活动
        SmsMarketingActivityProductRelationExample productRelationExample = 
                new SmsMarketingActivityProductRelationExample();
        productRelationExample.createCriteria().andProductIdEqualTo(productId);
        List<SmsMarketingActivityProductRelation> productRelationList = 
                marketingActivityProductRelationMapper.selectByExample(productRelationExample);
        for (SmsMarketingActivityProductRelation e : productRelationList) {
            //定义
            OmsPortalMarketingActivityWithProductIdDo marketingActivityWithProductIdDto =
                    new OmsPortalMarketingActivityWithProductIdDo();

            //设置商品ID
            marketingActivityWithProductIdDto.setProductId(productId);

            //设置营销活动
            SmsMarketingActivities marketingActivities = marketingActivitiesMapper.selectByPrimaryKey(e.getActivityId());
            if(marketingActivities != null){
                BeanUtils.copyProperties(marketingActivities, marketingActivityWithProductIdDto);
            }

            //设置营销活动对应的营销活动规则
            SmsMarketingActivityRuleExample activityRuleExample = new SmsMarketingActivityRuleExample();
            activityRuleExample.createCriteria().andActivityIdEqualTo(e.getActivityId());
            SmsMarketingActivityRule activityRule = marketingActivityRuleMapper.selectByExample(activityRuleExample).get(0);
            marketingActivityWithProductIdDto.setSmsMarketingActivityRule(activityRule);

            //增加
            marketingActivityWithProductIdDtoList.add(marketingActivityWithProductIdDto);
        }

        //从商品分类获取参加的所有营销活动
        SmsMarketingActivityProductCategoryRelationExample activityProductCategoryRelationExample =
                new SmsMarketingActivityProductCategoryRelationExample();
        activityProductCategoryRelationExample.createCriteria().andProductCategoryIdEqualTo(
                productMapper.selectByPrimaryKey(productId).getProductCategoryId());
        List<SmsMarketingActivityProductCategoryRelation>  marketingActivityProductCategoryRelationList =
                marketingActivityProductCategoryRelationMapper.selectByExample(activityProductCategoryRelationExample);
        for (SmsMarketingActivityProductCategoryRelation e : marketingActivityProductCategoryRelationList) {
            //定义
            OmsPortalMarketingActivityWithProductIdDo marketingActivityWithProductIdDto =
                    new OmsPortalMarketingActivityWithProductIdDo();

            //设置商品ID
            marketingActivityWithProductIdDto.setProductId(productId);

            //设置营销活动
            SmsMarketingActivities marketingActivities = marketingActivitiesMapper.selectByPrimaryKey(e.getActivityId());
            if(marketingActivities != null){
                BeanUtils.copyProperties(marketingActivities, marketingActivityWithProductIdDto);
            }

            //设置营销活动对应的营销活动规则
            SmsMarketingActivityRuleExample activityRuleExample = new SmsMarketingActivityRuleExample();
            activityRuleExample.createCriteria().andActivityIdEqualTo(e.getActivityId());
            SmsMarketingActivityRule activityRule = marketingActivityRuleMapper.selectByExample(activityRuleExample).get(0);
            marketingActivityWithProductIdDto.setSmsMarketingActivityRule(activityRule);

            //增加
            marketingActivityWithProductIdDtoList.add(marketingActivityWithProductIdDto);
        }

        //返回查询结果
        return marketingActivityWithProductIdDtoList;
    }
}
