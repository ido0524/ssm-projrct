package com.itheima.service.impl;

import com.itheima.domain.Roles;
import com.itheima.mapper.RolesMapper;
import com.itheima.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author duchengjun@itcast.cn
 * @date 2018/12/29
 */
@Service
@Transactional
public class RolesServiceImpl implements RolesService {
@Autowired
private RolesMapper rolesMapper;
    @Override
    public List<Roles> findAll() throws Exception {
        return rolesMapper.findAll();
    }

    @Override
    public List<Roles> findByUserId(String id) throws Exception {
        return rolesMapper.findByUserId(id);
    }


}
