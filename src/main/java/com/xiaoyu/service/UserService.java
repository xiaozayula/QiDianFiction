package com.xiaoyu.service;

import com.xiaoyu.pojo.User;

public interface UserService {
    //根据用户名查询用户
    User findByUserName(String userName) ;
    //注册
    void register(String userName, String passWord) ;

    //更新
    void updata(User user);
}
