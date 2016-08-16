package data.structures.trees;

/**
 * Created by sajit.kunnumkal on 8/16/2016.
 */
public class AVLTree {
    private AVLTreeNode root;
    /**
     *   a                      b
     *    \                   /   \
     *     b     =>          a     c
     *     	\
     *       c
     * @return
     */
    public AVLTreeNode llRotation(){

        AVLTreeNode a = root;
        AVLTreeNode b = root.right;
        a.right = b.left;
        b.left = a;
        root = b;
        recalculateHeights(root);
        return root;

    }

    /**
     *            a            b
     *           /             /   \
     *         b  =>          c     a
     *     	 /
     *      c
     * @return
     */
    public AVLTreeNode rrRotation() {
       return null;
    }
    private int recalculateHeights(AVLTreeNode node) {
        if(node == null){
            return 0;
        }
        node.ht = Math.max(recalculateHeights(node.left),recalculateHeights(node.right))+1;
        return node.ht;

    }

    public AVLTree(int nodeVal){
        root = new AVLTreeNode();
        root.left = root.right = null;
        root.val = nodeVal;
        root.ht = 1;
    }

    public AVLTreeNode getRoot() {
        return root;
    }

    public AVLTreeNode insert(int nodeVal,AVLTreeNode current){
        if(current == null){
            AVLTreeNode newNode = new AVLTreeNode();
            newNode.ht = 1;
            newNode.val = nodeVal;
            newNode.left = newNode.right = null;
            return newNode;
        }
        if(nodeVal>current.val){
            current.right = insert(nodeVal,current.right);

        }
        else {
            current.left = insert(nodeVal,current.left);
        }
        current.ht = Math.max(current.left != null? current.left.ht : 0, current.right != null? current.right.ht : 0 ) + 1;
        return current;
    }

    public AVLTreeNode heightBalancedInsert(int nodeVal){
        insert(nodeVal,root);
        if(root.getBalanceFactor() == -2){
            return llRotation();
        }
        return root;
    }

    public void printPreOrder(AVLTreeNode node){
        if(node.left != null){
            printPreOrder(node.left);
        }
        System.out.println(node);
        if(node.right != null){
            printPreOrder(node.right);
        }
    }

    public static void main(String[] args){

        AVLTree tree = new AVLTree(5);
        AVLTreeNode root = tree.getRoot();
        tree.printPreOrder(root);

        System.out.println("Inserting...6");
        AVLTreeNode newRoot = tree.heightBalancedInsert(6);

        tree.printPreOrder(newRoot);

        System.out.println("Inserting .. 9");

        AVLTreeNode newRoot2 = tree.heightBalancedInsert(9);

        tree.printPreOrder(newRoot2);
    }
}
