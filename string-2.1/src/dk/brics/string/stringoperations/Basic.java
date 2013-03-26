package dk.brics.string.stringoperations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.RegExp;
import dk.brics.automaton.State;
import dk.brics.automaton.StatePair;
import dk.brics.automaton.Transition;
import dk.brics.string.charset.CharSet;

/**
 * Basic automata.
 */
public class Basic {

    private static Automaton emptyString, noString, anyString,
            objectString, booleanString, characterString, doubleString,
            floatString, integerString, longString;
    private static CharSet emptyCharset;
    private static CharSet binaryBooleanCharset;
    private static Automaton binaryBooleanAutomaton;
    
    private static Automaton characterIsDigit;
    private static Automaton characterIsLetter;
    private static Automaton characterIsLetterOrDigit;
    private static Automaton characterIsLowerCase;
    private static Automaton characterIsSpaceChar;
    private static Automaton characterIsTitleCase;
    private static Automaton characterIsUpperCase;
    private static Automaton characterIsWhitespace;

    public static final char BINARY_TRUE = (char)1;
    public static final char BINARY_FALSE = (char)0;

    static {
        objectString = new RegExp("@\\@[0-9a-f]+").toAutomaton();
        emptyString = Automaton.makeEmptyString();
        emptyString.setInfo("\"\"");
        noString = Automaton.makeEmpty();
        noString.setInfo("<no string>");
        anyString = Automaton.makeAnyString();
        anyString.setInfo("<any string>");
        booleanString = Automaton.makeString("true").union(Automaton.makeString("false"));
        booleanString.setInfo("\"true\"|\"false\"");
        characterString = Automaton.makeAnyChar();
        characterString.setInfo("<char>");
        Automaton t0 = Automaton.makeCharRange('1', '9').concatenate(Automaton.makeCharRange('0', '9').repeat(0));
        Automaton t1 = Automaton.makeChar('0').union(Automaton.makeChar('-').optional().concatenate(t0));
        t1.minimize();
        t1.setInfo("<int>");
        integerString = t1;
        longString = t1;
        Automaton t2 = t0.concatenate(Automaton.makeChar('.')).concatenate(Automaton.makeCharRange('0', '9').repeat(0).concatenate(Automaton.makeCharRange('1', '9')).union(Automaton.makeChar('0')));
        Automaton t3 = Automaton.makeChar('E').concatenate(integerString).optional();
        Automaton t4 = t2.concatenate(t3).union(Automaton.makeString("Infinity"));
        Automaton t5 = Automaton.makeChar('-').optional().concatenate(t4);
        Automaton t6 = t5.union(Automaton.makeString("NaN"));
        t6.minimize();
        t6.setInfo("<float>");
        floatString = t6;
        doubleString = t6;
        
        // charsets
        emptyCharset = new CharSet();
        binaryBooleanCharset = new CharSet();
        binaryBooleanCharset.add(BINARY_TRUE);
        binaryBooleanCharset.add(BINARY_FALSE);
        
        binaryBooleanAutomaton = Automaton.makeChar(BINARY_TRUE).union(Automaton.makeChar(BINARY_FALSE));
        
        
        // create some automatons for Character.isDigit, Character.isLetter, etc.
        // these are defined by some unicode table and are not trivial, so we find all the characters by brute force
        characterIsDigit = new Automaton();
        characterIsLetter = new Automaton();
        characterIsLowerCase = new Automaton();
        characterIsSpaceChar = new Automaton();
        characterIsTitleCase = new Automaton();
        characterIsUpperCase = new Automaton();
        characterIsWhitespace = new Automaton();
        State digitState = new State();		digitState.setAccept(true);
        State letterState = new State();	letterState.setAccept(true);
        State lowercaseState = new State();	letterState.setAccept(true);
        State spacecharState = new State();	spacecharState.setAccept(true);
        State titlecaseState = new State();	titlecaseState.setAccept(true);
        State uppercaseState = new State();	uppercaseState.setAccept(true);
        State whitespaceState = new State();whitespaceState.setAccept(true);
        for (char ch=Character.MIN_VALUE; ch<Character.MAX_VALUE; ch++) {
        	if (Character.isDigit(ch)) {
        		characterIsDigit.getInitialState().addTransition(new Transition(ch, ch, digitState));
        	}
        	if (Character.isLetter(ch)) {
        		characterIsLetter.getInitialState().addTransition(new Transition(ch, ch, letterState));
        	}
        	if (Character.isLowerCase(ch)) {
        		characterIsLowerCase.getInitialState().addTransition(new Transition(ch, ch, lowercaseState));
        	}
        	if (Character.isSpaceChar(ch)) {
        		characterIsSpaceChar.getInitialState().addTransition(new Transition(ch, ch, spacecharState));
        	}
        	if (Character.isTitleCase(ch)) {
        		characterIsTitleCase.getInitialState().addTransition(new Transition(ch, ch, titlecaseState));
        	}
        	if (Character.isUpperCase(ch)) {
        		characterIsUpperCase.getInitialState().addTransition(new Transition(ch, ch, uppercaseState));
        	}
        	if (Character.isWhitespace(ch)) {
        		characterIsWhitespace.getInitialState().addTransition(new Transition(ch, ch, whitespaceState));
        	}
        }
        characterIsDigit.restoreInvariant();
        characterIsLetter.restoreInvariant();
        characterIsLowerCase.restoreInvariant();
        characterIsSpaceChar.restoreInvariant();
        characterIsTitleCase.restoreInvariant();
        characterIsUpperCase.restoreInvariant();
        characterIsWhitespace.restoreInvariant();
        characterIsDigit.reduce();
        characterIsLetter.reduce();
        characterIsLowerCase.reduce();
        characterIsSpaceChar.reduce();
        characterIsTitleCase.reduce();
        characterIsUpperCase.reduce();
        characterIsWhitespace.reduce();
        
        characterIsLetterOrDigit = characterIsDigit.union(characterIsLetter);
    }
    
    private Basic() {
    }
    
    public static CharSet getEmptyCharSet() {
        return emptyCharset;
    }
    public static CharSet getBinaryBooleanCharSet() {
        return binaryBooleanCharset;
    }
    
    public static CharSet makeBinaryBooleanCharSet(boolean b) {
        CharSet ch = new CharSet();
        ch.add(b ? BINARY_TRUE : BINARY_FALSE);
        return ch;
    }
    public static Automaton makeBinaryBoolean(boolean b) {
        return Automaton.makeString("" + (b ? BINARY_TRUE : BINARY_FALSE));
    }
    public static Automaton getBinaryBooleans() {
        return binaryBooleanAutomaton;
    }
    
    /**
     * Returns automaton for the empty string.
     */
    public static Automaton makeEmptyString() {
        return emptyString;
    }

    /**
     * Returns automaton for any string.
     */
    public static Automaton makeAnyString() {
        return anyString;
    }

    /**
     * Returns automaton for no string.
     */
    public static Automaton makeNoString() {
        return noString;
    }

    /**
     * Returns automaton for values of <tt>Object.toString()</tt>.
     */
    public static Automaton makeObjectString() {
        return objectString;
    }

    /**
     * Returns automaton for string values of <tt>Boolean</tt>.
     */
    public static Automaton makeBooleanString() {
        return booleanString;
    }

    /**
     * Returns automaton for string values of <tt>Character</tt>.
     */
    public static Automaton makeCharacterString() {
        return characterString;
    }

    /**
     * Returns automaton for string values of <tt>Double</tt>.
     */
    public static Automaton makeDoubleString() {
        return doubleString;
    }

    /**
     * Returns automaton for string values of <tt>Float</tt>.
     */
    public static Automaton makeFloatString() {
        return floatString;
    }

    /**
     * Returns automaton for string values of <tt>Byte</tt>.
     */
    public static Automaton makeByteString() {
        return integerString;
    }

    /**
     * Returns automaton for string values of <tt>Short</tt>.
     */
    public static Automaton makeShortString() {
        return integerString;
    }

    /**
     * Returns automaton for string values of <tt>Integer</tt>.
     */
    public static Automaton makeIntegerString() {
        return integerString;
    }

    /**
     * Returns automaton for string values of <tt>Long</tt>.
     */
    public static Automaton makeLongString() {
        return longString;
    }

    static void escapeChar(char c, StringBuilder b) {
        if (c >= 0x20 && c <= 0x7e) {
            b.append(c);
        } else {
            b.append("\\u");
            String t = Integer.toHexString(c & 0xffff);
            for (int j = 0; j + t.length() < 4; j++) {
                b.append('0');
            }
            b.append(t);
        }
    }

    static String escapeChar(char c) {
        StringBuilder b = new StringBuilder();
        escapeChar(c, b);
        return b.toString();
    }

    static String escapeString(String s) {
        StringBuilder b = new StringBuilder();
        b.append('"');
        for (int i = 0; i < s.length(); i++) {
            escapeChar(s.charAt(i), b);
        }
        b.append('"');
        return b.toString();
    }

    /**
     * Returns automaton for the given constant string.
     */
    public static Automaton makeConstString(String s) {
        Automaton a = Automaton.makeString(s);
        a.setInfo(escapeString(s));
        return a;
    }

    /**
     * Constructs name for the given automaton.
     */
    public static String getName(Automaton a) {
        Object info = a.getInfo();
        if (info != null) {
            return (String) info;
        }
        String s = a.getSingleton();
        if (s != null) {
            return escapeString(s);
        }
        return "<???>";
    }

    static Set<State> findReachableStates(State s) {
        Set<State> reachable = new HashSet<State>();
        TreeSet<State> pending = new TreeSet<State>();
        pending.add(s);
        while (!pending.isEmpty()) {
            State p = pending.first();
            pending.remove(p);
            reachable.add(p);
            for (Transition t : p.getTransitions()) {
                State q = t.getDest();
                if (!reachable.contains(q)) {
                    pending.add(q);
                }
            }
        }
        return reachable;
    }
    
    /**
     * Returns an automaton accepting every prefix of every string accepted by the
     * specified automaton. Prefixes of S include both the empty string and S itself.
     * <p/>
     * The resulting automaton will be deterministic if and only if the input automaton
     * was deterministic.
     */
    public static Automaton getPrefixesOf(Automaton automaton) {
        Automaton result = automaton.clone();
        for (State state : result.getLiveStates()) {
            state.setAccept(true);
        }
        result.restoreInvariant();
        if (result.isDeterministic()) {
            result.minimize();
        }
        return result;
    }
    
    /**
     * Returns an automaton accepting every suffix of every string accepted by the
     * specified automaton. Suffixes of S include both the empty string and S itself.
     * <p/>
     * The resulting automaton will be deterministic if and only if the input automaton
     * was deterministic.
     */
    public static Automaton getSuffixesOf(Automaton automaton) {
        Automaton result = automaton.clone();
        Collection<StatePair> epsilons = new ArrayList<StatePair>();
        for (State state : result.getLiveStates()) {
            if (state != result.getInitialState()) {
                epsilons.add(new StatePair(result.getInitialState(), state));
            }
        }
        result.addEpsilons(epsilons);
        if (automaton.isDeterministic()) {
            result.determinize();
            result.minimize();
        }
        return result;
    }
    
    /**
     * Returns an automaton accepting every substring of every string accepted by the
     * specified automaton.
     */
    public static Automaton getSubstringsOf(Automaton automaton) {
        Automaton result = automaton.clone();
        result.removeDeadTransitions();
        Collection<StatePair> epsilons = new ArrayList<StatePair>();
        for (State state : result.getStates()) {
            state.setAccept(true);
            if (state != result.getInitialState()) {
                epsilons.add(new StatePair(result.getInitialState(), state));
            }
        }
        result.restoreInvariant(); // accept states have been modified
        result.addEpsilons(epsilons);
        result.determinize();
        result.minimize();
        return result;
    }
    
    /**
     * Returns an automaton accepting all characters considered digits by {@link Character#isDigit(char)}.
     * <p/>
     * Note that unicode defines more digit characters than the traditional 0...9 digits.
     */
    public static Automaton getUnicodeDigits() {
    	return characterIsDigit;
    }
    
    /**
     * Returns an automaton accepting all characters considered letters by {@link Character#isLetter(char)}.
     */
    public static Automaton getUnicodeLetters() {
    	return characterIsLetter;
    }
    
    /**
     * Returns an automaton accepting all characters considered digits or letters by {@link Character#isLetterOrDigit(char)}.
     */
    public static Automaton getUnicodeLettersAndDigits() {
    	return characterIsLetterOrDigit;
    }
    
    /**
     * Returns an automaton accepting all characters considered lower case by {@link Character#isLowerCase(char)}.
     */
    public static Automaton getUnicodeLowerCase() {
    	return characterIsLowerCase;
    }

    /**
     * Returns an automaton accepting all characters considered space characters by {@link Character#isSpaceChar(char)}.
     */
    public static Automaton getUnicodeSpaceChars() {
    	return characterIsSpaceChar;
    }

    /**
     * Returns an automaton accepting all characters considered title case by {@link Character#isTitleCase(char)}.
     */
    public static Automaton getUnicodeTitleCase() {
    	return characterIsTitleCase;
    }

    /**
     * Returns an automaton accepting all characters considered upper case by {@link Character#isUpperCase(char)}.
     */
    public static Automaton getUnicodeUpperCase() {
    	return characterIsUpperCase;
    }
    
    /**
     * Returns an automaton accepting all characters considered whitespace by {@link Character#isWhitespace(char)}.
     */
    public static Automaton getUnicodeWhitespace() {
    	return characterIsWhitespace;
    }
}
