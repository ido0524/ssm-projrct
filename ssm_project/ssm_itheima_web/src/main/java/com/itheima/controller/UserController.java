package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.domain.Roles;
import com.itheima.domain.UserInfo;
import com.itheima.service.RolesService;
import com.itheima.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author duchengjun@itcast.cn
 * @date 2018/12/27
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RolesService rolesService;
    //注入加密对象
    @Autowired
    private PasswordEncoder passwordEncoder;
  @RequestMapping("/findAll")
    public String findAll(@RequestParam(required = true,defaultValue = "1") Integer pageNum, @RequestParam(required = true,defaultValue = "2") Integer pageSize, Model model) throws Exception {
      List<UserInfo> userList=userInfoService.findAll(pageNum,pageSize);
      PageInfo info= new PageInfo(userList);
      model.addAttribute("userList",info);
      return "user-list";
  }
//保存
    @RequestMapping("/saveUser")
    public String saveUser(UserInfo userInfo) throws Exception{
      //获取数据库明文密码加密
        String encode = passwordEncoder.encode(userInfo.getPassword());
         userInfo.setPassword(encode);
        userInfoService.saveUser(userInfo);
        return "redirect:findAll";
    }
//详情
    @RequestMapping("/findById")
    public String findById(String id,Model model) throws Exception {
      UserInfo userInfo=  userInfoService.findById(id);
        model.addAttribute("user",userInfo);
        return "user-show";
    }
 //修改
 @RequestMapping("/findUserById")
 public String findUserById(String id,Model model) throws Exception {
     UserInfo userInfo=  userInfoService.findById(id);
     model.addAttribute("user",userInfo);
     return "user-update";
  }
    @RequestMapping("/updateUser")
    public String updateProduct(UserInfo userInfo,Integer flag) throws Exception {
        //修改密码之后密码加密
        if(flag==1){
            String encodePwd = passwordEncoder.encode(userInfo.getPassword());
            userInfo.setPassword(encodePwd);
        }
       userInfoService.updateUser(userInfo);
        return "redirect:findAll";
    }
     @RequestMapping("/findRoles")
    public String findRoles(String id,Model model) throws Exception{
    List<Roles> roles = rolesService.findAll();//flag=null;
    List<Roles> userRoles = rolesService.findByUserId(id);
    for (Roles role : roles) {
        for (Roles userRole : userRoles) {
            //如果roleID=userRoleId
            if (role.getId().equals(userRole.getId())){
                role.setFlag(1);
            }
        }

    }
    
    model.addAttribute("roleList",roles);
    return "user-role-add";
}
}
