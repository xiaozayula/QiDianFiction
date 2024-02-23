package com.xiaoyu.mapper;

import com.xiaoyu.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
    @Insert("insert  into category(category_name,category_alias,create_time,update_time)"+
    "values (#{categoryName},#{categoryAlias},#{categoryUser},#cateTimes),#{updateTime}")
    void add(Category category);
}
