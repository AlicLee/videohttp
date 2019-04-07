package com.example.videohttp.dao;

import com.example.videohttp.mapper.TLiveSqlProvider;
import com.example.videohttp.module.TLive;
import org.apache.ibatis.jdbc.SQL;

import java.util.ArrayList;
import java.util.List;

public class LiveSqlProvider extends TLiveSqlProvider {
    public String updateOrInsert(TLive record) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("replace into v_live set");
        List<String> paramList = new ArrayList();
        if (record.getUserId() != null) {
            paramList.add(" userId = #{userId,jdbcType=INTEGER}");
        }
        if (record.getLiveTitle() != null) {
            paramList.add(" liveTitle = #{liveTitle,jdbcType=VARCHAR}");
        }
        if (record.getLiveIcon() != null) {
            paramList.add(" liveIcon = #{liveIcon,jdbcType=VARCHAR}");
        }
        if (record.getLiveAddress() != null) {
            paramList.add(" liveAddress = #{liveAddress,jdbcType=VARCHAR}");
        }
        if (record.getLiveStatus() != null) {
            paramList.add(" liveStatus = #{liveStatus,jdbcType=INTEGER}");
        }
        if (record.getLiveHdAddress() != null) {
            paramList.add(" liveHdAddress = #{liveHdAddress,jdbcType=VARCHAR}");
        }
        if (record.getLiveLdAddress() != null) {
            paramList.add(" liveLdAddress = #{liveLdAddress,jdbcType=VARCHAR}");
        }
        if (record.getLiveSdAddress() != null) {
            paramList.add(" liveSdAddress = #{liveSdAddress,jdbcType=VARCHAR}");
        }
        if (record.getLiveDescription() != null) {
            paramList.add(" liveDescription = #{liveDescription,jdbcType=VARCHAR}");
        }
        String paramString = String.join(",", paramList);
        sqlBuilder.append(paramString);
        System.out.println("sqlBuilder:" + sqlBuilder.toString());
        return sqlBuilder.toString();
    }

    public String updateByUserIdSelective(TLive record) {
        SQL sql = new SQL();
        sql.UPDATE("v_live");
        if (record.getLiveTitle() != null) {
            sql.SET("liveTitle = #{liveTitle,jdbcType=VARCHAR}");
        }

        if (record.getLiveIcon() != null) {
            sql.SET("liveIcon = #{liveIcon,jdbcType=VARCHAR}");
        }

        if (record.getLiveAddress() != null) {
            sql.SET("liveAddress = #{liveAddress,jdbcType=VARCHAR}");
        }

        if (record.getLiveStatus() != null) {
            sql.SET("liveStatus = #{liveStatus,jdbcType=INTEGER}");
        }

        if (record.getLiveHdAddress() != null) {
            sql.SET("liveHdAddress = #{liveHdAddress,jdbcType=VARCHAR}");
        }

        if (record.getLiveLdAddress() != null) {
            sql.SET("liveLdAddress = #{liveLdAddress,jdbcType=VARCHAR}");
        }

        if (record.getLiveSdAddress() != null) {
            sql.SET("liveSdAddress = #{liveSdAddress,jdbcType=VARCHAR}");
        }

        if (record.getLiveDescription() != null) {
            sql.SET("liveDescription = #{liveDescription,jdbcType=VARCHAR}");
        }
        sql.WHERE("userId=#{userId,jdbcType=INTEGER}");
        return sql.toString();
    }
}
