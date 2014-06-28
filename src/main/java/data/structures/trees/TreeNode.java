package data.structures.trees;

/**
 * Created by skunnumkal on 6/28/14.
 */
public class TreeNode {

    public int value;
    public TreeNode left = null,right = null,parent = null;

    public TreeNode(int value){
        this.value = value;
    }

    public boolean isLeaf(){
        return left  == null && right == null;
    }


}
