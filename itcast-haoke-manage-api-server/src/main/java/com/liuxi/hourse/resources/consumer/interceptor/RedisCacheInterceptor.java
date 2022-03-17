package com.liuxi.hourse.resources.consumer.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

/**
 * <p>
 *  缓存命中统一处理，只处理 GET 查询请求
 *  需要将类注册到 Spring 容器中
 * </P>
 * @author liu xi
 * @date 2022/3/17 22:58
 */
@Component
public class RedisCacheInterceptor implements HandlerInterceptor {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是 get 请求直接放行
        if (!StringUtils.equalsIgnoreCase(request.getMethod(), HttpMethod.GET.name())) {
            return true;
        }

        // 通过缓存命中，查询 redis。redisKey：md5(请求参数+uri)
        String redisKey = createRedisKey(request);
        String data = redisTemplate.opsForValue().get(redisKey);
        // false 缓存未命中
        if (StringUtils.isEmpty(data)) {
            return true;
        }

        // 命中直接返回 Redis 中的数据
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(data);
        return false;
    }

    /**
     * 自定义 Redis key
     * @param request
     * @return
     * @throws IOException
     */
    public static String createRedisKey(HttpServletRequest request) throws IOException {
        String paramStr = request.getRequestURI();
        // 请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (parameterMap.isEmpty()) {
            // 如果参数为空，读取请求体中内容
            paramStr += IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        } else {
            paramStr += objectMapper.writeValueAsString(parameterMap);
        }

        return "WEB_DATA_" + Arrays.toString(DigestUtils.md5(paramStr));
    }
}
