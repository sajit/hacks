package recursion;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by sajit on 7/8/14.
 */
public class SequenceContainsTest {

    @Test
    public void testContains(){
       String search = "rabbi";
       String target = "rrabbbit";

       assertThat(SequenceContains.contains(search,target)).isTrue();
    }

    @Test
    public void testNotContains(){
        String search = "arbbi";
        String target = "rrabbbit";

        assertThat(SequenceContains.contains(search,target)).isFalse();
    }
}
