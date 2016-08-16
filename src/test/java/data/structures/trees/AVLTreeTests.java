package data.structures.trees;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AVLTreeTests {

    @Test
    public void testHeights(){
        AVLTree aTree = new AVLTree(5);
        assertEquals(0, aTree.getRoot().getBalanceFactor());
        assertEquals(1,aTree.getRoot().ht);
        AVLTreeNode newNode = aTree.heightBalancedInsert(6);
        assertEquals(2,newNode.ht);
        assertEquals(-1,newNode.getBalanceFactor());

        newNode = aTree.heightBalancedInsert(8);
        assertEquals(6,newNode.val);
        assertEquals(2,newNode.ht);
        assertEquals(5,newNode.left.val);
        assertEquals(0,newNode.getBalanceFactor());
        assertEquals(0,newNode.left.getBalanceFactor());
        assertEquals(newNode.right.ht,newNode.left.ht);
        assertEquals(8,newNode.right.val);
    }
}
