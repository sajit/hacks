package bits;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by sajit on 11/1/14.
 */
public class MyBitVector {

    public static void main(String[] args){
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Short.MAX_VALUE);
        //System.out.println(Integer.BYTES);
        int bitVec = 0;

        //Random random = new Random();
        //Set<Integer> nums = new HashSet<>();
        for(int i=0;i<5;i++){
            int cur = i;

            int twoPow = (int)Math.pow(2,cur);
            bitVec = bitVec | twoPow;
            System.out.println(cur + " <= Cur | BitVec " + bitVec + " |2^cur  => " + twoPow);
            //bitVec = bitVec | shortcur;
        }
        System.out.println("Bit Vec " + bitVec);

        for(int x=0;x<8;x++){
            System.out.println(" Should exist? "+x +" " + exists(x,bitVec));
        }



    }

    private static boolean exists(int x,int bitVec){
        return !((bitVec & (int)Math.pow(2,x)) == 0);
    }


}
