package com.zhuiyi.demo.studyTest.multithreading;

/** 创建线程
 *      方法一：继承Thread
 * @author by niYongJian
 * @Date 2022-07-26 18:28
 */

class MyThread extends Thread{

    private int ticket=100;

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        while (ticket > 0){
            Thread.yield(); //线程让步
            System.out.println(Thread.currentThread().getName()+"  Thread线程："+ ticket--);
        }
    }

}

class MyRunnable implements Runnable{

    private int ticket=100;

    @Override
    public void run() {
        while (ticket > 0){
            Thread.yield(); //线程让步
            System.out.println(Thread.currentThread().getName()+"  MyRunnable线程："+ ticket--);
        }
    }
}
public class CreateMultipleThreadRunnableTest {
    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread=new MyThread();
////        myThread.run();//这事不同方法的调用[非多线程调用]
//        myThread.start(); //相当于开启一个新的线程，和main线程是同级的
//
//        MyRunnable myRunnable=new MyRunnable();
//        Thread thread=new Thread(myRunnable);
//        thread.start();
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println("主线程："+i);
//        }

        MyThread myt1=new MyThread("窗口1");
        MyThread myt2=new MyThread("窗口2");
        myt1.setPriority(Thread.MIN_PRIORITY);  //设置窗口优先级 1-10， 默认：5， 值越大优先级越高
        myt2.setPriority(Thread.MIN_PRIORITY);  //设置窗口优先级 1-10， 默认：5， 值越大优先级越高
        myt1.start();
        myt2.start();
        System.out.println("----------------");

//        Thread.sleep(10*1000); //线程休眠制定的时间 单位毫秒

        myt1.join(); //线程合并
        myt2.join(); //线程合并

        MyRunnable r=new MyRunnable();
        Thread  t1=new Thread(r,"窗口3");
        Thread  t2=new Thread(r,"窗口4");
        t1.setPriority(10);  //设置窗口优先级 1-10， 默认：5， 值越大优先级越高
        t2.setPriority(10);  //设置窗口优先级 1-10， 默认：5， 值越大优先级越高
        t1.start();
        t2.start();


    }
}
