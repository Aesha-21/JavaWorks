package spring.ioc;

public class PointInstanceFactory {
	
	private int x;
	private int y;
	
	public Point CreatePoint(int x ,int y) {
		return new Point(x,y);
	}
	public PointInstanceFactory(int x,int y) {
		this.x = x;
		this.y = y;
	}

	
	
	
	
}
