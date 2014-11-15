package data.structures.tries;

import com.google.common.collect.ImmutableList;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

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
        //dictionary.printDictionary();
        assertThat(dictionary.countNodes()).isEqualTo(13);
        assertThat(dictionary.isWord("tower")).isTrue();
        assertThat(dictionary.isWord("tea")).isTrue();
        assertThat(dictionary.isWord("yeshu")).isTrue();
        assertThat(dictionary.isWord("yeshy")).isFalse();

    }


    WordRank button = new WordRank("button",20);
    WordRank thai = new WordRank("thai",18);
    WordRank tee = new WordRank("tee",1);
    WordRank tea = new WordRank("tea",15);
    WordRank tep = new WordRank("tep",2);
    WordRank top = new WordRank("top",10);


    @Test
    public void identifyTop3(){
        insertData();
        //dictionary.printDictionary();
        assertThat(dictionary.getTop2At("arse")).isEmpty();
        assertThat(dictionary.getTop2At("b")).isEqualTo(ImmutableList.of(button));
        assertThat(dictionary.getTop2At("bu")).isEqualTo(ImmutableList.of(button));
        assertThat(dictionary.getTop2At("but")).isEqualTo(ImmutableList.of(button));
        assertThat(dictionary.getTop2At("butt")).isEqualTo(ImmutableList.of(button));
        assertThat(dictionary.getTop2At("butto")).isEqualTo(ImmutableList.of(button));
        assertThat(dictionary.getTop2At("button")).isEqualTo(ImmutableList.of(button));
        assertThat(dictionary.getTop2At("buttons")).isEmpty();
    }

    @Test
    public void identifyTop3_1(){
        insertData();
        List<WordRank> expected = ImmutableList.of(tea,thai);
        List<WordRank> result = dictionary.getTop2At("t");
        assertThat(result.size()).isEqualTo(2);
        for(WordRank wordRank : result){
            assertThat(expected.contains(wordRank)).isTrue();
        }


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
