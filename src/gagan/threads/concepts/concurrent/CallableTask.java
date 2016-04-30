package gagan.threads.concepts.concurrent;

import java.util.concurrent.Callable;

/**
 * Created by gagan on 1/5/16.
 */
public class CallableTask implements Callable<String> {
    final private String value;

    public CallableTask(String value) {
        this.value = value;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(300);
        String temp = Thread.currentThread().getName() + " " + value;
        System.out.println("Executing " + temp);
        return temp;
    }
}
