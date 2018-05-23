package greedy;

public class Candies {
    // Complete the candies function below.
    static int candies(int n, int[] arr) {
        int candies=1,currentMax=1;
        int downwardStreakCount = arr[1]<arr[0]?1:0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                currentMax +=1;
                int additionalCandies = downwardStreakCount*(downwardStreakCount-1)/2;
                candies += additionalCandies;
                //System.out.println(additionalCandies);
                downwardStreakCount=0;
            }
            else if(arr[i]==arr[i-1]){
                currentMax=1;
                int additionalCandies = downwardStreakCount*(downwardStreakCount-1)/2;
                candies += additionalCandies;
                //System.out.println(additionalCandies);
                downwardStreakCount=0;
            }
            else {
                currentMax=1;
                downwardStreakCount +=1;

            }
            candies = candies + currentMax;
            System.out.println(downwardStreakCount+",i="+i+",candies="+candies);

        }
        int additionalCandies = downwardStreakCount*(downwardStreakCount-1)/2;
        candies += additionalCandies;

        return candies;
    }

    public static void main(String[] args){
        int n=10;
        int[] arr = {4,2,1,6,7,8,9,2,1};
        System.out.println(candies(n,arr));
    }


}

