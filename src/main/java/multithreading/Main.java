package multithreading;

import org.springframework.scheduling.config.Task;

import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ScheduledExecutorService executorService
                = Executors.newSingleThreadScheduledExecutor();
        CountDownLatch countDownLatch = new CountDownLatch(10);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            // ...
            System.out.println("All previous tasks are completed");
        });

        Thread t1 = new Thread((Runnable) new Task((Runnable) cyclicBarrier), "T1");
        Thread t2 = new Thread((Runnable)new Task((Runnable) cyclicBarrier), "T2");
        Thread t3 = new Thread((Runnable) new Task((Runnable) cyclicBarrier), "T3");

        if (!cyclicBarrier.isBroken()) {
            t1.start();
            t2.start();
            t3.start();
        }

        Semaphore semaphore = new Semaphore(10);

    }
}
