package sorting;

/**
 * Created by skunnumkal on 10/24/14.
 */
public class SortingTypes {


    public static void main(String[] args){
        int[] arr = {4,6,2,12,3};
        quickSort(arr,0,4);
        for(int x : arr){
            System.out.print(" " + x);
        }
    }
    public static void quickSort(int[] arr,int start,int end){
        if(start<end){
            int pivot = partition(arr,start,end);
            quickSort(arr,start,pivot-1);
            quickSort(arr,pivot+1,end);
        }
    }

    private static int partition(int[] arr, int start, int end) {

        int i=start,j=end,pivotval = arr[start];
        while(i<j){
            while(i<=end && arr[i] <= pivotval){
                i++;
            }
            while(j>=start && arr[j] > pivotval){
                j--;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,start,j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
