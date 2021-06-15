package com.iscas.biz.samples;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.iscas.base.biz.util.SpringUtils;
import com.iscas.templet.common.BaseController;
import com.iscas.templet.common.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2020/8/17 20:49
 * @since jdk1.8
 */
@RestController
@Api(tags = "验证码")
@Slf4j
@ConditionalOnProperty(havingValue = "true", value = "kaptcha.enabled", matchIfMissing = false)
@RequestMapping("/verification")
public class VerificationCodeControllerTest extends BaseController {
    @Autowired
    private Producer producer;

    /**
     * 获取验证码
     * */
    @GetMapping("/kaptcha")
    @ApiOperation(value = "获取验证码", notes = "获取验证码")
    public void kaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = producer.createText();
        log.debug("*************验证码已经生成为：{}******************", capText);
        // 将验证码存于session中,分布式部署需要共享session，或存入共享存储中
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        BufferedImage bi = producer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // 向页面输出验证码
        ImageIO.write(bi, "jpg", out);
        try {
            // 清空缓存区
            out.flush();
        } finally {
            // 关闭输出流
            out.close();
        }
    }

    /**
     * 校验验证码
     * */
    @GetMapping("/verify")
    @ApiOperation(value = "校验验证码", notes = "校验验证码")
    public ResponseEntity verify(String code) throws Exception {
        ResponseEntity response = getResponse();
        // 获取Session中验证码
        Object storeCode = SpringUtils.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        // 判断验证码是否为空
        if (StringUtils.isEmpty(code)) {
            response.setValue(false);
        } else {
            // 校验验证码的正确与否
            boolean result = Objects.equals(code, storeCode);
            if (result) {
                //将验证码从session中删掉
                SpringUtils.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
            }
            response.setValue(result);
        }
        return response;
    }
}
