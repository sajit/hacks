package hackerrank.algo.hourglass.sum;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HourglassSum {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int maxHourglassSum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length-2;i++){
            for(int j=1;j<arr[i].length-1;j++){
                int hourglassSum = arr[i][j-1]+arr[i][j]+arr[i][j+1]+arr[i+1][j]+arr[i+2][j-1]+arr[i+2][j]+arr[i+2][j+1];
                if(hourglassSum> maxHourglassSum){
                    maxHourglassSum = hourglassSum;
                }

            }
        }
        return maxHourglassSum;

    }

    static Map<String,Integer> buildMap(String[] array) {
        Map<String,Integer> stringCountMap = new HashMap<>();
        for(String word : array){
                int charCount = stringCountMap.getOrDefault(word,0);
                stringCountMap.put(word,charCount+1);

        }
        return stringCountMap;
    }
    static void checkMagazine(String[] magazine, String[] note) {
       Map<String,Integer> magazineMap = buildMap(magazine);
       Map<String,Integer> noteMap = buildMap(note);
       String result = "Yes";

       for(String noteWord : noteMap.keySet()) {
           if(magazineMap.getOrDefault(noteWord,0)< noteMap.get(noteWord)) {
               result = "No";
               break;
           }
       }
       System.out.println(result);
    }

    private static final Scanner scanner = new Scanner(System.in);

//    public static void main(String[] args) throws IOException {
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
//
//            int[][] arr = new int[6][6];
//
//            for (int i = 0; i < 6; i++) {
//                String[] arrRowItems = scanner.nextLine().split(" ");
//                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//                for (int j = 0; j < 6; j++) {
//                    int arrItem = Integer.parseInt(arrRowItems[j]);
//                    arr[i][j] = arrItem;
//                }
//            }
//
//            int result = hourglassSum(arr);
//
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
//
//
//        }
//
//        scanner.close();
//    }

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
