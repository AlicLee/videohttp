package com.example.videohttp.service;

import com.example.videohttp.module.TLive;

import java.util.List;

public interface LiveService {
    int deleteByPrimaryKey(Integer id);
    int insert(TLive record);
    int insertSelective(TLive record);
    TLive selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(TLive record);
    int updateByUserIdSelective(TLive record);
    int updateByPrimaryKey(TLive record);
    List<TLive> selectByPages(int currentPage, int nextPage);
    int updateOrInsert(TLive tLive);
}
