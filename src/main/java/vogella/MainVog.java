package vogella;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by skunnumkal on 8/6/14.
 */
public class MainVog {

    public static void main(String[] args) throws InterruptedException {
        int sum = 0;
        long startTime1 = System.currentTimeMillis();
        //Single thread execution
        for( int i=0;i<4;i++){
            Thread.sleep(3000);
            sum+=1;
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("Took " + (endTime1-startTime1)  + " milliseconds to calculate " + sum);
        int NTHREDS = 4;
        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        long startTime2 = System.currentTimeMillis();
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        for(int i=0;i<4;i++){
            Callable<Integer> worker = new IntCallable();
            Future<Integer> integerFuture = executor.submit(worker);
            list.add(integerFuture);
        }
        int parallelSum = 0;

        for (Future<Integer> future : list) {
            try {
                parallelSum += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        long endTime2 = System.currentTimeMillis();

        System.out.println("Took " + (endTime2-startTime2) + " milliseconds to calculate "+parallelSum);
        executor.shutdown();
    }
}
