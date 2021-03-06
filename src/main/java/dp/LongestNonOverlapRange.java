package dp;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sajit on 7/3/14.
 */
public class LongestNonOverlapRange {

    public static Logger logger = Logger.getLogger(LongestNonOverlapRange.class.getSimpleName());
    public static int getLongestNonOverlaps(Interval[] intervals){
        Arrays.sort(intervals);
        for(Interval anInterval : intervals){
            System.out.println(anInterval);
        }
        //maximum length of all intervals for interval ending at that value
        int[] maxIntervalSoFar = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            maxIntervalSoFar[i]= intervals[i].getLength();
        }
        for(int i=1;i<maxIntervalSoFar.length;i++){
            for(int j=0;j<i;j++){
                if(!Interval.overlaps(intervals[i],intervals[j])){
                    maxIntervalSoFar[i] = Math.max(maxIntervalSoFar[i],maxIntervalSoFar[j]+intervals[i].getLength());

                }

            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<maxIntervalSoFar.length;i++){
            System.out.println("After..i="+i+":" + maxIntervalSoFar[i]);
            if(max < maxIntervalSoFar[i]){
                max = maxIntervalSoFar[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        List<Interval> intervalList = ImmutableList.of(new Interval(1,4),new Interval(2,3), new Interval(2,5), new Interval(6,8), new Interval(8,10), new Interval(9,10));
        Interval[] intervalArr = new Interval[intervalList.size()];
        int longestLen = LongestNonOverlapRange.getLongestNonOverlaps(intervalList.toArray(intervalArr));
        logger.info("Result = " + longestLen);
    }
}

