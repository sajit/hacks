package data.structures.tries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajit on 11/11/14.
 */
public class WordNode {

    final String prefix;
    final boolean isCompleteWord;
    final int rank;
    WordNode[] children = new WordNode[26];
    List<String> top3 = new ArrayList<>();
    public WordNode(String prefix,boolean isCompleteWord,int rank){
        this.prefix = prefix;
        this.isCompleteWord = isCompleteWord;
        this.rank = rank;

    }

    @Override
    public String toString(){
        return prefix;
    }



}
