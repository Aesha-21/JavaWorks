import java.io.File;
import java.io.IOException;

class MyFile{

public static void main(String args[]){

	File obj = new File("w.txt");
    System.out.println("done");
    
    try {
		if(obj.createNewFile()){
		System.out.println("crets"+obj.getName());
		}
		else{
		System.out.println("alrady there");
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
