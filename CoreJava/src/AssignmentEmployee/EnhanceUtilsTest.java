package AssignmentEmployee;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class EnhanceUtilsTest {

	@Test

	public void testMap() {
		Map<String, Integer> nums = Map.of("one", 1, "Two", 2, "Three", 3);
		try {
			System.out.println(nums.getClass().getName());
			System.out.println(nums.keySet());

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	// ex of create list on diff ways

	@Test
	public void testList() {
		List<Integer> nums = List.of(1, 2, 3, 4);
		try {
			nums.add(5);
			fail("Immutable list expected");

		} catch (Exception ex) {
			// ex.printStackTrace();

		}

		List<Integer> nums1 = new ArrayList<Integer>();
		nums1.addAll(nums);
		nums1.add(5);
	}

	@Test
	public void testMapConventional() {
		Map<String, Integer> nums = new HashMap<String, Integer>();
		nums.put("one", 1);
		nums.put("Two", 2);
		nums.put("Three", 3);

	}

	@Test
	void testListConventionl() {

		List<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		System.out.println(nums);
		List<Integer> nums1 = Arrays.asList(1, 2, 3);
		assertEquals(nums, nums1);

	}

}
