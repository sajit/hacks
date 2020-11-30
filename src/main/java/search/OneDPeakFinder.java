package search;

public class OneDPeakFinder {

    public static  Integer findAPeakV1(Integer[] arr) {
        for(int i=1;i<arr.length-1;i++) {
                if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                    return i;
                }
        }
        return arr[arr.length-1] > arr[arr.length-2]?arr.length-1:null;
    }

    public static Integer findAPeakV2(Integer[] arr,int startIdx,int endIdx) {

        if(startIdx>=arr.length || endIdx<0){
            return null;
        }
        if(startIdx==arr.length-1){
            return arr[arr.length-1] > arr[arr.length-2]?arr.length-1:null;
        }
        int i = (startIdx+endIdx)/2;
        if(i>0 && arr[i-1]> arr[i]) {
            return findAPeakV2(arr,startIdx,i-1);
        }
        else if(i<arr.length-1 && arr[i+1]>arr[i]) {
            return findAPeakV2(arr,i+1,endIdx);
        }
        else
            return null;
    }


    public static void main(String[] args) {
        int x = 10_000_000;
        Integer[] arr =new Integer[x];
        for(int i=0;i<arr.length;i++) {
            arr[i]=-i;
        }
        long startTime = System.currentTimeMillis();
        System.out.println("peak index="+ findAPeakV1(arr));
        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime-startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        System.out.println("peak index="+ findAPeakV2(arr,0,arr.length-1));
        endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime-startTime) + " milliseconds");
        
    }
}
