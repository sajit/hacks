package hackerrank.algo.bear.steady;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

public class GeneFinder {

    static int steadyGene(String gene) {

        int n  = gene.length();
        Map<Character,Integer> charCount = new HashMap<>();
        for(char c : gene.toCharArray()) {
            int count = charCount.getOrDefault(c,0);
            charCount.put(c,count+1);
        }
        Map<Character,Integer> subMap = new HashMap<>();
        int replaceStringLength = 0;
        for(Character ch : charCount.keySet()) {
            int v = charCount.get(ch);
            int diff = v-(n/4);
            if(diff>0) {
                subMap.put(ch,diff);
                replaceStringLength += diff;
            }
        }
        if(replaceStringLength==0){
            return 0;
        }
        int shortestGene = gene.length();
        for(int i=0;i<gene.length()-replaceStringLength;i++){

            Map<Character,Integer> tempMap = new HashMap(subMap);
            for(int j=i;j<gene.length() && (j-i+1<shortestGene);j++){
                Character key = gene.charAt(j);
                Integer vals = tempMap.get(key);
                if(vals!=null){
                    if(vals>1)
                        tempMap.put(key,vals-1);
                    else
                        tempMap.remove(key);
                }
                if(tempMap.isEmpty()) {
                    if((j-i+1)<shortestGene){
                        shortestGene = j-i+1;
                    }
                    break;
                }

            }
        }
        return shortestGene;

    }

    // Complete the stringConstruction function below.
    static int stringConstruction(String s) {
        int cost=0;
        Set<Character> pChars = new HashSet<>();
        for(char ch : s.toCharArray()){
            if(!pChars.contains(ch)){
                cost+=1;
                pChars.add(ch);
            }
        }
        return cost;
    }

    static int pairs(int k, int[] arr) {
        int count=0;
        Set<Integer> diffSet = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            diffSet.add(Math.abs(k-arr[i]));
        }
        for(int i=0;i<arr.length;i++){
            if(diffSet.contains(arr[i])){
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args) {

        System.out.println(pairs(Integer.MAX_VALUE-1,new int[]{Integer.MAX_VALUE,4,6,1}));
//        System.out.println(steadyGene("GAAATAAA"));
//        System.out.println(stringConstruction("abcd"));
//        System.out.println(stringConstruction("abab"));
//        System.out.println(stringConstruction("abca"));

    }
}
