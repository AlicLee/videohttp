package com.example.videohttp.mapper;

import com.example.videohttp.module.TLive;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

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
            "liveHdAddress, liveLdAddress, ",
            "liveSdAddress, liveDescption)",
            "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
            "#{livetitle,jdbcType=VARCHAR}, #{liveicon,jdbcType=VARCHAR}, ",
            "#{liveaddress,jdbcType=VARCHAR}, #{livestatus,jdbcType=INTEGER}, ",
            "#{livehdaddress,jdbcType=VARCHAR}, #{liveldaddress,jdbcType=VARCHAR}, ",
            "#{livesdaddress,jdbcType=VARCHAR}, #{livedescption,jdbcType=VARCHAR})"
    })
    int insert(TLive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_live
     *
     * @mbg.generated
     */
    @InsertProvider(type = TLiveSqlProvider.class, method = "insertSelective")
    int insertSelective(TLive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_live
     *
     * @mbg.generated
     */
    @Select({
            "select",
            "id, userId, liveTitle, liveIcon, liveAddress, liveStatus, liveHdAddress, liveLdAddress, ",
            "liveSdAddress, liveDescption",
            "from v_live",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "userId", property = "userid", jdbcType = JdbcType.INTEGER),
            @Result(column = "liveTitle", property = "livetitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveIcon", property = "liveicon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveAddress", property = "liveaddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveStatus", property = "livestatus", jdbcType = JdbcType.INTEGER),
            @Result(column = "liveHdAddress", property = "livehdaddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveLdAddress", property = "liveldaddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveSdAddress", property = "livesdaddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveDescption", property = "livedescption", jdbcType = JdbcType.VARCHAR)
    })
    TLive selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_live
     *
     * @mbg.generated
     */
    @Select({
            "select",
            "id, userId, liveTitle, liveIcon, liveAddress, liveStatus, liveHdAddress, liveLdAddress, ",
            "liveSdAddress, liveDescption",
            "from v_live",
            "limit #{currentIndex},#{pageSize}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "userId", property = "userid", jdbcType = JdbcType.INTEGER),
            @Result(column = "liveTitle", property = "livetitle", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveIcon", property = "liveicon", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveAddress", property = "liveaddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveStatus", property = "livestatus", jdbcType = JdbcType.INTEGER),
            @Result(column = "liveHdAddress", property = "livehdaddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveLdAddress", property = "liveldaddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveSdAddress", property = "livesdaddress", jdbcType = JdbcType.VARCHAR),
            @Result(column = "liveDescption", property = "livedescption", jdbcType = JdbcType.VARCHAR)
    })
    List<TLive> selectByPages(int currPage, int pageSize);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_live
     *
     * @mbg.generated
     */
    @UpdateProvider(type = TLiveSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TLive record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_live
     *
     * @mbg.generated
     */
    @Update({
            "update v_live",
            "set userId = #{userid,jdbcType=INTEGER},",
            "liveTitle = #{livetitle,jdbcType=VARCHAR},",
            "liveIcon = #{liveicon,jdbcType=VARCHAR},",
            "liveAddress = #{liveaddress,jdbcType=VARCHAR},",
            "liveStatus = #{livestatus,jdbcType=INTEGER},",
            "liveHdAddress = #{livehdaddress,jdbcType=VARCHAR},",
            "liveLdAddress = #{liveldaddress,jdbcType=VARCHAR},",
            "liveSdAddress = #{livesdaddress,jdbcType=VARCHAR},",
            "liveDescption = #{livedescption,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TLive record);

    @UpdateProvider(type = TLiveSqlProvider.class, method = "updateOrInsert")
    int updateOrInsert(TLive record);
}