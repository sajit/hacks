package data.structures.trees;


public class AVLTreeNode {
    public int val;   //Value
    public int ht;      //Height
    public AVLTreeNode left;   //Left child
    public AVLTreeNode right;   //Right child

    @Override
    public String toString() {
        return "{val:"+val+",ht:"+ht+",bf"+ getBalanceFactor()+  " }";
    }

    public int getBalanceFactor() {
        int leftHeight = (left == null)? 0 : left.ht;
        int rightHeight = (right == null)? 0 : right.ht;
        return leftHeight - rightHeight;
    }

}
