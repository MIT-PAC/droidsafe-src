package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TypedValue {
    public int type;
    public CharSequence string;
    public int data;
    public int assetCookie;
    public int resourceId;
    public int changingConfigurations = -1;
    public int density;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.419 -0400", hash_original_method = "2B6FE45C5D0D190DDF402565B50F1873", hash_generated_method = "2B6FE45C5D0D190DDF402565B50F1873")
        public TypedValue ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.419 -0400", hash_original_method = "A056539A8D172DAECD87700505289EB4", hash_generated_method = "8DE552559A97D4F975136F28A42B31F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float getFloat() {
        float var71ABE96FD28614A5086DBB9E4C8E387F_95337855 = (Float.intBitsToFloat(data));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(data);
    }

    
        public static float complexToFloat(int complex) {
        return (complex&(TypedValue.COMPLEX_MANTISSA_MASK
                   <<TypedValue.COMPLEX_MANTISSA_SHIFT))
            * RADIX_MULTS[(complex>>TypedValue.COMPLEX_RADIX_SHIFT)
                            & TypedValue.COMPLEX_RADIX_MASK];
    }

    
        public static float complexToDimension(int data, DisplayMetrics metrics) {
        return applyDimension(
            (data>>COMPLEX_UNIT_SHIFT)&COMPLEX_UNIT_MASK,
            complexToFloat(data),
            metrics);
    }

    
        public static int complexToDimensionPixelOffset(int data,
            DisplayMetrics metrics) {
        return (int)applyDimension(
                (data>>COMPLEX_UNIT_SHIFT)&COMPLEX_UNIT_MASK,
                complexToFloat(data),
                metrics);
    }

    
        public static int complexToDimensionPixelSize(int data,
            DisplayMetrics metrics) {
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

    
        public static float complexToDimensionNoisy(int data, DisplayMetrics metrics) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.421 -0400", hash_original_method = "4E6E7F41B76F4FD15549F58DC569C010", hash_generated_method = "8AD32A451EB2BFE1C4F78C5901DEF04A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getDimension(DisplayMetrics metrics) {
        dsTaint.addTaint(metrics.dsTaint);
        float var3370AF6D8C1322D68D158C89F7D8A021_1604477282 = (complexToDimension(data, metrics));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return complexToDimension(data, metrics);
    }

    
        public static float complexToFraction(int data, float base, float pbase) {
        switch ((data>>COMPLEX_UNIT_SHIFT)&COMPLEX_UNIT_MASK) {
        case COMPLEX_UNIT_FRACTION:
            return complexToFloat(data) * base;
        case COMPLEX_UNIT_FRACTION_PARENT:
            return complexToFloat(data) * pbase;
        }
        return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.421 -0400", hash_original_method = "293ADCB2B20AD2D3C2E6AE6F03ECAE91", hash_generated_method = "BCE6A5C4145D2108245226630B7FE1AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFraction(float base, float pbase) {
        dsTaint.addTaint(base);
        dsTaint.addTaint(pbase);
        float var8D26A233F5CDD251264B3C5CA53F7B04_1086924290 = (complexToFraction(data, base, pbase));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return complexToFraction(data, base, pbase);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.421 -0400", hash_original_method = "6C3907764C0BC2109F0045771A33B621", hash_generated_method = "8EE0E2C601D9098646C1ABB1BE32E82B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharSequence coerceToString() {
        int t;
        t = type;
        CharSequence var6D6292CE649B798444D0A62DB694BD65_2134407181 = (coerceToString(t, data));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int t = type;
        //if (t == TYPE_STRING) {
            //return string;
        //}
        //return coerceToString(t, data);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.422 -0400", hash_original_method = "AE1CAB20A8487EE7B21133A09B8F6C44", hash_generated_method = "955E5A59B4CE194B364E90C1455170C4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.422 -0400", hash_original_method = "44CD89AE4BAE0041D5FF2944B149F6B9", hash_generated_method = "49D23DCEC29B7B44E9A4F80967AAC872")
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
        String var806458D832AB974D230FEE4CBBDBD390_14494882 = (sb.toString());
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
}

