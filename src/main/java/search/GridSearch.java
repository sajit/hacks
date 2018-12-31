package search;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class GridSearch {
    /**
     * Find shortest path between two points in a grid
     *
     */
    static char[][] grid = new char[][]{
            {' ',' ',' ','*'},
            {' ',' ','*',' '},
            {' ','*',' ',' '},
            {' ',' ',' ',' '}};
    static boolean[][] visited = new boolean[4][4];
    public static String path(int start_i,int start_j,int end_i,int end_j) {

        Queue<SearchPath> queue = new PriorityQueue<>();
        SearchPath path = new SearchPath();
        path.add(new ImmutablePair<>(start_i,start_j));
        queue.add(path);
        return doBfs(queue,0,end_i,end_j);

    }

    private static String doBfs(Queue<SearchPath> queue, int length,
                                int target_row,int target_col) {
        if(queue.isEmpty()){
            return "no path";
        }
        SearchPath path = queue.poll();
        Pair<Integer,Integer> cell = path.getLast();
        if(cell.getLeft()==target_row && cell.getRight()==target_col){
            return path.toString();
        }
        visited[cell.getLeft()][cell.getRight()] = true;
        List<Pair<Integer,Integer>> visitable = getVisitable(cell);

        for(Pair<Integer,Integer> neighbour : visitable){
            SearchPath newPath = path.copy();
            newPath.add(neighbour);
            queue.add(newPath);

        }
        //System.out.println(builder.length());
        //builder.delete(builder.length()-5,builder.length());
        return doBfs(queue,length+1,target_row,target_col);
    }



    private static List<Pair<Integer, Integer>> getVisitable(Pair<Integer, Integer> currentCell) {
        int row = currentCell.getLeft();
        int col = currentCell.getRight();
        List<Pair<Integer,Integer>> result = new ArrayList<>();
        if(row>0 && !visited[row-1][col] && grid[row-1][col]!= '*'){
            result.add(new ImmutablePair<>(row-1,col));
        }
        if(col<3 && !visited[row][col+1] && grid[row][col+1]!= '*'){
            result.add(new ImmutablePair<>(row,col+1));
        }
        if(row<3 && !visited[row+1][col] && grid[row+1][col]!= '*'){
            result.add(new ImmutablePair<>(row+1,col));
        }
        if(col>0 && !visited[row][col-1] && grid[row][col-1]!= '*'){
            result.add(new ImmutablePair<>(row,col-1));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(path(1,0,3,2));
    }
}
