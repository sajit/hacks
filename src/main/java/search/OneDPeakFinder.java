package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OneDPeakFinder {

    public static  Integer findAPeakV1(Integer[] arr) {
        for(int i=1;i<arr.length;i++) {
                boolean leftCheck = arr[i]>arr[i-1];
                boolean rightCheck = (i<arr.length-1)?arr[i]>arr[i+1]:true;
                if( leftCheck && rightCheck){
                    return i;
                }
        }
        return null;
    }

    public static Integer findAPeakV2(Integer[] arr,int startIdx,int endIdx) {

        if(endIdx<=0) {
            return null;
        }

        if(startIdx==arr.length-1){
            return arr[arr.length-1] > arr[arr.length-2]?arr.length-1:null;
        }
        int i = (startIdx+endIdx)/2;
        boolean leftCheck = false;
        if(i>0){
            if(arr[i-1] > arr[i]){
                return findAPeakV2(arr,startIdx,i-1);
            }
            else
                leftCheck = true;
        }
        boolean rightCheck = false;
        if(i<arr.length-1){
            if(arr[i+1]>arr[i]){
                return findAPeakV2(arr,i+1,endIdx);
            }
            else
                rightCheck = true;
        }

        return (leftCheck && rightCheck)?i : null;
    }

    public static void printArea(Integer idx,Integer[]arr) {
        if(idx == null){
            return;
        }
        System.out.print("Idx="+idx+ " ");
        StringBuilder line = new StringBuilder();
        if(idx>0) {
            line.append(arr[idx-1]+",");
        }
        line.append(arr[idx]);
        if(idx<arr.length-1){
            line.append(","+arr[idx+1]);
        }
        System.out.println(line.toString());
    }


    public static void main(String[] args) {
        int x = 10_000_000;
        List<Integer> arrList = new ArrayList<>();
        for(int i=0;i<x;i++) {
            arrList.add(i);
        }
        Collections.shuffle(arrList);
        Integer[] arr = new Integer[x];
        arr = arrList.toArray(arr);
        long startTime = System.currentTimeMillis();
        printArea(findAPeakV1(arr),arr);
        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime-startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        printArea(findAPeakV2(arr,0,arr.length-1),arr);
        endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime-startTime) + " milliseconds");
        
    }
}
