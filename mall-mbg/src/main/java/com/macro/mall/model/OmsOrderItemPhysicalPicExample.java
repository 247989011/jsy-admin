package com.macro.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmsOrderItemPhysicalPicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmsOrderItemPhysicalPicExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdIsNull() {
            addCriterion("order_item_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdIsNotNull() {
            addCriterion("order_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdEqualTo(Long value) {
            addCriterion("order_item_id =", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotEqualTo(Long value) {
            addCriterion("order_item_id <>", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdGreaterThan(Long value) {
            addCriterion("order_item_id >", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_item_id >=", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdLessThan(Long value) {
            addCriterion("order_item_id <", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdLessThanOrEqualTo(Long value) {
            addCriterion("order_item_id <=", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdIn(List<Long> values) {
            addCriterion("order_item_id in", values, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotIn(List<Long> values) {
            addCriterion("order_item_id not in", values, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdBetween(Long value1, Long value2) {
            addCriterion("order_item_id between", value1, value2, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotBetween(Long value1, Long value2) {
            addCriterion("order_item_id not between", value1, value2, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayIsNull() {
            addCriterion("pic_save_way is null");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayIsNotNull() {
            addCriterion("pic_save_way is not null");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayEqualTo(String value) {
            addCriterion("pic_save_way =", value, "picSaveWay");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayNotEqualTo(String value) {
            addCriterion("pic_save_way <>", value, "picSaveWay");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayGreaterThan(String value) {
            addCriterion("pic_save_way >", value, "picSaveWay");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayGreaterThanOrEqualTo(String value) {
            addCriterion("pic_save_way >=", value, "picSaveWay");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayLessThan(String value) {
            addCriterion("pic_save_way <", value, "picSaveWay");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayLessThanOrEqualTo(String value) {
            addCriterion("pic_save_way <=", value, "picSaveWay");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayLike(String value) {
            addCriterion("pic_save_way like", value, "picSaveWay");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayNotLike(String value) {
            addCriterion("pic_save_way not like", value, "picSaveWay");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayIn(List<String> values) {
            addCriterion("pic_save_way in", values, "picSaveWay");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayNotIn(List<String> values) {
            addCriterion("pic_save_way not in", values, "picSaveWay");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayBetween(String value1, String value2) {
            addCriterion("pic_save_way between", value1, value2, "picSaveWay");
            return (Criteria) this;
        }

        public Criteria andPicSaveWayNotBetween(String value1, String value2) {
            addCriterion("pic_save_way not between", value1, value2, "picSaveWay");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupIsNull() {
            addCriterion("pic_fastdfs_group is null");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupIsNotNull() {
            addCriterion("pic_fastdfs_group is not null");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupEqualTo(String value) {
            addCriterion("pic_fastdfs_group =", value, "picFastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupNotEqualTo(String value) {
            addCriterion("pic_fastdfs_group <>", value, "picFastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupGreaterThan(String value) {
            addCriterion("pic_fastdfs_group >", value, "picFastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupGreaterThanOrEqualTo(String value) {
            addCriterion("pic_fastdfs_group >=", value, "picFastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupLessThan(String value) {
            addCriterion("pic_fastdfs_group <", value, "picFastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupLessThanOrEqualTo(String value) {
            addCriterion("pic_fastdfs_group <=", value, "picFastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupLike(String value) {
            addCriterion("pic_fastdfs_group like", value, "picFastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupNotLike(String value) {
            addCriterion("pic_fastdfs_group not like", value, "picFastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupIn(List<String> values) {
            addCriterion("pic_fastdfs_group in", values, "picFastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupNotIn(List<String> values) {
            addCriterion("pic_fastdfs_group not in", values, "picFastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupBetween(String value1, String value2) {
            addCriterion("pic_fastdfs_group between", value1, value2, "picFastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsGroupNotBetween(String value1, String value2) {
            addCriterion("pic_fastdfs_group not between", value1, value2, "picFastdfsGroup");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameIsNull() {
            addCriterion("pic_fastdfs_fullname is null");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameIsNotNull() {
            addCriterion("pic_fastdfs_fullname is not null");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameEqualTo(String value) {
            addCriterion("pic_fastdfs_fullname =", value, "picFastdfsFullname");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameNotEqualTo(String value) {
            addCriterion("pic_fastdfs_fullname <>", value, "picFastdfsFullname");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameGreaterThan(String value) {
            addCriterion("pic_fastdfs_fullname >", value, "picFastdfsFullname");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameGreaterThanOrEqualTo(String value) {
            addCriterion("pic_fastdfs_fullname >=", value, "picFastdfsFullname");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameLessThan(String value) {
            addCriterion("pic_fastdfs_fullname <", value, "picFastdfsFullname");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameLessThanOrEqualTo(String value) {
            addCriterion("pic_fastdfs_fullname <=", value, "picFastdfsFullname");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameLike(String value) {
            addCriterion("pic_fastdfs_fullname like", value, "picFastdfsFullname");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameNotLike(String value) {
            addCriterion("pic_fastdfs_fullname not like", value, "picFastdfsFullname");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameIn(List<String> values) {
            addCriterion("pic_fastdfs_fullname in", values, "picFastdfsFullname");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameNotIn(List<String> values) {
            addCriterion("pic_fastdfs_fullname not in", values, "picFastdfsFullname");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameBetween(String value1, String value2) {
            addCriterion("pic_fastdfs_fullname between", value1, value2, "picFastdfsFullname");
            return (Criteria) this;
        }

        public Criteria andPicFastdfsFullnameNotBetween(String value1, String value2) {
            addCriterion("pic_fastdfs_fullname not between", value1, value2, "picFastdfsFullname");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlIsNull() {
            addCriterion("pic_oss_url is null");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlIsNotNull() {
            addCriterion("pic_oss_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlEqualTo(String value) {
            addCriterion("pic_oss_url =", value, "picOssUrl");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlNotEqualTo(String value) {
            addCriterion("pic_oss_url <>", value, "picOssUrl");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlGreaterThan(String value) {
            addCriterion("pic_oss_url >", value, "picOssUrl");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pic_oss_url >=", value, "picOssUrl");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlLessThan(String value) {
            addCriterion("pic_oss_url <", value, "picOssUrl");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlLessThanOrEqualTo(String value) {
            addCriterion("pic_oss_url <=", value, "picOssUrl");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlLike(String value) {
            addCriterion("pic_oss_url like", value, "picOssUrl");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlNotLike(String value) {
            addCriterion("pic_oss_url not like", value, "picOssUrl");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlIn(List<String> values) {
            addCriterion("pic_oss_url in", values, "picOssUrl");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlNotIn(List<String> values) {
            addCriterion("pic_oss_url not in", values, "picOssUrl");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlBetween(String value1, String value2) {
            addCriterion("pic_oss_url between", value1, value2, "picOssUrl");
            return (Criteria) this;
        }

        public Criteria andPicOssUrlNotBetween(String value1, String value2) {
            addCriterion("pic_oss_url not between", value1, value2, "picOssUrl");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIsNull() {
            addCriterion("confirm_status is null");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIsNotNull() {
            addCriterion("confirm_status is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusEqualTo(String value) {
            addCriterion("confirm_status =", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotEqualTo(String value) {
            addCriterion("confirm_status <>", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusGreaterThan(String value) {
            addCriterion("confirm_status >", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_status >=", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLessThan(String value) {
            addCriterion("confirm_status <", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLessThanOrEqualTo(String value) {
            addCriterion("confirm_status <=", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusLike(String value) {
            addCriterion("confirm_status like", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotLike(String value) {
            addCriterion("confirm_status not like", value, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusIn(List<String> values) {
            addCriterion("confirm_status in", values, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotIn(List<String> values) {
            addCriterion("confirm_status not in", values, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusBetween(String value1, String value2) {
            addCriterion("confirm_status between", value1, value2, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andConfirmStatusNotBetween(String value1, String value2) {
            addCriterion("confirm_status not between", value1, value2, "confirmStatus");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeIsNull() {
            addCriterion("last_create_time is null");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeIsNotNull() {
            addCriterion("last_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeEqualTo(Date value) {
            addCriterion("last_create_time =", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeNotEqualTo(Date value) {
            addCriterion("last_create_time <>", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeGreaterThan(Date value) {
            addCriterion("last_create_time >", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_create_time >=", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeLessThan(Date value) {
            addCriterion("last_create_time <", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_create_time <=", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeIn(List<Date> values) {
            addCriterion("last_create_time in", values, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeNotIn(List<Date> values) {
            addCriterion("last_create_time not in", values, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeBetween(Date value1, Date value2) {
            addCriterion("last_create_time between", value1, value2, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_create_time not between", value1, value2, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdIsNull() {
            addCriterion("last_create_id is null");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdIsNotNull() {
            addCriterion("last_create_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdEqualTo(String value) {
            addCriterion("last_create_id =", value, "lastCreateId");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdNotEqualTo(String value) {
            addCriterion("last_create_id <>", value, "lastCreateId");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdGreaterThan(String value) {
            addCriterion("last_create_id >", value, "lastCreateId");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdGreaterThanOrEqualTo(String value) {
            addCriterion("last_create_id >=", value, "lastCreateId");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdLessThan(String value) {
            addCriterion("last_create_id <", value, "lastCreateId");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdLessThanOrEqualTo(String value) {
            addCriterion("last_create_id <=", value, "lastCreateId");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdLike(String value) {
            addCriterion("last_create_id like", value, "lastCreateId");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdNotLike(String value) {
            addCriterion("last_create_id not like", value, "lastCreateId");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdIn(List<String> values) {
            addCriterion("last_create_id in", values, "lastCreateId");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdNotIn(List<String> values) {
            addCriterion("last_create_id not in", values, "lastCreateId");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdBetween(String value1, String value2) {
            addCriterion("last_create_id between", value1, value2, "lastCreateId");
            return (Criteria) this;
        }

        public Criteria andLastCreateIdNotBetween(String value1, String value2) {
            addCriterion("last_create_id not between", value1, value2, "lastCreateId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdIsNull() {
            addCriterion("last_update_id is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdIsNotNull() {
            addCriterion("last_update_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdEqualTo(String value) {
            addCriterion("last_update_id =", value, "lastUpdateId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdNotEqualTo(String value) {
            addCriterion("last_update_id <>", value, "lastUpdateId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdGreaterThan(String value) {
            addCriterion("last_update_id >", value, "lastUpdateId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdGreaterThanOrEqualTo(String value) {
            addCriterion("last_update_id >=", value, "lastUpdateId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdLessThan(String value) {
            addCriterion("last_update_id <", value, "lastUpdateId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdLessThanOrEqualTo(String value) {
            addCriterion("last_update_id <=", value, "lastUpdateId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdLike(String value) {
            addCriterion("last_update_id like", value, "lastUpdateId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdNotLike(String value) {
            addCriterion("last_update_id not like", value, "lastUpdateId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdIn(List<String> values) {
            addCriterion("last_update_id in", values, "lastUpdateId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdNotIn(List<String> values) {
            addCriterion("last_update_id not in", values, "lastUpdateId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdBetween(String value1, String value2) {
            addCriterion("last_update_id between", value1, value2, "lastUpdateId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIdNotBetween(String value1, String value2) {
            addCriterion("last_update_id not between", value1, value2, "lastUpdateId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}