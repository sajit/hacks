package dp;

/**
 * Created by skunnumkal on 10/24/14.
 */

public class Interval implements Comparable<Interval>{

    public final int start,end;
    public Interval(int start,int end){
        this.start = start;
        this.end = end;
    }

    public static final boolean overlaps(final Interval a,final Interval b){
        if(a.end <= b.start || b.end <= a.start)
            return false;
        return true;
    }

    public int getLength(){
        return Math.abs(start-end);
    }

    @Override
    public int compareTo(Interval interval) {
        if(this.end < interval.end){
            return -1;
        }
        else if(this.end > interval.end){
            return 1;
        }
        else{
            return this.start - interval.start;
        }
    }

    @Override
    public String toString(){
        return "{"+start+" : "+end+"}";
    }
}
