package dp;



/**
 * Created by skunnumkal on 6/22/14.
 */
public class KPWitR {

    public static int maxVal(int weightRemaining){
        int[][] M = new int[weightRemaining+1][4];

        for(int i=1;i<M.length;i++){
            for(int j=1;j<M[i].length;j++){
                int skipVal = M[i][j-1];
                int maxPrev = 0;
                for(int k=1;k<i;k++){
                    if(M[k][j]>maxPrev){
                        maxPrev = M[k][j];
                    }
                }
                int includeVal = 0;
                if(i>=recursion.KPNoR.W[j-1]){
                    includeVal = recursion.KPNoR.V[j-1] + maxPrev;
                }
                M[i][j] = Math.max(skipVal,includeVal);
            }
        }

        return M[weightRemaining][3];
    }
}
