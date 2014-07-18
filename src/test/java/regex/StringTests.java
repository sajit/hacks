package regex;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by sajit on 7/18/14.
 */
public class StringTests {

    @Test
    public void javaSubStringing(){
      String a = "ad";
      assertThat(a.substring(0,0)).isEqualTo("");
      assertThat(a.substring(2)).isEqualTo("");
      assertThat(a.substring(1)).isEqualTo("d");
    }
}
