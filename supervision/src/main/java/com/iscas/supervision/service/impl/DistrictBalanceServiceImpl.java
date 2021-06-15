package com.iscas.supervision.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iscas.supervision.domain.DistrictBalanceDomain;
import com.iscas.supervision.mapper.DistrictBalanceMapper;
import com.iscas.supervision.service.DistrictBalanceService;
import org.springframework.stereotype.Service;

/**
 * @author zhangshuai
 * @date 2021/6/11
 */
@Service
public class DistrictBalanceServiceImpl extends ServiceImpl<DistrictBalanceMapper, DistrictBalanceDomain> implements DistrictBalanceService {
}
