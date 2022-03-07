package com.liuxi.hourse.resources.consumer.controller;

import com.liuxi.hourse.resources.consumer.api.service.HouseResourcesService;
import com.liuxi.house.resource.interfaces.pojo.entity.HouseResources;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/8 4:28
 */
@RestController
@RequestMapping("house/resources")
@Slf4j
public class HouseResourcesController {

    @Autowired
    private HouseResourcesService houseResourcesService;

    @PostMapping("saveHouseResources")
    public Integer saveHouseResources(@RequestBody HouseResources houseResources) {
        log.info("saveHouseResources ===> 前端传入参数：{}", houseResources);
        return this.houseResourcesService.saveHouseResources(houseResources);
    }
}
