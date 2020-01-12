package hackerrank.algo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class EmacsCSTest {

    @Test
    public void twoPlusesTestCase1() {
        String[] grid = {
                "GGGGGG",
                "GBBBGB",
                "GGGGGG",
                "GGBBGB",
                "GGGGGG"
        };

        assertEquals(5,EmaCS.twoPluses(grid));
    }

    @Test
    public void getMinPlus() {
        String[] grid = {
                "GGGGGG",
                "GBBBGB",
                "GGGGGG",
                "GGBBGB",
                "GGGGGG"
        };
        Plus minPlus = EmaCS.getMinPlus(2,4,EmaCS.stringArrTo2DCharArr(grid));

        assertEquals(5,minPlus.getArea());
    }

    @Test
    public void plusIntersection() {
        Plus plus1 = new Plus(new Line(new Point(2,3),new Point(2,5)),new Line(new Point(1,4),new Point(3,4)));
        Plus plus2 = new Plus(new Line(new Point(0,0),new Point(0,0)),new Line(new Point(0,0),new Point(0,0)));
        assertFalse(plus1.intersects(plus2));
    }
}
