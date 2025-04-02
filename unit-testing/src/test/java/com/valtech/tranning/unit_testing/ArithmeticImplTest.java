package com.valtech.tranning.unit_testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ArithmeticImplTest {
	
	private arithmetic a;
	
	@BeforeAll
	public static void test() {
		System.out.println("before all...");
	}
	
	@BeforeEach
	public void some() {
		System.out.println("before method");
		a  = new ArithmeticImpl();
	}
	
	@ParameterizedTest(name="Addmethod call with multiple value")
	@ValueSource(strings = {"5,2,3","10,5,5"})
	void testAddAgain(String params) {
		List<Integer> args = Arrays.asList(params.split(",")).stream().map(it -> Integer.parseInt(it)).collect(Collectors.toList());
		assertEquals(args.get(0), a.add(args.get(1), args.get(2)));
	}
	
	@ParameterizedTest(name="Add with CSV source A={0} B={1} Result={2}")
	@CsvSource(value  = {"4,2,2"})
	void testAddCsv(int c,int b, int res) {
		assertEquals(res, a.add(c, b));
	}
	
	
	@ParameterizedTest(name="Add with CSV source A={0} B={1} C={2}")
	@CsvFileSource(files="data.csv")
	void testAddCsvFile(int c,int b, int res) {
		assertEquals(res, a.add(c, b));
	
	}
	
	@ParameterizedTest(name="Add with Method source A={0} B={1} C={2}")
	@MethodSource(value="addArguments")
	void testAddMethod(int c,int b, int res) {
		assertEquals(res, a.add(c, b));
	
	}
	
	static Stream<Arguments> addArguments(){
		return Stream.of(Arguments.of(5,3,5),Arguments.of(10,5,5));
	}
	
	
	@Test
	void testAdd() {
		
		assertEquals(5, a.add(2, 3));
	}
	
	@Test
	void testSub() {
		assertEquals(-1, a.sub(2, 3));

		
	}@Test
	void testDiv() {
		
		
	}

}
