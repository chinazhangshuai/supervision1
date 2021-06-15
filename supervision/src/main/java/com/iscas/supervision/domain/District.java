package com.iscas.supervision.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhangshuai
 * @date 2021/6/11
 */
@Data
@TableName("DISTRICT")
public class District {

    /**
     * 区域代码
     */
    @TableField("DOMDISTRICT")
    private String domDistrict;

    /**
     * 区域名称
     */
    @TableField("DOMDISTRICT_NAME")
    private String domDistrictName;

    /**
     * 父区域代码
     */
    @TableField("DOMDISTRICT_PCODE")
    private String domDistrictPCode;

    /**
     * 父区域名称
     */
    @TableField("DOMDISTRICT_PNAME")
    private String domDistrictPName;

    /**
     * 区域等级
     */
    @TableField("DOMDISTRICT_LEVEL")
    private String domDistricLevel;

}
