package data.structures.trees;

import fixtures.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by skunnumkal on 7/14/14.
 */
public class SearchUtils {

    public static void DFS(TreeNode node){
        init(node);
        for(TreeNode child : node.getChildren()){
            if(child!= null && !child.visited){
                DFS(child);
            }
        }

    }

    public static void inOrder(TreeNode node){
        if(node.left != null){
            inOrder(node.left);
        }
        System.out.println(node.value);
        if(node.right != null){
            inOrder(node.right);
        }
    }

    private static void init(TreeNode node) {
        if(node ==null){
            throw new IllegalArgumentException("Null node");
        }
        processNode(node);
    }

    public static void BFS(TreeNode node){
        if(node ==null){
            throw new IllegalArgumentException("Null node");
        }
        Queue<TreeNode> aQueue = new LinkedList<TreeNode>();
        aQueue.add(node);
        while(!aQueue.isEmpty()){
           TreeNode cur = aQueue.poll();
            processNode(cur);
            for(TreeNode child : cur.getChildren()){
                if(child != null && !child.visited){
                    aQueue.add(child);
                }
            }
        }
    }

    private static void processNode(TreeNode aNode) {
        aNode.visited = true;
        System.out.println(aNode);
    }


    public static void main(String[] args){
        TreeNode root = TreeUtils.createTree(10);
        DFS(root);
        reset(root);
        System.out.println("------------------");
        BFS(root);
    }

    private static void reset(TreeNode node) {
        node.visited = false;
        if(node.left != null){
            reset(node.left);
        }
        if(node.right != null){
            reset(node.right);
        }
    }

    public static TreeNode findNode(TreeNode currentNode,int value) {
        TreeNode result = null;
        if(currentNode.value == value){
            result = currentNode;
        }
        if(result == null && currentNode.left != null){
            result = findNode(currentNode.left,value);

        }
        if(result == null && currentNode.right != null){
            result = findNode(currentNode.right,value);
        }
        return result;
    }
}
