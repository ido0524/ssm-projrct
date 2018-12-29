package com.itheima.service;


import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author duchengjun@itcast.cn
 * @date 2018/12/27
 */

public interface UserInfoService extends UserDetailsService {

    List<UserInfo> findAll(Integer pageNum,Integer pageSize) throws Exception;

    void saveUser(UserInfo userInfo)throws Exception;


    UserInfo findById(String id) throws Exception;

    void updateUser(UserInfo userInfo) throws Exception;
}
