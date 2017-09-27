package cn.tarena.ht.mapper;

import cn.tarena.ht.pojo.Module;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 12863 on 2017/7/14.
 */
public interface ModuleMapper {
    List<Module> findModuleList();

    void saveModule(Module module);

    void deletemodules(String[] ms);

    void updateModule(Module module);
    @Select("SELECT * FROM module_p WHERE module_id NOT IN(#{moduleId})")
    List<Module> findParentModuleList(String moduleId);

    Module findModuleByID(String moduleId);
    @Select("select module_id from role_module_p where role_id=#{roleId}")
    List<String> findModuleListByRoleId(String roleId);
}
