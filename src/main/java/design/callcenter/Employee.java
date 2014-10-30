package design.callcenter;

/**
 * Created by skunnumkal on 10/30/14.
 */
public class Employee {

    private boolean busy;

    public void setBusy(boolean isBusy){
        this.busy = isBusy;
    }

    public boolean isBusy(){
        return busy;
    }
}
