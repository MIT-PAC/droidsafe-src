package dk.brics.string.intermediate.operations;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import dk.brics.string.intermediate.Variable;
import dk.brics.string.util.UnorderedPair;

/**
 * Represents the aliasing status between a set of variables.
 * <p/>
 * This class is responsible for an efficient representation. To this end, the following semantic
 * assumptions are exploited:
 * <ul>
 * <li>A variable is always definitely an alias of itself.
 * <li>Two variables of incompatible types are definitely not aliases.
 * </ul>
 * Those assumptions affect the behaviour of the {@link #setAliasStatus} methods in these ways:
 * <ul>
 * <li>If a variable is assigned to definitely not be an alias of itself, an exception is thrown.
 * <li>If a variable is assigned to maybe be an alias of itself (or assigned to BOTTOM), nothing happens.
 * <li>If two variables of incompatible types are assigned to definitely be aliases, an exception is thrown.
 * <li>If two variables of incompatible types are assigned to maybe be aliases (or assigned to BOTTOM), nothing happens.
 * </ul>
 */
public class AliasTable {
	/**
	 * The default element of the map. Can be changed without issues. By setting this
	 * to the most common alias status, memory can be saved.
	 */
	private static final AliasStatus DEFAULT_ELEMENT = AliasStatus.BOTTOM;
	// TODO: It might be more efficient to set DEFAULT_ELEMENT to NOT, since it will use less memory after the analysis is complete.
	
	private Map<UnorderedPair<Variable>, AliasStatus> map = new HashMap<UnorderedPair<Variable>, AliasStatus>();
	private Set<Variable> variables;
	
	private boolean hasVariables(UnorderedPair<Variable> pair) {
	    return variables.contains(pair.getFirst()) && variables.contains(pair.getSecond());
	}
	
	/**
	 * Creates variable aliasings between the specified variables. Only variables in the specified
	 * set may be used in queries to this object.
	 * @param variables the variables to track aliasing between.
	 * @param initial the initial aliasing status between all pairs of variables
	 */
	public AliasTable(Set<Variable> variables, AliasStatus initial) {
	    this.variables = variables;
		if (initial == DEFAULT_ELEMENT)
			return;
		
		for (Variable var1 : variables) {
			for (Variable var2 : variables) {
				if (var1.getKey() <= var2.getKey())
					continue;
				if (var1.getType().cannotBeUsefulAliasOf(var2.getType()))
					continue;
				map.put(new UnorderedPair<Variable>(var1, var2), initial);
			}
		}
	}
	
	/**
	 * Returns the current aliasing status between two variables.
	 * @param a a variable from the set passed to {@link AliasTable}'s constructor.
	 * @param b a variable from the set passed to {@link AliasTable}'s constructor.
	 * @return an aliasing status. <tt>null</tt> is never returned.
	 */
	public AliasStatus getAliasStatus(Variable a, Variable b) {
		return getAliasStatus(new UnorderedPair<Variable>(a, b));
	}
	
	/**
	 * Returns the current aliasing status between two variables.
	 * @param pair a pair of variables from the set passed to {@link AliasTable}'s constructor.
	 * @return an aliasing status. <tt>null</tt> is never returned.
	 */
	public AliasStatus getAliasStatus(UnorderedPair<Variable> pair) {
		if (pair.getFirst() == pair.getSecond()) {
			return AliasStatus.DEFINITELY;
		}
		if (pair.getFirst().getType().cannotBeUsefulAliasOf(pair.getSecond().getType()))
			return AliasStatus.NOT;
		
		assert hasVariables(pair);
		
		AliasStatus status = map.get(pair);
		if (status == null) {
			return DEFAULT_ELEMENT;
		}
		return status;
	}
	
	/**
	 * Sets the current aliasing status between two variables. The order of the arguments is irrelevant.
	 * <p/>
	 * The semantic assumption listed in {@link AliasTable} may override the change.
	 * @return <tt>true</tt> if something changed
	 */
	public boolean setAliasStatus(Variable a, Variable b, AliasStatus status) {
		return setAliasStatus(new UnorderedPair<Variable>(a, b), status);
	}
	
	/**
	 * Sets the current aliasing status between two variables. If the two variables
	 * are the same, only {@link AliasStatus#DEFINITELY DEFINITELY} is accepted.
	 * @param pair a pair of variables from the set passed to {@link AliasTable}'s constructor.
	 * @return <tt>true</tt> if something changed
	 */
	public boolean setAliasStatus(UnorderedPair<Variable> pair, AliasStatus status) {
		if (pair.getFirst() == pair.getSecond()) {
			if (status == AliasStatus.NOT)
				throw new IllegalArgumentException("A variable can only be a definite alias of itself");
			return false;
		}
		if (pair.getFirst().getType().cannotBeUsefulAliasOf(pair.getSecond().getType())) {
			if (status == AliasStatus.DEFINITELY)
				throw new IllegalArgumentException("Two variables of incompatible types can only NOT be aliases.");
			return false;
		}
        
        assert hasVariables(pair);
        
		AliasStatus currentStatus = map.get(pair);
		if (status == currentStatus)
			return false;
		
		if (status == DEFAULT_ELEMENT) {
			if (currentStatus == null)
				return false;
			map.remove(pair);
			return true;
		}
		
		map.put(pair, status);
		return true;
	}
	
	/**
	 * Returns the result of <tt>toString</tt> on the underlying map. Mostly
	 * useful when running the integrated debugger.
	 */
	@Override
	public String toString() {
		return map.toString();
	}
}
