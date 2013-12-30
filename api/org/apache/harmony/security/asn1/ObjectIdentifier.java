package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;






public final class ObjectIdentifier {

    /**
     * Validates ObjectIdentifier (OID).
     *
     * @param oid oid as array of integers
     * @throws IllegalArgumentException if oid is invalid or null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.416 -0500", hash_original_method = "E1FBF626549ACB1158CD9E14F440ADC4", hash_generated_method = "0E00904E93A6F196E058B95B3DFA9B3A")
    
public static void validate(int[] oid) {
        if (oid == null) {
            throw new IllegalArgumentException("oid == null");
        }

        if (oid.length < 2) {
            throw new IllegalArgumentException("OID MUST have at least 2 subidentifiers");
        }

        if (oid[0] > 2) {
            throw new IllegalArgumentException(
                    "Valid values for first subidentifier are 0, 1 and 2");
        } else if (oid[0] != 2 && oid[1] > 39) {
            throw new IllegalArgumentException("If the first subidentifier has 0 or 1 value the "
                    + "second subidentifier value MUST be less than 40");
        }

        for (int anOid : oid) {
            if (anOid < 0) {
                throw new IllegalArgumentException("Subidentifier MUST have positive value");
            }
        }
    }

    /**
     * Returns string representation of OID.
     *
     * Note: it is supposed that passed array of integers
     * contains valid OID value, so no checks are performed.
     *
     * @param oid oid as array of integers
     * @return oid string representation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.418 -0500", hash_original_method = "537E0E62A536665037DE9BF93DCC6BC4", hash_generated_method = "18FE2AF03DA7E415BB218E6E82E80DAF")
    
public static String toString(int[] oid) {
        StringBuilder sb = new StringBuilder(3 * oid.length);

        for (int i = 0; i < oid.length - 1; ++i) {
            sb.append(oid[i]);
            sb.append('.');
        }
        sb.append(oid[oid.length - 1]);
        return sb.toString();
    }

    /**
     * Gets ObjectIdentifier (OID) from string representation.
     *
     * String representation is defined by the following syntax:
     *     OID = subidentifier 1*("." subidentifier)
     *     subidentifier = 1*(digit)
     *
     * @param str string representation of OID
     * @return oid as array of integers
     * @throws IllegalArgumentException if oid string is invalid or null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.420 -0500", hash_original_method = "D2F1B0F357AFECE488E1088CFE6DBC57", hash_generated_method = "08D553EB52C2E1246CD1707FCCE6C5DC")
    
public static int[] toIntArray(String str) {
        return toIntArray(str, true);
    }

    /**
     * Returns whether the given string is a valid ObjectIdentifier
     * (OID) representation.
     *
     * String representation is defined as for {@link #toIntArray}.
     *
     * @param str string representation of OID
     * @return true if oidString has valid syntax or false if not
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.422 -0500", hash_original_method = "0D08485A656DC1909930679AAD3ED153", hash_generated_method = "3BE256B79713C0F9388BE7428B880A36")
    
public static boolean isOID(String str) {
        return toIntArray(str, false) != null;
    }

    /**
     * Gets ObjectIdentifier (OID) from string representation.
     *
     * String representation is defined by the following syntax:
     *     OID = subidentifier 1*("." subidentifier)
     *     subidentifier = 1*(digit)
     *
     * @param str string representation of OID
     * @return oid as array of integers or null if the oid string is
     * invalid or null and shouldThrow is false
     * @throws IllegalArgumentException if oid string is invalid or null and
     * shouldThrow is true
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.426 -0500", hash_original_method = "53B83C1819BF34B8CC2A9C3AD4211A77", hash_generated_method = "6963480B9BE93A2D4AEC00AE8C63F59F")
    
private static int[] toIntArray(String str, boolean shouldThrow) {
        if (str == null) {
            if (! shouldThrow) {
                return null;
            }
            throw new IllegalArgumentException();
        }

        int length = str.length();
        if (length == 0) {
            if (! shouldThrow) {
                return null;
            }
            throw new IllegalArgumentException("Incorrect syntax");
        }

        int count = 1; // number of subidentifiers
        boolean wasDot = true; // indicates whether char before was dot or not.
        char c; // current char
        for (int i = 0; i < length; i++) {
            c = str.charAt(i);
            if (c == '.') {
                if (wasDot) {
                    if (! shouldThrow) {
                        return null;
                    }
                    throw new IllegalArgumentException("Incorrect syntax");
                }
                wasDot = true;
                count++;
            } else if (c >= '0' && c <= '9') {
                wasDot = false;
            } else {
                if (! shouldThrow) {
                    return null;
                }
                throw new IllegalArgumentException("Incorrect syntax");
            }
        }

        if (wasDot) {
            // the last char is dot
            if (! shouldThrow) {
                return null;
            }
            throw new IllegalArgumentException("Incorrect syntax");
        }

        if (count < 2) {
            if (! shouldThrow) {
                return null;
            }
            throw new IllegalArgumentException("Incorrect syntax");
        }

        int[] oid = new int[count];
        for (int i = 0, j = 0; i < length; i++) {
            c = str.charAt(i);
            if (c == '.') {
                j++;
            } else {
                oid[j] = oid[j] * 10 + c - 48; // '0' = 48
            }
        }

        if (oid[0] > 2) {
            if (! shouldThrow) {
                return null;
            }
            throw new IllegalArgumentException("Incorrect syntax");
        } else if (oid[0] != 2 && oid[1] > 39) {
            if (! shouldThrow) {
                return null;
            }
            throw new IllegalArgumentException("Incorrect syntax");
        }

        return oid;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.398 -0500", hash_original_field = "82C0B35B7B0E7EF1298A50C60DFA28D7", hash_generated_field = "282BA3ECCB824558DBD68D7EB102F89D")

    private  int[] oid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.400 -0500", hash_original_field = "6834EE6A69F4CDD499ACBB7835C507E6", hash_generated_field = "B67A2A548CCCA3ABBCDCF1E77441B37F")

    private String soid;

    /**
     * Creates ObjectIdentifier(OID) from array of integers.
     *
     * @param oid array of integers
     * @throws IllegalArgumentException if oid is invalid or null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.403 -0500", hash_original_method = "20230C77538103726EF6427B9F75CADF", hash_generated_method = "19F803FF527995898E302F71A7078D34")
    
public ObjectIdentifier(int[] oid) {
        validate(oid);
        this.oid = oid;
    }

    /**
     * Creates ObjectIdentifier(OID) from string representation.
     *
     * @param strOid oid string
     * @throws IllegalArgumentException if oid string is invalid or null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.405 -0500", hash_original_method = "33C298706B9DEBE0D1CFE9C3A9D89C98", hash_generated_method = "F9E2A45108A053FA859BFA6D8FC9CA82")
    
public ObjectIdentifier(String strOid) {
        this.oid = toIntArray(strOid);
        this.soid = strOid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.408 -0500", hash_original_method = "7A1590EC642F64148081547F7DE77EEF", hash_generated_method = "F480ADA366896864C0C61F4E10A83AF8")
    
@Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return Arrays.equals(oid, ((ObjectIdentifier) o).oid);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.411 -0500", hash_original_method = "CBAF5DCAABB7CFC3E05C923E938DB148", hash_generated_method = "5BDD1CCAC5970EE7D256D90500423945")
    
@Override public String toString() {
        if (soid == null) {
            soid = toString(oid);
        }
        return soid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.413 -0500", hash_original_method = "8929009F517116C951EAF49377701B44", hash_generated_method = "314217F6C50D1AF8F6781EC648892892")
    
@Override public int hashCode() {
        // FIXME change me to Arrays.hashCode(int[])
        int intHash = 0;
        for (int i = 0; i < oid.length && i < 4; i++) {
            intHash += oid[i] << (8 * i); //TODO what about to find better one?
        }
        return intHash & 0x7FFFFFFF; // only positive
    }

    
}

