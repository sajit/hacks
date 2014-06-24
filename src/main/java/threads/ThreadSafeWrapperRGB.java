package threads;

/**
 * Created by skunnumkal on 6/23/14.
 * This is the approach used by Java's thread safe collections
 */
public class ThreadSafeWrapperRGB {
    private UnsafeRGB color;

    public ThreadSafeWrapperRGB(int r, int g, int b) {

        color = new UnsafeRGB(r, g, b);
    }

    public synchronized void setColor(int r, int g, int b) {

        color.setColor(r, g, b);
    }

    /**
     * returns color in an array of three ints: R, G, and B
     */
    public synchronized int[] getColor() {

        return color.getColor();
    }

    public synchronized void invert() {

        color.invert();
    }
}
