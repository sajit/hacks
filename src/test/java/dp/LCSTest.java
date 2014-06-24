package dp;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by skunnumkal on 6/24/14.
 */
public class LCSTest {

    @Test
    public void testLCS1(){
        String a = "ababdd";
        String b = "badd";
        int length = LCS.lengthLCS(a,b);
        Assert.assertEquals(4,length);
    }

}
