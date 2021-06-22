package com.learn.designpattern.builder;

import com.uptool.core.util.EmptyUtil;
import com.uptool.core.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 查询Sql构建类
 * @Author: chenfuyuan
 * @Date: 2021/6/22 23:09
 */
public class QuerySqlBuilder {

    private QueryRule queryRule;

    private OrderRule orderRule;

    private List<String> selectPropertyList = new ArrayList<>();

    private String selectTableName;

    private String whereSql;

    private String orderSql;


    public QuerySqlBuilder() {
    }

    public QuerySqlBuilder addSelectPropertyList(List<String> selectPropertyList) {
        this.selectPropertyList = selectPropertyList;
        return this;
    }

    public String getWhereSql() {
        return this.whereSql;
    }

    public String getOrderSql() {
        return this.orderSql;
    }

    public QuerySqlBuilder addSelectProperty(String property) {
        this.selectPropertyList.add(property);
        return this;
    }

    public QuerySqlBuilder addQueryRule(QueryRule queryRule) {
        if (EmptyUtil.isEmpty(queryRule)) {
            return this;
        }
        this.queryRule = queryRule;
        initWhereSql(queryRule);

        return this;
    }

    public QuerySqlBuilder addOrderRule(OrderRule orderRule) {
        if (EmptyUtil.isEmpty(orderRule)) {
            return this;
        }
        this.orderRule = orderRule;
        initOrderSql(queryRule);
        return this;
    }

    private void initWhereSql(QueryRule queryRule) {
        whereSql = null;
        List<QueryRule.Rule> ruleList = queryRule.getRuleList();
        if (EmptyUtil.isEmpty(ruleList)) {
            return;
        }


        StringBuilder sql = new StringBuilder();
        for (QueryRule.Rule rule : ruleList) {
            rule.productSql(sql);
        }
        whereSql = sql.toString();
    }

    private void initOrderSql(QueryRule queryRule) {
        orderSql = null;
        List<OrderRule.Rule> ruleList = orderRule.getRuleList();
        if (EmptyUtil.isEmpty(ruleList)) {
            return;
        }

        StringBuilder sql = new StringBuilder();
        for (OrderRule.Rule rule : ruleList) {
            rule.productSql(sql);
        }

        orderSql = sql.toString();
    }

    public String build(String selectTableName){
        this.selectTableName = selectTableName;

        //生成查询表字段
        StringBuffer sql = new StringBuffer();
        produceSelect(sql);

        //生成查询条件字段
        produceQueryRule(sql);

        return StringUtil.removeSurPlusSpace(sql.toString());
    }

    private void produceQueryRule(StringBuffer sql) {
        if (EmptyUtil.isEmpty(queryRule)) {
            return;
        }
        sql.append(" WHERE 1 = 1 ").append(whereSql);
        sql.append(" ORDER BY ").append(orderSql);
    }

    private void produceSelect(StringBuffer sql) {
        sql.append("SELECT ");
        if (EmptyUtil.isEmpty(selectPropertyList)) {
            sql.append("*");
        } else {
            for (String property : selectPropertyList) {
                sql.append(property+",");
            }
            sql.delete(sql.length()-1, sql.length());
        }

        sql.append(" FROM " + selectTableName);
    }
}
