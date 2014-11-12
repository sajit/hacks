package data.structures.tries;

/**
 * Created by sajit on 11/11/14.
 */
public class Dictionary {

    WordNode root = new WordNode("");

    public void insert(String word,int rank){
        doInsert(word,rank,0,root);
    }

    private void doInsert(String word, int rank, int idx, WordNode curNode) {
        if(idx>= word.length()){
            curNode.rank = rank;
            curNode.isCompleteWord = true;
            return;

        }
        char ch = word.charAt(idx);
        WordNode child = curNode.children[ch%26];
        if(child == null){
            child = new WordNode(word.substring(0,idx));
        }
        curNode.children[ch%26] = child;
        doInsert(word,rank,idx+1,child);
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
}
