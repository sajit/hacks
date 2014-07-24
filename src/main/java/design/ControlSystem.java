package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by skunnumkal on 7/24/14.
 */
public class ControlSystem {

    Queue<Message> queue = new LinkedList<Message>();

    public void enQueue(Message message){
        queue.add(message);
    }
}
