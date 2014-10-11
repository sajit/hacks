package recursion;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * Created by skunnumkal on 10/11/14.
 */
public class WordBreak {

    public static Set<String> dictionary = ImmutableSet.of("leet","code","saj","it","ite");
    public static boolean breakWord(String word){
        if(dictionary.contains(word)){
            return true;
        }
        for(int i=1;i<word.length()-1;i++){
            String prefix = word.substring(0,i);
            String suffix = word.substring(i,word.length());
            if(breakWord(prefix) && breakWord(suffix)){
                return true;
            }
        }
        return false;
    }




    public static void main(String[] args){
        System.out.println("LetCode?" + breakWord("letcode"));
        System.out.println("sajit?" + breakWord("sajit"));
        System.out.println("sajite?" + breakWord("sajite"));
        System.out.println("leetcode?" + breakWord("leetcode"));
        System.out.println("leet" + breakWord("leet"));
    }
}
