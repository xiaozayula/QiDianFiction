package com.xiaoyu.mapper;

import com.xiaoyu.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    @Select("select *from Article where id=#{id}")
    Article findById(Integer id);
}
