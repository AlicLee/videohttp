package com.example.videohttp.service;

import com.example.videohttp.module.TLiveStatus;

public interface LiveStatusService {
    int deleteByPrimaryKey(Integer id);
    int insert(TLiveStatus record);
    int insertSelective(TLiveStatus record);
    TLiveStatus selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(TLiveStatus record);
    int updateByPrimaryKey(TLiveStatus record);
}
