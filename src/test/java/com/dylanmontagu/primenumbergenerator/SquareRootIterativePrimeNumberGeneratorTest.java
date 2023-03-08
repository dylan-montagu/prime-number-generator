package com.dylanmontagu.primenumbergenerator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class SquareRootIterativePrimeNumberGeneratorTest {
	static PrimeNumberGenerator generator;
	
	@BeforeClass
	public static void setup() {
		generator = new SquareRootIterativePrimeNumberGenerator();
	}
	
	@Test
	public void testIsPrimeOnPrimeNumbers() {
		List<Integer> primeNumbers = Arrays.asList(2, 3, 97, 7901, 7907, 7919);
		primeNumbers.forEach(primeNumber -> {
			assertTrue(generator.isPrime(primeNumber));
		});
	}
	
	@Test
	public void testIsPrimeOnNonPrimeNumbers() {
		List<Integer> nonPrimeNumbers = Arrays.asList(6, 1, -2, 7010, -1000, 0);
		nonPrimeNumbers.forEach(nonPrimeNumber -> {
			assertFalse(generator.isPrime(nonPrimeNumber));
		});
	}

	@Test
	public void testGenerateWithNumericallyIncreasingArguments() {
		List<Integer> primeNumberResults = Arrays.asList(7901, 7907, 7919);
		assertEquals(primeNumberResults, generator.generate(7900, 7920));

		primeNumberResults = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
		assertEquals(primeNumberResults, generator.generate(-10, 20));
	}

	@Test
	public void testGenerateWithNumericallyDecreasingArguments() {
		List<Integer> primeNumberResults = Arrays.asList(7901, 7907, 7919);
		assertEquals(primeNumberResults, generator.generate(7920, 7900));

		primeNumberResults = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
		assertEquals(primeNumberResults, generator.generate(20, -10));
	}
}
