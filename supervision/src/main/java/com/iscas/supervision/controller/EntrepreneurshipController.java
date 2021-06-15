package com.iscas.supervision.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iscas.supervision.domain.DistrictBalanceDomain;
import com.iscas.supervision.domain.EntrepreneurshipDomain;
import com.iscas.supervision.service.EntrepreneurshipService;
import com.iscas.templet.common.ResponseEntity;
import com.iscas.templet.exception.BaseException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangshuai
 * @date 2021/6/15
 */
@RestController
@RequestMapping("/supervision/entrepreneurShip")
@Api(tags = "页面四，全省创业分析")
public class EntrepreneurshipController {

    @Autowired
    private EntrepreneurshipService entrepreneurshipService;

    /**
     * 全省产业结构相似度
     * 全省主体均衡发展情况
     * @param domain
     * @return
     * @throws BaseException
     */
    @PostMapping("/search")
    public ResponseEntity search(@RequestBody EntrepreneurshipDomain domain) throws BaseException {
        ResponseEntity responseEntity = new ResponseEntity();
        QueryWrapper<EntrepreneurshipDomain> ScjgQueryMapper = new QueryWrapper<>();

        if(domain.getHdType() != null){
            //类型
            ScjgQueryMapper.eq("HD_TYPE",domain.getHdType());
        }
        ScjgQueryMapper.orderByDesc("hd_name");
        List<EntrepreneurshipDomain> dbList = entrepreneurshipService.list(ScjgQueryMapper);
        responseEntity.setValue(dbList);
        return responseEntity;
    }

    /**
     * 全省市场主体区域分布
     * @param domain
     * @return
     * @throws BaseException
     */
    @PostMapping("/subjectRegion")
    public ResponseEntity subjectRegion(@RequestBody EntrepreneurshipDomain domain) throws BaseException {
        ResponseEntity responseEntity = new ResponseEntity();
        QueryWrapper<EntrepreneurshipDomain> districtBalanceWapper = new QueryWrapper<>();
        List<EntrepreneurshipDomain> dbList = new ArrayList<>();
        if(domain.getHdType() != null  && domain.getHdParentCode() == null){
            districtBalanceWapper.eq("HD_TYPE",domain.getHdType());
            districtBalanceWapper.eq("HD_PARENT_CODE","510000");
            dbList = entrepreneurshipService.list(districtBalanceWapper);
        }else if(domain.getHdType() != null && domain.getHdParentCode() != null){
            districtBalanceWapper.eq("HD_TYPE",domain.getHdType());
            districtBalanceWapper.eq("HD_PARENT_CODE",domain.getHdParentCode());
            dbList = entrepreneurshipService.list(districtBalanceWapper);
        }
        responseEntity.setValue(dbList);
        return responseEntity;
    }

}
