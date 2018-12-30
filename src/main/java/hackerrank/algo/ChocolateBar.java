package hackerrank.algo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChocolateBar {

    static int birthday(List<Integer> s, int d, int m) {
        int sum=0;
        int numWays = 0;
        int i=0;
        for(i=0;i<m&& i<s.size();i++){
            sum += s.get(i);
        }
        if(sum==d){
            numWays++;
        }
        while(i<s.size()){
            sum = sum - s.get(i-m);
            sum = sum + s.get(i);
            if(sum==d){
                numWays++;
            }
            i++;
        }

        return numWays;
    }

    public static void main(String[] args) {
        List<Integer> bar = Arrays.asList(1,2,2,1,3,2);
        System.out.println(birthday(bar,4,2));
        bar = Arrays.asList(1,2,1,3,2);
        System.out.println(birthday(bar,3,2));
        System.out.println(birthday(Arrays.asList(1,1,1,1,1,1),3,2));
        System.out.println(birthday(Arrays.asList(4),4,1));
        bar = Arrays.stream("3 5 4 1 2 5 3 4 3 2 1 1 2 4 2 3 4 5 3 1 2 5 4 5 4 1 1 5 3 1 4 5 2 3 2 5 2 5 2 2 1 5 3 2 5 1 2 4 3 1 5 1 3 3 5".split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        System.out.println(bar.size());
        System.out.println(birthday(bar,18,6));
    }
}
