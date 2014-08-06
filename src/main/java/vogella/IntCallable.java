package vogella;

import java.util.concurrent.Callable;

/**
 * Created by skunnumkal on 8/6/14.
 */
public class IntCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(3000);
        return Integer.valueOf(1);
    }
}
