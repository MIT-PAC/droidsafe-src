package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;

public final class ObjectIdentifier {
    private final int[] oid;
    private String soid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.720 -0400", hash_original_method = "20230C77538103726EF6427B9F75CADF", hash_generated_method = "038CBFB0A498F135AD1DE72B6A755D4E")
    @DSModeled(DSC.SAFE)
    public ObjectIdentifier(int[] oid) {
        dsTaint.addTaint(oid);
        this.oid = oid;
        validate(oid);
        // ---------- Original Method ----------
        //validate(oid);
        //this.oid = oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.720 -0400", hash_original_method = "33C298706B9DEBE0D1CFE9C3A9D89C98", hash_generated_method = "D4E8C427C75E6FDA1239F30505579670")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectIdentifier(String strOid) {
        dsTaint.addTaint(strOid);
        this.oid = toIntArray(strOid);
        // ---------- Original Method ----------
        //this.oid = toIntArray(strOid);
        //this.soid = strOid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.720 -0400", hash_original_method = "7A1590EC642F64148081547F7DE77EEF", hash_generated_method = "9E0F0C35C86DE5C56EFAE32AFEBDC3A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var9B27E520BBC2DDC5CC18F0AC09DC0048_777274563 = (o == null || this.getClass() != o.getClass());
        } //End collapsed parenthetic
        boolean var85CA6B7259588F8D393C14CCCE2DBEB8_1912498537 = (Arrays.equals(oid, ((ObjectIdentifier) o).oid));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == o) {
            //return true;
        //}
        //if (o == null || this.getClass() != o.getClass()) {
            //return false;
        //}
        //return Arrays.equals(oid, ((ObjectIdentifier) o).oid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.720 -0400", hash_original_method = "CBAF5DCAABB7CFC3E05C923E938DB148", hash_generated_method = "B6775BDCE32FE46E2804CB310BCA7A78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        {
            soid = toString(oid);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (soid == null) {
            //soid = toString(oid);
        //}
        //return soid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.720 -0400", hash_original_method = "8929009F517116C951EAF49377701B44", hash_generated_method = "19175E69E8D643317342B224D35641DB")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        int intHash;
        intHash = 0;
        {
            int i;
            i = 0;
            {
                intHash += oid[i] << (8 * i);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int intHash = 0;
        //for (int i = 0; i < oid.length && i < 4; i++) {
            //intHash += oid[i] << (8 * i); 
        //}
        //return intHash & 0x7FFFFFFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.720 -0400", hash_original_method = "E1FBF626549ACB1158CD9E14F440ADC4", hash_generated_method = "0E00904E93A6F196E058B95B3DFA9B3A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.720 -0400", hash_original_method = "537E0E62A536665037DE9BF93DCC6BC4", hash_generated_method = "18FE2AF03DA7E415BB218E6E82E80DAF")
    public static String toString(int[] oid) {
        StringBuilder sb = new StringBuilder(3 * oid.length);
        for (int i = 0; i < oid.length - 1; ++i) {
            sb.append(oid[i]);
            sb.append('.');
        }
        sb.append(oid[oid.length - 1]);
        return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.720 -0400", hash_original_method = "D2F1B0F357AFECE488E1088CFE6DBC57", hash_generated_method = "08D553EB52C2E1246CD1707FCCE6C5DC")
    public static int[] toIntArray(String str) {
        return toIntArray(str, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.720 -0400", hash_original_method = "0D08485A656DC1909930679AAD3ED153", hash_generated_method = "3BE256B79713C0F9388BE7428B880A36")
    public static boolean isOID(String str) {
        return toIntArray(str, false) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.720 -0400", hash_original_method = "53B83C1819BF34B8CC2A9C3AD4211A77", hash_generated_method = "0F0788DFF9075996C188CB7A98FF64BE")
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
        int count = 1;
        boolean wasDot = true;
        char c;
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
                oid[j] = oid[j] * 10 + c - 48; 
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

    
}


