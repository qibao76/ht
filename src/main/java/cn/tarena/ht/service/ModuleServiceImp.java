package cn.tarena.ht.service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 12863 on 2017/7/14.
 */
@Service("moduleService")
public class ModuleServiceImp implements ModuleService {
    @Resource
    private ModuleMapper moduleMapper;
    public List<Module> findAllModules() {
        return moduleMapper.findModuleList();
    }

    public void saveModule(Module module) {
        module.setModuleId(UUID.randomUUID().toString());
        module.setState(1);
        module.setCreateTime(new Date());
        moduleMapper.saveModule(module);
    }

    public void deleteModules(String[] ms) {
        moduleMapper.deletemodules(ms);
    }

    public List<Module> findModuleList() {

        return moduleMapper.findModuleList();
    }

    public List<Module> findParentModuleList(String moduleId) {
        return moduleMapper.findParentModuleList(moduleId);
    }

    public Module findModuleByID(String moduleId) {
        return moduleMapper.findModuleByID(moduleId);
    }

    public List<String> findModuleListByRoleId(String roleId) {
        return moduleMapper.findModuleListByRoleId(roleId);
    }

    public void updateModule(Module module) {
        module.setUpdateTime(new Date());
        moduleMapper.updateModule(module);
    }
}
