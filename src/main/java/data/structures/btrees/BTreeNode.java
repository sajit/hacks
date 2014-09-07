package data.structures.btrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by sajit on 9/7/14.
 */
public class BTreeNode {

    private final int maxSize = 3;
    private List<KeyChildPair> keyChildren = new ArrayList<KeyChildPair>();

    public int getSize(){
        return keyChildren.size();
    }
    public BTreeNode rightMost = null;

}
class KeyChildPair implements Comparable<KeyChildPair>{
    private int key;
    private Optional<BTreeNode> child;

    public KeyChildPair(int key,BTreeNode childNode){
        this.key = key;

        this.child = Optional.ofNullable(childNode);


    }


    @Override
    public String toString(){
        int childSize =  (child.isPresent())?child.get().getSize():0;
        return "{"+key+ ", childNodeSize = " +childSize + "}";
    }

    @Override
    public int compareTo(KeyChildPair o) {
        return this.key - o.key;
    }
}
