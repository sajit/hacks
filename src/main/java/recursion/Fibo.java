package recursion;

/**
 * Created by skunnumkal on 6/21/14.
 */
public class Fibo {

    public int printFibo(int x){
        if(x<=1){
            return x;
        }
        return printFibo(x-1) + printFibo(x-2);
    }



    public static void main(String[] args){
        Fibo fibo = new Fibo();
        int val = fibo.printFibo(4);
        System.out.println(val);
    }
}
