package com.iscas.biz.mapper.common;

import com.iscas.biz.domain.common.WsData;
import com.iscas.biz.domain.common.WsDataExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WsDataMapper {
    long countByExample(WsDataExample example);

    int deleteByExample(WsDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WsData record);

    int insertSelective(WsData record);

    List<WsData> selectByExampleWithBLOBs(WsDataExample example);

    List<WsData> selectByExample(WsDataExample example);

    WsData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WsData record, @Param("example") WsDataExample example);

    int updateByExampleWithBLOBs(@Param("record") WsData record, @Param("example") WsDataExample example);

    int updateByExample(@Param("record") WsData record, @Param("example") WsDataExample example);

    int updateByPrimaryKeySelective(WsData record);

    int updateByPrimaryKeyWithBLOBs(WsData record);

    int updateByPrimaryKey(WsData record);

    @Delete("delete from ws_data where create_time < #{time,jdbcType=TIMESTAMP}")
    int deleteByTime(Date time);
}