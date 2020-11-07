package com.boring;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author boring
 * @date 2020/9/4 下午4:26
 */
public class ThreadPoolRejectedHandlerDemo {
    public static void main(String[] args) throws InterruptedException {
//        ThreadPoolExecutor executors = new ThreadPoolExecutor(2, 2, 0,
//                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1), new ThreadPoolExecutor.AbortPolicy());
//        for (int i = 0; i < 4; i++) {
//            executors.submit(() -> System.out.println(Thread.currentThread()));
//        }


//        ThreadPoolExecutor executors = new ThreadPoolExecutor(2, 2, 0,
//                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1), new ThreadPoolExecutor.CallerRunsPolicy());
//        for (int i = 0; i < 4; i++) {
//            executors.submit(() -> System.out.println(Thread.currentThread()));
//        }


//        ThreadPoolExecutor executors = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(3),
//                new ThreadPoolExecutor.DiscardOldestPolicy());
//        for (int i = 0; i < 7; i++) {
//            int j = i;
//            System.out.print(j+1 + "提交--");
//            executors.submit(() -> {
//                try {
//                    Thread.sleep(100L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.print(j+1 + "执行--");
//            });
//        }

        ThreadPoolExecutor executors = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1),
                new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 5; i++) {
            int j = i;
            System.out.print(j + 1 + "提交--");
            executors.submit(() -> {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(j + 1 + "执行--");
            });
        }
    }
}
