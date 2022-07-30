package com.zhuiyi.demo.studyTest.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/** 字符输入流
 * @author by niYongJian
 * @Date 2022-07-25 20:05
 */
public class FileReaderTest {
    public static void main(String[] args) throws Exception {
        FileReader fr=new FileReader("/Users/zhuiyi/idea/io/file.text");

        //字符流读取
            //第一种方式
//        System.out.println("");
//        int ch;
//        while ((ch=fr.read())!= -1){
//            System.out.print((char) ch);
//        }
            //第二种方式
        System.out.println("");
        char[] chars=new char[1024];
        int ch1;
        while ((ch1= fr.read(chars)) != -1){
            System.out.print(new String(chars,0,ch1));
        }
        System.out.println("");

        fr.close();
    }
}
