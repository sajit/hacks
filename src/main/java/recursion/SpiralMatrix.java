package recursion;

/**
 * Created by sajit on 7/6/14.
 */
public class SpiralMatrix {

    public static void printMatrix(int[][] matrix){
        printSpiral(0,0,matrix.length-1,matrix[0].length-1,matrix);
    }

    private static void printSpiral(int top, int left, int bottom, int right, int[][] curMatrix) {
        if((top > bottom) || (left > right))
            return;
        //print top row
        for(int j=left;j<=right;j++){
            System.out.print(" "+curMatrix[top][j]);
        }
        //print right col
        for(int i=top+1;i<=bottom;i++){
            System.out.print(" "+curMatrix[i][right]);
        }
        //print bottom row [right to left]
        for(int j=right-1;j>=left;j--){
            System.out.print(" " + curMatrix[bottom][j]);
        }
        //print left col bottom to top
        for(int i=bottom-1;i>top;i--){
            System.out.print(" " + curMatrix[i][left]);
        }

        printSpiral(top+1,left+1,bottom-1,right-1,curMatrix);
    }


    public static void main(String[] args){

        int[][] aMat = {{1,4,5,7,8,5},{4,1,7,8,3,5},{8,9,0,1,4,0},{4,1,8,6,8,3}};
        printMatrix(aMat);
    }
}
