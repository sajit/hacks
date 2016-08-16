package bai.tictactoe;

/**
 * Created by sajit on 5/12/16.
 */
public class TicTacToeBoard {

    private Cell[] board;

    public TicTacToeBoard(){
        board = new Cell[9];
        board[0] = new Cell(3);
        board[1] = new Cell(2);
        board[2] = new Cell(3);
        board[3] = new Cell(2);
        board[4] = new Cell(4);
        board[5] = new Cell(2);
        board[6] = new Cell(3);
        board[7] = new Cell(2);
        board[8] = new Cell(3);

    }

    public void markCell(int idx,char c){
        board[idx].val = c;
    }
}
