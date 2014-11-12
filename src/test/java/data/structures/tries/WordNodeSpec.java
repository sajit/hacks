package data.structures.tries;

import org.junit.Test;
import static org.fest.assertions.Assertions.*;

/**
 * Created by sajit on 11/12/14.
 */
public class WordNodeSpec {

    Dictionary dictionary = new Dictionary();
    @Test
    public void insertAndFind(){
        dictionary.insert("tower",56);
        assertThat(dictionary.isWord("tower")).isTrue();
        assertThat(dictionary.isWord("geo")).isFalse();
    }
}
