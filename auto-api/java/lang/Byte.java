package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public final class Byte extends Number implements Comparable<Byte> {
    private static final long serialVersionUID = -7183698231559129828L;
    private final byte value;
    public static final byte MAX_VALUE = (byte) 0x7F;
    public static final byte MIN_VALUE = (byte) 0x80;
    public static final int SIZE = 8;
    @SuppressWarnings("unchecked")
    public static final Class<Byte> TYPE
            = (Class<Byte>) byte[].class.getComponentType();
    private static final Byte[] VALUES = new Byte[256];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.315 -0400", hash_original_method = "7E64D11F2C96BA434CA992EF3846EE45", hash_generated_method = "AF059DFB7BC61188E781A499E632B8B3")
    @DSModeled(DSC.SAFE)
    public Byte(byte value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.328 -0400", hash_original_method = "6A41489347990CAADB010180F3DA4F08", hash_generated_method = "E247193C468BB212E4CADEADCA5EA380")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Byte(String string) throws NumberFormatException {
        this(parseByte(string));
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.340 -0400", hash_original_method = "A44A96B9BD8D4010644191EEAB137884", hash_generated_method = "8FA9B412BAB376EF4413EA3E3323F15E")
    @DSModeled(DSC.SAFE)
    @Override
    public byte byteValue() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.344 -0400", hash_original_method = "BB597B75ED281325D8B4388243F4CDF9", hash_generated_method = "7E12CD18CFFFCBA981ACF5FCBBD126E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Byte object) {
        dsTaint.addTaint(object.dsTaint);
        int varEB17148B4676BC6C35C2467C947D57DF_1737251925 = (compare(value, object.value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.357 -0400", hash_original_method = "526CB67D9082E1052DF512ACF5AFED97", hash_generated_method = "AF1DFE575C4097C8712CFD7C9136BD0A")
    public static int compare(byte lhs, byte rhs) {
        return lhs > rhs ? 1 : (lhs < rhs ? -1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.387 -0400", hash_original_method = "FFA7DA06804046B92F2D54F8D6E8206F", hash_generated_method = "2EB97CCF14C50762CE7A9B6EFF037343")
    public static Byte decode(String string) throws NumberFormatException {
        int intValue = Integer.decode(string);
        byte result = (byte) intValue;
        if (result == intValue) {
            return valueOf(result);
        }
        throw new NumberFormatException("Value out of range for byte: \"" + string + "\"");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.396 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "49EEC8EBB7ED6B4F36B5020D75D881E3")
    @DSModeled(DSC.SAFE)
    @Override
    public double doubleValue() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.420 -0400", hash_original_method = "C5FA8B05FD4F870ED8BC1DBD5FAAA797", hash_generated_method = "BCDFF994007535413DAF82E65520358B")
    @DSModeled(DSC.SAFE)
    @Override
    @FindBugsSuppressWarnings("RC_REF_COMPARISON")
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (object == this) || ((object instanceof Byte) && (((Byte) object).value == value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.424 -0400", hash_original_method = "9E2C0918A44EC11D2232D0B603F66A6B", hash_generated_method = "DB3CE558B9651E2B1B184E75E5F9E192")
    @DSModeled(DSC.SAFE)
    @Override
    public float floatValue() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.453 -0400", hash_original_method = "961F210287166DF05D8915D632129E75", hash_generated_method = "839D1EBE643B666CA5D1F1CA10397ED1")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.463 -0400", hash_original_method = "4668226786F0223B69B1E8157F3C469B", hash_generated_method = "E67840FBE5C0D422A0583798AABFBB9C")
    @DSModeled(DSC.SAFE)
    @Override
    public int intValue() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.473 -0400", hash_original_method = "ABF4FE035C950AC910A646D4B85E3F35", hash_generated_method = "D82057610AE68E1F843DA669F2E2AAF4")
    @DSModeled(DSC.SAFE)
    @Override
    public long longValue() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.481 -0400", hash_original_method = "3E3DB9EACBAEC53C68BCBB24FE69AB14", hash_generated_method = "30051DC3AE22E7DDA2FF507800CF7FBE")
    public static byte parseByte(String string) throws NumberFormatException {
        return parseByte(string, 10);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.492 -0400", hash_original_method = "BF3D50DD939D834A7DF75489B00C6690", hash_generated_method = "DCFACEE3BA254C7BC8C98F4F5AB6DDB7")
    public static byte parseByte(String string, int radix) throws NumberFormatException {
        int intValue = Integer.parseInt(string, radix);
        byte result = (byte) intValue;
        if (result == intValue) {
            return result;
        }
        throw new NumberFormatException("Value out of range for byte: \"" + string + "\"");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.500 -0400", hash_original_method = "C4526A740A626A32E8FE5B0C1E7B83A6", hash_generated_method = "688CF6C15FAE428AF1A47A7DEBC1FC29")
    @DSModeled(DSC.SAFE)
    @Override
    public short shortValue() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.508 -0400", hash_original_method = "6B315C20A4D45816791A47779D79F014", hash_generated_method = "814758768A59CF06E55360B7EA91FAC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varD42FC0CD51582E4DF744832DA0BFE096_484808877 = (Integer.toString(value));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Integer.toString(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.520 -0400", hash_original_method = "178909B2C58CF7188A6A8BC8023FFA15", hash_generated_method = "BA098F90A3D5AA4F49CACD160D9F0877")
    public static String toHexString(byte b, boolean upperCase) {
        return IntegralToString.byteToHexString(b, upperCase);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.533 -0400", hash_original_method = "A5C9B1F940A6E4E0B7C56A8CD89F3E5B", hash_generated_method = "CF35E1D7B63D21B25C3AC38B2AA64EC0")
    public static String toString(byte value) {
        return Integer.toString(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.538 -0400", hash_original_method = "C35C42F07E6BEE21A855B7E6408FB8DD", hash_generated_method = "E186142D5A2A10E55B23D27838DD1C2D")
    public static Byte valueOf(String string) throws NumberFormatException {
        return valueOf(parseByte(string));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.548 -0400", hash_original_method = "46925E95C7BFFD2FC27FB6165D068F93", hash_generated_method = "89D01FA737447FDF0216F6FA90FA37F9")
    public static Byte valueOf(String string, int radix) throws NumberFormatException {
        return valueOf(parseByte(string, radix));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 17:44:51.561 -0400", hash_original_method = "ED2DBBC22F9957F86BC9FC2AC655A3C8", hash_generated_method = "BF35DA0FF2C2C3C53A13663AA1B29BBE")
    public static Byte valueOf(byte b) {
        return VALUES[b + 128];
    }

    
    static {
        for (int i = -128; i < 128; i++) {
            VALUES[i + 128] = new Byte((byte) i);
        }
    }
    
}


