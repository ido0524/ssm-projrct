package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Roles;
import com.itheima.domain.UserInfo;
import com.itheima.mapper.UserInfoMapper;
import com.itheima.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duchengjun@itcast.cn
 * @date 2018/12/27
 */
@Service("userService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService{
@Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
           userInfo = userInfoMapper.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用spring security安全认证
        User user = new User(userInfo.getUsername(),/*不使用加密密码就必须带上他 反之*//*"{noop}"+*/userInfo.getPassword(), userInfo.getStatus()==1?true:false,
                true,true,true,getRoles(userInfo.getRoles()));
        return user;
    }
        //定义方法,设置权限集合
        public List<SimpleGrantedAuthority> getRoles(List<Roles> roles){
            List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
            //遍历查到的list集合
            for (Roles role: roles) {
                list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
            }
            return list;
        }

    @Override
    public List<UserInfo> findAll(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
      return userInfoMapper.findAll();
    }

    @Override
    public void saveUser(UserInfo userInfo) throws Exception {
        userInfoMapper.saveUser(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception{
        return userInfoMapper.findById(id);
    }

    @Override
    public void updateUser(UserInfo userInfo) throws Exception {
        userInfoMapper.updateUser(userInfo);
    }


}

