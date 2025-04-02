package Day02;

import java.util.Random;

public class Authenticator {

	public long authenticates(String name, String pass) throws Exception {
		//if(name.equals("aws")&& pass.equals("abc"))
		if("aws".equals(name)&& "abc".equals(pass)) {
			return new Random().nextLong();
		}
		throw new Exception("Only abc is allowed");
	}
}
