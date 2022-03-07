package com.liuxi.house.resource.interfaces.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.liuxi.house.resource.interfaces.pojo.BasePojo;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 楼盘表
 * @Accessors 链式编程
 * </p>
 *
 * @author liuxi
 * @since 2022-03-08
 */
@Data
@Accessors(chain = true)
public class TbEstate extends BasePojo {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 楼盘名称
     */
    private String name;

    /**
     * 所在省
     */
    private String province;

    /**
     * 所在市
     */
    private String city;

    /**
     * 所在区
     */
    private String area;

    /**
     * 具体地址
     */
    private String address;

    /**
     * 建筑年代
     */
    private String year;

    /**
     * 建筑类型
     */
    private String type;

    /**
     * 物业费
     */
    private String propertyCost;

    /**
     * 物业公司
     */
    private String propertyCompany;

    /**
     * 开发商
     */
    private String developers;

}
