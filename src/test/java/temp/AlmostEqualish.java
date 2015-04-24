package temp;

import org.junit.Ignore;
import org.junit.Test;
import static org.fest.assertions.Assertions.assertThat;


/**
 * Created by sajit on 2/19/15.
 */
public class AlmostEqualish {

    @Test
    public void testCalculateScore1() {

        assertThat(AlmostEqual.calculatePairs(3)).isEqualTo(2);

        assertThat(AlmostEqual.calculatePairs(-1)).isEqualTo(0);

    }

    @Test
    public void testFindMax1(){
        int[] inp = { 0,1,3,3,4};
       //assertThat(AlmostEqual.performBS(inp,1,inp.length-1,2,0)).isEqualTo(2);
        //assertThat(AlmostEqual.performBS(inp,1,inp.length-1,3,0)).isEqualTo(4);
        assertThat(AlmostEqual.findMaxValueWithinRange(inp,1,2)).isEqualTo(2);
        assertThat(AlmostEqual.findMaxValueWithinRange(inp,1,3)).isEqualTo(4);
    }

    @Test
    public void testFindMax2(){
        int[] inp = {2,5,6,8,13};
        assertThat(AlmostEqual.findMaxValueWithinRange(inp, 1, 4)).isEqualTo(1);
        assertThat(AlmostEqual.findMaxValueWithinRange(inp,1,15)).isEqualTo(5);
    }

    @Test
    public void findCombos() {
        int[] inp = {2, 5, 6, 8, 13};
        AlmostEqual.findCombos(inp,5);
    }
}
