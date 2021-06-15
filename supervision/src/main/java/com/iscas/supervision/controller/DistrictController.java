package com.iscas.supervision.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iscas.supervision.domain.District;
import com.iscas.supervision.domain.DistrictBalanceDomain;
import com.iscas.supervision.mapper.DistrictMapper;
import com.iscas.supervision.service.DistrictService;
import com.iscas.templet.common.ResponseEntity;
import com.iscas.templet.exception.BaseException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangshuai
 * @date 2021/6/14
 */
@RestController
@RequestMapping("/supervision/getDistrict")
@Api(tags = "得到所有地区信息的控制类")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    /**
     * 得到市级代码
     * @param
     * @return
     * @throws BaseException
     */
    @PostMapping("/getLevelOne")
    public ResponseEntity search() throws BaseException {
        ResponseEntity responseEntity = new ResponseEntity();
        QueryWrapper<District> districtQueryMapper = new QueryWrapper<>();


        districtQueryMapper.eq("DOMDISTRICT_LEVEL","2");

        districtQueryMapper.orderByAsc("DOMDISTRICT");
        List<District> districtList = districtService.list(districtQueryMapper);
        responseEntity.setValue(districtList);
        return responseEntity;
    }

}
