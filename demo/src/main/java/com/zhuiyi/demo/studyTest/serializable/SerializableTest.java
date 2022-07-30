package com.zhuiyi.demo.studyTest.serializable;

import java.io.*;

/** 序列化
 * @author by niYongJian
 * @Date 2022-07-25 21:45
 */

class SerializableEnity implements Serializable {

    private static final long serialVersionUID=1L;

    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "SerializableEnity{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public SerializableEnity() {
    }

    public SerializableEnity(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
public class SerializableTest {
    public static void main(String[] args) throws Exception {
//        FileOutputStream fos=new FileOutputStream("/Users/zhuiyi/idea/io/file2.text");
//        OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
//
//        ObjectOutputStream oop=new ObjectOutputStream(
//                fos );
//        SerializableEnity enity=new SerializableEnity("张三","13695625220");
//        oop.writeObject(enity);
//        fos.close();
//        osw.close();
//        oop.close();

        FileInputStream fis=new FileInputStream("/Users/zhuiyi/idea/io/file2.text");
        ObjectInputStream ois=new ObjectInputStream(fis);
        SerializableEnity enity1=(SerializableEnity)ois.readObject();
        System.out.println(enity1);
        ois.close();
        fis.close();

    }
}
