package cn.tarena.ht.mapper;

import cn.tarena.ht.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 12863 on 2017/7/13.
 */
public interface RoleMapper {
    //查询所有的角色信息
    @Select("select * from role_p order by ORDER_NO")
//    @Update()
//    @Insert()
//    @Delete()
    public List<Role> findRoleList();


    void save(Role role);

    Role findRole(String roleId);

    @Select("select ROLE_ID from ROLE_USER_P where  AUTH_USER_ID=#{userId} ")
    List<String> findUserRoel(String userId);

    void deleteRole(String roleId);

    void updateRole(Role role);

    @Delete("delete from role_module_p where role_id=#{roleId}")
    void deleteModuleByRoleId(String roleId);
    @Insert("insert into role_module_p values(#{moduleId},#{roleId})")
    void saveRoleModule(@Param("roleId")String roleId,@Param("moduleId") String moduleId);
}
