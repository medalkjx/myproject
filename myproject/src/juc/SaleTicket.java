package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：mei
 * @date ：Created in 2019/2/18 0018 下午 18:23
 * @description：多线程售票
 * 三个售票员卖出30张票
 *	多线程编程的企业级套路+模板
 *  1 线程        操作          资源类
 *  2 高内聚   低耦合
 * @modified By：
 * @version: $
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {for(int i=1;i<=40;i++) ticket.sale();},"A").start();
        new Thread(() -> {for(int i=1;i<=40;i++) ticket.sale();},"B").start();
        new Thread(() -> {for(int i=1;i<=40;i++) ticket.sale();},"C").start();
    }


}

/**
 *
 */
class Ticket {
    private int number = 30;
    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第" + (number--) + "张票,还剩余票数" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}