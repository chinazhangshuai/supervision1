package com.iscas.supervision.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iscas.biz.mp.mapper.DynamicMapper;
import com.iscas.common.tools.core.string.StringRaiseUtils;
import com.iscas.supervision.domain.RegionCapitalFlow;
import com.iscas.supervision.mapper.RegionCapitalFlowMapper;
import com.iscas.supervision.service.RegionCapitalFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/6/10 18:43
 * @since jdk1.8
 */
@Service
public class RegionCapitalFlowServiceImpl extends ServiceImpl<RegionCapitalFlowMapper, RegionCapitalFlow> implements RegionCapitalFlowService {

    @Autowired
    private DynamicMapper dynamicMapper;

    /**
     * 资金流入和资金流出
     */
    String allCapitalFlowsSql = "select " +
            "ENT_DOMDISTRICT_NAME as province," +
            "SUM(CHT_VALUE_ENT) as ent_value," +
            "SUM(CHT_VALUE_INV) as inv_value " +
            "from " +
            "F_DP_REGION_CAPITALFLOW_2 " +
            "WHERE " +
            "YEAR=%s " +
            "AND " +
            "ENT_DOMDISTRICT_NAME != INV_DOMDISTRICT_NAME " +
            "GROUP BY " +
            "ENT_DOMDISTRICT_NAME";
    /**
     * 内部投资
     */
    String interCapitalFlowsSql = "select " +
            "ENT_DOMDISTRICT_NAME as province, " +
            "CHT_VALUE_ENT as int_value " +
            "from " +
            "F_DP_REGION_CAPITALFLOW_2 " +
            "WHERE " +
            "YEAR=%s " +
            "AND " +
            "ENT_DOMDISTRICT_NAME = INV_DOMDISTRICT_NAME ";

    @Override
    public List getAllProvinceCapitalFlows() {
        int year = LocalDate.now().getYear();
        year = 2017;
        List<Map> entAndInvCapitalFlows = dynamicMapper.select(String.format(allCapitalFlowsSql, year));
        List<Map> intCapitalFlows = dynamicMapper.select(String.format(interCapitalFlowsSql, year));
        Map<String, Double> interMap = intCapitalFlows.stream().collect(Collectors.toMap(map -> map.get("PROVINCE").toString(), map -> Double.valueOf(map.get("INT_VALUE").toString())));

        return entAndInvCapitalFlows.stream().map(item -> {
            HashMap<Object, Object> newMap = new HashMap<>();
            item.forEach((key, value) -> newMap.put(StringRaiseUtils.convertToHump(key.toString().toLowerCase()), value));
            String province = newMap.get("province").toString();
            Double intValue = Optional.ofNullable(interMap.get(province)).orElse(0.00);
            newMap.put("intValue", intValue);
            return newMap;
        }).sorted(Comparator.comparing(map -> Double.valueOf(map.get("invValue").toString()), Comparator.reverseOrder())).collect(Collectors.toList());
    }

    @Override
    public List getSiChuanProvinceCapitalFlows() {
        int year = LocalDate.now().getYear();
        year = 2017;

        dynamicMapper.select(String.format(allCapitalFlowsSql, year));


        return null;
    }

    @Override
    public List getEconomicsTrend() {

        return null;
    }
}
