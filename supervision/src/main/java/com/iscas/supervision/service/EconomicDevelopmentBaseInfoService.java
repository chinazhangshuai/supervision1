package com.iscas.supervision.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iscas.supervision.domain.EconomicDevelopmentBaseInfo;

import java.util.Map;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/6/11 16:59
 * @since jdk1.8
 */
public interface EconomicDevelopmentBaseInfoService extends IService<EconomicDevelopmentBaseInfo> {
    Map<String, Map<String, String>> getEconomicsTrend();

    Map getOutInvestment();

    Map getInInvestment();
}
