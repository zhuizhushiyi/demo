package com.zhuiyi.demo.studyTest.multithreading;

import io.swagger.models.auth.In;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;

/**  Callable 开启需要ExecutorService接口
 * @author by niYongJian
 * @Date 2022-07-28 21:51
 */
class MyCallable  implements Callable<Integer> {

    private Integer number;


    public MyCallable(Integer number) {
        this.number = number;
    }

    public MyCallable() {
    }

    @Override
    public Integer call() throws Exception {
        Random r = new Random();
        number = r.nextInt(10);
        System.out.println(Thread.currentThread().getName()+"  随机数："+number);
        return number;
    }
}
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool=Executors.newFixedThreadPool(3);
        MyCallable myCallable1=new MyCallable();
        MyCallable myCallable2=new MyCallable();
        MyCallable myCallable3=new MyCallable();
        Future<Integer> resutl1= pool.submit(myCallable1);
        Future<Integer> resutl2= pool.submit(myCallable2);
        Future<Integer> resutl3= pool.submit(myCallable3);
        pool.shutdown();
        System.out.println("resutl1 =" + resutl1.get());
        System.out.println("resutl2 =" + resutl2.get());
        System.out.println("resutl3 =" + resutl3.get());

    }

}
