package com.xiaoyu.controller;

import com.xiaoyu.pojo.Result;
import com.xiaoyu.pojo.User;
import com.xiaoyu.service.UserService;
import com.xiaoyu.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("register")
    public Result register(@Pattern(regexp="^\\S{5,16}$") String userName,@Pattern(regexp="^\\S{5,16}$")  String passWord) {
        if (userName != null && userName.length() <= 16 && userName.length() >= 5
                && passWord != null && passWord.length() <= 16 && passWord.length() >= 5) {
            //查询用户
            User u = userService.findByUserName(userName);
            if (u == null) {
                //没有占用
                // 注册
                userService.register(userName, passWord);
                return Result.success();
            } else {
                //占用
                return Result.error("用户名已被占用");
            }
        }else{
            return Result.error("参数不合法");
        }
    }
    @PostMapping("login")
    public  Result<String> login(@Pattern(regexp="^\\S{5,16}$") String userName,@Pattern(regexp="^\\S{5,16}$")  String passWord){
        //根据用户名查询用户
        User loginUser=userService.findByUserName(userName);
        //判断该用户是否存在
        if(loginUser==null){
            return Result.error("用户名错误");
        }
        //判断密码是否正确
        if(Md5Util.getMD5String(passWord).equals((loginUser.getPassword()))){
            //登陆成功
            return  Result.success("jwt token令牌..");
        }
        return  Result.error("密码错误");
    }
}