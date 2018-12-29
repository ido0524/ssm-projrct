package com.itheima.mapper;

import com.itheima.domain.Roles;

import java.util.List;

/**
 * @author duchengjun@itcast.cn
 * @date 2018/12/27
 */
public interface RolesMapper {
    List<Roles> findByUserId(String id) throws Exception;
    List<Roles> findAll() throws Exception;
}
