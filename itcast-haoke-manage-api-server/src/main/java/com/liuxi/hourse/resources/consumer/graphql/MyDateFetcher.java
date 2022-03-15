package com.liuxi.hourse.resources.consumer.graphql;

import graphql.schema.DataFetchingEnvironment;

/**
 * <p>
 *  GraphQL 查询封装，减少硬编码
 * </P>
 * @author LiuXi
 * @date 2022/3/15 22:32
 */
public interface MyDateFetcher {

    /**
     * GraphQL 中的查询名称
     * @return
     */
    String fieldName();

    /**
     * 数据得查询
     * @param environment
     * @return
     */
    Object dataFetcher(DataFetchingEnvironment environment);
}
