package com.itheima.service;


import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author duchengjun@itcast.cn
 * @date 2018/12/27
 */



import com.itheima.domain.Roles;

import java.util.List;

public interface RolesService {
    List<Roles> findAll() throws Exception;
    List<Roles> findByUserId(String id) throws Exception;
}