package com.example.videohttp.service;

import com.example.videohttp.module.TUser;

public interface UserService {
    int deleteByPrimaryKey(Integer id);
    int insert(TUser record);
    int insertSelective(TUser record);
    TUser selectByPrimaryKey(Integer id);
    TUser selectByUserNameAndPassword(String userName,String userPassword);
    TUser selectByUserName(String userName);
    int updateByPrimaryKeySelective(TUser record);
    int updateByPrimaryKey(TUser record);
}
