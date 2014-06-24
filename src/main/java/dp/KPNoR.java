package dp;

/**
 * Created by skunnumkal on 6/22/14.
 */
public class KPNoR {
    public static int maxVal(int weightRemaining,int idx){
        int[][] table = new int[weightRemaining+1][idx+1];
        for(int i=0;i<table[0].length;i++){
            table[0][i] = 0;
        }
        for(int i=0;i<table.length;i++){
            table[i][0] = 0;
        }

        for(int i=1;i<table.length;i++){
            for(int j=1;j<table[i].length;j++){
                int skipVal = table[i][j-1],includeVal = 0;
                if(i>=recursion.KPNoR.W[j-1]){
                    includeVal = recursion.KPNoR.V[j-1] + table[i-recursion.KPNoR.W[j-1]][j];
                }
                table[i][j] = Math.max(skipVal,includeVal);
            }
        }

        return table[weightRemaining][idx];
    }
}
