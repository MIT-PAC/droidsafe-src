package dk.brics.string.util;

/**
 * An unordered immutable pair of elements. <i>Unordered</i> means the pair <tt>(a,b)</tt> equals the
 * pair <tt>(b,a)</tt>. An element of a pair cannot be <tt>null</tt>.
 * <p/>
 * The class implements {@link Comparable}. Pairs are compared by their smallest elements, and if
 * those are equal, they are compared by their maximum elements.
 * <p/>
 * To work correctly, the underlying element type must implement {@link Object#equals} and
 * {@link Comparable#compareTo} in a consistent fashion.
 */
public final class UnorderedPair<E extends Comparable<E>> implements Comparable<UnorderedPair<E>> {
	private final E first;
	private final E second;
	
	/**
	 * Creates an unordered pair of the specified elements. The order of the arguments is irrelevant,
	 * so the first argument is not guaranteed to be returned by {@link #getFirst()}, for example.
	 * @param a one element of the pair. Must not be <tt>null</tt>.
	 * @param b one element of the pair. Must not be <tt>null</tt>. May be the same as <tt>a</tt>.
	 */
	public UnorderedPair(E a, E b) {
		if (a.compareTo(b) < 0) {
			this.first = a;
			this.second = b;
		} else {
			this.first = b;
			this.second = a;
		}
	}
	
	/**
	 * Gets the smallest element of the pair (according to its {@link Comparable} implementation).
	 * @return an element of the pair. <tt>null</tt> is never returned.
	 */
	public E getFirst() {
		return first;
	}
	
	/**
	 * Gets the largest element of the pair (according to its {@link Comparable} implementation).
	 * @return an element of the pair. <tt>null</tt> is never returned.
	 */
	public E getSecond() {
		return second;
	}

	@Override
	public int hashCode() {
		return 31 * first.hashCode() + 173 * second.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnorderedPair<?> other = (UnorderedPair<?>) obj;
		if (!first.equals(other.first))
			return false;
		if (!second.equals(other.second))
			return false;
		return true;
	}
	
	public int compareTo(UnorderedPair<E> o) {
		int firstCmp = first.compareTo(o.first);
		if (firstCmp != 0)
			return firstCmp;
		return second.compareTo(o.second);
	}
	
	@Override
	public String toString() {
		return "(" + first + "," + second + ")";
	}
}
