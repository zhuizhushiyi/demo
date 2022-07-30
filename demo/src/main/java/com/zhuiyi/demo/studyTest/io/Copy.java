package com.zhuiyi.demo.studyTest.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/** 复制文件
 * @author by niYongJian
 * @Date 2022-07-25 19:55
 */
public class Copy {
    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        FileInputStream fileInput=new FileInputStream(new File("/Users/zhuiyi/idea/io/file.text"));
        FileOutputStream fileoutput=new FileOutputStream(new File("/Users/zhuiyi/idea/io/file1.text"));

        byte[] bytes=new byte[1024];
        int leng;
        while ((leng = fileInput.read(bytes)) != -1){
            fileoutput.write(bytes,0,leng);
        }
        fileInput.close();
        fileoutput.close();

        long end=System.currentTimeMillis();
        System.out.println("用时多少毫秒[1秒 = 1000毫秒]：" + (end-start));
    }
}
