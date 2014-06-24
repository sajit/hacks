package threads;

/**
 * Created by skunnumkal on 6/23/14.
 */
public class UnsafeRGB {

    private int r;
    private int g;
    private int b;

    public UnsafeRGB(int r, int g, int b) {

        checkRGBVals(r, g, b);

        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void setColor(int r, int g, int b) {

        checkRGBVals(r, g, b);

        this.r = r;
        this.g = g;
        this.b = b;
    }
    /**
     * returns color in an array of three ints: R, G, and B
     */
    public int[] getColor() {

        int[] retVal = new int[3];
        retVal[0] = r;
        retVal[1] = g;
        retVal[2] = b;

        return retVal;
    }

    public void invert() {

        r = 255 - r;
        g = 255 - g;
        b = 255 - b;
    }

    private static void checkRGBVals(int r, int g, int b) {

        if (r < 0 || r > 255 || g < 0 || g > 255 ||
                b < 0 || b > 255) {

            throw new IllegalArgumentException();
        }
    }
}
