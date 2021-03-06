package encoding;

import com.google.common.collect.ImmutableList;

import java.util.List;



/**
 * Created by skunnumkal on 7/22/14.
 */
public class HuffmanUtil {

    /**
     * For now assume that the freqMap is sorted
     * TODO add logic to sort it
     * @param freqMap
     * @return
     */
    public static HuffmanNode buildHuffmanTree(List<FrequencyMap> freqMap){


        FrequencyMap small1 = freqMap.get(0);
        FrequencyMap small2 = freqMap.get(1);
        HuffmanNode node1 = new HuffmanNode(small1.frequency.intValue(),String.valueOf(small1.character));
        HuffmanNode node2 = new HuffmanNode(small2.frequency.intValue(),String.valueOf(small2.character));
        HuffmanNode combo = new HuffmanNode(node1,node2);
        for(int i=2;i<freqMap.size();i++){
            FrequencyMap current = freqMap.get(i);
            HuffmanNode cur = new HuffmanNode(current.frequency.intValue(),String.valueOf(current.character));
            combo = new HuffmanNode(cur,combo);
        }
        return combo;

    }

    public static String encode(String target,HuffmanNode root){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<target.length();i++){
            char ch = target.charAt(i);
            sb.append(getEncoding(String.valueOf(ch),root));
        }
        return sb.toString();

    }

    public static String decode(String encoded,HuffmanNode node,HuffmanNode root){




        StringBuffer sb = new StringBuffer();
        doDecode(node,encoded,sb,root);



        return sb.toString();
    }

    private static void doDecode(HuffmanNode node, String encoded, StringBuffer sb,HuffmanNode root) {
        //System.out.println("StringBuffer so far " + sb.toString());
        //System.out.println("Current node " + node);
        //System.out.println("Encoded.." + encoded);
        if(node.left == null && node.right == null){
            sb.append(node.value);
            doDecode(root,encoded,sb,root);
        }
        if(encoded.isEmpty()){
            return;
        }
        String head = String.valueOf(encoded.charAt(0));
        if(head.equals("0") && node.left != null){
            doDecode(node.left,encoded.substring(1),sb,root);
        }
        if(head.equals("1") && node.right != null){
            doDecode(node.right,encoded.substring(1),sb,root);
        }
    }

    private static String getEncoding(String ch, HuffmanNode root) {
        return doGetEncoding(ch,root,"");

    }

    private static String doGetEncoding(String ch, HuffmanNode huffmanNode, String prefix) {

        if(huffmanNode.left.value.equals(ch)){
            return prefix+"0";
        }
        else if(huffmanNode.right.value.equals(ch)){
            return  prefix+"1";
        }
        else{
          return doGetEncoding(ch,huffmanNode.right,prefix+"1");
        }

    }

    public static void printHuffmanTree(HuffmanNode node){
        if(node.left != null){
            printHuffmanTree(node.left);
        }
        System.out.print(node);
        if(node.right != null){
            printHuffmanTree(node.right);
        }

    }


    public static void main(String[] args){
        List<FrequencyMap> list = ImmutableList.of(new FrequencyMap('g',2),
                new FrequencyMap('r',3),new FrequencyMap('a',6), new FrequencyMap('e',12));

        HuffmanNode root = HuffmanUtil.buildHuffmanTree(list);

        HuffmanUtil.printHuffmanTree(root);
        System.out.println();
        String targetString = "egearge";
        String encoding = HuffmanUtil.encode(targetString,root);
        //expected is 0 110 0 10 111 110 0
        System.out.println("Encoded string " + encoding);

        System.out.println("Decoded " + HuffmanUtil.decode(encoding,root,root));
    }




}
class FrequencyMap implements Comparable<FrequencyMap>{
    public final Character character;
    public final Integer frequency;
    public FrequencyMap(Character ch,Integer integer){
        this.character = ch;
        this.frequency = integer;
    }


    @Override
    public int compareTo(FrequencyMap o) {
        return frequency.intValue() - o.frequency.intValue();
    }
}
