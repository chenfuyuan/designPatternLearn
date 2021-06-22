package com.learn.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 排序规则
 * @Author: chenfuyuan
 * @Date: 2021/6/23 0:47
 */
public class OrderRule {



    public static final String ASC_ORDER = "ASC";

    public static final String DESC_ORDER = "DESC";

    private List<Rule> ruleList = new ArrayList<>();


    private OrderRule() {

    }

    public static OrderRule getInstance() {
        return new OrderRule();
    }

    public void addRule(Rule rule) {
        this.ruleList.add(rule);
    }

    public List<Rule> getRuleList() {
        return this.ruleList;
    }

    public static class Rule{
        private String propertyName;

        private String type;

        public Rule(String propertyName) {
            this.propertyName = propertyName;
            type = ASC_ORDER;
        }

        public Rule(String propertyName, String orderType) {
            this.propertyName = propertyName;
            this.type = orderType;
        }

        public void productSql(StringBuilder sql) {
            sql.append(" ").append(propertyName).append(" ").append(type);
        }
    }
}
