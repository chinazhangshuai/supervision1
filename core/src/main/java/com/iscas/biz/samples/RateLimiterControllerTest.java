package com.iscas.biz.samples;

import com.iscas.base.biz.aop.ratelimiter.MethodRateLimit;
import com.iscas.templet.common.BaseController;
import com.iscas.templet.common.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2018/7/16
 * @since jdk1.8
 */
@RestController("/rateLimiter")
@Api(tags = "限流")
public class RateLimiterControllerTest extends BaseController {
    /**
    * 方法限流测试
    * */
    @MethodRateLimit(maxWait = 500,permitsPerSecond = 1)
    @GetMapping("/limit")
    @ApiOperation(value = "测试限流", notes = "测试方法级限流")
    public ResponseEntity limit(){
        ResponseEntity responseEntity = getResponse();
        return responseEntity;
    }
}
