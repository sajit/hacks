package dp;

/**
 * Created by sajit on 7/8/14.
 */
public class SubseqCount {

    public static int count(String search,String target){
        int[][] C = new int[search.length()][target.length()];
        char searchHead = search.charAt(0);
        C[0][0] = (searchHead == target.charAt(0))?1:0;
        for(int j=1;j<C[0].length;j++){
            if(target.charAt(j)==searchHead){
                C[0][j]=C[0][j-1]+1;
            }
            else
                C[0][j]=C[0][j-1];
        }
        for(int i=1;i<C.length;i++){
            for(int j=i;j<C[i].length;j++){
                if(search.charAt(i) == target.charAt(j)){
                    C[i][j]=C[i][j-1]+C[i-1][j-1];
                }
                else{
                    C[i][j]=C[i][j-1];
                }
            }
        }
        return C[search.length()-1][target.length()-1];
    }

    public static void main(String[] args){
        String search = "rabbi";
        String target = "rrabbbitt";
        System.out.println(SubseqCount.count(search,target));
    }
}
