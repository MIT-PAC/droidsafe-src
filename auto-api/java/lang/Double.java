package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public final class Double extends Number implements Comparable<Double> {
    static final int EXPONENT_BIAS = 1023;
    static final int EXPONENT_BITS = 12;
    static final int MANTISSA_BITS = 52;
    static final int NON_MANTISSA_BITS = 12;
    static final long SIGN_MASK     = 0x8000000000000000L;
    static final long EXPONENT_MASK = 0x7ff0000000000000L;
    static final long MANTISSA_MASK = 0x000fffffffffffffL;
    private static final long serialVersionUID = -9172774392245257468L;
    private final double value;
    public static final double MAX_VALUE = 1.79769313486231570e+308;
    public static final double MIN_VALUE = 5e-324;
    public static final double NaN = 0.0 / 0.0;
    public static final double POSITIVE_INFINITY = 1.0 / 0.0;
    public static final double NEGATIVE_INFINITY = -1.0 / 0.0;
    public static final double MIN_NORMAL = 2.2250738585072014E-308;
    public static final int MAX_EXPONENT = 1023;
    public static final int MIN_EXPONENT = -1022;
    @SuppressWarnings("unchecked")
    public static final Class<Double> TYPE
            = (Class<Double>) double[].class.getComponentType();
    public static final int SIZE = 64;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.681 -0400", hash_original_method = "7EA95E8804ADA9698A61C51212EFD766", hash_generated_method = "C6DB84597C833F33CAAF38D30DEDB7CD")
    @DSModeled(DSC.SAFE)
    public Double(double value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.683 -0400", hash_original_method = "C14717042677DE8EFE6605DB4D5CF298", hash_generated_method = "44A7BF186EB1C0FD8A01ED2B70C1AF09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Double(String string) throws NumberFormatException {
        this(parseDouble(string));
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.685 -0400", hash_original_method = "1B85A65FB948A1CAE41CDDDF947CA953", hash_generated_method = "52C3BFC8420185B87CCFDF31B7A220EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Double object) {
        dsTaint.addTaint(object.dsTaint);
        int varEB17148B4676BC6C35C2467C947D57DF_1885471019 = (compare(value, object.value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.692 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "736992B7E67C3D999A201F9A84C24906")
    @DSModeled(DSC.SAFE)
    @Override
    public byte byteValue() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.693 -0400", hash_original_method = "102738B39C00AB089FDFEBF3A4B0137D", hash_generated_method = "8A9D7D48930E153880C3242400A8D282")
    public static long doubleToLongBits(double value) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return (long)value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.695 -0400", hash_original_method = "898239C8A5E784158B0FF1206336E849", hash_generated_method = "7EFD44BDB8E575F5ED3E2ADB6FCA5508")
    public static long doubleToRawLongBits(double value) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return (long)value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.702 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "49EEC8EBB7ED6B4F36B5020D75D881E3")
    @DSModeled(DSC.SAFE)
    @Override
    public double doubleValue() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.704 -0400", hash_original_method = "EE93E703109A76630ADBE20E58BC1ACE", hash_generated_method = "0D2A31A7807E04DAF53BBD8BCE4AB339")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varEDD453779E065AD25D6787B640B5D69A_747047415 = ((object instanceof Double) &&
                (doubleToLongBits(this.value) == doubleToLongBits(((Double) object).value)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (object instanceof Double) &&
                //(doubleToLongBits(this.value) == doubleToLongBits(((Double) object).value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.707 -0400", hash_original_method = "118855AC112B739ED1B5D8D57CEDA105", hash_generated_method = "6AF2A84BD365E2D8285B5EC160AAD9BA")
    @DSModeled(DSC.SAFE)
    @Override
    public float floatValue() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (float) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.710 -0400", hash_original_method = "66DA7C954B623D2BD7B3A96EB7989DA3", hash_generated_method = "0329BC0C5A00963ABC2BCBAA5575FBBC")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        long v;
        v = doubleToLongBits(value);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //long v = doubleToLongBits(value);
        //return (int) (v ^ (v >>> 32));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.713 -0400", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "50D86FD909925B6CFB3056BE4427F1CA")
    @DSModeled(DSC.SAFE)
    @Override
    public int intValue() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.724 -0400", hash_original_method = "82C3193F23F6D7770C948A8F860700C8", hash_generated_method = "4C255D1514CB35DF6A88FA78825547B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInfinite() {
        boolean var505176161675C49889A0D9B13A19DD63_715346164 = (isInfinite(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isInfinite(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.729 -0400", hash_original_method = "A3EC509E9519032EDFEF225EA8C949FF", hash_generated_method = "B11887FC3B6A3BAD273423365EA6BE37")
    public static boolean isInfinite(double d) {
        return (d == POSITIVE_INFINITY) || (d == NEGATIVE_INFINITY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.731 -0400", hash_original_method = "9E74C322CF79FFEBE378AFAB98D56D96", hash_generated_method = "791B23F879DC34E615FDD35DF2D41630")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNaN() {
        boolean varF9DDC5BA77FDA1F62C5E4CA79A063EC0_361743530 = (isNaN(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isNaN(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.739 -0400", hash_original_method = "A570339C802CFE5901F930FCAA1CB116", hash_generated_method = "7F8B0D286435B57612BBCABE86B8E8D3")
    public static boolean isNaN(double d) {
        return d != d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.741 -0400", hash_original_method = "720D7AE52B1B3E208CB48CB90BEACECA", hash_generated_method = "1418B956C0A9A3447501CAAF87869D84")
    public static double longBitsToDouble(long bits) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return (double)bits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.744 -0400", hash_original_method = "C9BB01BEFAD51CB3D65FBCA00F38E36E", hash_generated_method = "D35C73DB99AD5CCC98B431DBDEADE48B")
    @DSModeled(DSC.SAFE)
    @Override
    public long longValue() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return (long) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.752 -0400", hash_original_method = "25293AE596CADCBBB53C06F5AC0CC1E4", hash_generated_method = "605DFB2105E41AF97FEBDA947F8A9F93")
    public static double parseDouble(String string) throws NumberFormatException {
        return StringToReal.parseDouble(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.753 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "9D74A9F80DCC02694F100928EBEB58C3")
    @DSModeled(DSC.SAFE)
    @Override
    public short shortValue() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return (short) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.756 -0400", hash_original_method = "CC4885D60C7843DD614D40299C63463C", hash_generated_method = "46003DB5D298F279497E2A415063897C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var11DD3D30D0494DECBF2DDB1A8A6474C7_1506083753 = (Double.toString(value));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Double.toString(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.763 -0400", hash_original_method = "CC232B8CAE36CFF9A4793AA7869B9E47", hash_generated_method = "FEE36900B728A02BB946FAF254D44323")
    public static String toString(double d) {
        return RealToString.getInstance().doubleToString(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.765 -0400", hash_original_method = "56E955925627A96DCDE69BCFADC27964", hash_generated_method = "8A6643F14BD489EA94E2349ED39852F6")
    public static Double valueOf(String string) throws NumberFormatException {
        return parseDouble(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.767 -0400", hash_original_method = "16F4C4AC195BAC3086DB19C14344D828", hash_generated_method = "EDA70FBA71FEFC9DED50AF1026F67AFE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.770 -0400", hash_original_method = "B9C3A93ED4B2A822BD31B71C2B61BA78", hash_generated_method = "7F9C2DDB7260719502823F2D7E2B9678")
    public static Double valueOf(double d) {
        return new Double(d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:21:38.777 -0400", hash_original_method = "1D9798A0A4D63301EAA0C709DA651E0D", hash_generated_method = "3AD769F95755DC4156E5D1BDEC35EB6C")
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

    
}


