package com.gdou.gdousystem.configuration;

import com.gdou.gdousystem.filter.ShiroPermsFilter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Meng
 * @date 2019/12/21
 */
@Configuration
public class ShiroConfiguration {

    /**
     * 配置拦截规则
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.getFilters().put("perms",new ShiroPermsFilter());
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<>();
        filterChainDefinitionMap.put("/error/*","anon");          //静态资源不拦截
        filterChainDefinitionMap.put("/login","anon");            //登录不拦截
        filterChainDefinitionMap.put("/logout","logout");         //使用shiro实现好的的退出
        filterChainDefinitionMap.put("/test.html","anon");
        filterChainDefinitionMap.put("/course/*","perms[课程管理]");
        filterChainDefinitionMap.put("/examination/*","perms[考核管理]");
        filterChainDefinitionMap.put("/schedule/*","perms[课表管理]");
        filterChainDefinitionMap.put("/user/*","perms[用户管理]");
        filterChainDefinitionMap.put("/score/*","perms[成绩管理]");
        filterChainDefinitionMap.put("/**","authc");              //其余接口全部需要访问后登录
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setLoginUrl("https://www.baidu.com");
        return shiroFilterFactoryBean;
    }

    /**
     * 配置安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    /**
     * 配置自定义Realm
     * @return
     */
    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm=new MyShiroRealm();
        return myShiroRealm;
    }

}
