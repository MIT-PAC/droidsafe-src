package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class Pair<F, S> {

    
    public static <A, B> Pair <A, B> create(A a, B b) {
        return new Pair<A, B>(a, b);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.651 -0500", hash_original_field = "65A526F460179BA2222378A48839D0E9", hash_generated_field = "11C830DF6FB4A823C0844ADD83C166D2")

    public  F first;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.653 -0500", hash_original_field = "FF8E52E888CE1141B8EEA00138A18DBA", hash_generated_field = "594420204FA1F806800D783DC05892CC")

    public  S second;

    /**
     * Constructor for a Pair. If either are null then equals() and hashCode() will throw
     * a NullPointerException.
     * @param first the first object in the Pair
     * @param second the second object in the pair
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.656 -0500", hash_original_method = "2958ED2AC94D7F1EF56F55D0DF355D40", hash_generated_method = "5D1F833FF2D2A33E3458CD780D201C52")
    @DSSafe(DSCat.SAFE_OTHERS) 
public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Checks the two objects for equality by delegating to their respective equals() methods.
     * @param o the Pair to which this one is to be checked for equality
     * @return true if the underlying objects of the Pair are both considered equals()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.659 -0500", hash_original_method = "A022862730CB324FED346DC42742A154", hash_generated_method = "AA162B5160A8E91B07EBFE324BF6321B")
    
public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Pair)) return false;
        final Pair<F, S> other;
        try {
            other = (Pair<F, S>) o;
        } catch (ClassCastException e) {
            return false;
        }
        return first.equals(other.first) && second.equals(other.second);
    }

    /**
     * Compute a hash code using the hash codes of the underlying objects
     * @return a hashcode of the Pair
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:22.661 -0500", hash_original_method = "7E2E6D9DD55E11668C618EBE33FB07A0", hash_generated_method = "CA3FA9F91E6A875A2B5F08D2451BF398")
    
public int hashCode() {
        int result = 17;
        result = 31 * result + first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
    }

    
}

