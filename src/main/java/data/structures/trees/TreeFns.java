package data.structures.trees;

import fixtures.TreeUtils;

/**
 * Created by sajit on 7/16/14.
 */
public class TreeFns {

    public static final int MOVE_RIGHT = -1;
    public static final int MOVE_LEFT = 1;
    public static int count(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1 + count(node.left) + count(node.right);

    }

    public static int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(height(node.left),height(node.right));
    }

    public static void main(String[] args){
        TreeNode root = TreeUtils.createTree(10);
        System.out.println(TreeFns.height(root));
        System.out.println(TreeFns.count(root));
        System.out.println("++++++++++++++++++++++++");

    }

    public static int median(CountTreeNode node,int keep){
       int decision =node.rightCount - node.leftCount + keep;
       if(decision ==0){
           return node.value;
       }
       else if(decision<0){
           return median((CountTreeNode)node.left,keep+node.rightCount+MOVE_LEFT);
       }
       else{
           return median((CountTreeNode)node.right,keep-node.leftCount+MOVE_RIGHT);
       }
    }
}
