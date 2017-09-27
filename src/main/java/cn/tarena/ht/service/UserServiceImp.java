package cn.tarena.ht.service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;

import javax.annotation.Resource;

import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.utils.Encrpty;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 12863 on 2017/7/10.
 */
@Service("userService")
public class UserServiceImp implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private ModuleMapper moduleMapper;
    public List<User> findUserList() {

        return userMapper.findUserList();
    }

    public void deleteUsers(String[] userIds) {
        userInfoMapper.deleteUserInfos(userIds);

        userMapper.deleteUser(userIds);
    }

    public void updateUserState(String[] userIds, int i) {
        userMapper.updateUserState(userIds,i);
    }

    public void saveUser(User user) {
        String uuid= UUID.randomUUID().toString();
        UserInfo userInfo = user.getUserInfo();
        userInfo.setUserInfoId(uuid);
        userInfo.setCreateTime(new Date());
        //通过加密算法把密码加密
        user.setPassword(Encrpty.getMD5Hash(user.getPassword(),user.getUsername()));
        user.setUserId(uuid);
        userMapper.saveUser(user);
        userInfoMapper.saveUserInfo(userInfo);



    }

    public List<Map<String,Object>> findMangerList(String deptId) {
    	List<Map<String,Object>> map=userMapper.findMangerList(deptId);
        System.out.println(map);
        return map;
    }

    public void saveUserRole(String userId, String[] roleIds) {
        userMapper.deleteUserRole(userId);
        for (String roleId:roleIds) {
            userMapper.saveUserRole(userId,roleId);
        }
    }

    public User findUserByN_P(String username, String password) {

        return userMapper.findUserByN_P(username,Encrpty.getMD5Hash(password,username));

    }

    public User findUserByname(String username) {
        return userMapper.findUserByname(username);
    }

}
