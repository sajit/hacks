package combinatorial;

import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by sajit on 7/18/14.
 */
public class PandCUtilTest {

    @Test
    public void testPermutations(){

        List<String> result = PAndCUtils.permutations("abc");
        for(String s : result){
            System.out.print(" " +s);
        }
        assertThat(result.size()).isEqualTo(6);
    }

    @Test
    public void nChooseR(){
        List<String> result = PAndCUtils.nCr("abc",2);
        for(String s : result){
            System.out.print(" " + s);
        }
        assertThat(result.size()).isEqualTo(6);
    }
}
