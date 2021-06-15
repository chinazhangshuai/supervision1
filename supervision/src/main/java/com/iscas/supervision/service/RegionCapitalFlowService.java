package com.iscas.supervision.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iscas.supervision.domain.RegionCapitalFlow;

import java.util.List;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/6/10 18:43
 * @since jdk1.8
 */
public interface RegionCapitalFlowService extends IService<RegionCapitalFlow> {
    List getAllProvinceCapitalFlows();

    List getSiChuanProvinceCapitalFlows();

    List getEconomicsTrend();
}
