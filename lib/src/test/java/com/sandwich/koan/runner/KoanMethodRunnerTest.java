package com.sandwich.koan.runner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sandwich.koan.KoanMethod;
import com.sandwich.koan.path.CommandLineTestCase;
import com.sandwich.koan.result.KoanMethodResult;
import com.sandwich.koan.suite.NoAssertionKoan;
import com.sandwich.koan.suite.OnePassingKoan;

public class KoanMethodRunnerTest extends CommandLineTestCase {

	@Test
	public void koanWithAssertionPasses() throws Exception {
		KoanMethodResult result = KoanMethodRunner.run(
			new OnePassingKoan(),
			KoanMethod.getInstance(OnePassingKoan.class.getDeclaredMethod("koan")));
		assertTrue(result.isPassed());
	}

	@Test
	public void koanWithoutAssertionFails() throws Exception {
		KoanMethodResult result = KoanMethodRunner.run(
			new NoAssertionKoan(),
			KoanMethod.getInstance(NoAssertionKoan.class.getDeclaredMethod("koan")));
		assertFalse(result.isPassed());
		assertEquals("No assertion was invoked in this koan.", result.getMessage());
	}

	@Test
	public void assertionTrackingResetsBetweenKoans() throws Exception {
		KoanMethodResult first = KoanMethodRunner.run(
			new OnePassingKoan(),
			KoanMethod.getInstance(OnePassingKoan.class.getDeclaredMethod("koan")));
		KoanMethodResult second = KoanMethodRunner.run(
			new NoAssertionKoan(),
			KoanMethod.getInstance(NoAssertionKoan.class.getDeclaredMethod("koan")));
		assertTrue(first.isPassed());
		assertFalse(second.isPassed());
	}

	@Test
	public void koanWithoutAssertionCanBeAllowedToPass() throws Exception {
		KoanMethodResult result = KoanMethodRunner.run(
			new NoAssertionKoan(),
			KoanMethod.getInstance(NoAssertionKoan.class.getDeclaredMethod("koan"), false));
		assertTrue(result.isPassed());
	}
}
