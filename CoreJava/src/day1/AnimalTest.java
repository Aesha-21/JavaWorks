package day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimalTest {

	@Test
	void testDog() {
		Dog d = new Dog();
		ShowBehavior(d);
		//fail("it's failed");
	}

	@Test
	void testCat() {
		ShowBehavior(new Cat());
	}

	@Test
	void testTiger() {
		ShowBehavior(new Tiger());
	}

	private void ShowBehavior(Animal a) {
		a.drink();
		a.eat();
		a.maksound();
	}
}
