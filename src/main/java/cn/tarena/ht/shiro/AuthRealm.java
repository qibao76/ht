package cn.tarena.ht.shiro;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12863 on 2017/7/17.
 */
//shiro中的特定的类  继承了它   shiro才会自动识别
public class AuthRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;
    //授权管理
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //session中存放了用户的信息----->角色信息  模块信息   标签中的名称不要重复
        //权限管理
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        //用户的权限列表   这是假设的
        List<String> roleList = new ArrayList<String>();

        roleList.add("货运管理");
        roleList.add("基础信息");
        roleList.add("系统管理");
        //权限管理器
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //集合中的信息就是用户所拥有的权限
        info.addStringPermissions(roleList);
        return info;
    }
    //用户d登陆验证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /*
         *realm 的作用为shiro准备资料  真实用户信息
         * 1通过用户提交的username到数据库中查询信息
         * 2得到一个user对象,用户的真实密码 当前的realm返回
         * 3shiro会自动的根据提供的资料与传入的信息进行比较
         */
        UsernamePasswordToken logintoken= (UsernamePasswordToken) token;
        //1.获取username
        String username = logintoken.getUsername();
        //2.获取user对象
        User user=userService.findUserByname(username);
        //3.返回对象
        AuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());

        return info;
    }
}
