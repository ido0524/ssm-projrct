package com.itheima.mapper;

import com.itheima.domain.UserInfo;

import java.util.List;

public interface UserInfoMapper {

    UserInfo findByUsername(String userInfo) throws Exception;

    List<UserInfo> findAll() throws Exception;

    void saveUser(UserInfo userInfo)throws Exception;

    UserInfo findById(String id) throws Exception;


    void updateUser(UserInfo userInfo)throws Exception;
}
