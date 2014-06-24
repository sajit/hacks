package recursion;

/**
 * Created by skunnumkal on 6/23/14.
 */
public class MinMakeChange {

    public static int[] V = {1,5,10,25};
    public static int numCoins(int idx,int value){
        if(idx<0) return 10000;
        if(value<0) return 10000;
        if(value == 0) return 0;

        return Math.min(numCoins(idx-1,value),
                numCoins(idx,value-V[idx])+1);
    }
}
