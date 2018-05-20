package dp;

/**
 * Created by skunnumkal on 6/21/14.
 */
public class MaxSumSequence {

    public static int maxSum(int[] arr){
        int max = 0, currentSum = 0;
        for(int i=0;i<arr.length;i++){
            currentSum += arr[i];
            if(currentSum < 0){
                currentSum = 0;
            }
            if(currentSum > max){
                max = currentSum;
            }
        }
        return max;
    }

    public static int maxSumR(int[] arr,int idx,int globalMax,int currentSum){
        if(idx>=arr.length) return globalMax;
        int newMax = currentSum + arr[idx];
        if(newMax<0) newMax = 0;
        if(newMax>globalMax){
            globalMax = newMax;
        }
        return maxSumR(arr,idx+1,globalMax,newMax);

    }

    public static void main(String[] args) {
        int arr[] = {6,-13,1,7,-5,-9,19};
        System.out.println(maxSumR(arr,1,arr[0],arr[0]));
    }
}
