package temp;

import java.util.Scanner;

/**
 * Created by sajit on 2/23/15.
 */
public class Encryption
{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        int textLength = text.length();



        Tuple minTuple = calculateMinTuple(textLength);
        for(int j=0;j<minTuple.col;j++){
            for(int i=0;i<minTuple.row;i++){
                if((i*minTuple.col+ j)<textLength){
                    System.out.print(text.charAt(i*minTuple.col + j));
                }

            }
            System.out.print(" ");
        }


    }

    public static Tuple calculateMinTuple(int length) {
        int floor = (int)Math.floor(Math.sqrt(length));
        int ceiling = (int)Math.ceil(Math.sqrt(length));
        int minI = floor,minJ = ceiling,minArea = Integer.MAX_VALUE;
        for(int i=floor;i<=ceiling;i++){
            for(int j=i;j<=ceiling;j++){
                if(i*j >= length && i*j< minArea){
                    //possible
                    minI = i;
                    minJ= j;
                    minArea = i*j;

                }
            }
        }
        return Tuple.of(minI, minJ);
    }


}
class Tuple{
    public final int row;
    public final int col;
    public Tuple(int row,int col){
        this.row = row;
        this.col = col;

    }
    public static Tuple of(int i,int j){
        return new Tuple(i,j);
    }

    @Override
    public String toString(){
        return "{"+row+","+col+"}";
    }
}
