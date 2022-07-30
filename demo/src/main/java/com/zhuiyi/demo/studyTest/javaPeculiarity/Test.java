package com.zhuiyi.demo.studyTest.javaPeculiarity;

import com.zhuiyi.demo.studyTest.javaPeculiarity.inherit.Father;
import com.zhuiyi.demo.studyTest.javaPeculiarity.inherit.Son;

import java.util.*;

/** 测试类
 * @author by niYongJian
 * @Date 2022-07-24 10:41
 */
public class Test {


    public static void main(String[] args) {

        /**
         * inherit
         */
        Son son =new Son();
        son.setToy("youxi");
        son.print();
        Father father=(Father) son;
        father.print();
        System.out.println(son.toString());
        System.out.println(father.toString());
        System.out.println(son instanceof Father);
        System.out.println(son ==  father);

    }

}
