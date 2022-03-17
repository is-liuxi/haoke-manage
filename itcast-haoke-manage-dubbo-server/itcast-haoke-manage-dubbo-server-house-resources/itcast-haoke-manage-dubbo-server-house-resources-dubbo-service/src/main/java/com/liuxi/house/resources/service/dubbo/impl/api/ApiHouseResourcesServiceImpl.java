package com.liuxi.house.resources.service.dubbo.impl.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.liuxi.house.resource.interfaces.pojo.HouseResources;
import com.liuxi.house.resource.interfaces.dubbo.server.api.ApiHouseResourcesService;
import com.liuxi.house.resources.service.service.HouseResourcesService;
import com.liuxi.server.common.pojo.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/8 4:15
 */
@Service(version = "1.0.0")
public class ApiHouseResourcesServiceImpl implements ApiHouseResourcesService {

    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public int saveHouseResources(HouseResources houseResources) {

        return houseResourcesService.saveHouseResources(houseResources);
    }

    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources houseResources) {

        return houseResourcesService.queryHouseResourcesList(page, pageSize, houseResources);
    }

    @Override
    public HouseResources queryHouseResourcesById(Long id) {

        return houseResourcesService.queryHouseResourcesById(id);
    }
}
