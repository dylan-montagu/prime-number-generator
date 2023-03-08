package com.dylanmontagu.primenumbergenerator;

public class App 
{
    public static void main( String[] args ) {
    	PrimeGeneratorFromCli cli = new PrimeGeneratorFromCli(new SixKPrimeNumberGenerator(), new UserState());
    	cli.generatePrimesFromInput();
    }
}