package data.structures.lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by skunnumkal on 7/11/14.
 */
public class RemoveDuplicates {

    public static void removeDupes(ListNode head){
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            while(next != null && next.value == cur.value){
                next = next.next;
            }
            cur.next = next;
            cur = next;
        }

    }

    public static void main(String[] args){
        Random r = new Random();
        ListNode[] aList = new ListNode[20];
        for(int i=0;i<20;i++){
            aList[i] = new ListNode(Math.abs(r.nextInt())%7);
        }
        Arrays.sort(aList,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.value - o2.value;
            }
        });
        ListNode head = convertToList(aList);
        printArray(head);
        System.out.println();
        RemoveDuplicates.removeDupes(head);

        printArray(head);
    }

    private static void printArray(ListNode aNode) {
        ListNode current = aNode;
        while(current != null){
            System.out.print(" " + current);
            current = current.next;
        }
    }

    private static ListNode convertToList(ListNode[] anArray) {
        ListNode head = new ListNode(anArray[0].value);
        ListNode cur = head;
        for(int i=1;i<anArray.length;i++){
            ListNode next = new ListNode(anArray[i].value);
            cur.next = next;
            cur = next;
        }
        return head;
    }
}
