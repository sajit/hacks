package hackerrank.algo.bonetrousle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bonetrousle {

    /*
     * Complete the bonetrousle function below.
     */
    static long[] bonetrousle(long n, long k, int b) {
        /*
         * Write your code here.
         */
        List<Long> result = recursive_kp(n,k,b, new ArrayList<>());
        if(result == null) {
            return new long[] {-1};
        }
        long[] soln = new long[result.size()];
        for(int i=0;i<result.size();i++){
            soln[i] = result.get(i);
        }
        return soln;

    }

    static List<Long> recursive_kp(long needed, long k, int boxRemaining, List<Long> solnSofar) {
          if(needed<0) return null;
          if(k == 0 && needed > 0) return null;
          if(boxRemaining == 0 && needed > 0) return null;
          if(needed == 0 && boxRemaining > 0) return null;
          if(needed==0 && boxRemaining==0 && k==0) return solnSofar;
          //skip k
          List<Long> solnWithoutK = recursive_kp(needed,k-1,boxRemaining,solnSofar);
            List<Long> copy = new ArrayList<>(solnSofar);
            copy.add(k);
          List<Long> solnWithK = recursive_kp(needed-k,k-1,boxRemaining-1,copy);

          if(solnWithoutK == null) {
              return solnWithK;
          }
          else
              return solnWithoutK;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nkb = scanner.nextLine().split(" ");

            long n = Long.parseLong(nkb[0].trim());

            long k = Long.parseLong(nkb[1].trim());

            int b = Integer.parseInt(nkb[2].trim());

            long[] result = bonetrousle(n, k, b);

            for (int resultItr = 0; resultItr < result.length; resultItr++) {
                bufferedWriter.write(String.valueOf(result[resultItr]));

                if (resultItr != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
