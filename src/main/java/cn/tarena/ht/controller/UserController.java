package cn.tarena.ht.controller;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * Created by 12863 on 2017/7/10.
 */
@Controller
@RequestMapping("/sysadmin/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private DeptService deptService;
    @Resource
    RoleService roleService;
    //为用户分配角色
    @RequestMapping("toRole")
    public String toUserRole(Model model,String userId) throws JsonProcessingException {
        //给所有角色信息
        List<Role> list=roleService.findAllRoles();
        //
       /* StringBuffer zTree=new StringBuffer("[");
        for (Role role:list) {
            zTree.append("{id:\""+role.getId()+"\",name:\""+role.getName()+"\"},");
        }
        String s = zTree.substring(0, zTree.length() - 1);
        s+="]";*/
        List<String> roleList=roleService.findUSerRoleList(userId);
        for (Role role:list) {
            if (roleList.contains(role.getRoleId())){
                role.setChecked("true");
            }
        }
        ObjectMapper objectMapper=new ObjectMapper();
        String s = objectMapper.writeValueAsString(list);
        model.addAttribute("zTree",s);
        model.addAttribute("userId",userId);
        return "/sysadmin/user/jRoleUser";
    }
    //保存用户角色信息保存
    @RequestMapping("saveUserRole")
    public String saveUserRole(String userId,String[] roleIds){
    
    	userService.saveUserRole(userId,roleIds);

        return "redirect:/sysadmin/user/list";
    }




    @RequestMapping("/list")
    public String toUserList(Model model){
        //获取user列表数据
        List<User> userList = userService.findUserList();
        model.addAttribute("userList", userList);
        return "sysadmin/user/juserList";
    }
    @RequestMapping("delete")
    public String deleteUser(@RequestParam("userId") String[] userIds){
        userService.deleteUsers(userIds);

        return "redirect:/sysadmin/user/list ";
    }
    @RequestMapping("start")
    public String start(@RequestParam("userId") String[] userIds){
        userService.updateUserState(userIds,1);
        return "redirect:/sysadmin/user/list ";
    }
    @RequestMapping("stop")
    public String stop(@RequestParam("userId") String[] userIds){
        userService.updateUserState(userIds,0);
        return "redirect:/sysadmin/user/list ";
    }
    //跳转添加页面
    @RequestMapping("tocreate")
    public String tocreate(Model model){
        //获取部门列表
        List<Dept> deptList = deptService.findDeptList();
        model.addAttribute("deptList",deptList);
        return "sysadmin/user/juserCreate";
    }

    @RequestMapping("save")
    public String saveuser(User user){
        userService.saveUser(user);
        return "redirect:/sysadmin/user/list ";
    }

    @RequestMapping("manger")
    @ResponseBody
    public List<Map<String,Object>> userManger(String deptId){
    	List<Map<String,Object>> map=userService.findMangerList(deptId);
        System.out.println(map);
        return map;
    }











}
