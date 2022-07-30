package com.zhuiyi.demo.studyTest.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** 字符输出流
 * @author by niYongJian
 * @Date 2022-07-25 20:21
 */
public class FileWriterTest {

    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("/Users/zhuiyi/idea/io/file.text");

        char[] chars="中国人".toCharArray();
        fw.write(chars);

        fw.flush(); //刷新[相当于暂存]

        fw.write("中国人");


        fw.close();
    }
}
