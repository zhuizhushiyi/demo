package com.zhuiyi.demo.studyTest.javaPeculiarity.inherit;

/** 子类
 * @author by niYongJian
 * @Date 2022-07-24 10:34
 */
public class Son  extends Father {  //子类继承父类
    /**
     * 玩具
     */
    private String toy;

    public String getToy() {
        return toy;
    }

    public void setToy(String toy) {
        this.toy = toy;
    }

    @Override
    public String toString() {
        return "Son{" +
                "toy='" + toy + '\'' +
                '}';
    }

    public Son() {
    }

    public Son(String toy) {
        this.toy = toy;
    }

    public Son(String name, int age, String huji, String toy) {
        super(name, age, huji);
        this.toy = toy;
    }

    public void print(){
        System.out.println("打印子类print方法");
    }
}
