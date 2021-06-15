//package com.iscas.biz.samples;
//
//import com.google.common.collect.ImmutableList;
//import com.iscas.biz.domain.common.LogInfo;
//import com.iscas.biz.service.common.impl.DynamicSqlService;
//import com.iscas.templet.common.BaseController;
//import com.iscas.templet.common.ResponseEntity;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author lirenshen
// * @vesion 1.0
// * @date 2021/1/6 16:11
// * @since jdk1.8
// */
//@RestController
//@RequestMapping("/dynamicSql")
//@Api(tags = "动态sql")
//public class DynamicSqlController extends BaseController {
//
//
//    @Autowired
//    private DynamicSqlService dynamicSqlService;
//
//    @PostMapping("/save")
//    @ApiOperation(value = "保存操作", notes = "保存日志信息")
//    public ResponseEntity save(@RequestBody LogInfo logInfo) {
//        ResponseEntity response = getResponse();
//        String sql = "INSERT INTO log_info ( type, description ) VALUES ('%s', '%s' ) ";
//        String insertSql = String.format(sql, logInfo.getType(), logInfo.getDescription());
//        dynamicSqlService.dynamicInsert(insertSql);
//        response.setValue(logInfo);
//        return response;
//    }
//
//    @PostMapping("/update")
//    @ApiOperation(value = "更新操作", notes = "更新日志信息")
//    public ResponseEntity update(@RequestBody LogInfo logInfo) {
//        ResponseEntity response = getResponse();
//        String sql = "update log_info set type = '%s', description = '%s' where id = %s";
//        String updateSql = String.format(sql, logInfo.getType(), logInfo.getDescription(), logInfo.getId());
//        dynamicSqlService.dynamicUpdate(updateSql);
//        response.setValue(logInfo);
//        return response;
//    }
//
//    @PostMapping("/delete")
//    @ApiOperation(value = "删除操作", notes = "删除日志信息")
//    public ResponseEntity delete(String id) {
//        ResponseEntity response = getResponse();
//        String sql = "delete from log_info where id = %s";
//        String deleteSql = String.format(sql, id);
//        dynamicSqlService.dynamicDelete(deleteSql);
//        response.setValue(id);
//        return response;
//    }
//
//    @GetMapping("/selectById")
//    @ApiOperation(value = "通过id查询", notes = "查询日志信息")
//    public ResponseEntity selectById(String id) {
//        ResponseEntity response = getResponse();
//        String sql = "select * from log_info where id = %s";
//        String selectSql = String.format(sql, id);
//        Map one = dynamicSqlService.dynamicSelectOne(selectSql);
//        response.setValue(one);
//        return response;
//    }
//
//    @GetMapping("/selectList")
//    @ApiOperation(value = "通过多值查询", notes = "查询日志信息")
//    public ResponseEntity selectList(String ...ids) {
//        ResponseEntity response = getResponse();
//        StringBuilder builder = new StringBuilder();
//        builder.append("select * from log_info where id in (");
//        Iterator<String> it = Arrays.asList(ids).iterator();
//        if(it.hasNext()){
//            builder.append(it.next());
//        }
//        while(it.hasNext()){
//            builder.append(",").append(it.next());
//        }
//        builder.append(")");
//        List<Map> list = dynamicSqlService.dynamicSelect(builder.toString());
//        response.setValue(list);
//        return response;
//    }
//
//    @GetMapping("/dynamicSelectLargeData")
//    @ApiOperation(value = "流式查询", notes = "大量数据流式查询")
//    public ResponseEntity dynamicSelectLargeData() {
//        ResponseEntity response = getResponse();
//        String sql = "select * from log_info";
//        dynamicSqlService.dynamicSelectLargeData(sql);
//        response.setDesc("流式查询");
//        return response;
//    }
//
//    @GetMapping("/dynamicBatch")
//    @ApiOperation(value = "批量操作", notes = "批量处理sql")
//    public ResponseEntity dynamicBatch() {
//        ResponseEntity response = getResponse();
//        String firstSql = "insert into log_info ( type, description ) VALUES ('TEST', '测试批量' )";
//        String secondSql = "delete from log_info where id = 2";
//        ImmutableList<String> list = ImmutableList.of(firstSql, secondSql);
//        dynamicSqlService.dynamicBatch(list);
//        response.setDesc("批量操作");
//        return response;
//    }
//}
