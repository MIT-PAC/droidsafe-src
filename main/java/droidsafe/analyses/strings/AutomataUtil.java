package droidsafe.analyses.strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.Transition;
import dk.brics.string.stringoperations.AssertContainedInOther;
import dk.brics.string.stringoperations.AssertContainsOther;
import dk.brics.string.stringoperations.AssertEmpty;
import dk.brics.string.stringoperations.AssertEndsWith;
import dk.brics.string.stringoperations.AssertEquals;
import dk.brics.string.stringoperations.AssertHasLength;
import dk.brics.string.stringoperations.AssertHasNotLength;
import dk.brics.string.stringoperations.AssertInLanguage;
import dk.brics.string.stringoperations.AssertNotContainsOther;
import dk.brics.string.stringoperations.AssertNotEmpty;
import dk.brics.string.stringoperations.AssertNotEquals;
import dk.brics.string.stringoperations.AssertPrefixOf;
import dk.brics.string.stringoperations.AssertStartsWith;
import dk.brics.string.stringoperations.AssertSuffixOf;
import dk.brics.string.stringoperations.Basic;
import dk.brics.string.stringoperations.BinaryOperation;
import dk.brics.string.stringoperations.BooleanToString;
import dk.brics.string.stringoperations.CharAt1;
import dk.brics.string.stringoperations.CharAt2;
import dk.brics.string.stringoperations.Contains;
import dk.brics.string.stringoperations.Delete;
import dk.brics.string.stringoperations.DeleteCharAt;
import dk.brics.string.stringoperations.Insert;
import dk.brics.string.stringoperations.Operation;
import dk.brics.string.stringoperations.Postfix;
import dk.brics.string.stringoperations.Postfix2;
import dk.brics.string.stringoperations.Prefix;
import dk.brics.string.stringoperations.Replace1;
import dk.brics.string.stringoperations.Replace2;
import dk.brics.string.stringoperations.Replace3;
import dk.brics.string.stringoperations.Replace4;
import dk.brics.string.stringoperations.Replace5;
import dk.brics.string.stringoperations.Replace6;
import dk.brics.string.stringoperations.Reverse;
import dk.brics.string.stringoperations.SetCharAt1;
import dk.brics.string.stringoperations.SetCharAt2;
import dk.brics.string.stringoperations.SetLength;
import dk.brics.string.stringoperations.Split;
import dk.brics.string.stringoperations.Substring;
import dk.brics.string.stringoperations.Substring2;
import dk.brics.string.stringoperations.ToLowerCase;
import dk.brics.string.stringoperations.ToUpperCase;
import dk.brics.string.stringoperations.Trim;
import dk.brics.string.stringoperations.UnaryOperation;

/*
 * 
 * A Utility Class, used for converting automata into regular expressions.
 */
/**
 * @author garrinkimmell
 * 
 */
public class AutomataUtil {

    /** The logger for the class. **/
    static Logger logger = LoggerFactory.getLogger(AutomataUtil.class);


    /**
     * Convert the given automaton to a regular expression.
     * 
     * @param a
     * @return
     */
    public static RE convertAutomata(Automaton a) {
        return RE.brzozowski(a);
    }

    /**
     * @author garrinkimmell
     * 
     *         Regular Expression Operations
     */
    private static enum ReOp {
        /** The empty string **/
        EPSILON(11),
        /** The empty language **/
        EMPTY(11),
        /** Union of (many) REs **/
        UNION(3),
        /** Kleene closure of a RE. **/
        STAR(9),
        /** Concatenation of (many) REs **/
        CONCAT(5),
        /** A single character within a range **/
        RANGE(11),
        /** A constant string **/
        STRING(11),
        /** One-or-more of an argument RE **/
        PLUS(9),
        /** Zero-or-one of an argument RE **/
        OPTION(9),
        /** A unary operation on a regular expression. **/
        UNOP(12),
        /** A binary operation on a regular expression. **/
        BINOP(12);

        /**
         * For printing, we associate a precedence with each ReOp.
         */
        private int m_prec;

        /**
         * Constructor.
         * 
         * @param prec
         */
        ReOp(int prec) {
            this.m_prec = prec;
        }

        /**
         * Get the precedence field.
         * 
         * @return
         */
        int getPrec() {
            return m_prec;
        }

    };

    /** The representation of regular expressions. **/
    public static class RE {

        /** The operation **/
        public ReOp op;

        /** low and high characters in a range **/
        public char low, high;

        /** The literal, if a singleton string. **/
        public String lit;

        /** For Star, Plus, and Option, we keep a single argument. **/
        public RE unaryArg;

        /** For union, we keep a set of alternatives. **/
        public Set<RE> alts;

        /**
         * For concat, we keep a list of regular expressions to concat. For regexs representing
         * string operations, cats contains the argument(s) to the operation.
         **/
        public List<RE> cats;

        /** For string operations, we store the operation from the JSA. **/
        public Operation strOp;

        /**
         * For regular expressions generated by JSA as meta-regexes (like <float>), store the
         * meta-regex name.
         **/
        public String meta;


        /** The singleton empty string. **/
        public static final RE epsilon = new RE(ReOp.EPSILON);
        /** The empty language. **/
        public static final RE empty = new RE(ReOp.EMPTY);
        
        public RE anyString() {
            RE res = mkRange('\u0000','\uffff');
            res =  res.star();
            res.meta = "<any string>";
            return res;
        }
        
        
        public boolean isAnyString() {
            return "<any string>".equals(meta);
        }

        public boolean isLiteral() {
            return (op == ReOp.STRING);
        }
        
        public boolean isConcat() {
            return (op == ReOp.CONCAT); 
        }
        
        public boolean isUnion() {
            return (op == ReOp.UNION); 
        }
        
        /** Constructor. **/
        public RE(ReOp argOp) {
            this.op = argOp;
            low = '0';
            high = '0';
            lit = null;
            unaryArg = null;
            cats = null;
            alts = null;
            strOp = null;
            meta = null;
        }

        public RE(RE other) {
            this.op = other.op;
            this.low = other.low;
            this.high = other.high;
            this.lit = other.lit;
            this.unaryArg = other.unaryArg;
            this.alts = other.alts;
            this.cats = other.cats;
            this.strOp = other.strOp;
            this.meta = other.meta;
        }

        /**
         * RE equality.
         * 
         * @param x
         * @return
         */
        public boolean equals(RE x) {

            if (this == x) {
                return true;
            }

            if (x == null) {
                return false;
            }

            if (op != x.op) {
                return false;
            }

            if (low != x.low) {
                return false;
            }

            if (high != x.high) {
                return false;
            }

            if (lit == null && x.lit != null) {
                return false;
            }

            if (lit != null && !lit.equals(x.lit)) {
                return false;
            }

            if (unaryArg == null && x.unaryArg != null) {
                return false;
            }

            if (unaryArg != null && !unaryArg.equals(x.unaryArg)) {
                return false;
            }

            if (cats == null && x.cats != null) {
                return false;
            }

            if (cats != null && !cats.equals(x.cats)) {
                return false;
            }

            if (alts == null && x.alts != null) {
                return false;
            }

            if (alts != null && !alts.equals(x.alts)) {
                return false;
            }

            if (meta == null && x.meta != null) {
                return false;
            }

            if (meta != null && !meta.equals(x.meta)) {
                return false;
            }

            if (strOp == null && x.strOp != null) {
                return false;
            }

            if (strOp != null && !strOp.equals(x.strOp)) {
                return false;
            }

            return true;
        }

        /**
         * Return the hashcode for this regular expression.
         * 
         * @see java.lang.Object#hashCode()
         */
        public int hashCode() {
            int acc = 0;
            int c = 0;

            c = op.ordinal();
            acc = acc * 37 + c;

            c = low;
            acc = acc * 37 + c;

            c = high;
            acc = acc * 37 + c;

            if (lit == null) {
                acc *= 37;
            } else {
                acc = acc * 37 + lit.hashCode();
            }

            if (unaryArg == null) {
                acc *= 37;
            } else {
                acc = acc * 37 + unaryArg.hashCode();
            }

            if (cats == null) {
                acc *= 37;
            } else {
                acc = acc * 37 + cats.hashCode();
            }

            if (alts == null) {
                acc *= 37;
            } else {
                acc = acc * 37 + alts.hashCode();
            }

            if (strOp == null) {
                acc *= 37;
            } else {
                acc = acc * 37 + strOp.hashCode();
            }

            return acc;
        }

        /**
         * Construct a regular expression matching a single character.
         * 
         * @param c The character to match.
         * @return
         */
        public static RE mkChar(char c) {
            return mkString(Character.toString(c));
        }

        /**
         * Construct a regular expression matching the union of the languages matched by the
         * argument regular expressions.
         * 
         * @param x
         * @param y
         * @return
         */
        public static RE mkUnion(RE x, RE y) {
            if (x.op.equals(ReOp.EMPTY)) {
                return y;
            }
            if (y.op.equals(ReOp.EMPTY)) {
                return x;
            }
            
            RE res = new RE(ReOp.UNION);
            res.alts = new HashSet<RE>();
            if (x.meta != null) {
                res.alts.add(x);
            } else {
                res.alts.addAll(x.getAlts());
            }
            if (y.meta != null) {
                res.alts.add(y);
            } else {
                res.alts.addAll(y.getAlts());
            }

            if (res.alts.size() == 0) {
                return empty;
            } else if (res.alts.size() == 1) {
                for (RE e : res.alts) {
                    return e;
                }
            }
            return res;
        }

        /**
         * Construct a regular expression matching the Kleene closure of the language matched by the
         * argument regular expression.
         * 
         * @param x
         * @return
         */
        public static RE mkStar(RE x) {

            if (x.equals(epsilon) || x.equals(empty)) {
                return epsilon;
            }

            RE res = new RE(ReOp.STAR);
            res.unaryArg = x;
            return res;
        }

        /**
         * Construct a regular expression that matches the contatenation of one or more of the
         * argument regular expression.
         * 
         * @param x
         * @return
         */
        public static RE mkPlus(RE x) {

            if (x.equals(epsilon) || x.equals(empty)) {
                return epsilon;
            }

            RE res = new RE(ReOp.PLUS);
            res.unaryArg = x;
            return res;
        }

        /**
         * Construct a regular expression that matches the concatenation of the languages matched by
         * the two argument regular expressions.
         * 
         * @param x
         * @param y
         * @return
         */
        public static RE mkConcat(RE x, RE y) {

            if (x.op == ReOp.STRING && y.op == ReOp.STRING) {
                // logger.debug("ConcatStrings");
                return mkString(x.lit + y.lit);
            } else if (x.equals(empty) || y.equals(empty)) {
                return empty;
            } else if (y.equals(epsilon)) {
                return x;
            } else if (x.equals(epsilon)) {
                return y;
            } else if (x.op == ReOp.CONCAT && y.op == ReOp.CONCAT && x.meta == null
                    && y.meta == null) {
                RE res = new RE(ReOp.CONCAT);
                res.cats = new LinkedList<RE>();
                res.cats.addAll(x.cats);
                res.cats.addAll(y.cats);
                return res;
            } else if (x.op == ReOp.CONCAT && x.meta == null) {
                RE res = new RE(ReOp.CONCAT);
                res.cats = new LinkedList<RE>();
                res.cats.addAll(x.cats);
                res.cats.add(y);
                return res;
            } else if (y.op == ReOp.CONCAT && y.meta == null) {
                RE res = new RE(ReOp.CONCAT);
                res.cats = new LinkedList<RE>();
                res.cats.addAll(y.cats);
                res.cats.add(0, x);
                return res;
            } else {
                RE res = new RE(ReOp.CONCAT);
                res.cats = new LinkedList<RE>();
                res.cats.add(x);
                res.cats.add(y);
                return res;
            }

        }

        /**
         * Construct a regular expression that matches a language that is the image of the binary
         * op, applied to the two argument regular expression languages.
         * 
         * @param o The operation to apply
         * @param arg1
         * @param arg2
         * @return
         */
        public static RE mkBinOp(BinaryOperation o, RE arg1, RE arg2) {
            RE res = new RE(ReOp.BINOP);
            res.strOp = o;
            res.cats = new LinkedList<RE>();
            res.cats.add(arg1);
            res.cats.add(arg2);
            return res;
        }

        /**
         * Construct a regular expression that matches a language that is the image of the unary op,
         * applied to the argument regular expression language.
         */
        public static RE mkUnOp(UnaryOperation o, RE arg1) {
            RE res = new RE(ReOp.UNOP);
            res.strOp = o;
            res.cats = new LinkedList<RE>();
            res.cats.add(arg1);
            return res;
        }

        /**
         * Construct a regular expression that matches the single character that lies within the
         * (inclusive) range of the two argument characters.
         * 
         * @param low
         * @param high
         * @return
         */
        public static RE mkRange(char low, char high) {
            if (low == high) {
                return mkChar(low);
            }

            RE res = new RE(ReOp.RANGE);
            res.low = low;
            res.high = high;
            return res;
        }

        /**
         * Construct a regular expression that matches the input string.
         * 
         * @param lit
         * @return
         */
        public static RE mkString(String lit) {
            if (lit.isEmpty()) {
                return epsilon;
            }

            RE res = new RE(ReOp.STRING);
            res.lit = lit;
            return res;
        }

        /**
         * Construct a regular expression that matches zero or one occurence of the language matched
         * by the input regular expression.
         * 
         * @param arg
         * @return
         */
        public static RE mkOption(RE arg) {
            if (arg == empty) {
                return empty;
            }

            if (arg.op == ReOp.STAR) {
                return arg;
            }

            if (arg.op == ReOp.PLUS) {
                return mkStar(arg.unaryArg);
            }

            RE res = new RE(ReOp.OPTION);
            res.unaryArg = arg;
            return res;
        }

        /**
         * Convert to printable string.
         * 
         * @see java.lang.Object#toString()
         */
        public String toString() {
            return toString(false);
        }

        /**
         * Convert a RE to a string.
         * 
         * @param expand If this is true, then expand all meta-regexs. Otherwise, just print their
         *        meta representation.
         * @return
         */
        public String toString(boolean expand) {
            StringBuilder acc = new StringBuilder();
            toString(acc, 0, expand);
            return acc.toString();
        }

        /**
         * Convert a RE to a string, accumulating result in acc.
         * 
         * @param acc The accumulating string.
         * @param expand If this is true, then expand all meta-regexs. Otherwise, just print their
         *        meta representation.
         * @return
         */
        private void toString(StringBuilder acc, boolean expand) {
            if (this.meta != null && !expand) {
                acc.append(this.meta);
                return;
            }

            switch (this.op) {
                case EMPTY:
                    acc.append("<empty>");
                    return;
                case EPSILON:
                    acc.append("<epsilon>");
                    return;
                case RANGE:
                    if (this.low == '\u0000' && this.high == '\uffff') {
                        acc.append(".");
                        return;
                    } else {
                        acc.append('[');
                        acc.append(this.low);
                        acc.append('-');
                        acc.append(this.high);
                        acc.append(']');
                        return;
                    }
                    // case CHAR:
                    // acc.append(this.low);
                    // return;
                case STRING:
                    if (this.lit.equals("")) {
                        epsilon.toString(acc, expand);
                    } else {
                        acc.append(this.lit);
                        return;
                    }
                case UNION:
                    String sep = "";
                    for (RE r : alts) {
                        acc.append(sep);
                        r.toString(acc, op.getPrec(), expand);
                        sep = "|";
                    }
                    return;
                case STAR:
                    unaryArg.toString(acc, op.getPrec(), expand);
                    acc.append("*");
                    return;
                case PLUS:
                    unaryArg.toString(acc, op.getPrec(), expand);
                    acc.append("+");
                    return;
                case OPTION:
                    unaryArg.toString(acc, op.getPrec(), expand);
                    acc.append("?");
                    return;

                case CONCAT:
                    for (RE r : cats) {
                        r.toString(acc, op.getPrec(), expand);
                    }
                    return;

                case BINOP:
                case UNOP:
                    acc.append(strOp.toString());
                    acc.append("[");
                    sep = "";
                    for (RE arg : cats) {
                        acc.append(sep);
                        arg.toString(acc, op.getPrec(), expand);
                        sep = ",";
                    }
                    acc.append("]");
                    return;
                default:
                    acc.append("<unknown>");
                    return;
            }
        }

        /**
         * This handles adding parens, as necessary.
         * 
         * @param acc
         * @param prec
         * @param expand
         */
        private void toString(StringBuilder acc, int prec, boolean expand) {
            if (this.meta != null && !expand) {
                acc.append(this.meta);
                return;
            }
            boolean paren = op.getPrec() < prec;
            if (paren) acc.append('(');
            toString(acc, expand);
            if (paren) acc.append(')');
        }

        /**
         * Union the parameter regular expression with this regular expression.
         * 
         * @param y
         * @return
         */
        public RE union(RE y) {
            return mkUnion(this, y);
        }

        /**
         * Concatenate the parameter regular expression with this regular expression.
         * 
         * @param y
         * @return
         */
        public RE concat(RE y) {
            return mkConcat(this, y);
        }

        /**
         * Construct the Kleene closure of this regular expression.
         * 
         * @param y
         * @return
         */
        public RE star() {
            return mkStar(this);
        }

        /**
         * Convert this regular expression into an automaton.
         * 
         * @return
         */
        public Automaton toAutomaton() {
            Automaton arg;
            switch (this.op) {
                case EMPTY:
                    return Automaton.makeEmpty();
                case EPSILON:
                    return Automaton.makeEmptyString();
                case RANGE:
                    return Automaton.makeCharRange(low, high);
                case STRING:
                    return Automaton.makeString(lit);
                case STAR:
                    arg = unaryArg.toAutomaton();
                    return arg.repeat();
                case PLUS:
                    arg = unaryArg.toAutomaton();
                    return arg.repeat(1);
                case OPTION:
                    arg = unaryArg.toAutomaton();
                    return arg.optional();
                case UNION:
                    Set<Automaton> args = new HashSet<Automaton>();
                    for (RE a : alts) {
                        args.add(a.toAutomaton());
                    }
                    return Automaton.union(args);
                case CONCAT:
                    arg = Automaton.makeEmptyString();
                    for (RE a : cats) {
                        arg = arg.concatenate(a.toAutomaton());
                    }
                    return arg;
                case BINOP:
                    BinaryOperation bo = (BinaryOperation) strOp;
                    return bo.op(cats.get(0).toAutomaton(), cats.get(1).toAutomaton());
                case UNOP:
                    UnaryOperation uo = (UnaryOperation) strOp;
                    return uo.op(cats.get(0).toAutomaton());
                default:
                    return null;
            }
        }

        /**
         * For a regular expression that contains string operations, return a regular expression
         * that matches a language of the image of the operations, removing all string operation
         * nodes. This is conservative, and the result may match a superset of the language matched
         * by the original regular expression.
         * 
         * @return
         */
        public RE simplifyOps() {
            RE res;
            switch (this.op) {
                case EMPTY:
                case EPSILON:
                case RANGE:
                case STRING:
                    return this;
                case STAR:
                case PLUS:
                case OPTION:
                    res = new RE(this.op);
                    res.meta = meta;
                    res.unaryArg = unaryArg.simplifyOps();
                    return res;

                case UNION:
                    res = new RE(ReOp.UNION);
                    res.meta = meta;
                    res.alts = new HashSet<RE>();
                    for (RE arg : alts) {
                        res.alts.add(arg.simplifyOps());
                    }
                    return res;

                case CONCAT:
                    res = new RE(ReOp.CONCAT);
                    res.meta = meta;
                    res.cats = new LinkedList<RE>();
                    for (RE arg : cats) {
                        res.cats.add(arg.simplifyOps());
                    }
                    return res;

                case BINOP:
                case UNOP:
                    res = new RE(this);
                    res.cats = new LinkedList<RE>();
                    for (RE arg : cats) {
                        res.cats.add(arg.simplifyOps());
                    }                    
                    return res.interpretOp();
                default:
                    return this;
            }
        }

        // FIXME: This should work at the level of REGEXes, rather than on
        // automaton.
        /**
         * For regular expressions with string operations, this method should dispatch to the proper
         * handling of the operation over regular expressions.
         * 
         * If there is no definition of the operation on regular expressions, the method will
         * default to converting the regular expression to an automaton, applying the op to get a
         * new automaton, then converting that back to a regular expression.
         * 
         * @return
         */
        private RE interpretOp() {
            RE out = null;
            if (strOp instanceof AssertContainedInOther) {
                out = assertContainedInOther();
            } else if (strOp instanceof AssertContainsOther) {
                out = assertContainsOther();
            } else if (strOp instanceof AssertEmpty) {
                out = assertEmpty();
            } else if (strOp instanceof AssertEndsWith) {
                out = assertEndsWith();
            } else if (strOp instanceof AssertEquals) {
                out = assertEquals();
            } else if (strOp instanceof AssertHasLength) {
                out = assertHasLength();
            } else if (strOp instanceof AssertHasNotLength) {
                out = assertHasNotLength();
            } else if (strOp instanceof AssertInLanguage) {
                out = assertInLanguage();
            } else if (strOp instanceof AssertNotContainsOther) {
                out = assertNotContainsOther();
            } else if (strOp instanceof AssertNotEmpty) {
                out = assertNotEmpty();
            } else if (strOp instanceof AssertNotEquals) {
                out = assertNotEquals();
            } else if (strOp instanceof AssertPrefixOf) {
                out = assertPrefixOf();
            } else if (strOp instanceof AssertStartsWith) {
                out = assertStartsWith();
            } else if (strOp instanceof AssertSuffixOf) {
                out = assertSuffixOf();
            } else if (strOp instanceof BooleanToString) {
                out = booleanToString();
            } else if (strOp instanceof CharAt1) {
                out = charAt1();
            } else if (strOp instanceof CharAt2) {
                out = charAt2();
            } else if (strOp instanceof Contains) {
                out = contains();
            } else if (strOp instanceof Delete) {
                out = delete();
            } else if (strOp instanceof DeleteCharAt) {
                out = deleteCharAt();
            } else if (strOp instanceof Insert) {
                out = insert();
            } else if (strOp instanceof Postfix) {
                out = postfix();
            } else if (strOp instanceof Postfix2) {
                out = postfix2();                
            } else if (strOp instanceof Prefix) {
                out = prefix();
            } else if (strOp instanceof Replace1) {
                out = replace1();
            } else if (strOp instanceof Replace2) {
                out = replace2();
            } else if (strOp instanceof Replace3) {
                out = replace3();
            } else if (strOp instanceof Replace4) {
                out = replace4();
            } else if (strOp instanceof Replace5) {
                out = replace5();
            } else if (strOp instanceof Replace6) {
                out = replace6();
            } else if (strOp instanceof Reverse) {
                out = reverse();
            } else if (strOp instanceof SetCharAt1) {
                out = setCharAt2();
            } else if (strOp instanceof SetCharAt2) {
                out = setCharAt2();
            } else if (strOp instanceof SetLength) {
                out = setLength();
            } else if (strOp instanceof Split) {
                out = split();
            } else if (strOp instanceof Substring) {
                out = substring();
            } else if (strOp instanceof Substring2) {
                out = substring2();                
            } else if (strOp instanceof ToLowerCase) {
                out = toLowerCase();
            } else if (strOp instanceof ToUpperCase) {
                out = toUpperCase();
            } else if (strOp instanceof Trim) {
                out = trim();
            } else if (strOp instanceof UnaryOperation) {
                // Dummy
            } else if (strOp instanceof BinaryOperation) {
                // DUMMY
            } else if (strOp instanceof Operation) {
                // DUMMY
            } 
            
            logger.debug(String.format("StringOperation: %s",strOp.getClass()));
            int i = 0;
            for (RE arg : cats) {
                logger.debug(String.format("StringOperation Arg %s: %s", i, arg));
                i++;
            }
            if (out != null) {
                logger.debug(String.format("StringOperation simplified to %s", out));
                return out;
            } else {
                logger.debug("StringOperation no simplification.");
            }

            List<RE> args = new LinkedList<RE>();
            for (RE arg : cats) {
                args.add(arg.simplifyOps());
            }

            RE res = new RE(op);
            res.strOp = strOp;
            res.cats = args;

            Automaton auto = Automaton.makeEmpty();
            if (strOp instanceof UnaryOperation) {
                UnaryOperation o = (UnaryOperation) strOp;
                auto = o.op(args.get(0).toAutomaton());
            } else if (strOp instanceof BinaryOperation) {
                BinaryOperation o = (BinaryOperation) strOp;
                auto = o.op(args.get(0).toAutomaton(), args.get(1).toAutomaton());
            } else {
                throw new RuntimeException("Can't apply a string operation!");
            }
            return convertAutomata(auto);
        }



        private RE assertEquals() {
            RE arg1 = this.cats.get(0); // The inferred REGEX
            RE arg2 = this.cats.get(1); // The constrained REGEX

            
            if (arg1.equals(epsilon) && ! arg2.equals(epsilon)) {
                return empty;
            }
            
            if (arg1.op == ReOp.STAR && arg2.equals(epsilon)) {
                return epsilon;
            }
            
            if (arg1.op == ReOp.STRING && arg2.op == ReOp.STRING) {
                if (arg1.lit.equals(arg2.lit)) {
                    return arg1;
                } else {
                    return empty;
                }
            }
            
            if (arg1.op == ReOp.UNION) {
                RE acc = empty;
                for (RE a : arg1.alts) {
                    RE tmp = new RE(ReOp.BINOP);
                    tmp.strOp = this.strOp;
                    tmp.cats = new LinkedList<RE>();
                    tmp.cats.add(a);
                    tmp.cats.add(arg2);
                    RE res = tmp.interpretOp();
                    if (res == null) {
                        return null;
                    }   
                    acc = acc.union(tmp.interpretOp());
                }
                return acc;
            }
            
            if (arg1.isAnyString()) {
                return arg2;
            }
                
            return null;
        }

        private RE contains() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE charAt2() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE charAt1() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE booleanToString() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE assertInLanguage() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE assertHasNotLength() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE assertHasLength() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE assertEndsWith() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE assertContainsOther() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE assertContainedInOther() {
            return null;
        }

        private RE assertEmpty() {
            // FIXME:
            // The op definition in JSA intersects the argument with the empty string, 
            // which isn't the same thing, because if the argument does not 
            // accept the empty string, then the empty language will be returned.
            return RE.epsilon;
        }

        private RE assertSuffixOf() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE assertStartsWith() {
            RE arg1 = this.cats.get(0); // The inferred REGEX
            RE arg2 = this.cats.get(1); // The constrained REGEX


            if (arg1.equals(empty)) {
                return empty;
            }
            
            if (arg2.equals(epsilon)) {
                return arg1;
            }
            
            if (arg1.equals(epsilon)) {
                return empty;
            }

            if (arg1.isAnyString() && arg2.isLiteral()) {
                return arg2.concat(anyString());
            }
            
            if (arg1.op == ReOp.UNION) {
                RE acc = empty;
                for (RE a : arg1.alts) {
                    RE tmp = new RE(ReOp.BINOP);
                    tmp.strOp = this.strOp;
                    tmp.cats = new LinkedList<RE>();
                    tmp.cats.add(a);
                    tmp.cats.add(arg2);
                    RE res = tmp.interpretOp();
                    if (res == null) {
                        return null;
                    }   
                    acc = acc.union(tmp.interpretOp());
                }
                return acc;
            }            
            return null;
        }

        private RE assertPrefixOf() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE assertNotEquals() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE assertNotEmpty() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE assertNotContainsOther() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE delete() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE deleteCharAt() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE insert() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE postfix() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE prefix() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE replace1() {
            char c = ((Replace1)strOp).getC();
            char d =  ((Replace1)strOp).getD();
            // TODO Auto-generated method stub
            RE arg1 = cats.get(0);
            if (arg1.equals(empty)) {
                return empty;
            }
            
            if (arg1.equals(epsilon)) {
                return epsilon;
            }
            
            if (arg1.isLiteral()) {
                RE ret = new RE(this);
                ret.lit = this.lit.replace(c, d);
            }
            
            if (arg1.isConcat()) {
                RE ret = epsilon;
                for (RE a : arg1.cats){
                    RE tmp = new RE(this);
                    tmp.cats = new LinkedList<RE>();
                    tmp.cats.add(a);
                    RE r = tmp.interpretOp();
                    if (r == null) {
                        return null;
                    }
                    ret = ret.concat(r);
                }
                return ret;

            }
            
            if (arg1.isUnion()) {
                RE ret = empty;
                for (RE a : arg1.alts){
                    RE tmp = new RE(this);
                    tmp.cats = new LinkedList<RE>();
                    tmp.cats.add(a);
                    RE r = tmp.interpretOp();
                    if (r == null) {
                        return null;
                    }
                    ret = ret.union(r);
                }
                return ret;

            }
            
            
            return null;
        }

        private RE replace2() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE replace3() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE replace5() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE replace4() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE replace6() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE reverse() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE setCharAt2() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE setLength() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE split() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE substring() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE toLowerCase() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE toUpperCase() {
            // TODO Auto-generated method stub
            return null;
        }

        private RE trim() {
            // TODO Auto-generated method stub
            return null;
        }

        /**
         * Take the tail of a regular expression.
         **/
        private RE postfix2() {
            Postfix2 o = (Postfix2) strOp;
            int start = o.getStart();
            RE arg = cats.get(0);
            switch (arg.op) {
                case STRING:
                    if (arg.lit.length() > start) {
                        return mkString(arg.lit.substring(start));
                    } else {
                        return null;
                    }

                case CONCAT:
                    List<RE> tail = new LinkedList<RE>();
                    tail.addAll(arg.cats);
                    while (!tail.isEmpty()) {
                        RE a = tail.remove(0);
                        if (a.op == ReOp.STRING) {
                            int len = a.lit.length();
                            if (len >= start) {
                                RE s = mkString(a.lit.substring(start));
                                tail.add(0, s);
                                RE res = new RE(ReOp.CONCAT);
                                res.cats = tail;
                                return res;
                            } else {
                                start -= len;
                            }
                        }
                        return null;
                    }
                    return null;
                default:
                    return null;

            }

        }

        /**
         * The substring operation, applied to regular expressions.
         * 
         * @return
         */
        private RE substring2() {
            Substring2 o = (Substring2) strOp;
            int start = o.getStart();
            int end = o.getEnd();
            RE arg = cats.get(0);
            switch (arg.op) {
                case STRING:
                    if (arg.lit.length() > end) {
                        return mkString(arg.lit.substring(start, end));
                    } else {
                        return null;
                    }

                case CONCAT:
                    for (RE a : arg.cats) {
                        // System.out.println("Checking arg " + arg.toString());
                        if (a.op == ReOp.STRING) {
                            int len = a.lit.length();
                            if (len >= end) {
                                // System.out.println("Sucessful substring2: "
                                // + a.lit.substring(start, end));
                                return mkString(a.lit.substring(start, end));
                            } else {
                                // System.out.println("Skipping to next arg");
                                start -= len;
                                end -= len;
                            }
                        } else {
                            return null;
                        }
                    }

                default:
                    return null;
            }

        }

        /**
         *  Converting a DFA to a Regular Expression. 
         *  Translation of code from: 
         * http://cs.stackexchange.com/questions/2016/ \ 
         *    how-to-convert-finite-automata-to-regular-expressions 
         *  http://codepad.org/dbFztCCM
         **/
        private static RE brzozowski(Automaton fsm) {

            logger.debug("Brzozowski");

            // Check the case of a singleton string.
            String singleton = fsm.getSingleton();
            if (singleton != null) {
                // logger.debug("Singleton String");
                return mkString(singleton);
            }

            if (fsm.isEmpty()) {
                logger.debug("Empty language");
            }

            if (fsm.getAcceptStates().size() == 0) {
                logger.debug("No Accept States");
                return empty;
            }

            if (fsm.getNumberOfStates() > 5000) {
                logger.debug("Way too many states, so minimizing");
                fsm.minimize();
            }

            int m = fsm.getNumberOfStates();
            int idx = 0;
            logger.debug("Have " + m + " states");

            logger.debug("Allocating Arrays");
            RE[][] a = new RE[m][m];
            RE[] b = new RE[m];
            logger.debug("Done Allocating Arrays");

            // Give a state a name.
            Map<State, Integer> sm = new HashMap<State, Integer>();

            // Number the states; the initial state should be 0.
            State initial = fsm.getInitialState();

            Set<State> available = fsm.getLiveStates();
            logger.debug("Got Live States!");
            Set<State> done = new HashSet<State>();
            ArrayList<State> worklist = new ArrayList<State>();

            idx = 0;

            worklist.add(initial);

            while (!worklist.isEmpty()) {
                State cur = worklist.remove(0);
                // logger.debug("With state: " + cur.toString());
                if (!done.contains(cur)) {
                    // Note the numerical index of the state.
                    sm.put(cur, idx);
                    if (cur.isAccept()) {
                        b[idx] = epsilon;
                    } else {
                        b[idx] = empty;
                    }
                    done.add(cur);
                    idx++;

                    for (Transition t : cur.getTransitions()) {
                        State dest = t.getDest();
                        if (available.contains(dest) && (!done.contains(dest))) {
                            worklist.add(dest);
                        }
                    }
                }
            }

            // Init the table.
            for (State s : fsm.getStates()) {
                int i = sm.get(s);
                for (int j = 0; j < m; j++)
                    a[i][j] = empty;

                for (Transition t : s.getTransitions()) {
                    int j = sm.get(t.getDest());

                    RE e = RE.mkRange(t.getMin(), t.getMax());
                    a[i][j] = a[i][j].union(e);

                }
            }

            for (int n = m - 1; n >= 0; n--) {
                b[n] = a[n][n].star().concat(b[n]);

                for (int j = 0; j < n; j++) {
                    a[n][j] = a[n][n].star().concat(a[n][j]);
                }
                for (int i = 0; i < n; i++) {
                    b[i] = b[i].union(a[i][n].concat(b[n]));

                    for (int j = 0; j < n; j++) {
                        a[i][j] = a[i][j].union(a[i][n].concat(a[n][j]));
                    }
                }
                for (int i = 0; i < n; i++) {
                    a[i][n] = empty;
                }
            }

            RE res = b[sm.get(fsm.getInitialState())];

            return res;

        }

        /**
         * For a regular expression matching the union of several languages, get the top level
         * constituent regular expressions.
         * 
         * @return
         */
        public Collection<RE> getAlts() {
            if (op == ReOp.UNION) {
                return alts;
            }
            if (op == ReOp.EMPTY) {
                Collection<RE> set = new HashSet<RE>();
                return set;
            } else {
                Collection<RE> set = new HashSet<RE>();
                set.add(this);
                return set;
            }
        }
    }

}
