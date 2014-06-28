package data.structures.trees;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by skunnumkal on 6/28/14.
 */
public class BSTTests {

    @Test
    public void testDelete(){
        BST bst = new BST(19);
        bst.add(15);
        bst.add(25);

        bst.delete(19);

        assertThat(bst.find(19)).isNull();
        assertThat(bst.root.value).isEqualTo(25);
        assertThat(bst.find(15)).isNotNull();
    }
}
