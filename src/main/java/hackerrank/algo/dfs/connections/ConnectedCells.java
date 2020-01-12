package hackerrank.algo.dfs.connections;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ConnectedCells {


    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
        boolean[][] visitTracker = new boolean[grid.length][grid[0].length];
        int maxRegionSize = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int size = doDFS(i,j,grid,visitTracker);
                if(size>maxRegionSize) {
                    maxRegionSize = size;
                }
            }
        }

        return maxRegionSize;


    }

    static int doDFS(int row, int col, int[][] grid, boolean[][] visitTracker) {
        visitTracker[row][col]=true;
        if(grid[row][col]==0){
            return 0;
        }
        else{
            int rightDepth =0,bottomRightDepth = 0,bottomDepth=0,bottomLeftDepth = 0,
                    leftDepth=0, topLeftDepth = 0,topDepth=0, topRightDepth=0;
            if(col<grid[row].length-1 && !visitTracker[row][col+1]) { //can move right
                rightDepth = doDFS(row,col+1,grid,visitTracker);
            }
            //bottom right
            if(col<grid[row].length-1 && row<grid.length-1 && !visitTracker[row+1][col+1]) {
                bottomRightDepth = doDFS(row+1,col+1,grid,visitTracker);
            }
            if(row<grid.length-1 && !visitTracker[row+1][col]) {
                bottomDepth = doDFS(row+1,col,grid,visitTracker);
            }
            if(row<grid.length-1 && col>0 && !visitTracker[row+1][col-1]) {
                bottomLeftDepth = doDFS(row+1,col-1,grid,visitTracker);
            }
            if(col>0 && !visitTracker[row][col-1]) {
                leftDepth = doDFS(row,col-1,grid,visitTracker);
            }
            if(col> 0 && row>0 && !visitTracker[row-1][col-1]) {
                topLeftDepth = doDFS(row-1,col-1,grid,visitTracker);
            }
            if(row> 0 && !visitTracker[row-1][col]) {
                topDepth = doDFS(row-1,col,grid,visitTracker);
            }
            if(row> 0 && col< grid[row].length-1 && !visitTracker[row-1][col+1]) {
                topRightDepth = doDFS(row-1,col+1,grid,visitTracker);
            }
            return 1 + rightDepth + bottomRightDepth + bottomDepth + bottomLeftDepth + leftDepth + topLeftDepth + topDepth + topRightDepth;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {
                String[] gridRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < m; j++) {
                    int gridItem = Integer.parseInt(gridRowItems[j]);
                    grid[i][j] = gridItem;
                }
            }

            int res = maxRegion(grid);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();

            bufferedWriter.close();
        }

        scanner.close();
    }
}
