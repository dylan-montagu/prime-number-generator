package com.dylanmontagu.primenumbergenerator;

import java.util.ArrayList;
import java.util.List;

public class SixKPrimeNumberGenerator implements PrimeNumberGenerator {

	@Override
	public List<Integer> generate(int startingValue, int endingValue) {
		List<Integer> primeNumbers = new ArrayList<>();

		for (int i = Math.min(startingValue, endingValue); i <= Math.max(startingValue, endingValue); i++) {
			if (isPrime(i)) {
				primeNumbers.add(i);
			}
		}
		return primeNumbers;
	}

	@Override
	public boolean isPrime(int value) {
		if (value < 2)
			return false;
		if (value == 2 || value == 3)
			return true;
		if (value % 2 == 0 || value % 3 == 0)
			return false;

		for (int i = 6; i <= Math.sqrt(value) + 1; i += 6) {
			if (value % (i - 1) == 0 || value % (i + 1) == 0) {
				return false;
			}
		}
		return true;
	}
}
