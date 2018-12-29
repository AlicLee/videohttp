package com.example.videohttp.service.impl;

import com.example.videohttp.dao.SrsDao;
import com.example.videohttp.module.TSrs;
import com.example.videohttp.service.SrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SrsServiceImpl implements SrsService {
    @Autowired
    SrsDao srsDao;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return srsDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TSrs record) {
        return srsDao.insert(record);
    }

    @Override
    public int insertSelective(TSrs record) {
        return srsDao.insertSelective(record);
    }

    @Override
    public TSrs selectByPrimaryKey(Integer id) {
        return srsDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TSrs record) {
        return srsDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TSrs record) {
        return srsDao.updateByPrimaryKey(record);
    }
}
