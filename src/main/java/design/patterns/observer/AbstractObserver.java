package design.patterns.observer;

/**
 * Created by sajit on 4/23/15.
 */
public abstract class AbstractObserver {

    public abstract void updateMe();
    public abstract Object getValue();
    protected final Watchee watchee;
    public AbstractObserver(Watchee watchee){
        this.watchee = watchee;
    }
}
