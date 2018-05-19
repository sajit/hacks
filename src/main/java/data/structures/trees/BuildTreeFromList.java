package data.structures.trees;

import java.util.Arrays;
import java.util.List;

/**
 * Create a tree from an inordered and preordered list
 */
public class BuildTreeFromList {

    public void buildTree(List<Integer> inOrder, List<Integer> preOrder, TreeNode currentRoot,TreeNode treeRoot) {
        if(preOrder.isEmpty()){
            return;
        }
        TreeNode currentNode = new TreeNode(preOrder.get(0));
        int currentRootIdx = getIndex(inOrder,currentRoot);
        int currentNodeIdx = getIndex(inOrder,currentNode);
        if(currentNodeIdx<currentRootIdx){
            currentRoot.left = currentNode;
        }
        else {
            int parentVal = getRightMostNodeLessThan(inOrder,preOrder,currentNode);
            TreeNode parentNode = getNode(treeRoot,parentVal);
            parentNode.right = currentNode;

        }

        buildTree(inOrder,preOrder.subList(1,preOrder.size()),currentNode,treeRoot);

    }

    private TreeNode getNode(TreeNode currentNode, int nodeVal) {
        if(currentNode==null) return null;
        if(currentNode.value==nodeVal){
            return currentNode;
        }
        TreeNode node = getNode(currentNode.left,nodeVal);
        if(node==null){
            node = getNode(currentNode.right,nodeVal);
        }
        return node;
    }

    private int getRightMostNodeLessThan(List<Integer> inOrder, List<Integer> preOrder, TreeNode node) {

        int nodeIdx=getIndex(inOrder,node);
        int i;
        for(i=0;i<nodeIdx && !preOrder.contains(inOrder.get(i));i++);
        return inOrder.get(i-1);
    }

    private int getIndex(List<Integer> inOrder, TreeNode node) {
        for(int i=0;i<inOrder.size();i++){
            if(node.value == inOrder.get(i)){
                return i;
            }
        }
        throw new RuntimeException("bad_data");
    }

    public static void main(String[] args) {
        List<Integer> inOrderList = Arrays.asList(10,5,2,9,11,1,7,6,8);
        List<Integer> preOrderList = Arrays.asList(1,2,5,10,9,11,6,7,8);
        TreeNode root = new TreeNode(preOrderList.get(0));
        BuildTreeFromList buildTreeFromList = new BuildTreeFromList();
        buildTreeFromList.buildTree(inOrderList,preOrderList.subList(1,preOrderList.size()),root,root);
        SearchUtils.inOrder(root);

    }


}
