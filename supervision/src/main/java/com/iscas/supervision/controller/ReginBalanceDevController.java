package com.iscas.supervision.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iscas.biz.mp.mapper.DynamicMapper;
import com.iscas.supervision.domain.District;
import com.iscas.supervision.domain.DistrictBalanceDomain;
import com.iscas.supervision.mapper.DistrictMapper;
import com.iscas.supervision.service.DistrictBalanceService;
import com.iscas.supervision.service.DistrictService;
import com.iscas.templet.common.ResponseEntity;
import com.iscas.templet.exception.BaseException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangshuai
 * @date 2021/6/11
 */
@RestController
@RequestMapping("/supervision/regionalBalance")
@Api(tags = "页面二，区域协调发展")
public class ReginBalanceDevController {

    @Autowired
    private DistrictBalanceService districtBalanceService;

    @Autowired
    private DistrictService districtService;

    /**
     * 全省产业结构相似度
     * 全省主体均衡发展情况
     * @param domain
     * @return
     * @throws BaseException
     */
    @PostMapping("/search")
    public ResponseEntity search(@RequestBody DistrictBalanceDomain domain) throws BaseException {
        ResponseEntity responseEntity = new ResponseEntity();
        QueryWrapper<DistrictBalanceDomain> ScjgQueryMapper = new QueryWrapper<>();

        if(domain.getHdType() != null){
            //类型
            ScjgQueryMapper.eq("HD_TYPE",domain.getHdType());
        }
        ScjgQueryMapper.orderByDesc("hd_name");
        List<DistrictBalanceDomain> dbList = districtBalanceService.list(ScjgQueryMapper);
        responseEntity.setValue(dbList);
        return responseEntity;
    }

    /**
     * 区域产业结构相似度对比
     * @param domain
     * @return
     * @throws BaseException
     */
    @PostMapping("/simiComparison")
    public ResponseEntity simiComparison(@RequestBody DistrictBalanceDomain domain) throws BaseException {
        ResponseEntity responseEntity = new ResponseEntity();

        QueryWrapper<District> districtQueryWrapper = new QueryWrapper<>();
//        Map<String,List<DistrictBalanceDomain>> map = new HashMap<>();
        List<List<DistrictBalanceDomain>> resultLists = new ArrayList<>();
        if(domain.getHdType() != null){
            if(domain.getHdChildrenCode() != null){
                String[] distictCode = domain.getHdChildrenCode().split(",");
                for(int i = 0;i<distictCode.length;i++){
                    QueryWrapper<District> districtQueryWrapperWith = new QueryWrapper<>();
                    districtQueryWrapperWith.eq("DOMDISTRICT",distictCode[i]);
                    District district = districtService.getOne(districtQueryWrapperWith);

                    QueryWrapper<DistrictBalanceDomain> districtBalanceWapper = new QueryWrapper<>();
                    districtBalanceWapper.eq("HD_TYPE",domain.getHdType());
                    districtBalanceWapper.eq("HD_CHILDREN_CODE",district.getDomDistrict());
                    List<DistrictBalanceDomain> lists = districtBalanceService.list(districtBalanceWapper);
                    for(DistrictBalanceDomain districtBalanceDomain:lists){
                        districtBalanceDomain.setHdSName(district.getDomDistrictName());
                    }
                    resultLists.add(lists);
                }
            }else {
                districtQueryWrapper.eq("DOMDISTRICT_LEVEL","2");
                districtQueryWrapper.orderByDesc("DOMDISTRICT");
                List<District> lists = districtService.list(districtQueryWrapper);

                for(District district:lists){
                    QueryWrapper<DistrictBalanceDomain> districtBalanceWapper = new QueryWrapper<>();
                    districtBalanceWapper.eq("HD_TYPE",domain.getHdType());
                    districtBalanceWapper.eq("HD_CHILDREN_CODE",district.getDomDistrict());
                    districtBalanceWapper.orderByDesc("HD_CHILDREN_CODE");
                    List<DistrictBalanceDomain> dbList = districtBalanceService.list(districtBalanceWapper);
                    for(DistrictBalanceDomain districtBalanceDomain:dbList){
                        districtBalanceDomain.setHdSName(district.getDomDistrictName());
                    }
                    resultLists.add(dbList);
                }
            }
        }
        responseEntity.setValue(resultLists);
        return responseEntity;
    }

    /**
     * 全省市场主体区域分布
     * @param domain
     * @return
     * @throws BaseException
     */
    @PostMapping("/subjectRegion")
    public ResponseEntity subjectRegion(@RequestBody DistrictBalanceDomain domain) throws BaseException {
        ResponseEntity responseEntity = new ResponseEntity();
        QueryWrapper<DistrictBalanceDomain> districtBalanceWapper = new QueryWrapper<>();
        List<DistrictBalanceDomain> dbList = new ArrayList<>();
        if(domain.getHdType() != null && domain.getHdCode() != null && domain.getHdParentCode() == null){
            districtBalanceWapper.eq("HD_TYPE",domain.getHdType());
            districtBalanceWapper.eq("HD_CODE",domain.getHdCode());
            districtBalanceWapper.eq("HD_PARENT_CODE","510000");
            dbList = districtBalanceService.list(districtBalanceWapper);
        }else if(domain.getHdType() != null && domain.getHdCode() != null && domain.getHdParentCode() != null){
            districtBalanceWapper.eq("HD_TYPE",domain.getHdType());
            districtBalanceWapper.eq("HD_CODE",domain.getHdCode());
            districtBalanceWapper.eq("HD_PARENT_CODE",domain.getHdParentCode());
            dbList = districtBalanceService.list(districtBalanceWapper);
        }
        responseEntity.setValue(dbList);
        return responseEntity;
    }


}

