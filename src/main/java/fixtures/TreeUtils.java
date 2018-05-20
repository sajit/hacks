package fixtures;

import data.structures.trees.BST;
import data.structures.trees.TreeNode;

import java.util.Random;

/**
 * Created by skunnumkal on 7/16/14.
 */
public class TreeUtils {

    public static TreeNode createTree(int nodeCount){
        return makeBST(nodeCount).root;
    }

    private static BST makeBST(int nodeCount) {
        Random rand = new Random();
        int count = 1, rootValue = rand.nextInt(nodeCount*2);
        BST aBst = new BST(rootValue);
        System.out.println("Root" + rootValue);
        while(count<=nodeCount){
            int value = rand.nextInt(nodeCount*2);
            System.out.println("Adding " + value);
            aBst.add(value);
            count++;
        }
        return aBst;
    }

    public static BST createBST(int nodeCount){
        return makeBST(nodeCount);
    }
}
