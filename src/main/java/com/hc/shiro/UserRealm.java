package com.hc.shiro;

import com.hc.domain.Admin;
import com.hc.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.SimpleByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Resource
    private AdminService adminService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("===================doGetAuthorizationInfo=============================");

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //Subject subject = SecurityUtils.getSubject();
        //Admin admin = (Admin) subject.getPrincipal();
        //下面一句和上面两句的效果一致
        Admin admin = (Admin) principals.getPrimaryPrincipal();

        //模拟从数据库中查询出权限
        Set<String> roles = adminService.getRolesByAccount(admin.getAccount());
        Set<String> auths = adminService.getAuthsByAccount(admin.getAccount());
        //添加角色
        simpleAuthorizationInfo.setRoles(roles);
        //添加权限
        simpleAuthorizationInfo.setStringPermissions(auths);

        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("========doGetAuthenticationInfo=================");
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //从数据库中获取用户信息
        Admin admin = adminService.getByAccount(userToken.getUsername());
        if (null == admin) { //用户不存在
            return null; //抛出异常UnknownAccountException
        }
        //用户登录成功，将用户信息保存在Shiro的session中
        SecurityUtils.getSubject().getSession().setAttribute("currentLoginedUser", admin);
        //不能（不建议）自己做密码认证，系统会自己做
        // 主题(值为完整用户信息，方便授权时查找用户的权限)，密码，盐，realname
        SimpleByteSource salt = new SimpleByteSource(admin.getSalt());
        return new SimpleAuthenticationInfo(admin, admin.getPassword(), salt, admin.getNickname());
    }

}
