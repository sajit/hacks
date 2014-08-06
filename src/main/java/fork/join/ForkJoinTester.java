package fork.join;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by skunnumkal on 8/6/14.
 */
public class ForkJoinTester {
    private final int[] list = new int[2000000];

    public ForkJoinTester() {
        Random generator = new Random(19580427);
        for (int i = 0; i < list.length; i++) {
            list[i] = generator.nextInt(500000);
        }
    }

    public int[] getList() {
        return list;
    }

    public static void main(String[] args){
        ForkJoinTester test = new ForkJoinTester();
        Solver mfj = new Solver(test.getList());

        ForkJoinPool pool = new ForkJoinPool();
        long startTime = System.currentTimeMillis();
        pool.invoke(mfj);
        long result = mfj.result;
        long endTime = System.currentTimeMillis();
        System.out.println("Final Result " + result + " and taken " + (endTime-startTime));


    }
}
