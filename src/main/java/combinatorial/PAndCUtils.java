package combinatorial;

import com.google.common.collect.ImmutableList;

import java.util.*;

/**
 * Created by sajit on 7/18/14.
 */
public class PAndCUtils {

    private static int duplicateCount = 0;
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
        if(intermediate.isEmpty()){
            return ImmutableList.of(String.valueOf(ch));
        }
        for(String subString : intermediate){
            updatedResult.addAll(insertIntoEveryPosition(subString,ch));
        }
        return updatedResult;
    }

    private static List<String> insertIntoEveryPosition(String targetString, char insertChar) {
        List<String> gens = new ArrayList<String>();
        for(int i=0;i<targetString.length();i++){
          //gens.add();
        }
        return gens;

    }

    public static void main(String[] args){
        Set<String> result = PAndCUtils.combos("abc");
        for(String a : result){
            System.out.print( " " + a);
        }
        System.out.println("# of combinations = " + result.size());
        System.out.println("++++++++++++++++++++++++++");

        System.out.println("# of times duplicates were attempted to be added " + duplicateCount);
    }
}
