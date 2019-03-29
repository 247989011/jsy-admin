package com.macro.mall.model;

import java.util.ArrayList;
import java.util.List;

public class LmsLogisticsModeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LmsLogisticsModeExample() {
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

        public Criteria andLogisticsModeNameIsNull() {
            addCriterion("logistics_mode_name is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeNameIsNotNull() {
            addCriterion("logistics_mode_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeNameEqualTo(String value) {
            addCriterion("logistics_mode_name =", value, "logisticsModeName");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeNameNotEqualTo(String value) {
            addCriterion("logistics_mode_name <>", value, "logisticsModeName");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeNameGreaterThan(String value) {
            addCriterion("logistics_mode_name >", value, "logisticsModeName");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeNameGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_mode_name >=", value, "logisticsModeName");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeNameLessThan(String value) {
            addCriterion("logistics_mode_name <", value, "logisticsModeName");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeNameLessThanOrEqualTo(String value) {
            addCriterion("logistics_mode_name <=", value, "logisticsModeName");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeNameLike(String value) {
            addCriterion("logistics_mode_name like", value, "logisticsModeName");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeNameNotLike(String value) {
            addCriterion("logistics_mode_name not like", value, "logisticsModeName");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeNameIn(List<String> values) {
            addCriterion("logistics_mode_name in", values, "logisticsModeName");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeNameNotIn(List<String> values) {
            addCriterion("logistics_mode_name not in", values, "logisticsModeName");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeNameBetween(String value1, String value2) {
            addCriterion("logistics_mode_name between", value1, value2, "logisticsModeName");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeNameNotBetween(String value1, String value2) {
            addCriterion("logistics_mode_name not between", value1, value2, "logisticsModeName");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeIsNull() {
            addCriterion("logistics_type is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeIsNotNull() {
            addCriterion("logistics_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeEqualTo(String value) {
            addCriterion("logistics_type =", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeNotEqualTo(String value) {
            addCriterion("logistics_type <>", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeGreaterThan(String value) {
            addCriterion("logistics_type >", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_type >=", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeLessThan(String value) {
            addCriterion("logistics_type <", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeLessThanOrEqualTo(String value) {
            addCriterion("logistics_type <=", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeLike(String value) {
            addCriterion("logistics_type like", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeNotLike(String value) {
            addCriterion("logistics_type not like", value, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeIn(List<String> values) {
            addCriterion("logistics_type in", values, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeNotIn(List<String> values) {
            addCriterion("logistics_type not in", values, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeBetween(String value1, String value2) {
            addCriterion("logistics_type between", value1, value2, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andLogisticsTypeNotBetween(String value1, String value2) {
            addCriterion("logistics_type not between", value1, value2, "logisticsType");
            return (Criteria) this;
        }

        public Criteria andMinDaysIsNull() {
            addCriterion("min_days is null");
            return (Criteria) this;
        }

        public Criteria andMinDaysIsNotNull() {
            addCriterion("min_days is not null");
            return (Criteria) this;
        }

        public Criteria andMinDaysEqualTo(Integer value) {
            addCriterion("min_days =", value, "minDays");
            return (Criteria) this;
        }

        public Criteria andMinDaysNotEqualTo(Integer value) {
            addCriterion("min_days <>", value, "minDays");
            return (Criteria) this;
        }

        public Criteria andMinDaysGreaterThan(Integer value) {
            addCriterion("min_days >", value, "minDays");
            return (Criteria) this;
        }

        public Criteria andMinDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_days >=", value, "minDays");
            return (Criteria) this;
        }

        public Criteria andMinDaysLessThan(Integer value) {
            addCriterion("min_days <", value, "minDays");
            return (Criteria) this;
        }

        public Criteria andMinDaysLessThanOrEqualTo(Integer value) {
            addCriterion("min_days <=", value, "minDays");
            return (Criteria) this;
        }

        public Criteria andMinDaysIn(List<Integer> values) {
            addCriterion("min_days in", values, "minDays");
            return (Criteria) this;
        }

        public Criteria andMinDaysNotIn(List<Integer> values) {
            addCriterion("min_days not in", values, "minDays");
            return (Criteria) this;
        }

        public Criteria andMinDaysBetween(Integer value1, Integer value2) {
            addCriterion("min_days between", value1, value2, "minDays");
            return (Criteria) this;
        }

        public Criteria andMinDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("min_days not between", value1, value2, "minDays");
            return (Criteria) this;
        }

        public Criteria andMaxDaysIsNull() {
            addCriterion("max_days is null");
            return (Criteria) this;
        }

        public Criteria andMaxDaysIsNotNull() {
            addCriterion("max_days is not null");
            return (Criteria) this;
        }

        public Criteria andMaxDaysEqualTo(Integer value) {
            addCriterion("max_days =", value, "maxDays");
            return (Criteria) this;
        }

        public Criteria andMaxDaysNotEqualTo(Integer value) {
            addCriterion("max_days <>", value, "maxDays");
            return (Criteria) this;
        }

        public Criteria andMaxDaysGreaterThan(Integer value) {
            addCriterion("max_days >", value, "maxDays");
            return (Criteria) this;
        }

        public Criteria andMaxDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_days >=", value, "maxDays");
            return (Criteria) this;
        }

        public Criteria andMaxDaysLessThan(Integer value) {
            addCriterion("max_days <", value, "maxDays");
            return (Criteria) this;
        }

        public Criteria andMaxDaysLessThanOrEqualTo(Integer value) {
            addCriterion("max_days <=", value, "maxDays");
            return (Criteria) this;
        }

        public Criteria andMaxDaysIn(List<Integer> values) {
            addCriterion("max_days in", values, "maxDays");
            return (Criteria) this;
        }

        public Criteria andMaxDaysNotIn(List<Integer> values) {
            addCriterion("max_days not in", values, "maxDays");
            return (Criteria) this;
        }

        public Criteria andMaxDaysBetween(Integer value1, Integer value2) {
            addCriterion("max_days between", value1, value2, "maxDays");
            return (Criteria) this;
        }

        public Criteria andMaxDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("max_days not between", value1, value2, "maxDays");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusIsNull() {
            addCriterion("logistics_mode_status is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusIsNotNull() {
            addCriterion("logistics_mode_status is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusEqualTo(String value) {
            addCriterion("logistics_mode_status =", value, "logisticsModeStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusNotEqualTo(String value) {
            addCriterion("logistics_mode_status <>", value, "logisticsModeStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusGreaterThan(String value) {
            addCriterion("logistics_mode_status >", value, "logisticsModeStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_mode_status >=", value, "logisticsModeStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusLessThan(String value) {
            addCriterion("logistics_mode_status <", value, "logisticsModeStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusLessThanOrEqualTo(String value) {
            addCriterion("logistics_mode_status <=", value, "logisticsModeStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusLike(String value) {
            addCriterion("logistics_mode_status like", value, "logisticsModeStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusNotLike(String value) {
            addCriterion("logistics_mode_status not like", value, "logisticsModeStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusIn(List<String> values) {
            addCriterion("logistics_mode_status in", values, "logisticsModeStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusNotIn(List<String> values) {
            addCriterion("logistics_mode_status not in", values, "logisticsModeStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusBetween(String value1, String value2) {
            addCriterion("logistics_mode_status between", value1, value2, "logisticsModeStatus");
            return (Criteria) this;
        }

        public Criteria andLogisticsModeStatusNotBetween(String value1, String value2) {
            addCriterion("logistics_mode_status not between", value1, value2, "logisticsModeStatus");
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

        public Criteria andLastCreateTimeEqualTo(String value) {
            addCriterion("last_create_time =", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeNotEqualTo(String value) {
            addCriterion("last_create_time <>", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeGreaterThan(String value) {
            addCriterion("last_create_time >", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("last_create_time >=", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeLessThan(String value) {
            addCriterion("last_create_time <", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("last_create_time <=", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeLike(String value) {
            addCriterion("last_create_time like", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeNotLike(String value) {
            addCriterion("last_create_time not like", value, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeIn(List<String> values) {
            addCriterion("last_create_time in", values, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeNotIn(List<String> values) {
            addCriterion("last_create_time not in", values, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeBetween(String value1, String value2) {
            addCriterion("last_create_time between", value1, value2, "lastCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastCreateTimeNotBetween(String value1, String value2) {
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

        public Criteria andLastUpdateTimeEqualTo(String value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(String value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(String value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(String value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLike(String value) {
            addCriterion("last_update_time like", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotLike(String value) {
            addCriterion("last_update_time not like", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<String> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<String> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(String value1, String value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(String value1, String value2) {
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