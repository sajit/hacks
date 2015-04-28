package dp;

/**
 * Created by skunnumkal on 7/27/14.
 */
public class EditDistance {

    public static int minDistance(String a,String b){
        int[][] d = new int[a.length()+1][b.length()+1];

        for(int j=0;j<d[0].length;j++){
            d[0][j]=j;
        }
        for(int i=0;i<d.length;i++){
            d[i][0]=i;
        }

        for(int i=1;i<d.length;i++){
            for(int j=1;j<d[i].length;j++){

                if(a.charAt(i-1)==b.charAt(j-1)){
                    d[i][j]=d[i - 1][j - 1];
                }
                else{
                    d[i][j] = Math.min(d[i - 1][j], d[i][j - 1])+1;
                }
            }
        }
        printTable(d);
        return d[a.length()][b.length()];
    }

    private static void printTable(int[][] table) {
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table[i].length;j++){
                System.out.print(" "+table[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){

        String a = "soju";
        String b = "ponnu";

        System.out.println(EditDistance.minDistance(a,b));
    }


}
