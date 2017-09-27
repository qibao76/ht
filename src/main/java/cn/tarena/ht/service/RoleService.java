package cn.tarena.ht.service;

import cn.tarena.ht.pojo.Role;

import java.util.List;

/**
 * Created by 12863 on 2017/7/13.
 */
public interface RoleService {
    List<Role> findAllRoles();

    void save(Role role);

    Role findRole(String roleId);

    List<String> findUSerRoleList(String userId);

    void deleRole(String roleId);

    void updateRole(Role role);

    void saveRoleModule(String roleId, String[] moduleIds);
}
