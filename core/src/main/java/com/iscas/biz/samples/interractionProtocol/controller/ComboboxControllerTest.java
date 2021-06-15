package com.iscas.biz.samples.interractionProtocol.controller;

import com.iscas.biz.samples.interractionProtocol.model.TreeModelTest;
import com.iscas.biz.samples.interractionProtocol.service.ComboboxServiceTest;
import com.iscas.templet.common.BaseController;
import com.iscas.templet.common.ResponseEntity;
import com.iscas.templet.exception.BaseException;
import com.iscas.templet.view.table.ComboboxData;
import com.iscas.templet.view.tree.TreeResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * 下拉列表协议使用demo
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2021/1/4 17:51
 * @since jdk1.8
 */
@RestController
@RequestMapping("/test/combobox")
@Api(tags = "测试-下拉列表")
public class ComboboxControllerTest extends BaseController {
    private final ComboboxServiceTest comboboxServiceTest;

    public ComboboxControllerTest(ComboboxServiceTest comboboxServiceTest) {
        this.comboboxServiceTest = comboboxServiceTest;
    }

    @ApiOperation(value="测试获取下拉列表", notes="测试获取下拉列表")
    @GetMapping
    public ResponseEntity getTree() throws BaseException {
        List<ComboboxData> comboboxDatas = comboboxServiceTest.getCombobox();
        ResponseEntity response = getResponse();
        response.setValue(comboboxDatas);
        return response;
    }
}
