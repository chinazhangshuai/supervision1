package com.iscas.biz.samples.spring.controller;

import com.iscas.biz.samples.spring.model.TestSpringModel;
import com.iscas.templet.common.BaseController;
import com.iscas.templet.common.ResponseEntity;
import com.iscas.templet.exception.BaseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * spring基本使用测试
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2021/1/7 10:10
 * @since jdk1.8
 */
@RestController
@RequestMapping("/test/spring")
@Api(tags = "测试-spring基本使用")
public class SpringBaseUseControllerTest extends BaseController {

    @ApiOperation(value="测试get请求-2021-01-07", notes="")
    @GetMapping()
    public ResponseEntity testGet() throws BaseException {
        ResponseEntity response = getResponse();
        response.setMessage("测试Get请求成功");
        return response;
    }

    @ApiOperation(value="测试post请求-2021-01-07", notes="")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "testSpringModel", value = "测试数据", required = true, dataType = "TestSpringModel")
            }
    )
    @PostMapping
    public ResponseEntity testPost(@RequestBody TestSpringModel testSpringModel) throws BaseException {
        ResponseEntity response = getResponse();
        response.setMessage("测试post请求成功");
        response.setValue(testSpringModel);
        return response;
    }

    @ApiOperation(value="测试put请求-2021-01-07", notes="")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "param", value = "测试参数", required = true, dataType = "String"),
                    @ApiImplicitParam(name = "testSpringModel", value = "测试数据", required = false, dataType = "TestSpringModel")
            }
    )
    @PutMapping
    public ResponseEntity testPut(@RequestBody TestSpringModel testSpringModel, @RequestParam(required = false) String param)
            throws BaseException {
        ResponseEntity response = getResponse();
        response.setMessage("测试put请求成功");
        testSpringModel.setName(param);
        return response;
    }

    @ApiOperation(value="测试delete请求-2021-01-07", notes="")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "param", value = "测试参数", required = true, dataType = "String")
            }
    )
    @DeleteMapping("/{param}")
    public ResponseEntity testPut(@PathVariable String param)
            throws BaseException {
        ResponseEntity response = getResponse();
        response.setMessage("测试delete请求成功");
        return response;
    }


}
