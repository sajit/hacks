package sorting;

public class InsertionSort {

    static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        if(arr.length<=1){
            print(arr);
            return;
        }
        int el = arr[arr.length-1];
        int i= arr.length-2;
        while(i>=0 && el<arr[i]){
            arr[i+1]=arr[i];
            print(arr);
            i--;
        }
        arr[i+1]=el;
        print(arr);
    }

    public static void main(String[] args){
        insertionSort1(2,new int[]{5,2});
    }
}
