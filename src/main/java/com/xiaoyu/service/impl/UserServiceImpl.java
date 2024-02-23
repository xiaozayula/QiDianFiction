package com.xiaoyu.service.impl;

import com.xiaoyu.mapper.UserMapper;
import com.xiaoyu.pojo.User;
import com.xiaoyu.service.UserService;
import com.xiaoyu.utils.Md5Util;
import com.xiaoyu.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

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
    public void update(User user) {
        user.setCreateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer id =(Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl,id);
    }
}
