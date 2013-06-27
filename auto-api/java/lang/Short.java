package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Short extends Number implements Comparable<Short> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.218 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "6B20F172DB6AEA88BC2254D4F28BB29D")

    private short value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.219 -0400", hash_original_method = "929EA7C7B9F688B1FB918E42E094A176", hash_generated_method = "34D1BC1A6D7D79A3CCC438567DA6D000")
    public  Short(String string) throws NumberFormatException {
        this(parseShort(string));
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.219 -0400", hash_original_method = "943F3BD92535719838B11732349A25CE", hash_generated_method = "6461AAF473DA1D4263F37F10CDE089FA")
    public  Short(short value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.219 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "88CFC0851C8B7B08D0D2C40B5FBA738D")
    @Override
    public byte byteValue() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1988862556 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1988862556;
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.220 -0400", hash_original_method = "9451F44BD5942680EA0D419B40FE27E5", hash_generated_method = "957C5153D86DBA2E3B3EC4AF0E7B3A01")
    public int compareTo(Short object) {
        int varEB17148B4676BC6C35C2467C947D57DF_1009505414 = (compare(value, object.value));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571858941 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1571858941;
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.221 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "48C7F1E7BA775188FBE8DBBC64F17B94")
    @Override
    public double doubleValue() {
        double varE8CD7DA078A86726031AD64F35F5A6C0_623745819 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_623745819;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.222 -0400", hash_original_method = "0E7C562AADA4AAAABF3DA1440DB603BB", hash_generated_method = "D7C5317F6906A1A25D0366A014D62E8E")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097800212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097800212;
        // ---------- Original Method ----------
        //return (object instanceof Short) && (((Short) object).value == value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.222 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "C761B8D16A7315315B8ED117D7097404")
    @Override
    public float floatValue() {
        float var546ADE640B6EDFBC8A086EF31347E768_526781725 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_526781725;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.222 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "88F2B424406E81677ED84C0A588E32F0")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_759447394 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_759447394;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.222 -0400", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "805AD6133D66E7332E76510DE954170F")
    @Override
    public int intValue() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212161296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212161296;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.222 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "1AB60AA8992C7FC30F9CFB923B7AF663")
    @Override
    public long longValue() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_66498044 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_66498044;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.223 -0400", hash_original_method = "C4526A740A626A32E8FE5B0C1E7B83A6", hash_generated_method = "FA1538922EE877BD4DDDCEA8C4345B4A")
    @Override
    public short shortValue() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1836715965 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1836715965;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.223 -0400", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "00399A2202F96E3E11C029F5E2672F3D")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2013783369 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2013783369 = Integer.toString(value);
        varB4EAC82CA7396A68D541C85D26508E83_2013783369.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2013783369;
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

    
        public static short reverseBytes(short s) {
        return (short) ((s << 8) | ((s >>> 8) & 0xFF));
    }

    
        public static Short valueOf(short s) {
        return s < -128 || s >= 128 ? new Short(s) : SMALL_VALUES[s + 128];
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.224 -0400", hash_original_field = "8A229B991FDF19CA883A8D4E9D99142D", hash_generated_field = "E174156F8590F0A7563AED93135D059A")

    private static long serialVersionUID = 7515723908773894738L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.224 -0400", hash_original_field = "58D43F2979920AACD9FAF82D06E9CC69", hash_generated_field = "2E8990EE4BCAF51ABAF9910FEA47E327")

    public static final short MAX_VALUE = (short) 0x7FFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.231 -0400", hash_original_field = "8A0326ECCCC6AC72E19DB78C56A68A7A", hash_generated_field = "8248891CDA13195DEFED2D9240C645FE")

    public static final short MIN_VALUE = (short) 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.232 -0400", hash_original_field = "19BE510B820D2DF825572D14CACB552E", hash_generated_field = "35BBD8D16D40CCFD2558C6BE179C9BD7")

    public static final int SIZE = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.232 -0400", hash_original_field = "41D855CE4D75EE663D99662562F0FBD8", hash_generated_field = "E28BA0FAE7ADC3DBF11B80B560194555")

    @SuppressWarnings("unchecked")
    public static final Class<Short> TYPE
            = (Class<Short>) short[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.232 -0400", hash_original_field = "BC52D030307AD74705EC01D39B1A6174", hash_generated_field = "4B9882E299E1EC5B33A0E5D75B02F152")

    private static Short[] SMALL_VALUES = new Short[256];
    static {
        for (int i = -128; i < 128; i++) {
            SMALL_VALUES[i + 128] = new Short((short) i);
        }
    }
    
}

