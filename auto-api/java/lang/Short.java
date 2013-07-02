package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public final class Short extends Number implements Comparable<Short> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.696 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "6B20F172DB6AEA88BC2254D4F28BB29D")

    private short value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.696 -0400", hash_original_method = "929EA7C7B9F688B1FB918E42E094A176", hash_generated_method = "34D1BC1A6D7D79A3CCC438567DA6D000")
    public  Short(String string) throws NumberFormatException {
        this(parseShort(string));
        addTaint(string.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.697 -0400", hash_original_method = "943F3BD92535719838B11732349A25CE", hash_generated_method = "6461AAF473DA1D4263F37F10CDE089FA")
    public  Short(short value) {
        this.value = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.697 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "95A400E9436A3FAF7BF4D8B90709190E")
    @Override
    public byte byteValue() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1139274213 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1139274213;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.698 -0400", hash_original_method = "9451F44BD5942680EA0D419B40FE27E5", hash_generated_method = "F3E181DB4B71AC7FFC013FC9E0F411C0")
    public int compareTo(Short object) {
        int varEB17148B4676BC6C35C2467C947D57DF_2058199775 = (compare(value, object.value));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422129258 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422129258;
        
        
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.698 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "E2265EEB44DA6520EF70DC846AD61A23")
    @Override
    public double doubleValue() {
        double varE8CD7DA078A86726031AD64F35F5A6C0_1133764876 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1133764876;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.699 -0400", hash_original_method = "0E7C562AADA4AAAABF3DA1440DB603BB", hash_generated_method = "25DE913DB92BE755BFB6E21CE2F6C929")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839359884 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839359884;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.699 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "2AC330685BC18B3DB389B0EF56889E6D")
    @Override
    public float floatValue() {
        float var546ADE640B6EDFBC8A086EF31347E768_2103757200 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2103757200;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.699 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "B7EEC1FB73471CD2E847AD58E05F3B00")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515336157 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1515336157;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.699 -0400", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "99A931A0E0D57F0FD71F90F5189C7728")
    @Override
    public int intValue() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779998120 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779998120;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.700 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "5DC319D10E80FCEE9C00AE2DA88854AD")
    @Override
    public long longValue() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_656349435 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_656349435;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.700 -0400", hash_original_method = "C4526A740A626A32E8FE5B0C1E7B83A6", hash_generated_method = "B74CA2CFEACD35722E46DC8268FAC1FC")
    @Override
    public short shortValue() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_9250287 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_9250287;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.700 -0400", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "4A5DE03AF78484538E70BC1347F6AA8A")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_323818482 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_323818482 = Integer.toString(value);
        varB4EAC82CA7396A68D541C85D26508E83_323818482.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_323818482;
        
        
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

    
    public static short reverseBytes(short s) {
        return (short) ((s << 8) | ((s >>> 8) & 0xFF));
    }

    
    @DSModeled(DSC.SAFE)
    public static Short valueOf(short s) {
        return s < -128 || s >= 128 ? new Short(s) : SMALL_VALUES[s + 128];
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.701 -0400", hash_original_field = "8A229B991FDF19CA883A8D4E9D99142D", hash_generated_field = "AC22C2D7B4371C5B3354C8DF803452A1")

    private static final long serialVersionUID = 7515723908773894738L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.701 -0400", hash_original_field = "58D43F2979920AACD9FAF82D06E9CC69", hash_generated_field = "2E8990EE4BCAF51ABAF9910FEA47E327")

    public static final short MAX_VALUE = (short) 0x7FFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.701 -0400", hash_original_field = "8A0326ECCCC6AC72E19DB78C56A68A7A", hash_generated_field = "8248891CDA13195DEFED2D9240C645FE")

    public static final short MIN_VALUE = (short) 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.701 -0400", hash_original_field = "19BE510B820D2DF825572D14CACB552E", hash_generated_field = "35BBD8D16D40CCFD2558C6BE179C9BD7")

    public static final int SIZE = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.701 -0400", hash_original_field = "41D855CE4D75EE663D99662562F0FBD8", hash_generated_field = "E28BA0FAE7ADC3DBF11B80B560194555")

    @SuppressWarnings("unchecked")
    public static final Class<Short> TYPE
            = (Class<Short>) short[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.701 -0400", hash_original_field = "BC52D030307AD74705EC01D39B1A6174", hash_generated_field = "5EDCE38E3A4104420004ABECDB3724B1")

    private static final Short[] SMALL_VALUES = new Short[256];
    static {
        for (int i = -128; i < 128; i++) {
            SMALL_VALUES[i + 128] = new Short((short) i);
        }
    }
    
}

