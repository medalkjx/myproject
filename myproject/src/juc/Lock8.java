package juc;

import java.util.concurrent.TimeUnit;

class Phone{
    public static synchronized void sendSMS(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("===>sendSMS()");
    }
    public synchronized void sendEmail(){
        System.out.println("===>sendEmail()");
    }
    public void openPhone(){
        System.out.println("===>openPhone()");
    }
}
/**
 * @author ：mei
 * @date ：Created in 2019/2/19 0019 下午 19:14
 * @description：八种锁现象
 *  题目：多线程8锁
 * 1 一般访问，请问先打印短信还是邮件？S
 * 2 短信暂停4秒钟，请问先打印短信还是邮件？S
 * 3 新增普通开机方法， 请问先打印短信还是开机？O
 * 4 有两部手机，请问先打印短信还是邮件？E
 * 5 静态同步方法，1部手机，请问先打印短信还是邮件？S
 * 6 静态同步方法，2部手机，请问先打印短信还是邮件？S
 * 7 一个普通同步方法，一个静态同步方法，1部手机，请问先打印短信还是邮件？E
 * 8 一个普通同步方法，一个静态同步方法，2部手机，请问先打印短信还是邮件？E
 * @modified By：
 * @version: $
 */
public class Lock8 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            phone.sendSMS();
        },"A").start();
      try { TimeUnit.MILLISECONDS.sleep(200); } catch (Exception e) { e.printStackTrace();}
        new Thread(()->{
            //phone.sendEmail();
            phone2.sendEmail();
            //phone.openPhone();
        },"B").start();
    }
}
