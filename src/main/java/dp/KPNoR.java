package dp;

/**
 * Created by skunnumkal on 6/22/14.
 */
public class KPNoR {
    public static int maxVal(int weightRemaining,int idx){
        //table contains maximum value that can be obtained by
        // ith weight and jth item
        int[][] table = new int[weightRemaining+1][idx+1];
        for(int i=0;i<table[0].length;i++){
            table[0][i] = 0; //0 weights can only be got by taking nothing ie value = 0
        }
        for(int i=0;i<table.length;i++){
            table[i][0] = 0; // without taking any items value = 0
        }

        for(int i=1;i<table.length;i++){
            for(int j=1;j<table[i].length;j++){
                //skipValMax is maximum value that can be obtained by not taking the jth item for ith weight
                //includeValMax is maximum value that can be obtained by including jth item for ith weight
                int skipValMax = table[i][j-1];
                int includeValMax = 0;
                if(i>=recursion.KPNoR.W[j-1]){ //if weight > weight of jth item
                    includeValMax = recursion.KPNoR.V[j-1] + table[i-recursion.KPNoR.W[j-1]][j];
                    //value = value of jth item + max value of for weight of (i - jth item)
                }
                table[i][j] = Math.max(skipValMax,includeValMax);
            }
        }

        return table[weightRemaining][idx];
    }
}
