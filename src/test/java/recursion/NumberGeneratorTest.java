package recursion;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by sajit on 4/30/16.
 */
public class NumberGeneratorTest {

    @Test
    public void testPrintCombinations(){
        char[][] matrix = {{'A','B','C','2','*'},
                           {'1','*','*','*','*'},
                           {'P','Q','R','S','7'},
                           {'D','E','F','3','*'}};
        NumberGenerator generator = new NumberGenerator(matrix);
        generator.print("",0);
        assertThat(true).isTrue();
    }
}
