package dk.brics.string.flow;

import dk.brics.automaton.Automaton;

/**
 * Initialization node.
 */
public class InitializationNode extends Node {

    Automaton reg;

    InitializationNode(int key, Automaton reg) {
        super(key);
        this.reg = reg;
    }

    /**
     * Returns the automaton.
     */
    public Automaton getReg() {
        return reg;
    }

    @Override
    public void visitBy(NodeVisitor v) {
        v.visitInitializationNode(this);
    }
}
