package greedy;

import java.util.Arrays;

public class MarcCakeWalk {
    static long marcsCakewalk(int[] calorie) {

        Arrays.sort(calorie);
        int minMiles = 0;
        for(int i=0;i<calorie.length;i++){
            minMiles += calorie[i]*(int)Math.pow(2,calorie.length-1-i);
        }
        return minMiles;
    }

    public static void main(String[] args){
        System.out.println(marcsCakewalk(new int[]{1,3,2}));
    }
}
