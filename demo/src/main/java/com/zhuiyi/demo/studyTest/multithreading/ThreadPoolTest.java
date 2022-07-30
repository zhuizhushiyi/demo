package com.zhuiyi.demo.studyTest.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author by niYongJian
 * @Date 2022-07-28 21:22
 */

class MyThreadPool implements Runnable{

    @Override
    public void run() {
        System.out.println("我要一个教练");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("教练来了！  " + Thread.currentThread().getName());
        System.out.println("教练交完了，回到了教练室。");
    }
}
public class ThreadPoolTest {
    public static void main(String[] args) {
        //创建线程池对象
        MyThreadPool myThreadPool=new MyThreadPool();
        //创建线程池 [1-3种方式]
        ExecutorService pool =Executors.newFixedThreadPool(1);

        //创建线程池 [4.创建固定长度，以指定延迟时间或定时执行]
        ScheduledExecutorService ScheduledExecutorService =Executors.newScheduledThreadPool(3);
        ScheduledExecutorService.schedule(myThreadPool,1000, TimeUnit.MILLISECONDS);

//        pool.submit(myThreadPool);
//        pool.submit(myThreadPool);
//        pool.submit(myThreadPool);
//        pool.submit(myThreadPool);

        //关闭线程池
        ScheduledExecutorService.shutdown();
    }
}
