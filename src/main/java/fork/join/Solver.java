package fork.join;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * Created by skunnumkal on 8/6/14.
 */
public class Solver extends RecursiveAction {
    private int[] list;
    public long result;

    public Solver(int[] array) {
        this.list = array;
    }

    @Override
    protected void compute() {
        if(list.length ==1){
            result = list[0];
        }
        else{
            int midpoint = list.length/2;
            int[] l1 = Arrays.copyOfRange(list, 0, midpoint);
            int[] l2 = Arrays.copyOfRange(list, midpoint, list.length);
            Solver s1 = new Solver(l1);
            Solver s2 = new Solver(l2);
            invokeAll(s1, s2);
            result = s1.result + s2.result;
        }

    }
}
