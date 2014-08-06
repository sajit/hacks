package concurrency;

/**
 * Created by sajit on 8/6/14.
 */
public class Joy {

    private boolean joy = false;

    /**
     * Why is this version of guardedJoy synchronized? Suppose d is the object we're using to invoke wait.
     * When a thread invokes d.wait, it must own the intrinsic lock for d —
     * otherwise an error is thrown.
     * Invoking wait inside a synchronized method is a simple way to acquire the intrinsic lock.
     */
    public synchronized void guardedJoy(){
        while(!joy){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            toggleJoy();
        }
        System.out.println("Joy has been achieved");
    }

    public synchronized void toggleJoy(){
        joy = !joy;
        notifyAll();
    }


}

