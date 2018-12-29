package com.itheima.mapper;

import com.itheima.domain.Permission;

import java.util.List;

/**
 * @author duchengjun@itcast.cn
 * @date 2018/12/28
 */
public interface PermissionMapper {
   List<Permission>  findPermssionByRoleId(String id);
}
