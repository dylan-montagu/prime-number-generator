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
	
	int getInput(Scanner scanner) {
		return scanner.nextInt();
	}
	
	public void generatePrimesFromCliInput() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Prime number generator returns all prime numbers in a given range (inclusive)");
        
        // get starting value input from user
        System.out.print("Enter starting value of range: ");
        while (!userState.isStartingValueSet()) {
	        try {
				userState.setStartingValue(getInput(scanner));
				userState.setStartingValueSet(true);
				break;
			} catch (InputMismatchException e) {
				System.out.print("Value inputted is not a valid int. Please enter a valid starting value: ");
				scanner.next();
			}
    	}

        // get ending value input from user
        System.out.print("Enter ending value of range: ");
        while (!userState.isEndingValueSet()) {
	        try {
				userState.setEndingValue(getInput(scanner));
				userState.setEndingValueSet(true);
				break;
			} catch (InputMismatchException e) {
				System.out.print("Value inputted is not a valid int. Please enter a valid ending value: ");
				scanner.next();
			}
    	}
        
        System.out.println(String.format("Prime numbers between %d and %d are listed below:", 
        		userState.getStartingValue(), userState.getEndingValue()));
        System.out.println(generator.generate(userState.getStartingValue(), userState.getEndingValue()));
        
        //clean up
        userState.setPrimeNumbersPrinted(true);
        scanner.close();
        
	}
}
