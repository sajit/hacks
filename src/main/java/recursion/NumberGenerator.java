package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate a list of strings that can be mapped from a phone keypad
 * The normal method would be to recursively combine each result as given in combine method..
 *
 * But if the possible combinations are really huge you need a more memory efficient ways
 * Created by sajit on 4/30/16.
 */
public class NumberGenerator {

    private final char[][] matrix;

    public NumberGenerator(char[][] matrix){
        this.matrix = matrix;
    }


    public void print(String prefix,int row){
        if(row>=matrix.length){
            System.out.println(prefix);
            return;

        }
        for(int j=0;j<matrix[row].length && matrix[row][j] != '*';j++){
            print(prefix+matrix[row][j],row+1);
        }
    }

    /**
     * Usual way of generating the result.
     * @param a
     * @param word
     * @return
     */
    public List<String> combine(final List<String> a, final String word){
        if(word.isEmpty()){
            return a;
        }
        final char lastChar = word.charAt(word.length()-1);
        final char[] mappings = KeyboardMap.keyBoardMap(lastChar);
        final List<String> result = new ArrayList<>();
        if(a.isEmpty()){
            for(char ch : mappings){
                result.add(String.valueOf(ch));
            }

        }
        else{
            for(String suffix : a){
                for(char c : mappings){
                    result.add(c+suffix);
                }
            }
        }


        return combine(result,word.substring(0,word.length()-1));
    }
}
class KeyboardMap {
    public static char[] keyBoardMap(char c){

        switch (c){
            case '0': {return new char[]{'0'};}
            case '1': {return new char[]{'1'};}
            case '2': {return  new char[]{'A','B','C','2'};}
            case '3': {return  new char[]{'D','E','F','3'};}
            case '4': {return new char[]{'G','H','I','4'};}
            case '5': {return new char[]{'J','K','L','5'};}
            case '6': {return  new char[]{'M','N','O','6'};}
            case '7': {return  new char[]{'P','Q','R','S','7'};}
            case '8': {return  new char[]{'T','U','V','8'};}
            case '9': {return  new char[]{'W','X','Y','Z','9'};}
            default: throw  new IllegalArgumentException("Unknown character");

        }

    }
}
