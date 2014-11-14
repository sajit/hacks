package data.structures.tries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajit on 11/11/14.
 */
public class Dictionary {

    WordNode root = new WordNode("");

    public void insert(String word,int rank){
        doInsert(word,rank,0,root);
    }

    public List<WordRank> getTop2At(String word){
        return doGetTop2At(root,word,0);
    }

    private List<WordRank> doGetTop2At(WordNode current, String searchString,int idx) {

        System.out.println(current);
        if(current.prefix.equals(searchString)){
            return current.top2;
        }
        else{
            char ch = searchString.charAt(idx);
            WordNode child = current.children[ch%26];
            if(child == null){
                return new ArrayList<>();
            }
            else{
                return doGetTop2At(child,searchString,idx+1);
            }
        }
    }

    private void doInsert(String word, int rank, int idx, WordNode curNode) {
        if(idx>= word.length()){
            curNode.rank = rank;
            curNode.isCompleteWord = true;
            curNode.insertToTop3(new WordRank(word,rank));
            return;

        }
        char ch = word.charAt(idx);
        WordNode child = curNode.children[ch%26];
        if(child == null){
            child = new WordNode(word.substring(0,idx));
        }
        curNode.children[ch%26] = child;
        curNode.insertToTop3(new WordRank(word,rank));
        doInsert(word, rank, idx + 1, child);
    }

    public boolean isWord(String word){
        return doFind(word,0,root);
    }

    private boolean doFind(String word, int idx, WordNode currentNode) {
        if(idx>= word.length()){
            return currentNode.isCompleteWord;
        }
        char ch = word.charAt(idx);
        WordNode child = currentNode.children[ch%26];
        if(child == null){
            return false;
        }
        else{
            return doFind(word,idx+1,child);
        }
        
    }

    public int countNodes(){
        return doCount(root);

    }

    private int doCount(WordNode current) {
        int sum = 0;
        for(WordNode child : current.children){
            if(child != null){
                sum += doCount(child);
            }
        }
        return 1 + sum;
    }

    public void printDictionary(){
        printNode(root);

    }

    private void printNode(WordNode current) {
        System.out.println(current);
        for(WordNode child : current.children){
            if(child!=null){
                printNode(child);
            }
        }
    }
}
