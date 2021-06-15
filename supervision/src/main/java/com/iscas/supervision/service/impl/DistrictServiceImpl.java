package com.iscas.supervision.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iscas.supervision.domain.District;
import com.iscas.supervision.domain.RegionCapitalFlow;
import com.iscas.supervision.mapper.DistrictMapper;
import com.iscas.supervision.mapper.RegionCapitalFlowMapper;
import com.iscas.supervision.service.DistrictService;
import com.iscas.supervision.service.RegionCapitalFlowService;
import org.springframework.stereotype.Service;

/**
 * @author zhangshuai
 * @date 2021/6/11
 */
@Service
public class DistrictServiceImpl extends ServiceImpl<DistrictMapper, District> implements DistrictService {
}
