package hackerrank.algo;

import java.util.Objects;

public class GridCell {

    public final int x,y;

    public char ch;

    public GridCell(int x,int y){
        this.x = x;
        this.y = y;
    }



    @Override
    public String toString() {
        return x+"|"+y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridCell gridCell = (GridCell) o;
        return x == gridCell.x &&
                y == gridCell.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }
}
