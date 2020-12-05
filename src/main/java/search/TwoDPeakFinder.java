package search;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoDPeakFinder {

    public static Pair<Integer,Integer> find2DPeakV1(Integer[][] arr) {
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr.length;j++){
                boolean leftTest = arr[i][j] > arr[i][j-1];
                boolean topTest = arr[i][j] > arr[i-1][j];
                boolean rightTest = (j<arr.length-1)?arr[i][j] > arr[i][j+1] : true;
                boolean downTest = (i<arr.length-1)?arr[i][j] > arr[i+1][j] : true;
                if(leftTest && topTest && rightTest && downTest){
                    return new ImmutablePair<>(i,j);
                }
            }
        }
        return null;
    }

    /**
     *
     Consider mid column and find maximum element in it.
     Let index of mid column be ‘mid’, value of maximum element in mid column be ‘max’ and maximum element be at ‘mat[max_index][mid]’.
     If max >= A[index][mid-1] & max >= A[index][pick+1], max is a peak, return max.
     If max < mat[max_index][mid-1], recur for left half of matrix.
     If max < mat[max_index][mid+1], recur for right half of matrix.

     * @param arr
     * @param leftCol
     * @param rightCol
     * @return
     */
    public static Pair<Integer,Integer> find2DPeakV2(Integer[][] arr,int leftCol,int rightCol) {
        if(leftCol>=rightCol){
            return new ImmutablePair<>(globalMaxIndex(arr,leftCol),leftCol);
        }
        int midCol = (leftCol+rightCol)/2;
        int max_index = globalMaxIndex(arr,midCol);
        int max = arr[max_index][midCol];
        boolean leftCheck  = (midCol>0)? max > arr[max_index][midCol-1]:false;
        boolean rightCheck = (midCol>=arr.length-1)?true: max > arr[max_index][midCol+1];
        if(leftCheck && rightCheck){
            return new ImmutablePair<>(max_index,midCol);
        }
        if(max < arr[max_index][midCol-1]) {
            return find2DPeakV2(arr,leftCol,midCol-1);
        }
        if(max < arr[max_index][midCol+1]) {
            return find2DPeakV2(arr,midCol+1,rightCol);
        }
        return null;
    }

    private static Integer globalMaxIndex(Integer[][] arr, int colIndex) {
        int max = arr[0][colIndex];
        int rowIndex = 0;
        for(int j=1;j<arr.length;j++){
            if(arr[j][colIndex]>max){
                rowIndex = j;
                max = arr[j][colIndex];
            }
        }
        return rowIndex;
    }

    public static void printArea(Pair<Integer,Integer> rowColPair,Integer[][] arr){
        if(rowColPair == null) {
            return;
        }
        Integer row = rowColPair.getLeft();
        Integer col = rowColPair.getRight();
        if(row == null || col == null) {
            return;
        }
        System.out.println("Row="+row+",Col="+col);
        StringBuilder stringBuilder = new StringBuilder();
        if(row-1>=0){
            stringBuilder.append(arr[row-1][col]);
            stringBuilder.append("\n");
        }
        if(col-1>=0){
            stringBuilder.append(arr[row][col-1]+" ");
        }
        stringBuilder.append(arr[row][col]+" ");
        if(col+1<arr.length){
            stringBuilder.append(arr[row][col+1]);
        }
        stringBuilder.append("\n");
        if(row+1<arr.length){
            stringBuilder.append(arr[row+1][col]);
        }
        System.out.println(stringBuilder.toString());
    }
    public static void main(String[] args) {
        int x = 10_000;

        Integer[][] twoDArray = new Integer[x][x];
        for(int i=0;i<twoDArray.length;i++){
            for(int j=0;j<twoDArray.length;j++){

                twoDArray[i][j]=i+j;
            }
            //shuffle row i
            List<Integer> sortedRow = Arrays.asList(twoDArray[i]);
            Collections.shuffle(sortedRow);
            for(int j=0;j< twoDArray.length;j++){
                twoDArray[i][j] = sortedRow.get(j);
            }
        }

        long startTime = System.currentTimeMillis();
        printArea(find2DPeakV1(twoDArray),twoDArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime-startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        printArea(find2DPeakV2(twoDArray,0,twoDArray.length-1),twoDArray);
        endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime-startTime) + " milliseconds");

    }
}
