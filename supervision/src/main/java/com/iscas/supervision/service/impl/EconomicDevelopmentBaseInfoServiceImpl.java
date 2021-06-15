package com.iscas.supervision.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iscas.supervision.domain.EconomicDevelopmentBaseInfo;
import com.iscas.supervision.mapper.EconomicDevelopmentBaseInfoMapper;
import com.iscas.supervision.service.EconomicDevelopmentBaseInfoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/6/11 17:00
 * @since jdk1.8
 */
@Service
public class EconomicDevelopmentBaseInfoServiceImpl extends ServiceImpl<EconomicDevelopmentBaseInfoMapper, EconomicDevelopmentBaseInfo> implements EconomicDevelopmentBaseInfoService {
    @Override
    public Map<String, Map<String, String>> getEconomicsTrend() {

        //TODO 近三年暂无数据
        LocalDate endTime = LocalDate.now().minusYears(2);
        LocalDate startTime = endTime.minus(3, ChronoUnit.YEARS);
        String start = startTime.format(DateTimeFormatter.ofPattern("yyyy-MM"));
        String end = endTime.format(DateTimeFormatter.ofPattern("yyyy-MM"));

        QueryWrapper<EconomicDevelopmentBaseInfo> wrapper = new QueryWrapper();
        wrapper.eq("hd_type", "2");
        wrapper.between("hd_name", start, end);
        List<EconomicDevelopmentBaseInfo> EconomicDevelopmentBaseInfos = list(wrapper);

        Map<String, Map<String, String>> resultMap = EconomicDevelopmentBaseInfos.stream().sorted(Comparator.comparing(EconomicDevelopmentBaseInfo::getHdName)).
                collect(Collectors.groupingBy(EconomicDevelopmentBaseInfo::getHdTypeNm,
                        Collectors.mapping(Function.identity(), Collectors.toMap(EconomicDevelopmentBaseInfo::getHdName, EconomicDevelopmentBaseInfo::getHdValue))));

        resultMap.putIfAbsent("宏观经济走势预测--企业发展指数", new TreeMap<>());
        resultMap.putIfAbsent("宏观经济走势预测--财政收入增长率", new HashMap<>());

        resultMap.forEach((k, v) -> {
            int number = 0;
            LocalDate tmpDate = endTime;
            //3年内的数据
            while (number++ < 36) {
                tmpDate = tmpDate.minus(1, ChronoUnit.MONTHS);
                v.putIfAbsent(tmpDate.format(DateTimeFormatter.ofPattern("yyyy-MM")), "0.00");
            }
        });

        return resultMap;
    }

    @Override
    public Map getOutInvestment() {
        return null;
    }

    @Override
    public Map getInInvestment() {
        return null;
    }
}
