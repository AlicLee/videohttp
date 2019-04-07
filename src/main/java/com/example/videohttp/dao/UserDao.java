package com.example.videohttp.dao;

import com.example.videohttp.mapper.TUserMapper;
import com.example.videohttp.module.TUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface UserDao extends TUserMapper {
    /**
     * 根据用户名和密码查询
     */
    @Select({
            "select",
            "id, userName, userAge, userPhone, userEmail, userPassword, userCreateTime, userBirthDay, ",
            "userSex,userIcon",
            "from v_user",
            "where userPhone = #{userPhone,jdbcType=VARCHAR} and userPassword=#{userPassword,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "userName", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userAge", property = "userAge", jdbcType = JdbcType.INTEGER),
            @Result(column = "userPhone", property = "userPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userEmail", property = "userEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userPassword", property = "userPassword", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userCreateTime", property = "userCreateTime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userBirthDay", property = "userBirthDay", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userSex", property = "userSex", jdbcType = JdbcType.INTEGER),
            @Result(column = "userIcon", property = "userIcon", jdbcType = JdbcType.VARCHAR)

    })
    TUser selectByUserNameAndPassword(@Param("userPhone") String userPhone, @Param("userPassword") String userPassword);

    /**
     * 根据用户名查询
     */
    @Select({
            "select",
            "id, userName, userAge, userPhone, userEmail, userPassword, userCreateTime, userBirthDay, ",
            "userSex",
            "from v_user",
            "where userPhone = #{userPhone,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "userName", property = "userName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userAge", property = "userAge", jdbcType = JdbcType.INTEGER),
            @Result(column = "userPhone", property = "userPhone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userEmail", property = "userEmail", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userPassword", property = "userPassword", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userCreateTime", property = "userCreateTime", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userBirthDay", property = "userBirthDay", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userSex", property = "userSex", jdbcType = JdbcType.INTEGER),
            @Result(column = "userIcon", property = "userIcon", jdbcType = JdbcType.VARCHAR)
    })
    TUser selectByUserName(@Param("userPhone") String userPhone);
}
