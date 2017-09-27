package cn.tarena.ht.mapper;

import cn.tarena.ht.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by 12863 on 2017/7/10.
 */
public interface UserMapper {
    List<User> findUserList();

    void deleteUser(String[] userIds);

    void updateUserState(@Param("userIds") String[] userIds,@Param("state") int state);

    void saveUser(User user);

    List<Map<String,Object>> findMangerList(String deptId);

    void saveUserRole(@Param("userId")String userId,@Param("roleId")String roleId);

    @Delete("delete from role_user_p where AUTH_USER_ID=#{userId}")
    void deleteUserRole(String userId);


    public User findUserByN_P(@Param("username")String username,@Param("password")String password);

    User findUserByname(String username);
}
