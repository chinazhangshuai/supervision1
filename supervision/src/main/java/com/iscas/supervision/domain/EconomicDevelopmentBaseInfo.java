package com.iscas.supervision.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/6/10 18:11
 * @since jdk1.8
 * 经济发展基础数据
 */
@Data
@TableName("F_DP_REGION_CAPITALFLOW")
public class EconomicDevelopmentBaseInfo {

    /**
     * id
     */
    private String hdId;
    /**
     * 投资方所在省
     */
    private String hdName;

    /**
     * 投资金额、投资次数等值，根据hdType类型来确定
     */
    private String hdValue;

    /**
     * 同比
     */
    private String hdValueTb;

    /**
     * 环比
     */
    private String hdValueHb;

    /**
     * 占比
     */
    private String hdValueZb;

    /**
     * 被投城市
     */
    private String hdSname;

    /**
     * 类型
     */
    private String hdType;

    /**
     * 描述信息
     */
    private String hdTypeNm;

    /**
     * 单位
     */
    private String hdUnit;

    /**
     * 单维度筛选或其他维度筛选代码
     */
    private String hdCode;

    /**
     * 子级代码
     */
    private String hdChildrenCode;

    /**
     * 父级代码
     */
    private String hdParentCode;
}
