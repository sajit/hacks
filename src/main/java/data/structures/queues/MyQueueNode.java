package data.structures.queues;

/**
 * Created by skunnumkal on 12/5/14.
 */
public class MyQueueNode<E> {
    private MyQueueNode<E> next = null;
    E value;
    public MyQueueNode(E value){
        this.value = value;
    }

    public void setNext(MyQueueNode nextNode){
        this.next = nextNode;
    }

    public MyQueueNode<E> getNext(){
        return this.next;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
