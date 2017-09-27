package cn.tarena.ht.controller;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by 12863 on 2017/7/17.
 */
@Controller
public class LoginController {
    @Resource
    UserService userService;
    @RequestMapping("toLogin")
    public String toLogin(){
        return "sysadmin/login/login";
    }
    @RequestMapping("login")
    public String login(String username, String password, Model model){
        if (StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            //若为空
            model.addAttribute("errorInfo","账号密码不能为空");
            return "sysadmin/login/login";
        }
        //使用shiro进行用户验证
        //1  创建subject
        Subject subject= SecurityUtils.getSubject();
        /*
         * 创建一个token 一个令牌  需要传入两个参数1.用户名 2 密码
         * shiro拿到用户自己输入的用户名和密码 拿到自定义的realm中进行校验
         * 通过realm为shiro准备真实的用户
         * shiro自己把二者做匹配  如果匹配成功  证明用户名和密码正确 然后执行
         * 如果二者不匹配则拦截
         */
        //2生产令牌
        UsernamePasswordToken token =new UsernamePasswordToken(username,password);

        /*
         *第三步  实现登陆操作
         * subject.login(token);如果校验失败会抛出异常
         */
        try {
            subject.login(token);
            //如果登陆成功
            User user = (User) subject.getPrincipal();
            subject.getSession().setAttribute("session_user", user);
            return "redirect:/home.action";
        }catch (Exception e){
            e.printStackTrace();
            //若登陆失败跳转登陆页面
            //有异常证证明用户名或密码错误
            model.addAttribute("errorInfo", "用户名和密码错误");
            return "sysadmin/login/login";
        }

    }


}
