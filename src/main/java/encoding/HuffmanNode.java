package encoding;

/**
 * Created by skunnumkal on 7/22/14.
 */
public class HuffmanNode {

    public final int frequency;
    public final String value;
    public String encoding;

    public HuffmanNode left = null,right = null;

    public HuffmanNode(int frequency,String value){
        this.frequency = frequency;
        this.value = value;
    }

    public HuffmanNode(HuffmanNode left,HuffmanNode right){
        this.left = left;
        this.right = right;
        this.frequency = left.frequency+right.frequency;
        this.value = "*";
    }

    @Override
    public String toString(){
        return "{ " + value+":"+frequency+" }";
    }
}
