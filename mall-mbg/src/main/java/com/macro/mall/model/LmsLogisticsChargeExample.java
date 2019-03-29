package com.macro.mall.model;

import java.util.ArrayList;
import java.util.List;

public class LmsLogisticsChargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LmsLogisticsChargeExample() {
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

        public Criteria andTemplateIdIsNull() {
            addCriterion("template_id is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(Long value) {
            addCriterion("template_id =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(Long value) {
            addCriterion("template_id <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(Long value) {
            addCriterion("template_id >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("template_id >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(Long value) {
            addCriterion("template_id <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            addCriterion("template_id <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<Long> values) {
            addCriterion("template_id in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<Long> values) {
            addCriterion("template_id not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(Long value1, Long value2) {
            addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            addCriterion("template_id not between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andModeIdIsNull() {
            addCriterion("mode_id is null");
            return (Criteria) this;
        }

        public Criteria andModeIdIsNotNull() {
            addCriterion("mode_id is not null");
            return (Criteria) this;
        }

        public Criteria andModeIdEqualTo(Long value) {
            addCriterion("mode_id =", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotEqualTo(Long value) {
            addCriterion("mode_id <>", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdGreaterThan(Long value) {
            addCriterion("mode_id >", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mode_id >=", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdLessThan(Long value) {
            addCriterion("mode_id <", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdLessThanOrEqualTo(Long value) {
            addCriterion("mode_id <=", value, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdIn(List<Long> values) {
            addCriterion("mode_id in", values, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotIn(List<Long> values) {
            addCriterion("mode_id not in", values, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdBetween(Long value1, Long value2) {
            addCriterion("mode_id between", value1, value2, "modeId");
            return (Criteria) this;
        }

        public Criteria andModeIdNotBetween(Long value1, Long value2) {
            addCriterion("mode_id not between", value1, value2, "modeId");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNull() {
            addCriterion("send_id is null");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNotNull() {
            addCriterion("send_id is not null");
            return (Criteria) this;
        }

        public Criteria andSendIdEqualTo(Long value) {
            addCriterion("send_id =", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotEqualTo(Long value) {
            addCriterion("send_id <>", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThan(Long value) {
            addCriterion("send_id >", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThanOrEqualTo(Long value) {
            addCriterion("send_id >=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThan(Long value) {
            addCriterion("send_id <", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThanOrEqualTo(Long value) {
            addCriterion("send_id <=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdIn(List<Long> values) {
            addCriterion("send_id in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotIn(List<Long> values) {
            addCriterion("send_id not in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdBetween(Long value1, Long value2) {
            addCriterion("send_id between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotBetween(Long value1, Long value2) {
            addCriterion("send_id not between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendNameIsNull() {
            addCriterion("send_name is null");
            return (Criteria) this;
        }

        public Criteria andSendNameIsNotNull() {
            addCriterion("send_name is not null");
            return (Criteria) this;
        }

        public Criteria andSendNameEqualTo(String value) {
            addCriterion("send_name =", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameNotEqualTo(String value) {
            addCriterion("send_name <>", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameGreaterThan(String value) {
            addCriterion("send_name >", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameGreaterThanOrEqualTo(String value) {
            addCriterion("send_name >=", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameLessThan(String value) {
            addCriterion("send_name <", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameLessThanOrEqualTo(String value) {
            addCriterion("send_name <=", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameLike(String value) {
            addCriterion("send_name like", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameNotLike(String value) {
            addCriterion("send_name not like", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameIn(List<String> values) {
            addCriterion("send_name in", values, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameNotIn(List<String> values) {
            addCriterion("send_name not in", values, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameBetween(String value1, String value2) {
            addCriterion("send_name between", value1, value2, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameNotBetween(String value1, String value2) {
            addCriterion("send_name not between", value1, value2, "sendName");
            return (Criteria) this;
        }

        public Criteria andReceiptIdIsNull() {
            addCriterion("receipt_id is null");
            return (Criteria) this;
        }

        public Criteria andReceiptIdIsNotNull() {
            addCriterion("receipt_id is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptIdEqualTo(Long value) {
            addCriterion("receipt_id =", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdNotEqualTo(Long value) {
            addCriterion("receipt_id <>", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdGreaterThan(Long value) {
            addCriterion("receipt_id >", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdGreaterThanOrEqualTo(Long value) {
            addCriterion("receipt_id >=", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdLessThan(Long value) {
            addCriterion("receipt_id <", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdLessThanOrEqualTo(Long value) {
            addCriterion("receipt_id <=", value, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdIn(List<Long> values) {
            addCriterion("receipt_id in", values, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdNotIn(List<Long> values) {
            addCriterion("receipt_id not in", values, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdBetween(Long value1, Long value2) {
            addCriterion("receipt_id between", value1, value2, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptIdNotBetween(Long value1, Long value2) {
            addCriterion("receipt_id not between", value1, value2, "receiptId");
            return (Criteria) this;
        }

        public Criteria andReceiptNameIsNull() {
            addCriterion("receipt_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiptNameIsNotNull() {
            addCriterion("receipt_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptNameEqualTo(String value) {
            addCriterion("receipt_name =", value, "receiptName");
            return (Criteria) this;
        }

        public Criteria andReceiptNameNotEqualTo(String value) {
            addCriterion("receipt_name <>", value, "receiptName");
            return (Criteria) this;
        }

        public Criteria andReceiptNameGreaterThan(String value) {
            addCriterion("receipt_name >", value, "receiptName");
            return (Criteria) this;
        }

        public Criteria andReceiptNameGreaterThanOrEqualTo(String value) {
            addCriterion("receipt_name >=", value, "receiptName");
            return (Criteria) this;
        }

        public Criteria andReceiptNameLessThan(String value) {
            addCriterion("receipt_name <", value, "receiptName");
            return (Criteria) this;
        }

        public Criteria andReceiptNameLessThanOrEqualTo(String value) {
            addCriterion("receipt_name <=", value, "receiptName");
            return (Criteria) this;
        }

        public Criteria andReceiptNameLike(String value) {
            addCriterion("receipt_name like", value, "receiptName");
            return (Criteria) this;
        }

        public Criteria andReceiptNameNotLike(String value) {
            addCriterion("receipt_name not like", value, "receiptName");
            return (Criteria) this;
        }

        public Criteria andReceiptNameIn(List<String> values) {
            addCriterion("receipt_name in", values, "receiptName");
            return (Criteria) this;
        }

        public Criteria andReceiptNameNotIn(List<String> values) {
            addCriterion("receipt_name not in", values, "receiptName");
            return (Criteria) this;
        }

        public Criteria andReceiptNameBetween(String value1, String value2) {
            addCriterion("receipt_name between", value1, value2, "receiptName");
            return (Criteria) this;
        }

        public Criteria andReceiptNameNotBetween(String value1, String value2) {
            addCriterion("receipt_name not between", value1, value2, "receiptName");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNull() {
            addCriterion("charge_type is null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNotNull() {
            addCriterion("charge_type is not null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeEqualTo(String value) {
            addCriterion("charge_type =", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotEqualTo(String value) {
            addCriterion("charge_type <>", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThan(String value) {
            addCriterion("charge_type >", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("charge_type >=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThan(String value) {
            addCriterion("charge_type <", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThanOrEqualTo(String value) {
            addCriterion("charge_type <=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLike(String value) {
            addCriterion("charge_type like", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotLike(String value) {
            addCriterion("charge_type not like", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIn(List<String> values) {
            addCriterion("charge_type in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotIn(List<String> values) {
            addCriterion("charge_type not in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeBetween(String value1, String value2) {
            addCriterion("charge_type between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotBetween(String value1, String value2) {
            addCriterion("charge_type not between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andLessThanNIsNull() {
            addCriterion("less_than_n is null");
            return (Criteria) this;
        }

        public Criteria andLessThanNIsNotNull() {
            addCriterion("less_than_n is not null");
            return (Criteria) this;
        }

        public Criteria andLessThanNEqualTo(Integer value) {
            addCriterion("less_than_n =", value, "lessThanN");
            return (Criteria) this;
        }

        public Criteria andLessThanNNotEqualTo(Integer value) {
            addCriterion("less_than_n <>", value, "lessThanN");
            return (Criteria) this;
        }

        public Criteria andLessThanNGreaterThan(Integer value) {
            addCriterion("less_than_n >", value, "lessThanN");
            return (Criteria) this;
        }

        public Criteria andLessThanNGreaterThanOrEqualTo(Integer value) {
            addCriterion("less_than_n >=", value, "lessThanN");
            return (Criteria) this;
        }

        public Criteria andLessThanNLessThan(Integer value) {
            addCriterion("less_than_n <", value, "lessThanN");
            return (Criteria) this;
        }

        public Criteria andLessThanNLessThanOrEqualTo(Integer value) {
            addCriterion("less_than_n <=", value, "lessThanN");
            return (Criteria) this;
        }

        public Criteria andLessThanNIn(List<Integer> values) {
            addCriterion("less_than_n in", values, "lessThanN");
            return (Criteria) this;
        }

        public Criteria andLessThanNNotIn(List<Integer> values) {
            addCriterion("less_than_n not in", values, "lessThanN");
            return (Criteria) this;
        }

        public Criteria andLessThanNBetween(Integer value1, Integer value2) {
            addCriterion("less_than_n between", value1, value2, "lessThanN");
            return (Criteria) this;
        }

        public Criteria andLessThanNNotBetween(Integer value1, Integer value2) {
            addCriterion("less_than_n not between", value1, value2, "lessThanN");
            return (Criteria) this;
        }

        public Criteria andLessThanNChargeIsNull() {
            addCriterion("less_than_n_charge is null");
            return (Criteria) this;
        }

        public Criteria andLessThanNChargeIsNotNull() {
            addCriterion("less_than_n_charge is not null");
            return (Criteria) this;
        }

        public Criteria andLessThanNChargeEqualTo(Integer value) {
            addCriterion("less_than_n_charge =", value, "lessThanNCharge");
            return (Criteria) this;
        }

        public Criteria andLessThanNChargeNotEqualTo(Integer value) {
            addCriterion("less_than_n_charge <>", value, "lessThanNCharge");
            return (Criteria) this;
        }

        public Criteria andLessThanNChargeGreaterThan(Integer value) {
            addCriterion("less_than_n_charge >", value, "lessThanNCharge");
            return (Criteria) this;
        }

        public Criteria andLessThanNChargeGreaterThanOrEqualTo(Integer value) {
            addCriterion("less_than_n_charge >=", value, "lessThanNCharge");
            return (Criteria) this;
        }

        public Criteria andLessThanNChargeLessThan(Integer value) {
            addCriterion("less_than_n_charge <", value, "lessThanNCharge");
            return (Criteria) this;
        }

        public Criteria andLessThanNChargeLessThanOrEqualTo(Integer value) {
            addCriterion("less_than_n_charge <=", value, "lessThanNCharge");
            return (Criteria) this;
        }

        public Criteria andLessThanNChargeIn(List<Integer> values) {
            addCriterion("less_than_n_charge in", values, "lessThanNCharge");
            return (Criteria) this;
        }

        public Criteria andLessThanNChargeNotIn(List<Integer> values) {
            addCriterion("less_than_n_charge not in", values, "lessThanNCharge");
            return (Criteria) this;
        }

        public Criteria andLessThanNChargeBetween(Integer value1, Integer value2) {
            addCriterion("less_than_n_charge between", value1, value2, "lessThanNCharge");
            return (Criteria) this;
        }

        public Criteria andLessThanNChargeNotBetween(Integer value1, Integer value2) {
            addCriterion("less_than_n_charge not between", value1, value2, "lessThanNCharge");
            return (Criteria) this;
        }

        public Criteria andEachAddNIsNull() {
            addCriterion("each_add_n is null");
            return (Criteria) this;
        }

        public Criteria andEachAddNIsNotNull() {
            addCriterion("each_add_n is not null");
            return (Criteria) this;
        }

        public Criteria andEachAddNEqualTo(Integer value) {
            addCriterion("each_add_n =", value, "eachAddN");
            return (Criteria) this;
        }

        public Criteria andEachAddNNotEqualTo(Integer value) {
            addCriterion("each_add_n <>", value, "eachAddN");
            return (Criteria) this;
        }

        public Criteria andEachAddNGreaterThan(Integer value) {
            addCriterion("each_add_n >", value, "eachAddN");
            return (Criteria) this;
        }

        public Criteria andEachAddNGreaterThanOrEqualTo(Integer value) {
            addCriterion("each_add_n >=", value, "eachAddN");
            return (Criteria) this;
        }

        public Criteria andEachAddNLessThan(Integer value) {
            addCriterion("each_add_n <", value, "eachAddN");
            return (Criteria) this;
        }

        public Criteria andEachAddNLessThanOrEqualTo(Integer value) {
            addCriterion("each_add_n <=", value, "eachAddN");
            return (Criteria) this;
        }

        public Criteria andEachAddNIn(List<Integer> values) {
            addCriterion("each_add_n in", values, "eachAddN");
            return (Criteria) this;
        }

        public Criteria andEachAddNNotIn(List<Integer> values) {
            addCriterion("each_add_n not in", values, "eachAddN");
            return (Criteria) this;
        }

        public Criteria andEachAddNBetween(Integer value1, Integer value2) {
            addCriterion("each_add_n between", value1, value2, "eachAddN");
            return (Criteria) this;
        }

        public Criteria andEachAddNNotBetween(Integer value1, Integer value2) {
            addCriterion("each_add_n not between", value1, value2, "eachAddN");
            return (Criteria) this;
        }

        public Criteria andEachAddNChargeIsNull() {
            addCriterion("each_add_n_charge is null");
            return (Criteria) this;
        }

        public Criteria andEachAddNChargeIsNotNull() {
            addCriterion("each_add_n_charge is not null");
            return (Criteria) this;
        }

        public Criteria andEachAddNChargeEqualTo(Integer value) {
            addCriterion("each_add_n_charge =", value, "eachAddNCharge");
            return (Criteria) this;
        }

        public Criteria andEachAddNChargeNotEqualTo(Integer value) {
            addCriterion("each_add_n_charge <>", value, "eachAddNCharge");
            return (Criteria) this;
        }

        public Criteria andEachAddNChargeGreaterThan(Integer value) {
            addCriterion("each_add_n_charge >", value, "eachAddNCharge");
            return (Criteria) this;
        }

        public Criteria andEachAddNChargeGreaterThanOrEqualTo(Integer value) {
            addCriterion("each_add_n_charge >=", value, "eachAddNCharge");
            return (Criteria) this;
        }

        public Criteria andEachAddNChargeLessThan(Integer value) {
            addCriterion("each_add_n_charge <", value, "eachAddNCharge");
            return (Criteria) this;
        }

        public Criteria andEachAddNChargeLessThanOrEqualTo(Integer value) {
            addCriterion("each_add_n_charge <=", value, "eachAddNCharge");
            return (Criteria) this;
        }

        public Criteria andEachAddNChargeIn(List<Integer> values) {
            addCriterion("each_add_n_charge in", values, "eachAddNCharge");
            return (Criteria) this;
        }

        public Criteria andEachAddNChargeNotIn(List<Integer> values) {
            addCriterion("each_add_n_charge not in", values, "eachAddNCharge");
            return (Criteria) this;
        }

        public Criteria andEachAddNChargeBetween(Integer value1, Integer value2) {
            addCriterion("each_add_n_charge between", value1, value2, "eachAddNCharge");
            return (Criteria) this;
        }

        public Criteria andEachAddNChargeNotBetween(Integer value1, Integer value2) {
            addCriterion("each_add_n_charge not between", value1, value2, "eachAddNCharge");
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