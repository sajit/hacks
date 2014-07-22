package concurrency;

/**
 * Created by skunnumkal on 7/19/14.
 */
public class Simple {

    protected int i;

    public void setI(int i){

        this.i = this.i + 1;
        System.out.println("Setting i to " + this.i);
    }

    public int getI(){
        return  i;
    }

    public static void main(String[] args){
        Simple s = new Simple();
        Populator[] x = new Populator[10];
        for(int i=0;i<10;i++){
            x[i] = new Populator(s,i);
            new Thread(x[i]).start();
        }

    }
}
