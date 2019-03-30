package com.capgemini.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.demo.MathApplication;
import com.capgemini.demo.exception.InputInvalidExceptions;
import com.capgemini.demo.service.CalculatorService;

public class MathApplicationTest {

	@Mock
	private CalculatorService service;

	@InjectMocks
	MathApplication application = new MathApplication(service);

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testToPerformAdditionWithTwoPositiveNumbers() {
		when(service.addition(4, 4)).thenReturn(8);
		assertEquals(8, service.addition(4, 4));
	}

	@Test
	public void testToPerformAdditionWithOnePositiveAndOneNegative() {
		when(service.addition(8, -2)).thenReturn(6);
		assertEquals(6, service.addition(8, -2));
	}

	@Test
	public void testToPerformAdditionWithTwoNegativeNumbers() {
		when(service.addition(-8, -2)).thenReturn(-10);
		assertEquals(-10, service.addition(-8, -2));

	}

	@Test
	public void testToPerformSubtractionWithTwoPositiveNumbers() {
		when(service.addition(4, 2)).thenReturn(2);
		assertEquals(2, service.addition(4, 2));
	}

	@Test
	public void testToPerformSubtractionWithOnePositiveAndOneNegative() {
		when(service.addition(8, -2)).thenReturn(10);
		assertEquals(10, service.addition(8, -2));
	}

	@Test
	public void testToPerformSubtractionWithTwoNegativeNumbers() {
		when(service.addition(-8, -2)).thenReturn(-6);
		assertEquals(-6, service.addition(-8, -2));

	}

	@Test
	public void testToPerformMultiplicationWithTwoPositiveNumbers() {
		when(service.addition(4, 4)).thenReturn(16);
		assertEquals(16, service.addition(4, 4));
	}

	@Test
	public void testToPerformMultiplicationWithOnePositiveAndOneNegative() {
		when(service.addition(8, -2)).thenReturn(-16);
		assertEquals(-16, service.addition(8, -2));
	}

	@Test
	public void testToPerformMultiplicationWithTwoNegativeNumbers() {
		when(service.addition(-8, -2)).thenReturn(16);
		assertEquals(16, service.addition(-8, -2));

	}

	@Test
	public void testToPerformMultiplicationWithZero() {
		when(service.addition(10, 0)).thenReturn(0);
		assertEquals(0, service.addition(10, 0));
	}

	@Test
	public void testToPerformDivisionWithTwoPositiveNumbers() {
		when(service.addition(4, 4)).thenReturn(1);
		assertEquals(1, service.addition(4, 4));
	}

	@Test
	public void testToPerformDivisionWithOnePositiveAndOneNegative() {
		when(service.addition(8, -2)).thenReturn(-4);
		assertEquals(-4, service.addition(8, -2));
	}

	@Test
	public void testToPerformDivisionWithTwoNegativeNumbers() {
		when(service.addition(-8, -2)).thenReturn(4);
		assertEquals(4, service.addition(-8, -2));

	}

	@Test(expected = ArithmeticException.class)
	public void testToPerformDivisionByDividingWithZero() {
		doThrow(new ArithmeticException("Dividing with zero")).when(service).division(5, 0);
		service.division(5, 0);
	}

	@Test
	public void testToPerformFacatorialOfANumber() throws InputInvalidExceptions {
		when(service.factorial(4)).thenReturn(24L);
		assertEquals(24L, service.factorial(4));
	}

	@Test(expected = InputInvalidExceptions.class)
	public void testToPerformFactorialOfANumberLessThan1() throws InputInvalidExceptions {
		doThrow(new InputInvalidExceptions("Should not be less than1")).when(service).factorial(0); 
		service.factorial(0);

	}

	@Test
	public void testToPerformSquareOfANumberWithPositiveNumber() {
		when(service.square(8)).thenReturn(64L);
		assertEquals(64L, service.square(8));
	}

	@Test
	public void testToPerformSquareOfANumberWithNegativeNumber() {
		when(service.square(-5)).thenReturn(25L);
		assertEquals(25L, service.square(-5));
	}
}
