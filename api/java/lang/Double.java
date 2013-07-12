package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class Double extends Number implements Comparable<Double> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.659 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "CC3A7411181F65EEC4CCC5FA5B83F90E")

    private double value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.660 -0400", hash_original_method = "7EA95E8804ADA9698A61C51212EFD766", hash_generated_method = "3990EEE74B02A4503F84EFFAB849E6FA")
    public  Double(double value) {
        this.value = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.660 -0400", hash_original_method = "C14717042677DE8EFE6605DB4D5CF298", hash_generated_method = "7C73988AE58AF7A7F8B0B979C47A8434")
    public  Double(String string) throws NumberFormatException {
        this(parseDouble(string));
        addTaint(string.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.661 -0400", hash_original_method = "1B85A65FB948A1CAE41CDDDF947CA953", hash_generated_method = "4FF37B0E078D7D1277E9EC8657DC0599")
    public int compareTo(Double object) {
        addTaint(object.getTaint());
        int var054767143750F894747E80D9A9324D76_2118306411 = (compare(value, object.value));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1176992933 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1176992933;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.661 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "B214CB0C6AD400603642BC580AF0366C")
    @Override
    public byte byteValue() {
        byte varF3F1FD62E8C4F529180D718EF4A7CECE_1786198550 = ((byte) value);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1168020965 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1168020965;
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.663 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "B3C2FCE477EC148ACDFDC252AB25DE5E")
    @Override
    public double doubleValue() {
        double var2063C1608D6E0BAF80249C42E2BE5804_780672472 = (value);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1910024726 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1910024726;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.663 -0400", hash_original_method = "EE93E703109A76630ADBE20E58BC1ACE", hash_generated_method = "F925752A51A3FC243FF82285692E898B")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean varAA1D18A240E2887176D12FBD828B69C2_694058975 = ((object instanceof Double) &&
                (doubleToLongBits(this.value) == doubleToLongBits(((Double) object).value)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1542037438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1542037438;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.664 -0400", hash_original_method = "118855AC112B739ED1B5D8D57CEDA105", hash_generated_method = "57EFD7A51469722BF15E4FBEA88ABC08")
    @Override
    public float floatValue() {
        float var5EBD8E51B9016A257AFBE466801F6119_173341203 = ((float) value);
                float var546ADE640B6EDFBC8A086EF31347E768_45813812 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_45813812;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.664 -0400", hash_original_method = "66DA7C954B623D2BD7B3A96EB7989DA3", hash_generated_method = "E4FE985818319048C860BD82212FB956")
    @Override
    public int hashCode() {
        long v = doubleToLongBits(value);
        int var6CE7A3AB3701AA6E3FFDF9A565827DA7_636393592 = ((int) (v ^ (v >>> 32)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643759015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_643759015;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.665 -0400", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "6FB4EA5BB1C1D17B3B1BB9DAEE1C4D41")
    @Override
    public int intValue() {
        int varA873F4A71211BFDACBAEFBA0F9FCF91B_1114333587 = ((int) value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701336227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701336227;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.666 -0400", hash_original_method = "82C3193F23F6D7770C948A8F860700C8", hash_generated_method = "9DFCB6D60D920BD5F22FF368ADC374B8")
    public boolean isInfinite() {
        boolean varED07AD9C4CE3E6B7E975E781387699CA_834572003 = (isInfinite(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1072832683 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1072832683;
        
        
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean isInfinite(double d) {
        return (d == POSITIVE_INFINITY) || (d == NEGATIVE_INFINITY);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.668 -0400", hash_original_method = "9E74C322CF79FFEBE378AFAB98D56D96", hash_generated_method = "011B8CF4D1D8C541E41D7D26F32208FF")
    public boolean isNaN() {
        boolean varA99476A90E68FD60B10540ABE2E1DC0D_88396467 = (isNaN(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_45238637 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_45238637;
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.670 -0400", hash_original_method = "C9BB01BEFAD51CB3D65FBCA00F38E36E", hash_generated_method = "187EE94CC93F593427439E35225D278E")
    @Override
    public long longValue() {
        long varFB2F999141A9BFF686902BF4F0A9690D_1508971535 = ((long) value);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_951702226 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_951702226;
        
        
    }

    
        @DSModeled(DSC.SAFE)
    public static double parseDouble(String string) throws NumberFormatException {
        return StringToReal.parseDouble(string);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.671 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "F117331A8E93BF6A93CCF5AA1922C614")
    @Override
    public short shortValue() {
        short var6C672D319E59CBACFBF678626FD3727E_850401367 = ((short) value);
                short var4F09DAA9D95BCB166A302407A0E0BABE_2118924643 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_2118924643;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.671 -0400", hash_original_method = "CC4885D60C7843DD614D40299C63463C", hash_generated_method = "AA5DA0B9EA6E0441E6BA248E65DADC2E")
    @Override
    public String toString() {
String varD70FE175CAFA46C2C14A238B40D64876_1660966809 =         Double.toString(value);
        varD70FE175CAFA46C2C14A238B40D64876_1660966809.addTaint(taint);
        return varD70FE175CAFA46C2C14A238B40D64876_1660966809;
        
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.673 -0400", hash_original_field = "464DA22D8155D79AF40AAD172ACED9BF", hash_generated_field = "7F5B63AE36FC607559921B1D63D2079E")

    static final int EXPONENT_BIAS = 1023;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.673 -0400", hash_original_field = "8D883F91929DA8D4A7F5DD139DCA5CCB", hash_generated_field = "000E54F3BA29FBD16878C04E2FD284BE")

    static final int EXPONENT_BITS = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.674 -0400", hash_original_field = "98773D6313562CE2BEEBBC0A6184AC21", hash_generated_field = "B967A752EB7E74E3CC0A175C277EF3D5")

    static final int MANTISSA_BITS = 52;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.674 -0400", hash_original_field = "2926AA157E1DBECE8B515F730CA681AD", hash_generated_field = "69AB626B8F36038530178B38518A69D1")

    static final int NON_MANTISSA_BITS = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.674 -0400", hash_original_field = "C0524C96A2C6B642B9EEC2E0CF166893", hash_generated_field = "9BA6940C2D6091320867626804E0CB6D")

    static final long SIGN_MASK = 0x8000000000000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.674 -0400", hash_original_field = "F016505AF60D057A494B4E2C1DDBA1B5", hash_generated_field = "EBAB46050B41988DC2C5DC9FB4EC64CB")

    static final long EXPONENT_MASK = 0x7ff0000000000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.674 -0400", hash_original_field = "D401B4A6724042B962D0CE90B2955459", hash_generated_field = "8169933C3C05CBB337AAC9FF554BE71F")

    static final long MANTISSA_MASK = 0x000fffffffffffffL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.675 -0400", hash_original_field = "E33FD8B2A353BCD6F94972F09A0A5B98", hash_generated_field = "2742CA755AF68701043B73DE036C7EDA")

    private static final long serialVersionUID = -9172774392245257468L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.675 -0400", hash_original_field = "E19D505E2D69A54A95DC8E9C0A97DE2D", hash_generated_field = "D7B4F6E8BA984FBCFAED1ACB27E780C2")

    public static final double MAX_VALUE = 1.79769313486231570e+308;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.675 -0400", hash_original_field = "EB1B4AA8F4CEA2C6EC65E1AB9C516EEE", hash_generated_field = "6E35A9B0BA9FEBA45F45D92AEF546455")

    public static final double MIN_VALUE = 5e-324;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.675 -0400", hash_original_field = "FC5E65788E79735D364AC4CD896F0D5D", hash_generated_field = "E3647E370B6C241672FB38DF9FDCDDF6")

    public static final double NaN = 0.0 / 0.0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.675 -0400", hash_original_field = "C2DB4F4CEBC7A964333D203D2F873FD3", hash_generated_field = "6B8F1800C8E14DB7ED360C0B33522F82")

    public static final double POSITIVE_INFINITY = 1.0 / 0.0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.675 -0400", hash_original_field = "149D12C00223F69B0778A9AD6845CB69", hash_generated_field = "CFAAFA22EF80D170F9AD8220AA6677ED")

    public static final double NEGATIVE_INFINITY = -1.0 / 0.0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.676 -0400", hash_original_field = "EFFB5493E445F217D688C2FA67DE1901", hash_generated_field = "BD4E0DFD43F13354C4EBFEC46FC809C1")

    public static final double MIN_NORMAL = 2.2250738585072014E-308;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.676 -0400", hash_original_field = "84A98AFE5735589E134D3EB248285BA3", hash_generated_field = "A3E18AE28C2AEA8DC9FC7D7193B6C46A")

    public static final int MAX_EXPONENT = 1023;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.676 -0400", hash_original_field = "22C0244C9EF1F9475F53F326B526B9ED", hash_generated_field = "B9C9CE6037D12FD54C9E8B9BBF1B837A")

    public static final int MIN_EXPONENT = -1022;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.676 -0400", hash_original_field = "6B243EBAE04E8B2BEC864826A3295DE1", hash_generated_field = "52AE33E5FC27971C510276C7051C89E9")

    @SuppressWarnings("unchecked")
    public static final Class<Double> TYPE
            = (Class<Double>) double[].class.getComponentType();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.676 -0400", hash_original_field = "BEF545AA11A759CEB31C53B46631D67E", hash_generated_field = "9A4CFA4F02C5D68B7BDAB9B36D90F8D9")

    public static final int SIZE = 64;
}

