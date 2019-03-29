package com.macro.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmsMarketingActivitiesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsMarketingActivitiesExample() {
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

        public Criteria andActivityNameIsNull() {
            addCriterion("activity_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("activity_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("activity_name =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("activity_name <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("activity_name >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_name >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("activity_name <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("activity_name <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("activity_name like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("activity_name not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("activity_name in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("activity_name not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("activity_name between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("activity_name not between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andFrontTitleIsNull() {
            addCriterion("front_title is null");
            return (Criteria) this;
        }

        public Criteria andFrontTitleIsNotNull() {
            addCriterion("front_title is not null");
            return (Criteria) this;
        }

        public Criteria andFrontTitleEqualTo(String value) {
            addCriterion("front_title =", value, "frontTitle");
            return (Criteria) this;
        }

        public Criteria andFrontTitleNotEqualTo(String value) {
            addCriterion("front_title <>", value, "frontTitle");
            return (Criteria) this;
        }

        public Criteria andFrontTitleGreaterThan(String value) {
            addCriterion("front_title >", value, "frontTitle");
            return (Criteria) this;
        }

        public Criteria andFrontTitleGreaterThanOrEqualTo(String value) {
            addCriterion("front_title >=", value, "frontTitle");
            return (Criteria) this;
        }

        public Criteria andFrontTitleLessThan(String value) {
            addCriterion("front_title <", value, "frontTitle");
            return (Criteria) this;
        }

        public Criteria andFrontTitleLessThanOrEqualTo(String value) {
            addCriterion("front_title <=", value, "frontTitle");
            return (Criteria) this;
        }

        public Criteria andFrontTitleLike(String value) {
            addCriterion("front_title like", value, "frontTitle");
            return (Criteria) this;
        }

        public Criteria andFrontTitleNotLike(String value) {
            addCriterion("front_title not like", value, "frontTitle");
            return (Criteria) this;
        }

        public Criteria andFrontTitleIn(List<String> values) {
            addCriterion("front_title in", values, "frontTitle");
            return (Criteria) this;
        }

        public Criteria andFrontTitleNotIn(List<String> values) {
            addCriterion("front_title not in", values, "frontTitle");
            return (Criteria) this;
        }

        public Criteria andFrontTitleBetween(String value1, String value2) {
            addCriterion("front_title between", value1, value2, "frontTitle");
            return (Criteria) this;
        }

        public Criteria andFrontTitleNotBetween(String value1, String value2) {
            addCriterion("front_title not between", value1, value2, "frontTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIsNull() {
            addCriterion("activity_type is null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIsNotNull() {
            addCriterion("activity_type is not null");
            return (Criteria) this;
        }

        public Criteria andActivityTypeEqualTo(String value) {
            addCriterion("activity_type =", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotEqualTo(String value) {
            addCriterion("activity_type <>", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeGreaterThan(String value) {
            addCriterion("activity_type >", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeGreaterThanOrEqualTo(String value) {
            addCriterion("activity_type >=", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLessThan(String value) {
            addCriterion("activity_type <", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLessThanOrEqualTo(String value) {
            addCriterion("activity_type <=", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeLike(String value) {
            addCriterion("activity_type like", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotLike(String value) {
            addCriterion("activity_type not like", value, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeIn(List<String> values) {
            addCriterion("activity_type in", values, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotIn(List<String> values) {
            addCriterion("activity_type not in", values, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeBetween(String value1, String value2) {
            addCriterion("activity_type between", value1, value2, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityTypeNotBetween(String value1, String value2) {
            addCriterion("activity_type not between", value1, value2, "activityType");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionIsNull() {
            addCriterion("activity_description is null");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionIsNotNull() {
            addCriterion("activity_description is not null");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionEqualTo(String value) {
            addCriterion("activity_description =", value, "activityDescription");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionNotEqualTo(String value) {
            addCriterion("activity_description <>", value, "activityDescription");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionGreaterThan(String value) {
            addCriterion("activity_description >", value, "activityDescription");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("activity_description >=", value, "activityDescription");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionLessThan(String value) {
            addCriterion("activity_description <", value, "activityDescription");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionLessThanOrEqualTo(String value) {
            addCriterion("activity_description <=", value, "activityDescription");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionLike(String value) {
            addCriterion("activity_description like", value, "activityDescription");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionNotLike(String value) {
            addCriterion("activity_description not like", value, "activityDescription");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionIn(List<String> values) {
            addCriterion("activity_description in", values, "activityDescription");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionNotIn(List<String> values) {
            addCriterion("activity_description not in", values, "activityDescription");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionBetween(String value1, String value2) {
            addCriterion("activity_description between", value1, value2, "activityDescription");
            return (Criteria) this;
        }

        public Criteria andActivityDescriptionNotBetween(String value1, String value2) {
            addCriterion("activity_description not between", value1, value2, "activityDescription");
            return (Criteria) this;
        }

        public Criteria andActivityStateIsNull() {
            addCriterion("activity_state is null");
            return (Criteria) this;
        }

        public Criteria andActivityStateIsNotNull() {
            addCriterion("activity_state is not null");
            return (Criteria) this;
        }

        public Criteria andActivityStateEqualTo(String value) {
            addCriterion("activity_state =", value, "activityState");
            return (Criteria) this;
        }

        public Criteria andActivityStateNotEqualTo(String value) {
            addCriterion("activity_state <>", value, "activityState");
            return (Criteria) this;
        }

        public Criteria andActivityStateGreaterThan(String value) {
            addCriterion("activity_state >", value, "activityState");
            return (Criteria) this;
        }

        public Criteria andActivityStateGreaterThanOrEqualTo(String value) {
            addCriterion("activity_state >=", value, "activityState");
            return (Criteria) this;
        }

        public Criteria andActivityStateLessThan(String value) {
            addCriterion("activity_state <", value, "activityState");
            return (Criteria) this;
        }

        public Criteria andActivityStateLessThanOrEqualTo(String value) {
            addCriterion("activity_state <=", value, "activityState");
            return (Criteria) this;
        }

        public Criteria andActivityStateLike(String value) {
            addCriterion("activity_state like", value, "activityState");
            return (Criteria) this;
        }

        public Criteria andActivityStateNotLike(String value) {
            addCriterion("activity_state not like", value, "activityState");
            return (Criteria) this;
        }

        public Criteria andActivityStateIn(List<String> values) {
            addCriterion("activity_state in", values, "activityState");
            return (Criteria) this;
        }

        public Criteria andActivityStateNotIn(List<String> values) {
            addCriterion("activity_state not in", values, "activityState");
            return (Criteria) this;
        }

        public Criteria andActivityStateBetween(String value1, String value2) {
            addCriterion("activity_state between", value1, value2, "activityState");
            return (Criteria) this;
        }

        public Criteria andActivityStateNotBetween(String value1, String value2) {
            addCriterion("activity_state not between", value1, value2, "activityState");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeIsNull() {
            addCriterion("activity_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeIsNotNull() {
            addCriterion("activity_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeEqualTo(Date value) {
            addCriterion("activity_begin_time =", value, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeNotEqualTo(Date value) {
            addCriterion("activity_begin_time <>", value, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeGreaterThan(Date value) {
            addCriterion("activity_begin_time >", value, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_begin_time >=", value, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeLessThan(Date value) {
            addCriterion("activity_begin_time <", value, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_begin_time <=", value, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeIn(List<Date> values) {
            addCriterion("activity_begin_time in", values, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeNotIn(List<Date> values) {
            addCriterion("activity_begin_time not in", values, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeBetween(Date value1, Date value2) {
            addCriterion("activity_begin_time between", value1, value2, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_begin_time not between", value1, value2, "activityBeginTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeIsNull() {
            addCriterion("activity_end_time is null");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeIsNotNull() {
            addCriterion("activity_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeEqualTo(Date value) {
            addCriterion("activity_end_time =", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeNotEqualTo(Date value) {
            addCriterion("activity_end_time <>", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeGreaterThan(Date value) {
            addCriterion("activity_end_time >", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_end_time >=", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeLessThan(Date value) {
            addCriterion("activity_end_time <", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_end_time <=", value, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeIn(List<Date> values) {
            addCriterion("activity_end_time in", values, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeNotIn(List<Date> values) {
            addCriterion("activity_end_time not in", values, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeBetween(Date value1, Date value2) {
            addCriterion("activity_end_time between", value1, value2, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andActivityEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_end_time not between", value1, value2, "activityEndTime");
            return (Criteria) this;
        }

        public Criteria andUseCountIsNull() {
            addCriterion("use_count is null");
            return (Criteria) this;
        }

        public Criteria andUseCountIsNotNull() {
            addCriterion("use_count is not null");
            return (Criteria) this;
        }

        public Criteria andUseCountEqualTo(String value) {
            addCriterion("use_count =", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountNotEqualTo(String value) {
            addCriterion("use_count <>", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountGreaterThan(String value) {
            addCriterion("use_count >", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountGreaterThanOrEqualTo(String value) {
            addCriterion("use_count >=", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountLessThan(String value) {
            addCriterion("use_count <", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountLessThanOrEqualTo(String value) {
            addCriterion("use_count <=", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountLike(String value) {
            addCriterion("use_count like", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountNotLike(String value) {
            addCriterion("use_count not like", value, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountIn(List<String> values) {
            addCriterion("use_count in", values, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountNotIn(List<String> values) {
            addCriterion("use_count not in", values, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountBetween(String value1, String value2) {
            addCriterion("use_count between", value1, value2, "useCount");
            return (Criteria) this;
        }

        public Criteria andUseCountNotBetween(String value1, String value2) {
            addCriterion("use_count not between", value1, value2, "useCount");
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