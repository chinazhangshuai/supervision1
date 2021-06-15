package com.iscas.biz.samples.datasongPlus.controller;

import com.iscas.base.biz.test.datasongplus.domain.Achievements;
import com.iscas.base.biz.test.datasongplus.repository.AchievementsRepository;
import com.iscas.biz.mp.table.service.TableDefinitionService;
import com.iscas.datasong.client.DataSongClient;
import com.iscas.datasong.client.DataSongHttpClient;
import com.iscas.datasong.client.domain.DataSongSearchResult;
import com.iscas.datasong.lib.common.DataSongException;
import com.iscas.datasong.lib.request.SearchDataRequest;
import com.iscas.templet.common.BaseController;
import com.iscas.templet.common.ResponseEntity;
import com.iscas.templet.exception.BaseException;
import com.iscas.templet.view.table.TableHeaderResponse;
import com.iscas.templet.view.table.TableResponseData;
import com.iscas.templet.view.table.TableSearchRequest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lirenshen
 * @vesion 1.0
 * @date 2021/3/8 14:10
 * @since jdk1.8
 */
@RestController
@RequestMapping("/datasong/plus/test")
@Api(tags = "对接datasong接口")
public class DataSongControllerTest extends BaseController {
    /**
     * AchievementsRepository 需要改成自定义实体类的Repository
     */
    @Autowired
    AchievementsRepository achievementsRepository;
    @Autowired
    TableDefinitionService tableDefinitionService;

    @PostMapping(value = {"/{tableIdentity}"}, produces = {"application/json;charset=UTF-8"})
    public ResponseEntity getData(@PathVariable String tableIdentity, @RequestBody TableSearchRequest request) throws BaseException {
        ResponseEntity response = getResponse();
        TableHeaderResponse header = tableDefinitionService.getHeaderWithOption(tableIdentity);


        try {
            DataSongClient dataSongClient = DataSongHttpClient.getInstance("", "");
            SearchDataRequest searchDataRequest = new SearchDataRequest();
            DataSongSearchResult<Achievements> achievementsDataSongSearchResult = dataSongClient.getDataService().searchData(Achievements.class, searchDataRequest);

        } catch (DataSongException e) {
            e.printStackTrace();
        }


        TableResponseData<List> toTableByRequest = achievementsRepository.findToTableByRequest(request, header.getValue());
        response.setValue(toTableByRequest);
        return response;
    }
}
