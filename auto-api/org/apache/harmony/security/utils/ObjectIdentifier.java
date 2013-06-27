package org.apache.harmony.security.utils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public final class ObjectIdentifier {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.184 -0400", hash_original_field = "130F43112BB8A7A7790EBFC08EE9D6AF", hash_generated_field = "282BA3ECCB824558DBD68D7EB102F89D")

    private int[] oid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.184 -0400", hash_original_field = "AA3BEAB45B8CACBD81EA40A719A8F3DA", hash_generated_field = "D81A83B1820A06AF71E170062C4ECA79")

    private int hash = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.184 -0400", hash_original_field = "DE27C66C20C38B882DA535901EBF09FA", hash_generated_field = "B67A2A548CCCA3ABBCDCF1E77441B37F")

    private String soid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.184 -0400", hash_original_field = "0B9F315B99D0A470817D89EA6725CF07", hash_generated_field = "84B9B965B3055F61D4D95D618DA2A1D9")

    private String sOID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.195 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.195 -0400", hash_original_field = "DB0F6F37EBEB6EA09489124345AF2A45", hash_generated_field = "20B5DD71DC465C0DFA3301CB14EE7FDD")

    private Object group;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.195 -0400", hash_original_method = "7ABF15BC63C3D8D706564084308C24AA", hash_generated_method = "CCC4EB505410486A6B9D3FE727DD263E")
    public  ObjectIdentifier(int[] oid) {
        validateOid(oid);
        this.oid = oid;
        // ---------- Original Method ----------
        //validateOid(oid);
        //this.oid = oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.207 -0400", hash_original_method = "383F734F3FE5E01DEDB78CACC2759E14", hash_generated_method = "228E6EE25C1AE204D2B9DB2C73B87D71")
    public  ObjectIdentifier(int[] oid, String name, Object oidGroup) {
        this(oid);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("oidGroup == null");
        } //End block
        this.group = oidGroup;
        this.name = name;
        toOIDString();
        addTaint(oid[0]);
        // ---------- Original Method ----------
        //if (oidGroup == null) {
            //throw new NullPointerException("oidGroup == null");
        //}
        //this.group = oidGroup;
        //this.name = name;
        //toOIDString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.208 -0400", hash_original_method = "30E83D32FBE8DF043D06124E9715286A", hash_generated_method = "C426AE62285FAFD23D1AC0B42D85EE43")
    public int[] getOid() {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2080796853 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_2080796853;
        // ---------- Original Method ----------
        //return oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.209 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "5B5CB4DFFDD365057AA4AB87751DBFE7")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1434348324 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1434348324 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1434348324.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1434348324;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.218 -0400", hash_original_method = "FA340579AD853DABC65F97F27C820CE8", hash_generated_method = "E30E96CA254D28BD4A666AA28B085DD2")
    public Object getGroup() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1187762790 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1187762790 = group;
        varB4EAC82CA7396A68D541C85D26508E83_1187762790.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1187762790;
        // ---------- Original Method ----------
        //return group;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.219 -0400", hash_original_method = "7A1590EC642F64148081547F7DE77EEF", hash_generated_method = "39F27DB4D35FB8755EB54F9225110CD2")
    public boolean equals(Object o) {
        {
            boolean var9B27E520BBC2DDC5CC18F0AC09DC0048_842093426 = (o == null || this.getClass() != o.getClass());
        } //End collapsed parenthetic
        boolean var85CA6B7259588F8D393C14CCCE2DBEB8_1496916735 = (Arrays.equals(oid, ((ObjectIdentifier) o).oid));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_83970530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_83970530;
        // ---------- Original Method ----------
        //if (this == o) {
            //return true;
        //}
        //if (o == null || this.getClass() != o.getClass()) {
            //return false;
        //}
        //return Arrays.equals(oid, ((ObjectIdentifier) o).oid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.220 -0400", hash_original_method = "81F5AC8E69E1A1CBA984F8550D6AF5BD", hash_generated_method = "A4E6D160A17639458413BBAA5F6C095B")
    public String toOIDString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2051215557 = null; //Variable for return #1
        {
            sOID = "OID." + toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2051215557 = sOID;
        varB4EAC82CA7396A68D541C85D26508E83_2051215557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2051215557;
        // ---------- Original Method ----------
        //if (sOID == null) {
            //sOID = "OID." + toString();
        //}
        //return sOID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.221 -0400", hash_original_method = "B22823BCA8FD058C901A741025BA8FB1", hash_generated_method = "74448E5CECE8B70BC8619C4081B5D056")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_314669507 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_314669507 = soid;
        varB4EAC82CA7396A68D541C85D26508E83_314669507.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_314669507;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.231 -0400", hash_original_method = "F5FB24607FBDCD1263609B3FEECCC6D5", hash_generated_method = "2D2CA58F2523124C94610F29FB4BAE43")
    public int hashCode() {
        {
            hash = hashIntArray(oid);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1073181491 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1073181491;
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

