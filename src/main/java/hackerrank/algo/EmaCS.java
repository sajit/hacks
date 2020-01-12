package hackerrank.algo;

import java.util.*;


class Line {
    @Override
    public String toString(){
        return "["+start+"->"+end+"]";
    }
    public Line(Point start, Point end){
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
                return this.start.y > other.end.y || this.end.y < other.start.y;

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
                return this.start.x > other.end.x || this.end.x < other.start.x;
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
        return x+","+y;
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

    public Plus(Line horizontal, Line vertical){
        this.horizontal = horizontal;
        this.vertical = vertical;
    }
    public int getArea(){
        return 2*horizontal.length()-1;
    }

    public boolean intersects(Plus other){
        return other.horizontal.intersects(horizontal) || other.horizontal.intersects(vertical)
                || other.vertical.intersects(horizontal) || other.vertical.intersects(vertical);
    }
    @Override
    public String toString(){
        return " -- "+horizontal+" | " + vertical;
    }
}
public class EmaCS {
    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {

        char[][] gridCells = stringArrTo2DCharArr(grid);

        List<Plus> plusList = new ArrayList<>();
        //TODO further optimize
        for(int i=0;i<gridCells.length;i++){
            for(int j=0;j<gridCells[i].length;j++){
                //starting for this cell
                Plus minPlus = getMinPlus(i,j,gridCells);
                plusList.add(minPlus);
            }
        }
        Collections.sort(plusList, Comparator.comparingInt(Plus::getArea).reversed());
        for(int i=0;i<plusList.size()-1;i++){
            for(int j=i+1;j<plusList.size();j++){
                if(!plusList.get(i).intersects(plusList.get(j))){
                    return plusList.get(i).getArea()*plusList.get(j).getArea();
                }
            }
        }

        return 0;
    }

    public static char[][] stringArrTo2DCharArr(String[] grid) {
        char[][] gridCells = new char[grid.length][grid[0].length()];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length();j++) {

                gridCells[i][j] = grid[i].charAt(j);
            }
        }
        return gridCells;
    }

    public static Plus getMinPlus(int startI, int startJ, char[][] gridCells) {
        int minDist=Integer.MAX_VALUE;
        //go up
        int i=startI-1;
        int length=0;
        while(i>=0 && gridCells[i][startJ]=='G' && length<minDist){
            i--;length++;
        }
        minDist=length;

        int j=startJ+1;
        length=0;
        while(j<gridCells[startI].length && gridCells[startI][j]=='G' && length<minDist){
            j++;length++;
        }
        if(length<minDist){
            minDist = length;
        }

        i=startI+1;
        length=0;
        while(i<gridCells.length && gridCells[i][startJ]=='G' && length<minDist){
            i++;length++;
        }
        if(length<minDist){
            minDist =length;
        }

        j=startJ-1;
        length=0;
        while(j>=0 && gridCells[startI][j]=='G' && length<minDist){
            j--;length++;
        }
        if(length<minDist){
            minDist = length;
        }
        Line horizontal = new Line(new Point(startI,startJ-minDist),new Point(startI,startJ+minDist));
        Line vertical = new Line(new Point(startI-minDist,startJ),new Point(startI+minDist,startJ));

        return new Plus(horizontal,vertical);
    }
}
