package com.zhuiyi.demo.studyTest.io;

import java.io.*;

/** 测试非缓冲流字节流 与 缓冲流字节流字节流的速度 以及 缓存字符流的用法
 * @author by niYongJian
 * @Date 2022-07-25 20:40
 */
public class TestTime {
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
        System.out.println("FileInputStream,FileOutputStream用时多少毫秒[1秒 = 1000毫秒]：" + (end-start));


        long start1 = System.currentTimeMillis();
        BufferedInputStream bip=new BufferedInputStream(new FileInputStream(new File("/Users/zhuiyi/idea/io/file.text")));
        BufferedOutputStream bop=new BufferedOutputStream(new FileOutputStream(new File("/Users/zhuiyi/idea/io/file1.text")));

        byte[] bytes1=new byte[1024];
        int leng1;
        while ((leng1 = bip.read(bytes1)) != -1){
            bop.write(bytes1,0,leng1);
        }

        bip.close();
        bop.close();


        long end1=System.currentTimeMillis();
        System.out.println("BufferedInputStream,BufferedOutputStream用时多少毫秒[1秒 = 1000毫秒]：" + (end1-start1));


        System.out.println("-------------------------------------------------------------------------------------------");

        BufferedReader br=new BufferedReader(new FileReader("/Users/zhuiyi/idea/io/file.text"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("/Users/zhuiyi/idea/io/file1.text"));
        String leng2;
        while ((leng2=br.readLine()) != null){
            System.out.println(leng2);
            bw.write(leng2);
            bw.newLine();
        }
        br.close();
        bw.close();


    }
}
