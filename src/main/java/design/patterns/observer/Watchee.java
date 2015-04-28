package design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajit on 4/27/15.
 */
public class Watchee {

    private int state;
    private List<AbstractObserver> observerList = new ArrayList<>();
    public void setState(int newState){
        this.state = newState;
        notifyAllObservers();
    }

    public int getState(){
        return state;
    }

    public void attach(AbstractObserver observer){
        observerList.add(observer);
    }

    public void notifyAllObservers(){
        for(AbstractObserver observer : observerList){
            observer.updateMe();
        }
    }

}
