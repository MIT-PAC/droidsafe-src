package dk.brics.string.intermediate.operations;

/**
 * Describes the known aliasing status between two variables. Represents the elements
 * of the lattice:
 * <pre>
 *    {@link #MAYBE}
 *   /     \
 *  {@link #NOT}  {@link #DEFINITELY}
 *   \     /
 *    {@link #BOTTOM}
 * </pre>
 */
public enum AliasStatus {
	/**
	 * The two variables may or may not be aliased.
	 */
	MAYBE(0),
	
	/**
	 * The two variables are definitely aliased.
	 */
	DEFINITELY(1),
	
	/**
	 * The two variables are definitely not aliased.
	 */
	NOT(2),
	
	/**
	 * Bottom element.
	 */
	BOTTOM(3);
	
	private int index;
	private AliasStatus(int index) {
		this.index = index;
	}
	
	private static final AliasStatus[][] LEAST_UPPER_BOUND = {
		{MAYBE,		MAYBE,		MAYBE,		MAYBE},
		{MAYBE,		DEFINITELY,	MAYBE,		DEFINITELY},
		{MAYBE,		MAYBE,		NOT,		NOT},
		{MAYBE,		DEFINITELY,	NOT,		BOTTOM},
	};
	
	private static final AliasStatus[][] GREATEST_LOWER_BOUND = {
		{MAYBE,		DEFINITELY,	NOT,		BOTTOM},
		{DEFINITELY,DEFINITELY,	BOTTOM,		BOTTOM},
		{NOT,		BOTTOM,		NOT,		BOTTOM},
		{BOTTOM,	BOTTOM,		BOTTOM,		BOTTOM},
	};
	
	/**
	 * Returns true if this is {@link #DEFINITELY} or {@link #MAYBE}.
	 */
	public boolean mightBeAlias() {
		return this == DEFINITELY || this == MAYBE;
	}
	/**
	 * Returns true if this is {@link #DEFINITELY} or {@link #BOTTOM}.
	 */
	public boolean isDefinitelyOrBottom() {
		return this == DEFINITELY || this == BOTTOM;
	}
	
	public AliasStatus leastUpperBound(AliasStatus other) {
		return LEAST_UPPER_BOUND[index][other.index];
	}
	public AliasStatus greatestLowerBound(AliasStatus other) {
		return GREATEST_LOWER_BOUND[index][other.index];
	}
}
