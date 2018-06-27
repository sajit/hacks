package hackerrank.algo.container.ryanzehr.balls;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    /**
     * Intuition:  Ultimately the number of balls of type x should have a container which has that size. As long
     * as there are number of containers of size x matches the number of ball types that have count x a swap is
     * possible
     * @param containerMatrix
     * @return
     */
    public static String organizingContainers(int[][] containerMatrix) {
        int n = containerMatrix.length;
        //Create a bag for the amount of  each ball and the sizes of containers
        LinkedList<Integer> containers = new LinkedList<>();
        LinkedList<Integer> balls = new LinkedList<>();
        for(int i = 0; i < n; i++){
            int rowSum = 0;
            int colSum = 0;
            for(int j = 0; j < n; j++){
                rowSum += containerMatrix[i][j];
                colSum += containerMatrix[j][i];
            }
            balls.add(colSum);
            containers.add(rowSum);
        }

        //Check if the two bags are equal
        containers.removeAll(balls);
        if(containers.isEmpty()) return "Possible";
        else return "Impossible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[][] container = new int[n][n];

                for (int i = 0; i < n; i++) {
                    String[] containerRowItems = scanner.nextLine().split(" ");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    for (int j = 0; j < n; j++) {
                        int containerItem = Integer.parseInt(containerRowItems[j]);
                        container[i][j] = containerItem;
                    }
                }

                String result = organizingContainers(container);
                System.out.println(result);
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        }

        scanner.close();
    }
}
