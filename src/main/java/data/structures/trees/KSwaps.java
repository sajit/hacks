package data.structures.trees;

/**
 * Created by sajit on 2/14/15.
 */
public class KSwaps {

    public static void main(String[] args){

        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(7,null,new TreeNode(16)),
                                                        new TreeNode(4)),
                                       new TreeNode(3,null,new TreeNode(5)));

        int[] swapNodes = {4,1,3,2};

        performSwaps(root,swapNodes);
    }

    private static void performSwaps(TreeNode root, int[] swapNodes) {

        for(int node : swapNodes){
            TreeNode findNode = SearchUtils.findNode(root,node);
            if(findNode != null){
                TreeNode temp = findNode.left;
                findNode.left = findNode.right;
                findNode.right = temp;
            }

            SearchUtils.inOrder(root);
            System.out.println("-----------------");
        }

    }
}

