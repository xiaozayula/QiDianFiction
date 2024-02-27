package com.xiaoyu.mapper;

import com.xiaoyu.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/02/25/16:10
 * @Description:
 */
@Mapper
public interface ArticleMapper {
    //新增
    @Insert("insert into  article (title,content,cover_img,state,category_id,create_user,create_time,update_time" +
            "values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},#{createTime},#{updateTime}))")
    void add(Article article);

    List<Article> list(Integer userId, Integer categoryId, String state);

    @Select("select *from article where id=#{id}")
    Article findById(Integer id);
    @Update("update article set title=#{title},content=#{content},cover_img=#{coverImg}," +
            "state=#{state},category_id=#{categoryId},update_time=#{updateTime} where id=#{id}")
    void update(Article article);
    @Delete("delete  from article where id=#{id}")
    void deleteById(Integer id);
}
