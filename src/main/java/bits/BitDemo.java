package bits;

public class BitDemo {

	public static void main(String[] args) {
		byte b = 1;
		System.out.println((int)b);
		Byte byteObj = new Byte("1");

		assert byteObj.equals(44);
		assert false == true;

	}
}
