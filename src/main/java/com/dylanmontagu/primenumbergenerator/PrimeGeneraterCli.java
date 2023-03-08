package com.dylanmontagu.primenumbergenerator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeGeneraterCli {

	PrimeNumberGenerator generator;
	UserState userState;
	
	PrimeGeneraterCli(PrimeNumberGenerator generator) {
		this.generator = generator;
		this.userState = new UserState();
	}
	
	public void generatePrimesFromCliInput() {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Prime number generator returns all prime numbers in a given range (inclusive)");
        
        // get starting value input from user
        System.out.print("Enter starting value of range: ");
        while (!userState.isStartingValueSet()) {
	        try {
				userState.setStartingValue(in.nextInt());
				userState.setStartingValueSet(true);
				break;
			} catch (InputMismatchException e) {
				System.out.print("Value inputted is not a valid int. Please enter a valid starting value: ");
				in.next();
			}
    	}

        // get ending value input from user
        System.out.print("Enter ending value of range: ");
        while (!userState.isEndingValueSet()) {
	        try {
				userState.setEndingValue(in.nextInt());
				userState.setEndingValueSet(true);
				break;
			} catch (InputMismatchException e) {
				System.out.print("Value inputted is not a valid int. Please enter a valid ending value: ");
				in.next();
			}
    	}
        
        System.out.println(String.format("Prime numbers between %d and %d are listed below:", 
        		userState.getStartingValue(), userState.getEndingValue()));
        System.out.println(generator.generate(userState.getStartingValue(), userState.getEndingValue()));
        
        userState.setPrimeNumbersPrinted(true);
        in.close();
        
	}
}
