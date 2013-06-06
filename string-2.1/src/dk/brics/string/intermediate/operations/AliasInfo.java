package dk.brics.string.intermediate.operations;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import dk.brics.string.intermediate.Variable;
import dk.brics.string.util.UnorderedPair;

/**
 * Alias and corruption information for a specific program point.
 */
public class AliasInfo {
	/**
	 * Alias relations between the live and mutable variables.
	 */
    private AliasTable aliasing;

    /**
     * Set of corrupted variables (i.e. their values can be anything).
     */
    private Set<Variable> corrupted;

    /**
     * Set (unmodifiable) of potentially live variables, as provided by the liveness analysis.
     */
    private Set<Variable> live;

    AliasInfo(Set<Variable> live) {
        this.live = live;
        aliasing = new AliasTable(live, AliasStatus.BOTTOM);
        corrupted = new HashSet<Variable>();
    }

    /**
     * Returns the aliasing relation between two variables at this
     * program point. The variables must be live, or the result is undefined.
     * @param pair a pair of live variables
     * @return an {@link AliasStatus}, never <tt>null</tt>.
     */
    // LWG: no longer use UnorderedPair<Variable> for efficiency reason
    // public AliasStatus getAliasStatus(UnorderedPair<Variable> pair) {
	// 	return aliasing.getAliasStatus(pair);
	// }
    
    /**
     * Returns the aliasing relation between two variables at this
     * program point. The variables must be live, or the result is undefined.
     * @param a a live variable
     * @param b a live variable
     * @return an {@link AliasStatus}, never <tt>null</tt>.
     */
	public AliasStatus getAliasStatus(Variable a, Variable b) {
		return aliasing.getAliasStatus(a, b);
	}



	/**
     * Merge this element with the given.
     * Only live variables are considered.
     */
    boolean mergeIdentity(AliasInfo other) {
        return mergeFilter(other, null);
    }
    
    /**
     * Merge, where the specified variable is not an alias of anything.
     */
    boolean mergeNew(Variable v) {
    	if (!live.contains(v))
    		return false;
    	boolean changed = false;
    	for (Variable var : live) {
    		if (var == v)
    			continue;
    		if (var.getType().cannotBeUsefulAliasOf(v.getType()))
    			continue;
    		AliasStatus status = aliasing.getAliasStatus(var, v).leastUpperBound(AliasStatus.NOT);
    		changed |= aliasing.setAliasStatus(var, v, status);
    	}
    	return changed;
    }
    
    // LWG: no longer use UnorderedPair<Variable> for efficiency reason
    // private UnorderedPair<Variable> pair(Variable var1, Variable var2) {
    // 	return new UnorderedPair<Variable>(var1, var2);
    // }
    
    /**
     * Merge this element with the given, except for
     * all aliases with the given variable if non-null.
     * Only live variables are considered.
     */
    boolean mergeFilter(AliasInfo other, Variable a) {
        boolean changed = false;
        
        for (Variable var1 : live) {
        	if (!other.live.contains(var1))
        		continue;
        	if (var1 == a)
        		continue;
        	
        	for (Variable var2 : live) {
        		if (var1.getKey() <= var2.getKey()) // only bother with the unordered pairs (var1,var2) and var1!=var2
        			continue;
        		if (!other.live.contains(var2))
        			continue;
        		if (var2 == a)
        			continue;

                // LWG: no longer use UnorderedPair<Variable> for efficiency reason
        		// UnorderedPair<Variable> pair = pair(var1, var2);
        		// AliasStatus status = aliasing.getAliasStatus(pair).leastUpperBound(other.aliasing.getAliasStatus(pair));
        		// changed |= aliasing.setAliasStatus(pair, status);
        		AliasStatus status = aliasing.getAliasStatus(var1, var2).leastUpperBound(other.aliasing.getAliasStatus(var1, var2));
        		changed |= aliasing.setAliasStatus(var1, var2, status);
        	}
        }
        
        // Merge corrupted status
        for (Variable oc : other.corrupted) {
            if (a != oc && live.contains(oc)) {
                changed |= corrupted.add(oc);
            }
        }
        return changed;
    }
    
    /**
     * Alias a with b and with all variables aliased with b.
     * If a possible alias of b was corrupt, a will become corrupt.
     */
    boolean mergeAssign(AliasInfo other, Variable a, Variable b) {
        if (!live.contains(a))
            return false;
        
        boolean changed = false;
        // every variable alised with 'b' must become an alias with 'a', even if 'b' is no longer live
        for (Variable var : live) {
        	if (!other.live.contains(var))
        		continue;
        	if (var == a)
        		continue;
        	
        	AliasStatus status = aliasing.getAliasStatus(a, var).leastUpperBound(other.aliasing.getAliasStatus(b, var));
        	changed |= aliasing.setAliasStatus(a, var, status);
        }
        if (other.corrupted.contains(b)) {
        	changed |= corrupted.add(a);
        }
        return changed;
    }
    
    /**
     * Set aliasing status between a and b and with all variables aliased with b.
     * Also updates corruption.
     * @param status the new aliasing status between <tt>a</tt> and <tt>b</tt>
     */
    boolean mergeStatus(AliasInfo other, Variable a, Variable b, AliasStatus status) {
        if (!live.contains(a))
            return false;
        
    	boolean changed = false;
    	switch (status) {
    	case DEFINITELY:
    		changed = mergeAssign(other, a, b);
    		break;
    		
    	case BOTTOM:
    		break; // nothing changes
    		
    	case NOT:
    		for (Variable var : live) {
    			if (!other.live.contains(var))
    				continue;
    			if (var == a)
    				continue;
    			AliasStatus otherStatus = other.aliasing.getAliasStatus(b, var);
    			AliasStatus currentStatus = aliasing.getAliasStatus(a, var);
    			if (otherStatus == AliasStatus.DEFINITELY) { // FIXME: Make some tests for this case
    				// a!=b and b=c  ==>  a!=c 
    				changed |= aliasing.setAliasStatus(a, var, currentStatus.leastUpperBound(AliasStatus.NOT));
    			}
    		}
    		break;
    		
    	case MAYBE:
    		for (Variable var : live) {
    			if (!other.live.contains(var))
    				continue;
    			if (var == a)
    				continue;
    			AliasStatus otherStatus = other.aliasing.getAliasStatus(b, var);
    			if (otherStatus.mightBeAlias()) {
    				changed |= aliasing.setAliasStatus(a, var, AliasStatus.MAYBE);
    			}
    		}
			if (other.corrupted.contains(b)) {
				changed |= corrupted.add(a);
			}
    		break;
    	}
    	
        return changed;
    }
    
    /**
     * Every possible alias of the specified variable is marked corrupt, including the variable
     * itself.
     * <p/>
     * Always consider carefully which one of {@link #mergeCorrupt} and {@link #setCorrupt} you want to use. They are somewhat
     * similar, but the small difference is essential for a correct analysis.
     * @param a a variable to corrupt.
     * @return <tt>true</tt> if something changed.
     */
    boolean setCorrupt(Variable a) {
        boolean changed = false;
        for (Variable var : live) {
        	if (aliasing.getAliasStatus(var, a).mightBeAlias()) {
        		changed |= corrupted.add(var);
        	}
        }
        return changed;
    }
    
    /**
     * Every variable that might have been an alias of the specified variable at another specified program point
     * are corrupted at this program point. This includes the variable itself, if it is still live.
     * <p/>
     * Always consider carefully which one of {@link #mergeCorrupt} and {@link #setCorrupt} you want to use. They are somewhat
     * similar, but the small difference is essential for a correct analysis.
     * @param other the node to use aliasing info from.
     * @param variableToCorrupt a variable to corrupt
     * @return true if changed
     */
    boolean mergeCorrupt(AliasInfo other, Variable variableToCorrupt) {
    	boolean changed = false;
    	for (Variable var : live) {
    		if (other.aliasing.getAliasStatus(var, variableToCorrupt).mightBeAlias()) {
    			changed |= corrupted.add(var);
    		}
    	}
    	return changed;
    }
    
    boolean mergeAssertAliases(AliasInfo other, Variable a, Variable b) {
    	boolean changed = false;
    	
    	// merge aliasing for 'a' and 'b'
    	if (live.contains(a) && live.contains(b)) {
    		changed |= aliasing.setAliasStatus(a, b, aliasing.getAliasStatus(a, b).leastUpperBound(AliasStatus.DEFINITELY));
    	}
    	
    	// for all other variable pairs
    	for (Variable var1 : live) {
    		assert other.live.contains(var1);
    		
    		if (var1 == a || var1 == b)
    			continue;
    		
    		// set aliasing with variables other than 'a' and 'b'
    		for (Variable var2 : live) {
    			if (var2 == a || var2 == b || var2 == var1)
    				continue;
    			
    			AliasStatus before = aliasing.getAliasStatus(var1,var2);
    			AliasStatus after = other.aliasing.getAliasStatus(var1,var2);
    			changed |= aliasing.setAliasStatus(var1, var2, before.leastUpperBound(after));
    		}
    		
    		// set aliasing with 'a' and 'b'
    		AliasStatus beforeA = other.aliasing.getAliasStatus(var1, a);
    		AliasStatus beforeB = other.aliasing.getAliasStatus(var1, b);
    		
    		AliasStatus newA, newB;
    		if (beforeA.isDefinitelyOrBottom() || beforeB.isDefinitelyOrBottom()) {
    			newA = newB = beforeA.greatestLowerBound(beforeB);
    		} else {
    			newA = beforeA;
    			newB = beforeB;
    		}
    		
    		if (live.contains(a)) {
        		AliasStatus afterA = aliasing.getAliasStatus(var1, a);
        		changed |= aliasing.setAliasStatus(var1, a, afterA.leastUpperBound(newA));
    		}
    		if (live.contains(b)) {
        		AliasStatus afterB = aliasing.getAliasStatus(var1, b);
        		changed |= aliasing.setAliasStatus(var1, b, afterB.leastUpperBound(newB));
    		}
    	}
    	
    	return changed;
    }
    
    boolean mergeAssertNotAliases(AliasInfo other, Variable a, Variable b) {
    	boolean changed = false;
    	
    	// merge aliasing for 'a' and 'b'
    	if (live.contains(a) && live.contains(b)) {
    		changed |= aliasing.setAliasStatus(a, b, aliasing.getAliasStatus(a, b).leastUpperBound(AliasStatus.NOT));
    	}
    	
    	// for all other variable pairs
    	for (Variable var1 : live) {
    		assert other.live.contains(var1);
    		
    		if (var1 == a || var1 == b)
    			continue;
    		
    		// set aliasing with variables other than 'a' and 'b'
    		for (Variable var2 : live) {
    			if (var2 == a || var2 == b || var2 == var1)
    				continue;
    			
    			AliasStatus before = aliasing.getAliasStatus(var1,var2);
    			AliasStatus after = other.aliasing.getAliasStatus(var1,var2);
    			changed |= aliasing.setAliasStatus(var1, var2, before.leastUpperBound(after));
    		}
    		
    		// set aliasing with 'a' and 'b'
    		AliasStatus beforeA = other.aliasing.getAliasStatus(var1, a);
    		AliasStatus beforeB = other.aliasing.getAliasStatus(var1, b);
    		
    		if (live.contains(a)) {
        		AliasStatus afterA = aliasing.getAliasStatus(var1, a);
        		AliasStatus newA;
        		if (beforeB.isDefinitelyOrBottom()) {
        			newA = beforeA.greatestLowerBound(AliasStatus.NOT);
        		} else {
        			newA = beforeA;
        		}
        		changed |= aliasing.setAliasStatus(var1, a, afterA.leastUpperBound(newA));
    		}
    		if (live.contains(b)) {
        		AliasStatus afterB = aliasing.getAliasStatus(var1, b);
        		AliasStatus newB;
        		if (beforeA.isDefinitelyOrBottom()) {
        			newB = beforeB.greatestLowerBound(AliasStatus.NOT);
        		} else {
        			newB = beforeB;
        		}
        		changed |= aliasing.setAliasStatus(var1, b, afterB.leastUpperBound(newB));
    		}
    	}
    	
    	return changed;
    }
    
    /**
     * Returns a set variables containing all possible aliases of the specified variable, optionally
     * including only definite aliases. The variable itself is always included in the set.
     * @param v the variable to get aliases for
     * @param onlyDefinite if <tt>true</tt>, only definite aliases of <tt>v</tt> are included (this also includes <tt>v</tt> itself).
     * @return a newly created set, that is modifiable and independant of the <tt>AliasInfo</tt> object.
     */
    public Set<Variable> getAliasesForInclusive(Variable v, boolean onlyDefinite) {
    	Set<Variable> vars = new HashSet<Variable>();
    	for (Variable var : live) {
    		AliasStatus status = aliasing.getAliasStatus(v, var);		
    		if (status == AliasStatus.DEFINITELY || (!onlyDefinite && status == AliasStatus.MAYBE)) {
    			vars.add(var);
    		}
    	}
    	return vars;
    }
    
    /**
     * Returns a set variables containing all possible aliases of the specified variable, optionally
     * including only definite aliases. The variable itself is never included in the set.
     * @param v the variable to get aliases for
     * @param onlyDefinite if <tt>true</tt>, only definite aliases of <tt>v</tt> are included (except <tt>v</tt> itself).
     * @return a newly created set, that is modifiable and independant of the <tt>AliasInfo</tt> object.
     */
    public Set<Variable> getAliasesForExclusive(Variable v, boolean onlyDefinite) {
    	Set<Variable> vars = new HashSet<Variable>();
    	for (Variable var : live) {
    		if (var == v)
    			continue;
    		AliasStatus status = aliasing.getAliasStatus(v, var);		
    		if (status == AliasStatus.DEFINITELY || (!onlyDefinite && status == AliasStatus.MAYBE)) {
    			vars.add(var);
    		}
    	}
    	return vars;
    }
    
    /**
     * Returns whether the two variables are the same, or might be aliases.
     * Different from using {@link #getAliasesForInclusive(Variable, boolean)}, because this returns <tt>true</tt>
     * if the two variables are the same.
     */
    public boolean mightBeAliases(Variable a, Variable b) {
    	return aliasing.getAliasStatus(a, b).mightBeAlias();
    }
    
    /**
     * Returns whether the two variables are the same, or are definitely aliases.
     */
    public boolean definitelyAliases(Variable a, Variable b) {
    	return aliasing.getAliasStatus(a, b) == AliasStatus.DEFINITELY;
    }
    
    /**
     * Returns whether or not the given variable is corrupt.
     */
    public boolean isCorrupt(Variable v) {
        return corrupted.contains(v);
    }
    
    /**
     * Returns whether at least one of the specified variables are corrupt.
     */
    public boolean isAnyCorrupt(Collection<? extends Variable> variables) {
    	for (Variable v : variables) {
    		if (isCorrupt(v))
    			return true;
    	}
    	return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Def. Aliases:");
        for (Variable var1 : live) {
        	for (Variable var2 : live) {
        		if (var1.getKey() >= var2.getKey())
        			continue;
        		if (aliasing.getAliasStatus(var1, var2) != AliasStatus.DEFINITELY)
        			continue;
        		sb.append(" (" + var1 + "," + var2 + ")");
        	}
        }
        sb.append("\nNot Aliases:");
        for (Variable var1 : live) {
        	for (Variable var2 : live) {
        		if (var1.getKey() >= var2.getKey())
        			continue;
        		if (aliasing.getAliasStatus(var1, var2) != AliasStatus.NOT)
        			continue;
        		if (var1.getType().cannotBeAliasOf(var2.getType()))
        			continue; // ignore the trivial non-aliases
        		sb.append(" (" + var1 + "," + var2 + ")");
        	}
        }
        sb.append("\nLive: " + live + "\n");
        sb.append("Corrupted: " + corrupted + "\n");
        return sb.toString();
    }
}
