package Day03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import Day02.Car;

class LambdaExpression {

	@Test
	void test() {
		List<Car> cars = new ArrayList<Car>();
		cars.add(Car.builder().make("Honda").model("City").year(2024).version("ab").variant("bv").build());
		cars.add(new Car("Mini","Cooper",2024,3,7));
		
		cars.add(Car.builder().make("Honda").model("City").year(2024).version("xt").variant("uv").build());
		List<Car> newcar = new ArrayList<Car>();
		for (Car car : cars) {
			if(car.getVariant() > 5) {
				newcar.add(car);
			}
		}
		System.out.println(newcar);
		
		List<Car> mycar = cars.stream().filter(car -> car.getVersion() > 5).collect(Collectors.toList());
		System.out.println(mycar);
		
		System.out.println(cars.stream().filter(car -> "Mini".equals(car.getMake())).collect(Collectors.toList()));
		
		System.out.println(cars.stream().map(car -> car.getMake()).collect(Collectors.toSet()));
		}
	

}
