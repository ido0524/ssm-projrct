package com.itheima.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author duchengjun@itcast.cn
 * @date 2018/12/27
 */
public class Roles implements Serializable {
    private String id;
    private String roleName;
    private String roleDesc;
    //建立角色权限一对多关系
    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
    //创建一个红绿灯判断
    private Integer flag;

    public Integer getFlag() {
        return flag;
    }
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
