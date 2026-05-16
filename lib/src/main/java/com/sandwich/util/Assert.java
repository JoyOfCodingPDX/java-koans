package com.sandwich.util;

import com.sandwich.koan.KoanIncompleteException;
import com.sandwich.koan.constant.KoanConstants;

import static com.sandwich.koan.constant.KoanConstants.__;

public class Assert {

	static final String EXPECTED	= "expected:<";
	static final String END 		= ">";
	static final String BUT_WAS 	= "> but was:<";
	private static final ThreadLocal<Integer> ASSERTION_COUNT = ThreadLocal.withInitial(() -> 0);

	public static void resetAssertionTracking() {
		ASSERTION_COUNT.set(0);
	}

	public static boolean wasAssertionInvoked() {
		return ASSERTION_COUNT.get() > 0;
	}

	private static void assertionInvoked() {
		ASSERTION_COUNT.set(ASSERTION_COUNT.get() + 1);
	}
	
	public static void assertEquals(String msg, Object o0, Object o1){
		assertionInvoked();
		if(o0 == null && o1 != null){
			fail(msg, o0, o1);
		}
		if(o1 == null && o0 != null){
			fail(msg, o0, o1);
		}
		// not if o0 == o1 return, because equals may violate contract (though
		// that's obviously strongly discouraged), but cannot invoke equals on 
		// null pointer w/o sacrificing functionality from anticipating failure
		if(o1 == null && o0 == null){
			return;
		}
		if(!o0.equals(o1)){
			fail(msg, o0, o1);
		}
	}
	
	public static void assertEquals(Object o0, Object o1){
		assertEquals("", o0, o1);
	}

	public static void assertTrue(Object t){
		assertionInvoked();
		assertEquals(true,t);
	}
	
	public static void assertFalse(Object f){
		assertionInvoked();
		assertEquals(false,f);
	}
	
	public static void assertNull(Object o){
		assertionInvoked();
		assertEquals(null, o);
	}
	
	public static void assertNotNull(Object o){
		assertionInvoked();
		if(o == null){
			fail("something other than null",o);
		}
	}
	
	public static void assertSame(Object o0, Object o1){
		assertionInvoked();
		if(o0 != o1){
			fail("Are the same instance... ",o0,o1);
		}
	}
	
	public static void assertNotSame(Object o0, Object o1){
		assertionInvoked();
		if(o0 == o1){
			fail("Not the same instance... ",o0,o1);
		}
	}
	
	public static void fail(Object o0, Object o1) throws KoanIncompleteException {
		fail("", o0, o1);
	}
	
	public static void fail(String msg, Object o0, Object o1){
		Object expected = o0;
		Object actual = o1;

		if (wasNotAttempted(actual)) {
			expected = "Something other than " + __;
		}

		String message = new StringBuilder()
			.append(msg)
			.append(msg.length() == 0 ? "" : KoanConstants.EOL)
			.append(EXPECTED)
			.append(expected)
			.append(BUT_WAS)
			.append(actual)
			.append(END)
			.toString();
		fail(message);
	}

	private static boolean wasNotAttempted(Object actual) {
		return actual == __;
	}

	public static void fail(String msg){
		assertionInvoked();
		throw new KoanIncompleteException(msg);
	}
}
