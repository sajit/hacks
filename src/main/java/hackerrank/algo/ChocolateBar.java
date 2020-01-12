package hackerrank.algo;

import com.google.common.collect.ImmutableSet;

import java.util.*;
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
        System.out.println(dayOfYear(2019));
        System.out.println(dayOfYear(2017));
        System.out.println(dayOfYear(2016));
        System.out.println(dayOfYear(1800));
        System.out.println(dayOfYear(1918));

    }

    // Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {

        int pairsCount = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if((ar[i]+ar[j])%k==0){
                    pairsCount++;
                }
            }
        }
        return pairsCount;
    }

    static int migratoryBirds(List<Integer> arr) {
        Map<Integer,Integer> counts = new HashMap<>();
        for(int i : arr){
            int count = counts.getOrDefault(i,0);
            count +=1;
            counts.put(i,count);
        }
        Iterator<Integer> keyIterator  = counts.keySet().iterator();
        int minIdx = keyIterator.next();
        int maxVal= counts.get(minIdx);
        while(keyIterator.hasNext()){
            int key = keyIterator.next();
            int count = counts.get(key);
            if(count>maxVal){
                maxVal = count;
                minIdx = key;
            }
            else if(count==maxVal){
                if(key<minIdx){
                    minIdx = key;
                }
            }
        }

        return minIdx;
    }

    static String dayOfYear(int year){
        boolean isLeapYear = false;
        int daysRemaining = 256;
        if(year==1918){
            daysRemaining +=13;

        }else if(year<1918) {
            //julian
            isLeapYear = year%4==0;
        }
        else {
            //gregorian
            isLeapYear = year%400==0 || (year%4==0 && year%100!=0);
        }

        Set<Integer> thirtyoneDayMonths = ImmutableSet.of(1,3,5,7,8,10,12);
        int month = 1;
        while(daysRemaining>0){
            //subtract
            if(thirtyoneDayMonths.contains(month)){
                daysRemaining -= 31;
            }
            else if(month==2){
                daysRemaining -= isLeapYear? 29: 28;
            }
            else {
                daysRemaining -=30;
            }
            month++;
        }
        month-=1;
        //System.out.println(month);
        String monthString = String.valueOf(month);
        if(month<10){
            monthString = String.format("%02d", month);
        }

        //System.out.println(daysRemaining);
        return String.valueOf(30+daysRemaining)+"."+monthString+"."+year;
    }
}
