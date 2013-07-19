package java.lang;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class Short extends Number implements Comparable<Short> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.632 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "6B20F172DB6AEA88BC2254D4F28BB29D")

    private short value;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.632 -0400", hash_original_method = "929EA7C7B9F688B1FB918E42E094A176", hash_generated_method = "34D1BC1A6D7D79A3CCC438567DA6D000")
    public  Short(String string) throws NumberFormatException {
        this(parseShort(string));
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.632 -0400", hash_original_method = "943F3BD92535719838B11732349A25CE", hash_generated_method = "6461AAF473DA1D4263F37F10CDE089FA")
    public  Short(short value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.633 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "FF4D358B12D3B07213769863444E10EF")
    @Override
    public byte byteValue() {
        byte varF3F1FD62E8C4F529180D718EF4A7CECE_1911334790 = ((byte) value);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_2072002457 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_2072002457;
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.633 -0400", hash_original_method = "9451F44BD5942680EA0D419B40FE27E5", hash_generated_method = "E3D3FD0D26688C441EC1FB08FAEE29AD")
    public int compareTo(Short object) {
        addTaint(object.getTaint());
        int var054767143750F894747E80D9A9324D76_1297027947 = (compare(value, object.value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590344958 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590344958;
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
    @DSModeled(DSC.SAFE)
    public static int compare(long lhs, long rhs) {
        return lhs > rhs ? 1 : (lhs < rhs ? -1 : 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static Short decode(String string) throws NumberFormatException {
        int intValue = Integer.decode(string).intValue();
        short result = (short) intValue;
        if (result == intValue) {
            return valueOf(result);
        }
        throw new NumberFormatException("Value out of range for short: \"" + string + "\"");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.634 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "BA8D71D6EC5A2F988AE84004C9806364")
    @Override
    public double doubleValue() {
        double var2063C1608D6E0BAF80249C42E2BE5804_1018073464 = (value);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1802010545 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1802010545;
        // ---------- Original Method ----------
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.634 -0400", hash_original_method = "0E7C562AADA4AAAABF3DA1440DB603BB", hash_generated_method = "39253260D1E1EE4B6D746FAA4F622239")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean varDE02B0012693B2F0DBBDEFC2E4538AA7_1252309939 = ((object instanceof Short) && (((Short) object).value == value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1983259455 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1983259455;
        // ---------- Original Method ----------
        //return (object instanceof Short) && (((Short) object).value == value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.634 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "591EC70B8E914D001829A016B559445F")
    @Override
    public float floatValue() {
        float var2063C1608D6E0BAF80249C42E2BE5804_255790021 = (value);
                float var546ADE640B6EDFBC8A086EF31347E768_1551851549 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1551851549;
        // ---------- Original Method ----------
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.635 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "B3A25CEF72269B4E5AC1FBB7FC413334")
    @Override
    public int hashCode() {
        int var2063C1608D6E0BAF80249C42E2BE5804_1541631223 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923351768 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923351768;
        // ---------- Original Method ----------
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.635 -0400", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "232D3FFCDE5D4A1F4202A807DD103CAF")
    @Override
    public int intValue() {
        int var2063C1608D6E0BAF80249C42E2BE5804_246614064 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_314545955 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_314545955;
        // ---------- Original Method ----------
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.635 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "338FDA35DF856DD5251CB91CEF79ECF3")
    @Override
    public long longValue() {
        long var2063C1608D6E0BAF80249C42E2BE5804_290597418 = (value);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_551931996 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_551931996;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    public static short parseShort(String string) throws NumberFormatException {
        return parseShort(string, 10);
    }

    
    @DSModeled(DSC.SAFE)
    public static short parseShort(String string, int radix) throws NumberFormatException {
        int intValue = Integer.parseInt(string, radix);
        short result = (short) intValue;
        if (result == intValue) {
            return result;
        }
        throw new NumberFormatException("Value out of range for short: \"" + string + "\"");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.636 -0400", hash_original_method = "C4526A740A626A32E8FE5B0C1E7B83A6", hash_generated_method = "5023648527CB27B9506BAE7F9BEDF0E9")
    @Override
    public short shortValue() {
        short var2063C1608D6E0BAF80249C42E2BE5804_2069831394 = (value);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1028075988 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1028075988;
        // ---------- Original Method ----------
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.636 -0400", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "CFB93D8FA9195F19321501E2DEC80A09")
    @Override
    public String toString() {
String var695C2C3E368F8F994F8F1E388D82E0AE_652349740 =         Integer.toString(value);
        var695C2C3E368F8F994F8F1E388D82E0AE_652349740.addTaint(taint);
        return var695C2C3E368F8F994F8F1E388D82E0AE_652349740;
        // ---------- Original Method ----------
        //return Integer.toString(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(short value) {
        return Integer.toString(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static Short valueOf(String string) throws NumberFormatException {
        return valueOf(parseShort(string));
    }

    
    @DSModeled(DSC.SAFE)
    public static Short valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseShort(string, radix));
    }

    
    @DSModeled(DSC.SAFE)
    public static short reverseBytes(short s) {
        return (short) ((s << 8) | ((s >>> 8) & 0xFF));
    }

    
    @DSModeled(DSC.SAFE)
    public static Short valueOf(short s) {
        return s < -128 || s >= 128 ? new Short(s) : SMALL_VALUES[s + 128];
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.637 -0400", hash_original_field = "8A229B991FDF19CA883A8D4E9D99142D", hash_generated_field = "AC22C2D7B4371C5B3354C8DF803452A1")

    private static final long serialVersionUID = 7515723908773894738L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.637 -0400", hash_original_field = "58D43F2979920AACD9FAF82D06E9CC69", hash_generated_field = "2E8990EE4BCAF51ABAF9910FEA47E327")

    public static final short MAX_VALUE = (short) 0x7FFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.637 -0400", hash_original_field = "8A0326ECCCC6AC72E19DB78C56A68A7A", hash_generated_field = "8248891CDA13195DEFED2D9240C645FE")

    public static final short MIN_VALUE = (short) 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.637 -0400", hash_original_field = "19BE510B820D2DF825572D14CACB552E", hash_generated_field = "35BBD8D16D40CCFD2558C6BE179C9BD7")

    public static final int SIZE = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.637 -0400", hash_original_field = "41D855CE4D75EE663D99662562F0FBD8", hash_generated_field = "E28BA0FAE7ADC3DBF11B80B560194555")

    @SuppressWarnings("unchecked")
    public static final Class<Short> TYPE
            = (Class<Short>) short[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.637 -0400", hash_original_field = "BC52D030307AD74705EC01D39B1A6174", hash_generated_field = "5EDCE38E3A4104420004ABECDB3724B1")

    private static final Short[] SMALL_VALUES = new Short[256];
    static {
        for (int i = -128; i < 128; i++) {
            SMALL_VALUES[i + 128] = new Short((short) i);
        }
    }
    
}

