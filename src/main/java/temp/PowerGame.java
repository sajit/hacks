package temp;

import concurrency.SynchronizedQueue;

import java.io.PipedWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by sajit on 2/21/15.
 */
public class PowerGame {




    public static boolean isPowerOf2(BigInteger n){
        if(n.intValue() <= 1){
            return false;
        }
        if(n.intValue() ==2){
            return  true;
        }
        if(n.mod(BigInteger.valueOf(2l)) != BigInteger.ZERO){
            return false;
        }
        return isPowerOf2(n.shiftRight(1));
    }

    public static BigInteger largest2PowLessThan(BigInteger n){
        int count=0;
        while(n.doubleValue()>0){
            n = n.shiftRight(1);
            count++;
        }
        double ds = Math.pow(2,count-1);
        return BigDecimal.valueOf(ds).toBigInteger();
    }


    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0;i<t;i++){
            long n = scanner.nextLong();

            play(BigInteger.valueOf(n));

        }
    }

    private static void play(BigInteger n) {
        boolean oddTurn = true;
        while(n.intValue()>1){
            if(isPowerOf2(n)){
                n  = n.shiftRight(1);
            }
            else{
                n = n.subtract(largest2PowLessThan(n));
            }
            oddTurn = !oddTurn;
        }
        if(oddTurn){
            System.out.println("Richard");
        }
        else{
            System.out.println("Louis");
        }
    }
}
