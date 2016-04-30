package gagan.threads.concepts.concurrent;

/**
 * Created by gagan on 10/4/16.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuterTest {

    public static void main(String... args) throws Exception {
        ExecutorService executerService = Executors.newFixedThreadPool(15);
        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Future<String> result = executerService.submit(new CallableTask(i + ""));
            results.add(result);
        }
        Thread.sleep(1000);
        for (Future<String> item : results
                ) {
            System.out.println("Result " + item.get());
        }

        executerService.shutdown();

    }
}
