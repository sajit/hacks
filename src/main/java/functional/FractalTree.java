package functional;

public class FractalTree {
    //print out ascii art of a tree with 63 rows & 100 columns
    //each iteration halves length of vertical and horizontal parts
    private static final int MAX_COL = 100;
    private static final int MAX_ROWS = 63;
    private static char[][] board = new char[MAX_ROWS][MAX_COL];

    private void printTreeNonFn() {
       int currentIteration=1;
       for(int i=MAX_ROWS-1;i>=0;i--){
           for(int j=0;j<MAX_COL;j++){
               System.out.print(getChar(i,j,currentIteration));
           }
       }
    }

    private char getChar(int i, int j, int iteration) {
        return '_';
    }
}
