package com.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbUserFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserFileExample() {
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

        public Criteria andUserfileIdIsNull() {
            addCriterion("userfile_id is null");
            return (Criteria) this;
        }

        public Criteria andUserfileIdIsNotNull() {
            addCriterion("userfile_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserfileIdEqualTo(Long value) {
            addCriterion("userfile_id =", value, "userfileId");
            return (Criteria) this;
        }

        public Criteria andUserfileIdNotEqualTo(Long value) {
            addCriterion("userfile_id <>", value, "userfileId");
            return (Criteria) this;
        }

        public Criteria andUserfileIdGreaterThan(Long value) {
            addCriterion("userfile_id >", value, "userfileId");
            return (Criteria) this;
        }

        public Criteria andUserfileIdGreaterThanOrEqualTo(Long value) {
            addCriterion("userfile_id >=", value, "userfileId");
            return (Criteria) this;
        }

        public Criteria andUserfileIdLessThan(Long value) {
            addCriterion("userfile_id <", value, "userfileId");
            return (Criteria) this;
        }

        public Criteria andUserfileIdLessThanOrEqualTo(Long value) {
            addCriterion("userfile_id <=", value, "userfileId");
            return (Criteria) this;
        }

        public Criteria andUserfileIdIn(List<Long> values) {
            addCriterion("userfile_id in", values, "userfileId");
            return (Criteria) this;
        }

        public Criteria andUserfileIdNotIn(List<Long> values) {
            addCriterion("userfile_id not in", values, "userfileId");
            return (Criteria) this;
        }

        public Criteria andUserfileIdBetween(Long value1, Long value2) {
            addCriterion("userfile_id between", value1, value2, "userfileId");
            return (Criteria) this;
        }

        public Criteria andUserfileIdNotBetween(Long value1, Long value2) {
            addCriterion("userfile_id not between", value1, value2, "userfileId");
            return (Criteria) this;
        }

        public Criteria andUserFileNameIsNull() {
            addCriterion("user_file_name is null");
            return (Criteria) this;
        }

        public Criteria andUserFileNameIsNotNull() {
            addCriterion("user_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserFileNameEqualTo(String value) {
            addCriterion("user_file_name =", value, "userFileName");
            return (Criteria) this;
        }

        public Criteria andUserFileNameNotEqualTo(String value) {
            addCriterion("user_file_name <>", value, "userFileName");
            return (Criteria) this;
        }

        public Criteria andUserFileNameGreaterThan(String value) {
            addCriterion("user_file_name >", value, "userFileName");
            return (Criteria) this;
        }

        public Criteria andUserFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_file_name >=", value, "userFileName");
            return (Criteria) this;
        }

        public Criteria andUserFileNameLessThan(String value) {
            addCriterion("user_file_name <", value, "userFileName");
            return (Criteria) this;
        }

        public Criteria andUserFileNameLessThanOrEqualTo(String value) {
            addCriterion("user_file_name <=", value, "userFileName");
            return (Criteria) this;
        }

        public Criteria andUserFileNameLike(String value) {
            addCriterion("user_file_name like", value, "userFileName");
            return (Criteria) this;
        }

        public Criteria andUserFileNameNotLike(String value) {
            addCriterion("user_file_name not like", value, "userFileName");
            return (Criteria) this;
        }

        public Criteria andUserFileNameIn(List<String> values) {
            addCriterion("user_file_name in", values, "userFileName");
            return (Criteria) this;
        }

        public Criteria andUserFileNameNotIn(List<String> values) {
            addCriterion("user_file_name not in", values, "userFileName");
            return (Criteria) this;
        }

        public Criteria andUserFileNameBetween(String value1, String value2) {
            addCriterion("user_file_name between", value1, value2, "userFileName");
            return (Criteria) this;
        }

        public Criteria andUserFileNameNotBetween(String value1, String value2) {
            addCriterion("user_file_name not between", value1, value2, "userFileName");
            return (Criteria) this;
        }

        public Criteria andBelongUserIsNull() {
            addCriterion("belong_user is null");
            return (Criteria) this;
        }

        public Criteria andBelongUserIsNotNull() {
            addCriterion("belong_user is not null");
            return (Criteria) this;
        }

        public Criteria andBelongUserEqualTo(Long value) {
            addCriterion("belong_user =", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserNotEqualTo(Long value) {
            addCriterion("belong_user <>", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserGreaterThan(Long value) {
            addCriterion("belong_user >", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserGreaterThanOrEqualTo(Long value) {
            addCriterion("belong_user >=", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserLessThan(Long value) {
            addCriterion("belong_user <", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserLessThanOrEqualTo(Long value) {
            addCriterion("belong_user <=", value, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserIn(List<Long> values) {
            addCriterion("belong_user in", values, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserNotIn(List<Long> values) {
            addCriterion("belong_user not in", values, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserBetween(Long value1, Long value2) {
            addCriterion("belong_user between", value1, value2, "belongUser");
            return (Criteria) this;
        }

        public Criteria andBelongUserNotBetween(Long value1, Long value2) {
            addCriterion("belong_user not between", value1, value2, "belongUser");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("file_type like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(BigDecimal value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(BigDecimal value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(BigDecimal value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(BigDecimal value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<BigDecimal> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<BigDecimal> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileLocationIsNull() {
            addCriterion("file_location is null");
            return (Criteria) this;
        }

        public Criteria andFileLocationIsNotNull() {
            addCriterion("file_location is not null");
            return (Criteria) this;
        }

        public Criteria andFileLocationEqualTo(Long value) {
            addCriterion("file_location =", value, "fileLocation");
            return (Criteria) this;
        }

        public Criteria andFileLocationNotEqualTo(Long value) {
            addCriterion("file_location <>", value, "fileLocation");
            return (Criteria) this;
        }

        public Criteria andFileLocationGreaterThan(Long value) {
            addCriterion("file_location >", value, "fileLocation");
            return (Criteria) this;
        }

        public Criteria andFileLocationGreaterThanOrEqualTo(Long value) {
            addCriterion("file_location >=", value, "fileLocation");
            return (Criteria) this;
        }

        public Criteria andFileLocationLessThan(Long value) {
            addCriterion("file_location <", value, "fileLocation");
            return (Criteria) this;
        }

        public Criteria andFileLocationLessThanOrEqualTo(Long value) {
            addCriterion("file_location <=", value, "fileLocation");
            return (Criteria) this;
        }

        public Criteria andFileLocationIn(List<Long> values) {
            addCriterion("file_location in", values, "fileLocation");
            return (Criteria) this;
        }

        public Criteria andFileLocationNotIn(List<Long> values) {
            addCriterion("file_location not in", values, "fileLocation");
            return (Criteria) this;
        }

        public Criteria andFileLocationBetween(Long value1, Long value2) {
            addCriterion("file_location between", value1, value2, "fileLocation");
            return (Criteria) this;
        }

        public Criteria andFileLocationNotBetween(Long value1, Long value2) {
            addCriterion("file_location not between", value1, value2, "fileLocation");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNull() {
            addCriterion("upload_time is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(Date value) {
            addCriterion("upload_time =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(Date value) {
            addCriterion("upload_time <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(Date value) {
            addCriterion("upload_time >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upload_time >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(Date value) {
            addCriterion("upload_time <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("upload_time <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<Date> values) {
            addCriterion("upload_time in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<Date> values) {
            addCriterion("upload_time not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(Date value1, Date value2) {
            addCriterion("upload_time between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("upload_time not between", value1, value2, "uploadTime");
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