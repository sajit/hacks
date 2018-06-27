package dp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class EqualDistribution {

    // Complete the equal function below.
    static int equal(int[] arr) {

        printArr(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                return Integer.MAX_VALUE-10;
            }
        }
        if(allEqualArray(arr)){
            return 0;
        }
        final int maxVal = getMax(arr);
        if(maxVal ==-1){
            return Integer.MAX_VALUE-10;
        }

        return Math.min(Math.min(equal(subtract(1,arr,maxVal)),
                                 equal(subtract(3,arr,maxVal))),
                        equal(subtract(5,arr,maxVal)))+1;
    }

    private static void printArr(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }



//    static int equalDP(int[] arr) {
//        int maxVal = getMax(arr);
//        int[][] result = new int[maxVal][3];
//        for(int i=0;i<result.length;i++){
//            for(int j=0;j<result[j].length;j++){
//                int numWaysWith1Minus = equal2(subtract(1,arr,maxVal));
//                int[] subtract3Arr = subtract(3,arr,maxVal);
//                int[] subtract5Arr = subtract(5,arr,maxVal);
//                result[i][j] = Math.min(Math.min(equal2(subtract1Arr),equal2(subtract3Arr)),equal2(subtract5Arr))+1;
//            }
//        }
//
//    }


    private static int[] subtract(int n, int[] ints, int maxVal) {
        int[] newArr = new int[ints.length];
        for(int i=0;i<ints.length;i++){
            if(ints[i]==maxVal){
                newArr[i] = ints[i] - n;
            }
            else {
                newArr[i]= ints[i];
            }
        }
        return newArr;
    }

    private static boolean allEqualArray(int[] ints){
        boolean allEqual = true;
        for(int i=0;i<ints.length-1;i++){
            if(ints[i]!=ints[i+1]){
                allEqual = false;
                break;
            }
        }
        return allEqual;
    }
    /**
     * return
     * @param ints
     * @return -1 if more than one max element
     * idx of maxElement
     */
    private static int getMax(int[] ints) {
        Arrays.sort(ints);
        return (ints[ints.length-1]==ints[ints.length-2])? -1 : ints[ints.length-1];
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = equal(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
