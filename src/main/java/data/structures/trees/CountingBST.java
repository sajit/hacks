package data.structures.trees;

/**
 * Created by sajit on 7/16/14.
 */
public class CountingBST extends BST {
    CountTreeNode root;
    public CountingBST(int value) {
        super(value);
        root = new CountTreeNode(value);
    }
}
