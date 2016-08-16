package bai.tictactoe;

/**
 * Created by sajit on 5/14/16.
 */
public class Game {

    private Cell[] board;

    public void markCell(int idx,char c){
        board[idx].val = c;
    }

    public Cell getBestMove(Cell[] board,char symbol){
        //check rows
        //check cols
        //diagonals
        int scoreMax = 0;
        Cell bestCell = null;
        int thisScore = checkScore(board[0],board[1],board[2],symbol);
        if(thisScore > scoreMax){
            scoreMax = thisScore;
            bestCell = getBestCell(board[0],board[1],board[2]);
        }
        thisScore = checkScore(board[3],board[4],board[5],symbol);
        if(thisScore > scoreMax){
            scoreMax = thisScore;
            bestCell = getBestCell(board[3],board[4],board[5]);
        }
        thisScore = checkScore(board[6],board[7],board[8],symbol);
        if(thisScore > scoreMax){
            scoreMax = thisScore;
            bestCell = getBestCell(board[6],board[7],board[8]);
        }
        //col 1
        thisScore = checkScore(board[0],board[3],board[6],symbol);
        if(thisScore > scoreMax){
            scoreMax = thisScore;
            bestCell = getBestCell(board[0],board[3],board[6]);
        }
        //col 2
        thisScore = checkScore(board[1],board[4],board[7],symbol);
        if(thisScore > scoreMax){
            scoreMax = thisScore;
            bestCell = getBestCell(board[1],board[4],board[7]);
        }

        thisScore = checkScore(board[2],board[5],board[8],symbol);
        if(thisScore > scoreMax){
            scoreMax = thisScore;
            bestCell = getBestCell(board[2],board[5],board[8]);
        }
        //diagonal 1
        thisScore = checkScore(board[0],board[4],board[8],symbol);
        if(thisScore > scoreMax){
            scoreMax = thisScore;
            bestCell = getBestCell(board[0],board[4],board[8]);
        }

        //diagonal2
        thisScore = checkScore(board[2],board[4],board[6],symbol);
        if(thisScore > scoreMax){
            scoreMax = thisScore;
            bestCell = getBestCell(board[2],board[4],board[6]);
        }

        return  bestCell;
    }

    private Cell getBestCell(Cell a, Cell b, Cell cell) {
        return null;
    }

    private int checkScore(Cell cell1, Cell cell2, Cell cell3, char symbol) {
        if(cell1.val == symbol && cell2.val == symbol && cell3.val == symbol)
            return 10;
        if(cell1.opposite(symbol) && cell2.opposite(symbol) && cell3.opposite(symbol) )
            return -10;
        return 0;
    }
}
