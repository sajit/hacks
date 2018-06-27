package hackerrank.algo.dp.candies;

public class Candies {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
       int[] minCandies = new int[n];
       for(int i=0;i<minCandies.length;i++){
           minCandies[i]=1;
       }
       for(int i=1;i<minCandies.length;i++){
           if(arr[i]>arr[i-1]){
               minCandies[i] = minCandies[i-1]+1;
           }
       }

       for(int i=minCandies.length-1;i>0;i--){
           if(minCandies[i]>=minCandies[i-1] && arr[i-1]>arr[i]){
               minCandies[i-1] = minCandies[i]+1;
           }
       }

       long sum=0;
       for(int candies : minCandies){
           sum += candies;
       }
       return sum;
    }

    public static void main(String[] args){

        int[] arr = {2,4,2,6,1,7,8,9,2,1};
//        System.out.println(candies(10,arr));
//        arr = new int[]{1,2,2};
//        System.out.println(candies(3,arr));
        arr = new int[]{5,4,3,2};
        System.out.println(candies(4,arr));
    }
}
