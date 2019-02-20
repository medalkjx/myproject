package juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author ：mei
 * @date ：Created in 2019/2/19 0019 下午 20:03
 * @description：倒序计数
 * @modified By：
 * @version: $
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i=1 ; i <=6 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t国被灭");
                countDownLatch.countDown();
            },CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t====>华夏一统");
    }

    public static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t同学离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t==>班长关门走人");
    }
}
