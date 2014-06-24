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
}
