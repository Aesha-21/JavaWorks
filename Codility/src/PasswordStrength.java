import java.util.Scanner;

public class PasswordStrength {

	private static String passwordCheck(String pass) {
		boolean lowerChar = false, upperChar=false;
		boolean digits=false, containsSpecialChars= false, minlength=false;
		String special_chars ="!(){}[]:;<>?,@#$%^&*+=-~`|./";
		String strength;
		char[] ch = pass.toCharArray();
		
		for (int i=0;i<pass.length();i++) {
			if(Character.isLowerCase(ch[i])) {
				lowerChar =true;
			}
			if(Character.isUpperCase(ch[i])) {
				upperChar =true;
			}
			if(Character.isDigit(ch[i])) {
				digits =true;
			}
			if(special_chars.contains(String.valueOf(ch[i]))) {
				lowerChar = true;
			}
		}
		if(pass.length() >= 12) {
			minlength = true;
		}
		
		if(minlength && digits && upperChar && containsSpecialChars && lowerChar) {
			strength = "Strong";
		}else if(minlength && ((upperChar && lowerChar)||digits || containsSpecialChars)) {
			strength = "Medium";
		}else {
			strength = "Weak";
		}
		return strength;
		
	}
	public static void main(String[] args) {
		System.out.println("Password check...");
		Scanner sc = new Scanner(System.in);
		String password = sc.nextLine();
		String strength = passwordCheck(password);
		System.out.println("Strength"+strength);
	}
	
}



