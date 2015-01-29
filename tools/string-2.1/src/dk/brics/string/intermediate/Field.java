package dk.brics.string.intermediate;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A field in the intermediate representation. Each field is represented by an intermediate
 * variable.
 * <p/>
 * A field's variable must never be used directly in any statement except {@link FieldAssignment}
 * and {@link FieldReference}. To assign from one field to another, the first field must be copied into
 * a local variable with a {@link FieldReference} and then into the other field with a {@link FieldAssignment}.
 */
public class Field {

	private Variable variable;
	private boolean isStatic;
	
	// XXX maybe we should use LinkedLists instead of sets? We are using them to iterate the statements.
	// Testing for containment is trivial without the hash set anyway using "stm.getField() == field".
	private Set<FieldAssignment> fieldAssignments = new HashSet<FieldAssignment>();
	private Set<FieldReference> fieldReferences = new HashSet<FieldReference>();
	
	Field(Variable variable, boolean isStatic) {
		this.variable = variable;
		this.isStatic = isStatic;
		this.variable.setField(this);
	}
	
	/**
	 * Returns true if this is a static field.
	 */
	public boolean isStatic() {
		return isStatic;
	}
	
	/**
	 * Returns the field's variable, which holds all the possible
	 * values of the field at any time.
	 * @return a variable
	 */
	public Variable getVariable() {
		return variable;
	}
	
	/**
	 * Adds a field assignment to this field's set of assignments. This is called by {@link FieldAssignment}'s
	 * constructor.
	 * @param fa an assignment to this field
	 * @exception IllegalArgumentException if the assignment assigned to a field other than this
	 */
	void addFieldAssignment(FieldAssignment fa) {
	    if (fa.getField() != this) {
	        throw new IllegalArgumentException("Not an assignment to this field");
	    }
		fieldAssignments.add(fa);
	}
	
    /**
     * Adds a field reference to this field's set of references. This is called by {@link FieldReference}'s
     * constructor.
     * @param fa an assignment to this field
     * @exception IllegalArgumentException if the assignment assigned to a field other than this
     */
    void addFieldReference(FieldReference fr) {
        if (fr.getField() != this) {
            throw new IllegalArgumentException("Not a reference to this field");
        }
        fieldReferences.add(fr);
    }
	
	/**
	 * Returns the (unmodifiable) set of assignments to this field.
	 * @return an umodifiable set backed by the field object.
	 */
	public Set<FieldAssignment> getFieldAssignments() {
		return Collections.unmodifiableSet(fieldAssignments);
	}
	
	/**
	 * Returns the (unmodifiable) set of references to this field.
	 * @return an umodifiable set backed by the field object.
	 */
	public Set<FieldReference> getFieldReferences() {
	    return Collections.unmodifiableSet(fieldReferences);
	}
	
	@Override
	public String toString() {
		return "field("+variable+")";
	}
}
