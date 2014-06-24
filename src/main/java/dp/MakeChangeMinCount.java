package dp;

import java.util.logging.Logger;

/**
 * Created by skunnumkal on 6/24/14.
 */
public class MakeChangeMinCount {
    static Logger LOGGER = Logger.getLogger(MakeChangeMinCount.class.getSimpleName());
    static int[] V = {1,5,10,25};
    public static int minWays(int change){
        int[][] t = new int[change+1][V.length+1];
        for(int i=0;i<t[0].length;i++)
            t[0][i]=0;

        for(int i=0;i<t.length;i++){
            t[i][0]=10000;
        }

        for(int i=1;i<t.length;i++){
            for(int j=1;j<t[i].length;j++){
                int skipVal = t[i][j-1];
                int includeVal = 10000;
                if(i>=V[j-1]){
                    includeVal = t[i-V[j-1]][j];
                }
                t[i][j] = Math.min(skipVal,includeVal+1);

            }
        }

        return t[change][V.length];
    }

    public static void main(String[] args){
        LOGGER.info("Min ways to make " + MakeChangeMinCount.minWays(25));
    }
}
