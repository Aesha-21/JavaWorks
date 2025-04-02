package Day02;

public class ControlStatements {

	public void testIf(int a) {
	
		if(a % 2 == 0) {
			System.out.println(a+"is even number");
		}else {
			System.out.println(a +"is odd number");
		}
	}
	

	public void testfor(int[] a) {
		for (int j = 0; j < a.length; j++) {
			System.out.println(a[j]);
		}
	}
	
	public void testswitch(int c) {
		switch (c) {
		case 1:
			System.out.println("one");
			break;

		default:
			break;
		}
	}
	
	public int add(int iv, int ... a) {
		int sum = iv;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
			System.out.println("sum is ="+sum);
			
		}
		return sum;
	}
	
	public static void main(String[] args) {
		ControlStatements cst = new ControlStatements();
		cst.testIf(3);
		cst.testfor(new int[] {23,4,4});
		cst.testswitch(1);
		cst.add(1,46,7,53,3,4,67,7);
		
	}
	
	
}



