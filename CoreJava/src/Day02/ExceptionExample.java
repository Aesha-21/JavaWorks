package Day02;

public class ExceptionExample {

	public static void main(String[] args) {
		Authenticator auth = new Authenticator();
		try {
			long code = auth.authenticates("aws", "abc");
			System.out.println("Authenticate = "+code);
			auth.authenticates("aws", "abc");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			System.out.println("execute");
		}
		

	}

}
