public class FactorialCount {
	

	public int fectorial(int f) {
		int fact = 1;
		for(int i=1;i<=f;i++)
		{
			fact = fact*i;
			
		}	
		return fact;
	}

	public static void main(String[] args) {
		System.out.println("Main");
		
		FactorialCount obj = new FactorialCount();
		
		
		System.out.println(obj.fectorial(5));
	}
}
