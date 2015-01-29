package dk.brics.string.mlfa;

import dk.brics.automaton.Automaton;
import dk.brics.string.Misc;

/**
 * Automaton transition.
 */
public class AutomatonTransition extends MLFATransition {

    private Automaton a;

    /**
     * Construcs a new automaton transition.
     */
    public AutomatonTransition(Automaton a) {
        this.a = a;
    }

    @Override
    public String toString() {
        Object info = a.getInfo();
        if (info == null) {
            if (a.getSingleton() != null) {
                info = "\"" + Misc.escape(a.getSingleton()) + "\"";
            } else {
                info = "<???>";
            }
        }
        return "{" + info + "}";
    }

    /**
     * Returns the automaton of this transition.
     */
    public Automaton getAutomaton() {
        return a;
    }

    @Override
    public <T> T visitBy(TransitionVisitor<T> v) {
        return v.visitAutomatonTransition(this);
    }
}
