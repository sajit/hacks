package recursion;

/**
 * Created by sajit on 4/27/15.
 */
public class MaximumMontonic {

    /**
     * Return the maximum value in a monotonically increasing array. Ie an array with only one maximum value
     * @param arr
     * @return -1 if not found
     */
    public static int maxima(int[] arr){

        return doFindMaxima(arr,0,arr.length-1);
    }

    private static int doFindMaxima(int[] arr, int start, int end) {
        if(end-start>=2){
            int mid = (start + end)/2;
            int prev = mid - 1;
            int next = mid + 1;
            if(arr[mid] > arr[prev]) {
                if(arr[mid] > arr[next]){
                    return arr[mid];
                }
                else{ //arr[mid] < arr[next] on an increasing part of the array..need to move right
                     return doFindMaxima(arr,mid,end);
                }
            } else { //arr[mid] < arr[prev]
                return doFindMaxima(arr,start,mid);

            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {4,6,17,12,8,5,-7}; //{4,5,17,3,1,0,-1,-4};
        System.out.println(MaximumMontonic.maxima(arr));
    }
}