package com.iscas.supervision.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/6/10 18:10
 * @since jdk1.8
 * 区域资金流向
 */
@Data
@TableName("F_DP_REGION_CAPITALFLOW_2")
public class RegionCapitalFlow {
    /**
     * 年份
     */
    private String year;
    /**
     * 企业所在区域
     */
    private String entDomdistrict;
    /**
     * 企业名称
     */
    private String entDomdistrictName;
    /**
     * 投资区域
     */
    private String invDomdistrict;
    /**
     * 投资区域名称
     */
    private String invDomdistrictName;
    /**
     * 资金流出
     */
    private Double chtValueEnt;
    /**
     * 资金流入
     */
    private Double chtValueInv;
    /**
     * 资金总和
     */
    private Double chtValueZj;
}
