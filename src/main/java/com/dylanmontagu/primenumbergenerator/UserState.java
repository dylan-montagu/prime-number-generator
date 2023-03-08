package com.dylanmontagu.primenumbergenerator;

public class UserState {

	private int startingValue;
	private boolean startingValueSet;
	private int endingValue;
	private boolean endingValueSet;
	private boolean primeNumbersPrinted;

	public UserState() {
		this.startingValueSet = false;
		this.endingValueSet = false;
		this.primeNumbersPrinted = false;
	}

	// useful if repeating prime generator with same user, and for testing
	public void reset() {
		this.startingValueSet = false;
		this.endingValueSet = false;
		this.primeNumbersPrinted = false;
	}

	public int getStartingValue() {
		return startingValue;
	}

	public void setStartingValue(int startingValue) {
		this.startingValue = startingValue;
	}

	public boolean isStartingValueSet() {
		return startingValueSet;
	}

	public void setStartingValueSet(boolean startingValueSet) {
		this.startingValueSet = startingValueSet;
	}

	public int getEndingValue() {
		return endingValue;
	}

	public void setEndingValue(int endingValue) {
		this.endingValue = endingValue;
	}

	public boolean isEndingValueSet() {
		return endingValueSet;
	}

	public void setEndingValueSet(boolean endingValueSet) {
		this.endingValueSet = endingValueSet;
	}

	public boolean isPrimeNumbersPrinted() {
		return primeNumbersPrinted;
	}

	public void setPrimeNumbersPrinted(boolean primeNumbersReturned) {
		this.primeNumbersPrinted = primeNumbersReturned;
	}
}
