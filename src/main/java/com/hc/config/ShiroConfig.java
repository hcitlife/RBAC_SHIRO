package com.hc.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.hc.shiro.UserRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //1.创建realm对象，使用自定义类
    @Bean(name = "userRealm")
    public UserRealm shiroRealm() { //将自己的验证方式加入容器
        UserRealm userRealm = new UserRealm();

        //设置密码的匹配方式
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(1);//设置加密次数，默认为1
        userRealm.setCredentialsMatcher(credentialsMatcher);

        return userRealm;
    }

    //2.创建DefaultWebSecurityManager
    @Bean(name = "dwSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        //关联realm
        manager.setRealm(userRealm);
        return manager;
    }

    //3.创建ShiroFilterFactoryBean
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("dwSecurityManager") DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);

        //添加shiro的内置过滤器
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/index", "anon");//必须登录之后才能访问
        map.put("/admin/toLogin","anon");//跳转到登录页面，放行
        map.put("/admin/login","anon");//登录请求，放行
        map.put("/admin/logout","logout");//退出登录，相当于在AdminController中添加如下代码
        //@RequestMapping("/logout")
        //public String logout(){
        //    SecurityUtils.getSubject().logout();
        //    return "index";
        //}

        //拦截
        map.put("/admin/toAdd", "authc");//必须登录之后才能访问
        map.put("/admin/toUpdate", "authc");
        map.put("/admin/toDetail", "authc");
        map.put("/admin/toList", "authc");

        //授权，若当前登录用户未授权则会跳转到授权页面
        map.put("/admin/add", "perms[admin:add]");
        map.put("/admin/update", "perms[admin:update]");
        map.put("/admin/detail", "perms[admin:detail]");
        //查看管理员时，需要用户列表查询权限
        map.put("/admin/list", "perms[admin:list]");
        //删除管理员时，需要超级管理员角色
        map.put("/admin/delete/*","roles[role:system]");


        map.put("/storage/toList", "authc");


        //控制访问资源需要的权限
        bean.setFilterChainDefinitionMap(map);
        //登录页面
        bean.setLoginUrl("/admin/toLogin");

        //设置未授权页面
        bean.setUnauthorizedUrl("/unauth");

        //设置安全管理器
        return bean;
    }

    //Shiro整合thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        ShiroDialect shiroDialect = new ShiroDialect();
        return shiroDialect;
    }

    //基于注解的权限控制
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("dwSecurityManager") DefaultWebSecurityManager manager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }
}
