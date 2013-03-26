package dk.brics.string.charset;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.State;
import dk.brics.automaton.Transition;

/**
 * Character set.
 */
public class CharSet implements Cloneable {

    private HashSet<Interval> intervals = new HashSet<Interval>();

    /**
     * Constructs new empty character set.
     */
    public CharSet() {
    }

    /**
     * Returns new character set with all characters in strings in the given language.
     */
    public CharSet(Automaton a) {
        Automaton b = a.singleChars();
        for (Transition t : b.getInitialState().getTransitions()) {
            intervals.add(new Interval(t.getMin(), t.getMax()));
        }
    }
    /**
     * Returns new character set with all characters in the specified string.
     */
    public CharSet(String s) {
        for (int i=0; i<s.length(); i++) {
            intervals.add(new Interval(s.charAt(i), s.charAt(i+1)));
        }
    }

    @Override
    public CharSet clone() {
        CharSet a;
        try {
            a = (CharSet) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        a.intervals = new HashSet<Interval>(intervals);
        return a;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CharSet) {
            CharSet a = (CharSet) obj;
            return intervals.equals(a.intervals);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return intervals.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        boolean first = true;
        for (Interval v : new TreeSet<Interval>(intervals)) {
            if (first) {
                first = false;
            } else {
                b.append(",");
            }
            if (v.getMin() == v.getMax()) {
                appendChar(b, v.getMin());
            } else {
                appendChar(b, v.getMin());
                b.append("-");
                appendChar(b, v.getMax());
            }
        }
        return b.toString();
    }

    private void appendChar(StringBuilder b, char c) {
        b.append('\'');
        if (c >= 0x21 && c <= 0x7e && c != '-') {
            b.append(c);
        } else {
            b.append("\\u");
            String t = Integer.toHexString(c & 0xffff);
            for (int j = 0; j + t.length() < 4; j++) {
                b.append('0');
            }
            b.append(t);
        }
        b.append('\'');
    }

    void reduce() {
        TreeSet<Interval> s = new TreeSet<Interval>(intervals);
        intervals.clear();
        int min = -1, max = -1;
        for (Interval v : s) {
            if (v.getMin() <= max + 1) {
                if (v.getMax() > max) {
                    max = v.getMax();
                }
            } else {
                if (min > 0) {
                    intervals.add(new Interval((char) min, (char) max));
                }
                min = v.getMin();
                max = v.getMax();
            }
        }
        if (min > 0) {
            intervals.add(new Interval((char) min, (char) max));
        }
    }

    /**
     * Returns new character set with every character.
     */
    public static CharSet makeAnychars() {
        CharSet a = new CharSet();
        a.intervals.add(new Interval(Character.MIN_VALUE, Character.MAX_VALUE));
        return a;
    }

    /**
     * Constructs union of this character set and the given one.
     */
    public CharSet union(CharSet a) {
        CharSet b = clone();
        b.intervals.addAll(new HashSet<Interval>(a.intervals));
        b.reduce();
        return b;
    }

    /**
     * Constructs union of the given character sets.
     */
    public static CharSet union(List<CharSet> c) {
        CharSet a = new CharSet();
        for (CharSet b : c) {
            a.intervals.addAll(new HashSet<Interval>(b.intervals));
        }
        a.reduce();
        return a;
    }

    /**
     * Constructs character set as this one but removes the given character.
     */
    public CharSet remove(char c) {
        CharSet b = clone();
        for (Interval v : intervals) {
            if (v.getMin() <= c && c <= v.getMax()) {
                b.intervals.remove(v);
                if (v.getMin() < c) {
                    b.intervals.add(new Interval(v.getMin(), (char) (c - 1)));
                }
                if (c < v.getMax()) {
                    b.intervals.add(new Interval((char) (c + 1), v.getMax()));
                }
            }
        }
        return b;
    }

    /**
     * Constructs character set as this one but adds the given character.
     */
    public CharSet add(char c) {
        CharSet b = clone();
        b.intervals.add(new Interval(c));
        b.reduce();
        return b;
    }
    
    /**
     * Constructs a new character set as the intersection of this set and
     * the specified set. 
     */
    public CharSet intersection(CharSet other) {
        PriorityQueue<Interval> mine = new PriorityQueue<Interval>(intervals);
        PriorityQueue<Interval> yours = new PriorityQueue<Interval>(other.intervals);
        CharSet result = new CharSet();
        while (!mine.isEmpty() && !yours.isEmpty()) {
            Interval a = mine.peek();
            Interval b = yours.peek();
            
            Interval inter = a.intersection(b);
            
            if (inter != null) {
                result.intervals.add(inter);
            }
            
            if (a.getMax() < b.getMax()) {
                mine.remove();
            } else {
                yours.remove();
            }
        }
        return result;
    }
    
    boolean isTotal() {
        if (intervals.size() == 1) {
            Interval v = intervals.iterator().next();
            return v.getMin() == Character.MIN_VALUE && v.getMax() == Character.MAX_VALUE;
        } else {
            return false;
        }
    }

    /**
     * Constructs character set as this one and performs uppercase conversion of all characters.
     */
    public CharSet toLowerCase() {
        if (isTotal()) {
            return clone();
        }
        CharSet b = new CharSet();
        for (Interval v : intervals) {
            for (int c = v.getMin(); c <= v.getMax(); c++) {
            	String s = String.valueOf((char)c).toLowerCase();
            	for (int i=0; i<s.length(); i++) {
            		b.intervals.add(new Interval(s.charAt(i)));
            	}
            }
        }
        b.reduce();
        return b;
    }
    
    /**
     * Constructs character set as this one and performs lowercase conversion of all characters,
     * as done by {@link String#toUpperCase()} (which occasionally differs from character-wise application of {@link Character#toUpperCase(char)})
     */
    public CharSet toUpperCase() {
        if (isTotal()) {
            return clone();
        }
        CharSet b = new CharSet();
        for (Interval v : intervals) {
            for (int c = v.getMin(); c <= v.getMax(); c++) {
            	// some characters, like the German "ß", become multiple characters after being turned into upper case
            	String s = String.valueOf((char)c).toUpperCase();
            	for (int i=0; i<s.length(); i++) {
            		b.intervals.add(new Interval(s.charAt(i)));
            	}
            }
        }
        b.reduce();
        return b;
    }

    /**
     * Constructs automaton accepting strings with zero or more characters from this set.
     */
    public Automaton toAutomaton() {
        Automaton a = new Automaton();
        State s = a.getInitialState();
        s.setAccept(true);
        for (Interval v : intervals) {
            s.addTransition(new Transition(v.getMin(), v.getMax(), s));
        }
        return a;
    }

    /**
     * Checks whether a particular characters is in the set.
     */
    public boolean contains(char c) {
        for (Interval v : intervals) {
            if (v.getMin() <= c && c <= v.getMax()) {
                return true;
            }
        }
        return false;
    }
}
