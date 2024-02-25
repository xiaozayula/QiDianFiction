package com.xiaoyu.service.impl;

import com.xiaoyu.mapper.CategoryMapper;
import com.xiaoyu.pojo.Category;
import com.xiaoyu.service.CategoryService;
import com.xiaoyu.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/02/24/1:51
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void add(Category category) {
        //补充属性值
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());

        Map<String,Object>map=ThreadLocalUtil.get();
        Integer userId= (Integer) map.get("id");
        category.setCreateUser(userId);
        categoryMapper.add(category);
    }

    @Override
    public List<Category> list() {
        Map<String ,Object>map=ThreadLocalUtil.get();
        Integer userId=(Integer)map.get("Id");
        return categoryMapper.list(userId);
    }

    @Override
    public Category findById(Integer id) {
        Category c=categoryMapper.findById(id);
        return c;
    }

    @Override
    public void update(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.update(category);
    }
}
