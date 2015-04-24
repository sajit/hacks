package temp;

import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * Created by sajit on 2/21/15.
 */
public class SansaXor {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int i=0;i<cases;i++){
            int size = scanner.nextInt();
            int[] arr = new int[size];
            for(int j=0;j<size;j++){
                arr[j] = scanner.nextInt();

            }
            Integer[] intArr = new Integer[arr.length];
            for(int j=0;j<arr.length;j++){
                intArr[j] = arr[j];
            }
            List<Integer> arrs = Arrays.asList(intArr);
            subsets(arrs);
            System.out.println("*****");
            printSet(result);
        }

    }

    private static void printSet(Set<Set<Integer>> sets) {
        for(Set<Integer> aSet : sets){
            for(Integer x : aSet){
                System.out.print(x + ",");
            }
            System.out.println();
        }
    }

    static Set<Set<Integer>> result = new HashSet<>();
    private static void subsets(List<Integer> arrs) {

        //System.out.println(arrs);
        result.add(new HashSet<>(arrs));
        for(int i=0;i<arrs.size();i++){
            List<Integer> prefix = arrs.subList(0,i);
            List<Integer> suffix = arrs.subList(i+1, arrs.size());
            //System.out.println("Prefix " + prefix);
            //System.out.println("Suffx" + suffix);
            subsets(prefix);
            subsets(suffix);
        }


    }
}
