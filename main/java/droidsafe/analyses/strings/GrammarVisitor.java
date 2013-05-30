package droidsafe.analyses.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dk.brics.automaton.Automaton;
import dk.brics.string.directedgraph.StronglyConnectedComponents;
import dk.brics.string.grammar.AutomatonProduction;
import dk.brics.string.grammar.BinaryProduction;
import dk.brics.string.grammar.EpsilonProduction;
import dk.brics.string.grammar.Grammar;
import dk.brics.string.grammar.Nonterminal;
import dk.brics.string.grammar.PairProduction;
import dk.brics.string.grammar.Production;
import dk.brics.string.grammar.ProductionVisitor;
import dk.brics.string.grammar.UnaryProduction;
import dk.brics.string.grammar.UnitProduction;
import dk.brics.string.grammar.operations.Component;
import dk.brics.string.grammar.operations.Component.Recursion;
import droidsafe.analyses.strings.AutomataUtil.RE;

/**
 * @author garrinkimmell
 * 
 *         GrammarVisitor converts the productions for a strongly-regular Grammar into regular
 *         expressions.
 */
/**
 * @author garrinkimmell
 * 
 */
public class GrammarVisitor {

    /** The grammar that will be processed. **/
    private Grammar g;
    /** Mapping from grammar nonterminals to regular expressions **/
    private Map<Nonterminal, AutomataUtil.RE> reMap;

    /** The grammar's strongly connected components. **/
    private StronglyConnectedComponents<Nonterminal, Component> comps;

    /**
     * Constructor
     * 
     * @param grm The grammar to convert.
     */
    public GrammarVisitor(Grammar grm) {
        this.g = grm;
        reMap = new HashMap<Nonterminal, AutomataUtil.RE>();
        comps = grm.getComponents(true);
    }

    /**
     * @author garrinkimmell
     * 
     *         RecursiveProduction represents the set of productions for a nonterminal that may have
     *         recursive RHS, either directly or via other nonterminals.
     * 
     */
    private class RecursiveProduction implements ProductionVisitor {

        // In the description below, we assume that the language is
        // left-generating, when
        // in fact this depends on what comp.getRecursion() returns. The
        // only place this matters
        // is when we concatenate a terminal with a nonterminal, and we
        // abstract that out into the
        // concat method, which handles either case locally.
        //
        // We have
        // NT -> (SELF)NT + (CS0 R0 + ... + CSj Rj) + T1 .... Tk
        // Where R0 ... Rj are the elements of comp \not\equal NT, and
        // CS0 ... CSj are the sets of REs corresponding iwth each
        // respective
        // R in coeffs.

        // This is equivalent to
        // NT -> SELF* (CS0 R0 + ... + CSj Rj) + T1 .... Tk
        // Which we can multiply out:
        // NT -> SELF*CS0R0 + ... + SELF* CSj Rj + SELF* T1 + ... + SELF* Tk


        /** The nonterminal (LHS) associated with this production. **/
        private Nonterminal nt;

        /** The terminals (RHS) associated with this production **/
        private Set<RE> terms;

        /**
         * For each nonterminal appearing in the RHS which may recursively refer to this
         * nonterminal, the set of terminals associated with that nonterminal in this production.
         */
        private Map<Nonterminal, Set<RE>> coeffs;

        /** Whether this production is right- or left-generating. **/
        private Recursion rec;

        /**
         * The strongly connected component of nonterminals that may recursively reference this
         * nonterminal.
         */
        private Component comp;

        /**
         * Copy-constructor for RecursiveProduction.
         * 
         * @param c
         */
        public RecursiveProduction(RecursiveProduction c) {
            this.nt = c.nt;
            this.rec = c.rec;
            this.comp = c.comp;

            this.terms = new HashSet<RE>(c.terms);

            // Deep copy of coeffs.
            this.coeffs = new HashMap<Nonterminal, Set<RE>>();
            for (Map.Entry<Nonterminal, Set<RE>> entry : c.coeffs.entrySet()) {
                this.coeffs.put(entry.getKey(), new HashSet<RE>(entry.getValue()));
            }

        }

        /**
         * Constructor
         * 
         * @param nonterm The LHS nonterminal for this production.
         */
        public RecursiveProduction(Nonterminal nonterm) {
            this.nt = nonterm;
            this.comp = comps.getComponent(nonterm);
            this.rec = comp.getRecursion();

            this.terms = new HashSet<RE>();
            this.coeffs = new HashMap<Nonterminal, Set<RE>>();

        }



        /**
         * Convert the recursive production to a string.
         * 
         * @see java.lang.Object#toString()
         **/
        public String toString() {
            StringBuilder s = new StringBuilder(nt.toString() + " = ");
            String sep1 = "";
            for (Map.Entry<Nonterminal, Set<RE>> entry : coeffs.entrySet()) {
                s.append(sep1);

                if (entry.getValue().isEmpty()) {
                    continue;
                }

                if (rec == Recursion.LEFT) {
                    s.append(entry.getKey().toString());
                }

                if (entry.getValue().size() > 1) {
                    s.append("(");
                }
                String sep2 = "";
                for (RE c : entry.getValue()) {
                    s.append(sep2);
                    s.append(c.toString());
                    sep2 = " + ";
                }

                if (entry.getValue().size() > 1) {
                    s.append(")");
                }

                if (rec == Recursion.RIGHT) {
                    s.append(entry.getKey().toString());
                }

                sep1 = " + ";
            }

            for (RE c : terms) {
                s.append(sep1);
                s.append(c.toString());
                sep1 = " |+| ";
            }

            return s.toString();

        }

        /**
         * Given a pair of regular expressions, concatenate them in a manner consistent with this
         * production's recursion form (left- or right-recursive).
         * 
         * @param x
         * @param y
         * @return
         */
        private RE concat(RE x, RE y) {
            if (rec == Recursion.RIGHT) {
                return x.concat(y);
            } else {
                return y.concat(x);
            }
        }

        /**
         * Get the set of coefficients associated with the parameter nonterminal.
         * 
         * @param n The nonterminal to get coefficients for.
         * @return
         */
        private Set<RE> getCoeff(Nonterminal n) {
            Set<RE> cs = coeffs.get(n);
            if (cs == null) {
                cs = new HashSet<RE>();
                coeffs.put(n, cs);
            }
            return cs;
        }

        /**
         * Add the given regular expression to the set of coefficients associated with the given
         * nonterminal.
         * 
         * @param n The nonterminal to add to.
         * @param re The regular expression to add.
         */
        private void addCoeff(Nonterminal n, RE re) {
            getCoeff(n).addAll(re.getAlts());
        }

        /**
         * Remove all coefficients associated with the given nonterminal.
         * 
         * @param n The nonterminal to remove.
         * @return
         */
        private Set<RE> removeCoeff(Nonterminal n) {
            return this.coeffs.remove(n);
        }

        /**
         * Substitute the argument production into this production. Returns a copy of this.
         * 
         * @param other The recursive production to substitute in.
         * @return
         */
        public RecursiveProduction substitute(RecursiveProduction other) {
            // Copy the current equation
            RecursiveProduction newEqn = new RecursiveProduction(this);
            // Then perform the substitution destructively on the copy.
            newEqn.substituteDestructive(other);
            return newEqn;
        }

        /**
         * Substitute the argument production into this production. Modifies this.
         * 
         * @param other
         */
        private void substituteDestructive(RecursiveProduction other) {
            Nonterminal ont = other.nt;

            // Get the set of coefficients associated with the other
            // nonterminal;
            Set<RE> ocoeffs = getCoeff(ont);

            // If there are no coefficients associated with the other
            // nonterminal, then
            // we are done.
            if (!ocoeffs.isEmpty()) {

                // This will change coeffs, and terms.
                // Set<RE> newTerms = new HashSet<RE>(terms);

                // For each terminal t in other,
                // for each coefficient c associated with other in this,
                // add c(other.self*)term to newTerms.
                RE oSelfStar = unionREs(other.getCoeff(ont)).star();
                for (RE oterm : other.terms) {
                    for (RE c : ocoeffs) {
                        RE res = concat(c, concat(oSelfStar, oterm));
                        // System.out.println("Result of concat" +
                        // res.toString());
                        addTerm(res);
                    }
                }

                for (Map.Entry<Nonterminal, Set<RE>> entry : other.coeffs.entrySet()) {
                    Nonterminal substVar = entry.getKey(); // The variable in
                                                           // the term being
                                                           // substituted.
                    Set<RE> substCoeffs = entry.getValue(); // The coefficients
                                                            // associated with
                                                            // substVar in the
                                                            // production being
                                                            // substituted
                    // Set<RE> ncs = getCoeff(substVar); // The coefficients
                    // associated with substVar in *this* production
                    for (RE c : ocoeffs) {
                        for (RE oc : substCoeffs) {
                            RE newRE = concat(c, concat(oSelfStar, oc));
                            addCoeff(substVar, newRE);
                        }
                    }
                }
            }

            // Now, remove ont from newCoeffs, since it's no longer needed.
            removeCoeff(ont);
        }

        /**
         * Apply Arden's lemma X -> AX + B => X -> A*B Or reversed, if grammar is right-generating.
         * 
         * Modifies this.
         */
        private void arden() {
            Set<RE> self = removeCoeff(nt);
            if (self == null || self.isEmpty()) {
                return;
            }
            RE selfStar = unionREs(self).star();

            // Concat selfStar onto each coefficient.
            Map<Nonterminal, Set<RE>> oldCoeffs = coeffs;
            coeffs = new HashMap<Nonterminal, Set<RE>>();
            for (Map.Entry<Nonterminal, Set<RE>> entry : oldCoeffs.entrySet()) {
                Nonterminal var = entry.getKey();
                Set<RE> cs = entry.getValue();
                for (RE c : cs) {
                    addCoeff(var, concat(selfStar, c));
                }
            }

            // Concat selfStar onto each terminal
            Set<RE> oldTerms = terms;
            terms = new HashSet<RE>();
            for (RE t : oldTerms) {
                RE nxt = concat(selfStar, t);
                addTerm(nxt);
            }

        }

        /**
         * Extract the regular expression associated with this recursive production. Fails if there
         * are references to other productions in coeffs.
         * 
         * @return
         */
        public RE extractRE() {
            arden();
            if (!coeffs.isEmpty()) {
                throw new RuntimeException("production still has free variables");
            }
            return unionREs(terms);
        }

        /**
         * Process an automaton production.
         * 
         * @see dk.brics.string.grammar.ProductionVisitor#visitAutomatonProduction
         *      (dk.brics.string.grammar.Nonterminal, dk.brics.string.grammar.AutomatonProduction)
         **/
        public void visitAutomatonProduction(Nonterminal a, AutomatonProduction p) {
            // Automata productions should be added to the set of terminals for
            // this
            // nonterminal.
            Automaton automaton = p.getAutomaton();
            RE newRE = AutomataUtil.convertAutomata(automaton);
            newRE.meta = (String) automaton.getInfo();
            addTerm(newRE);
        }

        /**
         * Process a epsilon production.
         * 
         * @see dk.brics.string.grammar.ProductionVisitor#
         *      visitEpsilonProduction(dk.brics.string.grammar.Nonterminal,
         *      dk.brics.string.grammar.EpsilonProduction)
         **/
        public void visitEpsilonProduction(Nonterminal a, EpsilonProduction p) {
            // Epsilon productions should be added to the set of terminals for
            // this
            // nonterminal.
            addTerm(RE.empty);
        }

        /**
         * Add the argument regular expression to the set of terminal right-hand-sides.
         * 
         * @param tm
         */
        private void addTerm(RE tm) {
            terms.addAll(tm.getAlts());
        }

        /**
         * Visit a pair (concatenation of nonterminal) production.
         * 
         * @see dk.brics.string.grammar.ProductionVisitor# visitPairProduction(dk.
         *      brics.string.grammar.Nonterminal, dk.brics.string.grammar.PairProduction)
         **/
        public void visitPairProduction(Nonterminal a, PairProduction p) {

            Nonterminal left = p.getNonterminal1();
            Nonterminal right = p.getNonterminal2();

            boolean rleft = isRecursive(left);
            boolean rright = isRecursive(right);
            RE leftRE, rightRE;
            if (rleft) {
                rightRE = getRE(right);
                addCoeff(left, rightRE);
            } else if (rright) {
                leftRE = getRE(left);
                addCoeff(right, leftRE);
            } else {
                leftRE = getRE(left);
                rightRE = getRE(right);
                addTerm(leftRE.concat(rightRE));
            }

        }

        /**
         * Visit a production with the RHS a single nonterminal.
         * 
         * @see dk.brics.string.grammar.ProductionVisitor#visitUnitProduction(dk.
         *      brics.string.grammar.Nonterminal, dk.brics.string.grammar.UnitProduction)
         **/
        public void visitUnitProduction(Nonterminal a, UnitProduction p) {
            // If A -> B, and B is a nonterminal in this component, then add
            // an epsilon production to the coefficients for B.
            // If A -> B and B is a nonterminal in another component, then
            // fetch the corresponding RE and add it to the set of terms.
            Nonterminal rhs = p.getNonterminal();
            if (isRecursive(rhs)) {
                addCoeff(rhs, RE.epsilon);
            } else {
                RE rhsRE = getRE(rhs);
                addTerm(rhsRE);
            }
        }

        /**
         * Visit a production where the RHS is a single nonterminal.
         * 
         * @see dk.brics.string.grammar.ProductionVisitor#visitUnaryProduction(dk
         *      .brics.string.grammar.Nonterminal, dk.brics.string.grammar.UnaryProduction)
         **/
        public void visitUnaryProduction(Nonterminal a, UnaryProduction p) {
            Nonterminal arg = p.getNonterminal();
            if (isRecursive(arg)) {
                throw new RuntimeException("Unary production is recursive!");
            }
            RE re1 = getRE(p.getNonterminal());

            RE cur = RE.mkUnOp(p.getOperation(), re1);
            addTerm(cur);

        }

        /**
         * Visit a production where the RHS is the application of a string operation.
         * 
         * @see dk.brics.string.grammar.ProductionVisitor#
         *      visitBinaryProduction(dk.brics.string.grammar.Nonterminal,
         *      dk.brics.string.grammar.BinaryProduction)
         */
        public void visitBinaryProduction(Nonterminal a, BinaryProduction p) {
            Nonterminal arg1 = p.getNonterminal1();
            Nonterminal arg2 = p.getNonterminal2();

            if (isRecursive(arg1)) {
                throw new RuntimeException("Binary production arg1 is recursive!");
            }

            if (isRecursive(arg2)) {
                throw new RuntimeException("Binary production arg2 is recursive!");
            }

            RE re1 = getRE(arg1);
            RE re2 = getRE(arg2);
            RE cur = RE.mkBinOp(p.getOperation(), re1, re2);
            addTerm(cur);
        }

        /**
         * Return true if the nonterminal is recursive.
         * 
         * @param nt
         * @return
         */
        private boolean isRecursive(Nonterminal nonterm) {
            return comp.getNodes().contains(nonterm);
        }

    }

    /**
     * A ProductionVisitor for productions that are non-recursive.
     * 
     * @author garrinkimmell
     * 
     */
    private final class NonrecursiveProduction implements ProductionVisitor {
        @Override
        public void visitAutomatonProduction(Nonterminal a, AutomatonProduction p) {
            RE newRE = AutomataUtil.convertAutomata(p.getAutomaton());
            newRE.meta = (String) p.getAutomaton().getInfo();
            // System.out.println("Regex is " + newRE.toString(true));
            // System.out.println("Meta is " + newRE.meta);
            unionRE(a, newRE);
        }

        @Override
        public void visitEpsilonProduction(Nonterminal a, EpsilonProduction p) {
            unionRE(a, RE.epsilon);
        }

        @Override
        public void visitPairProduction(Nonterminal a, PairProduction p) {
            AutomataUtil.RE re1 = getRE(p.getNonterminal1());
            AutomataUtil.RE re2 = getRE(p.getNonterminal2());
            unionRE(a, re1.concat(re2));
        }

        @Override
        public void visitBinaryProduction(Nonterminal a, BinaryProduction p) {
            Nonterminal arg1 = p.getNonterminal1();
            Nonterminal arg2 = p.getNonterminal2();
            RE re1 = getRE(arg1);
            RE re2 = getRE(arg2);

            RE cur = RE.mkBinOp(p.getOperation(), re1, re2);
            unionRE(a, cur);
        }

        @Override
        public void visitUnaryProduction(Nonterminal a, UnaryProduction p) {
            RE re1 = getRE(p.getNonterminal());
            RE cur = RE.mkUnOp(p.getOperation(), re1);
            unionRE(a, cur);
        }

        @Override
        public void visitUnitProduction(Nonterminal a, UnitProduction p) {
            AutomataUtil.RE re = getRE(p.getNonterminal());
            unionRE(a, re);
        }
    }

    /**
     * Given a strongly-connected component, representing nonterminals that are mutually recursive,
     * iteratively substitute and simplify to generate regular expressions for each nonterminal in
     * the SCC.
     * 
     * @param c The strongly connected component, representing a set of nonterminals.
     */
    private void solve(final Component c) {

        Map<Nonterminal, RecursiveProduction> equations =
                new HashMap<Nonterminal, RecursiveProduction>();

        Map<Nonterminal, RecursiveProduction> scratch =
                new HashMap<Nonterminal, RecursiveProduction>();

        for (Nonterminal nt : c.getNodes()) {
            equations.put(nt, new RecursiveProduction(nt));
            RecursiveProduction v = new RecursiveProduction(nt);
            scratch.put(nt, v);
        }

        // System.out.println("Solving Equations");
        // for (Map.Entry<Nonterminal, RecursiveProduction> e : scratch.entrySet()) {
        // System.out.println(e.getValue().toString());
        // }

        List<Nonterminal> todo = new LinkedList<Nonterminal>(c.getNodes());
        List<Nonterminal> odot = new LinkedList<Nonterminal>();
        while (!todo.isEmpty()) {
            RecursiveProduction from = scratch.get(todo.remove(0));
            odot.add(0, from.nt);

            for (Nonterminal into : todo) {
                RecursiveProduction nextInto = scratch.get(into).substitute(from);
                scratch.put(into, nextInto);
            }

        }

        // Back-substitute equations.
        while (!odot.isEmpty()) {
            RecursiveProduction from = scratch.get(odot.remove(0));
            from.arden();
            // System.out.println(from.toString());

            for (Nonterminal into : odot) {
                RecursiveProduction nextInto = scratch.get(into).substitute(from);
                scratch.put(into, nextInto);
                // System.out.println(nextInto.toString());
            }
        }

        // Generate and save the regular expressions
        for (Map.Entry<Nonterminal, RecursiveProduction> e : scratch.entrySet()) {
            setRE(e.getKey(), e.getValue().extractRE());
        }
    }

    /**
     * Combines a set of regular expressions into a single regular expression.
     * 
     * @param coll
     * @return RE representing the union of all regular expression in <code>coll</code>.
     *         <code>RE.empty</code> if <code>coll.isEmpty()</code>.
     */
    private RE unionREs(Set<RE> coll) {
        if (coll.isEmpty()) {
            return RE.empty;
        }

        RE acc = RE.empty;
        for (RE re : coll) {
            acc = acc.union(re);
        }
        return acc;
    }

    /**
     * Get the regular expression representing the language generated by the given nonterminal.
     * 
     * @param nt
     * @return
     */
    public RE getRE(Nonterminal nt) {
        AutomataUtil.RE re = reMap.get(nt);
        if (re == null) {
            Component c = comps.getComponent(nt);
            Recursion rec = c.getRecursion();

            if (rec == Recursion.BOTH) {
                throw new RuntimeException("grammar is not strongly regular");
            } else if (rec == Recursion.LEFT || rec == Recursion.RIGHT) {
                solve(c);
            } else { // rec == Recursion.NONE
                reMap.put(nt, AutomataUtil.RE.empty);
                for (Production p : nt.getProductions()) {
                    p.visitBy(nt, new NonrecursiveProduction());
                }
            }
            return getRE(nt);
        } else {
            return re;
        }
    }

    /**
     * Set the regular expression associated with the given nonterminal.
     * 
     * @param nt
     * @param re
     */
    private void setRE(Nonterminal nt, RE re) {
        reMap.put(nt, re);
    }

    /**
     * Union the parameter regular expression with the existing regular expression mapped to the
     * parameter nonterminal.
     * 
     * @param nt
     * @param re
     */
    private void unionRE(Nonterminal nt, RE re) {
        RE old = getRE(nt);
        setRE(nt, old.union(re));
    }

    /**
     * Convert to string.
     * 
     * @see java.lang.Object#toString()
     **/
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Nonterminal v : g.getNonterminals()) {
            AutomataUtil.RE cur = getRE(v);
            if (cur != null) {
                s.append(v).append(" -> ").append(cur.toString()).append("\n");
            } else {
                for (Production p : v.getProductions()) {
                    s.append(v).append(" -> ").append(p);
                    s.append(p.getClass().getSimpleName()).append("\n");
                }
            }
        }
        return s.toString();
    }

}
