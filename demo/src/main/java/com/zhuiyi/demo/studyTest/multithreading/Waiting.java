package com.zhuiyi.demo.studyTest.multithreading;

/**
 * @author by niYongJian
 * @Date 2022-07-28 20:26
 */
public class Waiting {



    public static void main(String[] args) {
        Object lock=new Object();
        //客户线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+"说：老板，来俩包子！");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+"拿到老板做好的早餐，吃了起来");

                }

            }
        },"客户一").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+"说：老板，来俩包子！");
                    try {
                        lock.wait();
//                        lock.wait(1000); //等待指定时间 [毫秒]
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+"拿到老板做好的早餐，吃了起来");

                }

            }
        },"客户二").start();

        //商家线程
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+"制作好了！");
//                    lock.notify(); //唤醒一个
                    lock.notifyAll(); //唤醒所有的
                }


            }
        },"包子店").start();


    }
}
