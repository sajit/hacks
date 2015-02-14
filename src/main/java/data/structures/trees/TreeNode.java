package data.structures.trees;

/**
 * Created by skunnumkal on 6/28/14.
 */
public class TreeNode {

    public int value;
    public boolean visited = false;
    public TreeNode left = null,right = null,parent = null;

    public TreeNode(int value){
        this.value = value;
    }

    public boolean isLeaf(){
        return left  == null && right == null;
    }

    @Override
    public String toString(){
        return "{"+value+" ;visited?"+visited+"}";
    }

    public TreeNode[] getChildren() {
        return new TreeNode[]{left,right};
    }

    public TreeNode(int value,TreeNode left,TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
