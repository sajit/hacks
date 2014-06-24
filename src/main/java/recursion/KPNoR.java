package recursion;

/**
 * Created by skunnumkal on 6/22/14.
 */
public class KPNoR {
    public static int[] W = {5,3,5};
    public static int[] V = {8,6,5};


    public static int maxVal(int idx,int remainingWeight){
        if(idx < 0 )return 0;
        if(remainingWeight <= 0 ) return 0;
        return Math.max(maxVal(idx-1,remainingWeight),
                maxVal(idx-1,remainingWeight- W[idx])+V[idx]);
    }

}
