package dk.brics.string.grammar;

import dk.brics.automaton.Automaton;
import dk.brics.string.directedgraph.StronglyConnectedComponents;
import dk.brics.string.grammar.operations.Component;
import dk.brics.string.grammar.operations.Component.Recursion;
import dk.brics.string.grammar.operations.AssertionCycleApproximation;
import dk.brics.string.grammar.operations.GrammarAsDirectedGraph;
import dk.brics.string.grammar.operations.OperationCycleApproximation;
import dk.brics.string.grammar.operations.RegularApproximation;
import dk.brics.string.stringoperations.BinaryOperation;
import dk.brics.string.stringoperations.UnaryOperation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Context-free grammar with regular operations.
 *
 * @author Anders M&oslash;ller &lt;<a href="mailto:amoeller@cs.au.dk">amoeller@cs.au.dk</a>&gt;
 */
public class Grammar {

    private List<Nonterminal> nonterminals;

    /**
     * Constructs new empty grammar.
     */
    public Grammar() {
        nonterminals = new ArrayList<Nonterminal>();
    }

    /**
     * Adds new nonterminal.
     */
    public Nonterminal addNonterminal() {
        Nonterminal n = new Nonterminal(nonterminals.size());
        nonterminals.add(n);
        return n;
    }

    /**
     * Returns the (unmodifiable) list of nonterminals in this grammar.
     */
    public List<Nonterminal> getNonterminals() {
        return Collections.unmodifiableList(nonterminals);
    }

    /**
     * Adds new unit production [<tt>a -> b</tt>].
     * Ignored if <tt>a==b</tt>.
     */
    public void addUnitProduction(Nonterminal a, Nonterminal b) {
        if (a != b) {
            a.getProductions().add(new UnitProduction(b));
        }
    }

    /**
     * Adds new pair production [<tt>a -> b c</tt>].
     */
    public void addPairProduction(Nonterminal a, Nonterminal b, Nonterminal c) {
        a.getProductions().add(new PairProduction(b, c));
    }

    /**
     * Adds new automaton production [<tt>a -> reg</tt>].
     * Ignored if <tt>reg</tt> is empty.
     */
    public void addAutomatonProduction(Nonterminal a, Automaton reg) {
        if (!reg.isEmpty()) {
            a.getProductions().add(new AutomatonProduction(reg));
        }
    }

    /**
     * Adds new epsilon production [<tt>a -> ""</tt>].
     */
    public void addEpsilonProduction(Nonterminal a) {
        a.getProductions().add(new EpsilonProduction());
    }

    /**
     * Adds new unary operation production [<tt>a -> op1(b)</tt>].
     */
    public void addUnaryProduction(Nonterminal a, UnaryOperation op, Nonterminal b) {
        a.getProductions().add(new UnaryProduction(op, b));
    }

    /**
     * Adds new binary operation production [<tt>a -> op2(b,c)</tt>].
     */
    public void addBinaryProduction(Nonterminal a, BinaryOperation op, Nonterminal b, Nonterminal c) {
        a.getProductions().add(new BinaryProduction(op, b, c));
    }

    /**
     * Returns number of nonterminals in this grammar.
     */
    public int getNumberOfNonterminals() {
        return nonterminals.size();
    }

    /**
     * Returns number of productions in this grammar.
     */
    public int getNumberOfProductions() {
        int x = 0;
        for (Nonterminal n : nonterminals) {
            x += n.getProductions().size();
        }
        return x;
    }

    /**
     * Returns string representation of this grammar.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Nonterminal v : nonterminals) {
            for (Production p : v.getProductions()) {
                s.append(v).append(" -> ").append(p).append("\n");
            }
        }
        return s.toString();
    }

    /**
     * Visits all productions with the given visitor.
     */
    public void visitProductions(ProductionVisitor v) {
        for (Nonterminal a : nonterminals) {
            for (Production p : a.getProductions()) {
                p.visitBy(a, v);
            }
        }
    }
    
    /**
     * Breaks operation cycles using {@link AssertionCycleApproximation} and then
     * approximates the remaining operation cycles with {@link OperationCycleApproximation}.
     */
    public void approximateOperationCycles() {
        new AssertionCycleApproximation(this).approximate();
        new OperationCycleApproximation(this).approximate();
    }

    /**
     * See {@link OperationCycleApproximation#countCycles()}.
     */
    public int getNumberOfOperationCycles() {
        return new OperationCycleApproximation(this).countCycles();
    }

    /**
     * Finds the strongly connected components and their recursion kinds.
     */
    public StronglyConnectedComponents<Nonterminal, Component> getComponents(boolean find_recursion_kinds) {
        StronglyConnectedComponents<Nonterminal, Component> comp =
                new StronglyConnectedComponents<Nonterminal, Component>(new GrammarAsDirectedGraph(this));
        if (find_recursion_kinds) {
            for (Component c : comp.getComponents()) {
                c.findRecursion();
            }
        }
        return comp;
    }

    /**
     * Returns number of components.
     */
    public int getNumberOfComponents() {
        return getComponents(false).getComponents().size();
    }

    /**
     * Returns number of non-linear components.
     */
    public int getNumberOfNonLinearComponents() {
        int nonreg = 0;
        StronglyConnectedComponents<Nonterminal, Component> comp = getComponents(true);
        for (Component c : comp.getComponents()) {
            if (c.getRecursion() == Recursion.BOTH) {
                nonreg++;
            }
        }
        return nonreg;
    }

    /**
     * See {@link OperationCycleApproximation#getCharsets()}.
     */
    public String getCharsets() {
        return new OperationCycleApproximation(this).getCharsets();
    }

    /**
     * See {@link RegularApproximation}.
     */
    public void approximateNonLinear(Collection<Nonterminal> hotspots) {
        new RegularApproximation(this).approximate(hotspots);
    }
}
