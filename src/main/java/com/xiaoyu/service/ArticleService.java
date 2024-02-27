package com.xiaoyu.service;

import com.xiaoyu.pojo.Article;
import com.xiaoyu.pojo.PageBean;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/02/25/16:09
 * @Description:
 */
public interface ArticleService {
    //新增文章
    void add(Article article);

    //条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    //根据id查询文章的星系
    Article findById(Integer id);
}
