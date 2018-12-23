package data.structures.arrays;

import java.io.*;
import java.util.*;

import static java.lang.Math.max;

public class NewYearChaos {
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int minCount=0;
        for(int i=q.length-1;i>=0;i--){
            if(q[i]-i-1>2){
                System.out.println("Too chaotic");
                return;
            }
            for (int j = max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) minCount++;


        }
        System.out.println(minCount);
    }

    static void minimumBribes2(int[] q) {

        int minCount=0;
        Set<Integer> valuesSeen = new HashSet<>();
        for(int i=0;i<q.length-1;i++){
            valuesSeen.add(q[i]);
            if(q[i]-i-1>2){
                System.out.println("Too chaotic");
                return;
            }
            final int currentValue = q[i];
            //int numLesser=q[i]-1;//number of positions that are lesser than q[i]
            long valuesLessThanICount = valuesSeen.stream().filter(value -> value<currentValue).count();

            minCount +=q[i]-1-valuesLessThanICount;

        }
        System.out.println(minCount);
    }

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        long[] arr = new long[n];
        long maxVal=0;
        for(int i=0;i<queries.length;i++){
            int a = queries[i][0]-1;
            int b = queries[i][1]-1;
            int k = queries[i][2];
            for(int j=a;j<=b;j++){
                arr[j] += k;
                if(maxVal<arr[j]){
                    maxVal = arr[j];
                }
            }
        }
        return maxVal;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //int[][] queries1 = {{1,2,100},{2,5,100},{3,4,100}};
        //System.out.println(arrayManipulation(5,queries1));
        //int[][] queries2 = {{1,5,3}, {4,8,7}, {6,9,1}};
        //System.out.println(arrayManipulation(10,queries2));
        minimumBribes(new int[] {2,1,5,3,4});
        minimumBribes(new int[] {2,5,1,3,4});
        minimumBribes(new int[] {5,1,2,3,7,8,6,4});
        minimumBribes(new int[] {1,2,5,3,7,8,6,4});
        minimumBribes(new int[] {1,2,5,3,4,7,8,6});
//        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int tItr = 0; tItr < t; tItr++) {
//            int n = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            int[] q = new int[n];
//
//            String[] qItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int i = 0; i < n; i++) {
//                int qItem = Integer.parseInt(qItems[i]);
//                q[i] = qItem;
//            }
//
//            minimumBribes(q);
//        }
//
//        scanner.close();
    }
}
