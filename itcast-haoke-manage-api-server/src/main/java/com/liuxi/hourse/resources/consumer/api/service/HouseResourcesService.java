package com.liuxi.hourse.resources.consumer.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liuxi.hourse.resources.consumer.vo.PageTableResult;
import com.liuxi.hourse.resources.consumer.vo.Pagination;
import com.liuxi.house.resource.interfaces.pojo.entity.HouseResources;
import com.liuxi.house.resource.interfaces.pojo.vo.PageInfo;
import com.liuxi.house.resource.interfaces.server.api.ApiHouseResourcesService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/8 4:24
 */
@Service
public class HouseResourcesService {

    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    /**
     * 调用生产者新增房源服务
     * @param houseResources
     * @return
     */
    public Integer saveHouseResources(HouseResources houseResources) {

        return this.apiHouseResourcesService.saveHouseResources(houseResources);
    }

    /**
     * 分页条件查询房源列表
     * @param currentPage
     * @param pageSize
     * @param houseResources
     * @return
     */
    public PageTableResult<HouseResources> queryHouseResourcesList(int currentPage, int pageSize, HouseResources houseResources) {
        PageInfo<HouseResources> houseResourcesPageInfo = this.apiHouseResourcesService.queryHouseResourcesList(currentPage, pageSize, houseResources);
        return new PageTableResult<>(houseResourcesPageInfo.getRecords(),
                new Pagination(currentPage, pageSize, houseResourcesPageInfo.getTotal()));
    }

    /**
     * 根据 ID 查询房源数据
     * @param id
     * @return
     */
    public HouseResources queryHouseResourcesById(Long id) {

        return this.apiHouseResourcesService.queryHouseResourcesById(id);
    }
}
