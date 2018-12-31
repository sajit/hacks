package search;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class SearchPath implements Comparable<SearchPath> {

    private List<Pair<Integer,Integer>> path;

    public SearchPath(){
        path = new ArrayList<>();
    }

    public void add(Pair<Integer,Integer> node) {
        path.add(node);
    }

    public Pair<Integer,Integer> getLast() {
        return path.get(path.size()-1);
    }
    public SearchPath(List<Pair<Integer,Integer>> nodes) {
        this.path = nodes;
    }
    public int size() {
        return path.size();
    }

    public List<Pair<Integer,Integer>> getPath() {
        return path;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Pair<Integer,Integer> node : path) {
            sb.append("["+node.getLeft()+","+node.getRight()+"]");
        }
        return sb.toString();
    }

    public SearchPath copy() {
        List<Pair<Integer,Integer>> copy = new ArrayList<>();
        for(Pair<Integer,Integer> node : path) {
            copy.add(new ImmutablePair<>(node.getLeft(),node.getRight()));
        }
        return new SearchPath(copy);
    }

    @Override
    public int compareTo(SearchPath o) {
        if(size()==o.size()){
            for(int i=0;i<o.size();i++){
                int diff = path.get(i).getLeft()-o.getPath().get(i).getLeft();
                if(diff==0){
                    diff = path.get(i).getRight()-o.getPath().get(i).getRight();
                    if(diff==0){
                        continue;
                    }
                    else
                        return diff;
                }
                else return diff;
            }
        }
        else
            return size()-o.size();
        return 0;
    }
}
