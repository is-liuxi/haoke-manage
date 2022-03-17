package com.liuxi.ad.interfaces.dubbo.server.api;

import com.liuxi.ad.interfaces.pojo.Ad;
import com.liuxi.server.common.pojo.vo.PageInfo;

/**
 * <p>
 *  Dubbo 服务提供接口
 * </P>
 * @author liu xi
 * @date 2022/3/16 22:52
 */
public interface ApiAdService {

    /**
     * 查询轮播图
     * @param type
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Ad> queryAdList(Integer type, Integer currentPage, Integer pageSize);
}
