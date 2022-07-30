package com.zhuiyi.demo.studyTest.javaPeculiarity.inherit;

/** 父类
 * @author by niYongJian
 * @Date 2022-07-24 10:18
 */
public class Father implements Comparable<Father>{
    private String name;
    private int age;
    private String huji;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHuji() {
        return huji;
    }

    public void setHuji(String huji) {
        this.huji = huji;
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", huji='" + huji + '\'' +
                '}';
    }

    public Father() {

    }

    public Father(String name, int age, String huji) {
        this.name = name;
        this.age = age;
        this.huji = huji;
    }


    public void print(){
        System.out.println("打印父类print方法");
    }


    /**
     * listGather文件夹中Test类的HashSet<自定义类>
     *     自定义类型：如果希望自定义类型的成员相同时，不要重复添加到Set集合，那么应该重写hashCode()和equals()方法。
     *          开始
     * @return
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    /**
     * listGather文件夹中Test类的HashSet<自定义类>
     *     自定义类型：如果希望自定义类型的成员相同时，不要重复添加到Set集合，那么应该重写hashCode()和equals()方法。
     *          结束
     * @return
     */

    /**
     * listGather文件夹中Test类的TreeSet<自定义类>
     * 以下写法会报错
     *  报错信息：Father cannot be cast to java.lang.Comparable
     *      没有办法把 Father 转为 Comparable接口
     *      需要把Father 实现 Comparable接口 并且实现 compareTo()
     *      排序方式可以自行设置。
     *      第一种写法
     *          开始
     */
    @Override
    public int compareTo(Father o) {
        if (this.getAge() > o.getAge()){
            return 1;
        }else if(this.getAge() < o.getAge()){
            return -1;
        }
        return this.getName().compareTo(o.getName());
        // return this.getName().compareTo(o.getName()); 如果age重复会根据name再排序
        // return 0                                      如果age重复则去重
    }
    /**
     * listGather文件夹中Test类的TreeSet<自定义类>
     * 以下写法会报错
     *  报错信息：Father cannot be cast to java.lang.Comparable
     *      没有办法把 Father 转为 Comparable接口
     *      需要把Father 实现 Comparable接口 并且实现 compareTo()
     *      第一种写法
     *          结束
     */
}
