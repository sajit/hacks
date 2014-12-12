package l33t;

import org.apache.commons.lang.math.RandomUtils;

/**
 * Created by sajit on 12/11/14.
 */
public class BinaryMatrixMaxSub{

    public static int maxSubMatrix(boolean[][] in){
        //sumMatrix[i][j] indicates the size of the largest iXi or jXj (depneding on which is smaller) matrix whose
        //right bottom element is [i][j]
        int[][] sumMatrix = new int[in.length][in.length];
        int max = 0;
        for(int i=0;i<in.length;i++){
            if(in[i][0]){
                sumMatrix[i][0] = 1;
            }

        }
        for(int j=1;j<in[0].length;j++){
            if(in[0][j]){
                sumMatrix[0][j] = 1;
            }
        }
        for(int i=1;i<in.length;i++){
            for(int j=1;j<in[i].length;j++){
                if(in[i][j]){
                    sumMatrix[i][j] = Math.min(
                            Math.min(sumMatrix[i-1][j],sumMatrix[i][j-1]),
                            sumMatrix[i-1][j-1])+1;
                    if(sumMatrix[i][j]>max){
                        max = sumMatrix[i][j];
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args){

        boolean[][] in = new boolean[5][5];
        for(int i=0;i<in.length;i++){
            for(int j=0;j<in.length;j++)
                in[i][j] = RandomUtils.nextInt(5) > 0;
        }

        printMatrix(in);
        System.out.println(BinaryMatrixMaxSub.maxSubMatrix(in));
    }

    private static void printMatrix(boolean[][] booleans) {
        for(int i=0;i<booleans.length;i++){
            for(int j=0;j<booleans[i].length;j++){
                if(booleans[i][j]){
                    System.out.print("1 ");
                }
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
    }
}
