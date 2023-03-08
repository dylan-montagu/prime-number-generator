package com.dylanmontagu.primenumbergenerator;

import java.util.ArrayList;
import java.util.List;

public class SquareRootIterativePrimeNumberGenerator implements PrimeNumberGenerator {

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

		for (int i = 2; i <= Math.sqrt(value) + 1; i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}
}