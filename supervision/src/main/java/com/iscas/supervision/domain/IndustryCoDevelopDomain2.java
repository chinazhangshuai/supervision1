package com.iscas.supervision.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhangshuai
 * @date 2021/6/15
 * 各行业发展状况实体类
 */
@Data
@TableName("F_DP_INDUSTRYCO_2")
public class IndustryCoDevelopDomain2 {

    /**
     * 主键
     */
    @TableId("HD_ID")
    private String HdId;

    /**
     * 名字
     */
    @TableField("HD_NAME")
    private String HdName;

    /**
     * X轴：企业期末户数
     */
    @TableField("HD_VALUE_X")
    private int HdValueX;

    /**
     * Y轴：产业集聚指数
     */
    @TableField("HD_VALUE_Y")
    private Double HdValueY;

    /**
     * 半径：企业期末户数
     */
    @TableField("HD_VALUE_B")
    private int HdValueB;

    /**
     * 名称
     */
    @TableField("HD_SNAME")
    private String HdSName;

    /**
     * 类型
     */
    @TableField("HD_TYPE")
    private String HdType;

    /**
     * 类型名字
     */
    @TableField("HD_TYPE_NM")
    private String HdTypeNm;

    /**
     * 单位
     */
    @TableField("HD_UNIT")
    private String HdUnit;

    /**
     * 代码
     */
    @TableField("HD_CODE")
    private String HdCode;

    /**
     * 地区代码
     */
    @TableField("HD_DISTRIT_CODE")
    private String HdDistrictCode;


}
