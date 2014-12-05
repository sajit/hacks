package regex;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
      assertThat(a.substring(0,1)).isEqualTo("a");

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

    @Test
    public void testRegex(){
       String cookie = "_ga=GA1.3.945712263.1403671701; _ga=GA1.2.945712263.1403671701; sid=965200ff-2ed0-4d1c-bb75-5d042a61c1ff";
       String sidKey = StringUtils.substringAfter(cookie,"sid=");
       int index = sidKey.indexOf(" ");
       String token = sidKey;
       if(index>=0){
           token = sidKey.substring(0,index);
       }
       assertThat(token).isEqualTo("965200ff-2ed0-4d1c-bb75-5d042a61c1ff");
        //assertThat(cookie.subSequence(cookie.indexOf("sid=")+4)).isEqualTo("965200ff-2ed0-4d1c-bb75-5d042a61c1ff");
    }

    @Test
    public void testRegex2(){
        String cookie = " _ga=GA1.2.945712263.1403671701; sid=965200ff-2ed0-4d1c-bb75-5d042a61c1ff _ga=GA1.3.945712263.1403671701;";
        String sidKey = StringUtils.substringAfter(cookie,"sid=");
        int index = sidKey.indexOf(" ");
        String token = sidKey;
        if(index>=0){
            token = sidKey.substring(0,index);
        }
        assertThat(token).isEqualTo("965200ff-2ed0-4d1c-bb75-5d042a61c1ff");
        //assertThat(cookie.subSequence(cookie.indexOf("sid=")+4)).isEqualTo("965200ff-2ed0-4d1c-bb75-5d042a61c1ff");
    }


}
