package data.structures.tries;

import com.google.common.collect.ImmutableList;
import org.junit.Ignore;
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
        dictionary.printDictionary();
    }


    WordRank button = new WordRank("button",20);
    WordRank thai = new WordRank("thai",18);
    WordRank tee = new WordRank("tee",1);
    WordRank tea = new WordRank("tea",15);
    WordRank tep = new WordRank("tep",2);
    WordRank top = new WordRank("top",10);
    @Test
    @Ignore
    public void identifyTop3(){
        insertData();
        dictionary.printDictionary();
        assertThat(dictionary.getTop2At("arse")).isEmpty();
        assertThat(dictionary.getTop2At("b")).isEqualTo(ImmutableList.of(button));

    }

    private void insertData() {

        dictionary.insert(button.word, button.rank);
        dictionary.insert(thai.word,thai.rank);
        dictionary.insert(tee.word,tee.rank);
        dictionary.insert(tea.word,tea.rank);
        dictionary.insert(tep.word,tep.rank);
        dictionary.insert(top.word,top.rank);
    }
}
