package dp;

/**
 * Created by skunnumkal on 6/24/14.
 */
public class MakeChangeCount {
    static int[] V = {1,5,10,25};
    public static int countWays(int change){
        int[][] t = new int[change+1][V.length+1];
        for(int i=0;i<t[0].length;i++)
            t[0][i]=1;

        for(int i=0;i<t.length;i++){
            t[i][0]=0;
        }

        for(int i=1;i<t.length;i++){
            for(int j=1;j<t[i].length;j++){
              t[i][j] = t[i][j-1];
              if(i>=V[j-1]){
                 t[i][j] += t[i-V[j-1]][j];
              }

            }
        }

        return t[change][V.length];
    }
}
