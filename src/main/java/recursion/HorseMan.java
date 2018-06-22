package recursion;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by skunnumkal on 10/31/14.
 */
public class HorseMan {

    private static final int size = 8;


    public static int count = 0;
    public boolean traverse(int x,int y,int moveCount,int[][] visitCount){


        if(moveCount==size*size){
            System.out.println("Found a valid tour" + count++);
            print(visitCount);
            return true;
        }
        List<Pair<Integer,Integer>> possibleNextMoves = validNextMoves(x, y,visitCount);


        for(Pair<Integer,Integer> cell : possibleNextMoves){
            visitCount[cell.getLeft()][cell.getRight()]=moveCount;
            if(traverse(cell.getLeft(),cell.getRight(),moveCount+1,visitCount)){
                return true;
            }
            else {
                //reset backtrack
                visitCount[x][y] = -1;
            }
        }

        return false;
    }

    public void allTours(int x,int y,int moveCount,int[][] visitCount){
//
//
        if(moveCount==size*size){
            System.out.println("Found a valid tour" + count++);
            print(visitCount);
            return;
        }
        List<Pair<Integer,Integer>> possibleNextMoves = validNextMoves(x, y,visitCount);
//
//
        for(Pair<Integer,Integer> cell : possibleNextMoves){
               visitCount[cell.getLeft()][cell.getRight()]=moveCount;
               allTours(cell.getLeft(),cell.getRight(),moveCount+1,visitCount);
                //reset backtrack
                visitCount[x][y] = -1;
            }

    }


    public void print(int[][] visitCount){
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
        int[][] visitCount = new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                visitCount[i][j] = -1;
            }
        }
        visitCount[0][0]=0;
        horseMan.allTours(0,0,1,visitCount);

        System.out.println("Final count" + HorseMan.count);
        //horseMan.print(visitCount);
    }

    public List<Pair<Integer,Integer>> validNextMoves(int x,int y,int[][] visitCount){

        List<Pair<Integer,Integer>> result = new ArrayList<>();
        //bottom right
        if(x<(size-2) && y<(size-1) && visitCount[x+2][y+1]==-1){
            result.add(new ImmutablePair<>(x+2,y+1));
        }
        if(x<(size-1) && y<(size-2) && visitCount[x+1][y+2]==-1){
            result.add(new ImmutablePair<>(x+1,y+2));
        }
        //top right
        if(x>=2 && y<(size-1) && visitCount[x-2][y+1]==-1){
            result.add(new ImmutablePair<>(x-2,y+1));
        }
        if(x>=1 && y<(size-2) && visitCount[x-1][y+2]==-1){
            result.add(new ImmutablePair<>(x-1,y+2));
        }
        //top left
        if(x>=2 && y>=1 && visitCount[x-2][y-1]==-1){
            result.add(new ImmutablePair<>(x-2,y-1));
        }
        if(x>=1 && y>=2 && visitCount[x-1][y-2]==-1){
            result.add(new ImmutablePair<>(x-1,y-2));
        }
        //bottom left
        if(x<(size-2) && y>=1 && visitCount[x+2][y-1]==-1){
            result.add(new ImmutablePair<>(x+2,y-1));
        }
        if(x<(size-1) && y>=2 && visitCount[x+1][y-2]==-1){
            result.add(new ImmutablePair<>(x+1,y-2));
        }

        return result;
    }


}


