package com.iscas.biz.mapper.common;

import com.iscas.biz.domain.common.Org;
import com.iscas.biz.domain.common.OrgExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgMapper {
    long countByExample(OrgExample example);

    int deleteByExample(OrgExample example);

    int deleteByPrimaryKey(Integer orgId);

    Integer insert(Org record);

    int insertSelective(Org record);

    List<Org> selectByExampleWithBLOBs(OrgExample example);

    List<Org> selectByExample(OrgExample example);

    Org selectByPrimaryKey(Integer orgId);

    int updateByExampleSelective(@Param("record") Org record, @Param("example") OrgExample example);

    int updateByExampleWithBLOBs(@Param("record") Org record, @Param("example") OrgExample example);

    int updateByExample(@Param("record") Org record, @Param("example") OrgExample example);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKeyWithBLOBs(Org record);

    int updateByPrimaryKey(Org record);
}