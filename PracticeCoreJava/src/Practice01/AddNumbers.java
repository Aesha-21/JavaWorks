package Practice01;

class AddNumbers {
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	
	static void swapno(int x, int y) {
		
		int tmp = x;
		x = y;
		y = tmp;
		
		System.out.println("X = "+x+"Y = "+y);
	}
	
	
	
	public static void main(String[] args) {
		AddNumbers ad = new AddNumbers();
		int rs = AddNumbers.add(2, 3);
		System.out.println("Addition ="+rs);
		
		swapno(23, 12);
		
		
		
	}

	
	
}
