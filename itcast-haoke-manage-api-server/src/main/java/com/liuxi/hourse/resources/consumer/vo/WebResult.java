package com.liuxi.hourse.resources.consumer.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/17 12:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebResult {

    /**
     * @JsonIgnore 忽略序列化，不返回属性到前端，直接返回方法中得属性
     */
    @JsonIgnore
    private int status;
    @JsonIgnore
    private String msg;
    private List<?> data;

    @JsonIgnore
    public static WebResult ok(List<?> list) {
        return new WebResult(200, "成功", list);
    }

    @JsonIgnore
    public static WebResult ok(List<?> list, String msg) {

        return new WebResult(200, msg, list);
    }

    /**
     * 实际序列化返回到前端得数据
     * data:{
     *     list: {
     *
     *     }
     * }
     * @return
     */
    public Map<String, Object> getData() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("list", this.data);
        return data;
    }

    /**
     * meta:{
     *     msg: xxx,
     *     status: xxx
     * }
     * @return
     */
    public Map<String, Object> getMeta() {
        HashMap<String, Object> meta = new HashMap<>();
        meta.put("msg", this.msg);
        meta.put("status", this.status);
        return meta;
    }

}
