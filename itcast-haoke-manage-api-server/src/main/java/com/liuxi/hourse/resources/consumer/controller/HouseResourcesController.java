package com.liuxi.hourse.resources.consumer.controller;

import com.liuxi.hourse.resources.consumer.api.service.HouseResourcesService;
import com.liuxi.hourse.resources.consumer.vo.PageTableResult;
import com.liuxi.house.resource.interfaces.pojo.HouseResources;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("queryHouseResourcesList")
    public PageTableResult<HouseResources> queryHouseResourcesList(@RequestParam("currentPage") Integer currentPage,
                                                                   @RequestParam("pageSize") Integer pageSize,
                                                                   @RequestBody(required = false) HouseResources houseResources) {
        log.info("当前页：{}，页面显示大小：{}，查询条件：{}", currentPage, pageSize, houseResources);

        return this.houseResourcesService.queryHouseResourcesList(currentPage, pageSize, houseResources);
    }
}
