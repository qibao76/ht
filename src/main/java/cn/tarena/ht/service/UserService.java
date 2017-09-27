package cn.tarena.ht.service;

import cn.tarena.ht.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by 12863 on 2017/7/10.
 */
public interface UserService {
   List<User> findUserList();

   void deleteUsers(String[] userIds);

   void updateUserState(String[] userIds, int i);

   void saveUser(User user);

   List<Map<String,Object>> findMangerList(String deptId);

    void saveUserRole(String userId, String[] roleIds);

   User findUserByN_P(String username, String password);

    User findUserByname(String username);
}
