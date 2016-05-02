package gagan.threads.problems.solutions;

import java.util.concurrent.Semaphore;

/**
 * Created by gagan on 1/5/16.
 */
public class ThreadSequenceSemaphore {
    public static void main(String... args) {
        Semaphore semaphore = new Semaphore(1);
        int sequenceThreads = 4;
        for (int i = 1; i <= sequenceThreads; i++) {
            new Thread(new Test(semaphore, sequenceThreads)).start();
        }
    }


}


class Test implements Runnable {

    private static int i = 1;
    private static int threadCount = 0;
    final private Semaphore semaphore;
    private final int threadNo;
    final private int totalThreads;

    public Test(Semaphore semaphore, int totalThreads) {
        this.semaphore = semaphore;
        threadNo = threadCount + 1;
        this.totalThreads = totalThreads;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphore.acquire();
                if (i % totalThreads == 0 || i == threadNo) {//faulty logic
                    System.out.println("Thread " + threadNo + " Printing " + i);
                    i++;
                }

            } catch (InterruptedException e) {
                System.out.print(e.toString());
            } finally {
                semaphore.release();
            }
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
