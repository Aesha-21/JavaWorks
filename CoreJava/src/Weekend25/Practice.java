package Weekend25;

public class Practice {
	
	//type conversion/casting example
	public static void main(String[] args) {
		byte a = 12;
		int b = (byte)a;  //explicite conversion
		System.out.println(b);
		
		int c = 257;
		byte d = (byte)c; // if byte value store outof the range value its use % and divide by 256
		System.out.println(d);
		
		//promotion in expression
		byte me = 12;
		byte my = 12;
		int ok = (byte)(me+my); //promotion expression allow the type from lower to high data type conversion
		System.out.println(ok);
	}
	

}
