package com.example.videohttp.service.impl;

import com.example.videohttp.dao.LiveDao;
import com.example.videohttp.module.TLive;
import com.example.videohttp.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiveServiceImpl implements LiveService {
    @Autowired
    LiveDao liveDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return liveDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TLive record) {
        return liveDao.insert(record);
    }

    @Override
    public int insertSelective(TLive record) {
        return liveDao.insertSelective(record);
    }

    @Override
    public TLive selectByPrimaryKey(Integer id) {
        return liveDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TLive record) {
        return liveDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByUserIdSelective(TLive record) {
        return liveDao.updateByUserIdSelective(record);
    }

    @Override
    public int updateByPrimaryKey(TLive record) {
        return liveDao.updateByPrimaryKey(record);
    }

    @Override
    public List<TLive> selectByPages(int currentPage, int nextPage) {
        return liveDao.selectByPages(currentPage, nextPage);
    }

    @Override
    public int updateOrInsert(TLive record) {
        return liveDao.updateOrInsert(record);
    }
}
