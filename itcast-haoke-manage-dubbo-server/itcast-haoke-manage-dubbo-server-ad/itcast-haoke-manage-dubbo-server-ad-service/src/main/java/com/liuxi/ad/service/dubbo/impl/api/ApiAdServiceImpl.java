package com.liuxi.ad.service.dubbo.impl.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.liuxi.ad.interfaces.pojo.Ad;
import com.liuxi.ad.interfaces.dubbo.server.api.ApiAdService;
import com.liuxi.ad.service.service.AdService;
import com.liuxi.server.common.pojo.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 对外发布得接口
 * </P>
 * @author liu xi
 * @date 2022/3/16 23:05
 */
@Service(version = "1.0.0")
public class ApiAdServiceImpl implements ApiAdService {

    @Autowired
    private AdService adService;

    @Override
    public PageInfo<Ad> queryAdList(Integer type, Integer currentPage, Integer pageSize) {

        return this.adService.queryAdList(type, currentPage, pageSize);
    }
}
