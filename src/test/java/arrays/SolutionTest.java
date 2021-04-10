package arrays;

import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void singleElArray() {
        int[][] image = {{0}};
        Assert.assertEquals(ImmutableList.of(0,0,0,0),Solution.getRectangle(image));
    }

    @Test
    public void inTheMiddleArray() {
        int[][] image = {{1,1,1,1,1},{1,1,0,0,1},{1,1,0,0,1},{1,1,1,1,1}};
        Assert.assertEquals(ImmutableList.of(1,2,2,3),Solution.getRectangle(image));
    }

    @Test
    public void rightEdgeArray() {
        int[][] image = {{1,1,1,1,1},{1,1,1,1,0}};
        Assert.assertEquals(ImmutableList.of(1,4,1,4),Solution.getRectangle(image));
    }

    @Test
    public void lowerRightArray() {
        int[][] image = {{1,1,1,1,1},{1,1,0,0,0},{1,1,0,0,0}};
        Assert.assertEquals(ImmutableList.of(1,2,2,4),Solution.getRectangle(image));
    }
}
