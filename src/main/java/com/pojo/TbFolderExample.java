package com.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbFolderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFolderExample() {
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

        public Criteria andFolderIdIsNull() {
            addCriterion("folder_id is null");
            return (Criteria) this;
        }

        public Criteria andFolderIdIsNotNull() {
            addCriterion("folder_id is not null");
            return (Criteria) this;
        }

        public Criteria andFolderIdEqualTo(Long value) {
            addCriterion("folder_id =", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdNotEqualTo(Long value) {
            addCriterion("folder_id <>", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdGreaterThan(Long value) {
            addCriterion("folder_id >", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("folder_id >=", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdLessThan(Long value) {
            addCriterion("folder_id <", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdLessThanOrEqualTo(Long value) {
            addCriterion("folder_id <=", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdIn(List<Long> values) {
            addCriterion("folder_id in", values, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdNotIn(List<Long> values) {
            addCriterion("folder_id not in", values, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdBetween(Long value1, Long value2) {
            addCriterion("folder_id between", value1, value2, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdNotBetween(Long value1, Long value2) {
            addCriterion("folder_id not between", value1, value2, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderNameIsNull() {
            addCriterion("folder_name is null");
            return (Criteria) this;
        }

        public Criteria andFolderNameIsNotNull() {
            addCriterion("folder_name is not null");
            return (Criteria) this;
        }

        public Criteria andFolderNameEqualTo(String value) {
            addCriterion("folder_name =", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameNotEqualTo(String value) {
            addCriterion("folder_name <>", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameGreaterThan(String value) {
            addCriterion("folder_name >", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameGreaterThanOrEqualTo(String value) {
            addCriterion("folder_name >=", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameLessThan(String value) {
            addCriterion("folder_name <", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameLessThanOrEqualTo(String value) {
            addCriterion("folder_name <=", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameLike(String value) {
            addCriterion("folder_name like", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameNotLike(String value) {
            addCriterion("folder_name not like", value, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameIn(List<String> values) {
            addCriterion("folder_name in", values, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameNotIn(List<String> values) {
            addCriterion("folder_name not in", values, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameBetween(String value1, String value2) {
            addCriterion("folder_name between", value1, value2, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderNameNotBetween(String value1, String value2) {
            addCriterion("folder_name not between", value1, value2, "folderName");
            return (Criteria) this;
        }

        public Criteria andFolderFatherIsNull() {
            addCriterion("folder_father is null");
            return (Criteria) this;
        }

        public Criteria andFolderFatherIsNotNull() {
            addCriterion("folder_father is not null");
            return (Criteria) this;
        }

        public Criteria andFolderFatherEqualTo(Long value) {
            addCriterion("folder_father =", value, "folderFather");
            return (Criteria) this;
        }

        public Criteria andFolderFatherNotEqualTo(Long value) {
            addCriterion("folder_father <>", value, "folderFather");
            return (Criteria) this;
        }

        public Criteria andFolderFatherGreaterThan(Long value) {
            addCriterion("folder_father >", value, "folderFather");
            return (Criteria) this;
        }

        public Criteria andFolderFatherGreaterThanOrEqualTo(Long value) {
            addCriterion("folder_father >=", value, "folderFather");
            return (Criteria) this;
        }

        public Criteria andFolderFatherLessThan(Long value) {
            addCriterion("folder_father <", value, "folderFather");
            return (Criteria) this;
        }

        public Criteria andFolderFatherLessThanOrEqualTo(Long value) {
            addCriterion("folder_father <=", value, "folderFather");
            return (Criteria) this;
        }

        public Criteria andFolderFatherIn(List<Long> values) {
            addCriterion("folder_father in", values, "folderFather");
            return (Criteria) this;
        }

        public Criteria andFolderFatherNotIn(List<Long> values) {
            addCriterion("folder_father not in", values, "folderFather");
            return (Criteria) this;
        }

        public Criteria andFolderFatherBetween(Long value1, Long value2) {
            addCriterion("folder_father between", value1, value2, "folderFather");
            return (Criteria) this;
        }

        public Criteria andFolderFatherNotBetween(Long value1, Long value2) {
            addCriterion("folder_father not between", value1, value2, "folderFather");
            return (Criteria) this;
        }

        public Criteria andFolderUserIsNull() {
            addCriterion("folder_user is null");
            return (Criteria) this;
        }

        public Criteria andFolderUserIsNotNull() {
            addCriterion("folder_user is not null");
            return (Criteria) this;
        }

        public Criteria andFolderUserEqualTo(Long value) {
            addCriterion("folder_user =", value, "folderUser");
            return (Criteria) this;
        }

        public Criteria andFolderUserNotEqualTo(Long value) {
            addCriterion("folder_user <>", value, "folderUser");
            return (Criteria) this;
        }

        public Criteria andFolderUserGreaterThan(Long value) {
            addCriterion("folder_user >", value, "folderUser");
            return (Criteria) this;
        }

        public Criteria andFolderUserGreaterThanOrEqualTo(Long value) {
            addCriterion("folder_user >=", value, "folderUser");
            return (Criteria) this;
        }

        public Criteria andFolderUserLessThan(Long value) {
            addCriterion("folder_user <", value, "folderUser");
            return (Criteria) this;
        }

        public Criteria andFolderUserLessThanOrEqualTo(Long value) {
            addCriterion("folder_user <=", value, "folderUser");
            return (Criteria) this;
        }

        public Criteria andFolderUserIn(List<Long> values) {
            addCriterion("folder_user in", values, "folderUser");
            return (Criteria) this;
        }

        public Criteria andFolderUserNotIn(List<Long> values) {
            addCriterion("folder_user not in", values, "folderUser");
            return (Criteria) this;
        }

        public Criteria andFolderUserBetween(Long value1, Long value2) {
            addCriterion("folder_user between", value1, value2, "folderUser");
            return (Criteria) this;
        }

        public Criteria andFolderUserNotBetween(Long value1, Long value2) {
            addCriterion("folder_user not between", value1, value2, "folderUser");
            return (Criteria) this;
        }

        public Criteria andFolderCreatetimeIsNull() {
            addCriterion("folder_createtime is null");
            return (Criteria) this;
        }

        public Criteria andFolderCreatetimeIsNotNull() {
            addCriterion("folder_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andFolderCreatetimeEqualTo(Date value) {
            addCriterion("folder_createtime =", value, "folderCreatetime");
            return (Criteria) this;
        }

        public Criteria andFolderCreatetimeNotEqualTo(Date value) {
            addCriterion("folder_createtime <>", value, "folderCreatetime");
            return (Criteria) this;
        }

        public Criteria andFolderCreatetimeGreaterThan(Date value) {
            addCriterion("folder_createtime >", value, "folderCreatetime");
            return (Criteria) this;
        }

        public Criteria andFolderCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("folder_createtime >=", value, "folderCreatetime");
            return (Criteria) this;
        }

        public Criteria andFolderCreatetimeLessThan(Date value) {
            addCriterion("folder_createtime <", value, "folderCreatetime");
            return (Criteria) this;
        }

        public Criteria andFolderCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("folder_createtime <=", value, "folderCreatetime");
            return (Criteria) this;
        }

        public Criteria andFolderCreatetimeIn(List<Date> values) {
            addCriterion("folder_createtime in", values, "folderCreatetime");
            return (Criteria) this;
        }

        public Criteria andFolderCreatetimeNotIn(List<Date> values) {
            addCriterion("folder_createtime not in", values, "folderCreatetime");
            return (Criteria) this;
        }

        public Criteria andFolderCreatetimeBetween(Date value1, Date value2) {
            addCriterion("folder_createtime between", value1, value2, "folderCreatetime");
            return (Criteria) this;
        }

        public Criteria andFolderCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("folder_createtime not between", value1, value2, "folderCreatetime");
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