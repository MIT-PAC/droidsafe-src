package dk.brics.string.grammar.operations;

import java.util.LinkedList;
import java.util.List;

import dk.brics.string.directedgraph.StronglyConnectedComponents;
import dk.brics.string.grammar.BinaryProduction;
import dk.brics.string.grammar.Grammar;
import dk.brics.string.grammar.Nonterminal;
import dk.brics.string.grammar.Production;
import dk.brics.string.grammar.UnaryProduction;
import dk.brics.string.grammar.UnitProduction;

/**
 * Assertions involved in operation cycles are replaced by unit productions to
 * prevent them from provoking a character set approximation that would not otherwise occur.
 * <p/>
 * That is, a production of form <tt>X -&gt; assertOp(Y,Z)</tt> can be replaced with <tt>X -&gt Y</tt>.
 * <p/>
 * Strongly connected components are found independently of {@link OperationCycleApproximation}, so any
 * components that might be broken by this approximation will not be subject to character set approximation afterwards.
 * @author Asger
 */
public class AssertionCycleApproximation {
    
    private Grammar g;
    private StronglyConnectedComponents<Nonterminal, Component> comp;

    public AssertionCycleApproximation(Grammar g) {
        this.g = g;
    }
    
    public void approximate() {
        comp = g.getComponents(false);
        
        for (Component c : comp.getComponents()) {
            for (Nonterminal nt : c.getNodes()) {
                List<Production> removedProductions = new LinkedList<Production>();
                List<Production> addedProductions = new LinkedList<Production>();
                for (Production prod : nt.getProductions()) {
                    if (prod instanceof BinaryProduction) {
                        BinaryProduction bp = (BinaryProduction)prod;
                        
                        // only consider assertions
                        if (!bp.getOperation().isAssertion())
                            continue;
                        
                        // if the destination node is also in a cycle
                        if (c.contains(bp.getNonterminal1()) || c.contains(bp.getNonterminal2())) {
                            removedProductions.add(prod);
                            addedProductions.add(new UnitProduction(bp.getNonterminal1()));
                        }
                    }
                    else if (prod instanceof UnaryProduction) {
                        UnaryProduction up = (UnaryProduction)prod;
                        
                        // only consider assertions
                        if (!up.getOperation().isAssertion())
                            continue;
                        
                        // if the destination node is also in a cycle
                        if (c.contains(up.getNonterminal())) {
                            removedProductions.add(prod);
                            addedProductions.add(new UnitProduction(up.getNonterminal()));
                        }
                    }
                }
                nt.getProductions().removeAll(removedProductions);
                nt.getProductions().addAll(addedProductions);
            }
        }
    }
}
