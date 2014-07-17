package data.structures.trees;

/**
 * Created by sajit on 7/16/14.
 */
public class CountingBST extends BST {

    public CountingBST(int value) {
        super(value);
        root = new CountTreeNode(value);
    }


    @Override
    protected TreeNode doAdd(TreeNode currentNode, int value,TreeNode parentNode) {
        //System.out.println("In do Add of Counting BST ");
        CountTreeNode cur = (CountTreeNode) currentNode;
        CountTreeNode parent = (CountTreeNode)parentNode;

        if(currentNode == null){
            CountTreeNode newNode = new CountTreeNode(value);
            newNode.parent = parentNode;
            newNode.leftCount = newNode.rightCount = 0;
            return newNode;
        }
        else{
            if(value>currentNode.value){
                cur.right = doAdd(cur.right,value,cur);
                cur.rightCount += 1;
            }
            else if(value<currentNode.value){
                cur.left = doAdd(cur.left,value,cur);
                cur.leftCount +=1;
            }
        }
        return cur;

    }
}
