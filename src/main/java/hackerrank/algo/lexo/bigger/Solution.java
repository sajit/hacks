package hackerrank.algo.lexo.bigger;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


//    private static long findSum(long[][] array, int idx,int x,boolean isPenultimateArray) {
//        int sum=0;
//        if(isPenultimateArray && x==idx){
//            return sum;
//        }
//        for(int i=0;i<array.length;i++){
//            if(idx!=i){
//                sum+=array[i];
//            }
//        }
//        return sum;
//    }



    // Complete the countArray function below.
    public static long countArray(int n, int k, int x) {
        long[][] sum = new long[k][n];
        sum[0][0]=1;
        long prevColSum=1;
        long currentColSum;
        for(int j=1;j<sum[0].length-1;j++){
            currentColSum=0;
            for(int i=0;i<sum.length;i++){
                if(j==(sum[0].length-2) && i==x-1){
                    sum[i][j]=0;
                }
                else {
                    sum[i][j] = prevColSum - sum[i][j - 1];
                }
                currentColSum += sum[i][j];
            }
            prevColSum=currentColSum;
        }

        for(int i=0;i<sum.length;i++){
            for(int j=0;j<sum[i].length;j++){
                System.out.print(sum[i][j]+ " ");
            }
            System.out.println();
        }
        return prevColSum;

    }


    // Complete the cost function below.
    public static int cost(int[] B) {
        //return recursiveCost(B,0,new ArrayList<Integer>());
        int D = Arrays.stream(B).max().getAsInt();
        int[][] maxCostArray = new int[D+1][B.length];

        for(int j=1;j<maxCostArray[0].length;j++){
            for(int i=1;i<=B[j];i++){
                int maxSum=0;
                for(int k=1;k<=B[j-1];k++){
                    int sum = Math.abs(k-i)+maxCostArray[k][j-1];
                    if(sum>maxSum){
                        maxSum = sum;
                    }
                }
                maxCostArray[i][j]=maxSum;
            }
        }
        for(int i=0;i<maxCostArray.length;i++){
            for(int j=0;j<maxCostArray[i].length;j++){
                System.out.print(maxCostArray[i][j]+ " ");
            }
            System.out.println();
        }
        int maxSum=maxCostArray[1][maxCostArray[0].length-1];
        for(int k=1;k<=maxCostArray.length-1;k++){
            if(maxCostArray[k][maxCostArray[0].length-1]>maxSum) {
                maxSum = maxCostArray[k][maxCostArray[0].length-1];
            }
        }
        return maxSum;
    }

    static String gridChallenge(String[] grid) {


        char[][] gridArr  = new char[grid.length][grid[0].length()];
        for(int i=0;i<grid.length;i++){
            gridArr[i] = grid[i].toCharArray();
            Arrays.sort(gridArr[i]);
        }
        for(int j=0;j<gridArr[0].length;j++){
            for(int i=1;i<gridArr.length;i++){
                if(gridArr[i][j]<gridArr[i-1][j]){
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static int recursiveCost(int[] B, int idx, ArrayList<Integer> soFar) {
        if(idx>=B.length){
            return diff(soFar);
        }
        int maxSum=0;
        for(int a=1;a<=B[idx];a++){
            soFar.add(a);
            int sum = recursiveCost(B,idx+1,soFar);
            if(sum>maxSum){
                maxSum=sum;
            }
            soFar.remove(soFar.size()-1);
        }
        return maxSum;
    }

    private static int diff(ArrayList<Integer> soFar) {
        int sum=0;
        for(int i=0;i<soFar.size()-1;i++){
            sum+=Math.abs(soFar.get(i+1)-soFar.get(i));
        }
        return sum;
    }


    // Complete the biggerIsGreater function below.
    public static String biggerIsGreater(String w) {
        int suffixStartIdx = findLongestNonIncreasingSuffix(w);
        int pivotIdx = suffixStartIdx-1;
        if(pivotIdx<0){
            return "no answer";
        }
        else {
            int swapElementIdx = findSwapElement(w.charAt(pivotIdx),w);
            String prefix = w.substring(0,pivotIdx);
            char ch = w.charAt(swapElementIdx);
            StringBuilder sb = new StringBuilder(w);
            sb.deleteCharAt(swapElementIdx);
            String suffix = sb.toString().substring(pivotIdx);
            String modifiedString = prefix+ch+sortString(suffix);
            //System.out.println(modifiedString);
            return modifiedString;

        }


    }

    public  static int findSwapElement(char c, String str) {
        int idx = str.length()-1;
        while(str.charAt(idx)<=c){
            idx--;
        }
        return idx;
    }


    public static String sortString(String inputString)
    {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }

    static int findLongestNonIncreasingSuffix(String str){
        int suffixStart = str.length()-1;
        while(suffixStart>0 && str.charAt(suffixStart-1)>=str.charAt(suffixStart)){
            suffixStart--;
        }
        return suffixStart;
    }


    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String line;

        try {

            try (BufferedReader bufferedInputReader = new BufferedReader(new FileReader("/Users/sajit.kunnumkal/Desktop/input02.txt"))) {
                try (BufferedReader bufferedOutputReader = new BufferedReader(new FileReader("/Users/sajit.kunnumkal/Desktop/output02.txt"))) {

                    int numLines = Integer.valueOf(bufferedInputReader.readLine());

                    while ((line = bufferedInputReader.readLine()) != null) {
                        /**
                         Your implementation
                         **/
                        String outputline = bufferedOutputReader.readLine();
                        String fnOutput = biggerIsGreater(line);
                        if (!outputline.equals(fnOutput)) {
                            System.out.println("for input " + line + " expected " + outputline + " ..got = " + fnOutput);
                            System.exit(0);
                        }
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
//
//            int T = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int TItr = 0; TItr < T; TItr++) {
//                String w = scanner.nextLine();
//
//                String result = biggerIsGreater(w);
//
//                bufferedWriter.write(result);
//                bufferedWriter.newLine();
//            }
//
//            bufferedWriter.close();
//        }
//
//        scanner.close();
    }
}