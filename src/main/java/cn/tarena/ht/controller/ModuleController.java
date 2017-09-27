package cn.tarena.ht.controller;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 12863 on 2017/7/14.
 */
@Controller
@RequestMapping("sysadmin/module")
public class ModuleController {

    @Resource
    ModuleService moduleService;
    @RequestMapping("list")
    public String toModuleList(Model model){
        List<Module>list=moduleService.findAllModules();
        model.addAttribute("module",list);
        return "/sysadmin/module/jmoduleList";
    }


    @RequestMapping("save")
    public String saveModule(Module module){
        moduleService.saveModule(module);
        return "redirect:/sysadmin/module/list";
    }
    @RequestMapping("toupdate")
    public String toupdatemodule(String moduleId,Model model){
        //1.根据模块Id查询数据
        Module module = moduleService.findModuleByID(moduleId);

        //2.准备上级模块下拉列表
        List<Module> moduleList = moduleService.findParentModuleList(moduleId);

        model.addAttribute("module", module);
        model.addAttribute("moduleList", moduleList);
        return "sysadmin/module/jModuleUpdate";
    }
    @RequestMapping("update")
    public String update(Module module){
        moduleService.updateModule(module);
        return "redirect:/sysadmin/module/list";
    }
    //模块的删除
    @RequestMapping("delete")
    public String deleteModules(@RequestParam("moduleId") String[] ms){
        moduleService.deleteModules(ms);

        return "redirect:/sysadmin/module/list";
    }


    @RequestMapping("tocreate")
    public String tocreate(Model model){
        //准备上级部门下拉列表
        model.addAttribute("dataList", moduleService.findModuleList());

        return "sysadmin/module/jModuleCreate";
    }
}
