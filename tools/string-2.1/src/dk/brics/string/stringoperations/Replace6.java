package dk.brics.string.stringoperations;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.StatePair;
import dk.brics.automaton.Transition;
import dk.brics.string.charset.CharSet;
import dk.brics.string.util.MultiMap;

/**
 * Automaton operation for {@link String#replace(CharSequence,CharSequence)} where both arguments are known.
 * <p/>
 * When two occurrences of the search string overlaps, the replace() operation replaces the leftmost occurrence,
 * though the current implementation approximates it as though either occurrence is chosen at random.
 * For example, the operation <tt>"babab".replace("bab", "X")</tt>
 * will always produce <tt>"Xab"</tt>, but will be approximated as <tt>{"Xab","baX"}</tt>.
 */
public class Replace6 extends UnaryOperation {
	
	/** The first argument to replace(); the string to search for */
    private String searchFor;
    
    /** The second argument to replace(); the string to insert as replacement. */
    private String replaceBy;

    /**
     * Automaton operation for {@link String#replace(CharSequence,CharSequence)} where both arguments are known.
     * @param searchFor known value of the first argument
     * @param replaceBy known value of the second argument
     */
    public Replace6(String searchFor, String replaceBy) {
        this.searchFor = searchFor;
        this.replaceBy = replaceBy;
    }
    
    /**
     * An epsilon transition with an optional "constrained" character.
     * See addConstrainedEpsilons.
     * Does NOT currently have equals() and hashCode()!
     */
    private static final class ConstrainedEpsilon {
    	/** Origin of epsilon transition */
    	public State from;
    	
    	/** Destination of epsilon transition */
    	public State to;
    	
    	/** Illegal input after following epsilon, or null if not constrained */
    	public Character illegalCharacter;
    	
    	/** 
    	 * Returns the set of illegal characters, which is either empty or
    	 * a singleton set.
    	 */
    	public Set<Character> illegalCharacters() {
    		if (illegalCharacter == null)
    			return Collections.<Character>emptySet();
    		else
    			return Collections.singleton(illegalCharacter);
    	}

		public ConstrainedEpsilon(State from, State to, Character illegalCharacter) {
			this.from = from;
			this.to = to;
			this.illegalCharacter = illegalCharacter;
		}
		public ConstrainedEpsilon(State from, State to) {
			this.from = from;
			this.to = to;
			this.illegalCharacter = null;
		}
		
    }
    
    /**
     * A state and a transition. The transition will typically be
     * outgoing from the state, though it is not necessary.
     * Does NOT currently have equals() and hashCode()!
     */
    private static final class StateTransitionPair {
    	public State state;
    	public Transition transition;
		public StateTransitionPair(State state, Transition transition) {
			this.state = state;
			this.transition = transition;
		}
    }
    
    
    
    /**
     * Automaton operation.
     * Constructs a new automaton as a copy of <tt>a</tt>, with these modifications.
     * For every state <tt>s<sub>0</sub></tt>, if there exists a path <tt>s<sub>0</sub>,...,s<sub>n</sub></tt> reading the
     * search string <tt>S</tt>, the following modifications are made:
     * <ul>
     * <li>A replacement path <tt>r<sub>0</sub>,...,r<sub>m</sub></tt> is created, reading the replacement string.
     * <li>A ghost path <tt>g<sub>0</sub>,...,g<sub>n-1</sub></tt> is created, reading the search string, except for its last character.
     * <li>These epsilon transitions are created: 
     * 			<tt>(s<sub>0</sub>,r<sub>0</sub>), 
     * 				(s<sub>0</sub>,g<sub>0</sub>), 
     * 				(r<sub>m</sub>,s<sub>n</sub>)</tt>
     * <li>For <tt>i=1,...,n-1</tt> this <i>constrained</i> epsilon transition is created:
     * 			<tt>(g<sub>i</sub>, s<sub>i</sub>, [S<sub>i</sub>])</tt>, where <tt>S<sub>i</sub></tt> is the <i>i</i>-th character in the search string (0-based).
     * <li>For <tt>i=0,...,n-1</tt>, <tt>g<sub>i</sub></tt> is made an accept state if <tt>s<sub>i</sub></tt> is an accept state.
     * <li><tt>r<sub>0</sub></tt> and <tt>r<sub>m</sub></tt> are made accept states if <tt>s<sub>0</sub></tt> and <tt>s<sub>n</sub></tt> are accept states, respectively.
     * <li>The character <tt>S<sub>0</sub></tt> is removed from the transition <tt>(s<sub>0</sub>,s<sub>1</sub>)</tt>.
     * </ul>
     * The strategy above assumes that the input automaton is deterministic, and that
     * the search string is not empty. If the search string is empty, a different strategy is used, which
     * inserts the replacement string once between every state.
     * <p/>
     * A constrained epsilon transition is like a normal epsilon transition, except the constrained character cannot be read
     * immediately after following the transition. If it occurs afterwards, the automaton must move to the dead reject state instead of
     * following the transitions at the current state. If the automaton follows more than one constrained epsilon transition
     * consecutively, all their constrained characters become constrained.
     * <p/>
     * The intuition behind the strategy is this: If the search string occurs at some position, the replacement string
     * can now be read from that position instead. If only a prefix of the search string did occur, the automaton can
     * follow the ghost path a bit, and then jump back into the original path when a character differs from the search
     * string. Removing the first character from the first transition ensures that the automaton can no longer read the
     * whole search string at that position.
     */
    @Override
    public Automaton op(Automaton a) {
    	if (searchFor.length() == 0)
    		return emptyStringOp(a);
    	
    	Automaton result = a.clone();
    	
    	assert result.isDeterministic();
    	
    	List<ConstrainedEpsilon> epsilons = new LinkedList<ConstrainedEpsilon>();
    	List<StateTransitionPair> killedTransitions = new LinkedList<StateTransitionPair>();
    	List<StateTransitionPair> newTransitions = new LinkedList<StateTransitionPair>();
    	String ghostString = searchFor.substring(0, searchFor.length() - 1);
    	
    	for (State origin : result.getStates()) {
    		LinkedList<State> path = getPath(origin, searchFor);
    		
    		if (path == null)
    			continue;
    		
    		// create a path to read the replacement string
    		LinkedList<State> replacement = makeString(replaceBy);
    		
    		// create a path to read part of the search string, in case
    		// only a prefix of the search string occurred
    		LinkedList<State> ghost = makeString(ghostString);
    		
    		// connect to replacement string (head and tail)
    		epsilons.add(new ConstrainedEpsilon(origin, replacement.getFirst()));
    		epsilons.add(new ConstrainedEpsilon(replacement.getLast(), path.getLast()));
    		
    		// set accept states of first and last
    		if (origin.isAccept()) {
    			replacement.getFirst().setAccept(true);
    			ghost.getFirst().setAccept(true);
    		}
    		if (path.getLast().isAccept()) {
    			replacement.getLast().setAccept(true);
    		}
    		
    		// connect to ghost string (head)
    		epsilons.add(new ConstrainedEpsilon(origin, ghost.getFirst()));
    		
    		// connect to successive states in the ghost state,
    		// and set accept states in the ghost
    		Iterator<State> pathIt = path.iterator();
    		Iterator<State> ghostIt = ghost.iterator();
    		ghostIt.next(); // skip the initial state in the ghost path
    		int index = 1;
    		while (ghostIt.hasNext()) {
    			assert pathIt.hasNext();
    			State pathState = pathIt.next();
    			State ghostState = ghostIt.next();
    			
    			// add an epsilon transition, but disallow reading the next
    			// character from the search string if it is followed
    			epsilons.add(new ConstrainedEpsilon(ghostState, pathState, searchFor.charAt(index)));
    			
    			// set accept state
    			if (pathState.isAccept()) {
    				ghostState.setAccept(true);
    			}
    			
    			// next char in search string
    			index++;
    		}
    		
    		// remove the transition with the first character of
    		// the search string from the origin state
    		char first = searchFor.charAt(0);
    		for (Transition tr : origin.getTransitions()) {
    			if (tr.getMin() <= first && tr.getMax() >= first) {
    				killedTransitions.add(new StateTransitionPair(origin, tr));
    				
    				// add back the remaining characters from the interval
    				if (tr.getMin() < first) {
    					newTransitions.add(new StateTransitionPair(origin, new Transition(tr.getMin(), (char)(first-1), tr.getDest())));
    				}
    				if (tr.getMax() > first) {
    					newTransitions.add(new StateTransitionPair(origin, new Transition((char)(first+1), tr.getMax(), tr.getDest())));
    				}
    			}
    		}
    	}
    	
    	// apply the first character removal first
    	for (StateTransitionPair pair : killedTransitions) {
    		pair.state.getTransitions().remove(pair.transition);
    	}
    	for (StateTransitionPair pair : newTransitions) {
    		pair.state.addTransition(pair.transition);
    	}
    	
    	// apply epsilons
    	addConstrainedEpsilons(result, epsilons);
    	result.reduce();
    	result.minimize();
    	
    	return result;
    }

    /**
     * Returns the states reached by feeding the specified input to
     * the automaton, starting at the specified state. The initial
     * state is not added to the path. The number of states in the
     * path equals the length of the string.
     * <p/>
     * Returns <tt>null</tt> if the path ends in the dead state.
     * @param start state to search path at. 
     * @param string input to the automaton.
     * @return a new list of states, or <tt>null</tt>.
     */
    private LinkedList<State> getPath(State start, CharSequence string) {
    	LinkedList<State> path = new LinkedList<State>();
    	State state = start;
    	for (int i=0; i<string.length(); i++) {
    		state = state.step(string.charAt(i));
    		if (state == null)
    			return null;
    		path.add(state);
    	}
    	return path;
    }
    
    /**
     * Creates states and transitions reading the specified string.
     * None of the states are made accept states. The states are returned
     * in a linked list in topological order.
     * @param s a string
     * @return a new list with all the states
     */
    private LinkedList<State> makeString(CharSequence s) {
    	LinkedList<State> list = new LinkedList<State>();
    	State first = new State();
    	list.add(first);
    	State last = first;
    	for (int i=0; i<s.length(); i++) {
    		State state = new State();
    		last.addTransition(new Transition(s.charAt(i), state));
    		list.add(state);
    		last = state;
    	}
    	return list;
    }
    
    
    /**
     * Like adding normal epsilon transitions, except certain epsilon transition are
     * constrained, in that one specific character cannot be read after following that
     * transition (ie. reading that character goes to the dead rejecting state).
     * @param auto automaton to modify
     * @param epsilons constrained epsilon transitions to add.
     */
    private void addConstrainedEpsilons(Automaton auto, Collection<ConstrainedEpsilon> epsilons) {
    	// forward and backward contain all the epsilon transitions without illegal characters
    	MultiMap<State, State> forward = new MultiMap<State, State>();
    	MultiMap<State, State> backward = new MultiMap<State, State>();
    	
    	// 'all' contains key (s1,s2) if there is an epsilon transition from s1 to s2
    	// (s1,s2) then maps to the set of illegal characters on that transition (can be empty)
    	Map<StatePair, TreeSet<Character>> all = new HashMap<StatePair, TreeSet<Character>>();
    	
    	Set<StatePair> workset = new HashSet<StatePair>();
    	
    	// build the initial maps, without any closure 
    	for (ConstrainedEpsilon epsilon : epsilons) {
    		// ignore degenerate epsilons
    		if (epsilon.from == epsilon.to)
    			continue;
    		
    		forward.add(epsilon.from, epsilon.to);
    		backward.add(epsilon.to, epsilon.from);
    		
    		StatePair pair = new StatePair(epsilon.from, epsilon.to);
    		if (!all.containsKey(pair))
    			all.put(pair, new TreeSet<Character>(epsilon.illegalCharacters()));
    		else
    			all.get(pair).retainAll(epsilon.illegalCharacters());
    		workset.add(pair);
    	}
    	
    	// calculate the transitive closure.
    	// for every eps.tr. (s1,s2), we find a transition (s2,s3), and create (s1,s3).
    	// workset contains the (s1,s2) pairs that may yield a new transition like above.
    	while (!workset.isEmpty()) {
    		Iterator<StatePair> it = workset.iterator();
    		StatePair pair = it.next();
    		it.remove();
    		
    		State s1 = pair.getFirstState();
    		State s2 = pair.getSecondState();
    		
    		for (State s3 : forward.getView(s2)) {
    			// do not create degenerate epsilons
    			if (s1 == s3)
    				continue;
    			
    			assert s1 != s2 && s2 != s3;
    			
    			TreeSet<Character> illegal = new TreeSet<Character>(all.get(pair));
    			illegal.addAll(all.get(new StatePair(s2, s3)));
    			
    			boolean changed;
    			StatePair p2 = new StatePair(s1, s3);
    			if (!all.containsKey(p2)) {
    				all.put(p2, illegal);
    				forward.add(s1, s3); // note: we are not modifying the view being iterated because s1!=s2
    				backward.add(s3, s1);
    				changed = true;
    			} else {
    				changed = all.get(p2).retainAll(illegal);
    			}
    			
    			if (changed) {
    				workset.add(p2);
    				for (State s0 : backward.getView(s1)) {
    					workset.add(new StatePair(s0, s1));
    				}
    			}
    		}
    	}
		
		// closure completed, time to add the transitions
    	LinkedList<StateTransitionPair> transitions = new LinkedList<StateTransitionPair>();
		for (Map.Entry<StatePair, TreeSet<Character>> entry : all.entrySet()) {
			StatePair pair = entry.getKey();
			for (Transition tr : pair.getSecondState().getTransitions()) {
				char ch = tr.getMin();
				// TreeSet is sorted, so we visit the illegal characters in increasing order
				// at every illegal character, we add the interval below, since it must be a legal interval 
				for (Character illegal : entry.getValue()) {
					if (illegal < ch)
						continue;
					if (illegal > tr.getMax())
						break;
					if (illegal > ch) {
						transitions.add(new StateTransitionPair(pair.getFirstState(), new Transition(ch, (char)(illegal - 1), tr.getDest())));
					}
					ch = (char)(illegal + 1);
				}
				if (ch <= tr.getMax()) {
					transitions.add(new StateTransitionPair(pair.getFirstState(), new Transition(ch, tr.getMax(), tr.getDest())));
				}
			}
		}
		for (StateTransitionPair pair : transitions) {
			pair.state.addTransition(pair.transition);
		}
		auto.setDeterministic(false);
    }

    /**
     * If the search string is empty, the replace operation inserts the replacement string
     * between every character in the original string, and as prefix and suffix. 
     * This does not generalize well, so the case is handled specifically by this method.
     * </p>
     * For every state <tt>s</tt>, we create a path to read the replacement. All outgoing
     * transitions from <tt>s</tt> are changed to go out from last state in the replacement path.
     * <tt>s</tt> then gets all the transitions from the first state in the replacement path.
     * If <tt>s</tt> was an accept state, the last state in its replacement path is made an accept
     * state, and <tt>s</tt> is no longer an accept state (because the replacement string is inserted
     * as suffix).  
     * @param a input automaton. Will not be modified.
     * @return new automaton
     */
    private Automaton emptyStringOp(Automaton a) {
    	Automaton result = a.clone();
    	
    	for (State state : result.getStates()) {
    		LinkedList<State> insert = makeString(replaceBy);
    		insert.getLast().getTransitions().addAll(state.getTransitions());
    		state.getTransitions().clear();
    		state.getTransitions().addAll(insert.getFirst().getTransitions());
    		
    		if (state.isAccept()) {
    			insert.getLast().setAccept(true);
    			state.setAccept(false);
    		}
    	}
    	
    	return result;
    }
    
    @Override
    public CharSet charsetTransfer(CharSet a) {
        if (searchFor.length() == 1) {
            a = a.remove(searchFor.charAt(0));
        }
        for (char c : replaceBy.toCharArray()) {
            a = a.add(c);
        }
        return a;
    }

    @Override
    public String toString() {
        return "replace6[" + Basic.escapeString(searchFor) + "->" + Basic.escapeString(replaceBy) + "]";
    }

    @Override
    public int getPriority() {
        return 1;
    }

  
}
