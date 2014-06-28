package regex;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by skunnumkal on 6/28/14.
 */
public class RegexTests {

    @Test
    public void testPatterns(){
      assertThat(RegexMatcher.isMatch("","")).isTrue();
      assertThat(RegexMatcher.isMatch("abc","")).isFalse();
      assertThat(RegexMatcher.isMatch("abc","abc")).isTrue();

      assertThat(RegexMatcher.isMatch("aaa","a.a")).isTrue();
      assertThat(RegexMatcher.isMatch("aba","a.a")).isTrue();
      assertThat(RegexMatcher.isMatch("aab","a.a")).isFalse();
        assertThat(RegexMatcher.isMatch("aab","...a")).isFalse();

      assertThat(RegexMatcher.isMatch("aa","a*")).isTrue();

        assertThat(RegexMatcher.isMatch("aa","a*a")).isTrue();
        assertThat(RegexMatcher.isMatch("aaa","a*aaaa")).isFalse();
        assertThat(RegexMatcher.isMatch("aaaa","a*aaaa")).isTrue();
        assertThat(RegexMatcher.isMatch("aa","a*b")).isFalse();

        assertThat(RegexMatcher.isMatch("aa","a*b*")).isTrue();
        //assertThat(RegexMatcher.isMatch("aa","a*b*a")).isTrue();
        assertThat(RegexMatcher.isMatch("",".*")).isTrue();
        assertThat(RegexMatcher.isMatch("aaab",".*")).isTrue();
        assertThat(RegexMatcher.isMatch("aaa",".*aa")).isTrue();
        assertThat(RegexMatcher.isMatch("aa","a*b*b")).isFalse();
    }
}
