package design.patterns.observer;

/**
 * Created by sajit on 4/27/15.
 */
public class SquareObserver extends AbstractObserver {
    private Integer value = Integer.valueOf(0);

    public SquareObserver(Watchee watchee) {
        super(watchee);
    }

    @Override
    public void updateMe() {
        value = (int)Math.pow(watchee.getState(),2);
    }

    @Override
    public Object getValue() {
        return value;
    }
}
