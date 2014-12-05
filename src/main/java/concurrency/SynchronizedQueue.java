package concurrency;

import data.structures.queues.MyQueue;
import data.structures.queues.MyQueueNode;
import org.apache.commons.lang.math.RandomUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by skunnumkal on 12/5/14.
 */
public class SynchronizedQueue<E> implements MyQueue<E> {

    MyQueueNode<E> head,tail;
    //one way
    @Override
    public synchronized void add(MyQueueNode<E> e) {
        if(tail == null){
            head = tail = e;
            return;
        }
        tail.setNext(e);
        tail = e;
        notifyAll();
    }


   //another way
    @Override
    public MyQueueNode<E> poll() {
        //System.out.println("Here..tail" + tail + " head " + head);
        synchronized (this){
            if(head == null){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            MyQueueNode<E> tbr = head;
            if(head == tail){
                tail = null;
            }
            head = head.getNext();
            return tbr;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MyQueue<Integer> aQueue = new SynchronizedQueue<>();

        AThread t1 = new AThread(aQueue,1);

        t1.start();
        /**
         * Adding a sleep here will force main thread to sleep for 2 secs. By this time t1 would have
         * tried to poll twice and failed as you are only waiting for 10 ms
         */
        Thread.sleep(2000);
        AThread t2 = new AThread(aQueue,3);



        t2.start();

        System.out.println("********");
    }

}
class AThread extends Thread{
    private MyQueue queue;
    private String name;
    private final int count;
    public AThread(MyQueue queue,int count){
        this.queue = queue;
        this.name = UUID.randomUUID().toString();
        this.count = count;
    }

    private void add(MyQueueNode xy){
        System.out.println("Adding " + xy + " to  Thread " + this.name );
        this.queue.add(xy);
    }

    private MyQueueNode poll(){
        return this.queue.poll();
    }

    @Override
    public void run() {

       for(int i=0;i<count;i++){
           this.add(new MyQueueNode(RandomUtils.nextInt(1000)));
       }

       MyQueueNode result = this.poll();
       System.out.println("Polling in Thread " + name + " ; Result = " + result);
       System.out.println("Polling in Thread " + name + " ; Result = " + this.poll());
    }
}
