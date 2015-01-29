package dk.brics.string.grammar.operations;

import dk.brics.string.directedgraph.StronglyConnectedComponents;
import dk.brics.string.grammar.*;
import dk.brics.string.grammar.operations.Component.Recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Mohri-Nederhof approximation of grammars.
 */
public class RegularApproximation {

    private Grammar g;

    private StronglyConnectedComponents<Nonterminal, Component> comp;

    /**
     * Constructs a new approximator.
     */
    public RegularApproximation(Grammar g) {
        this.g = g;
    }

    /**
     * Performs Mohri-Nederhof regular approximation on the grammar.
     * The grammar is assumed to have no operation cycles (see {@link Grammar#approximateOperationCycles()}).
     *
     * @param hotspots nonterminals that correspond to expressions where automata are extracted later
     */
    public void approximate(Collection<Nonterminal> hotspots) {

        // find components and their recursion kinds
        GrammarAsDirectedGraph gd = new GrammarAsDirectedGraph(g);
        comp = new StronglyConnectedComponents<Nonterminal, Component>(gd);
        for (Component c : comp.getComponents()) {
            c.findRecursion();
        }
        boolean need_epsilon[] = new boolean[g.getNumberOfNonterminals()];
        final Nonterminal[] primed = new Nonterminal[g.getNumberOfNonterminals()];
        List<List<Production>> oldproductions = new ArrayList<List<Production>>();
        for (int i = 0; i < g.getNumberOfNonterminals(); i++) {
            oldproductions.add(null);
        }

        // find nonterminals that need epsilons
        for (Nonterminal a : g.getNonterminals()) {
            if (hotspots.contains(a)) {
                need_epsilon[a.getKey()] = true;
            }
            for (Nonterminal b : gd.getSuccesors().get(a.getKey())) {
                if (comp.getComponent(a) != comp.getComponent(b)) {
                    need_epsilon[b.getKey()] = true;
                }
            }
        }

        // find components that have both right and left recursion
        for (final Component c : comp.getComponents()) {
            if (c.getRecursion() == Recursion.BOTH) {
                List<Nonterminal> nonterminals = new ArrayList<Nonterminal>(c.getNodes());

                // make primed nonterminals and epsilon transitions
                for (Nonterminal a : nonterminals) {
                    int an = a.getKey();
                    oldproductions.set(an, a.getProductions());
                    a.setProductions(new ArrayList<Production>());
                    // A' -> ""  if hotspot or used by other component
                    Nonterminal nonterminal = newNonterminal(c);
                    nonterminal.setTaint(a.isTaint());
                    primed[an] = nonterminal;
                    if (need_epsilon[an]) {
                        g.addEpsilonProduction(primed[an]);
                    }
                }

                // make new productions and extra nonterminals for each original nonterminal
                for (Nonterminal a : nonterminals) {
                    final int an = a.getKey();
                    for (Production p : oldproductions.get(an)) {
                        p.visitBy(a, new ProductionVisitor() {

                            // A -> B
                            public void visitUnitProduction(Nonterminal a, UnitProduction p) {
                                if (c.contains(p.getNonterminal())) {
                                    // A -> B  =>  A -> B, B' -> A'
                                    g.addUnitProduction(a, p.getNonterminal());
                                    g.addUnitProduction(primed[p.getNonterminal().getKey()], primed[an]);
                                } else {
                                    // A -> X  =>  A -> X A'
                                    g.addPairProduction(a, p.getNonterminal(), primed[an]);
                                }
                            }

                            // A -> B C
                            public void visitPairProduction(Nonterminal a, PairProduction p) {
                                if (c.contains(p.getNonterminal1())) {
                                    if (c.contains(p.getNonterminal2())) {
                                        // A -> B C  =>  A -> B, B' -> C, C' -> A'
                                        g.addUnitProduction(a, p.getNonterminal1());
                                        g.addUnitProduction(primed[p.getNonterminal1().getKey()], p.getNonterminal2());
                                        g.addUnitProduction(primed[p.getNonterminal2().getKey()], primed[an]);
                                    } else {
                                        // A -> B X  =>  A -> B, B' -> X A'
                                        g.addUnitProduction(a, p.getNonterminal1());
                                        g.addPairProduction(primed[p.getNonterminal1().getKey()], p.getNonterminal2(), primed[an]);
                                    }
                                } else {
                                    if (c.contains(p.getNonterminal2())) {
                                        // A -> X B  =>  A -> X B, B' -> A'
                                        g.addPairProduction(a, p.getNonterminal1(), p.getNonterminal2());
                                        g.addUnitProduction(primed[p.getNonterminal2().getKey()], primed[an]);
                                    } else {
                                        // A -> X Y  =>  A -> R A', R -> X Y
                                        Nonterminal r = newNonterminal(c);
                                        r.setTaint(p.getNonterminal1().isTaint() || p.getNonterminal2().isTaint());
                                        g.addPairProduction(a, r, primed[an]);
                                        g.addPairProduction(r, p.getNonterminal1(), p.getNonterminal2());
                                    }
                                }
                            }

                            // A -> reg
                            public void visitAutomatonProduction(Nonterminal a, AutomatonProduction p) {
                                // A -> reg  =>  A -> R A', R -> reg
                                Nonterminal r = newNonterminal(c);
                                r.setTaint(a.isTaint());
                                g.addPairProduction(a, r, primed[an]);
                                g.addAutomatonProduction(r, p.getAutomaton());
                            }

                            // A -> op1(X)
                            public void visitUnaryProduction(Nonterminal a, UnaryProduction p) {
                                // A -> op1(X)  =>  A -> R A', R -> op1(X)
                                Nonterminal r = newNonterminal(c);
                                r.setTaint(a.isTaint());
                                g.addPairProduction(a, r, primed[an]);
                                g.addUnaryProduction(r, p.getOperation(), p.getNonterminal());
                            }

                            // A -> op1(X,Y)
                            public void visitBinaryProduction(Nonterminal a, BinaryProduction p) {
                                // A -> op2(X,Y)  =>  A -> R A', R -> op2(X,Y)
                                Nonterminal r = newNonterminal(c);
                                r.setTaint(a.isTaint());
                                g.addPairProduction(a, r, primed[an]);
                                g.addBinaryProduction(r, p.getOperation(), p.getNonterminal1(), p.getNonterminal2());
                            }

                            // A -> ""
                            public void visitEpsilonProduction(Nonterminal a, EpsilonProduction p) {
                                // A -> ""  =>  A -> A'
                                g.addUnitProduction(a, primed[an]);
                            }
                        });
                    }
                }

                // now this component only has right recursion
                c.setRecursion(Recursion.RIGHT);
            }
        }
    }

    private Nonterminal newNonterminal(Component c) {
        Nonterminal n = g.addNonterminal();
        comp.add(n, c);
        return n;
    }
}
