package temp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sajit on 2/18/15.
 * https://www.hackerrank.com/challenges/almost-equal-advanced
 */
public class AlmostEqual {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int size = scanner.nextInt();
        int k = scanner.nextInt();
        int[] h = new int[size];
        for(int i=0;i<size;i++){
            h[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        for(int i=0;i<q;i++){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int[] dest = new int[r-l+1];
            System.arraycopy(h,l,dest,0,r-l+1);
            //LibraryQuery.printArray(dest);
            Arrays.sort(dest);
            findCombos(dest, k);
        }
    }

    public static void findCombos(int[] inputArr, int k) {
        int count=0;
        //LibraryQuery.printArray(inputArr);
        for(int i=0;i<inputArr.length;i++){
            int size = findMaxValueWithinRange(inputArr, i + 1, inputArr[i] + k);
            //System.out.println("Size =" + size + " starting with " + inputArr[i]);
            int pc = calculatePairs(size);
            //System.out.println("Pair Count = " + pc);
                count +=pc ;
            }

        System.out.println(count);


    }

    public static int calculatePairs(int n) {
        if(n < 01){
            return 0;
        }
        return n-1;
    }

    public static int performBS(int[] inputArr, int startIdx, int endIdx, int compareVal,int compareIdx) {
        //System.out.println("StartIdx="+startIdx+" : EndIdx="+endIdx);
        if(startIdx <= endIdx){
            int midIdx = (startIdx + endIdx)/2;
            //System.out.println("MidIdx="+midIdx+ " Val " + inputArr[midIdx]);
            if(inputArr[midIdx]== compareVal){
                return midIdx-compareIdx; //review this
            }
            else if(inputArr[midIdx]> compareVal){
                return performBS(inputArr,startIdx,midIdx-1,compareVal,compareIdx);
            }
            else{
                return performBS(inputArr,midIdx+1,endIdx,compareVal,compareIdx);
            }
        }
        else{
            return endIdx-compareIdx+1;
        }

    }

    public static int findMaxValueWithinRange(int[] inputArr,int startIdx,int compareVal){
        int i=startIdx;
        for(;i<inputArr.length && inputArr[i]<=compareVal;i++);
        return i-startIdx+1;
    }
}
