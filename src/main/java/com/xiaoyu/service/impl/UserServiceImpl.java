package com.xiaoyu.service.impl;

import com.xiaoyu.mapper.UserMapper;
import com.xiaoyu.pojo.User;
import com.xiaoyu.service.UserService;
import com.xiaoyu.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String userName) {
        User u = userMapper.findByUserName(userName);
        return u;
    }

    @Override
    public void register(String username, String password) {
        // 加密
        String md5String = Md5Util.getMD5String(password);
        // 添加
        userMapper.add(username, md5String);
    }

    @Override
    public void updata(User user) {
        user.setCreateTime(LocalDateTime.now());
        userMapper.updata(user);
    }
}
