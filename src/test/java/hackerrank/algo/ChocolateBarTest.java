package hackerrank.algo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChocolateBarTest {

    @Test
    public void testPairs1() {
        assertEquals(3,ChocolateBar.divisibleSumPairs(6,5,new int[]{1,2,3,4,5,6}));
        assertEquals(5,ChocolateBar.divisibleSumPairs(6,3,new int[]{1, 3, 2, 6, 1, 2}));
    }
}
