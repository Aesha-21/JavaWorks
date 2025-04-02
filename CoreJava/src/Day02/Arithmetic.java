package Day02;

public interface Arithmetic {

	int a = 10;
	int b = 20;
	double subtract();   // double add(double a, double b) 
	double add();
	double multiply();
   int div(int a, int b);
	
	
	public static void main(String[] args) {
		Arithmetic ari = new Oprations();
		System.out.println(ari.add());
		System.out.println(ari.subtract());
		System.out.println(ari.multiply());

		
	}
}
