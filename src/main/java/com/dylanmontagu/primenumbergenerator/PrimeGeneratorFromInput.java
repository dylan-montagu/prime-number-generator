package com.dylanmontagu.primenumbergenerator;

import java.util.List;
import java.util.Scanner;

public interface PrimeGeneratorFromInput {

	int getInput(Scanner scanner);

	public List<Integer> generatePrimesFromInput();

}
