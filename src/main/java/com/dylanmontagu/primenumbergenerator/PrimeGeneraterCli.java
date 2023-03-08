package com.dylanmontagu.primenumbergenerator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeGeneraterCli {

	PrimeNumberGenerator generator;

	PrimeGeneraterCli(PrimeNumberGenerator generator) {
		this.generator = generator;
	}
	
	public void generatePrimesFromCliInput() {
		int startingValue, endingValue;
        Scanner in = new Scanner(System.in);
        
        System.out.println("Prime number generator returns all prime numbers in a given range (inclusive)");
        
        // get starting value input from user
        System.out.print("Enter starting value of range: ");
        while (true) {
	        try {
				startingValue = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.print("Value inputted is not a valid int. Please enter a valid starting value: ");
				in.next();
			}
    	}
        
        // get ending value input from user
        System.out.print("Enter ending value of range: ");
        while (true) {
	        try {
				endingValue = in.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.print("Value inputted is not a valid int. Please enter a valid ending value: ");
				in.next();
			}
    	}
        
        System.out.println("Prime numbers between " + startingValue + " and " + endingValue + " are listed below:");
        System.out.println(generator.generate(startingValue, endingValue));
        
        in.close();
	}
}
