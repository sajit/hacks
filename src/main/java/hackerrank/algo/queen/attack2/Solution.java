package hackerrank.algo.queen.attack2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    public static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {




        boolean[][] board = new boolean[n+1][n+1];
        for(int i=0;i<k;i++){
            board[obstacles[i][0]][obstacles[i][1]] = true;
        }
        int i = r_q;
        int j = c_q;
        int count=0;
        //go up & right
        while(i>1 && j<n && !board[i-1][j+1]){
            count+=1;
            i--;j++;
        }
        i = r_q;
        j = c_q;
        //go down && left
        while(i<n && j>1 && !board[i+1][j-1]){
            count +=1;
            i++;j--;
        }
        i = r_q;
        j = c_q;
        //go down && right
        while(i<n && j<n && !board[i+1][j+1]){
            count +=1;
            i++;j++;
        }
        i = r_q;
        j = c_q;
        //go up && left
        while(i>1 && j>1 && !board[i-1][j-1]){
            count +=1;
            i--;j--;
        }
        //go left
        i= r_q;
        j = c_q;
        while(j>1 && !board[i][j-1]){
            count +=1;
            j--;
        }
        //go right
        i= r_q;
        j = c_q;
        while(j<n && !board[i][j+1]){
            count +=1;
            j++;
        }
        //go up
        i= r_q;
        j = c_q;
        while(i>1 && !board[i-1][j]){
            count +=1;
            i--;
        }//go down
        i= r_q;
        j = c_q;
        while(i<n && !board[i+1][j]){
            count +=1;
            i++;
        }


     return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            String[] r_qC_q = scanner.nextLine().split(" ");

            int r_q = Integer.parseInt(r_qC_q[0]);

            int c_q = Integer.parseInt(r_qC_q[1]);

            int[][] obstacles = new int[k][2];

            for (int i = 0; i < k; i++) {
                String[] obstaclesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                    obstacles[i][j] = obstaclesItem;
                }
            }

            int result = queensAttack(n, k, r_q, c_q, obstacles);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();
        }

        scanner.close();
    }
}