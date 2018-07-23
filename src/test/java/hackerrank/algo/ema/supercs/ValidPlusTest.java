package hackerrank.algo.ema.supercs;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidPlusTest {

    @Test
    public void testHLAndVL() {
        char[][] gridC = {
            {'G','G','G','G'},
            {'B','G','G','B'},
            {'G','B','G','B'},
            {'G','B','B','B'},
            {'G','G','G','B'}
        };
        Map<Integer,List<Line>> horizontalLines = ValidPlus.getHL(gridC);
        assertEquals(2,horizontalLines.size());
        assertEquals(3,horizontalLines.get(1).size());
        assertEquals(1,horizontalLines.get(3).size());
        Map<Integer,List<Line>> verticalLines = ValidPlus.getVL(gridC);
        assertEquals(1,verticalLines.size());
        assertEquals(2,verticalLines.get(3).size());


    }

    @Test
    public void validPlusShape() {
        Line line1 = new Line(new Point(0,0),new Point(0,0));
        assertTrue(ValidPlus.formsValidPlus(line1,line1));
        line1 = new Line(new Point(2,0),new Point(2,4));
        Line line2 = new Line(new Point(0,1),new Point(4,1));
        assertFalse(ValidPlus.formsValidPlus(line1,line2));
        line2 = new Line(new Point(0,2),new Point(4,2));
        assertTrue(ValidPlus.formsValidPlus(line1,line2));
    }

    @Test
    public void testArea() {
        String[] grid = {
                "GGGG","BGGB","GBGB","GBBB","GGGB"
        };
        assertEquals(1,ValidPlus.twoPluses(grid));
    }

    @Test
    public void testArea1() {
        String[] grid = {
                "GGGGGG", "GBBBGB", "GGGGGG", "GGBBGB", "GGGGGG"

        };
        assertEquals(5,ValidPlus.twoPluses(grid));
    }

    @Test
    public void testLineSegIntersection() {
        Line line1 = new Line(new Point(1,4),new Point(3,4));
        Line line2 = new Line(new Point(2,3), new Point(2,5));
        assertTrue(line1.intersects(line2));
        line1 = new Line(new Point(1,6),new Point(3,6));
        assertFalse(line1.intersects(line2));


    }

    @Test
    public void testVLineSegIntersection() {
        Line line1 = new Line(new Point(1,4),new Point(3,4));
        Line line2 = new Line(new Point(2,4), new Point(3,4));
        assertTrue(line1.intersects(line2));


    }
}
