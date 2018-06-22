package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skunnumkal on 10/31/14.
 */
public class HorseMan {

    private final int size = 8;
    private int[][] visitCount = new int[size][size];
    private Cell[][] board = new Cell[size][size];
    public HorseMan() {
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j] = new Cell(i,j);
            }
        }
    }
    public static int count = 0;
    public boolean isTourComplete(){
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++){
                if(!board[i][j].visited){
                    return false;
                }
            }

        return true;
    }
    public boolean traverse(int x,int y,int moveCount){

        board[x][y].visited = true;
        visitCount[x][y] = moveCount;
        if(isTourComplete()){
            System.out.println("Found a valid tour" + count++);
            //print();
            return true;
        }
        List<Cell> possibleNextMoves = validNextMoves(x,y);


        for(Cell cell : possibleNextMoves){

            if(traverse(cell.x,cell.y,moveCount+1)){
                return true;
            }
            else {
                //reset backtrack
                board[x][y].visited=false;
                visitCount[x][y] = -1;
            }
        }

        return false;
    }

    public void print(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                String yes = (board[i][j].visited)? "X" : "";
                System.out.print(" | " + yes);
            }
            System.out.println();

        }
        System.out.println("---------------------------------------");
        for(int i=0;i<visitCount.length;i++){
            for(int j=0;j<visitCount[i].length;j++){

                System.out.print(" " + visitCount[i][j]);
            }
            System.out.println();

        }
        System.out.println("---------------------------------------");
    }

    public static void main(String[] args){
        HorseMan horseMan = new HorseMan();
        horseMan.traverse(0,0,1);

        System.out.println("Final count" + HorseMan.count);
        horseMan.print();
    }

    public List<Cell> validNextMoves(int x,int y){
         List<Cell> result = new ArrayList<>();

        //top left
        if(x<(size-2) && y<(size-1) && !board[x+2][y+1].visited){
            result.add(Cell.of(x+2,y+1));
        }
        if(x<(size-1) && y<(size-2) && !board[x+1][y+2].visited){
            result.add(Cell.of(x+1,y+2));
        }
        //top right
        if(x>=2 && y<(size-1) && !board[x-2][y+1].visited){
            result.add(Cell.of(x-2,y+1));
        }
        if(x>=1 && y<(size-2) && !board[x-1][y+2].visited){
            result.add(Cell.of(x-1,y+2));
        }
        //bottom right
        if(x>=2 && y>=1 && !board[x-2][y-1].visited){
            result.add(Cell.of(x-2,y-1));
        }
        if(x>=1 && y>=2 && !board[x-1][y-2].visited){
            result.add(Cell.of(x-1,y-2));
        }
        //bottom left
        if(x<(size-2) && y>=1 && !board[x+2][y-1].visited){
            result.add(Cell.of(x+2,y-1));
        }
        if(x<(size-1) && y>=2 && !board[x+1][y-2].visited){
            result.add(Cell.of(x+1,y-2));
        }

        return result;
    }


}
class Cell{
    public final int x,y;
    public boolean visited= false;

    public Cell(int x,int y){
        this.x = x;this.y = y;

    }
    public static Cell of(int x,int y){
        return new Cell(x,y);
    }
}


