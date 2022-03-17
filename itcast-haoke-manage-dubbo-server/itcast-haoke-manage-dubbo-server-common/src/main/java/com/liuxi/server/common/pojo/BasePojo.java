package com.liuxi.server.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *  所有数据库中都有的两个字段
 * </P>
 * @author liu xi
 * @date 2022/3/8 2:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BasePojo implements Serializable {

    /**
     * 创建时间
     */
    private LocalDateTime created;

    /**
     * 更新时间
     */
    private LocalDateTime updated;
}
