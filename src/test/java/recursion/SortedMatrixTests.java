package recursion;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by skunnumkal on 7/7/14.
 */
public class SortedMatrixTests {


    int[][] matrix = {{2,3,5,6,9},{3,4,7,8,10},{5,6,10,12,13}};
    @Test
     public void testFind1(){

        assertThat(SortedMatrix.find(matrix,7)).isTrue();
    }

    @Test
    public void testFind2(){

        assertThat(SortedMatrix.find(matrix,8)).isTrue();
    }

    @Test
    public void testFind3(){

        assertThat(SortedMatrix.find(matrix,5)).isTrue();
        assertThat(SortedMatrix.find(matrix,6)).isTrue();
    }

    @Test
    public void testFind4(){

        assertThat(SortedMatrix.find(matrix,13)).isTrue();
    }

    @Test
    public void testFind5(){

        assertThat(SortedMatrix.find(matrix,1)).isFalse();
        assertThat(SortedMatrix.find(matrix,11)).isFalse();
    }


}
