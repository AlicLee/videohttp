package com.example.videohttp.mapper;

import com.example.videohttp.module.TSrs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TSrsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_srs
     *
     * @mbg.generated
     */
    @Delete({
        "delete from v_srs",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_srs
     *
     * @mbg.generated
     */
    @Insert({
        "insert into v_srs (id, action, ",
        "client_id, ip, vhost, ",
        "custom, createTime)",
        "values (#{id,jdbcType=INTEGER}, #{action,jdbcType=VARCHAR}, ",
        "#{client_id,jdbcType=INTEGER}, #{ip,jdbcType=VARCHAR}, #{vhost,jdbcType=VARCHAR}, ",
        "#{custom,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(TSrs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_srs
     *
     * @mbg.generated
     */
    @InsertProvider(type=TSrsSqlProvider.class, method="insertSelective")
    int insertSelective(TSrs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_srs
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, action, client_id, ip, vhost, custom, createTime",
        "from v_srs",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_id", property="client_id", jdbcType=JdbcType.INTEGER),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="vhost", property="vhost", jdbcType=JdbcType.VARCHAR),
        @Result(column="custom", property="custom", jdbcType=JdbcType.VARCHAR),
        @Result(column="createTime", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    TSrs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_srs
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TSrsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSrs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_srs
     *
     * @mbg.generated
     */
    @Update({
        "update v_srs",
        "set action = #{action,jdbcType=VARCHAR},",
          "client_id = #{client_id,jdbcType=INTEGER},",
          "ip = #{ip,jdbcType=VARCHAR},",
          "vhost = #{vhost,jdbcType=VARCHAR},",
          "custom = #{custom,jdbcType=VARCHAR},",
          "createTime = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TSrs record);
}