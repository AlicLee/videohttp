package com.example.videohttp.service;

import com.example.videohttp.module.TSrs;

public interface SrsService {
    int deleteByPrimaryKey(Integer id);
    int insert(TSrs record);
    int insertSelective(TSrs record);
    TSrs selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(TSrs record);
    int updateByPrimaryKey(TSrs record);
}
