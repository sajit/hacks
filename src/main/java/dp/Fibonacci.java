package dp;

/**
 * Created by skunnumkal on 6/21/14.
 */
public class Fibonacci {
    /**
     *  int temp = a + b;
     a = b;
     b = temp;
     * @param x
     * @return
     */
    public static void fibo(int x){
        int a = 0,b = 1;
        System.out.print(" "+a+ " "+b);
        for(int i=2;i<=x;i++){
            int temp = a + b;
            a = b;
            b = temp;
            System.out.print(" " + temp);

        }

    }

    public static void reverse(int x,int lowerVal,int higherVal){
        int a = lowerVal,b = higherVal;
        System.out.print(higherVal+" "+lowerVal);
        for(int i=x;i>=0;i--){
            int temp = b-a;
            b = a;
            a = temp;
            System.out.print(" "+temp);

        }

    }




}
