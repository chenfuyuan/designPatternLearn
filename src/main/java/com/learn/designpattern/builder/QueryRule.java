package com.learn.designpattern.builder;

import lombok.Data;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 主要功能用于构造查询条件
 * @Author: chenfuyuan
 * @Date: 2021/6/22 22:42
 */
@Data
public class QueryRule {

    /**
     * 规则列表
     */
    private List<Rule> ruleList = new ArrayList<>();

    private QueryRule() {

    }

    public static QueryRule getInstance() {
        return new QueryRule();
    }

    public void addRule(Rule rule) {
        this.ruleList.add(rule);
    }

    @Data
    public static abstract class Rule {

        /**
         * 字段名称
         */
        private String propertyName;

        /**
         * 值
         */
        protected Object[] values;

        protected String andOr = AND;

        public static final String AND = "AND";
        public static final String OR = "OR";

        public Rule(String propertyName,String andOr,Object[] values) {
            this.propertyName = propertyName;
            this.values = values;
            this.andOr = andOr;
        }

        public Rule(String propertyName,String andOr,Object value) {
            this.propertyName = propertyName;
            this.andOr = andOr;
            this.values = new Object[1];
            this.values[0] = value;
        }

        public Rule(String propertyName,String andOr) {
            this.propertyName = propertyName;
            this.andOr = andOr;
        }

        public void productSql(StringBuilder sqlCache){
            sqlCache.append(" ").append(andOr).append(" ").append(propertyName);
            productRuleSql(sqlCache);
        }

        protected abstract void productRuleSql(StringBuilder sqlCache);

        protected String getValueStr(Object value) {
            if (value instanceof String) {
                return "\"" + value + "\"";
            }else {
                return value.toString();
            }
        }
    }


    public static class EqualRule extends Rule {
        public EqualRule(String propertyName,String andOr, Object value) {
            super(propertyName,andOr,value);
        }

        @Override
        public void productRuleSql(StringBuilder sqlCache) {
            sqlCache.append(" = ").append(getValueStr(values[0]));
        }
    }


    public static class LikeRule extends Rule{
        public LikeRule(String propertyName,String andOr, Object value) {
            super(propertyName, andOr,value);
        }

        @Override
        public void productRuleSql(StringBuilder sqlCache) {
            sqlCache.append(" like ").append(getValueStr(values[0]));
        }
    }

    public static class InRule extends Rule{
        public InRule(String propertyName, String andOr,Object[] values) {
            super(propertyName, andOr,values);
        }

        @Override
        public void productRuleSql(StringBuilder sqlCache) {
            sqlCache.append(" IN (");
            for (Object value : values) {
                sqlCache.append(getValueStr(value)).append(",");
            }
            sqlCache.setCharAt(sqlCache.length() - 1, ')');
        }
    }

    public class IsNullRule extends Rule{
        public IsNullRule(String propertyName,String andOr) {
            super(propertyName, andOr);
        }

        @Override
        public void productRuleSql(StringBuilder sqlCache) {
            sqlCache.append(" is null ");
        }
    }

}
