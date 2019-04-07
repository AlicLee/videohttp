package com.example.videohttp.dao;

import com.example.videohttp.mapper.TVideoMapper;
import com.example.videohttp.module.TVideo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface VideoDao extends TVideoMapper {
    @Select({
            "select",
            "id, name, path, userid,coverPath",
            "from v_video order by id desc",
            "limit #{currentPage,jdbcType=INTEGER},#{nextPage,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "path", property = "path", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
            @Result(column="coverPath", property="coverPath", jdbcType=JdbcType.VARCHAR)
    })
    List<TVideo> getVideoByPages(@Param("currentPage") int pageIndex, @Param("nextPage") int pageSize);

    @Insert(
            "<script>" +
                    "INSERT INTO v_video(id,name,path,userid,coverPath) VALUES" +
                    "<foreach collection=\"list\" item=\"item1\" index=\"index\"  separator=\",\">" +
                    "(#{item1.id},#{item1.name},#{item1.path},#{item1.userid},#{item1.coverPath})" +
                    "</foreach>" +
                    "</script>"
    )
    int batchInsertVideo(@Param("list") List<TVideo> videoList);
}
