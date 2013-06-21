package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class Double extends Number implements Comparable<Double> {
    private double value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.677 -0400", hash_original_method = "7EA95E8804ADA9698A61C51212EFD766", hash_generated_method = "28E961B6D7E9BA7D5955A5B0F3410623")
    @DSModeled(DSC.SAFE)
    public Double(double value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.677 -0400", hash_original_method = "C14717042677DE8EFE6605DB4D5CF298", hash_generated_method = "6E6983DCF64BF39EF8672CC3718F9F76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Double(String string) throws NumberFormatException {
        this(parseDouble(string));
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.677 -0400", hash_original_method = "1B85A65FB948A1CAE41CDDDF947CA953", hash_generated_method = "5E5209B3CA0C27B903290304E58CE92F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Double object) {
        dsTaint.addTaint(object.dsTaint);
        int varEB17148B4676BC6C35C2467C947D57DF_1860919321 = (compare(value, object.value));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return compare(value, object.value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.677 -0400", hash_original_method = "6B61312FC318A12A6B19178CA8B54E86", hash_generated_method = "4F78E57EE61A27A10E7A632140A3DDA6")
    @DSModeled(DSC.SAFE)
    @Override
    public byte byteValue() {
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte) value;
    }

    
        public static long doubleToLongBits(double value) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long doubleToRawLongBits(double value) {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.678 -0400", hash_original_method = "3D3B0AF18CC8081B7BB4A7DC662E1F07", hash_generated_method = "02C8EAF77A98DB2CD3BC8AC0566EBE67")
    @DSModeled(DSC.SAFE)
    @Override
    public double doubleValue() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.678 -0400", hash_original_method = "EE93E703109A76630ADBE20E58BC1ACE", hash_generated_method = "65A7FCFAE94954CDEB5697A85C4E5EDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varEDD453779E065AD25D6787B640B5D69A_1084608885 = ((object instanceof Double) &&
                (doubleToLongBits(this.value) == doubleToLongBits(((Double) object).value)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (object instanceof Double) &&
                //(doubleToLongBits(this.value) == doubleToLongBits(((Double) object).value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.678 -0400", hash_original_method = "118855AC112B739ED1B5D8D57CEDA105", hash_generated_method = "24537EFFAD87A630A8269C28DC5299E1")
    @DSModeled(DSC.SAFE)
    @Override
    public float floatValue() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (float) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.678 -0400", hash_original_method = "66DA7C954B623D2BD7B3A96EB7989DA3", hash_generated_method = "F5432EC08032429936EE8160E6849191")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        long v;
        v = doubleToLongBits(value);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //long v = doubleToLongBits(value);
        //return (int) (v ^ (v >>> 32));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.678 -0400", hash_original_method = "138584002FB2DE9D0E5B5F8DAEDB3270", hash_generated_method = "7F343EC6551F993ABCCC87486B9C3CD6")
    @DSModeled(DSC.SAFE)
    @Override
    public int intValue() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.679 -0400", hash_original_method = "82C3193F23F6D7770C948A8F860700C8", hash_generated_method = "FA891E367CDA6FC939630D3EA5B266DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInfinite() {
        boolean var505176161675C49889A0D9B13A19DD63_1122602845 = (isInfinite(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isInfinite(value);
    }

    
        public static boolean isInfinite(double d) {
        return (d == POSITIVE_INFINITY) || (d == NEGATIVE_INFINITY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.679 -0400", hash_original_method = "9E74C322CF79FFEBE378AFAB98D56D96", hash_generated_method = "128FA0E6240C621A05AC8CB9C757FA3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNaN() {
        boolean varF9DDC5BA77FDA1F62C5E4CA79A063EC0_1286251034 = (isNaN(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isNaN(value);
    }

    
        public static boolean isNaN(double d) {
        return d != d;
    }

    
        public static double longBitsToDouble(long bits) {
        return DSUtils.UNKNOWN_DOUBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.679 -0400", hash_original_method = "C9BB01BEFAD51CB3D65FBCA00F38E36E", hash_generated_method = "258C8F0A8E550593F600871FBDCC6C37")
    @DSModeled(DSC.SAFE)
    @Override
    public long longValue() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return (long) value;
    }

    
        public static double parseDouble(String string) throws NumberFormatException {
        return StringToReal.parseDouble(string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.680 -0400", hash_original_method = "8E8C16CBE89F9837B346C9544C9B6BCC", hash_generated_method = "41D347FA9B5B0AF32CD8FBD284185B0B")
    @DSModeled(DSC.SAFE)
    @Override
    public short shortValue() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return (short) value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.680 -0400", hash_original_method = "CC4885D60C7843DD614D40299C63463C", hash_generated_method = "E0E167C2F658BDFAB0020476AB7ED120")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var11DD3D30D0494DECBF2DDB1A8A6474C7_1450347366 = (Double.toString(value));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Double.toString(value);
    }

    
        public static String toString(double d) {
        return RealToString.getInstance().doubleToString(d);
    }

    
        public static Double valueOf(String string) throws NumberFormatException {
        return parseDouble(string);
    }

    
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

    
        public static Double valueOf(double d) {
        return new Double(d);
    }

    
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

    
    static final int EXPONENT_BIAS = 1023;
    static final int EXPONENT_BITS = 12;
    static final int MANTISSA_BITS = 52;
    static final int NON_MANTISSA_BITS = 12;
    static final long SIGN_MASK     = 0x8000000000000000L;
    static final long EXPONENT_MASK = 0x7ff0000000000000L;
    static final long MANTISSA_MASK = 0x000fffffffffffffL;
    private static final long serialVersionUID = -9172774392245257468L;
    public static final double MAX_VALUE = 1.79769313486231570e+308;
    public static final double MIN_VALUE = 5e-324;
    public static final double NaN = 0.0 / 0.0;
    public static final double POSITIVE_INFINITY = 1.0 / 0.0;
    public static final double NEGATIVE_INFINITY = -1.0 / 0.0;
    public static final double MIN_NORMAL = 2.2250738585072014E-308;
    public static final int MAX_EXPONENT = 1023;
    public static final int MIN_EXPONENT = -1022;
    @SuppressWarnings("unchecked") public static final Class<Double> TYPE
            = (Class<Double>) double[].class.getComponentType();
    public static final int SIZE = 64;
}

