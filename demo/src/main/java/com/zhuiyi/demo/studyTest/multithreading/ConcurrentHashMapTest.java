package com.zhuiyi.demo.studyTest.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** 比较多线程使用ConcurrentHashMap 与 HashMap的区别
 * @author by niYongJian
 * @Date 2022-07-30 15:45
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();
        for (int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    for (int j =0;j<10;j++){
                        map.put(Thread.currentThread().getName(),"----->"+j);
                        System.out.println(map);
                    }
                }
            }).start();
        }
        Thread.sleep(5000);
        

    }
}
