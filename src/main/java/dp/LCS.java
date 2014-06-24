package dp;

/**
 * Created by skunnumkal on 6/24/14.
 */
public class LCS {

    public static int lengthLCS(String a,String b){
        int[][] t = new int[a.length()+1][b.length()+1];
        for(int i=1;i<t.length;i++){
            for(int j=1;j<t[i].length;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = t[i-1][j-1]+1;
                }
                else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }

        return t[a.length()][b.length()];
    }
}
