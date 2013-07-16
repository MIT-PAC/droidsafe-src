package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class Byte extends Number implements Comparable<Byte> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.657 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "8CCAF7A9B8382D1617ADC5CB954C674D")

    private byte value;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.658 -0400", hash_original_method = "7E64D11F2C96BA434CA992EF3846EE45", hash_generated_method = "EF48A56C44D8A8A39C1273A89D41BB2B")
    public  Byte(byte value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.659 -0400", hash_original_method = "6A41489347990CAADB010180F3DA4F08", hash_generated_method = "F7CBDE0FC3DB6982482E3182E5E24FEB")
    public  Byte(String string) throws NumberFormatException {
        this(parseByte(string));
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.660 -0400", hash_original_method = "A44A96B9BD8D4010644191EEAB137884", hash_generated_method = "D9C7BA7D47C4FB0715F8057C432933B0")
    @Override
    public byte byteValue() {
        byte var2063C1608D6E0BAF80249C42E2BE5804_2076890545 = (value);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_529689293 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_529689293;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.661 -0400", hash_original_method = "BB597B75ED281325D8B4388243F4CDF9", hash_generated_method = "7D4A1E1810BB605AE4A8D19EC0BCC99D")
    public int compareTo(Byte object) {
        addTaint(object.getTaint());
        int var054767143750F894747E80D9A9324D76_1644355298 = (compare(value, object.value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490432496 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_490432496;
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
        @DSModeled(DSC.SAFE)
    public static int compare(byte lhs, byte rhs) {
        return lhs > rhs ? 1 : (lhs < rhs ? -1 : 0);
    }

    
        @DSModeled(DSC.SAFE)
    public static Byte decode(String string) throws NumberFormatException {
        int intValue = Integer.decode(string);
        byte result = (byte) intValue;
        if (result == intValue) {
            return valueOf(result);
        }
        throw new NumberFormatException("Value out of range for byte: \"" + string + "\"");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.665 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "FD245E4A498468DBCF41E0F1B6F39E2E")
    @Override
    public double doubleValue() {
        double var2063C1608D6E0BAF80249C42E2BE5804_943758098 = (value);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1232409825 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1232409825;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.666 -0400", hash_original_method = "C5FA8B05FD4F870ED8BC1DBD5FAAA797", hash_generated_method = "C6F15FEF12DE27A981FF5D37A8AA7AA6")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean varE8A08F741909F31FB8F0528D5AB0BE41_688128537 = ((object == this) || ((object instanceof Byte) && (((Byte) object).value == value)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1318303129 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1318303129;
        // ---------- Original Method ----------
        //return (object == this) || ((object instanceof Byte) && (((Byte) object).value == value));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.667 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "62B9CA384CB83EA9B733009CF3E4D010")
    @Override
    public float floatValue() {
        float var2063C1608D6E0BAF80249C42E2BE5804_1934662372 = (value);
                float var546ADE640B6EDFBC8A086EF31347E768_1244557165 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1244557165;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.668 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "F00BADBD20733406D29BB1296FB13F3B")
    @Override
    public int hashCode() {
        int var2063C1608D6E0BAF80249C42E2BE5804_805874647 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2036178088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2036178088;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.669 -0400", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "F8310C6070D5F857CEE7C259A1DB8C9A")
    @Override
    public int intValue() {
        int var2063C1608D6E0BAF80249C42E2BE5804_300427474 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859629859 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859629859;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.669 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "E24CE3800A049D52A1720FA75627CDF2")
    @Override
    public long longValue() {
        long var2063C1608D6E0BAF80249C42E2BE5804_668116023 = (value);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_715183533 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_715183533;
        // ---------- Original Method ----------
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
    public static byte parseByte(String string) throws NumberFormatException {
        return parseByte(string, 10);
    }

    
        @DSModeled(DSC.SAFE)
    public static byte parseByte(String string, int radix) throws NumberFormatException {
        int intValue = Integer.parseInt(string, radix);
        byte result = (byte) intValue;
        if (result == intValue) {
            return result;
        }
        throw new NumberFormatException("Value out of range for byte: \"" + string + "\"");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.671 -0400", hash_original_method = "C4526A740A626A32E8FE5B0C1E7B83A6", hash_generated_method = "42BCE37F6F9D93138D3D585A6BFCEF13")
    @Override
    public short shortValue() {
        short var2063C1608D6E0BAF80249C42E2BE5804_745277604 = (value);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1450665325 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1450665325;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.672 -0400", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "4B878DE7CDEE51397470F96E0BF7DE36")
    @Override
    public String toString() {
String var695C2C3E368F8F994F8F1E388D82E0AE_293872736 =         Integer.toString(value);
        var695C2C3E368F8F994F8F1E388D82E0AE_293872736.addTaint(taint);
        return var695C2C3E368F8F994F8F1E388D82E0AE_293872736;
        // ---------- Original Method ----------
        //return Integer.toString(value);
    }

    
        @DSModeled(DSC.SAFE)
    public static String toHexString(byte b, boolean upperCase) {
        return IntegralToString.byteToHexString(b, upperCase);
    }

    
        @DSModeled(DSC.SAFE)
    public static String toString(byte value) {
        return Integer.toString(value);
    }

    
        @DSModeled(DSC.SAFE)
    public static Byte valueOf(String string) throws NumberFormatException {
        return valueOf(parseByte(string));
    }

    
        @DSModeled(DSC.SAFE)
    public static Byte valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseByte(string, radix));
    }

    
        @DSModeled(DSC.SAFE)
    public static Byte valueOf(byte b) {
        return VALUES[b + 128];
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.674 -0400", hash_original_field = "DBC4A581536433FD03C96B6E5D72EB5A", hash_generated_field = "0B9495765198BD47B32DBC3AF8355DF1")

    private static final long serialVersionUID = -7183698231559129828L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.675 -0400", hash_original_field = "2434B3C976A9FAD8E750F72B62E4B63A", hash_generated_field = "0BA33D8AB14923CFCC8563593CF17893")

    public static final byte MAX_VALUE = (byte) 0x7F;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.675 -0400", hash_original_field = "D76F19F370FA721763252EBCE89D5A8C", hash_generated_field = "7250F7F8A72BCB9BD36FFE6F7115CD32")

    public static final byte MIN_VALUE = (byte) 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.675 -0400", hash_original_field = "719899EE218A4CD7454FD813A94C2A64", hash_generated_field = "F24EEB984834E57CF9AD1E8B082B7AF3")

    public static final int SIZE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.676 -0400", hash_original_field = "68A1EFD0C85CB605BE6402FB6D4976EE", hash_generated_field = "339B0BC27B447AC9E571FEBE3354B6B1")

    @SuppressWarnings("unchecked")
    public static final Class<Byte> TYPE
            = (Class<Byte>) byte[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.676 -0400", hash_original_field = "F8FA46C3B8178EEEB22C6EE267E2C46C", hash_generated_field = "B024BB67DE07AF1FC60D295A0CC58A8E")

    private static final Byte[] VALUES = new Byte[256];
    static {
        for (int i = -128; i < 128; i++) {
            VALUES[i + 128] = new Byte((byte) i);
        }
    }
    
}

