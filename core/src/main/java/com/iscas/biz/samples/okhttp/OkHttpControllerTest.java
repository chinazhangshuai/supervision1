package com.iscas.biz.samples.okhttp;

import cn.hutool.core.map.MapUtil;
import com.iscas.base.biz.service.common.OkHttpCustomClient;
import com.iscas.common.web.tools.json.JsonUtils;
import com.iscas.templet.common.BaseController;
import com.iscas.templet.common.ResponseEntity;
import com.iscas.templet.exception.BaseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * okhttp客户端测试
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2021/1/6 8:45
 * @since jdk1.8
 */
@RestController
@RequestMapping("/test/okhttp")
@Api(tags = "测试-okhttp客户端示例")
public class OkHttpControllerTest extends BaseController {
    private final OkHttpCustomClient httpCustomClient;

    @Value("${server.port}")
    private String serverPort;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    public OkHttpControllerTest(OkHttpCustomClient httpCustomClient) {
        this.httpCustomClient = httpCustomClient;
    }

    private String getUrlPrefix() {
        String url = new StringBuilder().append("http://localhost:").append(serverPort)
                .append(contextPath).append("/test/okhttp/").toString();
        return url;
    }

    @ApiOperation(value="测试get请求-2021-01-06", notes="create by:朱全文")
    @GetMapping("/get")
    public ResponseEntity get() throws BaseException {
        try {
            String s = httpCustomClient.doGet(getUrlPrefix() + "/server/get");
            ResponseEntity responseEntity = JsonUtils.fromJson(s, ResponseEntity.class);
            return responseEntity;
        } catch (IOException e) {
            throw new BaseException("测试get请求出错", e);
        }
    }

    @GetMapping("/server/get")
    public ResponseEntity serverGet() {
        return new ResponseEntity();
    }

    @ApiOperation(value="测试post请求-2021-01-06", notes="create by:朱全文")
    @GetMapping("/post")
    public ResponseEntity post() throws BaseException {
        try {
            //header
            Map<String, String> header = new HashMap<>();
            header.put("Authorization", "xxxxxxxxxxx");
            Map<Object, Object> map = MapUtil.builder().put("a", "aaa").put("b", "bbb").build();
            String s = httpCustomClient.doPost(getUrlPrefix() + "/server/post", header, JsonUtils.toJson(map));
            ResponseEntity responseEntity = JsonUtils.fromJson(s, ResponseEntity.class);
            return responseEntity;
        } catch (IOException e) {
            throw new BaseException("测试get请求出错", e);
        }
    }

    @PostMapping("/server/post")
    public ResponseEntity serverPost(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        System.out.println(token);
        System.out.println(map);
        return new ResponseEntity();
    }

    @ApiOperation(value="测试put请求-2021-01-06", notes="create by:朱全文")
    @GetMapping("/put")
    public ResponseEntity put() throws BaseException {
        try {
            //header
            Map<String, String> header = new HashMap<>();
            header.put("Authorization", "xxxxxxxxxxx");
            Map<Object, Object> map = MapUtil.builder().put("a", "aaa").put("b", "bbb").build();
            String s = httpCustomClient.doPut(getUrlPrefix() + "/server/put", header, JsonUtils.toJson(map));
            ResponseEntity responseEntity = JsonUtils.fromJson(s, ResponseEntity.class);
            return responseEntity;
        } catch (IOException e) {
            throw new BaseException("测试put请求出错", e);
        }
    }

    @PutMapping("/server/put")
    public ResponseEntity serverPut(@RequestHeader("Authorization") String token, @RequestBody Map map) {
        System.out.println(token);
        System.out.println(map);
        return new ResponseEntity();
    }

    @ApiOperation(value="测试delete请求-2021-01-06", notes="create by:朱全文")
    @GetMapping("/delete")
    public ResponseEntity delete() throws BaseException {
        try {
            //header
            Map<String, String> header = new HashMap<>();
            header.put("Authorization", "xxxxxxxxxxx");
            String s = httpCustomClient.doDelete(getUrlPrefix() + "/server/delete", header);
            ResponseEntity responseEntity = JsonUtils.fromJson(s, ResponseEntity.class);
            return responseEntity;
        } catch (IOException e) {
            throw new BaseException("测试get请求出错", e);
        }
    }

    @DeleteMapping("/server/delete")
    public ResponseEntity serverDelete(@RequestHeader("Authorization") String token) {
        System.out.println(token);
        return new ResponseEntity();
    }


}
