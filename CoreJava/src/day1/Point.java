package day1;

public abstract class Point {

	private double x;
	private double y;
	
	public Point() {} //define constructor
	
	// public void Point() {}
	
	
	public Point(double x, double y) {
		this.x=x;
		this.y=y;
				
	}
	
	public double distance() {  //method
		return Math.sqrt(x*x + y*y);
	}
	
	public double distance(double x1, double y1) {
		double diffx = x1-x;
		double diffy = y1-y;
		return Math.sqrt(diffx * diffx + diffy * diffy);
	}
	
	public double distance (Point p) {
		return distance(p.x, p.y);
	}
	
	public static void main(String[] args) {
		Point3D p3 = new Point3D();
		System.out.println("point 3d"+p3.distance());
		//Point p = new Point(10,20);
//		System.out.println(p);
//		System.out.println(p.distance());
//		System.out.println(p.distance(102,203));
//		System.out.println(p.distance(p));
	}
	
	@Override
	public String toString() {
		return "Point x="+x+ "Y="+y;
		
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return x;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	
	//abstract method
	
	public abstract void MarkMeOnTV();
	
	/*
	 * precetion 
	 * */

}
