package com.iscas.biz.samples.interractionProtocol.controller;

import com.iscas.biz.samples.interractionProtocol.model.TreeModelTest;
import com.iscas.biz.samples.interractionProtocol.service.TreeServiceTest;
import com.iscas.templet.common.BaseController;
import com.iscas.templet.common.ResponseEntity;
import com.iscas.templet.exception.BaseException;
import com.iscas.templet.view.tree.TreeResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 树协议测试
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2021/1/4 17:24
 * @since jdk1.8
 */
@RestController
@RequestMapping("/test/tree")
@Api(tags = "测试-树")
public class TreeControllerTest extends BaseController {
    private final TreeServiceTest treeServiceTest;

    public TreeControllerTest(TreeServiceTest treeServiceTest) {
        this.treeServiceTest = treeServiceTest;
    }

    @ApiOperation(value="测试获取树", notes="测试获取树")
    @GetMapping
    public ResponseEntity getTree() throws BaseException {
        TreeResponseData<TreeModelTest> treeData = treeServiceTest.getTree();
        ResponseEntity response = getResponse();
        response.setValue(treeData);
        return response;
    }
}
