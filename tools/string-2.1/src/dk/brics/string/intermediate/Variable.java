package dk.brics.string.intermediate;


/**
 * A variable or other intermediate value in the Java program.
 * A variable has a type, which is either {@link java.lang.String},
 * {@link java.lang.StringBuffer}, {@link java.lang.StringBuilder},
 * an array (of arbitrary dimension)
 * of {@link java.lang.String}, or some irrelevant type.
 */
public final class Variable implements Comparable<Variable> {

    /**
     * The type of the variable.
     */
    private VariableType type;

    private int key;

    private boolean taint;
    
    private Field field;
    
    Variable(int key, VariableType type) {
        this.key = key;
        this.type = type;
    }
    
    /**
     * Sets the field associated with this variable. Called by {@link Field}'s constructor.
     */
    void setField(Field field) {
        this.field = field;
    }
    
    /**
     * Returns the field represented by this variable, or <tt>null</tt> if this is
     * not a field variable.
     * @return <tt>null</tt>, or a field.
     */
	public Field getField() {
        return field;
    }

    /**
     * Returns true if the variable <i>might</i> be mutable.
     */
    public boolean isMutable() {
        return type.mightBeUsefulMutable();
    }
    
    /**
     * Returns <tt>true</tt> if this is a local variable, and <tt>false</tt>
     * if it is a field variable.
     */
    public boolean isLocal() {
        return field == null;
    }
    
    /**
     * Returns <tt>false</tt> if this is a local variable, and <tt>true</tt>
     * if it is a field variable.
     */
    public boolean isField() {
        return field != null;
    }
    
    /**
     * Returns a string representation of the variable.
     *
     * @return a unique identifier for the variable.
     */
    @Override
    public String toString() {
        String n = "x";
        switch (getType()) {
            case NONE:
                n = "n";
                break;
            case STRING:
                n = "s";
                break;
            case STRINGBUFFER:
                n = "b";
                break;
            case ARRAY:
                n = "a";
                break;
            case PRIMITIVE:
                n = "p";
                break;
        }
        return n + key;
    }

    public boolean isTaint() {
        return taint;
    }

    public void setTaint(boolean taint) {
        this.taint = taint;
    }
    
    public int getKey() {
		return key;
	}

    public int compareTo(Variable v) {
        assert key == v.key || v != this; // must not compare variables from different applications
        
        return key - v.key;
    }

    @Override
    public boolean equals(Object other) {
        return other == this;
    }
    @Override
    public int hashCode() {
        return key;
    }
    
    /**
     * @return the type
     */
    public VariableType getType() {
        return type;
    }
}
