package Day04;

import static org.junit.jupiter.api.Assertions.*;


import java.io.*;

import org.junit.jupiter.api.Test;

class IOTest {
	
	@Test
	public void testBufferReader() {
		try(BufferedReader br = new BufferedReader(new FileReader(new File("data.txt")))){
			
			System.out.println(br.readLine()+"   buffer read");
			System.out.println(br.readLine());
			System.out.println(br.readLine());

		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	@Test
	public void testReaders() {
		try (Reader reader = new FileReader(new File("data.txt"))) {
			try(Writer writer = new FileWriter(new File("dataOut.txt"))){
				char [] buff = new char[4];
				int i = -1;
				while((i=reader.read(buff))!= -1){
					writer.write(buff,0,i);
				}
				writer.flush();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testChanningStream() {
		try(InputStream is = new BufferedInputStream(new FileInputStream(new File("data.txt")))){
			try (OutputStream os = new FileOutputStream("dataCopy.txt")){
				byte [] buff = new byte[4]; //real world we use buffer size is 8192 or 16768
				//int byteread = is.read(buff);
				int i =0;
				while((i=is.read(buff)) != -1) {
					System.out.println(new String(buff,0,i)+"  string chain");
					os.write(buff,0,i);
				}
				os.flush();
				}
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@Test
	public void secondReadTryWithResourcesWithLoop() {
		try(InputStream is = new FileInputStream(new File("data.txt"))){
			try (OutputStream os = new FileOutputStream("dataCopy.txt")){
			byte [] buff = new byte[4]; //real world we use buffer size is 8192 or 16768
			//int byteread = is.read(buff);
			int i =0;
			while((i=is.read(buff)) != -1) {
				System.out.println(new String(buff,0,i) +"  loop");
				os.write(buff,0,i);
			}
			os.flush();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void secondReadTryWithResources() {
		try(InputStream is = new FileInputStream(new File("data.txt"))){
			byte [] buff = new byte[4]; //real world we use buffer size is 8192 or 16768
			int byteread = is.read(buff);
			assertEquals(4, byteread);
			assertEquals(4, is.read(buff));
			
			System.out.println(new String(buff)+"  " +" asserts");
			
			assertEquals(4, is.read(buff));
			System.out.println(new String(buff));
		
			assertEquals(4, is.read(buff));
			System.out.println(new String(buff));
			
			assertEquals(1, is.read(buff));
			System.out.println(new String(buff));

			assertEquals(-1, is.read(buff));
			System.out.println(new String(buff));


			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testReadTryWithResources() {
		try(InputStream is = new FileInputStream(new File("data.txt"))){
			assertEquals('H', ((byte)is.read()));
			assertEquals('e', ((byte)is.read()));
			assertEquals('l', ((byte)is.read()));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRead() {
		InputStream is = null;
		try {

		is = new FileInputStream(new File("data.txt"));
		//byte b = (byte) 'H';
		assertEquals('H', ((byte)is.read()));
		assertEquals('e', ((byte)is.read()));
		assertEquals('l', ((byte)is.read()));
		assertEquals('l', ((byte)is.read()));
		assertEquals('o', ((byte)is.read()));
		
		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		try {
    			is.close();
    		}catch(IOException e) {
    			e.printStackTrace();
    		}
    	}
	}

}
