package recursion;

/**
 * Created by skunnumkal on 7/7/14.
 */
public class SortedMatrix {

    public static boolean find(int[][] matrix,int value){
        return doFind(value,matrix,0,0,matrix.length-1,matrix[0].length-1);
    }

    private static boolean doFind(int value, int[][] matrix, int top, int left, int bottom, int right) {

        System.out.println("Top" + top + " Left " + left + " Bottom " + bottom + " Rgiht " + right);
        if(top > bottom || left > right){
            return false;
        }
        if(top == bottom && left == right){
            return value == matrix[top][left];
        }
        int xMid = (top + bottom)/2;
        int yMid = (left + right)/2;
        int mid = matrix[xMid][yMid];
        if(value == mid){
            return true;
        }
        else if(value < mid){
            return doFind(value,matrix,top,left,xMid,yMid) || doFind(value,matrix,top,yMid+1,xMid,right) ||
                    doFind(value,matrix,xMid+1,left,bottom,yMid);
        }
        else{
            return doFind(value,matrix,xMid+1,yMid+1,bottom,right) || doFind(value,matrix,top,yMid+1,xMid,right) ||
                    doFind(value,matrix,xMid+1,left,bottom,yMid);
        }
    }
}
