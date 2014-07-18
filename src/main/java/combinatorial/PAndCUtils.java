package combinatorial;

import java.util.HashSet;
import java.util.Set;

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
