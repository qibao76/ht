package cn.tarena.ht.service;

import cn.tarena.ht.pojo.Module;

import java.util.List;

/**
 * Created by 12863 on 2017/7/14.
 */
public interface ModuleService {
    List<Module> findAllModules();

    void saveModule(Module module);
    void updateModule(Module module);
    void deleteModules(String[] ms);

    List<Module> findModuleList();

    List<Module> findParentModuleList(String moduleId);

    Module findModuleByID(String moduleId);

    List<String> findModuleListByRoleId(String roleId);
}
