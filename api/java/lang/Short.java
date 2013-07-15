package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class Short extends Number implements Comparable<Short> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.414 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "6B20F172DB6AEA88BC2254D4F28BB29D")

    private short value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.415 -0400", hash_original_method = "929EA7C7B9F688B1FB918E42E094A176", hash_generated_method = "34D1BC1A6D7D79A3CCC438567DA6D000")
    public  Short(String string) throws NumberFormatException {
        this(parseShort(string));
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.415 -0400", hash_original_method = "943F3BD92535719838B11732349A25CE", hash_generated_method = "6461AAF473DA1D4263F37F10CDE089FA")
    public  Short(short value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.416 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "DC0814CD5BE8F2175EF3ABC5DA9CA6B6")
    @Override
    public byte byteValue() {
        byte varF3F1FD62E8C4F529180D718EF4A7CECE_97075636 = ((byte) value);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_2067821216 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_2067821216;
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.417 -0400", hash_original_method = "9451F44BD5942680EA0D419B40FE27E5", hash_generated_method = "5E386943CB0CEDD2AFD5C2E8CCDCDAF3")
    public int compareTo(Short object) {
        addTaint(object.getTaint());
        int var054767143750F894747E80D9A9324D76_1937210642 = (compare(value, object.value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_124746371 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_124746371;
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
        @DSModeled(DSC.SAFE)
    public static int compare(long lhs, long rhs) {
        return lhs > rhs ? 1 : (lhs < rhs ? -1 : 0);
    }

    
        public static Short decode(String string) throws NumberFormatException {
        int intValue = Integer.decode(string).intValue();
        short result = (short) intValue;
        if (result == intValue) {
            return valueOf(result);
        }
        throw new NumberFormatException("Value out of range for short: \"" + string + "\"");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.425 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "FA5336F4FCEC68AD14FADF69B3611110")
    @Override
    public double doubleValue() {
        double var2063C1608D6E0BAF80249C42E2BE5804_1063866855 = (value);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1855369474 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1855369474;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.430 -0400", hash_original_method = "0E7C562AADA4AAAABF3DA1440DB603BB", hash_generated_method = "45A51663C3CAB6D76756EF24F23FDEF8")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean varDE02B0012693B2F0DBBDEFC2E4538AA7_531476105 = ((object instanceof Short) && (((Short) object).value == value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1508458432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1508458432;
        // ---------- Original Method ----------
        //return (object instanceof Short) && (((Short) object).value == value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.431 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "EBFE7F9BCFA0DA4182627C29FDA62BF1")
    @Override
    public float floatValue() {
        float var2063C1608D6E0BAF80249C42E2BE5804_1936278635 = (value);
                float var546ADE640B6EDFBC8A086EF31347E768_573449773 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_573449773;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.431 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "19736A14F0F637E10ABCD1862B905E32")
    @Override
    public int hashCode() {
        int var2063C1608D6E0BAF80249C42E2BE5804_369595170 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1497629072 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1497629072;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.432 -0400", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "F667956BA449DF24FEBE8E2AA91C7FAC")
    @Override
    public int intValue() {
        int var2063C1608D6E0BAF80249C42E2BE5804_1529816963 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1913008965 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1913008965;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.432 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "4C674459D9A6B35E19D3DAF7492AFEB9")
    @Override
    public long longValue() {
        long var2063C1608D6E0BAF80249C42E2BE5804_410647202 = (value);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_584649792 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_584649792;
        // ---------- Original Method ----------
        //return value;
    }

    
        public static short parseShort(String string) throws NumberFormatException {
        return parseShort(string, 10);
    }

    
        public static short parseShort(String string, int radix) throws NumberFormatException {
        int intValue = Integer.parseInt(string, radix);
        short result = (short) intValue;
        if (result == intValue) {
            return result;
        }
        throw new NumberFormatException("Value out of range for short: \"" + string + "\"");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.440 -0400", hash_original_method = "C4526A740A626A32E8FE5B0C1E7B83A6", hash_generated_method = "D366C5027317DAE2ADBAE9473D1EC256")
    @Override
    public short shortValue() {
        short var2063C1608D6E0BAF80249C42E2BE5804_1895511934 = (value);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1027187471 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1027187471;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.440 -0400", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "F17E5B1D3FA5D6B66233B02CD9EA4056")
    @Override
    public String toString() {
String var695C2C3E368F8F994F8F1E388D82E0AE_1702463623 =         Integer.toString(value);
        var695C2C3E368F8F994F8F1E388D82E0AE_1702463623.addTaint(taint);
        return var695C2C3E368F8F994F8F1E388D82E0AE_1702463623;
        // ---------- Original Method ----------
        //return Integer.toString(value);
    }

    
        public static String toString(short value) {
        return Integer.toString(value);
    }

    
        public static Short valueOf(String string) throws NumberFormatException {
        return valueOf(parseShort(string));
    }

    
        public static Short valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseShort(string, radix));
    }

    
        @DSModeled(DSC.SAFE)
    public static short reverseBytes(short s) {
        return (short) ((s << 8) | ((s >>> 8) & 0xFF));
    }

    
        public static Short valueOf(short s) {
        return s < -128 || s >= 128 ? new Short(s) : SMALL_VALUES[s + 128];
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.443 -0400", hash_original_field = "8A229B991FDF19CA883A8D4E9D99142D", hash_generated_field = "AC22C2D7B4371C5B3354C8DF803452A1")

    private static final long serialVersionUID = 7515723908773894738L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.443 -0400", hash_original_field = "58D43F2979920AACD9FAF82D06E9CC69", hash_generated_field = "2E8990EE4BCAF51ABAF9910FEA47E327")

    public static final short MAX_VALUE = (short) 0x7FFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.443 -0400", hash_original_field = "8A0326ECCCC6AC72E19DB78C56A68A7A", hash_generated_field = "8248891CDA13195DEFED2D9240C645FE")

    public static final short MIN_VALUE = (short) 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.444 -0400", hash_original_field = "19BE510B820D2DF825572D14CACB552E", hash_generated_field = "35BBD8D16D40CCFD2558C6BE179C9BD7")

    public static final int SIZE = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.444 -0400", hash_original_field = "41D855CE4D75EE663D99662562F0FBD8", hash_generated_field = "E28BA0FAE7ADC3DBF11B80B560194555")

    @SuppressWarnings("unchecked")
    public static final Class<Short> TYPE
            = (Class<Short>) short[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.444 -0400", hash_original_field = "BC52D030307AD74705EC01D39B1A6174", hash_generated_field = "5EDCE38E3A4104420004ABECDB3724B1")

    private static final Short[] SMALL_VALUES = new Short[256];
    static {
        for (int i = -128; i < 128; i++) {
            SMALL_VALUES[i + 128] = new Short((short) i);
        }
    }
    
}

