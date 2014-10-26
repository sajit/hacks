package strings;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.*;

/**
 * Created by skunnumkal on 10/11/14.
 */
public class WordGraph {

    public static Set<String> dictionary = ImmutableSet.of();
    
    public List<String> link(String startWord,String target){
        Queue<Path> queue = new LinkedList<>();
        queue.add(new Path(startWord,new ArrayList<String>()));
        while(!queue.isEmpty()){
            Path current = queue.poll();
            if(current.word.equals(target)){
                return current.pred;
            }
            List<String> neighbors = getNeighbhors(current.word);
            for(String neighbor : neighbors){
                if(!current.pred.contains(neighbor)){
                    queue.add(new Path(neighbor,whyIlikeScala(current.pred,current.word)));
                }
            }
        }
        return null;
    }

    private List<String> getNeighbhors(String word) {

        return null;
    }

    public static List<String> whyIlikeScala(List<String> aList,String word){
        List<String> result = new ArrayList<>();
        result.addAll(aList);
        result.add(word);
        return result;
    }
}
class Path{
    final public String word;
    final public List<String> pred;
    public Path(String word,List<String> path){
        this.word = word;
        this.pred = path;
    }
}
