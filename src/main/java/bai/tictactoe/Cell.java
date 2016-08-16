package bai.tictactoe;

/**
 * Created by sajit on 5/12/16.
 */
public class Cell {
    public char val = '-';
    final public int imp;

    public Cell(int imp){
        this.imp = imp;
    }

    public boolean opposite(char sym){
        return val != '-' && val != sym;

    }
}
