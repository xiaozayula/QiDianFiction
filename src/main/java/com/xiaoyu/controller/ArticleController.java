package com.xiaoyu.controller;

import com.xiaoyu.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("list")
    public Result<String> list(){
        return Result.success("所以的文章数据...");
    }
}
