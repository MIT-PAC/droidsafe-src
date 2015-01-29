package dk.brics.string.util;

/**
 * A generic, immutable pair of two objects. Implements <tt>equals</tt> and <tt>hashCode</tt>.
 */
public final class Pair<A,B> {
	private final A first;
	private final B second;
	
	public Pair(A first, B second) {
		this.first = first;
		this.second = second;
	}

	public A getFirst() {
		return first;
	}

	public B getSecond() {
		return second;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
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
		Pair<?,?> other = (Pair<?,?>) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}
	
	/**
	 * Convenience method for creating a new pair, since generic arguments may be inferred
	 * by a static method call but not by a constructor call.
	 */
	public static <A,B> Pair<A,B> make(A a, B b) {
	    return new Pair<A,B>(a,b);
	}
	
}
