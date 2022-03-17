package com.liuxi.ad.service.service;

import com.liuxi.ad.interfaces.pojo.Ad;
import com.liuxi.server.common.pojo.vo.PageInfo;

/**
 * <p>
 *
 * </P>
 * @author LiuXi
 * @date 2022/3/16 23:08
 */
public interface AdService {

    /**
     * 查询轮播图
     * @param type
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageInfo<Ad> queryAdList(Integer type, Integer currentPage, Integer pageSize);
}
