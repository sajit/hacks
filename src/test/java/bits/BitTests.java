package bits;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class BitTests {

	@Test
	public void testEquality() {
		assertEquals(1,new Byte("1").byteValue());
		assertNotEquals(new Byte("1"),new Integer(1));
		assertEquals(3,Integer.parseInt("011",2));
		assertEquals(11,Integer.parseInt("011",10));
		assertEquals(10,Integer.parseInt("A",16));
		System.out.println(new Byte("101").intValue());
	}
}
