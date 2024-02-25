package com.xiaoyu.mapper;

import com.xiaoyu.pojo.Article;
import com.xiaoyu.pojo.Result;
import com.xiaoyu.service.ArticleService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
