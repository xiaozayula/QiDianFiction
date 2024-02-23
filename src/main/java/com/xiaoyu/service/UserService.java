package com.xiaoyu.service;

import com.xiaoyu.pojo.User;

public interface UserService {
    // 根据用户名查询用户
    User findByUserName(String userName);

    // 注册
    void register(String userName, String passWord);

    // 更新
    void update(User user);

    //更新头像
    void updateAvatar(String avatarUrl);

    //更新密码
    void updatePwd(String newPwd);
}
