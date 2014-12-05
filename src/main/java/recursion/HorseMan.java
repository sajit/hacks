package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skunnumkal on 10/31/14.
 */
public class HorseMan {

    private final int size = 8;
    private boolean[][] visited = new boolean[size][size];
    private int[][] visitCount = new int[size][size];
    public static int count = 0;
    public boolean isTourComplete(){
        for(int i=0;i<visited.length;i++)
            for(int j=0;j<visited[i].length;j++){
                if(!visited[i][j]){
                    return false;
                }
            }

        return true;
    }
    public boolean traverse(int x,int y,int moveCount){
        //print();
        visited[x][y] = true;
        visitCount[x][y] = moveCount;
        if(isTourComplete()){
            System.out.println("Found a valid tour" + count++);
            print();
            return true;
        }
        List<Cell> possibleNextMoves = validNextMoves(x,y);


        for(Cell cell : possibleNextMoves){

            traverse(cell.x,cell.y,moveCount+1);
        }
        visited[x][y]=false;
        visitCount[x][y] = -1;
        return false;
    }

    public void print(){
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[i].length;j++){
                String yes = (visited[i][j])? "X" : "";
                System.out.print(" | " + yes);
            }
            System.out.println();

        }
        System.out.println("---------------------------------------");
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[i].length;j++){

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
        if(x<(size-2) && y<(size-1) && !visited[x+2][y+1]){
            result.add(Cell.of(x+2,y+1));
        }
        if(x<(size-1) && y<(size-2) && !visited[x+1][y+2]){
            result.add(Cell.of(x+1,y+2));
        }
        //top right
        if(x>=2 && y<(size-1) && !visited[x-2][y+1]){
            result.add(Cell.of(x-2,y+1));
        }
        if(x>=1 && y<(size-2) && !visited[x-1][y+2]){
            result.add(Cell.of(x-1,y+2));
        }
        //bottom right
        if(x>=2 && y>=1 && !visited[x-2][y-1]){
            result.add(Cell.of(x-2,y-1));
        }
        if(x>=1 && y>=2 && !visited[x-1][y-2]){
            result.add(Cell.of(x-1,y-2));
        }
        //bottom left
        if(x<(size-2) && y>=1 && !visited[x+2][y-1]){
            result.add(Cell.of(x+2,y-1));
        }
        if(x<(size-1) && y>=2 && !visited[x+1][y-2]){
            result.add(Cell.of(x+1,y-2));
        }

        return result;
    }


}
class Cell{
    public final int x,y;

    public Cell(int x,int y){
        this.x = x;this.y = y;

    }
    public static Cell of(int x,int y){
        return new Cell(x,y);
    }
}


