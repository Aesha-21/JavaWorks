package Weekend25;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.ToStringConversion;

public class PracticeArray {
	
	public static void main(String[] args) {
		int no[] = {2,4,1,3}; 
		
		//simple array
		for(int a=0;a<=3;a++) {
			System.out.println(no[a]+"aa");
		}
		
		
		//2D Array
		int no1[][] = new int[3][4];
		
		for (int i=0;i<3;i++) {
			
			for(int j=0;j<4;j++) {
				
				no1 [i][j] =(int) (Math.random() * 10);
				System.out.print(no1[i][j]+ " ");
				
			}
			System.out.println();
		}
		
		//ex of jagged  Array
		
		int num[][] = new int[4][];
		
		num[0] = new int[3];
		num[1] = new int[6];
		num[2] = new int[2];
		num[3] = new int[4];

		
		System.out.println("Jagged Array example");
		for (int i=0;i<num.length;i++) {
			
			for(int j=0;j<num[i].length;j++) {
				
				num [i][j] =(int) (Math.random() * 10);
				System.out.print(num[i][j]+ " ");
		
			}
			System.out.println();
		}
		
	
	
		//ex of string buffer and builder
		
		String str = "he";
		
		StringBuffer sb = new StringBuffer("Buffer");
		sb.append("String");
		System.out.println(sb);
		
		//object to the String object

		String nw = sb.toString();
		//System.out.println(nw);
	
		StringBuilder sbl = new StringBuilder(nw);
		System.out.println(sbl);
	}

}
