package recursion;

import static dp.KPWitR.minusInf;

/**
 * Created by skunnumkal on 6/22/14.
 */
public class KPWithRAndSingleItems {

    public static int maxVal(int idx,int remainingWeight){
        if(idx < 0 )return 0;
        if(remainingWeight<0) return 0;
        if(remainingWeight==0) return 0;
        int skipMaxVal = maxVal(idx-1,remainingWeight);
        if(remainingWeight>=KPNoR.W[idx]){
            return KPNoR.V[idx] + skipMaxVal;
        }
        else
            return skipMaxVal;


    }

    public static void main(String[] args){
        System.out.println(maxVal(2,9));
    }


    public static int maxVal2(int idx,int remainingWeight){
        if(idx < 0 )return 0;

        if(remainingWeight <= 0 ) return 0;
        return Math.max(maxVal(idx-1,remainingWeight),
                maxVal(idx,remainingWeight - KPNoR.W[idx])+KPNoR.V[idx]);
    }




}
