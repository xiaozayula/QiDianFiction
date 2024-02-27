package com.xiaoyu.controller;

import com.xiaoyu.pojo.Category;
import com.xiaoyu.pojo.Result;
import com.xiaoyu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/02/24/1:49
 * @Description:
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public Result add(@RequestBody @Validated(Category.Add.class) Category category){
        categoryService.add(category);
        return Result.success();
    }

    @GetMapping
    public Result<List <Category>> list(){
        List<Category> cs=categoryService.list();
        return  Result.success(cs);
    }
    @GetMapping("/detail")
    public Result<Category> detail(Integer id){
        Category c=categoryService.findById(id);
        return Result.success(c);
    }
    @PutMapping
    public  Result update(@RequestBody @Validated (Category.Update.class)Category category){
        categoryService.update(category);
        return  Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id){
        categoryService.deleteById(id);
        return Result.success();
    }
}
