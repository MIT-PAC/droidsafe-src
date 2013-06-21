package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public final class ObjectIdentifier {
    private int[] oid;
    private String soid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.127 -0400", hash_original_method = "20230C77538103726EF6427B9F75CADF", hash_generated_method = "5A21B54DD6AD871F70495A6929B08A59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectIdentifier(int[] oid) {
        dsTaint.addTaint(oid[0]);
        validate(oid);
        // ---------- Original Method ----------
        //validate(oid);
        //this.oid = oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.127 -0400", hash_original_method = "33C298706B9DEBE0D1CFE9C3A9D89C98", hash_generated_method = "42868728053BC844805EFDD2D2B25A19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectIdentifier(String strOid) {
        dsTaint.addTaint(strOid);
        this.oid = toIntArray(strOid);
        // ---------- Original Method ----------
        //this.oid = toIntArray(strOid);
        //this.soid = strOid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.127 -0400", hash_original_method = "7A1590EC642F64148081547F7DE77EEF", hash_generated_method = "A12E4EA125364493A91987F534146AC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var9B27E520BBC2DDC5CC18F0AC09DC0048_199887616 = (o == null || this.getClass() != o.getClass());
        } //End collapsed parenthetic
        boolean var85CA6B7259588F8D393C14CCCE2DBEB8_50978780 = (Arrays.equals(oid, ((ObjectIdentifier) o).oid));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.127 -0400", hash_original_method = "CBAF5DCAABB7CFC3E05C923E938DB148", hash_generated_method = "877FC279D70087DA94BA9F6AB750A602")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.128 -0400", hash_original_method = "8929009F517116C951EAF49377701B44", hash_generated_method = "D7B65A07BC40D536563BCB6DC39CB01C")
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

    
        public static String toString(int[] oid) {
        StringBuilder sb = new StringBuilder(3 * oid.length);
        for (int i = 0; i < oid.length - 1; ++i) {
            sb.append(oid[i]);
            sb.append('.');
        }
        sb.append(oid[oid.length - 1]);
        return sb.toString();
    }

    
        public static int[] toIntArray(String str) {
        return toIntArray(str, true);
    }

    
        public static boolean isOID(String str) {
        return toIntArray(str, false) != null;
    }

    
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

