package data.structures.tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sajit on 11/11/14.
 */
public class WordNode {

    final String prefix;
    boolean isCompleteWord;
    int rank;
    WordNode[] children = new WordNode[26];
    List<WordRank> top2 = new ArrayList<>();
    public WordNode(String prefix){
        this.prefix = prefix;
        this.isCompleteWord = isCompleteWord;
        this.rank = rank;

    }

    @Override
    public String toString(){
        return prefix;
    }

    public void insertToTop3(WordRank wordRank){
        top2.add(wordRank);
        Collections.sort(top2);
        if(top2.size()>2){
             top2.remove(2);
        }
    }



}
class WordRank implements Comparable<WordRank>{
  public final String word;
  public final int rank;

    public WordRank(String word,int rank){
        this.word = word; this.rank = rank;

    }
    @Override
    public boolean equals(Object o){
        if(!(o instanceof WordRank)){
            return false;
        }
        WordRank that = (WordRank)o;
        return that.word.equals(word) && that.rank == rank;
    }

    @Override
    public int hashCode(){
        return rank*10+ word.hashCode();
    }
    @Override
    public int compareTo(WordRank o) {
          return o.rank - rank;
    }
}
