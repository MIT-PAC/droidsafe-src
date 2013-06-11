package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class TypedValue {
    public static final int TYPE_NULL = 0x00;
    public static final int TYPE_REFERENCE = 0x01;
    public static final int TYPE_ATTRIBUTE = 0x02;
    public static final int TYPE_STRING = 0x03;
    public static final int TYPE_FLOAT = 0x04;
    public static final int TYPE_DIMENSION = 0x05;
    public static final int TYPE_FRACTION = 0x06;
    public static final int TYPE_FIRST_INT = 0x10;
    public static final int TYPE_INT_DEC = 0x10;
    public static final int TYPE_INT_HEX = 0x11;
    public static final int TYPE_INT_BOOLEAN = 0x12;
    public static final int TYPE_FIRST_COLOR_INT = 0x1c;
    public static final int TYPE_INT_COLOR_ARGB8 = 0x1c;
    public static final int TYPE_INT_COLOR_RGB8 = 0x1d;
    public static final int TYPE_INT_COLOR_ARGB4 = 0x1e;
    public static final int TYPE_INT_COLOR_RGB4 = 0x1f;
    public static final int TYPE_LAST_COLOR_INT = 0x1f;
    public static final int TYPE_LAST_INT = 0x1f;
    public static final int COMPLEX_UNIT_SHIFT = 0;
    public static final int COMPLEX_UNIT_MASK = 0xf;
    public static final int COMPLEX_UNIT_PX = 0;
    public static final int COMPLEX_UNIT_DIP = 1;
    public static final int COMPLEX_UNIT_SP = 2;
    public static final int COMPLEX_UNIT_PT = 3;
    public static final int COMPLEX_UNIT_IN = 4;
    public static final int COMPLEX_UNIT_MM = 5;
    public static final int COMPLEX_UNIT_FRACTION = 0;
    public static final int COMPLEX_UNIT_FRACTION_PARENT = 1;
    public static final int COMPLEX_RADIX_SHIFT = 4;
    public static final int COMPLEX_RADIX_MASK = 0x3;
    public static final int COMPLEX_RADIX_23p0 = 0;
    public static final int COMPLEX_RADIX_16p7 = 1;
    public static final int COMPLEX_RADIX_8p15 = 2;
    public static final int COMPLEX_RADIX_0p23 = 3;
    public static final int COMPLEX_MANTISSA_SHIFT = 8;
    public static final int COMPLEX_MANTISSA_MASK = 0xffffff;
    public static final int DENSITY_DEFAULT = 0;
    public static final int DENSITY_NONE = 0xffff;
    public int type;
    public CharSequence string;
    public int data;
    public int assetCookie;
    public int resourceId;
    public int changingConfigurations = -1;
    public int density;
    private static final float MANTISSA_MULT =
        1.0f / (1<<TypedValue.COMPLEX_MANTISSA_SHIFT);
    private static final float[] RADIX_MULTS = new float[] {
        1.0f*MANTISSA_MULT, 1.0f/(1<<7)*MANTISSA_MULT,
        1.0f/(1<<15)*MANTISSA_MULT, 1.0f/(1<<23)*MANTISSA_MULT
    };
    private static final String[] DIMENSION_UNIT_STRS = new String[] {
        "px", "dip", "sp", "pt", "in", "mm"
    };
    private static final String[] FRACTION_UNIT_STRS = new String[] {
        "%", "%p"
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.717 -0400", hash_original_method = "A056539A8D172DAECD87700505289EB4", hash_generated_method = "47495AB55A9F31CD698C786A92FCB032")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getFloat() {
        float var71ABE96FD28614A5086DBB9E4C8E387F_528701650 = (Float.intBitsToFloat(data));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.717 -0400", hash_original_method = "9EFDC8C0CDD9AD4C2BE0769A6DE1F754", hash_generated_method = "7DA32D42672A3A979B15EF386B6C0755")
    public static float complexToFloat(int complex) {
        return (complex&(TypedValue.COMPLEX_MANTISSA_MASK
                   <<TypedValue.COMPLEX_MANTISSA_SHIFT))
            * RADIX_MULTS[(complex>>TypedValue.COMPLEX_RADIX_SHIFT)
                            & TypedValue.COMPLEX_RADIX_MASK];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.717 -0400", hash_original_method = "6C5A22F4663F4F9E1C302D0E30F9B0C1", hash_generated_method = "2A19386401AB30F7466CE5B7B828E6CC")
    public static float complexToDimension(int data, DisplayMetrics metrics) {
        return applyDimension(
            (data>>COMPLEX_UNIT_SHIFT)&COMPLEX_UNIT_MASK,
            complexToFloat(data),
            metrics);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.717 -0400", hash_original_method = "F8AE94A22F8AE9A752D1A750BF89FB35", hash_generated_method = "6BD6BDCD4FB6144240CC18246C77074D")
    public static int complexToDimensionPixelOffset(int data,
            DisplayMetrics metrics) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (int)applyDimension(
                (data>>COMPLEX_UNIT_SHIFT)&COMPLEX_UNIT_MASK,
                complexToFloat(data),
                metrics);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.718 -0400", hash_original_method = "1AFB790AF4C5A46BF2EC77DCAF92F5C7", hash_generated_method = "C6ACC5A4A1A43C7CCE3CE6CB1D01A659")
    public static int complexToDimensionPixelSize(int data,
            DisplayMetrics metrics) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final float value = complexToFloat(data);
        final float f = applyDimension(
                (data>>COMPLEX_UNIT_SHIFT)&COMPLEX_UNIT_MASK,
                value,
                metrics);
        final int res = (int)(f+0.5f);
        if (res != 0) return res;
        if (value == 0) return 0;
        if (value > 0) return 1;
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.718 -0400", hash_original_method = "04AD62EFCF8834E104D76228065ADCEE", hash_generated_method = "F6F4FF578CB4E6C5C3217916824C82D2")
    public static float complexToDimensionNoisy(int data, DisplayMetrics metrics) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        float res = complexToDimension(data, metrics);
        System.out.println(
            "Dimension (0x" + ((data>>TypedValue.COMPLEX_MANTISSA_SHIFT)
                               & TypedValue.COMPLEX_MANTISSA_MASK)
            + "*" + (RADIX_MULTS[(data>>TypedValue.COMPLEX_RADIX_SHIFT)
                                & TypedValue.COMPLEX_RADIX_MASK] / MANTISSA_MULT)
            + ")" + DIMENSION_UNIT_STRS[(data>>COMPLEX_UNIT_SHIFT)
                                & COMPLEX_UNIT_MASK]
            + " = " + res);
        return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.718 -0400", hash_original_method = "9888E074ABA7371BA58689FF5C9B581A", hash_generated_method = "78D8534072A5128EF4F0E9F8CF7BF382")
    public static float applyDimension(int unit, float value,
                                       DisplayMetrics metrics) {
        switch (unit) {
        case COMPLEX_UNIT_PX:
            return value;
        case COMPLEX_UNIT_DIP:
            return value * metrics.density;
        case COMPLEX_UNIT_SP:
            return value * metrics.scaledDensity;
        case COMPLEX_UNIT_PT:
            return value * metrics.xdpi * (1.0f/72);
        case COMPLEX_UNIT_IN:
            return value * metrics.xdpi;
        case COMPLEX_UNIT_MM:
            return value * metrics.xdpi * (1.0f/25.4f);
        }
        return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.718 -0400", hash_original_method = "4E6E7F41B76F4FD15549F58DC569C010", hash_generated_method = "5CEE2C3189B40A680510E5EEDB52E4EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getDimension(DisplayMetrics metrics) {
        dsTaint.addTaint(metrics.dsTaint);
        float var3370AF6D8C1322D68D158C89F7D8A021_407001908 = (complexToDimension(data, metrics));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return complexToDimension(data, metrics);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.718 -0400", hash_original_method = "FAE0D5D91A5B06A784F27BF2799820E8", hash_generated_method = "4A25C2FAB72B1BF68F6936BD952B4B63")
    public static float complexToFraction(int data, float base, float pbase) {
        switch ((data>>COMPLEX_UNIT_SHIFT)&COMPLEX_UNIT_MASK) {
        case COMPLEX_UNIT_FRACTION:
            return complexToFloat(data) * base;
        case COMPLEX_UNIT_FRACTION_PARENT:
            return complexToFloat(data) * pbase;
        }
        return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.718 -0400", hash_original_method = "293ADCB2B20AD2D3C2E6AE6F03ECAE91", hash_generated_method = "8CD32462DCBCC25CCD319708B738B0E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFraction(float base, float pbase) {
        dsTaint.addTaint(base);
        dsTaint.addTaint(pbase);
        float var8D26A233F5CDD251264B3C5CA53F7B04_1624719202 = (complexToFraction(data, base, pbase));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return complexToFraction(data, base, pbase);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.718 -0400", hash_original_method = "6C3907764C0BC2109F0045771A33B621", hash_generated_method = "E525D5FADBC0A18AA1297F04A182270C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharSequence coerceToString() {
        int t;
        t = type;
        CharSequence var6D6292CE649B798444D0A62DB694BD65_1197235108 = (coerceToString(t, data));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int t = type;
        //if (t == TYPE_STRING) {
            //return string;
        //}
        //return coerceToString(t, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.718 -0400", hash_original_method = "8BBACF31C6619A3337FF7F78CB99ABED", hash_generated_method = "F4BD6B25B60119AA0382E4C38846C082")
    public static final String coerceToString(int type, int data) {
        switch (type) {
        case TYPE_NULL:
            return null;
        case TYPE_REFERENCE:
            return "@" + data;
        case TYPE_ATTRIBUTE:
            return "?" + data;
        case TYPE_FLOAT:
            return Float.toString(Float.intBitsToFloat(data));
        case TYPE_DIMENSION:
            return Float.toString(complexToFloat(data)) + DIMENSION_UNIT_STRS[
                (data>>COMPLEX_UNIT_SHIFT)&COMPLEX_UNIT_MASK];
        case TYPE_FRACTION:
            return Float.toString(complexToFloat(data)*100) + FRACTION_UNIT_STRS[
                (data>>COMPLEX_UNIT_SHIFT)&COMPLEX_UNIT_MASK];
        case TYPE_INT_HEX:
            return "0x" + Integer.toHexString(data);
        case TYPE_INT_BOOLEAN:
            return data != 0 ? "true" : "false";
        }
        if (type >= TYPE_FIRST_COLOR_INT && type <= TYPE_LAST_COLOR_INT) {
            return "#" + Integer.toHexString(data);
        } else if (type >= TYPE_FIRST_INT && type <= TYPE_LAST_INT) {
            return Integer.toString(data);
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.718 -0400", hash_original_method = "AE1CAB20A8487EE7B21133A09B8F6C44", hash_generated_method = "5B42193DF1ED8DFD298F6CBE1C3019DC")
    @DSModeled(DSC.SAFE)
    public void setTo(TypedValue other) {
        dsTaint.addTaint(other.dsTaint);
        type = other.type;
        string = other.string;
        data = other.data;
        assetCookie = other.assetCookie;
        resourceId = other.resourceId;
        density = other.density;
        // ---------- Original Method ----------
        //type = other.type;
        //string = other.string;
        //data = other.data;
        //assetCookie = other.assetCookie;
        //resourceId = other.resourceId;
        //density = other.density;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.719 -0400", hash_original_method = "44CD89AE4BAE0041D5FF2944B149F6B9", hash_generated_method = "2B8A41C728906588DA90404FD9C16D95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("TypedValue{t=0x").append(Integer.toHexString(type));
        sb.append("/d=0x").append(Integer.toHexString(data));
        {
            sb.append(" \"").append(string != null ? string : "<null>").append("\"");
        } //End block
        {
            sb.append(" a=").append(assetCookie);
        } //End block
        {
            sb.append(" r=0x").append(Integer.toHexString(resourceId));
        } //End block
        sb.append("}");
        String var806458D832AB974D230FEE4CBBDBD390_2139180174 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append("TypedValue{t=0x").append(Integer.toHexString(type));
        //sb.append("/d=0x").append(Integer.toHexString(data));
        //if (type == TYPE_STRING) {
            //sb.append(" \"").append(string != null ? string : "<null>").append("\"");
        //}
        //if (assetCookie != 0) {
            //sb.append(" a=").append(assetCookie);
        //}
        //if (resourceId != 0) {
            //sb.append(" r=0x").append(Integer.toHexString(resourceId));
        //}
        //sb.append("}");
        //return sb.toString();
    }

    
}


