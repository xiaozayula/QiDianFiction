package com.xiaoyu.controller;

import com.xiaoyu.pojo.Article;
import com.xiaoyu.pojo.PageBean;
import com.xiaoyu.pojo.Result;
import com.xiaoyu.service.ArticleService;
import com.xiaoyu.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/02/19/16:27
 * @Description:
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PutMapping
    public Result add(@RequestBody@Validated Article article){
        articleService.add(article);
        return  Result.success();
    }
    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ){
        PageBean<Article> pb=articleService.list(pageNum,pageSize,categoryId,state);
        return  Result.success(pb);
    }

    @GetMapping("/detail")
    public  Result<Article> detail(Integer id){
        Article a=articleService.findById(id);
        return  Result.success(a);
    }
    @PutMapping
    public  Result update(@RequestBody @Validated Article article){
        articleService.update(article);
        return   Result.success();
    }
    @DeleteMapping
    public Result delete(Integer id){
        articleService.deleteById(id);
        return Result.success();
    }
}
