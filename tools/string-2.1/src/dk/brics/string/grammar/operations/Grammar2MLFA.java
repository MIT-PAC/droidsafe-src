package dk.brics.string.grammar.operations;

import dk.brics.string.directedgraph.StronglyConnectedComponents;
import dk.brics.string.grammar.*;
import dk.brics.string.grammar.operations.Component.Recursion;
import dk.brics.string.mlfa.MLFA;
import dk.brics.string.mlfa.MLFAState;
import dk.brics.string.mlfa.MLFAStatePair;

/**
 * Converter from strongly regular grammars to MLFAs.
 *
 * @see dk.brics.string.StringAnalysis
 */
public class Grammar2MLFA {

    private Grammar g;

    private StronglyConnectedComponents<Nonterminal, Component> comp;

    private MLFAState[] nt_states;

    /**
     * Constructs a new converter for the given grammar.
     */
    public Grammar2MLFA(Grammar g) {
        this.g = g;
    }

    /**
     * Constructs {@link MLFA} from the grammar.
     * The grammar is assumed to be approximated first (see {@link RegularApproximation}).
     *
     * @see #getMLFAStatePair(Nonterminal)
     */
    public MLFA convert() {
        comp = g.getComponents(true);
        nt_states = new MLFAState[g.getNumberOfNonterminals()];
        MLFA mlfa = new MLFA();
        for (Component c : comp.getComponents()) {
            convertComponent(c, mlfa);
        }
        return mlfa;
    }

    /**
     * Returns MLFA state pair representing initial and final state for the given nonterminal.
     * {@link #convert()} must be called first.
     */
    public MLFAStatePair getMLFAStatePair(Nonterminal n) {
        MLFAStatePair p;
        Component c = comp.getComponent(n);
        if (c.getRecursion() == Recursion.RIGHT || c.getRecursion() == Recursion.NONE) {
            p = new MLFAStatePair(nt_states[n.getKey()], c.getState());
        } else {
            p = new MLFAStatePair(c.getState(), nt_states[n.getKey()]);
        }
        p.setTaint(n.isTaint());
        return p;
    }

    private void convertComponent(final Component c, final MLFA mlfa) {
        if (c.getState() == null) {

            // make states
            c.setState(mlfa.addState());
            for (Nonterminal a : c.getNodes()) {
                nt_states[a.getKey()] = mlfa.addState();
            }

            // make transitions
            for (Nonterminal a : c.getNodes()) {
                for (Production p : a.getProductions()) {
                    if (c.getRecursion() == Recursion.BOTH) {
                        throw new RuntimeException("grammar is not strongly regular");
                    } else if (c.getRecursion() == Recursion.RIGHT || c.getRecursion() == Recursion.NONE) {
                        // component is right or non recursive
                        p.visitBy(a, new ProductionVisitor() {

                            public void visitUnitProduction(Nonterminal a, UnitProduction p) {
                                if (c.contains(p.getNonterminal())) {
                                    // A -> B  =>  (A)--e-->(B)
                                    mlfa.addEpsilonTransition(nt_states[a.getKey()], nt_states[p.getNonterminal().getKey()]);
                                } else {
                                    // A -> X  =>  (A)--[X]-->(T)
                                    convertComponent(comp.getComponent(p.getNonterminal()), mlfa);
                                    mlfa.addIdentityTransition(nt_states[a.getKey()], c.getState(), getMLFAStatePair(p.getNonterminal()));
                                }
                            }

                            public void visitPairProduction(Nonterminal a, PairProduction p) {
                                if (c.contains(p.getNonterminal2())) {
                                    // A -> X B  =>  (A)--[X]-->(B)
                                    convertComponent(comp.getComponent(p.getNonterminal1()), mlfa);
                                    mlfa.addIdentityTransition(nt_states[a.getKey()], nt_states[p.getNonterminal2().getKey()], getMLFAStatePair(p.getNonterminal1()));
                                } else {
                                    // A -> X Y  =>  (A)--[X]-->(R), (R)--[Y]-->(T)
                                    MLFAState r = mlfa.addState();
                                    convertComponent(comp.getComponent(p.getNonterminal1()), mlfa);
                                    convertComponent(comp.getComponent(p.getNonterminal2()), mlfa);
                                    mlfa.addIdentityTransition(nt_states[a.getKey()], r, getMLFAStatePair(p.getNonterminal1()));
                                    mlfa.addIdentityTransition(r, c.getState(), getMLFAStatePair(p.getNonterminal2()));
                                }
                            }

                            public void visitAutomatonProduction(Nonterminal a, AutomatonProduction p) {
                                // A -> reg  =>  (A)--[reg]-->(T)
                                mlfa.addAutomatonTransition(nt_states[a.getKey()], c.getState(), p.getAutomaton());
                            }

                            public void visitUnaryProduction(Nonterminal a, UnaryProduction p) {
                                // A -> op1(X)  =>  (A)--[op1(X)]-->(T)
                                convertComponent(comp.getComponent(p.getNonterminal()), mlfa);
                                mlfa.addUnaryTransition(nt_states[a.getKey()], c.getState(), p.getOperation(), getMLFAStatePair(p.getNonterminal()));
                            }

                            public void visitBinaryProduction(Nonterminal a, BinaryProduction p) {
                                // A -> op2(X,Y)  =>  (A)--[op2(X,Y)]-->(T)
                                convertComponent(comp.getComponent(p.getNonterminal1()), mlfa);
                                convertComponent(comp.getComponent(p.getNonterminal2()), mlfa);
                                mlfa.addBinaryTransition(nt_states[a.getKey()], c.getState(), p.getOperation(),
                                        getMLFAStatePair(p.getNonterminal1()), getMLFAStatePair(p.getNonterminal2()));
                            }

                            public void visitEpsilonProduction(Nonterminal a, EpsilonProduction p) {
                                // A -> ""  =>  (A)--e-->(T)
                                mlfa.addEpsilonTransition(nt_states[a.getKey()], c.getState());
                            }
                        });
                    } else {
                        // component is left recursive
                        p.visitBy(a, new ProductionVisitor() {

                            public void visitUnitProduction(Nonterminal a, UnitProduction p) {
                                if (c.contains(p.getNonterminal())) {
                                    // A -> B  =>  (B)---e--->(A)
                                    mlfa.addEpsilonTransition(nt_states[p.getNonterminal().getKey()], nt_states[a.getKey()]);
                                } else {
                                    // A -> X  =>  (S)--[X]-->(A)
                                    convertComponent(comp.getComponent(p.getNonterminal()), mlfa);
                                    mlfa.addIdentityTransition(c.getState(), nt_states[a.getKey()], getMLFAStatePair(p.getNonterminal()));
                                }
                            }

                            public void visitPairProduction(Nonterminal a, PairProduction p) {
                                if (c.contains(p.getNonterminal1())) {
                                    // A -> B X  =>  (B)--[X]-->(A)
                                    convertComponent(comp.getComponent(p.getNonterminal2()), mlfa);
                                    mlfa.addIdentityTransition(nt_states[p.getNonterminal1().getKey()], nt_states[a.getKey()], getMLFAStatePair(p.getNonterminal2()));
                                } else {
                                    // A -> X Y  =>  (S)--[X]-->(R), (R)--[Y]-->(A)
                                    MLFAState r = mlfa.addState();
                                    convertComponent(comp.getComponent(p.getNonterminal1()), mlfa);
                                    convertComponent(comp.getComponent(p.getNonterminal2()), mlfa);
                                    mlfa.addIdentityTransition(c.getState(), r, getMLFAStatePair(p.getNonterminal1()));
                                    mlfa.addIdentityTransition(r, nt_states[a.getKey()], getMLFAStatePair(p.getNonterminal2()));
                                }
                            }

                            public void visitAutomatonProduction(Nonterminal a, AutomatonProduction p) {
                                // A -> reg  =>  (S)--[reg]-->(A)
                                mlfa.addAutomatonTransition(c.getState(), nt_states[a.getKey()], p.getAutomaton());
                            }

                            public void visitUnaryProduction(Nonterminal a, UnaryProduction p) {
                                // A -> op1(X)  =>  (S)--[op1(X)]-->(A)
                                convertComponent(comp.getComponent(p.getNonterminal()), mlfa);
                                mlfa.addUnaryTransition(c.getState(), nt_states[a.getKey()], p.getOperation(), getMLFAStatePair(p.getNonterminal()));
                            }

                            public void visitBinaryProduction(Nonterminal a, BinaryProduction p) {
                                // A -> op2(X,Y)  =>  (S)--[op2(X,Y)]-->(A)
                                convertComponent(comp.getComponent(p.getNonterminal1()), mlfa);
                                convertComponent(comp.getComponent(p.getNonterminal2()), mlfa);
                                mlfa.addBinaryTransition(c.getState(), nt_states[a.getKey()], p.getOperation(),
                                        getMLFAStatePair(p.getNonterminal1()),
                                        getMLFAStatePair(p.getNonterminal2()));
                            }

                            public void visitEpsilonProduction(Nonterminal a, EpsilonProduction p) {
                                // A -> ""  =>  (S)---e--->(A)
                                mlfa.addEpsilonTransition(c.getState(), nt_states[a.getKey()]);
                            }
                        });
                    }
                }
            }
        }
    }
}
