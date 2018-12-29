package com.example.videohttp.service.impl;

import com.example.videohttp.dao.UserDao;
import com.example.videohttp.module.TUser;
import com.example.videohttp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
     UserDao userDao;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TUser record) {
        return userDao.insert(record);
    }

    @Override
    public int insertSelective(TUser record) {
        return userDao.insertSelective(record);
    }

    @Override
    public TUser selectByPrimaryKey(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public TUser selectByUserNameAndPassword(String userName, String userPassword) {
        return userDao.selectByUserNameAndPassword(userName,userPassword);
    }

    @Override
    public TUser selectByUserName(String userName) {
        return userDao.selectByUserName(userName);
    }

    @Override
    public int updateByPrimaryKeySelective(TUser record) {
        return userDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TUser record) {
        return userDao.updateByPrimaryKey(record);
    }
}
