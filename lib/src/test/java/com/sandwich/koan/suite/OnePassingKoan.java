package com.sandwich.koan.suite;

import static com.sandwich.util.Assert.assertTrue;

import com.sandwich.koan.Koan;

public class OnePassingKoan {
	boolean[] invoked;
	public OnePassingKoan(){
		invoked = new boolean[]{false};
	}
	@Koan
	public void koan() {
		invoked[0] = true;
		assertTrue(invoked[0]);
	}
}
