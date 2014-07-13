package data.structures.lists;

/**
 * Created by skunnumkal on 7/11/14.
 */
public class ListNode {

    public int value;
    public ListNode next = null;

    public ListNode(int value){
        this.value = value;
    }

    @Override
    public String toString(){
        return "{"+value+"}";
    }
}
