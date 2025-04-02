package Day03;

public class Outer {
	
	private int a,b;
	
	public void outerPrint() {
		System.out.println("outer print");
	}
	
	
	public static class StaticInner{
		public void print(Outer o) {
			System.out.println("Outer class");

		}
	}
	
	private static abstract class Just {
		abstract void print();
	}
	
	public static class JustImpl extends Just {
		@Override
		void print() {
			System.out.println("This is a Just class for print ...");
		}
	}
	
	public class Inner {
		public void print() {
			System.out.println("Inner print A =" + a + " B = " +b);
		}
		public void addOne() {
			b++;
			a++;
			
		}
	}
	
	

	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
		i.addOne();
		Outer.Inner i1 = o.new Inner();
		i1.print();
		i.print();
		
		Outer o1 = new Outer();
		Outer.Inner i2 = o1.new Inner();
		i2.print();
		i2.addOne();
		i2.print();
		i.print();
		
		Outer.StaticInner si = new Outer.StaticInner();
		si.print(o1);
		
		Just jl = new JustImpl();
		jl.print();
		
		Just j2 = new Just() {
			
			@Override
			void print() {
				System.out.println("This is anonymes...");
			}
		};	
		j2.print();
	}
}
