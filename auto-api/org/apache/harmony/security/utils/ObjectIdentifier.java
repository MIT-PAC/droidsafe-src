package org.apache.harmony.security.utils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;

public final class ObjectIdentifier {
    private final int[] oid;
    private int hash = -1;
    private String soid;
    private String sOID;
    private String name;
    private Object group;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.792 -0400", hash_original_method = "7ABF15BC63C3D8D706564084308C24AA", hash_generated_method = "57C7307AA56D103B0CB66738DBBA80AF")
    @DSModeled(DSC.SAFE)
    public ObjectIdentifier(int[] oid) {
        dsTaint.addTaint(oid);
        validateOid(oid);
        // ---------- Original Method ----------
        //validateOid(oid);
        //this.oid = oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.792 -0400", hash_original_method = "383F734F3FE5E01DEDB78CACC2759E14", hash_generated_method = "7EF0D52013C5400BCEDAD0B962BE291F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectIdentifier(int[] oid, String name, Object oidGroup) {
        this(oid);
        dsTaint.addTaint(oidGroup.dsTaint);
        dsTaint.addTaint(oid);
        dsTaint.addTaint(name);
        {
            throw new NullPointerException("oidGroup == null");
        } //End block
        toOIDString();
        // ---------- Original Method ----------
        //if (oidGroup == null) {
            //throw new NullPointerException("oidGroup == null");
        //}
        //this.group = oidGroup;
        //this.name = name;
        //toOIDString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.792 -0400", hash_original_method = "30E83D32FBE8DF043D06124E9715286A", hash_generated_method = "DC1E35D8DB3EC515D52F6161938F7A0E")
    @DSModeled(DSC.SAFE)
    public int[] getOid() {
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.793 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "F47755EA38582EE7C3877DD72123E9B0")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.793 -0400", hash_original_method = "FA340579AD853DABC65F97F27C820CE8", hash_generated_method = "A4E0DEDE910799A06EC6DD9B352EC819")
    @DSModeled(DSC.SAFE)
    public Object getGroup() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return group;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.793 -0400", hash_original_method = "7A1590EC642F64148081547F7DE77EEF", hash_generated_method = "15AA19B3C2E3D7D80D6C6940C6E3A09E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var9B27E520BBC2DDC5CC18F0AC09DC0048_2072459429 = (o == null || this.getClass() != o.getClass());
        } //End collapsed parenthetic
        boolean var85CA6B7259588F8D393C14CCCE2DBEB8_1604886352 = (Arrays.equals(oid, ((ObjectIdentifier) o).oid));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.793 -0400", hash_original_method = "81F5AC8E69E1A1CBA984F8550D6AF5BD", hash_generated_method = "33F3B99E076E6357B25839E493EE9DDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toOIDString() {
        {
            sOID = "OID." + toString();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (sOID == null) {
            //sOID = "OID." + toString();
        //}
        //return sOID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.793 -0400", hash_original_method = "B22823BCA8FD058C901A741025BA8FB1", hash_generated_method = "522384E495A98B93B27D8BAD05DDC9A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        {
            StringBuilder sb;
            sb = new StringBuilder(4 * oid.length);
            {
                int i;
                i = 0;
                {
                    sb.append(oid[i]);
                    sb.append('.');
                } //End block
            } //End collapsed parenthetic
            sb.append(oid[oid.length - 1]);
            soid = sb.toString();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (soid == null) {
            //StringBuilder sb = new StringBuilder(4 * oid.length);
            //for (int i = 0; i < oid.length - 1; ++i) {
                //sb.append(oid[i]);
                //sb.append('.');
            //}
            //sb.append(oid[oid.length - 1]);
            //soid = sb.toString();
        //}
        //return soid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.793 -0400", hash_original_method = "F5FB24607FBDCD1263609B3FEECCC6D5", hash_generated_method = "56DE0D64F4335A75ED5C493368154F2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        {
            hash = hashIntArray(oid);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (hash == -1) {
            //hash = hashIntArray(oid);
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.793 -0400", hash_original_method = "8A03D4A0A8F771BBDCBB48C7AE384ACF", hash_generated_method = "2F7D3B508C8CE668C31890B26F7A3F6F")
    public static void validateOid(int[] oid) {
        if (oid == null) {
            throw new NullPointerException("oid == null");
        }
        if (oid.length < 2) {
            throw new IllegalArgumentException("OID MUST have at least 2 subidentifiers");
        }
        if (oid[0] > 2) {
            throw new IllegalArgumentException("Valid values for first subidentifier are 0, 1 and 2");
        } else if (oid[0] != 2 && oid[1] > 39) {
            throw new IllegalArgumentException("If the first subidentifier has 0 or 1 value the second subidentifier value MUST be less than 40");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.793 -0400", hash_original_method = "8BE7213CC6A7767AC7788E8FF7C56936", hash_generated_method = "CEBD3A7CE307C99CD19038C61A900D09")
    public static int hashIntArray(int[] array) {
        int intHash = 0;
        for (int i = 0; i < array.length && i < 4; i++) {
            intHash += array[i] << (8 * i); 
        }
        return intHash & 0x7FFFFFFF;
    }

    
}


