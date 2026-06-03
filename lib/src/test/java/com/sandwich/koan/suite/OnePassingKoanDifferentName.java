package com.sandwich.koan.suite;

import static com.sandwich.util.Assert.assertTrue;

import com.sandwich.koan.Koan;

public class OnePassingKoanDifferentName extends OnePassingKoan {

	@Koan
	public void koan() {
		assertTrue(true);
	}
	
}
