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

      String x = "add";
      String y=   x.intern();
      System.out.println(y);
    }

    @Test
    public void pooling(){
        String s = "ab"+"c";
        String t = "a"+"bc";
        assertThat(s==t).isTrue();
        assertThat(s.equals(t)).isTrue();

        String ns = new String("ab"+"c");
        String nt = new String("a"+"bc");
        assertThat(ns == nt).isFalse();
        assertThat(ns.equals(nt)).isTrue();
    }


}
