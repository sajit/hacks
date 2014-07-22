package memory;

import java.util.HashMap;

/**
 * Created by skunnumkal on 7/19/14.
 */
public class OOM {

    static Object[] x = new Object[100000000];
    public static void main(String[] args) throws InterruptedException {
        int i=0;
        while(true){
            HashMap map = new HashMap<String, String>(10000000);
            x[i] = map;
            i++;
            //System.out.println("Created object..");
            //Thread.sleep(5);

        }
    }

    /**
     * StackOverflow Error
     */
    public void goIn(){
        goIn();
    }
}
