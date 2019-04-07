package com.example.videohttp.dao;

import com.example.videohttp.mapper.TLiveMapper;
import com.example.videohttp.module.TLive;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface LiveDao extends TLiveMapper {
    @UpdateProvider(type = LiveSqlProvider.class, method = "updateOrInsert")
    int updateOrInsert(TLive record);

    @Select({"select", "id, userId, liveTitle, liveIcon, liveAddress, liveStatus, liveHdAddress," +
            " liveLdAddress, ", "liveSdAddress, liveDescription", "from v_live order by id desc", "limit #{currentPage,jdbcType=INTEGER},#{nextPage,jdbcType=INTEGER}"})
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "userId", property = "userId", jdbcType = JdbcType.INTEGER),
            @Result(column = "liveTitle", property = "liveTitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveIcon", property = "liveIcon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveAddress", property = "liveAddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveStatus", property = "liveStatus", jdbcType = JdbcType.INTEGER),
            @Result(column = "liveHdAddress", property = "liveHdAddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveLdAddress", property = "liveLdAddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveSdAddress", property = "liveSdAddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveDescription", property = "liveDescription", jdbcType = JdbcType.VARCHAR)
    })
    List<TLive> selectByPages(@Param("currentPage") int currentPage, @Param("nextPage") int nextPage);

    @UpdateProvider(type = LiveSqlProvider.class, method = "updateByUserIdSelective")
    int updateByUserIdSelective(TLive record);
}
