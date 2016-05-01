package gagan.threads.problems.solutions;

/**
 * Created by gagan on 10/4/16.
 */
public class ThreadSequenceVolatile {


    public static void main(String... args) {
        Sequence seq = new Sequence();
        Thread t1 = new Thread(seq, "T1");
        Thread t2 = new Thread(seq, "T2");
        Thread t3 = new Thread(seq, "T3");
        t1.start();
        t2.start();
        t3.start();
    }

}

class Sequence implements Runnable {
    //Object lock = new Object();
    static volatile int turn = 1;
    static volatile int counter = 1;


    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while (true) {
//synchronized (lock) {
            if (threadName.equals("T1") && turn == 1) {

                System.out.println(threadName + ": " + counter);

                turn = 2;
                counter++;
                Thread.yield();

            } else if (threadName.equals("T2") && turn == 2) {
                System.out.println(threadName + ": " + counter);

                turn = 3;
                counter++;
                Thread.yield();

            } else if (threadName.equals("T3") && turn == 3) {
                System.out.println(threadName + ": " + counter);

                turn = 1;
                counter++;
                Thread.yield();

            }
//}
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
