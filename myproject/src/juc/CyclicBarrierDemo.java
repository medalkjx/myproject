package juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ：mei
 * @date ：Created in 2019/2/19 0019 下午 21:14
 * @description：循环屏障
 * @modified By：
 * @version: $
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("====>\t召唤神龙");
        });
        for (int i = 1; i <= 7 ; i++) {
            final int tem =i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t收集第"+tem+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
