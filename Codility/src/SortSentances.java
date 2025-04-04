import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortSentances {
	
	public static int countVowels(String sentences) {
		int count =0 ;
		sentences =  sentences.toLowerCase();
		for(char c : sentences.toCharArray()) {
			if(c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u' || c == 'A' || c == 'E' ||c == 'I' ||c == 'O' ||c == 'U') {
			   count++;	
			}
		}
		System.out.println(sentences);
		return count;
	}

	public static void main(String[] args) {
		
		
		List<String> sentences = Arrays.asList("Hello I am Jasy","I am from vaitnam","I am a Student");
		//asc
		Collections.sort(sentences, new Comparator<String>() {
			public int compare(String s1, String s2) {
				
				return  countVowels(s1) - countVowels(s2);
				
			}
		   
		});
		//desc
		Collections.sort(sentences, new Comparator<String>() {
			public int compare(String s1, String s2) {
				
				return countVowels(s2) - countVowels(s1);
			}
		   
		});
		
		System.out.println(countVowels(sentences));
	}
	
}

