package com.dylanmontagu.primenumbergenerator;

public class App 
{
    public static void main( String[] args ) {
    	PrimeGeneraterCli cli = new PrimeGeneraterCli(new SquareRootIterativePrimeNumberGenerator());
    	cli.generatePrimesFromCliInput();
    }
}
