package com.iscas.supervision.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iscas.supervision.domain.DistrictBalanceDomain;
import com.iscas.supervision.domain.IndustryCoDevelopDomain;
import com.iscas.supervision.mapper.DistrictBalanceMapper;
import com.iscas.supervision.mapper.IndustryCoDevelopMapper;
import com.iscas.supervision.service.DistrictBalanceService;
import com.iscas.supervision.service.IndustryCoDevelopService;
import org.springframework.stereotype.Service;

/**
 * @author zhangshuai
 * @date 2021/6/15
 */
@Service
public class IndustryCoDevelopServiceImpl extends ServiceImpl<IndustryCoDevelopMapper, IndustryCoDevelopDomain> implements IndustryCoDevelopService {
}
