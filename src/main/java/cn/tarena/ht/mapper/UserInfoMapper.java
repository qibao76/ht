package cn.tarena.ht.mapper;

import cn.tarena.ht.pojo.UserInfo;

/**
 * Created by 12863 on 2017/7/11.
 */
public interface UserInfoMapper {

    public void deleteUserInfos(String[] UserInfos);

    void saveUserInfo(UserInfo userInfo);
}
