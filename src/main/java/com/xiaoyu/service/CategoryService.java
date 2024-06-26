package com.xiaoyu.service;

import com.xiaoyu.pojo.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/02/24/1:50
 * @Description:
 */
public interface CategoryService  {
    //新增分类
    void add(Category category);

    //列表查询
    List<Category> list();

    //根据id查询分类信息
    Category findById(Integer id);

    //更新分类
    void update(Category category);

    //删除分类
    void deleteById(Integer id);
}
