package com.zhuiyi.demo.studyTest.io;


import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * @author by niYongJian
 * @Date 2022-07-24 20:53
 */
public class FileTest {
    /**
     * 递归遍历指定文件夹下的所有的java文件内容
     *      开始
     * @param dir
     */
    //第一种方法
    public static void printDir(File dir){
        if(dir.isFile() && dir.getName().endsWith(".java")){
            System.out.println(dir);
        }else{
            File[] file= dir.listFiles();
            if(file != null){
                for (File f:file){
                    if(f.isFile()){
                        if(f.getName().endsWith(".java")){
                            System.out.println(f);
                        }

                    }else{
                        printDir(f);
                    }

                }
            }
        }
    }
    //第二种使用FileFilter接口
    public static void printDir2(File dir){
        if(dir.isFile() && dir.getName().endsWith(".java")){
            System.out.println(dir);
        }else{
            File[] file= dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory() || (pathname.isFile() && pathname.getName().endsWith(".java"));
                }
            });
            if(file != null){
                for (File f:file){
                    if (f.isDirectory()){
                        printDir2(f);
                    }else{
                        System.out.println(f);
                    }
                }
            }
        }
    }
    /**
     * 递归遍历指定文件夹下的所有的java文件内容
     *      开始
     * @param
     */

    public static void main(String[] args) throws IOException {

        File file=new File("/Users/zhuiyi/idea/");
        System.out.println("文件的绝对路径："+file.getAbsolutePath());
        System.out.println("文件的名称："+file.getName());
        System.out.println("文件的大小："+file.length());
        System.out.println("判断文件是否存在："+file.exists());
//        if (file.exists()){
//            file.delete();
//        }else {
//            file.createNewFile();
//        }
        System.out.println("判断是否是文件："+file.isFile());
        System.out.println("判断是否是目录："+file.isDirectory());
//        if(!file.isDirectory()){
//            file.mkdir(); //创建单级目录
//            file.mkdirs(); //创建多级目录
//        }else{
//            file.delete();
//        }

        //遍历文件名
        String[] list= file.list();
        for (String str: list) {
            System.out.println(str);
        }

        //遍历文件目录
        File[] list2= file.listFiles();
        for (File str: list2) {
            System.out.println(str);
        }

        System.out.println("----------------------------------------------------------------------");
        //遍历目录所有的文件内容
        printDir2(file);

//        File file2=new File("/Users/zhuiyi/idea");
//        System.out.println("文件夹的绝对路径："+file2.getAbsolutePath());
//        System.out.println("文件夹的名称："+file2.getName());
//        System.out.println("文件夹的大小："+file2.length());



    }
}
