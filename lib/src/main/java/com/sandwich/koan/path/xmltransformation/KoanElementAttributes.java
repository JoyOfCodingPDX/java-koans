package com.sandwich.koan.path.xmltransformation;


public class KoanElementAttributes{
	
	public String name, displayIncompleteKoanException, requireAssertion, className;
	
	public KoanElementAttributes(String name, String displayIncompleteKoanException, String requireAssertion, String className){
		this.name = name;
		this.displayIncompleteKoanException = displayIncompleteKoanException;
		this.requireAssertion = requireAssertion;
		this.className = className;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((className == null) ? 0 : className.hashCode());
		result = prime
				* result
				+ ((displayIncompleteKoanException == null) ? 0
						: displayIncompleteKoanException.hashCode());
		result = prime * result
				+ ((requireAssertion == null) ? 0 : requireAssertion.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KoanElementAttributes other = (KoanElementAttributes) obj;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (displayIncompleteKoanException == null) {
			if (other.displayIncompleteKoanException != null)
				return false;
		} else if (!displayIncompleteKoanException
				.equals(other.displayIncompleteKoanException))
			return false;
		if (requireAssertion == null) {
			if (other.requireAssertion != null)
				return false;
		} else if (!requireAssertion.equals(other.requireAssertion))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KoanElementAttributes [name=" + name
				+ ", displayIncompleteKoanException="
				+ displayIncompleteKoanException + ", requireAssertion="
				+ requireAssertion + ", className=" + className
				+ "]";
	}
	
}
