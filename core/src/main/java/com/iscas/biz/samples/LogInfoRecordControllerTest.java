package com.iscas.biz.samples;

import com.iscas.biz.config.log.LogRecord;
import com.iscas.biz.config.log.LogType;
import com.iscas.biz.config.log.OperateType;
import com.iscas.templet.common.BaseController;
import com.iscas.templet.common.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/1/6 17:19
 * @since jdk1.8
 */
@RestController
@RequestMapping("/LogInfoRecord")
@Api(tags = "统一日志")
public class LogInfoRecordControllerTest extends BaseController {

    @PostMapping("/biz")
    @ApiOperation(value = "业务操作", notes = "执行相关业务")
    @LogRecord(type = LogType.SYSTEM, desc = "测试记录业务日志", operateType = OperateType.add)
    public ResponseEntity biz(@RequestBody Object object) {
        ResponseEntity response = getResponse();
        //业务逻辑
        return response;
    }
}
