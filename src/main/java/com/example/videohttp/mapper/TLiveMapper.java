package com.example.videohttp.mapper;

import com.example.videohttp.module.TLive;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TLiveMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_live
     *
     * @mbg.generated
     */
    @Delete({
        "delete from v_live",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_live
     *
     * @mbg.generated
     */
    @Insert({
        "insert into v_live (id, userId, ",
        "liveTitle, liveIcon, ",
        "liveAddress, liveStatus, ",
        "liveHdAddress, liveSdAddress, ",
        "liveDescription, liveLdAddress)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{liveTitle,jdbcType=VARCHAR}, #{liveIcon,jdbcType=VARCHAR}, ",
        "#{liveAddress,jdbcType=VARCHAR}, #{liveStatus,jdbcType=INTEGER}, ",
        "#{liveHdAddress,jdbcType=VARCHAR}, #{liveSdAddress,jdbcType=VARCHAR}, ",
        "#{liveDescription,jdbcType=VARCHAR}, #{liveLdAddress,jdbcType=VARCHAR})"
    })
    int insert(TLive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_live
     *
     * @mbg.generated
     */
    @InsertProvider(type=TLiveSqlProvider.class, method="insertSelective")
    int insertSelective(TLive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_live
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, userId, liveTitle, liveIcon, liveAddress, liveStatus, liveHdAddress, liveSdAddress, ",
        "liveDescription, liveLdAddress",
        "from v_live",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="liveTitle", property="liveTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="liveIcon", property="liveIcon", jdbcType=JdbcType.VARCHAR),
        @Result(column="liveAddress", property="liveAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="liveStatus", property="liveStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="liveHdAddress", property="liveHdAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="liveSdAddress", property="liveSdAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="liveDescription", property="liveDescription", jdbcType=JdbcType.VARCHAR),
        @Result(column="liveLdAddress", property="liveLdAddress", jdbcType=JdbcType.VARCHAR)
    })
    TLive selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_live
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TLiveSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_live
     *
     * @mbg.generated
     */
    @Update({
        "update v_live",
        "set userId = #{userId,jdbcType=INTEGER},",
          "liveTitle = #{liveTitle,jdbcType=VARCHAR},",
          "liveIcon = #{liveIcon,jdbcType=VARCHAR},",
          "liveAddress = #{liveAddress,jdbcType=VARCHAR},",
          "liveStatus = #{liveStatus,jdbcType=INTEGER},",
          "liveHdAddress = #{liveHdAddress,jdbcType=VARCHAR},",
          "liveSdAddress = #{liveSdAddress,jdbcType=VARCHAR},",
          "liveDescription = #{liveDescription,jdbcType=VARCHAR},",
          "liveLdAddress = #{liveLdAddress,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TLive record);
}