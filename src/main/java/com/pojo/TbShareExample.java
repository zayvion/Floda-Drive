package com.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbShareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbShareExample() {
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

        public Criteria andShareIdIsNull() {
            addCriterion("share_id is null");
            return (Criteria) this;
        }

        public Criteria andShareIdIsNotNull() {
            addCriterion("share_id is not null");
            return (Criteria) this;
        }

        public Criteria andShareIdEqualTo(Long value) {
            addCriterion("share_id =", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotEqualTo(Long value) {
            addCriterion("share_id <>", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThan(Long value) {
            addCriterion("share_id >", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThanOrEqualTo(Long value) {
            addCriterion("share_id >=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThan(Long value) {
            addCriterion("share_id <", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThanOrEqualTo(Long value) {
            addCriterion("share_id <=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdIn(List<Long> values) {
            addCriterion("share_id in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotIn(List<Long> values) {
            addCriterion("share_id not in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdBetween(Long value1, Long value2) {
            addCriterion("share_id between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotBetween(Long value1, Long value2) {
            addCriterion("share_id not between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareUserIsNull() {
            addCriterion("share_user is null");
            return (Criteria) this;
        }

        public Criteria andShareUserIsNotNull() {
            addCriterion("share_user is not null");
            return (Criteria) this;
        }

        public Criteria andShareUserEqualTo(Long value) {
            addCriterion("share_user =", value, "shareUser");
            return (Criteria) this;
        }

        public Criteria andShareUserNotEqualTo(Long value) {
            addCriterion("share_user <>", value, "shareUser");
            return (Criteria) this;
        }

        public Criteria andShareUserGreaterThan(Long value) {
            addCriterion("share_user >", value, "shareUser");
            return (Criteria) this;
        }

        public Criteria andShareUserGreaterThanOrEqualTo(Long value) {
            addCriterion("share_user >=", value, "shareUser");
            return (Criteria) this;
        }

        public Criteria andShareUserLessThan(Long value) {
            addCriterion("share_user <", value, "shareUser");
            return (Criteria) this;
        }

        public Criteria andShareUserLessThanOrEqualTo(Long value) {
            addCriterion("share_user <=", value, "shareUser");
            return (Criteria) this;
        }

        public Criteria andShareUserIn(List<Long> values) {
            addCriterion("share_user in", values, "shareUser");
            return (Criteria) this;
        }

        public Criteria andShareUserNotIn(List<Long> values) {
            addCriterion("share_user not in", values, "shareUser");
            return (Criteria) this;
        }

        public Criteria andShareUserBetween(Long value1, Long value2) {
            addCriterion("share_user between", value1, value2, "shareUser");
            return (Criteria) this;
        }

        public Criteria andShareUserNotBetween(Long value1, Long value2) {
            addCriterion("share_user not between", value1, value2, "shareUser");
            return (Criteria) this;
        }

        public Criteria andShareCommentIsNull() {
            addCriterion("share_comment is null");
            return (Criteria) this;
        }

        public Criteria andShareCommentIsNotNull() {
            addCriterion("share_comment is not null");
            return (Criteria) this;
        }

        public Criteria andShareCommentEqualTo(String value) {
            addCriterion("share_comment =", value, "shareComment");
            return (Criteria) this;
        }

        public Criteria andShareCommentNotEqualTo(String value) {
            addCriterion("share_comment <>", value, "shareComment");
            return (Criteria) this;
        }

        public Criteria andShareCommentGreaterThan(String value) {
            addCriterion("share_comment >", value, "shareComment");
            return (Criteria) this;
        }

        public Criteria andShareCommentGreaterThanOrEqualTo(String value) {
            addCriterion("share_comment >=", value, "shareComment");
            return (Criteria) this;
        }

        public Criteria andShareCommentLessThan(String value) {
            addCriterion("share_comment <", value, "shareComment");
            return (Criteria) this;
        }

        public Criteria andShareCommentLessThanOrEqualTo(String value) {
            addCriterion("share_comment <=", value, "shareComment");
            return (Criteria) this;
        }

        public Criteria andShareCommentLike(String value) {
            addCriterion("share_comment like", value, "shareComment");
            return (Criteria) this;
        }

        public Criteria andShareCommentNotLike(String value) {
            addCriterion("share_comment not like", value, "shareComment");
            return (Criteria) this;
        }

        public Criteria andShareCommentIn(List<String> values) {
            addCriterion("share_comment in", values, "shareComment");
            return (Criteria) this;
        }

        public Criteria andShareCommentNotIn(List<String> values) {
            addCriterion("share_comment not in", values, "shareComment");
            return (Criteria) this;
        }

        public Criteria andShareCommentBetween(String value1, String value2) {
            addCriterion("share_comment between", value1, value2, "shareComment");
            return (Criteria) this;
        }

        public Criteria andShareCommentNotBetween(String value1, String value2) {
            addCriterion("share_comment not between", value1, value2, "shareComment");
            return (Criteria) this;
        }

        public Criteria andShareTitleIsNull() {
            addCriterion("share_title is null");
            return (Criteria) this;
        }

        public Criteria andShareTitleIsNotNull() {
            addCriterion("share_title is not null");
            return (Criteria) this;
        }

        public Criteria andShareTitleEqualTo(String value) {
            addCriterion("share_title =", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotEqualTo(String value) {
            addCriterion("share_title <>", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleGreaterThan(String value) {
            addCriterion("share_title >", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleGreaterThanOrEqualTo(String value) {
            addCriterion("share_title >=", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLessThan(String value) {
            addCriterion("share_title <", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLessThanOrEqualTo(String value) {
            addCriterion("share_title <=", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLike(String value) {
            addCriterion("share_title like", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotLike(String value) {
            addCriterion("share_title not like", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleIn(List<String> values) {
            addCriterion("share_title in", values, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotIn(List<String> values) {
            addCriterion("share_title not in", values, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleBetween(String value1, String value2) {
            addCriterion("share_title between", value1, value2, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotBetween(String value1, String value2) {
            addCriterion("share_title not between", value1, value2, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareUrlIsNull() {
            addCriterion("share_url is null");
            return (Criteria) this;
        }

        public Criteria andShareUrlIsNotNull() {
            addCriterion("share_url is not null");
            return (Criteria) this;
        }

        public Criteria andShareUrlEqualTo(String value) {
            addCriterion("share_url =", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotEqualTo(String value) {
            addCriterion("share_url <>", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThan(String value) {
            addCriterion("share_url >", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThanOrEqualTo(String value) {
            addCriterion("share_url >=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThan(String value) {
            addCriterion("share_url <", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThanOrEqualTo(String value) {
            addCriterion("share_url <=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLike(String value) {
            addCriterion("share_url like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotLike(String value) {
            addCriterion("share_url not like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlIn(List<String> values) {
            addCriterion("share_url in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotIn(List<String> values) {
            addCriterion("share_url not in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlBetween(String value1, String value2) {
            addCriterion("share_url between", value1, value2, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotBetween(String value1, String value2) {
            addCriterion("share_url not between", value1, value2, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareDateIsNull() {
            addCriterion("share_date is null");
            return (Criteria) this;
        }

        public Criteria andShareDateIsNotNull() {
            addCriterion("share_date is not null");
            return (Criteria) this;
        }

        public Criteria andShareDateEqualTo(Date value) {
            addCriterion("share_date =", value, "shareDate");
            return (Criteria) this;
        }

        public Criteria andShareDateNotEqualTo(Date value) {
            addCriterion("share_date <>", value, "shareDate");
            return (Criteria) this;
        }

        public Criteria andShareDateGreaterThan(Date value) {
            addCriterion("share_date >", value, "shareDate");
            return (Criteria) this;
        }

        public Criteria andShareDateGreaterThanOrEqualTo(Date value) {
            addCriterion("share_date >=", value, "shareDate");
            return (Criteria) this;
        }

        public Criteria andShareDateLessThan(Date value) {
            addCriterion("share_date <", value, "shareDate");
            return (Criteria) this;
        }

        public Criteria andShareDateLessThanOrEqualTo(Date value) {
            addCriterion("share_date <=", value, "shareDate");
            return (Criteria) this;
        }

        public Criteria andShareDateIn(List<Date> values) {
            addCriterion("share_date in", values, "shareDate");
            return (Criteria) this;
        }

        public Criteria andShareDateNotIn(List<Date> values) {
            addCriterion("share_date not in", values, "shareDate");
            return (Criteria) this;
        }

        public Criteria andShareDateBetween(Date value1, Date value2) {
            addCriterion("share_date between", value1, value2, "shareDate");
            return (Criteria) this;
        }

        public Criteria andShareDateNotBetween(Date value1, Date value2) {
            addCriterion("share_date not between", value1, value2, "shareDate");
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