package recursion;

import java.math.BigInteger;

public class Factorial {

    // Complete the extraLongFactorials function below.


    static void extraLongFactorials(int n) {
        BigInteger product = BigInteger.valueOf(n);
        while(n>1){
            product = product.multiply(BigInteger.valueOf(n-1));
            n--;
        }
        System.out.println(product);
    }

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
      int rowSum=0;
      int colSum=0;
      int[] maxPerRow = init(container.length);
      int currentRowMax=0;
      for(int j=0;j<container[0].length;j++){
          if(container[0][j]>=currentRowMax){
              currentRowMax = container[0][j];
              maxPerRow[0]=j;
          }
          rowSum += container[0][j];
      }


      for(int i=1;i<container.length;i++) {
          int currentRowSum = 0;
          currentRowMax=0;
          for (int j = 0; j < container[i].length; j++) {
              if(container[i][j]>=currentRowMax){
                  currentRowMax = container[i][j];
                  if(!hasIdx(maxPerRow,j))
                        maxPerRow[i]=j;
              }
              currentRowSum += container[i][j];
          }
          if (currentRowSum != rowSum) {
              return "Impossible";
          }
      }

        for(int i=0;i<container.length;i++){
            colSum += container[i][0];
        }
        for(int j=1;j<container[0].length;j++) {
            int currentColSum = 0;
            for (int i = 0; i < container.length; i++) {
                currentColSum += container[i][j];
            }
            if (currentColSum != colSum) {
                return "Impossible";
            }
        }

      for(int i=0;i<container.length;i++){
          int maxBallIdx = maxPerRow[i];
          for(int j=0;j<container.length&& j!=i;j++){
            while(container[j][maxBallIdx]>0 ){
                int swapNumIdx = canSwap(container,i,maxBallIdx);
                if(swapNumIdx>=0){
                    swap(container,i,j,maxBallIdx,swapNumIdx);
                }
            }
          }
          dump(container);
      }
      //dump(container);
      return finalCheck(container);

    }

    public static String finalCheck(int[][] container) {
        for(int i=0;i<container.length;i++){
            int nonZeroCount=0;
            for(int j=0;j<container[i].length;j++){
                if(container[i][j]>0){
                    nonZeroCount++;
                }
                if(nonZeroCount>1){
                    return "Impossible";
                }
            }
        }
        return "Possible";
    }

    public static void swap(int[][] container, int row_i, int row_j, int maxBallIdx, int swapNumIdx) {
        container[row_i][maxBallIdx] +=1;
        container[row_j][maxBallIdx] -=1;
        container[row_i][swapNumIdx] -=1;
        container[row_j][swapNumIdx] +=1;
    }

    /*
     * return true if this row has balls that can be removed
     */
    public static int canSwap(int[][] container, int row_i, int maxBallIdx) {
        //in row i find the first ball type that has non zero count
        int idx=-1;
        for(int i=0;i<container.length;i++){
            if(container[row_i][i]>0 && i!=maxBallIdx){
                return i;
            }
        }
        return idx;
    }

    public static void dump(int[][] container) {
        for(int i=0;i<container.length;i++){
            for(int j=0;j<container[i].length;j++){
                System.out.print(container[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("------");
    }

    private static boolean hasIdx(int[] maxPerRow, int i) {
        for(int j=0;j<maxPerRow.length;j++){
            if(maxPerRow[j]==i){
                return true;
            }
        }
        return false;
    }

    private static int[] init(int length) {
        int[] maxPerRowArray = new int[length];
        for(int i=0;i<maxPerRowArray.length;i++){
            maxPerRowArray[i]= -1;
        }
        return maxPerRowArray;
    }

    public static void main(String[] args){
        int[][] container = {{3,3,0},{1,0,5},{2,3,1}};

        System.out.println(organizingContainers(container));
    }
}
