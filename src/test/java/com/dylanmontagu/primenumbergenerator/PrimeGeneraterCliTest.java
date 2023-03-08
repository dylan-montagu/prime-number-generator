package com.dylanmontagu.primenumbergenerator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.any;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class PrimeGeneraterCliTest {

	static PrimeGeneraterCli cli;
	static PrimeNumberGenerator generator;
	static PrimeGeneraterCli spyCli;
	
	@BeforeClass
	public static void setup() {
		generator = new SixKPrimeNumberGenerator();
		cli = new PrimeGeneraterCli(generator);
		spyCli = spy(new PrimeGeneraterCli(generator));
	}
	
	@After
	public void resetUser() {
		spyCli.userState.reset();
	}
	
	void StringToStdIn(String input) {
    	InputStream in = new ByteArrayInputStream(input.getBytes());
    	System.setIn(in);
	}
	
	/*
	 * Testing the equivalent of the following console output: 
	 * """
		 	Prime number generator returns all prime numbers in a given range (inclusive)
			Enter starting value of range: 1
			Enter ending value of range: 9
			Prime numbers between 1 and 9 are listed below:
			[2, 3, 5, 7]
	 * """
	 */
	@Test
	public void testValidInputs() {
		// arbitrary input data for spy'd scanner runs, not actually used
    	StringToStdIn("1\n1\n1\n1\n1\n1\n");
		
		doReturn(7)
				.doReturn(7)
				.when(spyCli).getInput(any(Scanner.class));
		
		spyCli.generatePrimesFromCliInput();
		assertTrue(spyCli.userState.isPrimeNumbersPrinted());
	}
	

	/*
	 * Testing the equivalent of the following console output: 
	 * """
		 	Prime number generator returns all prime numbers in a given range (inclusive)
			Enter starting value of range: a
			Value inputted is not a valid int. Please enter a valid starting value: 1
			Enter ending value of range: b
			Value inputted is not a valid int. Please enter a valid ending value: 9
			Prime numbers between 1 and 9 are listed below:
			[2, 3, 5, 7]
	 * """
	 */
	@Test 
	public void testNonValidInputs() {
		// arbitrary input data for spy'd scanner runs, not actually used    	
    	StringToStdIn("1\n1\n1\n1\n1\n1\n");
		
		doThrow(new InputMismatchException())
				.doReturn(1)
				.doThrow(new InputMismatchException())
				.doReturn(9)
				.when(spyCli).getInput(any(Scanner.class));
		
		spyCli.generatePrimesFromCliInput();
		assertTrue(spyCli.userState.isPrimeNumbersPrinted());
	}
	
	@Test
	public void testGetInput() {
    	StringToStdIn("5\n");
    	Scanner scanner = new Scanner(System.in);
    	
		assertEquals(5, cli.getInput(scanner));
	}
	
	@Test(expected = InputMismatchException.class)
	public void testGetInputWithInvalidInput() {
    	StringToStdIn("a\n");
    	Scanner scanner = new Scanner(System.in);
    	
    	cli.getInput(scanner);
	}
	
	
	@Ignore ("Testing against string output brittle")
	@Test
	public void testValidIntInputs() {
    	String input = "5\n5\n";
    	InputStream in = new ByteArrayInputStream(input.getBytes());
    	System.setIn(in);
    	
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    	
    	cli.generatePrimesFromCliInput();
    	String expectedOutput = new String("Prime number generator returns all prime numbers in a given range (inclusive)\n"
    			+ "Enter starting value of range: "
    			+ "Enter ending value of range: "
    			+ "Prime numbers between 5 and 5 are listed below:\n"
    			+ "[5]\n");
    	assertEquals(expectedOutput, outContent.toString());
	}	
	
	@Ignore ("Testing against string output brittle")
	@Test
	public void testInvalidInputs() {
    	String input = "a\n5\na\n5\n";
    	InputStream in = new ByteArrayInputStream(input.getBytes());
    	System.setIn(in);
    	
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    	
    	cli.generatePrimesFromCliInput();
    	String expectedOutput = new String("Prime number generator returns all prime numbers in a given range (inclusive)\n"
    			+ "Enter starting value of range: "
    			+ "Value inputted is not a valid int. Please enter a valid starting value: "
    			+ "Enter ending value of range: "
    			+ "Value inputted is not a valid int. Please enter a valid ending value: "
    			+ "Prime numbers between 5 and 5 are listed below:\n"
    			+ "[5]\n");
    	assertEquals(expectedOutput, outContent.toString());
	}

}
