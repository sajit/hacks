package temp;

import org.junit.Test;

import java.math.BigInteger;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by sajit on 2/22/15.
 */
public class PowerGamers {

    @Test
    public void testLargestPowerLessThan(){
        assertThat(PowerGame.largest2PowLessThan(BigInteger.valueOf(6))).isEqualTo(BigInteger.valueOf(4));
    }

    @Test
    public void testLargestPowerLesserthan1(){
        assertThat(PowerGame.largest2PowLessThan(BigInteger.valueOf(9))).isEqualTo(BigInteger.valueOf(8));
    }

    @Test
    public void testVeryLargePower(){
        BigInteger x = BigInteger.valueOf((long)Math.pow(2,32)-1);
        BigInteger expected = BigInteger.valueOf((long)Math.pow(2,31));
        assertThat(PowerGame.largest2PowLessThan(x)).isEqualTo(expected);
    }

    @Test
    public void testPowers(){
        assertThat(PowerGame.isPowerOf2(BigInteger.valueOf((long)Math.pow(2,30)))).isEqualTo(true);
        assertThat(PowerGame.isPowerOf2(BigInteger.valueOf((long)Math.pow(2,29)+1))).isEqualTo(false);
    }
}
