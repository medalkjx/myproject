package juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
class MyThread implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("=====>come in");
        return "in";
    }
}
*/

/**
 * @author ：mei
 * @date ：Created in 2019/2/19 0019 下午 19:50
 * @description：多线程中，第3种获得多线程的方式
 * @modified By：
 * @version: $
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask(() -> {
            System.out.println("=====>com in call() lambdy express");
            return "come";
        });
        Thread thread = new Thread(futureTask, "A");
        thread.start();
        System.out.println("======>retValue: " + futureTask.get());
    }
}
