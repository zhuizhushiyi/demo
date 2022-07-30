package com.zhuiyi.demo.studyTest.io;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/** 字节输出流
 * @author by niYongJian
 * @Date 2022-07-24 22:00
 */
public class FileOutputStreamTest {
    public static void main(String[] args){
        //1.创建字节输出流 [两种方式]
        FileOutputStream fop=null;
//        FileOutputStream fop=new FileOutputStream("/Users/zhuiyi/idea/io/file.text");
//        FileOutputStream fop2=new FileOutputStream(new File("/Users/zhuiyi/idea/io/file.text"));
        try{
            fop=new FileOutputStream("/Users/zhuiyi/idea/io/file.text");  //默认覆盖原有内容
//            fop=new FileOutputStream("/Users/zhuiyi/idea/io/file.text",true);  //不覆盖，只追加
            //2.写出数据
            fop.write(97);
            fop.write(98);
            fop.write(99);

//            byte[] bytes= "hello".getBytes(); //写出一个字节数组
//            fop.write(bytes);
            byte[] bytes="hello".getBytes();      //写出一个字节数组，指定区间
            fop.write(bytes,2,3);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                //3.关闭流
                fop.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }



    }
}
