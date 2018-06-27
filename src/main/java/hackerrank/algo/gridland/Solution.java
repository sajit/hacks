package hackerrank.algo.gridland;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Range{
    public final int start;
    public final int end;

    public Range(int start, int end){
        this.start = start;
        this.end = end;

    }
    public int getLength(){
        return end-start+1;
    }

    public boolean hasGap(Range otherRange){
        return (otherRange.start>end+1 || otherRange.end+1<start);
    }

    public Range merge(Range otherRange){
        if(hasGap(otherRange)){
            throw new RuntimeException("not_possible");
        }
        else {
            return new Range(Math.min(start,otherRange.start),Math.max(end,otherRange.end));
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return start == range.start &&
                end == range.end;
    }

    @Override
    public int hashCode() {

        return Objects.hash(start, end);
    }

    @Override
    public String toString(){
        return "["+start+":"+end+"]";
    }
}
public class Solution {
    // Complete the gridlandMetro function below.
    static int gridlandMetro(int n, int m, int k, int[][] track) {
        Map<Integer,List<Range>> tracks = new HashMap<>();
        //int[][] has_track = new int[n+1][m+1];
        for(int i=0;i<k;i++){
            Range thisRange = new Range(track[i][1], track[i][2]);
            int row = track[i][0];
            List<Range> rangeForRow = tracks.get(row);
            if(rangeForRow==null){
                rangeForRow = new ArrayList<>();
            }
            List<Range> toBeMerged = new ArrayList<>();
            for(Range range : rangeForRow){
                if(!range.hasGap(thisRange)){
                    toBeMerged.add(range);
                }
            }
            Range newRange = thisRange;
            for(int s=0;s<toBeMerged.size();s++){
                newRange = toBeMerged.get(s).merge(newRange);
            }
            rangeForRow.removeAll(toBeMerged);
            rangeForRow.add(newRange);


            tracks.put(row,rangeForRow);

        }
        BigInteger lamps= BigInteger.ZERO;
        for(Integer row : tracks.keySet()){
            List<Range> ranges = tracks.get(row);
            BigInteger trackLength=BigInteger.ZERO;
            for(Range range : ranges){
                trackLength = trackLength.add(BigInteger.valueOf(range.getLength()));
            }
            lamps = lamps.add(BigInteger.valueOf(m).subtract(trackLength));
        }
        return lamps.add(BigInteger.valueOf(m*(n-tracks.size()))).intValue();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            String[] nmk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmk[0]);

            int m = Integer.parseInt(nmk[1]);

            int k = Integer.parseInt(nmk[2]);

            int[][] track = new int[k][3];

            for (int i = 0; i < k; i++) {
                String[] trackRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 3; j++) {
                    int trackItem = Integer.parseInt(trackRowItems[j]);
                    track[i][j] = trackItem;
                }
            }

            int result = gridlandMetro(n, m, k, track);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedWriter.close();
        }

        scanner.close();
    }
}
