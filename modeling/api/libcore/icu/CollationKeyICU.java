package libcore.icu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.CollationKey;

public final class CollationKeyICU extends CollationKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.527 -0500", hash_original_field = "AB97A4156FC1CC1DAF26375194010FF1", hash_generated_field = "4E58ABB9D5068B90ACC1157BF07E4EBB")

    private  byte[] bytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.530 -0500", hash_original_field = "5A19588B577A4926772CAE314F19FADE", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

    private int hashCode;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.532 -0500", hash_original_method = "FDD367E7E47ED4793DE3731632868D96", hash_generated_method = "FDD367E7E47ED4793DE3731632868D96")
    
CollationKeyICU(String source, byte[] bytes) {
        super(source);
        this.bytes = bytes;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.535 -0500", hash_original_method = "2BC5B1EAC391DF0E7068AFC895CE7148", hash_generated_method = "8701510548B0E35ED5569A1072A0266D")
    
@Override public int compareTo(CollationKey other) {
        // Get the bytes from the other collation key.
        final byte[] rhsBytes;
        if (other instanceof CollationKeyICU) {
            rhsBytes = ((CollationKeyICU) other).bytes;
        } else {
            rhsBytes = other.toByteArray();
        }

        if (bytes == null || bytes.length == 0) {
            if (rhsBytes == null || rhsBytes.length == 0) {
                return 0;
            }
            return -1;
        } else {
            if (rhsBytes == null || rhsBytes.length == 0) {
                return 1;
            }
        }

        int count = Math.min(bytes.length, rhsBytes.length);
        for (int i = 0; i < count; ++i) {
            int s = bytes[i] & 0xff;
            int t = rhsBytes[i] & 0xff;
            if (s < t) {
                return -1;
            }
            if (s > t) {
                return 1;
            }
        }
        if (bytes.length < rhsBytes.length) {
            return -1;
        }
        if (bytes.length > rhsBytes.length) {
            return 1;
        }
        return 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.537 -0500", hash_original_method = "02D4FA820C7658A0385D9CDD7EC5D935", hash_generated_method = "E1AC05A4AEFBDA264B4106B15AC4F3F3")
    
@Override public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CollationKey)) {
            return false;
        }
        return compareTo((CollationKey) object) == 0;
    }

    /**
     * Creates a hash code for this CollationKey.
     * Compute the hash by iterating sparsely over about 32 (up to 63) bytes
     * spaced evenly through the string.  For each byte, multiply the previous
     * hash value by a prime number and add the new byte in, like a linear
     * congruential random number generator, producing a pseudo-random
     * deterministic value well distributed over the output range.
     * @return hash value of collation key. Hash value is never 0.
     * @stable ICU 2.4
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.541 -0500", hash_original_method = "14EA39361109DCC90111D16D29CE0C8D", hash_generated_method = "227A58A6782E59F194019631AF0DF412")
    
@Override public int hashCode() {
        if (hashCode == 0) {
            if (bytes != null && bytes.length != 0) {
                int len = bytes.length;
                int inc = ((len - 32) / 32) + 1;
                for (int i = 0; i < len;) {
                    hashCode = (hashCode * 37) + bytes[i];
                    i += inc;
                }
            }
            if (hashCode == 0) {
                hashCode = 1;
            }
        }
        return hashCode;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:09.543 -0500", hash_original_method = "6C3C6FF515A6D95256010638A5024205", hash_generated_method = "85E090F4E1A22D34B3EB8A349C3F8584")
    
@Override public byte[] toByteArray() {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return bytes.clone();
    }
    
}

