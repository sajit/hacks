package data.structures.hashing;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, TreeSet<Long>> valCountMap = new HashMap<>();
        for (int i=0;i<arr.size();i++) {

            Long key = arr.get(i);
            TreeSet<Long> indices = valCountMap.getOrDefault(key,new TreeSet<>());


            indices.add(Long.valueOf(i));
            valCountMap.put(key, indices);
        }

        long tripletCounts = 0;


        for(long key : valCountMap.keySet()) {


            if(valCountMap.containsKey(key*r) && valCountMap.containsKey(key*r*r)) {
                TreeSet<Long> indices = valCountMap.get(key);
                for(long index : indices){
                    TreeSet<Long> firstMulIndixes = valCountMap.get(key*r);

                    long count1 = firstMulIndixes.tailSet(index).size();
                    TreeSet<Long> secondMulIndixes = valCountMap.get(key*r*r);
                    long count2 = secondMulIndixes.tailSet(index).size();
                    tripletCounts += count1*count2;
                }



            }

        }
        return tripletCounts;

    }
    public static void main(String[] args) {
        int[] intArray = {1,2,2,4};
        long[] vals = Arrays.stream(intArray).mapToLong(i -> i).toArray();
        List<Long> Longs = new ArrayList<>();
        for(long val : vals){
            Longs.add(val);
        }
        System.out.println(countTriplets(Longs,2));
        intArray = new int[]{1,3,9,9,27,81};
        vals = Arrays.stream(intArray).mapToLong(i -> i).toArray();
        Longs = new ArrayList<>();
        for(long val : vals){
            Longs.add(val);
        }
        System.out.println(countTriplets(Longs,3));

        intArray = new int[] {1,5,5,25,125};
        vals = Arrays.stream(intArray).mapToLong(i -> i).toArray();
        Longs = new ArrayList<>();
        for(long val : vals){
            Longs.add(val);
        }
        System.out.println(countTriplets(Longs,5));

        intArray = new int[] {1,2,1,2,4};
        vals = Arrays.stream(intArray).mapToLong(i -> i).toArray();
        Longs = new ArrayList<>();
        for(long val : vals){
            Longs.add(val);
        }
        System.out.println(countTriplets(Longs,2));


    }
}
