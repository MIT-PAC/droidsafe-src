package java.lang;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public final class Double extends Number implements Comparable<Double> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.851 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "CC3A7411181F65EEC4CCC5FA5B83F90E")

    private double value;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.851 -0400", hash_original_method = "7EA95E8804ADA9698A61C51212EFD766", hash_generated_method = "3990EEE74B02A4503F84EFFAB849E6FA")
    public  Double(double value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.852 -0400", hash_original_method = "C14717042677DE8EFE6605DB4D5CF298", hash_generated_method = "7C73988AE58AF7A7F8B0B979C47A8434")
    public  Double(String string) throws NumberFormatException {
        this(parseDouble(string));
        addTaint(string.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.852 -0400", hash_original_method = "1B85A65FB948A1CAE41CDDDF947CA953", hash_generated_method = "BFA00591BD99F923CF460976336D1E3F")
    public int compareTo(Double object) {
        addTaint(object.getTaint());
        int var054767143750F894747E80D9A9324D76_559839308 = (compare(value, object.value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050879945 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050879945;
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.852 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "90ADD8522BEB47E92D313C55E865AAAA")
    @Override
    public byte byteValue() {
        byte varF3F1FD62E8C4F529180D718EF4A7CECE_632741915 = ((byte) value);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_476693268 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_476693268;
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
    @DSModeled(DSC.SAFE)
    public static long doubleToLongBits(double value) {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    public static long doubleToRawLongBits(double value) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.853 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "7BBC800434C4A0006BBA9E3EEF06851D")
    @Override
    public double doubleValue() {
        double var2063C1608D6E0BAF80249C42E2BE5804_805284866 = (value);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1518052937 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1518052937;
        // ---------- Original Method ----------
        //return value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.853 -0400", hash_original_method = "EE93E703109A76630ADBE20E58BC1ACE", hash_generated_method = "BD418F0401AF5916E80A188A5B14ECFC")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean varAA1D18A240E2887176D12FBD828B69C2_408262715 = ((object instanceof Double) &&
                (doubleToLongBits(this.value) == doubleToLongBits(((Double) object).value)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_229591373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_229591373;
        // ---------- Original Method ----------
        //return (object instanceof Double) &&
                //(doubleToLongBits(this.value) == doubleToLongBits(((Double) object).value));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.854 -0400", hash_original_method = "118855AC112B739ED1B5D8D57CEDA105", hash_generated_method = "79F64E627F553FF4B81936C66AC47982")
    @Override
    public float floatValue() {
        float var5EBD8E51B9016A257AFBE466801F6119_219083307 = ((float) value);
                float var546ADE640B6EDFBC8A086EF31347E768_1833790194 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1833790194;
        // ---------- Original Method ----------
        //return (float) value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.854 -0400", hash_original_method = "66DA7C954B623D2BD7B3A96EB7989DA3", hash_generated_method = "B2AF17BA5F5F1EDE1766D744E51842C5")
    @Override
    public int hashCode() {
        long v = doubleToLongBits(value);
        int var6CE7A3AB3701AA6E3FFDF9A565827DA7_679794667 = ((int) (v ^ (v >>> 32)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477855223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477855223;
        // ---------- Original Method ----------
        //long v = doubleToLongBits(value);
        //return (int) (v ^ (v >>> 32));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.854 -0400", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "C42B667B6FD1EF8F4F74820CD7B363B3")
    @Override
    public int intValue() {
        int varA873F4A71211BFDACBAEFBA0F9FCF91B_647909406 = ((int) value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448994647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448994647;
        // ---------- Original Method ----------
        //return (int) value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.854 -0400", hash_original_method = "82C3193F23F6D7770C948A8F860700C8", hash_generated_method = "ACAA0F93CC4DC461FD196C0ADE84F277")
    public boolean isInfinite() {
        boolean varED07AD9C4CE3E6B7E975E781387699CA_2139122280 = (isInfinite(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_404630518 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_404630518;
        // ---------- Original Method ----------
        //return isInfinite(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isInfinite(double d) {
        return (d == POSITIVE_INFINITY) || (d == NEGATIVE_INFINITY);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.855 -0400", hash_original_method = "9E74C322CF79FFEBE378AFAB98D56D96", hash_generated_method = "7C9911BA6B4D043B6545287612273B39")
    public boolean isNaN() {
        boolean varA99476A90E68FD60B10540ABE2E1DC0D_339401288 = (isNaN(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_848555148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_848555148;
        // ---------- Original Method ----------
        //return isNaN(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isNaN(double d) {
        return d != d;
    }

    
    @DSModeled(DSC.SAFE)
    public static double longBitsToDouble(long bits) {
        return DSUtils.UNKNOWN_DOUBLE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.855 -0400", hash_original_method = "C9BB01BEFAD51CB3D65FBCA00F38E36E", hash_generated_method = "DBF4DA5CB7DC965535A32F2CE14D64A1")
    @Override
    public long longValue() {
        long varFB2F999141A9BFF686902BF4F0A9690D_795556764 = ((long) value);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_646738008 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_646738008;
        // ---------- Original Method ----------
        //return (long) value;
    }

    
    @DSModeled(DSC.SAFE)
    public static double parseDouble(String string) throws NumberFormatException {
        return StringToReal.parseDouble(string);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.856 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "4ACB22C59CD63AF4133CFA614C08C0C3")
    @Override
    public short shortValue() {
        short var6C672D319E59CBACFBF678626FD3727E_1107524890 = ((short) value);
                short var4F09DAA9D95BCB166A302407A0E0BABE_941329269 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_941329269;
        // ---------- Original Method ----------
        //return (short) value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.857 -0400", hash_original_method = "CC4885D60C7843DD614D40299C63463C", hash_generated_method = "2967E0E5C53A706AD8F58312AAA7F878")
    @Override
    public String toString() {
String varD70FE175CAFA46C2C14A238B40D64876_2145834717 =         Double.toString(value);
        varD70FE175CAFA46C2C14A238B40D64876_2145834717.addTaint(taint);
        return varD70FE175CAFA46C2C14A238B40D64876_2145834717;
        // ---------- Original Method ----------
        //return Double.toString(value);
    }

    
    @DSModeled(DSC.SAFE)
    public static String toString(double d) {
        return RealToString.getInstance().doubleToString(d);
    }

    
    @DSModeled(DSC.SAFE)
    public static Double valueOf(String string) throws NumberFormatException {
        return parseDouble(string);
    }

    
    @DSModeled(DSC.SAFE)
    public static int compare(double double1, double double2) {
        if (double1 > double2) {
            return 1;
        }
        if (double2 > double1) {
            return -1;
        }
        if (double1 == double2 && 0.0d != double1) {
            return 0;
        }
        if (isNaN(double1)) {
            if (isNaN(double2)) {
                return 0;
            }
            return 1;
        } else if (isNaN(double2)) {
            return -1;
        }
        long d1 = doubleToRawLongBits(double1);
        long d2 = doubleToRawLongBits(double2);
        return (int) ((d1 >> 63) - (d2 >> 63));
    }

    
    @DSModeled(DSC.SAFE)
    public static Double valueOf(double d) {
        return new Double(d);
    }

    
    @DSModeled(DSC.SAFE)
    public static String toHexString(double d) {
        if (d != d) {
            return "NaN";
        }
        if (d == POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (d == NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        long bitValue = doubleToLongBits(d);
        boolean negative = (bitValue & 0x8000000000000000L) != 0;
        long exponent = (bitValue & 0x7FF0000000000000L) >>> 52;
        long significand = bitValue & 0x000FFFFFFFFFFFFFL;
        if (exponent == 0 && significand == 0) {
            return (negative ? "-0x0.0p0" : "0x0.0p0");
        }
        StringBuilder hexString = new StringBuilder(10);
        if (negative) {
            hexString.append("-0x");
        } else {
            hexString.append("0x");
        }
        if (exponent == 0) { 
            hexString.append("0.");
            int fractionDigits = 13;
            while ((significand != 0) && ((significand & 0xF) == 0)) {
                significand >>>= 4;
                fractionDigits--;
            }
            String hexSignificand = Long.toHexString(significand);
            if (significand != 0 && fractionDigits > hexSignificand.length()) {
                int digitDiff = fractionDigits - hexSignificand.length();
                while (digitDiff-- != 0) {
                    hexString.append('0');
                }
            }
            hexString.append(hexSignificand);
            hexString.append("p-1022");
        } else { 
            hexString.append("1.");
            int fractionDigits = 13;
            while ((significand != 0) && ((significand & 0xF) == 0)) {
                significand >>>= 4;
                fractionDigits--;
            }
            String hexSignificand = Long.toHexString(significand);
            if (significand != 0 && fractionDigits > hexSignificand.length()) {
                int digitDiff = fractionDigits - hexSignificand.length();
                while (digitDiff-- != 0) {
                    hexString.append('0');
                }
            }
            hexString.append(hexSignificand);
            hexString.append('p');
            hexString.append(Long.toString(exponent - 1023));
        }
        return hexString.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.859 -0400", hash_original_field = "464DA22D8155D79AF40AAD172ACED9BF", hash_generated_field = "7F5B63AE36FC607559921B1D63D2079E")

    static final int EXPONENT_BIAS = 1023;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.859 -0400", hash_original_field = "8D883F91929DA8D4A7F5DD139DCA5CCB", hash_generated_field = "000E54F3BA29FBD16878C04E2FD284BE")

    static final int EXPONENT_BITS = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.859 -0400", hash_original_field = "98773D6313562CE2BEEBBC0A6184AC21", hash_generated_field = "B967A752EB7E74E3CC0A175C277EF3D5")

    static final int MANTISSA_BITS = 52;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.859 -0400", hash_original_field = "2926AA157E1DBECE8B515F730CA681AD", hash_generated_field = "69AB626B8F36038530178B38518A69D1")

    static final int NON_MANTISSA_BITS = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.859 -0400", hash_original_field = "C0524C96A2C6B642B9EEC2E0CF166893", hash_generated_field = "9BA6940C2D6091320867626804E0CB6D")

    static final long SIGN_MASK = 0x8000000000000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.859 -0400", hash_original_field = "F016505AF60D057A494B4E2C1DDBA1B5", hash_generated_field = "EBAB46050B41988DC2C5DC9FB4EC64CB")

    static final long EXPONENT_MASK = 0x7ff0000000000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.860 -0400", hash_original_field = "D401B4A6724042B962D0CE90B2955459", hash_generated_field = "8169933C3C05CBB337AAC9FF554BE71F")

    static final long MANTISSA_MASK = 0x000fffffffffffffL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.860 -0400", hash_original_field = "E33FD8B2A353BCD6F94972F09A0A5B98", hash_generated_field = "2742CA755AF68701043B73DE036C7EDA")

    private static final long serialVersionUID = -9172774392245257468L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.860 -0400", hash_original_field = "E19D505E2D69A54A95DC8E9C0A97DE2D", hash_generated_field = "D7B4F6E8BA984FBCFAED1ACB27E780C2")

    public static final double MAX_VALUE = 1.79769313486231570e+308;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.860 -0400", hash_original_field = "EB1B4AA8F4CEA2C6EC65E1AB9C516EEE", hash_generated_field = "6E35A9B0BA9FEBA45F45D92AEF546455")

    public static final double MIN_VALUE = 5e-324;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.860 -0400", hash_original_field = "FC5E65788E79735D364AC4CD896F0D5D", hash_generated_field = "E3647E370B6C241672FB38DF9FDCDDF6")

    public static final double NaN = 0.0 / 0.0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.860 -0400", hash_original_field = "C2DB4F4CEBC7A964333D203D2F873FD3", hash_generated_field = "6B8F1800C8E14DB7ED360C0B33522F82")

    public static final double POSITIVE_INFINITY = 1.0 / 0.0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.860 -0400", hash_original_field = "149D12C00223F69B0778A9AD6845CB69", hash_generated_field = "CFAAFA22EF80D170F9AD8220AA6677ED")

    public static final double NEGATIVE_INFINITY = -1.0 / 0.0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.860 -0400", hash_original_field = "EFFB5493E445F217D688C2FA67DE1901", hash_generated_field = "BD4E0DFD43F13354C4EBFEC46FC809C1")

    public static final double MIN_NORMAL = 2.2250738585072014E-308;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.860 -0400", hash_original_field = "84A98AFE5735589E134D3EB248285BA3", hash_generated_field = "A3E18AE28C2AEA8DC9FC7D7193B6C46A")

    public static final int MAX_EXPONENT = 1023;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.860 -0400", hash_original_field = "22C0244C9EF1F9475F53F326B526B9ED", hash_generated_field = "B9C9CE6037D12FD54C9E8B9BBF1B837A")

    public static final int MIN_EXPONENT = -1022;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.860 -0400", hash_original_field = "6B243EBAE04E8B2BEC864826A3295DE1", hash_generated_field = "52AE33E5FC27971C510276C7051C89E9")

    @SuppressWarnings("unchecked")
    public static final Class<Double> TYPE
            = (Class<Double>) double[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.860 -0400", hash_original_field = "BEF545AA11A759CEB31C53B46631D67E", hash_generated_field = "9A4CFA4F02C5D68B7BDAB9B36D90F8D9")

    public static final int SIZE = 64;
}

