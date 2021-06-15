package com.iscas.biz.mapper.common;

import com.iscas.biz.domain.common.RoleMenuExample;
import com.iscas.biz.domain.common.RoleMenuKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMenuMapper {
    long countByExample(RoleMenuExample example);

    int deleteByExample(RoleMenuExample example);

    int deleteByPrimaryKey(RoleMenuKey key);

    int insert(RoleMenuKey record);

    int insertSelective(RoleMenuKey record);

    List<RoleMenuKey> selectByExample(RoleMenuExample example);

    int updateByExampleSelective(@Param("record") RoleMenuKey record, @Param("example") RoleMenuExample example);

    int updateByExample(@Param("record") RoleMenuKey record, @Param("example") RoleMenuExample example);
}