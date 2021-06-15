package com.iscas.biz.samples.datasongPlus.controller;

import com.iscas.base.biz.test.datasongplus.domain.Achievements;
import com.iscas.base.biz.test.datasongplus.repository.AchievementsRepository;
import com.iscas.base.biz.test.datasongplus.service.AchievementsService;
import com.iscas.biz.mp.table.service.TableDefinitionService;
import com.iscas.templet.common.BaseController;
import com.iscas.templet.common.ResponseEntity;
import com.iscas.templet.exception.BaseException;
import com.iscas.templet.view.table.TableHeaderResponse;
import com.iscas.templet.view.table.TableResponse;
import com.iscas.templet.view.table.TableResponseData;
import com.iscas.templet.view.table.TableSearchRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2020/3/2 10:57
 * @since jdk1.8
 */
@RestController
@RequestMapping("/test/datasong/plus")
@Api(tags = "测试-使用datasong-client-plus")
public class AchievementsControllerTest extends BaseController {
    @Autowired
    private AchievementsService achievementsService;
    @Autowired
    AchievementsRepository achievementsRepository;
    @Autowired
    TableDefinitionService tableDefinitionService;

    @ApiOperation(value="[测试/XXX] 测试datasong-client-plus的查询，带分页排序", notes="create by:朱全文 2020-03-02")
//    @ApiImplicitParams(
//            {
//                    @ApiImplicitParam(name = "map", value = "上传到数据", required = true, dataType = "TableSearchRequest")
//            }
//    )
    @GetMapping()
    public ResponseEntity findByPage() {
        List<Achievements> all = achievementsService.findByPage();
        ResponseEntity response = getResponse();
        response.setValue(all);
        return response;
    }

    @ApiOperation(value="[测试/XXX] 测试datasong-client-plus的查询，直接返回表", notes="create by:朱全文 2020-03-02")
//    @ApiImplicitParams(
//            {
//                    @ApiImplicitParam(name = "map", value = "上传到数据", required = true, dataType = "TableSearchRequest")
//            }
//    )
    @GetMapping("/totable")
    public TableResponse findToTable() {
        TableResponseData<List> tableResponseData = achievementsService.findToTable();
        TableResponse response = new TableResponse();
        response.setValue(tableResponseData);
        return response;
    }

    @ApiOperation(value="[测试/XXX] 测试新增", notes="create by:朱全文 2020-03-02")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "achievements", value = "新增的数据", required = true, dataType = "Achievements")
            }
    )
    @PostMapping()
    public ResponseEntity save(@RequestBody Achievements achievements) {
        ResponseEntity response = getResponse();
        String id = achievementsService.save(achievements);
        response.setValue(id);
        return response;
    }

    @ApiOperation(value="[测试/XXX] 测试查询", notes="create by:朱全文 2020-03-02")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "String", value = "查询的数据", required = true, dataType = "String")
            }
    )
    @GetMapping("/search")
    public ResponseEntity search(@RequestParam String name) {
        ResponseEntity response = getResponse();
        List<Achievements> achievements = achievementsService.findByAuthorCNLike(name);
        response.setValue(achievements);
        return response;
    }

    @ApiOperation(value="[测试/XXX] 测试删除", notes="create by:朱全文 2020-03-02")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "String", value = "待删除的ID", required = true, dataType = "String")
            }
    )
    @DeleteMapping()
    public ResponseEntity delete(@RequestParam String id) {
        ResponseEntity response = getResponse();
        boolean flag = achievementsService.delete(id);
        response.setValue(flag);
        return response;
    }

    @PostMapping(value = {"/{tableIdentity}"}, produces = {"application/json;charset=UTF-8"})
    public ResponseEntity getData(@PathVariable String tableIdentity, @RequestBody TableSearchRequest request) throws BaseException {
        ResponseEntity response = getResponse();
        TableHeaderResponse header = tableDefinitionService.getHeaderWithOption(tableIdentity);
        TableResponseData<List> toTableByRequest = achievementsRepository.findToTableByRequest(request, header.getValue());
        response.setValue(toTableByRequest);
        return response;
    }
}
