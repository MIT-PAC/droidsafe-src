package dk.brics.string.charset;

/**
 * Character interval.
 */
public class Interval implements Comparable<Interval> {

    private char min, max;

    /**
     * Constructs a new singleton character interval.
     */
    public Interval(char c) {
        min = max = c;
    }

    /**
     * Constructs a new character interval.
     */
    public Interval(char min, char max) {
        if (max < min) {
            char t = max;
            max = min;
            min = t;
        }
        this.min = min;
        this.max = max;
    }

    /**
     * Returns the start character of this interval.
     */
    public char getMin() {
        return min;
    }

    /**
     * Returns the end character of this interval.
     */
    public char getMax() {
        return max;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Interval) {
            Interval t = (Interval) obj;
            return t.min == min && t.max == max;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return min * 2 + max * 3;
    }
    
    private char max(char a, char b) {
        if (a > b)
            return a;
        else
            return b;
    }
    private char min(char a, char b) {
        if (a > b)
            return b;
        else
            return a;
    }
    
    /**
     * Returns the intersection of two intervals, or <tt>null</tt> if the
     * two interval do not intersect.
     * @param other an interval. May be the same as <tt>this</tt>.
     * @return a new interval or <tt>null</tt>
     */
    public Interval intersection(Interval other) {
        char minimum = max(min, other.min);
        char maximum = min(max, other.max);
        if (minimum > maximum)
            return null;
        return new Interval(minimum, maximum);
    }

    /**
     * Compares two intervals with start character as primary key
     * and end character as secondary key.
     */
    public int compareTo(Interval v) {
        if (min < v.min || (min == v.min && max < v.max)) {
            return -1;
        }
        if (v.min < min || (v.min == min && v.max < max)) {
            return 1;
        }
        return 0;
    }
}
