package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Byte extends Number implements Comparable<Byte> {
    private byte value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.439 -0400", hash_original_method = "7E64D11F2C96BA434CA992EF3846EE45", hash_generated_method = "B8F5CF8BC4F1DDC31801B86B1F094C3A")
    @DSModeled(DSC.SAFE)
    public Byte(byte value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.439 -0400", hash_original_method = "6A41489347990CAADB010180F3DA4F08", hash_generated_method = "F525B7ECF89E181680CDD3749451DE40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Byte(String string) throws NumberFormatException {
        this(parseByte(string));
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.439 -0400", hash_original_method = "A44A96B9BD8D4010644191EEAB137884", hash_generated_method = "D2318C9508E14B8B85560DDB4E242CED")
    @DSModeled(DSC.SAFE)
    @Override
    public byte byteValue() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.440 -0400", hash_original_method = "BB597B75ED281325D8B4388243F4CDF9", hash_generated_method = "1D4DFAAAD636179FD9132F5960E4B1DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Byte object) {
        dsTaint.addTaint(object.dsTaint);
        int varEB17148B4676BC6C35C2467C947D57DF_693621531 = (compare(value, object.value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
        public static int compare(byte lhs, byte rhs) {
        return lhs > rhs ? 1 : (lhs < rhs ? -1 : 0);
    }

    
        public static Byte decode(String string) throws NumberFormatException {
        int intValue = Integer.decode(string);
        byte result = (byte) intValue;
        if (result == intValue) {
            return valueOf(result);
        }
        throw new NumberFormatException("Value out of range for byte: \"" + string + "\"");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.440 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "02C8EAF77A98DB2CD3BC8AC0566EBE67")
    @DSModeled(DSC.SAFE)
    @Override
    public double doubleValue() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.440 -0400", hash_original_method = "C5FA8B05FD4F870ED8BC1DBD5FAAA797", hash_generated_method = "F3879E63FF080EFC7BC0370628CE5F30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @FindBugsSuppressWarnings("RC_REF_COMPARISON")
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var11D143228A346AC117970CE0F609BC62_46639081 = ((object == this) || ((object instanceof Byte) && (((Byte) object).value == value)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (object == this) || ((object instanceof Byte) && (((Byte) object).value == value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.441 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "89D86731B5289C6353CA0DC29E484746")
    @DSModeled(DSC.SAFE)
    @Override
    public float floatValue() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.441 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "2CC0EC8302E0602B9137F5B8629A7214")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.441 -0400", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "036E05D318FB7A9B9F28D4BD928D74B4")
    @DSModeled(DSC.SAFE)
    @Override
    public int intValue() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.441 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "80C9E384C663D2D407424A79AF4BFC59")
    @DSModeled(DSC.SAFE)
    @Override
    public long longValue() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return value;
    }

    
        public static byte parseByte(String string) throws NumberFormatException {
        return parseByte(string, 10);
    }

    
        public static byte parseByte(String string, int radix) throws NumberFormatException {
        int intValue = Integer.parseInt(string, radix);
        byte result = (byte) intValue;
        if (result == intValue) {
            return result;
        }
        throw new NumberFormatException("Value out of range for byte: \"" + string + "\"");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.441 -0400", hash_original_method = "C4526A740A626A32E8FE5B0C1E7B83A6", hash_generated_method = "3D66E8454B043C5D45C9817A80595123")
    @DSModeled(DSC.SAFE)
    @Override
    public short shortValue() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.441 -0400", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "AE7121E6AB6E8530BC147CEAC0DAACF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varD42FC0CD51582E4DF744832DA0BFE096_1078002162 = (Integer.toString(value));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Integer.toString(value);
    }

    
        public static String toHexString(byte b, boolean upperCase) {
        return IntegralToString.byteToHexString(b, upperCase);
    }

    
        public static String toString(byte value) {
        return Integer.toString(value);
    }

    
        public static Byte valueOf(String string) throws NumberFormatException {
        return valueOf(parseByte(string));
    }

    
        public static Byte valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseByte(string, radix));
    }

    
        public static Byte valueOf(byte b) {
        return VALUES[b + 128];
    }

    
    private static final long serialVersionUID = -7183698231559129828L;
    public static final byte MAX_VALUE = (byte) 0x7F;
    public static final byte MIN_VALUE = (byte) 0x80;
    public static final int SIZE = 8;
    @SuppressWarnings("unchecked") public static final Class<Byte> TYPE
            = (Class<Byte>) byte[].class.getComponentType();
    private static final Byte[] VALUES = new Byte[256];
    static {
        for (int i = -128; i < 128; i++) {
            VALUES[i + 128] = new Byte((byte) i);
        }
    }
    
}

