package com.study.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TempThread implements Runnable{
    @Override
    public void run() {
        // 打印正在执行的缓存线程信息
        System.out.println(Thread.currentThread().getName()+"正在被执行");
        try{
            // sleep  一秒保证3哥人物分别在3个线程上执行
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public static class TestThreadPoolExecutor{
        public static void main(String[] args) {
            // 创建数组型缓冲等待队列
            BlockingQueue<Runnable> bq = new ArrayBlockingQueue<Runnable>(10);
            // ThreadPoolExecutor:创建自定义线程池，池中保存的线程池数为3，允许最大的线程数为6
            ThreadPoolExecutor tpe = new ThreadPoolExecutor(3,
                    6,50, TimeUnit.MILLISECONDS,bq);

            //创建3个任务
            Runnable t1 = new TempThread();
            Runnable t2 = new TempThread();
            Runnable t3 = new TempThread();

            // 3个任务分别在3个线程执行
            tpe.execute(t1);
            tpe.execute(t2);
            tpe.execute(t3);

            // 关闭自定义线程池
            tpe.shutdown();
        }
    }
}
