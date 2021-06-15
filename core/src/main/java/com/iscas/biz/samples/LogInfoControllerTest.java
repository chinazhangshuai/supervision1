//package com.iscas.biz.samples;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.iscas.biz.domain.common.LogInfo;
//import com.iscas.biz.service.common.LogInfoService;
//import com.iscas.templet.common.BaseController;
//import com.iscas.templet.common.ResponseEntity;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @author lirenshen
// * @vesion 1.0
// * @date 2021/1/6 11:04
// * @since jdk1.8
// */
//@RestController
//@RequestMapping("/logInfo")
//@Api(tags = "mybatis-plus使用")
//public class LogInfoControllerTest extends BaseController {
//
//    @Autowired
//    private LogInfoService logInfoService;
//
//    @PostMapping("/save")
//    @ApiOperation(value = "保存操作", notes = "保存日志信息")
//    public ResponseEntity save(@RequestBody LogInfo logInfo) {
//        ResponseEntity response = getResponse();
//        Integer count = logInfoService.saveLog(logInfo);
//        response.setValue(count);
//        return response;
//    }
//
//    @PostMapping("/update")
//    @ApiOperation(value = "更新操作", notes = "更新日志信息")
//    public ResponseEntity update(@RequestBody LogInfo logInfo) {
//        ResponseEntity response = getResponse();
//        Integer updateCount = logInfoService.updateLog(logInfo);
//        response.setValue(updateCount);
//        return response;
//    }
//
//    @PostMapping("/delete")
//    @ApiOperation(value = "删除操作", notes = "删除日志信息")
//    public ResponseEntity delete(String id) {
//        ResponseEntity response = getResponse();
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("id", id);
//        boolean remove = logInfoService.remove(wrapper);
//        response.setValue(remove);
//        return response;
//    }
//
//    @GetMapping("/selectById")
//    @ApiOperation(value = "通过id查询", notes = "查询日志信息")
//    public ResponseEntity selectById(String id) {
//        ResponseEntity response = getResponse();
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("id", id);
//        LogInfo logInfo = logInfoService.getOne(wrapper);
//        response.setValue(logInfo);
//        return response;
//    }
//
//    @GetMapping("/selectByPage")
//    @ApiOperation(value = "分页查询", notes = "分页查询日志信息")
//    public ResponseEntity selectByPage(Integer pageNumber, Integer pageSize) {
//
//        Page page = new Page<>(pageNumber, pageSize);
//        ResponseEntity response = getResponse();
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.lt("id", 100);
//        Page result = logInfoService.page(page, wrapper);
//        response.setValue(result);
//        return response;
//    }
//
//    @GetMapping("/selectByIds")
//    @ApiOperation(value = "多值查询", notes = "根据多个id查询日志信息")
//    public ResponseEntity selectByIds(Integer pageNumber, Integer pageSize, String... ids) {
//        Page page = new Page<>(pageNumber, pageSize);
//        ResponseEntity response = getResponse();
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.in("id", ids);
//        Page result = logInfoService.page(page, wrapper);
//        response.setValue(result);
//        return response;
//    }
//
//    @GetMapping("/selectByLike")
//    @ApiOperation(value = "模糊查询", notes = "根据描述查询日志信息")
//    public ResponseEntity selectByLike(Integer pageNumber, Integer pageSize, String description) {
//
//        Page page = new Page<>(pageNumber, pageSize);
//        ResponseEntity response = getResponse();
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.like("description", description);
//        Page result = logInfoService.page(page, wrapper);
//        response.setValue(result);
//        return response;
//    }
//}
