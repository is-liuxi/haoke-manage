package com.liuxi.ad.interfaces.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liuxi.server.common.pojo.BasePojo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </P>
 * @author liu xi
 * @date 2022/3/16 22:50
 */
@Data
@Accessors(chain = true)
@TableName("tb_ad")
public class Ad extends BasePojo {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 广告类型
     */
    private Integer type;
    /**
     * 描述
     */
    private String title;
    /**
     * 图片URL地址
     */
    private String url;
}
