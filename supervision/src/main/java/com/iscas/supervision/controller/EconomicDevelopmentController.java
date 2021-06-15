package com.iscas.supervision.controller;

import com.iscas.supervision.service.EconomicDevelopmentBaseInfoService;
import com.iscas.supervision.service.RegionCapitalFlowService;
import com.iscas.templet.common.BaseController;
import com.iscas.templet.common.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/6/10 17:34
 * @since jdk1.8
 */
@RestController
@RequestMapping("/supervision/economicDevelopment")
@Api(tags = "页面一，经济发展分析")
public class EconomicDevelopmentController extends BaseController {

    @Autowired
    private RegionCapitalFlowService regionCapitalFlowService;

    @Autowired
    private EconomicDevelopmentBaseInfoService economicDevelopmentBaseInfoService;

    @ApiOperation(value = "长江经济带各省市互投-和弦图(各省资金流向)")
    @PostMapping("/getAllProvinceCapitalFlows")
    public ResponseEntity getAllProvinceCapitalFlows() {
        ResponseEntity response = getResponse();
        List capitalFlows = regionCapitalFlowService.getAllProvinceCapitalFlows();
        response.setValue(capitalFlows);
        return response;
    }

    @ApiOperation(value = "宏观经济走势预测")
    @PostMapping("/getEconomicsTrend")
    public ResponseEntity getEconomicsTrend() {
        ResponseEntity response = getResponse();
        Map economicsTrend = economicDevelopmentBaseInfoService.getEconomicsTrend();
        response.setValue(economicsTrend);
        return response;
    }

    @ApiOperation(value = "对外投资")
    @PostMapping("/getOutInvestment")
    public ResponseEntity getOutInvestment() {
        ResponseEntity response = getResponse();
        Map economicsTrend = economicDevelopmentBaseInfoService.getOutInvestment();
        response.setValue(economicsTrend);
        return response;
    }

    @ApiOperation(value = "吸引投资")
    @PostMapping("/getInInvestment")
    public ResponseEntity getInInvestment() {
        ResponseEntity response = getResponse();
        Map economicsTrend = economicDevelopmentBaseInfoService.getInInvestment();
        response.setValue(economicsTrend);
        return response;
    }


}
