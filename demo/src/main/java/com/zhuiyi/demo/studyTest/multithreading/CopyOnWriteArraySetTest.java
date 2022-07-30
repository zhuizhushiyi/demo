package com.zhuiyi.demo.studyTest.multithreading;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author by niYongJian
 * @Date 2022-07-30 15:25
 */
public class CopyOnWriteArraySetTest {


    public static void main(String[] args) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet=new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.add("zhangsan");
        copyOnWriteArraySet.add("lisi");
        copyOnWriteArraySet.add("wangwu");
        copyOnWriteArraySet.add("lisi");

        System.out.println(copyOnWriteArraySet.size());
        System.out.println(copyOnWriteArraySet.toString());
    }
}
