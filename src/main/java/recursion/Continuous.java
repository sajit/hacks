package recursion;

import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by skunnumkal on 6/29/14.
 */
public class Continuous {

    public static int longestSequence(Set<Integer> set,int currentVal){

        if(set.isEmpty()){
            return 0;
        }
        Integer val = Integer.valueOf(currentVal);
        if(set.contains(val)){
            set.remove(val);
            return 1 + longestSequence(set,currentVal-1);
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args){
        Set<Integer> set = ImmutableSet.of(100,4,200,1,3,2);
        int longest = 0;
        for(Integer anInt : set){
            Set<Integer> aCopy = new HashSet<Integer>(set);
            int current = Continuous.longestSequence(aCopy,anInt.intValue());
            System.out.println("For integer " + anInt.intValue() + " Longest Val " + current);
            if(longest < current){
                longest = current;
            }
        }
        System.out.println(" Longest " + longest);
    }


}
