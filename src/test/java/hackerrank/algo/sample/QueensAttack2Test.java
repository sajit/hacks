package hackerrank.algo.sample;


import hackerrank.algo.queen.attack2.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueensAttack2Test {

    @Test
    public void testNoObstacles() {
        assertEquals(9,Solution.queensAttack(4,0,4,4,new int[0][0]));
        assertEquals(11,Solution.queensAttack(4,0,3,2,new int[0][0]));
        assertEquals(9,Solution.queensAttack(4,0,4,2,new int[0][0]));
        assertEquals(9,Solution.queensAttack(4,0,2,1,new int[0][0]));
        assertEquals(9,Solution.queensAttack(4,0,3,4,new int[0][0]));

        assertEquals(0,Solution.queensAttack(1,0,1,1,new int[0][0]));
    }

    @Test
    public void test3Obstacles() {
        /**
         * 5 3
         4 3
         5 5
         4 2
         2 3
         */
        int[][] obstacles = new int[3][2];
        obstacles[0]= new int[]{5,5};
        obstacles[1] = new int[]{4,2};
        obstacles[2] = new int[]{2,3};
        assertEquals(10,Solution.queensAttack(5,3,4,3,obstacles));
    }


}
