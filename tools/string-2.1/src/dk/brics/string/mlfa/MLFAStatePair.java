package dk.brics.string.mlfa;

/**
 * Pair of MLFA states.
 */
public class MLFAStatePair {

    private MLFAState s1, s2;
    private boolean taint;

    /**
     * Constructs new pair.
     *
     * @param s1 first state
     * @param s2 second state
     */
    public MLFAStatePair(MLFAState s1, MLFAState s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    /**
     * Returns first component of this pair.
     *
     * @return first state
     */
    public MLFAState getFirstState() {
        return s1;
    }

    /**
     * Returns second component of this pair.
     *
     * @return second state
     */
    public MLFAState getSecondState() {
        return s2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MLFAStatePair) {
            MLFAStatePair p = (MLFAStatePair) obj;
            return p.s1 == s1 && p.s2 == s2;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return s1.hashCode() * 2 + s2.hashCode() * 3;
    }

    @Override
    public String toString() {
        return "(" + s1 + "," + s2 + ")";
    }

    public boolean isTaint() {
        return taint;
    }

    public void setTaint(boolean taint) {
        this.taint = taint;
    }
}
