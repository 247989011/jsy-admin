package com.macro.mall.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmsOrderPayLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmsOrderPayLogExample() {
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

        public Criteria andPayModeIdIsNull() {
            addCriterion("pay_mode_id is null");
            return (Criteria) this;
        }

        public Criteria andPayModeIdIsNotNull() {
            addCriterion("pay_mode_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayModeIdEqualTo(Long value) {
            addCriterion("pay_mode_id =", value, "payModeId");
            return (Criteria) this;
        }

        public Criteria andPayModeIdNotEqualTo(Long value) {
            addCriterion("pay_mode_id <>", value, "payModeId");
            return (Criteria) this;
        }

        public Criteria andPayModeIdGreaterThan(Long value) {
            addCriterion("pay_mode_id >", value, "payModeId");
            return (Criteria) this;
        }

        public Criteria andPayModeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_mode_id >=", value, "payModeId");
            return (Criteria) this;
        }

        public Criteria andPayModeIdLessThan(Long value) {
            addCriterion("pay_mode_id <", value, "payModeId");
            return (Criteria) this;
        }

        public Criteria andPayModeIdLessThanOrEqualTo(Long value) {
            addCriterion("pay_mode_id <=", value, "payModeId");
            return (Criteria) this;
        }

        public Criteria andPayModeIdIn(List<Long> values) {
            addCriterion("pay_mode_id in", values, "payModeId");
            return (Criteria) this;
        }

        public Criteria andPayModeIdNotIn(List<Long> values) {
            addCriterion("pay_mode_id not in", values, "payModeId");
            return (Criteria) this;
        }

        public Criteria andPayModeIdBetween(Long value1, Long value2) {
            addCriterion("pay_mode_id between", value1, value2, "payModeId");
            return (Criteria) this;
        }

        public Criteria andPayModeIdNotBetween(Long value1, Long value2) {
            addCriterion("pay_mode_id not between", value1, value2, "payModeId");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusIsNull() {
            addCriterion("pay_result_status is null");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusIsNotNull() {
            addCriterion("pay_result_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusEqualTo(String value) {
            addCriterion("pay_result_status =", value, "payResultStatus");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusNotEqualTo(String value) {
            addCriterion("pay_result_status <>", value, "payResultStatus");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusGreaterThan(String value) {
            addCriterion("pay_result_status >", value, "payResultStatus");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pay_result_status >=", value, "payResultStatus");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusLessThan(String value) {
            addCriterion("pay_result_status <", value, "payResultStatus");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusLessThanOrEqualTo(String value) {
            addCriterion("pay_result_status <=", value, "payResultStatus");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusLike(String value) {
            addCriterion("pay_result_status like", value, "payResultStatus");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusNotLike(String value) {
            addCriterion("pay_result_status not like", value, "payResultStatus");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusIn(List<String> values) {
            addCriterion("pay_result_status in", values, "payResultStatus");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusNotIn(List<String> values) {
            addCriterion("pay_result_status not in", values, "payResultStatus");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusBetween(String value1, String value2) {
            addCriterion("pay_result_status between", value1, value2, "payResultStatus");
            return (Criteria) this;
        }

        public Criteria andPayResultStatusNotBetween(String value1, String value2) {
            addCriterion("pay_result_status not between", value1, value2, "payResultStatus");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionIsNull() {
            addCriterion("pay_result_description is null");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionIsNotNull() {
            addCriterion("pay_result_description is not null");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionEqualTo(String value) {
            addCriterion("pay_result_description =", value, "payResultDescription");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionNotEqualTo(String value) {
            addCriterion("pay_result_description <>", value, "payResultDescription");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionGreaterThan(String value) {
            addCriterion("pay_result_description >", value, "payResultDescription");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("pay_result_description >=", value, "payResultDescription");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionLessThan(String value) {
            addCriterion("pay_result_description <", value, "payResultDescription");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionLessThanOrEqualTo(String value) {
            addCriterion("pay_result_description <=", value, "payResultDescription");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionLike(String value) {
            addCriterion("pay_result_description like", value, "payResultDescription");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionNotLike(String value) {
            addCriterion("pay_result_description not like", value, "payResultDescription");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionIn(List<String> values) {
            addCriterion("pay_result_description in", values, "payResultDescription");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionNotIn(List<String> values) {
            addCriterion("pay_result_description not in", values, "payResultDescription");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionBetween(String value1, String value2) {
            addCriterion("pay_result_description between", value1, value2, "payResultDescription");
            return (Criteria) this;
        }

        public Criteria andPayResultDescriptionNotBetween(String value1, String value2) {
            addCriterion("pay_result_description not between", value1, value2, "payResultDescription");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayResultProofIsNull() {
            addCriterion("pay_result_proof is null");
            return (Criteria) this;
        }

        public Criteria andPayResultProofIsNotNull() {
            addCriterion("pay_result_proof is not null");
            return (Criteria) this;
        }

        public Criteria andPayResultProofEqualTo(String value) {
            addCriterion("pay_result_proof =", value, "payResultProof");
            return (Criteria) this;
        }

        public Criteria andPayResultProofNotEqualTo(String value) {
            addCriterion("pay_result_proof <>", value, "payResultProof");
            return (Criteria) this;
        }

        public Criteria andPayResultProofGreaterThan(String value) {
            addCriterion("pay_result_proof >", value, "payResultProof");
            return (Criteria) this;
        }

        public Criteria andPayResultProofGreaterThanOrEqualTo(String value) {
            addCriterion("pay_result_proof >=", value, "payResultProof");
            return (Criteria) this;
        }

        public Criteria andPayResultProofLessThan(String value) {
            addCriterion("pay_result_proof <", value, "payResultProof");
            return (Criteria) this;
        }

        public Criteria andPayResultProofLessThanOrEqualTo(String value) {
            addCriterion("pay_result_proof <=", value, "payResultProof");
            return (Criteria) this;
        }

        public Criteria andPayResultProofLike(String value) {
            addCriterion("pay_result_proof like", value, "payResultProof");
            return (Criteria) this;
        }

        public Criteria andPayResultProofNotLike(String value) {
            addCriterion("pay_result_proof not like", value, "payResultProof");
            return (Criteria) this;
        }

        public Criteria andPayResultProofIn(List<String> values) {
            addCriterion("pay_result_proof in", values, "payResultProof");
            return (Criteria) this;
        }

        public Criteria andPayResultProofNotIn(List<String> values) {
            addCriterion("pay_result_proof not in", values, "payResultProof");
            return (Criteria) this;
        }

        public Criteria andPayResultProofBetween(String value1, String value2) {
            addCriterion("pay_result_proof between", value1, value2, "payResultProof");
            return (Criteria) this;
        }

        public Criteria andPayResultProofNotBetween(String value1, String value2) {
            addCriterion("pay_result_proof not between", value1, value2, "payResultProof");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayIsNull() {
            addCriterion("is_offline_pay is null");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayIsNotNull() {
            addCriterion("is_offline_pay is not null");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayEqualTo(String value) {
            addCriterion("is_offline_pay =", value, "isOfflinePay");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayNotEqualTo(String value) {
            addCriterion("is_offline_pay <>", value, "isOfflinePay");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayGreaterThan(String value) {
            addCriterion("is_offline_pay >", value, "isOfflinePay");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayGreaterThanOrEqualTo(String value) {
            addCriterion("is_offline_pay >=", value, "isOfflinePay");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayLessThan(String value) {
            addCriterion("is_offline_pay <", value, "isOfflinePay");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayLessThanOrEqualTo(String value) {
            addCriterion("is_offline_pay <=", value, "isOfflinePay");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayLike(String value) {
            addCriterion("is_offline_pay like", value, "isOfflinePay");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayNotLike(String value) {
            addCriterion("is_offline_pay not like", value, "isOfflinePay");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayIn(List<String> values) {
            addCriterion("is_offline_pay in", values, "isOfflinePay");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayNotIn(List<String> values) {
            addCriterion("is_offline_pay not in", values, "isOfflinePay");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayBetween(String value1, String value2) {
            addCriterion("is_offline_pay between", value1, value2, "isOfflinePay");
            return (Criteria) this;
        }

        public Criteria andIsOfflinePayNotBetween(String value1, String value2) {
            addCriterion("is_offline_pay not between", value1, value2, "isOfflinePay");
            return (Criteria) this;
        }

        public Criteria andMtcnCodeIdIsNull() {
            addCriterion("mtcn_code_id is null");
            return (Criteria) this;
        }

        public Criteria andMtcnCodeIdIsNotNull() {
            addCriterion("mtcn_code_id is not null");
            return (Criteria) this;
        }

        public Criteria andMtcnCodeIdEqualTo(Long value) {
            addCriterion("mtcn_code_id =", value, "mtcnCodeId");
            return (Criteria) this;
        }

        public Criteria andMtcnCodeIdNotEqualTo(Long value) {
            addCriterion("mtcn_code_id <>", value, "mtcnCodeId");
            return (Criteria) this;
        }

        public Criteria andMtcnCodeIdGreaterThan(Long value) {
            addCriterion("mtcn_code_id >", value, "mtcnCodeId");
            return (Criteria) this;
        }

        public Criteria andMtcnCodeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mtcn_code_id >=", value, "mtcnCodeId");
            return (Criteria) this;
        }

        public Criteria andMtcnCodeIdLessThan(Long value) {
            addCriterion("mtcn_code_id <", value, "mtcnCodeId");
            return (Criteria) this;
        }

        public Criteria andMtcnCodeIdLessThanOrEqualTo(Long value) {
            addCriterion("mtcn_code_id <=", value, "mtcnCodeId");
            return (Criteria) this;
        }

        public Criteria andMtcnCodeIdIn(List<Long> values) {
            addCriterion("mtcn_code_id in", values, "mtcnCodeId");
            return (Criteria) this;
        }

        public Criteria andMtcnCodeIdNotIn(List<Long> values) {
            addCriterion("mtcn_code_id not in", values, "mtcnCodeId");
            return (Criteria) this;
        }

        public Criteria andMtcnCodeIdBetween(Long value1, Long value2) {
            addCriterion("mtcn_code_id between", value1, value2, "mtcnCodeId");
            return (Criteria) this;
        }

        public Criteria andMtcnCodeIdNotBetween(Long value1, Long value2) {
            addCriterion("mtcn_code_id not between", value1, value2, "mtcnCodeId");
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