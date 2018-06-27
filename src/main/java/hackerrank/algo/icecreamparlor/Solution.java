package hackerrank.algo.icecreamparlor;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {
     Map<Integer,Integer> diffIdxMap = new HashMap<>();
     for(int i=0;i<arr.length;i++){
         if(diffIdxMap.keySet().contains(arr[i])){
             return new int[]{diffIdxMap.get(arr[i])+1,i+1};
         }
         diffIdxMap.put(m-arr[i], i);
     }
     throw new IllegalArgumentException("bad_data");
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                int m = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[] arr = new int[n];

                String[] arrItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < n; i++) {
                    int arrItem = Integer.parseInt(arrItems[i]);
                    arr[i] = arrItem;
                }

                int[] result = icecreamParlor(m, arr);

                for (int i = 0; i < result.length; i++) {
                    bufferedWriter.write(String.valueOf(result[i]));

                    if (i != result.length - 1) {
                        bufferedWriter.write(" ");
                    }
                }

                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        }

        scanner.close();
    }
}

