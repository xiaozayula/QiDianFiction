package com.xiaoyu.controller;

import com.xiaoyu.pojo.Result;
import com.xiaoyu.pojo.User;
import com.xiaoyu.service.UserService;
import com.xiaoyu.utils.JwtUtil;
import com.xiaoyu.utils.Md5Util;
import com.xiaoyu.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String userName,
        @Pattern(regexp = "^\\S{5,16}$") String passWord) {
        if (userName != null && userName.length() <= 16 && userName.length() >= 5 && passWord != null
            && passWord.length() <= 16 && passWord.length() >= 5) {
            // 查询用户
            User u = userService.findByUserName(userName);
            if (u == null) {
                // 没有占用
                // 注册
                userService.register(userName, passWord);
                return Result.success();
            } else {
                // 占用
                return Result.error("用户名已被占用");
            }
        } else {
            return Result.error("参数不合法");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String userName,
        @Pattern(regexp = "^\\S{5,16}$") String passWord) {
        // 根据用户名查询用户
        User loginUser = userService.findByUserName(userName);
        // 判断该用户是否存在
        if (loginUser == null) {
            return Result.error("用户名错误");
        }
        // 判断密码是否正确
        if (Md5Util.getMD5String(passWord).equals((loginUser.getPassword()))) {
            // 登陆成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("usename", loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }

    @GetMapping("/userInfo")
    public Result<User> useInfo(@RequestHeader(name = "Authorization") String token) {
        // 根据用户名查询用户
        // Map<String, Object> map = JwtUtil.parseToken(token);
        // String username = (String)map.get("username");
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String)map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result updata(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success();
    }
    @PatchMapping("updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl){//@URL检验avatarUrl是不是URL地址
        userService.updateAvatar(avatarUrl);
        return  Result.success();
    }
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params){
        //1.校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");
        if (!StringUtils.hasLength(oldPwd)||!StringUtils.hasLength(newPwd)||!StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要参数");
        }
        //原密码是否正确
        //调用userService根据用户名拿回密码，再用old_pwd比对
        Map<String ,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserName(username);
        if(!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            return Result.error("原密码填写不正确");
        }
        //newPwd和rePwd是否一样
        if (!rePwd.equals(newPwd)){
            return Result.error("再次填写的新密码不一样");
        }

        //2.调用service完成密码更新
        userService.updatePwd(newPwd);
        return  Result.success();
    }

}