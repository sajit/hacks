package l33t;

import com.google.common.collect.ImmutableList;
import dp.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skunnumkal on 10/24/14.
 */
public class InsertIntervals {

    public static void main(String[] args){
        List<Interval> input = ImmutableList.of(
                new Interval(1,3),new Interval(4,6),new Interval(8,9)
        );
        List<Interval> output1 = InsertIntervals.insert(input,new Interval(2,5));
        for(Interval in : output1){
            System.out.print(" " + in);
        }
        System.out.println();
        List<Interval> output2 = InsertIntervals.insert(input,new Interval(6,8));
        for(Interval in : output2){
            System.out.print(" " + in);
        }
        System.out.println();
        List<Interval> output3 = InsertIntervals.insert(input,new Interval(9,10));
        for(Interval in : output3){
            System.out.print(" " + in);
        }
        System.out.println();
        List<Interval> output4 = InsertIntervals.insert(input,new Interval(-1,0));
        for(Interval in : output4){
            System.out.print(" " + in);
        }
    }

    public static List<Interval> insert(List<Interval> input,Interval newInterval){
      int start=0;
      List<Interval> result = new ArrayList<Interval>();
      int highestBeforeIndex = getHighestBefore(input,newInterval);

      if(highestBeforeIndex==input.size()-1){ //all elements are lesser than newInterval
         result.addAll(input);
         result.add(newInterval);
          return result;
      }

      int lowestAfterIdx = getLowestAfter(input,newInterval);
      if(lowestAfterIdx==0){ //all elements are greater than newInterval
          result.add(newInterval);
          result.addAll(input);
          return result;
      }

      Interval merged = merge(input.get(highestBeforeIndex+1),input.get(lowestAfterIdx-1),newInterval);

      for(int i=0;i<=highestBeforeIndex;i++){
          result.add(input.get(i));
      }
      result.add(merged);
      for(int i=lowestAfterIdx;i<input.size();i++){
          result.add(input.get(i));
      }
      return result;
    }

    private static Interval merge(Interval smaller,Interval larger, Interval newInterval) {
        int mergeStart,mergeEnd;
        //System.out.println("Larger " + larger + "Smaller " + smaller);
        if(smaller.start<newInterval.start){
            mergeStart = smaller.start;
        }
        else{
            mergeStart = newInterval.start;
        }
        if(larger.end>newInterval.end){
            mergeEnd = larger.end;
        }
        else{
            mergeEnd = newInterval.end;
        }
        return new Interval(mergeStart,mergeEnd);
    }

    private static int getHighestBefore(List<Interval> intervals,Interval target){
        for(int i=intervals.size()-1;i>=0;i--){
            if(intervals.get(i).end<=target.start){
                return i;
            }
        }
        return -1;
    }
    private static int getLowestAfter(List<Interval> intervals,Interval target){
        for(int i=0;i<intervals.size();i++){
            if(intervals.get(i).start >= target.end){
                return i;
            }
        }
        return intervals.size();
    }
}


