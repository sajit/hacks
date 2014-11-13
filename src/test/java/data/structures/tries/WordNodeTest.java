package data.structures.tries;

import org.junit.Test;
import static org.fest.assertions.Assertions.*;

/**
 * Created by sajit on 11/12/14.
 */
public class WordNodeTest {

    Dictionary dictionary = new Dictionary();
    @Test
    public void insertAndFind(){
        dictionary.insert("tower",56);
        assertThat(dictionary.isWord("tower")).isTrue();
        assertThat(dictionary.isWord("geo")).isFalse();
        assertThat(dictionary.isWord("towe")).isFalse();
    }

    @Test
    public void countNodes(){
        dictionary.insert("tower",56);
        dictionary.insert("tea",34);
        dictionary.insert("yeshu",1);
        assertThat(dictionary.countNodes()).isEqualTo(13);
    }
}
