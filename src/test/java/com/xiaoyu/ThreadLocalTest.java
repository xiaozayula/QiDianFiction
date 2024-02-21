package com.xiaoyu;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/02/21/17:30
 * @Description:
 */

public class ThreadLocalTest {
    @Test
    public  void testThreadLocalSetAndGet(){
        //提供TreadLocal对象
        ThreadLocal tl =new ThreadLocal();
        //开启两个线程
        new Thread(()->{
            tl.set("小燕");
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
        },"蓝色").start();

        new Thread(()->{
            tl.set("小言");
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
            System.out.println(Thread.currentThread().getName()+":"+tl.get());
        },"绿色").start();

    }
}
