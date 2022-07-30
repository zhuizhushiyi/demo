package com.zhuiyi.demo.studyTest.listGather;

import com.zhuiyi.demo.studyTest.javaPeculiarity.inherit.Father;
import io.swagger.models.auth.In;

import java.lang.reflect.Array;
import java.util.*;

/** List集合
 * @author by niYongJian
 * @Date 2022-07-24 17:03
 */
public class Test {
    public static void main(String[] args) {
        /**
         * ArrayList
         */
        List<Integer> list1=new ArrayList<>();
        list1.add(0,100);
        list1.add(1,200);
        list1.add(2,300);
        list1.add(3,400);
        System.out.println("ArrayList"+list1);
        list1.set(1,2000);
        System.out.println("ArrayList"+list1);
        list1.remove(1);
        System.out.println("ArrayList"+list1);


        /**
         * LinkedList
         */
        LinkedList<String> list2=new LinkedList<>();
        list2.add("0");
        list2.addFirst("-1");
        list2.addFirst("-2");
        list2.addLast("1");
        list2.addLast("2");
        System.out.println("LinkedList"+list2);
        System.out.println("LinkedList弹出一个元素："+list2.pop());
        System.out.println("LinkedList弹出一个元素后打印集合"+list2);


        /**
         * HashSet
         */
        Set<String> set1=new HashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("3");
        set1.add("4");
        System.out.println("HashSet"+set1);
        for (String str:
             set1) {
            System.out.println("HashSet进入for循环"+str);
        }

        Iterator<String> iterator=set1.iterator();
        while (iterator.hasNext()){
            System.out.println("HashSet进入iterator迭代器"+ iterator.next());
        }

        //无法放入重复的元素 [非自定义数据类型]
        set1.add("4");
        System.out.println("HashSet"+set1);


        /**
         * 自定义类 [默认可以重复]
         *      自定义类型：如果希望自定义类型的成员相同时，不要重复添加到Set集合，那么应该重写hashCode()和equals()方法。
         */
        Set<Father> set2=new HashSet<>();
        Father father=new Father("zhangsan",20,"anhui");
        set2.add(father);
        set2.add(new Father("lisi",21,"henan"));
        set2.add(new Father("wangwu",22,"guangxi"));
        set2.add(new Father("zhangsan",23,"shanghai"));
        set2.add(father);
        System.out.println("HashSet<自定义数据类型>"+set2);
        /**
         * 自定义类 [默认可以重复]
         *     自定义类型：如果希望自定义类型的成员相同时，不要重复添加到Set集合，那么应该重写hashCode()和equals()方法。
         *          结束
         * @return
         */


        /**
         * TreeSet
         */
        Set<String> set3 =new TreeSet<>();
        set3.add("aaa");
        set3.add("ddd");
        set3.add("bbb");
        set3.add("ccc");
        set3.add("ccc");
        System.out.println("TreeSet是否有序去重，看结果"+set3);








        /**
         * 以下写法会报错
         *  报错信息：Father cannot be cast to java.lang.Comparable
         *      没有办法把 Father 转为 Comparable接口
         *      需要把Father 实现 Comparable接口 并且实现 compareTo()
         *          开始
         */

        /**
         * * 以下写法会报错
         *  报错信息：Father cannot be cast to java.lang.Comparable
         *      没有办法把 Father 转为 Comparable接口
         *      需要把Father 实现 Comparable接口 并且实现 compareTo()
         *      第二种写法
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return
         */
        Set<Father> set4=new TreeSet<>(new Comparator<Father>() {
            @Override
            public int compare(Father o1, Father o2) {
                if(o1.getAge() > o2.getAge()){
                    return 1;
                }else if(o1.getAge() < o2.getAge()){
                    return -1;
                }
                return 0;
            }
        });
        /**
         * * 以下写法会报错
         *  报错信息：Father cannot be cast to java.lang.Comparable
         *      没有办法把 Father 转为 Comparable接口
         *      需要把Father 实现 Comparable接口 并且实现 compareTo()
         *      第二种写法
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return
         */
        set4.add(new Father("lisi",21,"shanghai"));
        set4.add(new Father("wangwu",22,"shanghai"));
        set4.add(new Father("zhangsan",23,"shanghai"));
        set4.add(new Father("zhangsan",22,"shanghai"));
        System.out.println("TreeSet"+set4);
        /**
         * 以下写法会报错
         *  报错信息：Father cannot be cast to java.lang.Comparable
         *      没有办法把 Father 转为 Comparable接口
         *      需要把Father 实现 Comparable接口 并且实现 compareTo()
         *          结束
         */
    }
}
