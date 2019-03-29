package com.macro.mall.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FdfsFilenameMapperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FdfsFilenameMapperExample() {
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

        public Criteria andFdfsGroupIsNull() {
            addCriterion("fdfs_group is null");
            return (Criteria) this;
        }

        public Criteria andFdfsGroupIsNotNull() {
            addCriterion("fdfs_group is not null");
            return (Criteria) this;
        }

        public Criteria andFdfsGroupEqualTo(String value) {
            addCriterion("fdfs_group =", value, "fdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFdfsGroupNotEqualTo(String value) {
            addCriterion("fdfs_group <>", value, "fdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFdfsGroupGreaterThan(String value) {
            addCriterion("fdfs_group >", value, "fdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFdfsGroupGreaterThanOrEqualTo(String value) {
            addCriterion("fdfs_group >=", value, "fdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFdfsGroupLessThan(String value) {
            addCriterion("fdfs_group <", value, "fdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFdfsGroupLessThanOrEqualTo(String value) {
            addCriterion("fdfs_group <=", value, "fdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFdfsGroupLike(String value) {
            addCriterion("fdfs_group like", value, "fdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFdfsGroupNotLike(String value) {
            addCriterion("fdfs_group not like", value, "fdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFdfsGroupIn(List<String> values) {
            addCriterion("fdfs_group in", values, "fdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFdfsGroupNotIn(List<String> values) {
            addCriterion("fdfs_group not in", values, "fdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFdfsGroupBetween(String value1, String value2) {
            addCriterion("fdfs_group between", value1, value2, "fdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFdfsGroupNotBetween(String value1, String value2) {
            addCriterion("fdfs_group not between", value1, value2, "fdfsGroup");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameIsNull() {
            addCriterion("fdfs_full_path_name is null");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameIsNotNull() {
            addCriterion("fdfs_full_path_name is not null");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameEqualTo(String value) {
            addCriterion("fdfs_full_path_name =", value, "fdfsFullPathName");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameNotEqualTo(String value) {
            addCriterion("fdfs_full_path_name <>", value, "fdfsFullPathName");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameGreaterThan(String value) {
            addCriterion("fdfs_full_path_name >", value, "fdfsFullPathName");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameGreaterThanOrEqualTo(String value) {
            addCriterion("fdfs_full_path_name >=", value, "fdfsFullPathName");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameLessThan(String value) {
            addCriterion("fdfs_full_path_name <", value, "fdfsFullPathName");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameLessThanOrEqualTo(String value) {
            addCriterion("fdfs_full_path_name <=", value, "fdfsFullPathName");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameLike(String value) {
            addCriterion("fdfs_full_path_name like", value, "fdfsFullPathName");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameNotLike(String value) {
            addCriterion("fdfs_full_path_name not like", value, "fdfsFullPathName");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameIn(List<String> values) {
            addCriterion("fdfs_full_path_name in", values, "fdfsFullPathName");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameNotIn(List<String> values) {
            addCriterion("fdfs_full_path_name not in", values, "fdfsFullPathName");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameBetween(String value1, String value2) {
            addCriterion("fdfs_full_path_name between", value1, value2, "fdfsFullPathName");
            return (Criteria) this;
        }

        public Criteria andFdfsFullPathNameNotBetween(String value1, String value2) {
            addCriterion("fdfs_full_path_name not between", value1, value2, "fdfsFullPathName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameIsNull() {
            addCriterion("origin_file_name is null");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameIsNotNull() {
            addCriterion("origin_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameEqualTo(String value) {
            addCriterion("origin_file_name =", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameNotEqualTo(String value) {
            addCriterion("origin_file_name <>", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameGreaterThan(String value) {
            addCriterion("origin_file_name >", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("origin_file_name >=", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameLessThan(String value) {
            addCriterion("origin_file_name <", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameLessThanOrEqualTo(String value) {
            addCriterion("origin_file_name <=", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameLike(String value) {
            addCriterion("origin_file_name like", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameNotLike(String value) {
            addCriterion("origin_file_name not like", value, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameIn(List<String> values) {
            addCriterion("origin_file_name in", values, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameNotIn(List<String> values) {
            addCriterion("origin_file_name not in", values, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameBetween(String value1, String value2) {
            addCriterion("origin_file_name between", value1, value2, "originFileName");
            return (Criteria) this;
        }

        public Criteria andOriginFileNameNotBetween(String value1, String value2) {
            addCriterion("origin_file_name not between", value1, value2, "originFileName");
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
