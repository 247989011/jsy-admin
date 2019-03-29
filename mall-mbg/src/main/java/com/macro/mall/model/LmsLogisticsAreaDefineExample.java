package com.macro.mall.model;

import java.util.ArrayList;
import java.util.List;

public class LmsLogisticsAreaDefineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LmsLogisticsAreaDefineExample() {
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

        public Criteria andAreaNameCnIsNull() {
            addCriterion("area_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameCnIsNotNull() {
            addCriterion("area_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameCnEqualTo(String value) {
            addCriterion("area_name_cn =", value, "areaNameCn");
            return (Criteria) this;
        }

        public Criteria andAreaNameCnNotEqualTo(String value) {
            addCriterion("area_name_cn <>", value, "areaNameCn");
            return (Criteria) this;
        }

        public Criteria andAreaNameCnGreaterThan(String value) {
            addCriterion("area_name_cn >", value, "areaNameCn");
            return (Criteria) this;
        }

        public Criteria andAreaNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("area_name_cn >=", value, "areaNameCn");
            return (Criteria) this;
        }

        public Criteria andAreaNameCnLessThan(String value) {
            addCriterion("area_name_cn <", value, "areaNameCn");
            return (Criteria) this;
        }

        public Criteria andAreaNameCnLessThanOrEqualTo(String value) {
            addCriterion("area_name_cn <=", value, "areaNameCn");
            return (Criteria) this;
        }

        public Criteria andAreaNameCnLike(String value) {
            addCriterion("area_name_cn like", value, "areaNameCn");
            return (Criteria) this;
        }

        public Criteria andAreaNameCnNotLike(String value) {
            addCriterion("area_name_cn not like", value, "areaNameCn");
            return (Criteria) this;
        }

        public Criteria andAreaNameCnIn(List<String> values) {
            addCriterion("area_name_cn in", values, "areaNameCn");
            return (Criteria) this;
        }

        public Criteria andAreaNameCnNotIn(List<String> values) {
            addCriterion("area_name_cn not in", values, "areaNameCn");
            return (Criteria) this;
        }

        public Criteria andAreaNameCnBetween(String value1, String value2) {
            addCriterion("area_name_cn between", value1, value2, "areaNameCn");
            return (Criteria) this;
        }

        public Criteria andAreaNameCnNotBetween(String value1, String value2) {
            addCriterion("area_name_cn not between", value1, value2, "areaNameCn");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnIsNull() {
            addCriterion("area_name_en is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnIsNotNull() {
            addCriterion("area_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnEqualTo(String value) {
            addCriterion("area_name_en =", value, "areaNameEn");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnNotEqualTo(String value) {
            addCriterion("area_name_en <>", value, "areaNameEn");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnGreaterThan(String value) {
            addCriterion("area_name_en >", value, "areaNameEn");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("area_name_en >=", value, "areaNameEn");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnLessThan(String value) {
            addCriterion("area_name_en <", value, "areaNameEn");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnLessThanOrEqualTo(String value) {
            addCriterion("area_name_en <=", value, "areaNameEn");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnLike(String value) {
            addCriterion("area_name_en like", value, "areaNameEn");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnNotLike(String value) {
            addCriterion("area_name_en not like", value, "areaNameEn");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnIn(List<String> values) {
            addCriterion("area_name_en in", values, "areaNameEn");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnNotIn(List<String> values) {
            addCriterion("area_name_en not in", values, "areaNameEn");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnBetween(String value1, String value2) {
            addCriterion("area_name_en between", value1, value2, "areaNameEn");
            return (Criteria) this;
        }

        public Criteria andAreaNameEnNotBetween(String value1, String value2) {
            addCriterion("area_name_en not between", value1, value2, "areaNameEn");
            return (Criteria) this;
        }

        public Criteria andAreaTypeIsNull() {
            addCriterion("area_type is null");
            return (Criteria) this;
        }

        public Criteria andAreaTypeIsNotNull() {
            addCriterion("area_type is not null");
            return (Criteria) this;
        }

        public Criteria andAreaTypeEqualTo(String value) {
            addCriterion("area_type =", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeNotEqualTo(String value) {
            addCriterion("area_type <>", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeGreaterThan(String value) {
            addCriterion("area_type >", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("area_type >=", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeLessThan(String value) {
            addCriterion("area_type <", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeLessThanOrEqualTo(String value) {
            addCriterion("area_type <=", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeLike(String value) {
            addCriterion("area_type like", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeNotLike(String value) {
            addCriterion("area_type not like", value, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeIn(List<String> values) {
            addCriterion("area_type in", values, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeNotIn(List<String> values) {
            addCriterion("area_type not in", values, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeBetween(String value1, String value2) {
            addCriterion("area_type between", value1, value2, "areaType");
            return (Criteria) this;
        }

        public Criteria andAreaTypeNotBetween(String value1, String value2) {
            addCriterion("area_type not between", value1, value2, "areaType");
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