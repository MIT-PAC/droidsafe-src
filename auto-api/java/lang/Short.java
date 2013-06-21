package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Short extends Number implements Comparable<Short> {
    private short value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.067 -0400", hash_original_method = "929EA7C7B9F688B1FB918E42E094A176", hash_generated_method = "B5C5491CD5BF4E35A3CB8B4A8E777D9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Short(String string) throws NumberFormatException {
        this(parseShort(string));
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.068 -0400", hash_original_method = "943F3BD92535719838B11732349A25CE", hash_generated_method = "92DC8FB77B4C9284B3AA05D994AD8E6C")
    @DSModeled(DSC.SAFE)
    public Short(short value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.068 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "4F78E57EE61A27A10E7A632140A3DDA6")
    @DSModeled(DSC.SAFE)
    @Override
    public byte byteValue() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.068 -0400", hash_original_method = "9451F44BD5942680EA0D419B40FE27E5", hash_generated_method = "B6C51AF4940231967691E6BAEF4EE79C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Short object) {
        dsTaint.addTaint(object.dsTaint);
        int varEB17148B4676BC6C35C2467C947D57DF_1424786251 = (compare(value, object.value));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.069 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "02C8EAF77A98DB2CD3BC8AC0566EBE67")
    @DSModeled(DSC.SAFE)
    @Override
    public double doubleValue() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.069 -0400", hash_original_method = "0E7C562AADA4AAAABF3DA1440DB603BB", hash_generated_method = "BE0B049C1BD51185FD0A981389AD1292")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (object instanceof Short) && (((Short) object).value == value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.069 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "89D86731B5289C6353CA0DC29E484746")
    @DSModeled(DSC.SAFE)
    @Override
    public float floatValue() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.069 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "2CC0EC8302E0602B9137F5B8629A7214")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.077 -0400", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "036E05D318FB7A9B9F28D4BD928D74B4")
    @DSModeled(DSC.SAFE)
    @Override
    public int intValue() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.080 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "80C9E384C663D2D407424A79AF4BFC59")
    @DSModeled(DSC.SAFE)
    @Override
    public long longValue() {
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.083 -0400", hash_original_method = "C4526A740A626A32E8FE5B0C1E7B83A6", hash_generated_method = "3D66E8454B043C5D45C9817A80595123")
    @DSModeled(DSC.SAFE)
    @Override
    public short shortValue() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.085 -0400", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "FF79282E56303D87EB62C04D64BBB981")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varD42FC0CD51582E4DF744832DA0BFE096_946510021 = (Integer.toString(value));
        return dsTaint.getTaintString();
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

    
    private static final long serialVersionUID = 7515723908773894738L;
    public static final short MAX_VALUE = (short) 0x7FFF;
    public static final short MIN_VALUE = (short) 0x8000;
    public static final int SIZE = 16;
    @SuppressWarnings("unchecked") public static final Class<Short> TYPE
            = (Class<Short>) short[].class.getComponentType();
    private static final Short[] SMALL_VALUES = new Short[256];
    static {
        for (int i = -128; i < 128; i++) {
            SMALL_VALUES[i + 128] = new Short((short) i);
        }
    }
    
}

