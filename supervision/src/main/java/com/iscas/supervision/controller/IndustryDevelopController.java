package com.iscas.supervision.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iscas.supervision.domain.IndustryCoDevelopDomain;
import com.iscas.supervision.domain.IndustryCoDevelopDomain2;
import com.iscas.supervision.service.IndustryCoDevelop2Service;
import com.iscas.supervision.service.IndustryCoDevelopService;
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
 * @date 2021/6/15
 */
@RestController
@RequestMapping("/supervision/industryDevelopment")
@Api(tags = "页面三，产业发展检测")
public class IndustryDevelopController {

    @Autowired
    private IndustryCoDevelopService industryCoDevelopService;

    @Autowired
    private IndustryCoDevelop2Service industryCoDevelop2Service;
    /**
     * 产业发展趋势
     * @param domain
     * @return
     * @throws BaseException
     */
    @PostMapping("/search")
    public ResponseEntity search(@RequestBody IndustryCoDevelopDomain domain) throws BaseException {
        ResponseEntity responseEntity = new ResponseEntity();
        QueryWrapper<IndustryCoDevelopDomain> ScjgQueryMapper = new QueryWrapper<>();

        if(domain.getHdType() != null){
            //类型
            ScjgQueryMapper.eq("HD_TYPE",domain.getHdType());
        }
        ScjgQueryMapper.orderByDesc("hd_name");
        List<IndustryCoDevelopDomain> dbList = industryCoDevelopService.list(ScjgQueryMapper);
        responseEntity.setValue(dbList);
        return responseEntity;
    }

    /**
     * 各行业发展情况
     * @param domain
     * @return
     * @throws BaseException
     */
    @PostMapping("/Industries")
    public ResponseEntity getIndustries(@RequestBody IndustryCoDevelopDomain2 domain) throws BaseException {
        ResponseEntity responseEntity = new ResponseEntity();
        QueryWrapper<IndustryCoDevelopDomain2> ScjgQueryMapper = new QueryWrapper<>();

        if(domain.getHdType() != null){
            //类型
            ScjgQueryMapper.eq("HD_TYPE",domain.getHdType());
        }
        ScjgQueryMapper.orderByDesc("hd_name");
        List<IndustryCoDevelopDomain2> dbList = industryCoDevelop2Service.list(ScjgQueryMapper);
        responseEntity.setValue(dbList);
        return responseEntity;
    }


}
