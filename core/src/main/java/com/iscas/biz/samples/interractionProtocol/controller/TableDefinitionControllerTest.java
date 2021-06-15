package com.iscas.biz.samples.interractionProtocol.controller;

import com.iscas.biz.mp.table.service.TableDefinitionService;
import com.iscas.templet.common.BaseController;
import com.iscas.templet.common.ResponseEntity;
import com.iscas.templet.exception.BaseException;
import com.iscas.templet.exception.ValidDataException;
import com.iscas.templet.view.table.TableSearchRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 测试表格交互
 *
 * 使用前请先导入两个sql脚本，只导入结构就可以
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2021/1/4 17:10
 * @since jdk1.8
 */

@RestController
@RequestMapping("/test/table")
@Api(tags = "测试-表格")
public class TableDefinitionControllerTest extends BaseController {
    @Autowired
	private TableDefinitionService tableDefinitionService;

	@ApiOperation(value="获取表头", notes="不带数据，不带下拉列表")
    @GetMapping(value = "/{tableIdentity}/header", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getTableHeader(@PathVariable String tableIdentity) throws BaseException {
		return tableDefinitionService.getTableHeader(tableIdentity);
    }

	@ApiOperation(value="获取表头", notes="不带数据，带下拉列表")
	@GetMapping(value = "/{tableIdentity}/headerWithOption", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity getTableHeaderWithOption(@PathVariable String tableIdentity) throws BaseException {
		return tableDefinitionService.getHeaderWithOption(tableIdentity);
	}

	@ApiOperation(value="查询表格数据", notes="不带表头")
	@PostMapping(value = "/{tableIdentity}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity getData(@PathVariable String tableIdentity, @RequestBody TableSearchRequest request)
		throws ValidDataException {
		return tableDefinitionService.getData(tableIdentity, request, null);
	}

	@ApiOperation(value="删除数据", notes="根据主键删除数据")
	@DeleteMapping( value = "/{tableIdentity}/{primaryKey}")
	public ResponseEntity deleteData(@PathVariable String tableIdentity, @PathVariable Object primaryKey)
		throws ValidDataException {
		return tableDefinitionService.deleteData(tableIdentity, primaryKey);
	}

	@ApiOperation(value="删除数据", notes="根据主键删除数据")
	@PostMapping( value = "/{tableIdentity}/delete")
	public ResponseEntity batchDeleteData(@PathVariable String tableIdentity, @RequestBody List<Integer> ids)
			throws ValidDataException {
		for (Integer id : ids) {
			tableDefinitionService.deleteData(tableIdentity, id);
		}
		return new ResponseEntity();
	}

	@ApiOperation(value="修改/新增数据")
	@PostMapping(value = "/edit/{tableIdentity}")
	public ResponseEntity editData(@PathVariable String tableIdentity, @RequestBody Map<String,Object> data)
		throws ValidDataException {
		return tableDefinitionService.saveData(tableIdentity, data, false);
	}

//	@ApiOperation(value="新增数据", notes="更新")
//	@PostMapping(value = "/{tableIdentity}")
//	public ResponseEntity saveData(@PathVariable String tableIdentity, @RequestBody Map<String,Object> data)
//			throws ValidDataException {
//		return tableDefinitionService.saveData(tableIdentity, data, false);
//	}
}