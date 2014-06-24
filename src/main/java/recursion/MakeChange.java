package recursion;

/**
 * Created by skunnumkal on 6/23/14.
 */
public class MakeChange {

    public static int[] V = {1,5,10,25};
    public static int numWays(int idx,int value){
        if(idx<0) return 0;
        if(value<0) return 0;
        if(value == 0) return 1;

        return numWays(idx-1,value) + numWays(idx,value-V[idx]);
    }


}
