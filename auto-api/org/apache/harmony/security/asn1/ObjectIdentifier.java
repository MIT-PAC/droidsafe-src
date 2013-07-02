package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Arrays;

public final class ObjectIdentifier {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.902 -0400", hash_original_field = "130F43112BB8A7A7790EBFC08EE9D6AF", hash_generated_field = "282BA3ECCB824558DBD68D7EB102F89D")

    private int[] oid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.902 -0400", hash_original_field = "DE27C66C20C38B882DA535901EBF09FA", hash_generated_field = "B67A2A548CCCA3ABBCDCF1E77441B37F")

    private String soid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.902 -0400", hash_original_method = "20230C77538103726EF6427B9F75CADF", hash_generated_method = "695B95975CC186A99EED9C9A4C949FFD")
    public  ObjectIdentifier(int[] oid) {
        validate(oid);
        this.oid = oid;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.903 -0400", hash_original_method = "33C298706B9DEBE0D1CFE9C3A9D89C98", hash_generated_method = "29DFD93289F4CBDE2E7B748208083263")
    public  ObjectIdentifier(String strOid) {
        this.oid = toIntArray(strOid);
        this.soid = strOid;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.903 -0400", hash_original_method = "7A1590EC642F64148081547F7DE77EEF", hash_generated_method = "75FAA06B39307FBF7C94C55E43B57D24")
    @Override
    public boolean equals(Object o) {
        {
            boolean var9B27E520BBC2DDC5CC18F0AC09DC0048_1948381952 = (o == null || this.getClass() != o.getClass());
        } 
        boolean var85CA6B7259588F8D393C14CCCE2DBEB8_431015278 = (Arrays.equals(oid, ((ObjectIdentifier) o).oid));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064317301 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064317301;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.904 -0400", hash_original_method = "CBAF5DCAABB7CFC3E05C923E938DB148", hash_generated_method = "CDB32BF83BD2BCACD3F42403F1B7F655")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1224885886 = null; 
        {
            soid = toString(oid);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1224885886 = soid;
        varB4EAC82CA7396A68D541C85D26508E83_1224885886.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1224885886;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.904 -0400", hash_original_method = "8929009F517116C951EAF49377701B44", hash_generated_method = "D4FF41ADD740DD5597979E085D7FD3A6")
    @Override
    public int hashCode() {
        int intHash = 0;
        {
            int i = 0;
            {
                intHash += oid[i] << (8 * i);
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365785289 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365785289;
        
        
        
            
        
        
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

