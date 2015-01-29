package dk.brics.string.grammar.operations;

import dk.brics.string.charset.CharSet;
import dk.brics.string.directedgraph.StronglyConnectedComponents;
import dk.brics.string.grammar.*;
import dk.brics.string.stringoperations.Operation;

import java.util.*;

/**
 * Operation cycle approximation.
 */
public class OperationCycleApproximation {

    private Grammar g;

    private StronglyConnectedComponents<Nonterminal, Component> comp;

    private CharSet[] charsets;

    private List<Set<Nonterminal>> nexts, prevs;

    /**
     * Constructs a new approximator for the given grammar.
     *
     * @param g
     */
    public OperationCycleApproximation(Grammar g) {
        this.g = g;
    }

    /**
     * Approximates operation cycles in the grammar.
     * An operation cycle is an occurrence of a production [<tt>a -> op1(b)</tt>] or [<tt>a -> op2(b,c)</tt>]
     * where <tt>b</tt> or <tt>c</tt> recursively refers to <tt>a</tt>.
     */
    public void approximate() {
        comp = g.getComponents(false);
        findCharsets();
        boolean done = false;
        while (!done) {
            done = true;
            for (Component c : comp.getComponents()) {
                int cycles = 0;
                Nonterminal max_nt = null;
                Production max_prod = null;
                Operation max_op = null;
                // look for operation cycles in this component
                for (Nonterminal n : c.getNodes()) {
                    for (Production p : n.getProductions()) {
                        CycleVisitor v = new CycleVisitor(c);
                        p.visitBy(n, v);
                        if (v.is_cycle) {
                            if (cycles == 0 || v.op.getPriority() > max_op.getPriority()) { // assume that the operations are different objects
                                max_nt = n;
                                max_prod = p;
                                max_op = v.op;
                            }
                            cycles++;
                        }
                    }
                }
                if (cycles > 0) {
                    if (cycles > 1) {
                        done = false;
                    }
                    // replace  A->op  with  A->automatonproduction(charset(op))
                    CharSetTransferVisitor ctv = new CharSetTransferVisitor();
                    max_prod.visitBy(null, ctv);
                    max_nt.getProductions().remove(max_prod);
                    g.addAutomatonProduction(max_nt, ctv.c.toAutomaton());
                }
            }
            if (!done) {
                comp = g.getComponents(false);
            }
        }
    }

    /**
     * Returns number of operation cycles.
     */
    public int countCycles() {
        int cycles = 0;
        comp = g.getComponents(false);
        for (Component c : comp.getComponents()) {
            for (Nonterminal n : c.getNodes()) {
                for (Production p : n.getProductions()) {
                    CycleVisitor v = new CycleVisitor(c);
                    p.visitBy(n, v);
                    if (v.is_cycle) {
                        cycles++;
                    }
                }
            }
        }
        return cycles;
    }

    private void findPrevsNexts() {
        nexts = new ArrayList<Set<Nonterminal>>();
        prevs = new ArrayList<Set<Nonterminal>>();
        for (int i = 0; i < g.getNumberOfNonterminals(); i++) {
            nexts.add(new HashSet<Nonterminal>());
            prevs.add(new HashSet<Nonterminal>());
        }
        g.visitProductions(new ProductionVisitor() {

            public void visitAutomatonProduction(Nonterminal a, AutomatonProduction p) {
            }

            public void visitBinaryProduction(Nonterminal a, BinaryProduction p) {
                nexts.get(a.getKey()).add(p.getNonterminal1());
                nexts.get(a.getKey()).add(p.getNonterminal2());
                prevs.get(p.getNonterminal1().getKey()).add(a);
                prevs.get(p.getNonterminal2().getKey()).add(a);
            }

            public void visitEpsilonProduction(Nonterminal a, EpsilonProduction p) {
            }

            public void visitPairProduction(Nonterminal a, PairProduction p) {
                nexts.get(a.getKey()).add(p.getNonterminal1());
                nexts.get(a.getKey()).add(p.getNonterminal2());
                prevs.get(p.getNonterminal1().getKey()).add(a);
                prevs.get(p.getNonterminal2().getKey()).add(a);
            }

            public void visitUnaryProduction(Nonterminal a, UnaryProduction p) {
                nexts.get(a.getKey()).add(p.getNonterminal());
                prevs.get(p.getNonterminal().getKey()).add(a);
            }

            public void visitUnitProduction(Nonterminal a, UnitProduction p) {
                nexts.get(a.getKey()).add(p.getNonterminal());
                prevs.get(p.getNonterminal().getKey()).add(a);
            }
        });
    }

    /**
     * Finds charsets for all nonterminals, assumes that components have been found.
     */
    private void findCharsets() {
        findPrevsNexts();
        charsets = new CharSet[g.getNumberOfNonterminals()];
        for (Component c : comp.getComponents()) // traverses SCC tree bottom-up
        {
            findCharsets(c);
        }
    }

    /**
     * Finds charsets for all nonterminals in the given component,
     * assuming that its successors have been processed.
     */
    private void findCharsets(Component c) {
        // reset charsets
        for (Nonterminal n : c.getNodes()) {
            charsets[n.getKey()] = new CharSet();
        }
        // fixpoint iteration, within this component
        TreeSet<Nonterminal> worklist = new TreeSet<Nonterminal>(c.getNodes());
        while (!worklist.isEmpty()) {
            Nonterminal n = worklist.first();
            worklist.remove(n);
            if (updateCharset(n)) {
                for (Nonterminal m : prevs.get(n.getKey())) {
                    if (comp.getComponent(m) == c) {
                        worklist.add(m);
                    }
                }
            }
        }
    }

    /**
     * Updates charset according to productions. Returns true if any changes.
     */
    boolean updateCharset(Nonterminal n) {
        List<CharSet> c = new ArrayList<CharSet>();
        c.add(charsets[n.getKey()]);
        CharSetTransferVisitor ctv = new CharSetTransferVisitor();
        for (Production p : n.getProductions()) {
            p.visitBy(null, ctv);
            c.add(ctv.c);
        }
        CharSet newset = CharSet.union(c);
        boolean changed = !newset.equals(charsets[n.getKey()]);
        charsets[n.getKey()] = newset;
        return changed;
    }

    /**
     * Returns string representation of character sets for all nonterminals.
     */
    public String getCharsets() {
        comp = g.getComponents(false);
        findCharsets();
        StringBuilder b = new StringBuilder();
        for (Nonterminal n : g.getNonterminals()) {
            b.append(n).append(": ").append(charsets[n.getKey()]).append("\n");
        }
        return b.toString();
    }

    static class CycleVisitor implements ProductionVisitor {

        Component c;

        boolean is_cycle = false;
        Operation op;

        CycleVisitor(Component c) {
            this.c = c;
        }

        public void visitUnaryProduction(Nonterminal a, UnaryProduction p) {
            is_cycle = c.contains(p.getNonterminal());
            op = p.getOperation();
        }

        public void visitBinaryProduction(Nonterminal a, BinaryProduction p) {
            is_cycle = c.contains(p.getNonterminal1()) || c.contains(p.getNonterminal2());
            op = p.getOperation();
        }

        public void visitAutomatonProduction(Nonterminal a, AutomatonProduction p) {
        }

        public void visitEpsilonProduction(Nonterminal a, EpsilonProduction p) {
        }

        public void visitPairProduction(Nonterminal a, PairProduction p) {
        }

        public void visitUnitProduction(Nonterminal a, UnitProduction p) {
        }
    }

    class CharSetTransferVisitor implements ProductionVisitor {

        CharSet c;

        public void visitAutomatonProduction(Nonterminal a, AutomatonProduction p) {
            c = new CharSet(p.getAutomaton());
        }

        public void visitBinaryProduction(Nonterminal a, BinaryProduction p) {
            c = p.getOperation().charsetTransfer(
                    charsets[p.getNonterminal1().getKey()],
                    charsets[p.getNonterminal2().getKey()]);
        }

        public void visitEpsilonProduction(Nonterminal a, EpsilonProduction p) {
            c = new CharSet();
        }

        public void visitPairProduction(Nonterminal a, PairProduction p) {
            c = charsets[p.getNonterminal1().getKey()]
                    .union(charsets[p.getNonterminal2().getKey()]);
        }

        public void visitUnaryProduction(Nonterminal a, UnaryProduction p) {
            c = p.getOperation().charsetTransfer(charsets[p.getNonterminal().getKey()]);
        }

        public void visitUnitProduction(Nonterminal a, UnitProduction p) {
            c = charsets[p.getNonterminal().getKey()];
        }
    }
}
