package com.xiaoyu.mapper;

import com.xiaoyu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    //根据用户名查询用户
    User findByUserName(String userName) ;
    //添加
    @Insert("insert into (username,password,creat_time,updata_time)"+" values(#{username},#{password},now(),now())")
    void add(String username, String password) ;

    @Update("update  user set nickname=#{nickname},email=#{emial},update_time=#{updataTime},where id=#{id}")
    void updata(User user);
}
