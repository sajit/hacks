package recursion;

/**
 * Created by skunnumkal on 6/22/14.
 */
public class KPWitR {

    public static int maxVal(int idx,int remainingWeight){
        if(idx < 0 )return 0;

        if(remainingWeight <= 0 ) return 0;
        int skipVal = maxVal(idx-1,remainingWeight);
        int includeVal = 0;
        for(int i=idx;i>=0;i--){
           int val =  maxVal(idx,remainingWeight - KPNoR.W[idx]) + KPNoR.V[idx];
            if(val > includeVal){
                includeVal = val;
            }
        }
        //System.out.println("Current Remaining Weight" + remainingWeight);
        //System.out.println("Skip " + idx + " = " + skipVal + " Include Val " + includeVal);
        return Math.max(skipVal,includeVal);
    }



    public static int maxVal2(int idx,int remainingWeight){
        if(idx < 0 )return 0;

        if(remainingWeight <= 0 ) return 0;
        return Math.max(maxVal(idx-1,remainingWeight),
                maxVal(idx,remainingWeight - KPNoR.W[idx])+KPNoR.V[idx]);
    }




}
