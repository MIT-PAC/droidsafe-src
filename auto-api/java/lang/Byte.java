package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Byte extends Number implements Comparable<Byte> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.049 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "8CCAF7A9B8382D1617ADC5CB954C674D")

    private byte value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.049 -0400", hash_original_method = "7E64D11F2C96BA434CA992EF3846EE45", hash_generated_method = "EF48A56C44D8A8A39C1273A89D41BB2B")
    public  Byte(byte value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.060 -0400", hash_original_method = "6A41489347990CAADB010180F3DA4F08", hash_generated_method = "F7CBDE0FC3DB6982482E3182E5E24FEB")
    public  Byte(String string) throws NumberFormatException {
        this(parseByte(string));
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.061 -0400", hash_original_method = "A44A96B9BD8D4010644191EEAB137884", hash_generated_method = "BE56805F91014455969B22CAB1E3FC48")
    @Override
    public byte byteValue() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1947440111 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1947440111;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.061 -0400", hash_original_method = "BB597B75ED281325D8B4388243F4CDF9", hash_generated_method = "4813388044841C76C12F95C55845290A")
    public int compareTo(Byte object) {
        int varEB17148B4676BC6C35C2467C947D57DF_2101960590 = (compare(value, object.value));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773358274 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773358274;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.062 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "3793FACB6C7E23746BCBEAA3171B332D")
    @Override
    public double doubleValue() {
        double varE8CD7DA078A86726031AD64F35F5A6C0_911408776 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_911408776;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.062 -0400", hash_original_method = "C5FA8B05FD4F870ED8BC1DBD5FAAA797", hash_generated_method = "C7F420B206EDC38BD176DE526B70C101")
    @Override
    @FindBugsSuppressWarnings("RC_REF_COMPARISON")
    public boolean equals(Object object) {
        boolean var11D143228A346AC117970CE0F609BC62_429299674 = ((object == this) || ((object instanceof Byte) && (((Byte) object).value == value)));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1086014653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1086014653;
        // ---------- Original Method ----------
        //return (object == this) || ((object instanceof Byte) && (((Byte) object).value == value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.062 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "1788D379778993E2308EA6CBFD1CBB3A")
    @Override
    public float floatValue() {
        float var546ADE640B6EDFBC8A086EF31347E768_2104207912 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2104207912;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.066 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "078A40058413B6E7138C3CAAC4549A6F")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126957978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126957978;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.067 -0400", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "F45EFF77338FAB7CFBE7B2D241AB32D7")
    @Override
    public int intValue() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061710092 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061710092;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.067 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "2D7BFDAA61E0755B14434DA416A89F75")
    @Override
    public long longValue() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_347526013 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_347526013;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.067 -0400", hash_original_method = "C4526A740A626A32E8FE5B0C1E7B83A6", hash_generated_method = "BE7DA05831E228A426723C8834B9E52C")
    @Override
    public short shortValue() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1182811590 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1182811590;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.071 -0400", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "C8D14CCD074067B2FC47BF2DFE2878CD")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_126510090 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_126510090 = Integer.toString(value);
        varB4EAC82CA7396A68D541C85D26508E83_126510090.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_126510090;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.082 -0400", hash_original_field = "DBC4A581536433FD03C96B6E5D72EB5A", hash_generated_field = "E6E09911F0D7B8F0771504A962C4FC69")

    private static long serialVersionUID = -7183698231559129828L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.088 -0400", hash_original_field = "2434B3C976A9FAD8E750F72B62E4B63A", hash_generated_field = "0BA33D8AB14923CFCC8563593CF17893")

    public static final byte MAX_VALUE = (byte) 0x7F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.088 -0400", hash_original_field = "D76F19F370FA721763252EBCE89D5A8C", hash_generated_field = "7250F7F8A72BCB9BD36FFE6F7115CD32")

    public static final byte MIN_VALUE = (byte) 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.088 -0400", hash_original_field = "719899EE218A4CD7454FD813A94C2A64", hash_generated_field = "F24EEB984834E57CF9AD1E8B082B7AF3")

    public static final int SIZE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.088 -0400", hash_original_field = "68A1EFD0C85CB605BE6402FB6D4976EE", hash_generated_field = "339B0BC27B447AC9E571FEBE3354B6B1")

    @SuppressWarnings("unchecked")
    public static final Class<Byte> TYPE
            = (Class<Byte>) byte[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.088 -0400", hash_original_field = "F8FA46C3B8178EEEB22C6EE267E2C46C", hash_generated_field = "53128BDD24ACF1F4EAAA72626E3D242D")

    private static Byte[] VALUES = new Byte[256];
    static {
        for (int i = -128; i < 128; i++) {
            VALUES[i + 128] = new Byte((byte) i);
        }
    }
    
}

