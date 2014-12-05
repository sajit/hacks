package l33t;

/**
 * Created by sajit on 10/27/14.
 */
public class DuplicateUtils {

    public static SLLNode removeDuplicates(SLLNode node){
        SLLNode head = node,current = node;

        while(current !=null && current.next != null){

            while(current.next != null && current.val == current.next.val){
                SLLNode nextNode = current.next;
                current.next = nextNode.next;
                nextNode = null;
            }
            current = current.next;


        }


        return head;
    }

    public static void main(String[] args){
        SLLNode a1 = new SLLNode(1);
        //SLLNode a2 = new SLLNode(1);
        //SLLNode a3 = new SLLNode(1);
        //SLLNode a4 = new SLLNode(1);


        SLLNode b1 = new SLLNode(2);
        SLLNode b2 = new SLLNode(3);

        SLLNode c1 = new SLLNode(4);
        SLLNode c2 = new SLLNode(4);
        SLLNode c3 = new SLLNode(4);

        //a1.next = a2; a2.next = a3; a3.next = a4;
        a1.next = b1; b1.next = b2; b2.next = c1; c1.next = c2;
        c2.next = c3;

        SLLNode head = DuplicateUtils.removeDuplicates(a1);
        print(head);
    }

    private static void print(SLLNode node) {
        if(node != null){
            System.out.print(" "+ node.val);
            print(node.next);
        }


    }
}
class SLLNode{
    public int val;
    public SLLNode next;

    public SLLNode(int val){
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString(){
        return "{"+val+"}";
    }
}

