package dk.brics.string.external;

import java.util.ArrayList;
import java.util.List;

import dk.brics.automaton.Automaton;

/**
 * A description of a non-application method. Describes which strings may
 * be returned, and which arguments might be modified.
 */
public class MethodResolution {
	private Automaton returnedAutomaton = null;
	private int returnedArgument = -1;
	private List<Boolean> corruptedArguments;
	
	/**
	 * Creates a method resolution for a completely corrupting method
	 * call with the specified number of arguments.
	 * <p/>
	 * Precision can be increasing using {@link #setReturnedAutomaton(Automaton)} and
	 * {@link #setArgumentCorrupted(int, boolean)}.
	 * @param numArguments number of arguments to the method
	 */
	public MethodResolution(int numArguments) {
		this.corruptedArguments = new ArrayList<Boolean>();
		for (int i=0; i<numArguments; i++) {
			corruptedArguments.add(true);
		}
	}
	/**
	 * Creates a method resolution for a completely corrupting method
	 * call with the specified number of arguments.
	 * <p/>
	 * Precision can be increasing using {@link #setReturnedAutomaton(Automaton)} and
	 * {@link #setArgumentCorrupted(int, boolean)}.
	 * @param numArguments number of arguments to the method
	 * @param returnedAutomaton see {@link #setReturnedAutomaton(Automaton)}
	 */
	public MethodResolution(int numArguments, Automaton returnedAutomaton) {
		this(numArguments);
		setReturnedAutomaton(returnedAutomaton);
	}
	
	/**
	 * Returns the automaton accepting all possible return values of the method, or <tt>null</tt> if the method
	 * returns something corrupt.
	 * <p/>
	 * If a mutable string-type is returned by the method, it is corrupt unless the object is "forgotten" 
	 * by the external code, so it does not get modified outside the application again. 
	 * If this is not the case, this method must return <tt>null</tt>.
	 * @return an automaton denoting the possible return values, or <tt>null</tt> is something corrupt is returned.
	 */
	public Automaton getReturnedAutomaton() {
		return returnedAutomaton;
	}
	
	/**
	 * Sets the automaton accepting all possible return values of the method, or <tt>null</tt> if the method
	 * returns something corrupt.
	 * <p/>
	 * If a mutable string-type is returned by the method, it is corrupt unless the object is "forgotten" 
	 * by the external code, so it does not get modified outside the application again. 
	 * If this is not the case, this method must return <tt>null</tt>.
	 * <p/>
	 * Automatically sets the returned argument index to -1.
	 * @param returnValue an automaton denoting the possible return values, or <tt>null</tt> is something corrupt is returned or an argument is returned.
	 */
	public void setReturnedAutomaton(Automaton returnValue) {
		this.returnedArgument = -1;
		this.returnedAutomaton = returnValue;
	}
	
	/**
	 * Returns the index of an argument being returned, or -1 if the method
	 * does not return one of its arguments. If the argument is mutable, it must
	 * never be modified in the external code (not before nor after the method returns).
	 * @return an argument index, or -1.
	 */
	public int getReturnedArgument() {
		return returnedArgument;
	}
	
	/**
	 * Sets the index of an argument being returned, or -1 if the method
	 * does not return one of its arguments. If the argument is mutable, it must
	 * never be modified in the external code (not before nor after the method returns).
	 * <p/>
	 * Automatically sets the returned automaton to <tt>null</tt>.
	 * @param returnedArgument an argument index, or -1.
	 */
	public void setReturnedArgument(int returnedArgument) {
		if (returnedArgument < -1 || returnedArgument >= corruptedArguments.size())
			throw new IllegalArgumentException("Returned argument index must be -1 or less than the number of arguments");
		this.returnedAutomaton = null;
		this.returnedArgument = returnedArgument;
	}
	
	/**
	 * Sets the method to return something corrupt. Sets the returned argument index to -1, and
	 * the returned automaton to <tt>null</tt>.
	 */
	public void setReturnCorrupt() {
		this.returnedArgument = -1;
		this.returnedAutomaton = null;
	}
	
	/**
	 * Returns whether the return value is considered corrupt.
	 * @return whether return value is corrupt
	 */
	public boolean isReturnCorrupt() {
		return returnedArgument == -1 && returnedAutomaton == null;
	}
	
	/**
	 * Returns a list of booleans, where index <tt>i</tt> indicates whether argument <tt>i</tt>
	 * might be changed as a result of calling the method.
	 * @return a mutable list of booleans backed by this object; <tt>null</tt> is never returned.
	 */
	public List<Boolean> getCorruptedArguments() {
		return corruptedArguments;
	}
	
	/**
	 * Returns whether argument <tt>i</tt> might be modified as a result of invoking the method.
	 * Convenient alternative to using {@link #getCorruptedArguments()}.
	 * @param i the argument number
	 * @return <tt>true</tt> if the specified argument might be modified
	 */
	public boolean isArgumentCorrupted(int i) {
		return corruptedArguments.get(i);
	}

	/**
	 * Sets whether argument <tt>i</tt> might be modified as a result of invoking the method.
	 * Convenient alternative to using {@link #getCorruptedArguments()}.
	 * @param i the argument number
	 * @param b <tt>true</tt> if the specified argument might be modified
	 */
	public void setArgumentCorrupted(int i, boolean b) {
		corruptedArguments.set(i, b);
	}
	
}
