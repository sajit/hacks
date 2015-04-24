package temp;

import data.structures.lists.ListNode;

import java.util.Scanner;

/**
 * Created by sajit on 2/14/15.
 */
public class LibraryQuery {



    public static  void main(String[] args){

      int[] inp = {1,2,3,6,7,9,13};
        replaceAndPlace(inp,4,-8);

        printArray(inp);
    }

    private static void replaceAndPlace(int[] arr, int index, int value) {
        assert index < arr.length;
        int current = arr[index];
        arr[index] = value;
        if(value<current){
            //bubbledown
            int i = index;
            while(i>=1 && arr[i-1]>arr[i]){
                swap(arr,i,i-1);
                i -= 1;
            }
        }
        else{
            int i = index;
            while(i<arr.length-1 && arr[i+1]<arr[i]){
                swap(arr,i,i+1);
                i += 1;
            }

        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {

        for(int i : arr){
            System.out.print(" " + i);
        }
        System.out.println();
    }
}