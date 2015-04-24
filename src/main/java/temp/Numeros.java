package temp;

import java.util.*;

/**
 * Created by sajit on 2/24/15.
 */
public class Numeros {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for(int i=0;i<m;i++){
            b[i] = scanner.nextInt();
        }
        if(m<n){
            process(a,b);
        }else{
            process(b,a);
        }
        
    }

    private static void process(int[] longer, int[] shorter) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int x : longer){

            Integer val = count.get(x);
            if(val == null){
                val = Integer.valueOf(0);
            }
            count.put(x,val + 1);

        }
        for(int y : shorter){
            Integer val = count.get(y);
            if(val != null){
                val -= 1;
                if(val ==0){
                    count.remove(y);
                }
                else{
                    count.put(y,val);
                }
            }
        }
        List<Integer> remList = new ArrayList<>();
        count.forEach((k,v) -> {
            for(int i=0;i<v;i++){
                remList.add(k);
            }
        });
        Collections.sort(remList);
        for(int rem : remList){
            System.out.print(rem+ " ");
        }
    }
}
