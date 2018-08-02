package hackerrank.algo.sherlock.anagrams;

import java.io.*;
import java.util.*;

public class SherlockAnagrams {
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int total=0;
        for(int size=1;size<s.length();size++){
            Map<String,Integer> strCountMap = buildMap(s,size);
            for(Integer count : strCountMap.values()) {
                total += (count*(count-1))/2;
            }

        }
        return total;

    }

    static Map<String,Integer> buildMap(String s, int size) {
        Map<String,Integer> strCountMap = new HashMap<>();
        //char[] chars = s.toCharArray();
        for(int i=0;i<=s.length()-size;i++){
            char[] charArray = s.substring(i,i+size).toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            int count = strCountMap.getOrDefault(key,0);
            strCountMap.put(key,count+1);
        }
        return  strCountMap;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                String s = scanner.nextLine();

                int result = sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            }


        }

        scanner.close();
    }
}
