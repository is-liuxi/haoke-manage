package com.liuxi.hourse.resources.consumer.graphql.impl;

import com.liuxi.hourse.resources.consumer.api.service.HouseResourcesService;
import com.liuxi.hourse.resources.consumer.graphql.MyDateFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/15 22:40
 */
@Service
public class HouseResourcesDataFetcher implements MyDateFetcher {

    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public String fieldName() {
        // 查询名字
        return "HouseResources";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        // 获取参数
        Long id = environment.getArgument("id");
        return houseResourcesService.queryHouseResourcesById(id);
    }
}
