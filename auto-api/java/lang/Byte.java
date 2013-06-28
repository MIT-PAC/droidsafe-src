package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Byte extends Number implements Comparable<Byte> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.356 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "8CCAF7A9B8382D1617ADC5CB954C674D")

    private byte value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.357 -0400", hash_original_method = "7E64D11F2C96BA434CA992EF3846EE45", hash_generated_method = "EF48A56C44D8A8A39C1273A89D41BB2B")
    public  Byte(byte value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.357 -0400", hash_original_method = "6A41489347990CAADB010180F3DA4F08", hash_generated_method = "F7CBDE0FC3DB6982482E3182E5E24FEB")
    public  Byte(String string) throws NumberFormatException {
        this(parseByte(string));
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.358 -0400", hash_original_method = "A44A96B9BD8D4010644191EEAB137884", hash_generated_method = "85555742BC1C0DBB3A2FDC75C1B2C447")
    @Override
    public byte byteValue() {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_230819102 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_230819102;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.358 -0400", hash_original_method = "BB597B75ED281325D8B4388243F4CDF9", hash_generated_method = "9D43D1E444E682C232247C83E22C99CD")
    public int compareTo(Byte object) {
        int varEB17148B4676BC6C35C2467C947D57DF_1676994783 = (compare(value, object.value));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620234061 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620234061;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.359 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "75632171F653EF6D1215980422112F47")
    @Override
    public double doubleValue() {
        double varE8CD7DA078A86726031AD64F35F5A6C0_245101633 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_245101633;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.360 -0400", hash_original_method = "C5FA8B05FD4F870ED8BC1DBD5FAAA797", hash_generated_method = "65849A675747C122B734EDCE46500DDC")
    @Override
    @FindBugsSuppressWarnings("RC_REF_COMPARISON")
    public boolean equals(Object object) {
        boolean var11D143228A346AC117970CE0F609BC62_1027863786 = ((object == this) || ((object instanceof Byte) && (((Byte) object).value == value)));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_347672050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_347672050;
        // ---------- Original Method ----------
        //return (object == this) || ((object instanceof Byte) && (((Byte) object).value == value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.360 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "F2722A2E0C616218BC3B3868CDEE2BB3")
    @Override
    public float floatValue() {
        float var546ADE640B6EDFBC8A086EF31347E768_849624176 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_849624176;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.361 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "C797EBE91F78B1E0638703B1032839C1")
    @Override
    public int hashCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1277004860 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1277004860;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.361 -0400", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "4B6501FBA0838CDED8795CE2D1402304")
    @Override
    public int intValue() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813268695 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813268695;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.362 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "742FC1E5B2FF85198BFBB76106D3CEE0")
    @Override
    public long longValue() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_976516631 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_976516631;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.362 -0400", hash_original_method = "C4526A740A626A32E8FE5B0C1E7B83A6", hash_generated_method = "CF18051426FE0900D0F4A80223A18EB9")
    @Override
    public short shortValue() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1954310264 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1954310264;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.363 -0400", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "A4135B7E6A790EEC0B69A16E6E42B1FD")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1586999976 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1586999976 = Integer.toString(value);
        varB4EAC82CA7396A68D541C85D26508E83_1586999976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1586999976;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.363 -0400", hash_original_field = "DBC4A581536433FD03C96B6E5D72EB5A", hash_generated_field = "0B9495765198BD47B32DBC3AF8355DF1")

    private static final long serialVersionUID = -7183698231559129828L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.363 -0400", hash_original_field = "2434B3C976A9FAD8E750F72B62E4B63A", hash_generated_field = "0BA33D8AB14923CFCC8563593CF17893")

    public static final byte MAX_VALUE = (byte) 0x7F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.363 -0400", hash_original_field = "D76F19F370FA721763252EBCE89D5A8C", hash_generated_field = "7250F7F8A72BCB9BD36FFE6F7115CD32")

    public static final byte MIN_VALUE = (byte) 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.363 -0400", hash_original_field = "719899EE218A4CD7454FD813A94C2A64", hash_generated_field = "F24EEB984834E57CF9AD1E8B082B7AF3")

    public static final int SIZE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.364 -0400", hash_original_field = "68A1EFD0C85CB605BE6402FB6D4976EE", hash_generated_field = "339B0BC27B447AC9E571FEBE3354B6B1")

    @SuppressWarnings("unchecked")
    public static final Class<Byte> TYPE
            = (Class<Byte>) byte[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.364 -0400", hash_original_field = "F8FA46C3B8178EEEB22C6EE267E2C46C", hash_generated_field = "B024BB67DE07AF1FC60D295A0CC58A8E")

    private static final Byte[] VALUES = new Byte[256];
    static {
        for (int i = -128; i < 128; i++) {
            VALUES[i + 128] = new Byte((byte) i);
        }
    }
    
}

