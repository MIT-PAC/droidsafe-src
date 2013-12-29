package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class TypedValue {

    /**
     * Retrieve the base value from a complex data integer.  This uses the 
     * {@link #COMPLEX_MANTISSA_MASK} and {@link #COMPLEX_RADIX_MASK} fields of 
     * the data to compute a floating point representation of the number they 
     * describe.  The units are ignored. 
     *  
     * @param complex A complex data value.
     * 
     * @return A floating point value corresponding to the complex data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.363 -0500", hash_original_method = "9EFDC8C0CDD9AD4C2BE0769A6DE1F754", hash_generated_method = "7DA32D42672A3A979B15EF386B6C0755")
    public static float complexToFloat(int complex)
    {
        return (complex&(TypedValue.COMPLEX_MANTISSA_MASK
                   <<TypedValue.COMPLEX_MANTISSA_SHIFT))
            * RADIX_MULTS[(complex>>TypedValue.COMPLEX_RADIX_SHIFT)
                            & TypedValue.COMPLEX_RADIX_MASK];
    }

    /**
     * Converts a complex data value holding a dimension to its final floating 
     * point value. The given <var>data</var> must be structured as a 
     * {@link #TYPE_DIMENSION}.
     *  
     * @param data A complex data value holding a unit, magnitude, and 
     *             mantissa.
     * @param metrics Current display metrics to use in the conversion -- 
     *                supplies display density and scaling information.
     * 
     * @return The complex floating point value multiplied by the appropriate 
     * metrics depending on its unit. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.364 -0500", hash_original_method = "6C5A22F4663F4F9E1C302D0E30F9B0C1", hash_generated_method = "2A19386401AB30F7466CE5B7B828E6CC")
    public static float complexToDimension(int data, DisplayMetrics metrics)
    {
        return applyDimension(
            (data>>COMPLEX_UNIT_SHIFT)&COMPLEX_UNIT_MASK,
            complexToFloat(data),
            metrics);
    }

    /**
     * Converts a complex data value holding a dimension to its final value
     * as an integer pixel offset.  This is the same as
     * {@link #complexToDimension}, except the raw floating point value is
     * truncated to an integer (pixel) value.
     * The given <var>data</var> must be structured as a 
     * {@link #TYPE_DIMENSION}.
     *  
     * @param data A complex data value holding a unit, magnitude, and 
     *             mantissa.
     * @param metrics Current display metrics to use in the conversion -- 
     *                supplies display density and scaling information.
     * 
     * @return The number of pixels specified by the data and its desired
     * multiplier and units.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.365 -0500", hash_original_method = "F8AE94A22F8AE9A752D1A750BF89FB35", hash_generated_method = "118DBCE5B429EB33B70269F134AEE2F7")
    public static int complexToDimensionPixelOffset(int data,
            DisplayMetrics metrics)
    {
        return (int)applyDimension(
                (data>>COMPLEX_UNIT_SHIFT)&COMPLEX_UNIT_MASK,
                complexToFloat(data),
                metrics);
    }

    /**
     * Converts a complex data value holding a dimension to its final value
     * as an integer pixel size.  This is the same as
     * {@link #complexToDimension}, except the raw floating point value is
     * converted to an integer (pixel) value for use as a size.  A size
     * conversion involves rounding the base value, and ensuring that a
     * non-zero base value is at least one pixel in size.
     * The given <var>data</var> must be structured as a 
     * {@link #TYPE_DIMENSION}.
     *  
     * @param data A complex data value holding a unit, magnitude, and 
     *             mantissa.
     * @param metrics Current display metrics to use in the conversion -- 
     *                supplies display density and scaling information.
     * 
     * @return The number of pixels specified by the data and its desired
     * multiplier and units.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.366 -0500", hash_original_method = "1AFB790AF4C5A46BF2EC77DCAF92F5C7", hash_generated_method = "A65D61A24A5C9F404D559B608474AE45")
    public static int complexToDimensionPixelSize(int data,
            DisplayMetrics metrics)
    {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.367 -0500", hash_original_method = "04AD62EFCF8834E104D76228065ADCEE", hash_generated_method = "9978C9AAC915E867A2A6C034AC911C4B")
    public static float complexToDimensionNoisy(int data, DisplayMetrics metrics)
    {
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

    /**
     * Converts an unpacked complex data value holding a dimension to its final floating 
     * point value. The two parameters <var>unit</var> and <var>value</var>
     * are as in {@link #TYPE_DIMENSION}.
     *  
     * @param unit The unit to convert from.
     * @param value The value to apply the unit to.
     * @param metrics Current display metrics to use in the conversion -- 
     *                supplies display density and scaling information.
     * 
     * @return The complex floating point value multiplied by the appropriate 
     * metrics depending on its unit. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.368 -0500", hash_original_method = "9888E074ABA7371BA58689FF5C9B581A", hash_generated_method = "78D8534072A5128EF4F0E9F8CF7BF382")
    public static float applyDimension(int unit, float value,
                                       DisplayMetrics metrics)
    {
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

    /**
     * Converts a complex data value holding a fraction to its final floating 
     * point value. The given <var>data</var> must be structured as a 
     * {@link #TYPE_FRACTION}.
     * 
     * @param data A complex data value holding a unit, magnitude, and 
     *             mantissa.
     * @param base The base value of this fraction.  In other words, a 
     *             standard fraction is multiplied by this value.
     * @param pbase The parent base value of this fraction.  In other 
     *             words, a parent fraction (nn%p) is multiplied by this
     *             value.
     * 
     * @return The complex floating point value multiplied by the appropriate 
     * base value depending on its unit. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.370 -0500", hash_original_method = "FAE0D5D91A5B06A784F27BF2799820E8", hash_generated_method = "4A25C2FAB72B1BF68F6936BD952B4B63")
    public static float complexToFraction(int data, float base, float pbase)
    {
        switch ((data>>COMPLEX_UNIT_SHIFT)&COMPLEX_UNIT_MASK) {
        case COMPLEX_UNIT_FRACTION:
            return complexToFloat(data) * base;
        case COMPLEX_UNIT_FRACTION_PARENT:
            return complexToFloat(data) * pbase;
        }
        return 0;
    }

    /**
     * Perform type conversion as per {@link #coerceToString()} on an
     * explicitly supplied type and data.
     * 
     * @param type The data type identifier.
     * @param data The data value.
     * 
     * @return String The coerced string value.  If the value is
     *         null or the type is not known, null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.374 -0500", hash_original_method = "8BBACF31C6619A3337FF7F78CB99ABED", hash_generated_method = "F4BD6B25B60119AA0382E4C38846C082")
    public static final String coerceToString(int type, int data)
    {
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.321 -0500", hash_original_field = "7DD5518512901CC92FD27194D8EC0EAA", hash_generated_field = "FAB83A30C954D5EAF6C5E211561B8DD8")

    public static final int TYPE_NULL = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.322 -0500", hash_original_field = "B9B5E25E637E6E92257447CA2C0919CB", hash_generated_field = "38F44CD4A22D443E14C749C99D7B03F6")

    public static final int TYPE_REFERENCE = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.323 -0500", hash_original_field = "E101EC6A92D0F81C54188C951B94B5C1", hash_generated_field = "6FEF1A3E747755944D5D0E8630E2C2B2")

    public static final int TYPE_ATTRIBUTE = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.324 -0500", hash_original_field = "2FFC78C77B2F6256BA2A68BC3797EDBC", hash_generated_field = "AE3D6575E480F857BD862A0E7EA220A4")

    public static final int TYPE_STRING = 0x03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.325 -0500", hash_original_field = "E416B5AA81EB809E985C46A814D9E1D8", hash_generated_field = "29E44FD0B30780E4B87D99A925BBF089")

    public static final int TYPE_FLOAT = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.326 -0500", hash_original_field = "B1170A841FABEE38AFAA2241B35E2022", hash_generated_field = "1369701B52CEB0F3D1A0EC63B11B8D6E")

    public static final int TYPE_DIMENSION = 0x05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.327 -0500", hash_original_field = "B331A6E2D45D24072ED2639FB96B2D24", hash_generated_field = "833C4630F6BCC984E702D37EDB12E8ED")

    public static final int TYPE_FRACTION = 0x06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.327 -0500", hash_original_field = "7E47E9DA46DA15D16841D0D6621D0BB3", hash_generated_field = "FB2B680A57176990C5D1AEEB84FF1828")

    public static final int TYPE_FIRST_INT = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.328 -0500", hash_original_field = "FE0E7BEE30B92AF871115762CE64CBF7", hash_generated_field = "A110EC341689914092CFA62CC3EEB3D2")

    public static final int TYPE_INT_DEC = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.329 -0500", hash_original_field = "EED8D37D7E29B793925AA48625C9B60C", hash_generated_field = "D9C1F3AD59438D181993E61468E13707")

    public static final int TYPE_INT_HEX = 0x11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.330 -0500", hash_original_field = "47A749BFC673691BDEC20E5FFE77DCD4", hash_generated_field = "B6FA4F653E13ACC0FFECA031B9AA8C27")

    public static final int TYPE_INT_BOOLEAN = 0x12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.331 -0500", hash_original_field = "FF9F578DA58F3D9F4E854D9E906DA09A", hash_generated_field = "EBB5D30EA9D73F6763D07CBD205902B4")

    public static final int TYPE_FIRST_COLOR_INT = 0x1c;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.332 -0500", hash_original_field = "A39F1E1743277AD21BA448A5F3E14245", hash_generated_field = "20AE8266726BFE88BA908EFB6C0CE43F")

    public static final int TYPE_INT_COLOR_ARGB8 = 0x1c;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.332 -0500", hash_original_field = "8DA79F03A5F6AEE8A989BB8EAE3DF50F", hash_generated_field = "C4D9E33336D23D731B52B0DA9286658A")

    public static final int TYPE_INT_COLOR_RGB8 = 0x1d;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.333 -0500", hash_original_field = "027D3B06AEA154225169F098E1572360", hash_generated_field = "38229F174EE176B5200E5BA9D474754A")

    public static final int TYPE_INT_COLOR_ARGB4 = 0x1e;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.334 -0500", hash_original_field = "51FF5F7B49A530F8DCAAC6F773D24FE6", hash_generated_field = "39FFF200FD4262D546B653DFBA606995")

    public static final int TYPE_INT_COLOR_RGB4 = 0x1f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.336 -0500", hash_original_field = "548F03136840F3264AFD33BEC869FDE9", hash_generated_field = "B7CBC70B2B0599726C6DB268057B085D")

    public static final int TYPE_LAST_COLOR_INT = 0x1f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.336 -0500", hash_original_field = "45D639DCCDB461F72EF70EE712A3FDB2", hash_generated_field = "2B769CA784CD7AB163514A60E14C331F")

    public static final int TYPE_LAST_INT = 0x1f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:13.548 -0500", hash_original_field = "BEDCE3CFE3C46F196385EE1026E98631", hash_generated_field = "7DFC0CC8D23BDC2C27CA40E98820450F")


    /** Complex data: bit location of unit information. */
    public static final int COMPLEX_UNIT_SHIFT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.338 -0500", hash_original_field = "B20CF91295E965E74D46E04AA1328574", hash_generated_field = "7576233DF8001236B59FF5F8B6DF21E4")

    public static final int COMPLEX_UNIT_MASK = 0xf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.339 -0500", hash_original_field = "596D9872DAF3CFFE7D6071258B1BD11A", hash_generated_field = "D79D6548980B0D0135AABACE895F01FB")

    public static final int COMPLEX_UNIT_PX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.340 -0500", hash_original_field = "1405772D8F5CAD03D4B3A130198EA871", hash_generated_field = "FAB0C0B16CAF018F9F3D41EF038EC332")

    public static final int COMPLEX_UNIT_DIP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.341 -0500", hash_original_field = "629B269F5E0651D9914A1E887D3E92BF", hash_generated_field = "8B3CF9A4D12B176ED389A65637AFFDC1")

    public static final int COMPLEX_UNIT_SP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.342 -0500", hash_original_field = "4FFFAB61AA99C3AA74E7246CD1563D1C", hash_generated_field = "F460AE66CA4E71774F1C695735FF00E3")

    public static final int COMPLEX_UNIT_PT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.343 -0500", hash_original_field = "CEDBC16405EF276E7D73123F20F66B7C", hash_generated_field = "D45BE86AF0B133EFBA5B4D988277C345")

    public static final int COMPLEX_UNIT_IN = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.344 -0500", hash_original_field = "417EA8E66DBA44BA1593FFD6F7C51702", hash_generated_field = "75619E54BA0D5936D031625C6EFAF35B")

    public static final int COMPLEX_UNIT_MM = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.345 -0500", hash_original_field = "FD64DA11CFD4B1CE16D0DCE6ECE9EB66", hash_generated_field = "6D8D6A24A296476C8E566FB7D1D91576")

    public static final int COMPLEX_UNIT_FRACTION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.345 -0500", hash_original_field = "7737833A8E5DDFD5869F08658CA0727D", hash_generated_field = "DA35118BBC0A77778DDDB7C4E82F751B")

    public static final int COMPLEX_UNIT_FRACTION_PARENT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.346 -0500", hash_original_field = "EFD7090C90319AB3AD20BF4740B52C60", hash_generated_field = "5F5466348AABE7CC3C3F3659B31EF2D4")

    public static final int COMPLEX_RADIX_SHIFT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.347 -0500", hash_original_field = "028217A1DDBD8176AFC0FB45DED18A10", hash_generated_field = "8EDF03B5061338D3A74BC26ABB300BC7")
 
    public static final int COMPLEX_RADIX_MASK = 0x3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.348 -0500", hash_original_field = "974E33E41E5121D1BA178A79228CEB79", hash_generated_field = "2BD0A4F6EBD10CFF9E5898C148064074")

    public static final int COMPLEX_RADIX_23p0 = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.349 -0500", hash_original_field = "0512D5BEFD79731B4170C8265CB2562F", hash_generated_field = "284EB73AE7AC497E9C32C025476BD790")

    public static final int COMPLEX_RADIX_16p7 = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.350 -0500", hash_original_field = "49F93E38045514F9C23FFEAC1FC7D24D", hash_generated_field = "1C20E0A03D90E63067DCDC56F581BC61")

    public static final int COMPLEX_RADIX_8p15 = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.351 -0500", hash_original_field = "46BBE90DFFA67BB6016964C760C72EA4", hash_generated_field = "8CFCF75116077EFEC228B19E70E43169")

    public static final int COMPLEX_RADIX_0p23 = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.352 -0500", hash_original_field = "D55352E9393A9A58A1F009F990644E75", hash_generated_field = "FBEEEEC9611D6D1F217A37104C68D53A")

    public static final int COMPLEX_MANTISSA_SHIFT = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.352 -0500", hash_original_field = "9286900EDCD5B5582C3BBBD8B6223A55", hash_generated_field = "8FAB9224E953515379052AF1EB535261")

    public static final int COMPLEX_MANTISSA_MASK = 0xffffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:13.565 -0500", hash_original_field = "9114F25CD26CBE7EFF5A7B2C5A195ADF", hash_generated_field = "7B92EA00A0CDAB4CB6F2206DBBB6354F")


    /**
     * If {@link #density} is equal to this value, then the density should be
     * treated as the system's default density value: {@link DisplayMetrics#DENSITY_DEFAULT}.
     */
    public static final int DENSITY_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.354 -0500", hash_original_field = "7DE4E2FF74F059CCE2D0D7702BDBA7B4", hash_generated_field = "BE4AB4EDD127C2D581EAF28ED755B3AC")

    public static final int DENSITY_NONE = 0xffff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.361 -0500", hash_original_field = "B227E31B5FE2E06E3AEBC15ED5BE562E", hash_generated_field = "816429ADA4869386A788A79FCB2E4862")


    private static final float MANTISSA_MULT =
        1.0f / (1<<TypedValue.COMPLEX_MANTISSA_SHIFT);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.362 -0500", hash_original_field = "417D26C77E11FA208443778B4A75C5A8", hash_generated_field = "83BC5619F5931FAE9E79FB481D63FD21")

    private static final float[] RADIX_MULTS = new float[] {
        1.0f*MANTISSA_MULT, 1.0f/(1<<7)*MANTISSA_MULT,
        1.0f/(1<<15)*MANTISSA_MULT, 1.0f/(1<<23)*MANTISSA_MULT
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.372 -0500", hash_original_field = "A40548904022F1286CC2EEDD56D6F43E", hash_generated_field = "10C0AF30F876AE259FC47201562554A2")


    private static final String[] DIMENSION_UNIT_STRS = new String[] {
        "px", "dip", "sp", "pt", "in", "mm"
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.373 -0500", hash_original_field = "92A37AEB433DBDFE59CD4B0727CE1B54", hash_generated_field = "1266E200AF087EE20CA300B759679DB6")

    private static final String[] FRACTION_UNIT_STRS = new String[] {
        "%", "%p"
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:13.566 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "C5C834E5450DA8B269EA4773C3355C0C")


    /** The type held by this value, as defined by the constants here.
     *  This tells you how to interpret the other fields in the object. */
    public int type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.356 -0500", hash_original_field = "187C0F8AF8005BE02C91FD59329D927E", hash_generated_field = "CFAED3DC6365920D99B3FF14124BC282")

    public CharSequence string;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.356 -0500", hash_original_field = "DAD87C9A7CA9D7B8B3E19B01BD33E002", hash_generated_field = "192BA59E30228600717460D3490A8A2E")

    public int data;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.357 -0500", hash_original_field = "7C6A5CDB59899F5382FBCCA7156F276E", hash_generated_field = "944F948888F42B582AE60E037B308E6F")

    public int assetCookie;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.358 -0500", hash_original_field = "51C4B58E249A64A84D6A876E56365092", hash_generated_field = "2A30705FC493B45DFEFFCC70485129DE")

    public int resourceId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.359 -0500", hash_original_field = "080A0AE6CF79C847107DC0439512372A", hash_generated_field = "07F36030A8078D0478F2B26ED2B23DD2")

    public int changingConfigurations = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.360 -0500", hash_original_field = "D7FC4F087F7781307482B1B12ECB9138", hash_generated_field = "E5F5E1B9EB0FFA9AA190565F78E3A1F1")

    public int density;
    
@DSModeled(DSC.SAFE)
    public TypedValue() {
    }

    /* ------------------------------------------------------------ */

    /** Return the data for this value as a float.  Only use for values
     *  whose type is {@link #TYPE_FLOAT}. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.360 -0500", hash_original_method = "A056539A8D172DAECD87700505289EB4", hash_generated_method = "327F456DBCCF2519D55F7061179FB0F9")
    public final float getFloat() {
        return Float.intBitsToFloat(data);
    }

    /**
     * Return the data for this value as a dimension.  Only use for values 
     * whose type is {@link #TYPE_DIMENSION}. 
     * 
     * @param metrics Current display metrics to use in the conversion -- 
     *                supplies display density and scaling information.
     * 
     * @return The complex floating point value multiplied by the appropriate 
     * metrics depending on its unit. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.369 -0500", hash_original_method = "4E6E7F41B76F4FD15549F58DC569C010", hash_generated_method = "0DC9794378F16736B8B6E505EC7B7681")
    public float getDimension(DisplayMetrics metrics)
    {
        return complexToDimension(data, metrics);
    }

    /**
     * Return the data for this value as a fraction.  Only use for values whose 
     * type is {@link #TYPE_FRACTION}. 
     * 
     * @param base The base value of this fraction.  In other words, a 
     *             standard fraction is multiplied by this value.
     * @param pbase The parent base value of this fraction.  In other 
     *             words, a parent fraction (nn%p) is multiplied by this
     *             value.
     * 
     * @return The complex floating point value multiplied by the appropriate 
     * base value depending on its unit. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.371 -0500", hash_original_method = "293ADCB2B20AD2D3C2E6AE6F03ECAE91", hash_generated_method = "2B399FDA82D9AF66EA1BEBB4A65D4087")
    public float getFraction(float base, float pbase)
    {
        return complexToFraction(data, base, pbase);
    }

    /**
     * Regardless of the actual type of the value, try to convert it to a
     * string value.  For example, a color type will be converted to a
     * string of the form #aarrggbb.
     * 
     * @return CharSequence The coerced string value.  If the value is
     *         null or the type is not known, null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.371 -0500", hash_original_method = "6C3907764C0BC2109F0045771A33B621", hash_generated_method = "FC81C9DD59488DDB92951F61D633C0C4")
    public final CharSequence coerceToString()
    {
        int t = type;
        if (t == TYPE_STRING) {
            return string;
        }
        return coerceToString(t, data);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.375 -0500", hash_original_method = "AE1CAB20A8487EE7B21133A09B8F6C44", hash_generated_method = "A7E9CBDC4F50C1D09D48207184B5E47B")
    public void setTo(TypedValue other)
    {
        type = other.type;
        string = other.string;
        data = other.data;
        assetCookie = other.assetCookie;
        resourceId = other.resourceId;
        density = other.density;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.376 -0500", hash_original_method = "44CD89AE4BAE0041D5FF2944B149F6B9", hash_generated_method = "7437CEA7D7835947FE4809D27809766F")
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("TypedValue{t=0x").append(Integer.toHexString(type));
        sb.append("/d=0x").append(Integer.toHexString(data));
        if (type == TYPE_STRING) {
            sb.append(" \"").append(string != null ? string : "<null>").append("\"");
        }
        if (assetCookie != 0) {
            sb.append(" a=").append(assetCookie);
        }
        if (resourceId != 0) {
            sb.append(" r=0x").append(Integer.toHexString(resourceId));
        }
        sb.append("}");
        return sb.toString();
    }
}

