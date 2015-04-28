package design.patterns.observer;

/**
 * Created by sajit on 4/27/15.
 */
public class CubeObserver extends AbstractObserver {
    private Integer value = Integer.valueOf(0);

    public CubeObserver(Watchee watchee) {
        super(watchee);
    }

    @Override
    public void updateMe() {
        int base = watchee.getState();
        value = base*base*base;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
