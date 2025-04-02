package Day03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;
import org.junit.jupiter.*;

import static org.junit.jupiter.api.Assertions.*;


public class UtilsTestcase {
	
	public class Point implements Comparable<Point>{
		
		@Override
		public int compareTo(Point other) {
			if(this == other || this.equals(other))
			 return 0;
			
			int diffx = x - other.x;
			
			if(diffx == 0) return y - other.y;
			return diffx;
		}
		
		



		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(x, y);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return x == other.x && y == other.y;
		}





		private int x;
		private int y;
		
		//constructor
		
		public Point() {}
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	
		


		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}

		private UtilsTestcase getEnclosingInstance() {
			return UtilsTestcase.this;
		}

	
		
		
	}
	
	//starting test cases

	@Test
	public void testMap() {
		tryingMaps(new HashMap<String, Integer>());
		tryingMaps(new TreeMap<String, Integer>());

		
	}
	
	public void tryingMaps(Map<String, Integer> numbers) {
		assertEquals(0, numbers.size());
		numbers.put("One", 1);
		assertEquals(1, numbers.size());
		assertEquals(1, numbers.get("One"));
		numbers.put("One", 2);
		assertEquals(1, numbers.size());
		assertEquals(2, numbers.get("One"));
		numbers.put("one", 1);
		assertEquals(2, numbers.size());
		assertEquals(1, numbers.get("one"));


	}
	
	@Test
	public void testArrayList() {
		tryingList(new ArrayList<UtilsTestcase.Point>());
		tryingList(new LinkedList<UtilsTestcase.Point>());

		
	}
	
	
	public void tryingList(List<Point> points) {
		assertEquals(0, points.size());
		Point p = new Point(2,3);
		points.add(p);
		assertEquals(1, points.size());
		points.add(p);
		assertEquals(2, points.size());
		points.add(new Point(2,3));
		assertEquals(3, points.size());
		points.add(new Point(3,2));
		assertEquals(4, points.size());

	}
	
	public void tryingSets(Set<Point> points) {
		assertEquals(0, points.size());
		Point p = new Point(2,3);
		points.add(p);
		assertEquals(1, points.size());
		points.add(p);
		assertEquals(1, points.size());
		points.add(new Point(2,3));
		assertEquals(1, points.size());
		points.add(new Point(3,2));
		assertEquals(2, points.size());

	}
	
	@Test
	public void testHAsh() {
		tryingSets(new HashSet<UtilsTestcase.Point>());
	}
	
	@Test
	public void testset() {
		
	}
	
}
