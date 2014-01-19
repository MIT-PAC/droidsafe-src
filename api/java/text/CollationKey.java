package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class CollationKey implements Comparable<CollationKey> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.369 -0500", hash_original_field = "113A199BE68A5F67DC2655549852AA2D", hash_generated_field = "2D2DC69F3BF28B00B15BD37DFC141996")

    private  String source;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.372 -0500", hash_original_method = "FA2BB1F012B53BF817CC40F1D26354AF", hash_generated_method = "2BCBB035079A053386A5126B969D116F")
    
protected CollationKey(String source) {
        this.source = source;
    }

    /**
     * Compares this collation key to the given collation key.
     *
     * @param value the other collation key.
     * @return a negative value if this key is less than {@code value},
     *         0 if they are equal, and a positive value if this key is greater.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.375 -0500", hash_original_method = "5A8B3826F27E8A10E70456EFF51F7B67", hash_generated_method = "34BE21858DBE7BB60BBE664DFC1749FC")
    
public abstract int compareTo(CollationKey value);

    /**
     * Returns the string from which this collation key was created.
     *
     * @return the source string of this collation key.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.377 -0500", hash_original_method = "CAA51A8D77816B9C71E897924204286F", hash_generated_method = "9B985589C949425CCB62BF63707CC1D4")
    
public String getSourceString() {
        return source;
    }

    /**
     * Returns this collation key as a byte array.
     *
     * @return an array of bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:07.379 -0500", hash_original_method = "31E18643298D4EE9D64BE0AC906151D9", hash_generated_method = "3D52100227B2457DAC4556D4C4615F2D")
    
public abstract byte[] toByteArray();
    
}

