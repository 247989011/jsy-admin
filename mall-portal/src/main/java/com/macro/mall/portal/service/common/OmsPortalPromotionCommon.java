package com.macro.mall.portal.service.common;

import com.macro.mall.mapper.*;
import com.macro.mall.model.*;
import com.macro.mall.portal.domain.OmsPortalMarketingActivityDo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class OmsPortalPromotionCommon {
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private SmsCouponMapper couponMapper;
    @Autowired
    private SmsCouponProductRelationMapper couponProductRelationMapper;
    @Autowired
    private SmsCouponProductCategoryRelationMapper couponProductCategoryRelationMapper;
    @Autowired
    private SmsCouponHistoryMapper couponHistoryMapper;
    @Autowired
    private SmsMarketingActivitiesMapper marketingActivitiesMapper;
    @Autowired
    private SmsMarketingActivityRuleMapper marketingActivityRuleMapper;
    @Autowired
    private  SmsMarketingActivityProductRelationMapper marketingActivityProductRelationMapper;
    @Autowired
    private SmsMarketingActivityProductCategoryRelationMapper marketingActivityProductCategoryRelationMapper;

    //全场通用的营销活动信息
    public List<OmsPortalMarketingActivityDo> searchGeneralMarketingActivity() {
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
            List<SmsMarketingActivities> activities = marketingActivitiesMapper.selectByExample(activitiesExample);
            if(activities != null && !activities.isEmpty()){
                OmsPortalMarketingActivityDo activityDto = new OmsPortalMarketingActivityDo();
                BeanUtils.copyProperties(activities.get(0), activityDto);
                activityDto.setSmsMarketingActivityRule(e);
                activityDtoList.add(activityDto);
            }

        }

        //返回查询结果
        return activityDtoList;
    }

    //获取客户的优惠劵信息
    public List<SmsCouponHistory> searchMemberCouponHistory(Long memberId, Integer useStatus) {

        SmsCouponHistoryExample couponHistoryExample=new SmsCouponHistoryExample();
        SmsCouponHistoryExample.Criteria criteria = couponHistoryExample.createCriteria();
        criteria.andMemberIdEqualTo(memberId);
        if(useStatus!=null){
            criteria.andUseStatusEqualTo(useStatus);
        }
        return couponHistoryMapper.selectByExample(couponHistoryExample);
    }

    //根据商品ID 获取客户可参加的营销活动信息
    public List<OmsPortalMarketingActivityDo> searchAppointMarketingActivity(Long productId) {
        //定义返回结果
        List<OmsPortalMarketingActivityDo> marketingActivityDtoList =
                new ArrayList<OmsPortalMarketingActivityDo>();

        //从商品ID获取参加的所有营销活动
        SmsMarketingActivityProductRelationExample productRelationExample =
                new SmsMarketingActivityProductRelationExample();
        productRelationExample.createCriteria().andProductIdEqualTo(productId);
        List<SmsMarketingActivityProductRelation> productRelationList =
                marketingActivityProductRelationMapper.selectByExample(productRelationExample);
        for (SmsMarketingActivityProductRelation e : productRelationList) {
            //定义
            OmsPortalMarketingActivityDo marketingActivityDto =
                    new OmsPortalMarketingActivityDo();

            //设置营销活动
            SmsMarketingActivities marketingActivities = marketingActivitiesMapper.selectByPrimaryKey(e.getActivityId());
            if(marketingActivities == null){
                continue;
            }
            BeanUtils.copyProperties(marketingActivities, marketingActivityDto);

            //设置营销活动对应的营销活动规则
            SmsMarketingActivityRuleExample activityRuleExample = new SmsMarketingActivityRuleExample();
            activityRuleExample.createCriteria().andActivityIdEqualTo(e.getActivityId());
            List<SmsMarketingActivityRule> activityRule = marketingActivityRuleMapper.selectByExample(activityRuleExample);
            if (activityRule != null && !activityRule.isEmpty()) {
                marketingActivityDto.setSmsMarketingActivityRule(activityRule.get(0));
            }

            //增加
            marketingActivityDtoList.add(marketingActivityDto);
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
            OmsPortalMarketingActivityDo marketingActivityDto =
                    new OmsPortalMarketingActivityDo();

            //设置营销活动
            SmsMarketingActivities marketingActivities = marketingActivitiesMapper.selectByPrimaryKey(e.getActivityId());
            if(marketingActivities == null){
                continue;
            }
            BeanUtils.copyProperties(marketingActivities, marketingActivityDto);

            //设置营销活动对应的营销活动规则
            SmsMarketingActivityRuleExample activityRuleExample = new SmsMarketingActivityRuleExample();
            activityRuleExample.createCriteria().andActivityIdEqualTo(e.getActivityId());
            List<SmsMarketingActivityRule> activityRule = marketingActivityRuleMapper.selectByExample(activityRuleExample);
            if (activityRule != null && !activityRule.isEmpty()) {
                marketingActivityDto.setSmsMarketingActivityRule(activityRule.get(0));
            }

            //增加
            marketingActivityDtoList.add(marketingActivityDto);
        }

        //返回查询结果
        return marketingActivityDtoList;
    }

    //根据客户ID和商品ID 获取优惠劵信息
    public List<SmsCoupon> searchAppointCoupon(Long memberId, Long productId) {
        //定义返回值
        List<SmsCoupon> couponList = new ArrayList<SmsCoupon>();

        //获取客户有效的优惠劵Id
        List<SmsCouponHistory>  couponHistoryList = searchMemberCouponHistory(memberId, 0); //0 - 未使用即有效优惠劵信息
        List<Long> couponIds  = new ArrayList<Long>();
        for (SmsCouponHistory e : couponHistoryList) {
            couponIds.add(e.getCouponId());
        }

        //根据商品ID和客户ID获取有效优惠劵信息
        SmsCouponProductRelationExample couponProductRelationExample = new SmsCouponProductRelationExample();
        SmsCouponProductRelationExample.Criteria criteria = couponProductRelationExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andCouponIdIn(couponIds);
        List<SmsCouponProductRelation> couponProductRelationList = couponProductRelationMapper.
                selectByExample(couponProductRelationExample);
        for (SmsCouponProductRelation e : couponProductRelationList) {
            SmsCoupon coupon = couponMapper.selectByPrimaryKey(e.getCouponId());
            if(coupon != null ){
                couponList.add(coupon);
            }
        }

        //从商品分类获和客户ID获取有效的优惠劵信息
        SmsCouponProductCategoryRelationExample couponProductCategoryRelationExample =
                new SmsCouponProductCategoryRelationExample();
        SmsCouponProductCategoryRelationExample.Criteria criteria1 =
                couponProductCategoryRelationExample.createCriteria();
        criteria1.andProductCategoryIdEqualTo(productMapper.selectByPrimaryKey(productId).getProductCategoryId());
        criteria1.andCouponIdIn(couponIds);

        List<SmsCouponProductCategoryRelation>  couponProductCategoryRelationList =
                couponProductCategoryRelationMapper.selectByExample(couponProductCategoryRelationExample);
        for (SmsCouponProductCategoryRelation e : couponProductCategoryRelationList) { ;
            SmsCoupon coupon = couponMapper.selectByPrimaryKey(e.getCouponId());
            if(coupon != null ){
                couponList.add(coupon);
            }
        }
        return couponList;
    }
}
