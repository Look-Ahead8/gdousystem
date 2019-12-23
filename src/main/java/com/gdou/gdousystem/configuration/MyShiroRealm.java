package com.gdou.gdousystem.configuration;


import com.gdou.gdousystem.bean.Permission;
import com.gdou.gdousystem.bean.Role;
import com.gdou.gdousystem.bean.Teacher;
import com.gdou.gdousystem.service.PermissionService;
import com.gdou.gdousystem.service.RoleService;
import com.gdou.gdousystem.service.TeacherService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Meng
 * @date 2019/12/21
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private TeacherService teacherService;

    /**
     * 授权，根据登录的用户名查找出所拥有的权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String teacherId=(String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<Permission> permissions=permissionService.findPermissionByTeacherId(teacherId);
        List<Role> roles=roleService.findRoleByTeacherId(teacherId);
        Set<String> roleSet=new HashSet<>();
        Set<String> permissionSet=new HashSet<>();
        for (Role role:roles){
            roleSet.add(role.getRoleName());
        }
        for (Permission permission:permissions){
            permissionSet.add(permission.getPermissionName());
        }
        authorizationInfo.setRoles(roleSet);
        authorizationInfo.setStringPermissions(permissionSet);
        return authorizationInfo;
    }

    /**
     * 认证,从数据库中查找出对应用户名的用户信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String teacherId=authenticationToken.getPrincipal().toString();
        Teacher teacher=teacherService.findTeacherByTeacherId(teacherId);
        if(teacher==null){
            return null;
        }else{
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(teacher.getTeacherId(),teacher.getPassword(),getName());
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("teacher",teacher);
            return authenticationInfo;
        }
    }
}
