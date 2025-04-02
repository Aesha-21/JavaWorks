package Day03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThreadTest {

	@Test
	void test() {

		Runnable r = new Runnable() {
			public void run() {
				for (int i =0;i< 10;i++) {
					System.out.println(Thread.currentThread()+ ""+i);
				}
			}
		};
		
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		
		Thread t = new Thread() {
			public void run() {
				for (int i =0;i< 10;i++) {
					System.out.println(Thread.currentThread()+ ""+i+"From run method");
				}
			}
		};
		t.start();
		
	}

}
