package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment(){
        lock.lock();
        try {
            while(number != 0){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrement(){
        lock.lock();
        try {
            while(number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    /*public synchronized void increment() throws InterruptedException {
        while (number !=0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+","+number);
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        while (number ==0){
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+","+number);
        this.notifyAll();
    }*/
}
/**
 * @author ：mei
 * @date ：Created in 2019/2/19 0019 下午 18:49
 * @description：线程等待
 * 题目：现在两个线程，可以操作初始值为零的一个变量，实现一个线程对该变量加1，一个线程对该变量减1，
 * 实现交替，来10轮，变量初始值为零。
 *
 * 1 高内聚低耦合前提下，线程   操作      资源类
 * 2 判断+干活+通知
 * 3 避免虚假唤醒，线程判断用while
 * @modified By：
 * @version: $
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() ->{
            for (int i = 1; i <=10 ; i++)
                try {
                    shareResource.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        },"A").start();

        new Thread(() ->{
            for (int i = 1; i <=10; i++)
                try {
                shareResource.decrement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(() ->{
            for (int i = 1; i <=10 ; i++)
                try {
                    shareResource.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        },"C").start();
        new Thread(() ->{
            for (int i = 1; i <= 10; i++)
                try {
                    shareResource.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        },"D").start();
    }
}
