package com.dylanmontagu.primenumbergenerator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PrimeNumberGeneratorTest {
	private PrimeNumberGenerator generator;
	
    public PrimeNumberGeneratorTest(PrimeNumberGenerator generator) {
    	this.generator = generator;
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
      return Arrays.asList(new Object[][] {
        { new SquareRootIterativePrimeNumberGenerator() },
        { new SixKPrimeNumberGenerator() }
      });
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
		List<Integer> expectedPrimeNumberResults = Arrays.asList(7901, 7907, 7919);
		assertEquals(expectedPrimeNumberResults, generator.generate(7900, 7920));

		expectedPrimeNumberResults = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
		assertEquals(expectedPrimeNumberResults, generator.generate(-10, 20));
	}

	@Test
	public void testGenerateWithNumericallyDecreasingArguments() {
		List<Integer> expectedPrimeNumberResults = Arrays.asList(7901, 7907, 7919);
		assertEquals(expectedPrimeNumberResults, generator.generate(7920, 7900));

		expectedPrimeNumberResults = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
		assertEquals(expectedPrimeNumberResults, generator.generate(20, -10));
	}
	
	@Test
	public void testGenerateWithEqualArguments() {
		List<Integer>expectedPrimeNumberResults = Arrays.asList(7901);
		assertEquals(expectedPrimeNumberResults, generator.generate(7901, 7901));
	}
}
