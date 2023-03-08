package com.dylanmontagu.primenumbergenerator;

import java.util.List;

interface PrimeNumberGenerator {

    List<Integer> generate(int startingValue, int endingValue);
    
    boolean isPrime(int value);
}
