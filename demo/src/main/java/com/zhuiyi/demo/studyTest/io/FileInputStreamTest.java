package com.zhuiyi.demo.studyTest.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/** 字节输入流
 * @author by niYongJian
 * @Date 2022-07-25 19:01
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws Exception {
        //创建输入流的对象，[绝对路径]
        FileInputStream fip=new FileInputStream(new File("/Users/zhuiyi/idea/io/file.text"));
        //2.读取数据[两种方法]
            //单字符读取
//        char  c= (char) fip.read();
//        System.out.println("读取单个字符"+ c);
//
//        System.out.println("第一种方式读取文件：");
//        int i;
//        while ((i=fip.read()) != -1){
//            System.out.print( (char)i);
//        }
//        System.out.println("");

            //读取字节数组
        System.out.println("第二种方式读取文件：");
        byte[] bytes=new byte[1024];
        int leng;
        while ((leng=fip.read(bytes)) != -1){
            System.out.print( new String(bytes,0,leng));
        }
        System.out.println("");

        fip.close();

    }
}
