package data.structures.queues;

/**
 * Created by skunnumkal on 12/5/14.
 */
public interface  MyQueue<E> {

    MyQueueNode<E> poll();
    void add(MyQueueNode<E> e);
}
