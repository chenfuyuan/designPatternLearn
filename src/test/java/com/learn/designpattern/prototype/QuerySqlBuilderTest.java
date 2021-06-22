package com.learn.designpattern.prototype;

import com.learn.designpattern.builder.OrderRule;
import com.learn.designpattern.builder.QueryRule;
import com.learn.designpattern.builder.QuerySqlBuilder;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.junit.Test;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author: chenfuyuan
 * @Date: 2021/6/22 23:26
 */
public class QuerySqlBuilderTest {
    @Test
    public void demo01() {
        QueryRule queryRule = QueryRule.getInstance();
        queryRule.addRule(new QueryRule.EqualRule("age", QueryRule.Rule.OR, "18"));
        queryRule.addRule(new QueryRule.LikeRule("name",QueryRule.Rule.AND,"%张三%"));
        OrderRule orderRule = OrderRule.getInstance();
        orderRule.addRule(new OrderRule.Rule("age"));
        QuerySqlBuilder querySqlBuilder = new QuerySqlBuilder().
                addSelectProperty("age")
                .addSelectProperty("name")
                .addQueryRule(queryRule)
                .addOrderRule(orderRule);
        System.out.println(querySqlBuilder.build("student"));
    }
}
