package com.iscas.biz.samples.norepeatSubmit;

import com.iscas.base.biz.aop.norepeat.submit.NoRepeatSubmit;
import com.iscas.base.biz.service.common.OkHttpCustomClient;
import com.iscas.templet.common.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 防重复提交测试
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2021/1/4 18:25
 * @since jdk1.8
 */
@RestController
@RequestMapping("/test/norepeat/submit")
@Api(tags = "测试-放重复提交")
public class NoRepeatSubmitControllerTest {

    private final OkHttpCustomClient okHttpCustomClient;

    public NoRepeatSubmitControllerTest(OkHttpCustomClient okHttpCustomClient) {
        this.okHttpCustomClient = okHttpCustomClient;
    }

    @NoRepeatSubmit
    @GetMapping("/testNoRepeat")
    @ApiOperation(value="防重复提交测试-2021-01-06", notes="create by:朱全文")
    public ResponseEntity test() throws InterruptedException, IOException {
        for (int i = 0; i < 1000000; i++) {
//            System.out.println(1111);
        }
        return new ResponseEntity();
    }

}
