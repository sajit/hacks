package data.structures.trees;

import fixtures.TreeUtils;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by skunnumkal on 6/28/14.
 */
public class BSTTests {

    BST bst = new BST(19);
    @Before
    public void setup(){

        bst.add(15);
        bst.add(25);
    }
    @Test
    public void testDelete(){


        bst.delete(19);

        assertThat(bst.find(19)).isNull();
        assertThat(bst.root.value).isEqualTo(25);
        assertThat(bst.find(15)).isNotNull();
    }

    @Test
    public void testCount(){
        assertThat(TreeFns.count(bst.root)).isEqualTo(3);
    }
}
