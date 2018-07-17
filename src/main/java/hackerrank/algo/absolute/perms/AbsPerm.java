package hackerrank.algo.absolute.perms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AbsPerm {
    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {

        Set<Integer> idxSet = new HashSet<>();
        int[] pos = new int[n+1];
        for(int i=1;i<=n;i++){

            if(i<=k){
                pos[i]=i+k;
                if(pos[i]>n || idxSet.contains(pos[i])){
                    return new int[]{-1};
                }
                idxSet.add(pos[i]);

            }
            else {

                if(idxSet.contains(i-k)){
                    pos[i]=i+k;
                }
                else{
                   pos[i]=i-k;
                }
                if(pos[i]<0 || pos[i]>n || idxSet.contains(pos[i])){
                    return new int[]{-1};
                }
                idxSet.add(pos[i]);
            }
        }
        return Arrays.copyOfRange(pos,1,pos.length);
    }
}
