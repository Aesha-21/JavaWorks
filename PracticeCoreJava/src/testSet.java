import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class testSet {

	static int arryp[] = {1,2,3,4,4,4,789};
	
	static int largno() {
		
		int max = arryp[0];
		
		for(int i=1; i < arryp.length;i++) {
			
			if(arryp[i]>max) {
				max=arryp[i];
				}
			
		}
		return max;
	}
	
	
	//using stream api
	
	static int arryfind() {
		int arr2[] = {3,4,2,43};
		
		int max = Arrays.stream(arr2).max().getAsInt();
		
		return max;
	}
	
	static void arry2() {
		
		int arr[]= {1,2,3,5};
		
		Arrays.sort(arr);
		System.out.println(""+arr[arr.length-1]);
	}
	
	static int listarr() {
		
		int arr[]= {3,456,34,2,3,112,345};
		
		List<Integer> lst = new ArrayList<Integer>();
		
		for(int i=1;i<arr.length;i++) {
			lst.add(arr[i]);
		}
		return Collections.max(lst);
	}
	
	public static void main(String[] args) {
		testSet tob = new testSet();
		System.out.println(tob.largno());
		System.out.println("using array stream...."+tob.arryfind());
		tob.listarr();
		System.out.println("ArrayList..."+tob.listarr());
	}
}
