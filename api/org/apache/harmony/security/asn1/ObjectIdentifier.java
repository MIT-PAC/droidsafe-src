package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public final class ObjectIdentifier {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.043 -0400", hash_original_field = "130F43112BB8A7A7790EBFC08EE9D6AF", hash_generated_field = "282BA3ECCB824558DBD68D7EB102F89D")

    private int[] oid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.043 -0400", hash_original_field = "DE27C66C20C38B882DA535901EBF09FA", hash_generated_field = "B67A2A548CCCA3ABBCDCF1E77441B37F")

    private String soid;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.043 -0400", hash_original_method = "20230C77538103726EF6427B9F75CADF", hash_generated_method = "695B95975CC186A99EED9C9A4C949FFD")
    public  ObjectIdentifier(int[] oid) {
        validate(oid);
        this.oid = oid;
        // ---------- Original Method ----------
        //validate(oid);
        //this.oid = oid;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.044 -0400", hash_original_method = "33C298706B9DEBE0D1CFE9C3A9D89C98", hash_generated_method = "29DFD93289F4CBDE2E7B748208083263")
    public  ObjectIdentifier(String strOid) {
        this.oid = toIntArray(strOid);
        this.soid = strOid;
        // ---------- Original Method ----------
        //this.oid = toIntArray(strOid);
        //this.soid = strOid;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.044 -0400", hash_original_method = "7A1590EC642F64148081547F7DE77EEF", hash_generated_method = "258A5D9454C461720698B6310FAD15DE")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_183676437 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1379373875 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1379373875;
        } //End block
    if(o == null || this.getClass() != o.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_67950994 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_956870140 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_956870140;
        } //End block
        boolean var62A536C7516308AA2A6C1868C0B5E7EE_1102807471 = (Arrays.equals(oid, ((ObjectIdentifier) o).oid));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_83169106 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_83169106;
        // ---------- Original Method ----------
        //if (this == o) {
            //return true;
        //}
        //if (o == null || this.getClass() != o.getClass()) {
            //return false;
        //}
        //return Arrays.equals(oid, ((ObjectIdentifier) o).oid);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.045 -0400", hash_original_method = "CBAF5DCAABB7CFC3E05C923E938DB148", hash_generated_method = "F83F5CEA729BFAF035DB79F583905770")
    @Override
    public String toString() {
    if(soid == null)        
        {
            soid = toString(oid);
        } //End block
String var2D98CC55C81F1E6E04CCE50DEB76A9B7_616375120 =         soid;
        var2D98CC55C81F1E6E04CCE50DEB76A9B7_616375120.addTaint(taint);
        return var2D98CC55C81F1E6E04CCE50DEB76A9B7_616375120;
        // ---------- Original Method ----------
        //if (soid == null) {
            //soid = toString(oid);
        //}
        //return soid;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.045 -0400", hash_original_method = "8929009F517116C951EAF49377701B44", hash_generated_method = "FE3FE4DA4D1EBC0A13BBAAFB3B22F669")
    @Override
    public int hashCode() {
        int intHash = 0;
for(int i = 0;i < oid.length && i < 4;i++)
        {
            intHash += oid[i] << (8 * i);
        } //End block
        int varA649C0FF433C9DEED60103F772C02F3A_449785004 = (intHash & 0x7FFFFFFF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_839692482 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_839692482;
        // ---------- Original Method ----------
        //int intHash = 0;
        //for (int i = 0; i < oid.length && i < 4; i++) {
            //intHash += oid[i] << (8 * i); 
        //}
        //return intHash & 0x7FFFFFFF;
    }

    
        @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
    public static int[] toIntArray(String str) {
        return toIntArray(str, true);
    }

    
        @DSModeled(DSC.SAFE)
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

