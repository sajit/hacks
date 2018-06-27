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


    static final int minusInf = -10000;
    static int unboundedKnapsack(int k, int[] arr) {
        //return k-unboundedKnapsackR(k,arr,arr.length-1);
        return k-unboundedKnapsackDP(k,arr);

    }
    static int unboundedKnapsackR(int k, int[] arr,int i) {
        if(k<0) return minusInf;
        if(i<0) return minusInf;
        if(k==0) return 0;
        return Math.max(unboundedKnapsackR(k,arr,i-1),unboundedKnapsackR(k-arr[i],arr,i));

    }

    static int unboundedKnapsackDP(int k, int[] arr){
        int[][] max_vals = new int[k+1][arr.length+1];
        for(int j=1;j<max_vals[0].length;j++)max_vals[0][j]=0;
        for(int i=0;i<max_vals.length;i++)max_vals[i][0]=minusInf;

        for(int i=1;i<max_vals.length;i++){
            for(int j=1;j<max_vals[i].length;j++){
                if(i>=arr[j-1]){
                    max_vals[i][j]=Math.max(max_vals[i][j-1],max_vals[i-arr[j-1]][j]);
                }
                else {
                    max_vals[i][j] = Math.max(max_vals[i][j-1],minusInf);
                }
            }
        }
        return max_vals[k][arr.length];
    }

    public static void main(String[] args) {
        System.out.println(unboundedKnapsack(12,new int[]{3,6,9}));
        System.out.println(unboundedKnapsack(9,new int[]{3,4,4,4,8}));
    }

}
