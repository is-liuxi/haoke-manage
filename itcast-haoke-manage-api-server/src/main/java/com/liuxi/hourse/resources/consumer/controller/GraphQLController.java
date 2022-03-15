package com.liuxi.hourse.resources.consumer.controller;

import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/15 20:57
 */
@RequestMapping("graphql")
@RestController
public class GraphQLController {

    @Autowired
    private GraphQL graphQL;

    /**
     * 请求参数示范：
     * {
     *   HouseResources(id:4){
     *     id
     *     title
     *     estateId
     *     buildingNum
     *     buildingUnit
     *   }
     * }
     *
     * 指定查询
     * @param query
     */
    @GetMapping
    public Map<String, Object> queryHouseById(@RequestParam("query") String query) {
        // 执行指定查询，标准输出
        return this.graphQL.execute(query).toSpecification();
    }
}
