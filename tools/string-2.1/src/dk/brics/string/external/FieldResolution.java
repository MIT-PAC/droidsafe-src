package dk.brics.string.external;

import dk.brics.automaton.Automaton;

/**
 * Description of a non-application <tt>String</tt> field.
 * <p/>
 * It is allowed for the same field to yield different resolutions at various program
 * points. Because only immutable fields can be resolved, it is legal to change the
 * field in non-application code, as long as all resolutions of the field remain valid
 * at each reference to that field.
 * <p/>
 * Note that it is better for a resolver to return <tt>null</tt> instead of creating
 * a field resolution accepting <em>any string</em>, since another resolver might
 * produce a more accurate answer. The outcomes of an unresolved field, and the <em>any string</em>
 * resolution, are identical.
 * 
 * @author Asger
 *
 */
public class FieldResolution {
    private Automaton automaton;
    
    /**
     * Creates a field resolution specifying the possible values of the field,
     * at the place it was read.
     * @param automaton automaton accepting all possible values of the field.
     */
    public FieldResolution(Automaton automaton) {
        setAutomaton(automaton);
    }
    
    /**
     * Returns an automaton accepting all the possible values of the field, at
     * the place it was read.
     * @return an automaton; never <tt>null</tt>.
     */
    public Automaton getAutomaton() {
        return automaton;
    }
    
    /**
     * Sets the automaton accepting all the possible values of the field, at
     * the place it was read.
     * @param automaton an automaton. Must not be <tt>null</tt>.
     */
    public void setAutomaton(Automaton automaton) {
        if (automaton == null)
            throw new IllegalArgumentException("Automaton must not be null");
        this.automaton = automaton;
    }
    
}
