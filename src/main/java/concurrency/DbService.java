package concurrency;

import java.util.concurrent.*;

/**
 * Created by sajit.kunnumkal on 7/22/2015.
 */
public class DbService {

    public String getName_v1(String name,long sleep) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> future = executorService.submit(new StringCallable(name,sleep));
        executorService.shutdown();
        return future.get();
    }

    /**
     * This is a bad idea because it can always timeout but timeout is caught and can return null,
     * for a method that doesnt expect it
     * @param name
     * @param sleep
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public String badIdea(String name, long sleep) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String result = null;
        Future<String> future = executorService.submit(new StringCallable(name,sleep));
        executorService.shutdown();
        try {
            result = future.get(1000,TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {

        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        DbService service = new DbService();
        System.out.println(service.getName_v1("name_1",1000));

        System.out.println("######");

        System.out.println(service.badIdea("name_2", 400));

        System.out.println(service.badIdea("name_2:2", 1500));

    }
}
class StringCallable implements Callable<String> {

    final String value;
    final long sleepTime;

    public StringCallable(String value,long sleepTime) {
        this.value = value;
        this.sleepTime = sleepTime;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(sleepTime);
        System.out.println("In callable");
        return value;
    }
}
