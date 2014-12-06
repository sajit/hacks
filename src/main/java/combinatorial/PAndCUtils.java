package combinatorial;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.*;

/**
 * Created by sajit on 7/18/14.
 */
public class PAndCUtils {

    private static int duplicateCount = 0;


    public static Set<Set<Integer>> intCombos(List<Integer> ints){

        Set<Set<Integer>> resultSet = new HashSet<Set<Integer>>();
        doIntCombos(ints,resultSet);
        return resultSet;
    }

    private static void doIntCombos(List<Integer> integers,Set<Set<Integer>> soFar) {
        soFar.add(new HashSet<Integer>(integers));
        if(integers.size()<=1){
            return;
        }

        for(int i=0;i<integers.size();i++){
            List<Integer> prefix = integers.subList(0,i);
            List<Integer> suffix = integers.subList(i+1,integers.size());
            List<Integer> remaining = new ArrayList<Integer>();
            remaining.addAll(prefix);
            remaining.addAll(suffix);
            
            doIntCombos(remaining,soFar);
        }

        for(Set<Integer> aSet : soFar){
            System.out.print(aSet + " ");
        }
        System.out.println("**" + soFar.size());

    }

    public static Set<String> combos(String x){
        Set<String> resultSet = new HashSet<String>();
        //resultSet.add(x);
        doCombos(x,resultSet);
        return resultSet;
    }

    private static void doCombos(String str, Set<String> soFar) {
        boolean result = soFar.add(str);
        if(!result){
            duplicateCount++;
        }
        for(int i=0;i<str.length();i++){
            String prefix = str.substring(0,i);
            String suffix = str.substring(i+1);
            doCombos(prefix+suffix,soFar);
        }
    }


    public static List<String> nCr(String s,int r){
        Set<String> combos = combos(s);
        Set<String> subset = new HashSet<String>();
        for(String aCombo : combos){
            if(aCombo.length()==r){
                subset.add(aCombo);
            }
        }

        List<String> result = new ArrayList<String>();
        for(String aCombo : subset){
            result.addAll(permutations(aCombo));
        }

        return  result;
    }
    public static List<String> permutations(String x){
        List<String> result = new ArrayList<String>();
        for(int i=0;i<x.length();i++){
            char ch = x.charAt(i);
            result = generatePerms(result,ch);
        }

        return  result;
    }

    private static List<String> generatePerms(List<String> intermediate, char ch) {
        List<String> updatedResult = new ArrayList<String>();
        System.out.println(" Ch = " + ch + ",intermediate " + intermediate);
        if(intermediate.isEmpty()){
            return ImmutableList.of(String.valueOf(ch));
        }
        for(String subString : intermediate){
            updatedResult.addAll(insertIntoEveryPosition(subString,ch));
        }
        System.out.println("After insertions into every position " + updatedResult);
        return updatedResult;
    }

    private static List<String> insertIntoEveryPosition(String targetString, char insertChar) {
        List<String> gens = new ArrayList<String>();
        for(int i=0;i<=targetString.length();i++){
          String prefix = targetString.substring(0,i);
          String suffix = targetString.substring(i);
          gens.add(prefix+insertChar+suffix);
        }
        return gens;

    }

    public static void main(String[] args){


//        List<Integer> ints = ImmutableList.of(1,5,7,3);
//        Set<Set<Integer>> result = PAndCUtils.intCombos(ints);
//
        List<String> result = PAndCUtils.permutations("abc");
        for(String resultIn : result){
            System.out.print(" " + resultIn);
        }
    }
}
