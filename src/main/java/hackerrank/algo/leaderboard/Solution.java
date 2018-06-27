package hackerrank.algo.leaderboard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    // Complete the climbingLeaderboard function below.
    public static int[] climbingLeaderboard(int[] scores, int[] alice) {

        int[] distinctScores = Arrays.stream(scores).distinct().toArray();
        int[] positions = new int[alice.length];
        for(int i=0;i<alice.length;i++){
            int position = getPosition(alice[i],0,distinctScores.length-1,distinctScores);
            positions[i]=position+1;
        }
        return positions;


    }

    public static int getPosition(int aliceScore, int start, int end, int[] scores) {
        if(start>end){
            return end+1;
        }
        int middle = (start+end)/2;
        int midScore = scores[middle];
        if(midScore>aliceScore){
            return getPosition(aliceScore,middle+1,end,scores);
        }
        else if(midScore<aliceScore){
            return getPosition(aliceScore,start,middle-1,scores);
        }
        else {
            return middle;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int scoresCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] scores = new int[scoresCount];

            String[] scoresItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < scoresCount; i++) {
                int scoresItem = Integer.parseInt(scoresItems[i]);
                scores[i] = scoresItem;
            }

            int aliceCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] alice = new int[aliceCount];

            String[] aliceItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < aliceCount; i++) {
                int aliceItem = Integer.parseInt(aliceItems[i]);
                alice[i] = aliceItem;
            }

            int[] result = climbingLeaderboard(scores, alice);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write("\n");
                }
            }

            bufferedWriter.newLine();

            bufferedWriter.close();
        }

        scanner.close();
    }
}
