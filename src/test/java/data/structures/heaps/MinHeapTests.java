package data.structures.heaps;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by sajit on 7/19/14.
 */
public class MinHeapTests {
    MinHeap minHeap = new MinHeap(10);
    @Test
    public void insertShouldBubbleUp(){

        minHeap.insert(16);
        minHeap.insert(42);
        minHeap.insert(5);

        assertThat(minHeap.findMin()).isEqualTo(5);

    }

    @Test
    public void bubbleMultipleUp(){
        minHeap.insert(9);
        minHeap.insert(34);
        minHeap.insert(68);
        minHeap.insert(97);
        minHeap.insert(38);
        minHeap.insert(5);

        assertThat(minHeap.findMin()).isEqualTo(5);
    }

    @Test
    public void bubbleDown(){
        minHeap.insert(3);minHeap.insert(71);minHeap.insert(9);minHeap.insert(75);minHeap.insert(87);
        minHeap.insert(75);minHeap.insert(80);

        minHeap.deleteMin();

        assertThat(minHeap.findMin()).isEqualTo(9);

        minHeap.printHeap();
        minHeap.deleteMin();
        assertThat(minHeap.findMin()).isEqualTo(71);
        minHeap.printHeap();
    }
}
