package design;

import java.util.concurrent.Callable;

/**
 * Created by skunnumkal on 7/26/14.
 */
public class ElevatorCallable implements Callable {
    private Elevator elevator;
    private Integer target;
    public ElevatorCallable(Elevator elevator,Integer target){
        this.elevator = elevator;
        this.target = target;
    }

    @Override
    public Object call() throws Exception {
        elevator.move(target);
        return null;
    }
}
