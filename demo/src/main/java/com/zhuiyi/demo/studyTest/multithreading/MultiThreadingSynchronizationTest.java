package com.zhuiyi.demo.studyTest.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author by niYongJian
 * @Date 2022-07-26 22:21
 */
// 第一种锁 synchronized锁
class Ticket implements Runnable{
    private static int ticket=100;


    @Override
    public void run() {
////        synchronized锁：同步代码块
//        synchronized (Ticket.class){    //加synchronized锁解决安全问题 ，当new多个实例的时候可以用当前类的名称.class [例如这里Ticket.class,前提是 ticket也要加上static修饰] 也可以实现锁的效果！！！
//            //...
//        }

        //synchronized锁：同步代码块
        ticket();
    }

    /**
     * synchronized可以非修饰静态方法，锁就相当于类名[例如这里this]
     *  synchronized还可以修饰静态方法，锁就相当于类名[例如这里Ticket.class]
     */
    public synchronized void ticket(){
        while (ticket > 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"  MyRunnable线程："+ ticket--);
        }
    }
}
//第二种锁：Lock接口锁
class MyList{

    private Lock lock=new ReentrantLock();
    private String[] strArr={"a","b","","",""};
    private int index=2;
    public void add(String str){
        lock.lock();
        try {
            strArr[index]=str;
            Thread.sleep(100);
            index++;
            System.out.println(Thread.currentThread().getName()+ "添加了" + str);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public String[] getStrArr(){
        return strArr;
    }
}

public class MultiThreadingSynchronizationTest {

    public static void main(String[] args) throws InterruptedException {
//        Ticket r=new Ticket();
//        Thread  t1=new Thread(r,"窗口1");
//        Thread  t2=new Thread(r,"窗口2");
//        t1.start();
//        t2.start();

        System.out.println("---------------------------------------------------------------------------------------------------------");

        MyList myList=new MyList();
        Runnable runnable1=new Runnable() {
            @Override
            public void run() {
                myList.add("hello");
            }
        };
        Runnable runnable2=new Runnable() {
            @Override
            public void run() {
                myList.add("word");
            }
        };
        Thread t3=new Thread(runnable1,"线程A");
        Thread t4=new Thread(runnable2,"线程B");
        t3.start();
        t4.start();

//        t3.join();
//        t4.join();

        Thread.sleep(1000);
        String[] strArr= myList.getStrArr();
        for (String str:strArr) {
            System.out.println("str:" + str);
        }
    }

}
