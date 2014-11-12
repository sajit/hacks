package recursion;

/**
 * Created by sajit on 11/2/14.
 */
public class EightQueens {


    final int size;
    final boolean[][] placeGrid;
    public EightQueens(int size){
        this.size = size;
        placeGrid = new boolean[size][size];
    }
    public void placeQueen(int row){
        if(row>= size){
          printBoard();
          return;
        }
        for(int j=0;j<placeGrid[row].length;j++){
            if(canPlace(row,j)){
                placeGrid[row][j] = true;
                placeQueen(row+1);
            }
            placeGrid[row][j] = false;
        }
    }

    private boolean canPlace(int row, int j) {
        for(int i=0;i<placeGrid[row].length;i++){
            if(placeGrid[row][i]){
                return false;
            }
        }
        for(int i=0;i<size;i++){
            if(placeGrid[i][j]){
                return false;
            }
        }
        for(int i=row-1,k=j+1;i>=0 && k<size;i--,k++){
            if(placeGrid[i][k]){
                return false;
            }
        }
        for(int i=row-1,k=j-1;i>=0 && k>=0;i--,k--){
            if(placeGrid[i][k]){
                return false;
            }
        }

        for(int i=row+1,k=j+1;i<size && k<size;i++,k++){
            if(placeGrid[i][k]){
                return false;
            }
        }

        for(int i=row+1,k=j-1;i<size && k>=0;i++,k--){
            if(placeGrid[i][k]){
                return false;
            }
        }


        return true;
    }

    private void printBoard() {
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                String s = (!placeGrid[i][j])? " " : "Q";
                System.out.print("|"+s);
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");
    }

    private static void main(String[] args){
        EightQueens eightQueens = new EightQueens(4);
        eightQueens.placeQueen(0);
    }
}
