package hackerrank.algo.nondivisiablesubset;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class Solution {


    public static Set<Integer> maxSet(int k,Set<Integer> sSet) {
        List<Set<Integer>> outList = new ArrayList<>();
        Integer oustedNum = breakSet(k, sSet);
        while(oustedNum != null){
            boolean mergeable = false;
            for(int i=0;i<outList.size();i++){
                if(canMerge(oustedNum,outList.get(i),k)) {
                    outList.get(i).add(oustedNum);
                    Collections.sort(outList, (o1, o2) -> o2.size()-o1.size());

                    mergeable = true;
                    break;
                }
            }
            if(!mergeable){
                outList.add(new HashSet<>(Arrays.asList(oustedNum)));
            }
            oustedNum = breakSet(k,sSet);
        }
        return (outList.isEmpty()||sSet.size()>outList.get(0).size())?sSet:outList.get(0);


    }

    private static boolean canMerge(Integer oustedNum, Set<Integer> integers,int k) {
        Iterator<Integer> setItr = integers.iterator();
        while(setItr.hasNext()){
            Integer x = setItr.next();
            if((oustedNum+x)%k==0) return false;
        }
        return true;
    }



    public static Integer breakSet(int k,Set<Integer> set) {
        Set<Integer> remainders = new HashSet<>();
        if(set.size()<2) return null;

        Iterator<Integer> setItr = set.iterator();

        Integer duplicate = null;
        while(setItr.hasNext()){
            Integer element = setItr.next();
            int remainder = element%k;
            if(remainders.contains(k-remainder)) {
                duplicate = element;
                break;
            }
            remainders.add(element);

        }
        if(duplicate!=null){
            set.remove(duplicate);

        }
        return duplicate;
    }
//    public static boolean isDivisible(int k,int[] elements) {
//        Set<Integer> remainders = new HashSet<>();
//        for(int i=0;i<elements.length;i++){
//            int remainder = elements[i]%k;
//            if(remainders.contains(k-remainder)){
//                return true;
//            }
//            remainders.add(remainder);
//        }
//        return false;
//    }
//    // Complete the nonDivisibleSubset function below.
//    public static int dononDivisibleSubset(int k, int[] S, int maxSize) {
//        if(maxSize>S.length){
//            return maxSize;
//        }
//        if(S.length<2) return 0;
//        if(!isDivisible(k,S)){
//            return S.length;
//        }
//        else {
//            for(int i=0;i<S.length;i++){
//                int[] subArray = getArrayWithout(S,i);
//                int size = dononDivisibleSubset(k,subArray,maxSize);
//                if(size>maxSize){
//                    maxSize  = size;
//                }
//
//
//            }
//            return maxSize;
//        }
//    }

//    public static int[] getArrayWithout(int[] s, int elIdx) {
//        int[] subArray = new int[s.length-1];
//        for(int i=0;i<subArray.length;i++){
//            if(i>=elIdx){
//                subArray[i]=s[i+1];
//            }
//            else {
//                subArray[i] = s[i];
//            }
//
//        }
//        return subArray;
//    }

    public static int nonDivisibleSubset(int k, int[] S) {
        Integer[] sInt = Arrays.stream(S).boxed().toArray(Integer[]::new);
        Set<Integer> sSet = new HashSet<Integer>(Arrays.asList(sInt));
        Set<Integer> maxSubSet = maxSet(k,sSet);
        return maxSubSet.size();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] S = new int[n];

            String[] SItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int SItem = Integer.parseInt(SItems[i]);
                S[i] = SItem;
            }

            int result = nonDivisibleSubset(k, S);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();
        }

        scanner.close();
    }

}
