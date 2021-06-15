package com.iscas.biz.domain.common;

import java.util.ArrayList;
import java.util.List;

public class WsDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WsDataExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNull() {
            addCriterion("msg_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNotNull() {
            addCriterion("msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIdEqualTo(String value) {
            addCriterion("msg_id =", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotEqualTo(String value) {
            addCriterion("msg_id <>", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThan(String value) {
            addCriterion("msg_id >", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThanOrEqualTo(String value) {
            addCriterion("msg_id >=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThan(String value) {
            addCriterion("msg_id <", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThanOrEqualTo(String value) {
            addCriterion("msg_id <=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLike(String value) {
            addCriterion("msg_id like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotLike(String value) {
            addCriterion("msg_id not like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdIn(List<String> values) {
            addCriterion("msg_id in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotIn(List<String> values) {
            addCriterion("msg_id not in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdBetween(String value1, String value2) {
            addCriterion("msg_id between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotBetween(String value1, String value2) {
            addCriterion("msg_id not between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyIsNull() {
            addCriterion("user_identify is null");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyIsNotNull() {
            addCriterion("user_identify is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyEqualTo(String value) {
            addCriterion("user_identify =", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyNotEqualTo(String value) {
            addCriterion("user_identify <>", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyGreaterThan(String value) {
            addCriterion("user_identify >", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyGreaterThanOrEqualTo(String value) {
            addCriterion("user_identify >=", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyLessThan(String value) {
            addCriterion("user_identify <", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyLessThanOrEqualTo(String value) {
            addCriterion("user_identify <=", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyLike(String value) {
            addCriterion("user_identify like", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyNotLike(String value) {
            addCriterion("user_identify not like", value, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyIn(List<String> values) {
            addCriterion("user_identify in", values, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyNotIn(List<String> values) {
            addCriterion("user_identify not in", values, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyBetween(String value1, String value2) {
            addCriterion("user_identify between", value1, value2, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andUserIdentifyNotBetween(String value1, String value2) {
            addCriterion("user_identify not between", value1, value2, "userIdentify");
            return (Criteria) this;
        }

        public Criteria andPersistentIsNull() {
            addCriterion("persistent is null");
            return (Criteria) this;
        }

        public Criteria andPersistentIsNotNull() {
            addCriterion("persistent is not null");
            return (Criteria) this;
        }

        public Criteria andPersistentEqualTo(Boolean value) {
            addCriterion("persistent =", value, "persistent");
            return (Criteria) this;
        }

        public Criteria andPersistentNotEqualTo(Boolean value) {
            addCriterion("persistent <>", value, "persistent");
            return (Criteria) this;
        }

        public Criteria andPersistentGreaterThan(Boolean value) {
            addCriterion("persistent >", value, "persistent");
            return (Criteria) this;
        }

        public Criteria andPersistentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("persistent >=", value, "persistent");
            return (Criteria) this;
        }

        public Criteria andPersistentLessThan(Boolean value) {
            addCriterion("persistent <", value, "persistent");
            return (Criteria) this;
        }

        public Criteria andPersistentLessThanOrEqualTo(Boolean value) {
            addCriterion("persistent <=", value, "persistent");
            return (Criteria) this;
        }

        public Criteria andPersistentIn(List<Boolean> values) {
            addCriterion("persistent in", values, "persistent");
            return (Criteria) this;
        }

        public Criteria andPersistentNotIn(List<Boolean> values) {
            addCriterion("persistent not in", values, "persistent");
            return (Criteria) this;
        }

        public Criteria andPersistentBetween(Boolean value1, Boolean value2) {
            addCriterion("persistent between", value1, value2, "persistent");
            return (Criteria) this;
        }

        public Criteria andPersistentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("persistent not between", value1, value2, "persistent");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNull() {
            addCriterion("destination is null");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNotNull() {
            addCriterion("destination is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationEqualTo(String value) {
            addCriterion("destination =", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotEqualTo(String value) {
            addCriterion("destination <>", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThan(String value) {
            addCriterion("destination >", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("destination >=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThan(String value) {
            addCriterion("destination <", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThanOrEqualTo(String value) {
            addCriterion("destination <=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLike(String value) {
            addCriterion("destination like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotLike(String value) {
            addCriterion("destination not like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationIn(List<String> values) {
            addCriterion("destination in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotIn(List<String> values) {
            addCriterion("destination not in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationBetween(String value1, String value2) {
            addCriterion("destination between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotBetween(String value1, String value2) {
            addCriterion("destination not between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andAckIsNull() {
            addCriterion("ack is null");
            return (Criteria) this;
        }

        public Criteria andAckIsNotNull() {
            addCriterion("ack is not null");
            return (Criteria) this;
        }

        public Criteria andAckEqualTo(Boolean value) {
            addCriterion("ack =", value, "ack");
            return (Criteria) this;
        }

        public Criteria andAckNotEqualTo(Boolean value) {
            addCriterion("ack <>", value, "ack");
            return (Criteria) this;
        }

        public Criteria andAckGreaterThan(Boolean value) {
            addCriterion("ack >", value, "ack");
            return (Criteria) this;
        }

        public Criteria andAckGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ack >=", value, "ack");
            return (Criteria) this;
        }

        public Criteria andAckLessThan(Boolean value) {
            addCriterion("ack <", value, "ack");
            return (Criteria) this;
        }

        public Criteria andAckLessThanOrEqualTo(Boolean value) {
            addCriterion("ack <=", value, "ack");
            return (Criteria) this;
        }

        public Criteria andAckIn(List<Boolean> values) {
            addCriterion("ack in", values, "ack");
            return (Criteria) this;
        }

        public Criteria andAckNotIn(List<Boolean> values) {
            addCriterion("ack not in", values, "ack");
            return (Criteria) this;
        }

        public Criteria andAckBetween(Boolean value1, Boolean value2) {
            addCriterion("ack between", value1, value2, "ack");
            return (Criteria) this;
        }

        public Criteria andAckNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ack not between", value1, value2, "ack");
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