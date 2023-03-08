package com.dylanmontagu.primenumbergenerator;

public class App 
{
    public static void main( String[] args ) {
    	PrimeGeneratorCli cli = new PrimeGeneratorCli(new SixKPrimeNumberGenerator());
    	cli.generatePrimesFromCliInput();
    }
}