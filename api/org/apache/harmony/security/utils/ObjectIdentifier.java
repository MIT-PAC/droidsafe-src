package org.apache.harmony.security.utils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public final class ObjectIdentifier {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.432 -0400", hash_original_field = "130F43112BB8A7A7790EBFC08EE9D6AF", hash_generated_field = "282BA3ECCB824558DBD68D7EB102F89D")

    private int[] oid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.432 -0400", hash_original_field = "AA3BEAB45B8CACBD81EA40A719A8F3DA", hash_generated_field = "D81A83B1820A06AF71E170062C4ECA79")

    private int hash = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.432 -0400", hash_original_field = "DE27C66C20C38B882DA535901EBF09FA", hash_generated_field = "B67A2A548CCCA3ABBCDCF1E77441B37F")

    private String soid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.432 -0400", hash_original_field = "0B9F315B99D0A470817D89EA6725CF07", hash_generated_field = "84B9B965B3055F61D4D95D618DA2A1D9")

    private String sOID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.432 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.432 -0400", hash_original_field = "DB0F6F37EBEB6EA09489124345AF2A45", hash_generated_field = "20B5DD71DC465C0DFA3301CB14EE7FDD")

    private Object group;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.433 -0400", hash_original_method = "7ABF15BC63C3D8D706564084308C24AA", hash_generated_method = "CCC4EB505410486A6B9D3FE727DD263E")
    public  ObjectIdentifier(int[] oid) {
        validateOid(oid);
        this.oid = oid;
        // ---------- Original Method ----------
        //validateOid(oid);
        //this.oid = oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.434 -0400", hash_original_method = "383F734F3FE5E01DEDB78CACC2759E14", hash_generated_method = "BBAD01333EDF3FDA592B357578932828")
    public  ObjectIdentifier(int[] oid, String name, Object oidGroup) {
        this(oid);
        addTaint(oid[0]);
    if(oidGroup == null)        
        {
            NullPointerException varE44F839234FE1E111036D9CCC87F2537_1514977803 = new NullPointerException("oidGroup == null");
            varE44F839234FE1E111036D9CCC87F2537_1514977803.addTaint(taint);
            throw varE44F839234FE1E111036D9CCC87F2537_1514977803;
        } //End block
        this.group = oidGroup;
        this.name = name;
        toOIDString();
        // ---------- Original Method ----------
        //if (oidGroup == null) {
            //throw new NullPointerException("oidGroup == null");
        //}
        //this.group = oidGroup;
        //this.name = name;
        //toOIDString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.434 -0400", hash_original_method = "30E83D32FBE8DF043D06124E9715286A", hash_generated_method = "CA45C723251216BB7EC56717465D4DC2")
    public int[] getOid() {
        int[] var130F43112BB8A7A7790EBFC08EE9D6AF_39922093 = (oid);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1873613705 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1873613705;
        // ---------- Original Method ----------
        //return oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.435 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3FA308681331D06972913A0C3DE9BEB6")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_1151702311 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1151702311.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1151702311;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.435 -0400", hash_original_method = "FA340579AD853DABC65F97F27C820CE8", hash_generated_method = "E8BC571C0FE48BAA844F5DCAE8D4B488")
    public Object getGroup() {
Object varD15A27BD67EB0D670CD5C298FF20B74F_1360345573 =         group;
        varD15A27BD67EB0D670CD5C298FF20B74F_1360345573.addTaint(taint);
        return varD15A27BD67EB0D670CD5C298FF20B74F_1360345573;
        // ---------- Original Method ----------
        //return group;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.436 -0400", hash_original_method = "7A1590EC642F64148081547F7DE77EEF", hash_generated_method = "6920D7354AC33295F438E4E16C128630")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1089376907 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1846908314 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1846908314;
        } //End block
    if(o == null || this.getClass() != o.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_247296854 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1704021358 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1704021358;
        } //End block
        boolean var62A536C7516308AA2A6C1868C0B5E7EE_892097730 = (Arrays.equals(oid, ((ObjectIdentifier) o).oid));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_877398181 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_877398181;
        // ---------- Original Method ----------
        //if (this == o) {
            //return true;
        //}
        //if (o == null || this.getClass() != o.getClass()) {
            //return false;
        //}
        //return Arrays.equals(oid, ((ObjectIdentifier) o).oid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.437 -0400", hash_original_method = "81F5AC8E69E1A1CBA984F8550D6AF5BD", hash_generated_method = "5A223EA65B2ABFE8EDC8B73F23F4AD23")
    public String toOIDString() {
    if(sOID == null)        
        {
            sOID = "OID." + toString();
        } //End block
String var1644F0E5DA14318D1460A2F3EC7526E4_1309316059 =         sOID;
        var1644F0E5DA14318D1460A2F3EC7526E4_1309316059.addTaint(taint);
        return var1644F0E5DA14318D1460A2F3EC7526E4_1309316059;
        // ---------- Original Method ----------
        //if (sOID == null) {
            //sOID = "OID." + toString();
        //}
        //return sOID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.438 -0400", hash_original_method = "B22823BCA8FD058C901A741025BA8FB1", hash_generated_method = "B449E8E141599E0F58295658D3CD58DA")
    public String toString() {
    if(soid == null)        
        {
            StringBuilder sb = new StringBuilder(4 * oid.length);
for(int i = 0;i < oid.length - 1;++i)
            {
                sb.append(oid[i]);
                sb.append('.');
            } //End block
            sb.append(oid[oid.length - 1]);
            soid = sb.toString();
        } //End block
String var2D98CC55C81F1E6E04CCE50DEB76A9B7_1680422614 =         soid;
        var2D98CC55C81F1E6E04CCE50DEB76A9B7_1680422614.addTaint(taint);
        return var2D98CC55C81F1E6E04CCE50DEB76A9B7_1680422614;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.438 -0400", hash_original_method = "F5FB24607FBDCD1263609B3FEECCC6D5", hash_generated_method = "00143AD5836ADEAA65F9EC791BD5323C")
    public int hashCode() {
    if(hash == -1)        
        {
            hash = hashIntArray(oid);
        } //End block
        int var0800FC577294C34E0B28AD2839435945_1059887815 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1290019700 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1290019700;
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

