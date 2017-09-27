package cn.tarena.ht.service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 12863 on 2017/7/13.
 */
@Service("roleService")
public class RoleServiceImp implements RoleService{

    @Resource
    RoleMapper roleMapper;
    public List<Role> findAllRoles() {

        return roleMapper.findRoleList();
    }

    public void save(Role role) {
        role.setRoleId(UUID.randomUUID().toString());
        role.setCreateTime(new Date());
        roleMapper.save(role);
    }

    public Role findRole(String roleId) {

        return roleMapper.findRole(roleId);
    }

    public List<String> findUSerRoleList(String userId) {
        return roleMapper.findUserRoel(userId);
    }

    public void deleRole(String roleId) {
        roleMapper.deleteRole(roleId);
    }

    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }

    public void saveRoleModule(String roleId, String[] moduleIds) {
        //先根据roleId删除全部模块信息  然后在保存
        roleMapper.deleteModuleByRoleId(roleId);

        //保存角色和模块关联关系
        for (String moduleId : moduleIds) {
            roleMapper.saveRoleModule(roleId,moduleId);
        }
    }
}
