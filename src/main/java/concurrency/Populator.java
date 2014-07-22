package concurrency;

import java.util.Random;

/**
 * Created by skunnumkal on 7/19/14.
 */
public class Populator implements Runnable {

    final Simple simple;
    final int idx;
    public Populator(Simple simple,int idx){
        this.simple = simple;
        this.idx = idx;
    }
    public Populator(SynchronizedSimple simple,int idx){
        this.simple = simple;
        this.idx = idx;

    }
    @Override
    public void run() {
        //System.out.println("Running idx " + idx);
        Random r = new Random();
        if(r.nextBoolean()){
            simple.setI(r.nextInt());
        }
        else{
            System.out.println("Getting I " + simple.getI());
        }

    }
}
