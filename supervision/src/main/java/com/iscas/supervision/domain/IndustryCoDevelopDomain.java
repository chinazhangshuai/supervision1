package com.iscas.supervision.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhangshuai
 * @date 2021/6/11
 */
@Data
@TableName("F_DP_INDUSTRYCO")
public class IndustryCoDevelopDomain {

    /**
     * 主键
     */
    @TableId("HD_ID")
    private String hdId;

    /**
     * 名称
     */
    @TableField("HD_NAME")
    private String hdName;

    /**
     * 值
     */
    @TableField("HD_VALUE")
    private Double hdValue;

    /**
     * 同比
     */
    @TableField("HD_VALUE_TB")
    private Double hdValueTB;

    /**
     * 环比
     */
    @TableField("HD_VALUE_HB")
    private Double hdValueHB;

    /**
     * 占比
     */
    @TableField("HD_VALUE_ZB")
    private Double hdValueZB;

    /**
     * 名称
     */
    @TableField("HD_SNAME")
    private String hdSName;

    /**
     * 对应页面代码
     */
    @TableField("HD_TYPE")
    private String hdType;

    /**
     * 对应页面注释
     */
    @TableField("HD_TYPE_NM")
    private String hdTypeName;

    /**
     * 单位
     */
    @TableField("HD_UNIT")
    private String hdUnit;

    /**
     * 代码
     */
    @TableField("HD_CODE")
    private String hdCode;

    /**
     * 子级区域代码
     */
    @TableField("HD_CHILDREN_CODE")
    private String hdChildrenCode;

    /**
     * 父级代码
     */
    @TableField("HD_PARENT_CODE")
    private String hdParentCode;

}
