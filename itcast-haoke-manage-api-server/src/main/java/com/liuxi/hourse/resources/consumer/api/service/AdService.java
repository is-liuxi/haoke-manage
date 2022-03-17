package com.liuxi.hourse.resources.consumer.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuxi.ad.interfaces.dubbo.server.api.ApiAdService;
import com.liuxi.ad.interfaces.pojo.Ad;
import com.liuxi.hourse.resources.consumer.vo.WebResult;
import com.liuxi.server.common.pojo.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/16 23:22
 */
@Service
public class AdService {

    @Reference(version = "1.0.0")
    private ApiAdService apiAdService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 查询轮播图
     * @param type
     * @param currentPage
     * @param pageSize
     * @return
     */
    public WebResult queryAdList(Integer type, Integer currentPage, Integer pageSize) {
        PageInfo<Ad> adPageInfo = this.apiAdService.queryAdList(type, currentPage, pageSize);
        List<Ad> records = adPageInfo.getRecords();

        List<Map<String, String>> resultList = new ArrayList<>(16);
        Map<String, String> urlMap = null;
        for (Ad item : records) {
            urlMap = new HashMap<>();
            urlMap.put("original", item.getUrl());
            resultList.add(urlMap);
        }
        return WebResult.ok(resultList);
    }
}
