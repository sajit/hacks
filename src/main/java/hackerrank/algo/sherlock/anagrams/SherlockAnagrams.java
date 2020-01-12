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

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stackChar = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c=='(' || c =='{' || c == '['){
                stackChar.push(c);
            }
            else {
                try {
                    char chTop = stackChar.pop();
                    if(!isComplement(c,chTop)){
                        return "NO";
                    }
                } catch (EmptyStackException ese) {
                    return "NO";
                }
            }
        }
        if(stackChar.isEmpty()){
            return "YES";
        }
        else
            return "NO";
    }

    static boolean isComplement(char c, char chTop) {
        if(c==')'){
            return chTop=='(';
        }
        else if(c=='}') {
            return chTop == '{';
        }
        else if(c==']') {
            return  chTop == '[';
        }
        else
            return false;
    }

    static int maxSubsetSum(int[] arr) {
        int[] maxSoFar = new int[arr.length];
        maxSoFar[0]=arr[0];
        int globalMax = maxSoFar[0];
        if(arr.length>1){
            maxSoFar[1]=Math.max(maxSoFar[0],arr[1]);
            if(maxSoFar[1]>globalMax){
                globalMax = maxSoFar[1];
            }
        }
        for(int i=2;i<arr.length;i++){

            maxSoFar[i]= Math.max(arr[i],Math.max(globalMax,arr[i]+maxSoFar[i-2]));
            if(maxSoFar[i]>globalMax){
                globalMax = maxSoFar[i];
            }

        }
        return  globalMax;
    }

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        if(s1.isEmpty()|| s2.isEmpty()){
            return 0;
        }
        int maxSize=0;
        for(int i=0;i<s1.length();i++){
            int size=0;
            for(int j=0;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    size = 1 + commonChild(s1.substring(i+1),s2.substring(j+1));
                    if(size>maxSize){
                        maxSize = size;
                    }
                }
            }
        }
        return maxSize;

    }

    static int commonChild_V2(String s1, String s2) {
        int[][] lcs = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    lcs[i][j]=Math.max(Math.max(lcs[i-1][j],lcs[i][j-1]),lcs[i-1][j-1]+1);
                }
                else
                    lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
            }
        }
        return lcs[s1.length()][s2.length()];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.print(commonChild("harry","sally"));
        System.out.print(commonChild("abcd","abdc"));
        System.out.print(commonChild("aa","bb"));
        System.out.print(commonChild("SHINCHAN","NOHARAAA"));
        System.out.println(commonChild("ABCDEF","FBDAMN"));
        System.out.print(commonChild_V2("harry","sally"));
        System.out.print(commonChild_V2("abcd","abdc"));
        System.out.print(commonChild_V2("aa","bb"));
        System.out.print(commonChild_V2("SHINCHAN","NOHARAAA"));
        System.out.print(commonChild_V2("ABCDEF","FBDAMN"));
//        System.out.println(maxSubsetSum(new int[]{-2,1,3,-4,5}));
//        System.out.println(maxSubsetSum(new int[]{3,7,4,6,5}));
//        System.out.println(maxSubsetSum(new int[]{2,1,5,8,4}));
//        System.out.println(maxSubsetSum(new int[]{3,5,-7,8,10}));
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
//
//            int q = scanner.nextInt();
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int qItr = 0; qItr < q; qItr++) {
//                String s = scanner.nextLine();
//
//                int result = sherlockAndAnagrams(s);
//
//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
//            }
//
//
//        }
//
//        scanner.close();
    }
}
