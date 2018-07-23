package hackerrank.algo.ema.supercs;

import java.util.*;

class Line {
    @Override
    public String toString(){
        return "[Start="+start+",End="+end+"]";
    }
    public Line(Point start,Point end){
        this.start = start;
        this.end = end;
    }
    public final Point start,end;

    public int length() {
        if(start.x==end.x){
            return Math.abs(start.y-end.y)+1;
        }
        else {
            return Math.abs(start.x-end.x)+1;
        }
    }

    public boolean isHorizontal() {
        return start.x==end.x;
    }
    public boolean intersects(Line other){
        if(this.isHorizontal()){
            if(other.isHorizontal()){
                return !(this.start.y > other.end.y || this.end.y < other.start.y);

            }
            else {
                return other.start.x<=this.start.x && other.end.x>=this.end.x && this.start.y <= other.start.y && this.end.y >= other.end.y;
            }
        }
        else { //this is vertical
            if(other.isHorizontal()){
                return other.start.y<=this.start.y && other.end.y>=this.end.y && this.start.x <= other.start.x && this.end.x >= other.end.x;
            }
            else {
                return !(this.start.x > other.end.x || this.end.x < other.start.x);
            }
        }
    }

    public Point middle() {
        return new Point(((start.x+end.x)/2),((start.y+end.y)/2));
    }
}
class Point {
    @Override
    public String toString(){
        return x+"|"+y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    public final int x,y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }


}
class Plus{
    public final Line horizontal,vertical;

    public Plus(Line horizontal,Line vertical){
        this.horizontal = horizontal;
        this.vertical = vertical;
    }
    public int getArea(){
        return 2*horizontal.length();
    }

    public boolean intersects(Plus other){
        return other.horizontal.intersects(horizontal) || other.horizontal.intersects(vertical)
                || other.vertical.intersects(horizontal) || other.vertical.intersects(vertical);
    }

    @Override
    public String toString(){
        return "Horizontal :"+horizontal+" Vertical"+vertical;
    }

}
public class ValidPlus {

    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {

        char[][] gridC = new char[grid.length][grid[0].length()];
        for(int i=0;i<gridC.length;i++){
            for(int j=0;j<grid[i].length();j++)
                gridC[i][j]=grid[i].charAt(j);
        }
        Plus biggestPlus = null;
        //return TreeMap
        Map<Integer,List<Line>> horizontalLinesMap = getHL(gridC);
        //return TreeMap
        Map<Integer,List<Line>> verticalLinesMap = getVL(gridC);
        for(Integer verticalLength : verticalLinesMap.keySet()){
            List<Line> verticalLines = verticalLinesMap.get(verticalLength);
            List<Line> horizontalLinesOfSameLength = horizontalLinesMap.get(verticalLength);
            if(horizontalLinesOfSameLength!=null){
                for(Line horizontalLine : horizontalLinesOfSameLength){
                    for(Line verticalLine : verticalLines){
                        if(formsValidPlus(horizontalLine,verticalLine)){
                            if(biggestPlus==null){
                                biggestPlus = new Plus(horizontalLine,verticalLine);
                                System.out.println("Formed plus" + biggestPlus);
                            }
                            else {
                                Plus nextBiggestPlus = new Plus(horizontalLine,verticalLine);
                                if(!nextBiggestPlus.intersects(biggestPlus)){
                                    return biggestPlus.getArea()*nextBiggestPlus.getArea();
                                }
                            }
                        }
                    }
                }
            }
        }
        return horizontalLinesMap.size()>1?1:0;


    }



    public static boolean formsValidPlus(Line line1, Line line2) {
//        if(line1.isHorizontal() && line2.isHorizontal()){
//            return false; //both horizontal
//        }
//        if(!line1.isHorizontal() && !line2.isHorizontal()){
//            return false;
//        }
        if(line1.length()%2==0 || line2.length()%2==0){
            return false;
        }
        if(line1.length()!=line2.length()){
            return false;
        }
        return line1.middle().equals(line2.middle());
    }



    public static Map<Integer,List<Line>> getHL(char[][] gridC) {
        Map<Integer,List<Line>> horizontalLinesMap = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<gridC.length;i++){
            int j=0;
            int count=0;
            while(j<gridC[i].length) {
                if(gridC[i][j]=='G'){
                    count++;
                }
                else{
                    if(count>0 && count%2!=0){
                        List<Line> lines = horizontalLinesMap.getOrDefault(count,new ArrayList<>());
                        lines.add(new Line(new Point(i,j-count+1),new Point(i,j)));
                        horizontalLinesMap.put(count,lines);
                    }
                    count=0;
                }
                j++;
            }
            if(count>0 && (count-1)%2!=0){
                List<Line> lines = horizontalLinesMap.getOrDefault(count,new ArrayList<>());
                lines.add(new Line(new Point(i,0),new Point(i,j-1)));
                horizontalLinesMap.put(count,lines);
            }


        }
        return horizontalLinesMap;
    }
    public static Map<Integer, List<Line>> getVL(char[][] gridC) {
        Map<Integer,List<Line>> verticalLinesMap = new TreeMap<>(Collections.reverseOrder());
        for(int j=0;j<gridC[0].length;j++){
            int i=0;
            int count=0;
            while(i<gridC.length){
                if(gridC[i][j]=='G'){
                    count++;
                }
                else{
                    if(count>1 && count%2 != 0){
                        List<Line> lines = verticalLinesMap.getOrDefault(count,new ArrayList<>());
                        lines.add(new Line(new Point(i-count+1,j),new Point(i,j)));
                        verticalLinesMap.put(count,lines);
                    }
                    count = 0;
                }
                i++;
            }
            if(count>1 && count%2 != 0){
                List<Line> lines = verticalLinesMap.getOrDefault(count,new ArrayList<>());
                lines.add(new Line(new Point(i-count,j),new Point(i-1,j)));
                verticalLinesMap.put(count,lines);
            }
        }
        return verticalLinesMap;
    }
}
