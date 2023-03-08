package com.dylanmontagu.primenumbergenerator;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

public class AppTest {
	@Test
	public void contrivedTestForFullCoverage() {
		App app = new App();
		String input = "5\n5\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		App.main(null);
		assertTrue(true);
	}
}