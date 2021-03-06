package data.structures.trees;


import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by skunnumkal on 6/28/14.
 */
public class BST {

    public TreeNode root;

    public BST(int value){
        root = new TreeNode(value);
    }

    public void add(int value){
        doAdd(root,value,null);
    }



    protected TreeNode doAdd(TreeNode currentNode, int value,TreeNode parentNode) {
        if(currentNode == null){
            TreeNode newNode = new TreeNode(value);
            newNode.parent = parentNode;
            return newNode;
        }
        else{
            if(value>currentNode.value){
                currentNode.right = doAdd(currentNode.right,value,currentNode);
            }
            else if(value<currentNode.value){
                currentNode.left = doAdd(currentNode.left,value,currentNode);
            }
        }
        return currentNode;
    }

    public TreeNode find(int value){
        return doFind(root,value);
    }

    private TreeNode doFind(TreeNode currentNode, int value) {
        if(currentNode == null){
            return null;
        }
        else{
            if(currentNode.value == value){
                return currentNode;
            }
            else if(currentNode.value > value){
                return doFind(currentNode.left,value);
            }
            else{
                return doFind(currentNode.right,value);
            }
        }
    }

    public void delete(int value){
        TreeNode aNode = find(value);
        if(aNode != null){
            doDelete(aNode);
        }

    }

    private void doDelete(TreeNode node) {
        if(node.isLeaf()){
            if(isLeftChild(node)){
                node.parent.left = null;
            }
            else{
                node.parent.right = null;
            }

            node = null;
        }
        else if(node.left == null){
            TreeNode rightChild = node.right;
            if(isLeftChild(node)){
                node.parent.left = rightChild;
            }
            else{
                node.parent.right = rightChild;
            }
            rightChild.parent = node.parent;
            node = null;

        }
        else if(node.right == null){
            TreeNode leftChild = node.left;
            if(isLeftChild(node)){
                node.parent.left = leftChild;
            }
            else{
                node.parent.right = leftChild;
            }
            leftChild.parent = node.parent;
            node = null;
        }
        else{
            //has two children
            TreeNode smallest = findSmallest(node.right);
            node.value = smallest.value;
            smallest = null;
        }



    }

    public TreeNode findSmallest(TreeNode currentRoot) {
        TreeNode cur = currentRoot;
        while(cur.left != null){
            cur = cur.left;
        }
        return cur;
    }


    private boolean isLeftChild(TreeNode aNode) {
        return aNode.value < aNode.parent.value;
    }


    public int findNthLargest(TreeNode node,int n){
        Pair<TreeNode,Integer> pair = findLargest(node);
        if(n>=0){

            return pair.getRight();
        }
        if(pair.getRight()==node.value) { //root is biggest value, next consider left branch
           node = node.left;
        }
        else
            node.right = pair.getLeft();
        return findNthLargest(node,n-1);
    }

    private Pair<TreeNode, Integer> findLargest(TreeNode node) {
        while(node!= null && node.right!=null){
            return findLargest(node.right);
        }
        return new ImmutablePair<>(node.left,node.value);
    }


}
