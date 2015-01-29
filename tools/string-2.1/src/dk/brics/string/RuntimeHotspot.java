package dk.brics.string;

import dk.brics.automaton.Automaton;
import soot.ValueBox;

/**
 * A representation of a hotspot in the analysis of a program
 * using the string analysis runtime library.
 * Each <code>RuntimeHotspot</code> object corresponds to a specific
 * call of the {@link dk.brics.string.runtime.Strings#analyze Strings.analyze} or
 * {@link dk.brics.string.runtime.Strings#check Strings.check} runtime method.
 *
 * @see dk.brics.string.runtime.Strings
 */
public class RuntimeHotspot {

    /**
     * The actual string expression to analyze.
     */
    public ValueBox spot;

    /**
     * The expected analysis result for the expression.
     * This corresponds to the regular expression or automaton
     * given in the runtime method call.
     */
    public Automaton expected;

    public HotspotKind kind;

    RuntimeHotspot(ValueBox spot, Automaton expected, HotspotKind kind) {
        this.spot = spot;
        this.expected = expected;
        this.kind = kind;
    }
}
