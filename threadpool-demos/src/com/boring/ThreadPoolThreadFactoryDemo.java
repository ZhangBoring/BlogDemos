package com.boring;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author boring
 * @date 2020/9/4 下午5:27
 */
public class ThreadPoolThreadFactoryDemo {

    public static class UserThreadFactory implements ThreadFactory {
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        public UserThreadFactory(String whatFutureOfGroup) {
            this.namePrefix = "UserThreadFactory-" + whatFutureOfGroup + "-Thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            String name = namePrefix + threadNumber.getAndIncrement();
            return new Thread(r, name);
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1), new UserThreadFactory("SomeOperate"));
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName() + "-do something");
        executor.submit(runnable);
        executor.submit(runnable);
    }
}
