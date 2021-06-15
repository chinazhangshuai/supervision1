package com.iscas.biz.samples;

import com.iscas.biz.domain.common.LogInfo;
import com.iscas.biz.service.cache.CacheService;
import com.iscas.templet.common.BaseController;
import com.iscas.templet.common.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/6 17:36
 * @since jdk1.8
 */
@RestController
@RequestMapping("/cache")
@Api(tags = "缓存使用")
public class CacheControllerTest extends BaseController {

    private String cacheKey = "logInfo";

    @Autowired
    private CacheService cacheService;

    @PostMapping("/set")
    @ApiOperation(value = "存入缓存", notes = "测试存入缓存")
    public ResponseEntity set(@RequestBody LogInfo logInfo) {
        ResponseEntity response = getResponse();
        cacheService.set(cacheKey,logInfo);
        response.setDesc("存入缓存");
        return response;
    }

    @GetMapping("/get")
    @ApiOperation(value = "获取缓存", notes = "测试获取缓存")
    public ResponseEntity get() {
        ResponseEntity response = getResponse();
        LogInfo logInfo = (LogInfo)cacheService.get(LogInfo.class,cacheKey);
        response.setValue(logInfo);
        return response;
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除缓存", notes = "测试删除缓存")
    public ResponseEntity deleteFromCaffeine(String cacheKey) {
        ResponseEntity response = getResponse();
        cacheService.delete(this.cacheKey);
        response.setDesc("删除缓存");
        return response;
    }

}
