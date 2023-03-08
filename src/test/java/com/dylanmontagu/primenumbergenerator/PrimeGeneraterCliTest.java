package com.dylanmontagu.primenumbergenerator;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;
import org.junit.Test;

public class PrimeGeneraterCliTest {

	static PrimeGeneraterCli cli;
	static PrimeNumberGenerator generator;
	
	@BeforeClass
	public static void setup() {
		generator = new SixKPrimeNumberGenerator();
		cli = new PrimeGeneraterCli(generator);
	}

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
