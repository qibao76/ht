package cn.tarena.ht.controller;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.ModuleService;
import cn.tarena.ht.service.RoleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 12863 on 2017/7/13.
 */
@Controller
@RequestMapping("sysadmin/role")
public class RoleController {
    @Resource
    RoleService roleService;
    @Resource
    ModuleService moduleService;
    @RequestMapping("list")
    public String toRoleList(Model model){
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("roles",roles);
        return "sysadmin/role/jRoleList";
    }

    @RequestMapping("tocreate")
    public String tocreate(){
        return "sysadmin/role/jRoleCreate";
    }
    @RequestMapping("save")
    public String saveRole(Role role){
        roleService.save(role);
        return "redirect:/sysadmin/role/list";
    }
    @RequestMapping("toupdate")
    public String toupdateRole(String roleId,Model model){
        Role role=roleService.findRole(roleId);
        model.addAttribute("role",role);
        return "sysadmin/role/jRoleUpdate";
    }
    @RequestMapping("update")
    public String updateRole(Role role){
        roleService.updateRole(role);
        return "redirect:/sysadmin/role/list";
    }
    @RequestMapping("delete")
    public String deleteRole(String roleId){
        roleService.deleRole(roleId);
        return "redirect:/sysadmin/role/list";
    }
    @RequestMapping("toUserMoudle")
    public String toUserMoudle(Model model,String roleId) throws JsonProcessingException {
        //查询所有的模块列表
        List<Module> moduleList = moduleService.findModuleList();

        //根据roleId查询所有的模块Id
        List<String> m_list = moduleService.findModuleListByRoleId(roleId);

        //在全部模块列表中匹配已有模块id然后回显
        for (Module module : moduleList) {
            if(m_list.contains(module.getModuleId())){
                module.setChecked("true");
            }
        }


        //将列表转化为json串
        ObjectMapper objectMapper = new ObjectMapper();
        String zTreeJson = objectMapper.writeValueAsString(moduleList);

        //封装json数据 和roleId
        model.addAttribute("zTreeJson", zTreeJson);
        model.addAttribute("roleId", roleId);
        return "sysadmin/role/jRoleModule";
    }

    @RequestMapping("saveRoleModule")
    public String saveRoleModule(String roleId,String[] moduleIds){
        roleService.saveRoleModule(roleId,moduleIds);
        return "redirect:/sysadmin/role/list";
    }


}
