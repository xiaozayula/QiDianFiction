package com.xiaoyu.mapper;

import com.xiaoyu.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/02/24/1:52
 * @Description:
 */
@Mapper
public interface CategoryMapper  {
    //新增
    @Insert("insert  into category(category_name,category_alias,create_user,create_time,update_time)"+
    "values (#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void add(Category category);

    //查询所有
    @Select("select*from category where craet_user=#{userId} ")
    List<Category> list(Integer userId);

    //根据id查询
    @Select("select *from category where id=#{id}")
    Category findById(Integer id);

    //更新
    @Update("update category set category_neme=#{categoryName},category_alias=#{categoryAlics},update_time={updateTime} where id=#{id}")
    void update(Category category);

    //删除根据id
    @Delete("delete from category where id=#{id}")
    void deleteById(Integer id);
}
