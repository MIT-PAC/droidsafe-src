package org.apache.harmony.security.utils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public final class ObjectIdentifier {
    private int[] oid;
    private int hash = -1;
    private String soid;
    private String sOID;
    private String name;
    private Object group;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.398 -0400", hash_original_method = "7ABF15BC63C3D8D706564084308C24AA", hash_generated_method = "5176FCD3A5FF3011C2D1CD83BE3EC627")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectIdentifier(int[] oid) {
        dsTaint.addTaint(oid[0]);
        validateOid(oid);
        // ---------- Original Method ----------
        //validateOid(oid);
        //this.oid = oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.398 -0400", hash_original_method = "383F734F3FE5E01DEDB78CACC2759E14", hash_generated_method = "C5D6F3401D910464C204BED5E86960F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectIdentifier(int[] oid, String name, Object oidGroup) {
        this(oid);
        dsTaint.addTaint(oidGroup.dsTaint);
        dsTaint.addTaint(oid[0]);
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("oidGroup == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.398 -0400", hash_original_method = "30E83D32FBE8DF043D06124E9715286A", hash_generated_method = "6ACFD8F5C46BF2587DD8ED8967E8E5AD")
    @DSModeled(DSC.SAFE)
    public int[] getOid() {
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.398 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3573899E99121C9CFE87F9DDAEE36810")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.399 -0400", hash_original_method = "FA340579AD853DABC65F97F27C820CE8", hash_generated_method = "EE2892EE5E9D70FB1668557EEC9DDB90")
    @DSModeled(DSC.SAFE)
    public Object getGroup() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return group;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.399 -0400", hash_original_method = "7A1590EC642F64148081547F7DE77EEF", hash_generated_method = "38305A023639401F17C2A70F833FA59F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var9B27E520BBC2DDC5CC18F0AC09DC0048_619209331 = (o == null || this.getClass() != o.getClass());
        } //End collapsed parenthetic
        boolean var85CA6B7259588F8D393C14CCCE2DBEB8_589041802 = (Arrays.equals(oid, ((ObjectIdentifier) o).oid));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.399 -0400", hash_original_method = "81F5AC8E69E1A1CBA984F8550D6AF5BD", hash_generated_method = "5EB2EEA32880969795091DD841546F71")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.399 -0400", hash_original_method = "B22823BCA8FD058C901A741025BA8FB1", hash_generated_method = "8D59C3E2E9FD2A6030F8C1372B4CFDCB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.400 -0400", hash_original_method = "F5FB24607FBDCD1263609B3FEECCC6D5", hash_generated_method = "0451A527625321CB31FE8147C28A6CA8")
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

    
        public static int hashIntArray(int[] array) {
        int intHash = 0;
        for (int i = 0; i < array.length && i < 4; i++) {
            intHash += array[i] << (8 * i); 
        }
        return intHash & 0x7FFFFFFF;
    }

    
}

