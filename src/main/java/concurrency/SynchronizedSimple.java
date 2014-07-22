package concurrency;

/**
 * Created by skunnumkal on 7/19/14.
 */
public class SynchronizedSimple extends Simple{



    @Override
    public void setI(int i){
        synchronized (this){
            this.i = this.i + 1;
        }

        System.out.println("Setting i to in Synch " + this.i);
    }

    @Override
    public int getI(){
        synchronized (this){
            System.out.println("In synch");
            return i;
        }
        //return  i;
    }

    public static void main(String[] args){
        SynchronizedSimple s = new SynchronizedSimple();
        Populator[] x = new Populator[10];
        for(int i=0;i<10;i++){
            x[i] = new Populator(s,i);
            new Thread(x[i]).start();
        }

    }
}
