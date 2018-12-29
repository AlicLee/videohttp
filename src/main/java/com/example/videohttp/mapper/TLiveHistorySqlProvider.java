package com.example.videohttp.mapper;

import com.example.videohttp.module.TLiveHistory;
import org.apache.ibatis.jdbc.SQL;

public class TLiveHistorySqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_liveHistory
     *
     * @mbg.generated
     */
    public String insertSelective(TLiveHistory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("v_liveHistory");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("createTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFilepath() != null) {
            sql.VALUES("filePath", "#{filepath,jdbcType=VARCHAR}");
        }
        
        if (record.getUserid() != null) {
            sql.VALUES("userId", "#{userid,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_liveHistory
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(TLiveHistory record) {
        SQL sql = new SQL();
        sql.UPDATE("v_liveHistory");
        
        if (record.getCreatetime() != null) {
            sql.SET("createTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFilepath() != null) {
            sql.SET("filePath = #{filepath,jdbcType=VARCHAR}");
        }
        
        if (record.getUserid() != null) {
            sql.SET("userId = #{userid,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}