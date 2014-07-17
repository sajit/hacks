package data.structures.trees;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by skunnumkal on 7/17/14.
 */
public class CountingBSTTest {

    Random rand = new Random();
    final int rootVal = 56;
    CountingBST cBst = new CountingBST(rootVal);
    @Before
    public void setup(){
        int count = 0;
        while(count<10){
            int val = rand.nextInt(2*rootVal);
            System.out.println("Inserting " +val);
            cBst.add(val);
            count++;
        }
    }
    @Test
    public void addKeepTrackOFcount(){
        CountTreeNode cRoot = (CountTreeNode)cBst.root;
        int count =cRoot.leftCount + cRoot.rightCount;
        System.out.println("Left Count " + cRoot.leftCount +  " Right Count : " + cRoot.rightCount);
        assertThat(count).isGreaterThan(5);
    }

    @Test
    public void getMedian(){
        CountTreeNode cRoot = (CountTreeNode)cBst.root;
        System.out.println(TreeFns.median(cRoot,0));
    }
}
