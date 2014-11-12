package dp;

/**
 * Created by skunnumkal on 6/23/14.
 */
public class LongestPalindrome {

    public static int longestPalLength(String str){
        int[][] table = new int[str.length()][str.length()];

        //all individual chars have length 1
        for(int i=0;i<table.length;i++){
            table[i][i] = 1;
        }

        //adjacent characters should have 2

        int max = 0;
        for(int i=table.length-2;i>=0;i--){
            for(int j=i+1;j<table[i].length;j++){
                if(str.charAt(i) == str.charAt(j)){
                    table[i][j] = table[i+1][j-1]+2;
                    if(table[i][j] > max){
                        max = table[i][j];
                    }
                }
                else{
                    table[i][j] = 0;
                }

            }
        }



        return max;

    }

    public static void main(String[] args){
        String s1 = "malayalam";
        String s2 = "mlayalam";
        System.out.println(LongestPalindrome.longestPalLength(s1));
        System.out.println(LongestPalindrome.longestPalLength(s2));
    }
}
