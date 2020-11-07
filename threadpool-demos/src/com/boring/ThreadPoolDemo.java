package com.boring;

import java.util.concurrent.*;

/**
 * @author boring
 * @date 2020/8/22 下午1:28
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();
//        threadPoolDemo.normalThreadPool();
//        threadPoolDemo.normalThreadPoolRejectHandler();
//        threadPoolDemo.executorsNewFixed();
//        threadPoolDemo.executorsNewCached();
//        threadPoolDemo.scheduledThreadPoolOnce();
//        threadPoolDemo.scheduledThreadPoolAtFixedRate();
        threadPoolDemo.scheduledThreadPoolWithFixedDelay();
    }

    /**
     * 公共测试模块
     *
     * @param threadPoolExecutor 具体的线程池实例
     */
    public void commonTestCase(ThreadPoolExecutor threadPoolExecutor) throws InterruptedException {
        for (int i = 0; i < 8; i++) {
            final int n = i;
            threadPoolExecutor.submit(() -> {
                try {
                    // 模拟任务，时长2秒钟
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 在任务执行过程中，查看线程池状态
        Thread.sleep(100L);
        System.out.println("执行中线程池线程数量：" + threadPoolExecutor.getPoolSize());
        System.out.println("执行中等待队列任务数：" + threadPoolExecutor.getQueue().size());
        // 任务执行完之后，查看线程池状态
        Thread.sleep(10000L);
        System.out.println("执行完线程池线程数量：" + threadPoolExecutor.getPoolSize());
        System.out.println("执行完等待队列任务数：" + threadPoolExecutor.getQueue().size());

        // 等待缓存线程存活时间
//        Thread.sleep(60000L);
//        System.out.println("超过缓存时间线程池线程数量：" + threadPoolExecutor.getPoolSize());
//        System.out.println("超过缓存时间等待队列任务数：" + threadPoolExecutor.getQueue().size());
    }

    /**
     * 线程池：
     * <br/>核心线程数量为 3个，最多线程数量为 5个；
     * <br/>超过核心数量的线程的存活时间为 5秒；
     * <br/>线程等待队列为无界队列
     *
     * @throws InterruptedException
     */
    public void normalThreadPool() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5,
                5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
        commonTestCase(threadPoolExecutor);
    }

    /**
     * 线程池：
     * <br/>核心线程数量为 3个，最多线程数量为 5个；
     * <br/>超过核心数量的线程的存活时间为 5秒；
     * <br/>线程等待队列为容量大小为 3的队列
     * <br/>指定拒绝策略
     *
     * @throws InterruptedException
     */
    public void normalThreadPoolRejectHandler() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2),
                (r, executor) -> System.out.println("拒绝任务"));
        commonTestCase(threadPoolExecutor);
    }

    /**
     * 等价于：
     * new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
     *
     * @throws InterruptedException
     */
    public void executorsNewFixed() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        commonTestCase(threadPoolExecutor);
    }

    /**
     * 等价于:
     * new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
     *
     * @throws InterruptedException
     */
    public void executorsNewCached() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        commonTestCase(threadPoolExecutor);
    }

    public void executorsNewSingleton() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // ... test code
    }

    /**
     * 定义定时任务线程池，1秒后执行任务。DelayedWorkQueue实现。
     */
    public void scheduledThreadPoolOnce() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        scheduledThreadPoolExecutor.schedule(() -> {
            System.out.println("执行定时任务：" + System.currentTimeMillis());
        }, 1000L, TimeUnit.MILLISECONDS);
        System.out.println("提交定时任务：" + System.currentTimeMillis());
    }

    /**
     * 定义定时任务线程池，1秒后执行任务,每隔三秒执行一次，任务执行时间为5秒。
     * 说明：任务执行时间大于循环周期，则该方式，在前次任务执行完成后立即执行。
     */
    public void scheduledThreadPoolAtFixedRate() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            System.out.println("执行定时任务开始：" + System.currentTimeMillis());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行定时任务结束：" + System.currentTimeMillis());
        }, 1000L, 3000L, TimeUnit.MILLISECONDS);
        System.out.println("完成提交定时任务：" + System.currentTimeMillis());
    }

    /**
     * 定义定时任务线程池，1秒后执行任务,每隔三秒执行一次，任务执行时间为5秒。
     * 说明：该方式是在前次任务执行结束后开始计算循环周期时间，即前次任务执行结束后，再经过3秒执行下次任务。
     */
    public void scheduledThreadPoolWithFixedDelay() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(() -> {
            System.out.println("执行定时任务开始：" + System.currentTimeMillis());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行定时任务结束：" + System.currentTimeMillis());
        }, 1000L, 3000L, TimeUnit.MILLISECONDS);
        System.out.println("完成提交定时任务：" + System.currentTimeMillis());
    }
}
