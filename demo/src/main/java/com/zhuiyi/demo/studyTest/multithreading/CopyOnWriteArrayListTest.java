package com.zhuiyi.demo.studyTest.multithreading;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 比较多线程使用CopyOnWriteArray 和 ArrayList的区别
 * @author by niYongJian
 * @Date 2022-07-30 15:00
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> arrayList=new CopyOnWriteArrayList<>();
        ExecutorService pool= Executors.newFixedThreadPool(5);
        for (int i=0;i<5;i++){
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<10;j++){
                        arrayList.add(Thread.currentThread().getName()+" 产生随机数： " + new Random().nextInt(1000));
                    }

                }
            });
        }
        pool.shutdown();
        //判断线程池是否结束,结束后在继续走下面的代码
        while (!pool.isTerminated()){

        }
        System.out.println("arrayList的个数："+arrayList.size());
        for (String str:arrayList){
            System.out.println(str);
        }
    }
}
