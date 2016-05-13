package bai.tictactoe;

/**
 * Created by sajit on 5/12/16.
 */
public class TicTacToeBoard {

    private TicTacToeCell[] board;

    public TicTacToeBoard(){
        board = new TicTacToeCell[9];
        board[0] = new TicTacToeCell(3);
        board[1] = new TicTacToeCell(2);
        board[2] = new TicTacToeCell(3);
        board[3] = new TicTacToeCell(2);
        board[4] = new TicTacToeCell(4);
        board[5] = new TicTacToeCell(2);
        board[6] = new TicTacToeCell(3);
        board[7] = new TicTacToeCell(2);
        board[8] = new TicTacToeCell(3);

    }

    public void markCell(int idx,char c){
        board[idx].val = c;
    }
}
