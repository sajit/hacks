package concurrency;

import java.util.concurrent.Callable;

/**
 * Created by skunnumkal on 7/26/14.
 */


public class MyCallable implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (long i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }

}
