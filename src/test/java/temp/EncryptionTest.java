package temp;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by sajit on 2/24/15.
 */
public class EncryptionTest {

    @Test
    public void test1Tuples(){

        Tuple tuple = Encryption.calculateMinTuple(54);
        assertThat(tuple.row).isEqualTo(7);
        assertThat(tuple.col).isEqualTo(8);
        Tuple tuple1 = Encryption.calculateMinTuple(100);
        assertThat(tuple1.row).isEqualTo(tuple1.col);

        int textL = "feedthedog".length();
        Tuple textTup = Encryption.calculateMinTuple(textL);
        assertThat(textTup.row).isEqualTo(3);
        assertThat(textTup.col).isEqualTo(4);
    }
}
