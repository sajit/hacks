package dp;

/**
 * Created by skunnumkal on 6/23/14.
 */
public class LongestPalindrome {

    public static int longestPalLength(String str){
        int[][] table = new int[str.length()][str.length()];

        for(int i=0;i<table.length;i++){
            table[i][i] = 1;
        }

        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                table[i][i+1] = 2;
            }
            else{
                table[i][i+1]=0;
            }
        }
        int max = 0;
        for(int i=table.length-3;i>=0;i--){
            for(int j=i+2;j<table[i].length;j++){
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
}
