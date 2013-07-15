package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class TypedValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.447 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public int type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.447 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "CFAED3DC6365920D99B3FF14124BC282")

    public CharSequence string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.447 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "192BA59E30228600717460D3490A8A2E")

    public int data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.447 -0400", hash_original_field = "15197B692EDA82D18257639A7B3B3FF6", hash_generated_field = "944F948888F42B582AE60E037B308E6F")

    public int assetCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.447 -0400", hash_original_field = "DDBE01C861A066CC39136CBB178AAF7D", hash_generated_field = "2A30705FC493B45DFEFFCC70485129DE")

    public int resourceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.447 -0400", hash_original_field = "5F6BE01CF19350414E2A48903E10B93A", hash_generated_field = "07F36030A8078D0478F2B26ED2B23DD2")

    public int changingConfigurations = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.447 -0400", hash_original_field = "35F3675343000D6BB5F10CE451A571A4", hash_generated_field = "E5F5E1B9EB0FFA9AA190565F78E3A1F1")

    public int density;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.447 -0400", hash_original_method = "0B58DE40EB8BF8C74A189BC20C7FD705", hash_generated_method = "0B58DE40EB8BF8C74A189BC20C7FD705")
    public TypedValue ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.448 -0400", hash_original_method = "A056539A8D172DAECD87700505289EB4", hash_generated_method = "BA2973C00BF9E64553E4B4B0FB68AAAD")
    public final float getFloat() {
        float varDB0829D96679B3E70A0CB58EAC799176_890242205 = (Float.intBitsToFloat(data));
                float var546ADE640B6EDFBC8A086EF31347E768_901360787 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_901360787;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.450 -0400", hash_original_method = "4E6E7F41B76F4FD15549F58DC569C010", hash_generated_method = "F12FDC54D18295469BDBBCA470904756")
    public float getDimension(DisplayMetrics metrics) {
        addTaint(metrics.getTaint());
        float var5C0E2B71D9BB7E63D53516F0EC676CD7_1990651540 = (complexToDimension(data, metrics));
                float var546ADE640B6EDFBC8A086EF31347E768_2074639999 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2074639999;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.450 -0400", hash_original_method = "293ADCB2B20AD2D3C2E6AE6F03ECAE91", hash_generated_method = "FDF5BB171A5925E184EAE2E3D5C4C5D7")
    public float getFraction(float base, float pbase) {
        addTaint(pbase);
        addTaint(base);
        float var4C84E76686717A5E1D39992F3B0FFAF6_2113407539 = (complexToFraction(data, base, pbase));
                float var546ADE640B6EDFBC8A086EF31347E768_1207569799 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1207569799;
        // ---------- Original Method ----------
        //return complexToFraction(data, base, pbase);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.451 -0400", hash_original_method = "6C3907764C0BC2109F0045771A33B621", hash_generated_method = "9F0D9FA19369AEEB99A879D5CCE6988F")
    public final CharSequence coerceToString() {
        int t = type;
    if(t == TYPE_STRING)        
        {
CharSequence varDCF8A90B03379D9C1C8BF337A3879E0C_2081529772 =             string;
            varDCF8A90B03379D9C1C8BF337A3879E0C_2081529772.addTaint(taint);
            return varDCF8A90B03379D9C1C8BF337A3879E0C_2081529772;
        } //End block
CharSequence varC48A172B614CE5EFF1251A722A45354E_657320663 =         coerceToString(t, data);
        varC48A172B614CE5EFF1251A722A45354E_657320663.addTaint(taint);
        return varC48A172B614CE5EFF1251A722A45354E_657320663;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.452 -0400", hash_original_method = "AE1CAB20A8487EE7B21133A09B8F6C44", hash_generated_method = "92B2774E264185FFD066BBD574CB6742")
    public void setTo(TypedValue other) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.453 -0400", hash_original_method = "44CD89AE4BAE0041D5FF2944B149F6B9", hash_generated_method = "2DC9297C1F8507F219A7FAD5806F63BD")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TypedValue{t=0x").append(Integer.toHexString(type));
        sb.append("/d=0x").append(Integer.toHexString(data));
    if(type == TYPE_STRING)        
        {
            sb.append(" \"").append(string != null ? string : "<null>").append("\"");
        } //End block
    if(assetCookie != 0)        
        {
            sb.append(" a=").append(assetCookie);
        } //End block
    if(resourceId != 0)        
        {
            sb.append(" r=0x").append(Integer.toHexString(resourceId));
        } //End block
        sb.append("}");
String var2460B846747F8B22185AD8BE722266A5_1406578387 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1406578387.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1406578387;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.453 -0400", hash_original_field = "BBDCEBAD0F6B4DB79CC89C519EE5D1DE", hash_generated_field = "FAB83A30C954D5EAF6C5E211561B8DD8")

    public static final int TYPE_NULL = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.453 -0400", hash_original_field = "FB833F62168054FADED0C37073DE0D3A", hash_generated_field = "38F44CD4A22D443E14C749C99D7B03F6")

    public static final int TYPE_REFERENCE = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.453 -0400", hash_original_field = "15542C6A5104670529AAB5082DDAF3EC", hash_generated_field = "6FEF1A3E747755944D5D0E8630E2C2B2")

    public static final int TYPE_ATTRIBUTE = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.453 -0400", hash_original_field = "E0CBD6201AE01FDA3FB3A8EA5EB5BD4D", hash_generated_field = "AE3D6575E480F857BD862A0E7EA220A4")

    public static final int TYPE_STRING = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.453 -0400", hash_original_field = "7F4A7EF1862A0D236ADAC9A6FECBB7F7", hash_generated_field = "29E44FD0B30780E4B87D99A925BBF089")

    public static final int TYPE_FLOAT = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.453 -0400", hash_original_field = "134CDFF4B0304DCB8DD9F30750A0323E", hash_generated_field = "1369701B52CEB0F3D1A0EC63B11B8D6E")

    public static final int TYPE_DIMENSION = 0x05;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.453 -0400", hash_original_field = "8BA7D7B1D34B6BD170C188C9727FA877", hash_generated_field = "833C4630F6BCC984E702D37EDB12E8ED")

    public static final int TYPE_FRACTION = 0x06;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.453 -0400", hash_original_field = "28EDABCE4CD39565E90DAB0862736EFE", hash_generated_field = "FB2B680A57176990C5D1AEEB84FF1828")

    public static final int TYPE_FIRST_INT = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.453 -0400", hash_original_field = "E01C34685DF7C921F545C326163051D0", hash_generated_field = "A110EC341689914092CFA62CC3EEB3D2")

    public static final int TYPE_INT_DEC = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.453 -0400", hash_original_field = "782D4B8D7EF8F21D5149EE8AE0CDFC62", hash_generated_field = "D9C1F3AD59438D181993E61468E13707")

    public static final int TYPE_INT_HEX = 0x11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.453 -0400", hash_original_field = "43885120A0A7109E564984EAB9BEA816", hash_generated_field = "B6FA4F653E13ACC0FFECA031B9AA8C27")

    public static final int TYPE_INT_BOOLEAN = 0x12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "395F4AE15A0E763E93C11F0A9EF82772", hash_generated_field = "EBB5D30EA9D73F6763D07CBD205902B4")

    public static final int TYPE_FIRST_COLOR_INT = 0x1c;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "B76629EB6D27E8AF8B0287394E26752E", hash_generated_field = "20AE8266726BFE88BA908EFB6C0CE43F")

    public static final int TYPE_INT_COLOR_ARGB8 = 0x1c;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "E0E041050D108E8BB5D6017927F0B6C7", hash_generated_field = "C4D9E33336D23D731B52B0DA9286658A")

    public static final int TYPE_INT_COLOR_RGB8 = 0x1d;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "F06958D4BF7179BE0257EB9EF1781DFC", hash_generated_field = "38229F174EE176B5200E5BA9D474754A")

    public static final int TYPE_INT_COLOR_ARGB4 = 0x1e;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "1A8881F7C071445EEB568E847DA64C77", hash_generated_field = "39FFF200FD4262D546B653DFBA606995")

    public static final int TYPE_INT_COLOR_RGB4 = 0x1f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "C7E833ACBF33CC77A4EF31264FD230AB", hash_generated_field = "B7CBC70B2B0599726C6DB268057B085D")

    public static final int TYPE_LAST_COLOR_INT = 0x1f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "40CA1B61668A74DD42B18394F89899FD", hash_generated_field = "2B769CA784CD7AB163514A60E14C331F")

    public static final int TYPE_LAST_INT = 0x1f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "C9CC580194CF034F4E73CFA2090DFDE2", hash_generated_field = "7EDE6ABA9388F8FDFEE6577D005BEBB8")

    public static final int COMPLEX_UNIT_SHIFT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "D53BD81E45E4A6D8432503396275BD53", hash_generated_field = "7576233DF8001236B59FF5F8B6DF21E4")

    public static final int COMPLEX_UNIT_MASK = 0xf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "929DAED4D52B3612BAC901548BB7DDB5", hash_generated_field = "D79D6548980B0D0135AABACE895F01FB")

    public static final int COMPLEX_UNIT_PX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "F68BA17F365AA22400239D5F6F160DA7", hash_generated_field = "FAB0C0B16CAF018F9F3D41EF038EC332")

    public static final int COMPLEX_UNIT_DIP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "7746F93E6D40193DFE0D5ED537EE7736", hash_generated_field = "8B3CF9A4D12B176ED389A65637AFFDC1")

    public static final int COMPLEX_UNIT_SP = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "0CC45DB80349B9E877CC0C4A9DFDDF03", hash_generated_field = "F460AE66CA4E71774F1C695735FF00E3")

    public static final int COMPLEX_UNIT_PT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "39E30E61E7F893F8009819D2B9D31D83", hash_generated_field = "D45BE86AF0B133EFBA5B4D988277C345")

    public static final int COMPLEX_UNIT_IN = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.454 -0400", hash_original_field = "73FBF59A8ECFF93D6AEB929EB914E2E9", hash_generated_field = "75619E54BA0D5936D031625C6EFAF35B")

    public static final int COMPLEX_UNIT_MM = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "290911483016470DE89093D87D643E1F", hash_generated_field = "6D8D6A24A296476C8E566FB7D1D91576")

    public static final int COMPLEX_UNIT_FRACTION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "8E600D7DB7A0BFD2CA53D1A1A993EC51", hash_generated_field = "DA35118BBC0A77778DDDB7C4E82F751B")

    public static final int COMPLEX_UNIT_FRACTION_PARENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "7EE4852DCAE345769F675BDD354CD208", hash_generated_field = "5F5466348AABE7CC3C3F3659B31EF2D4")

    public static final int COMPLEX_RADIX_SHIFT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "DA21F5DF2FC21D587CBFC3C8A88E292C", hash_generated_field = "8EDF03B5061338D3A74BC26ABB300BC7")

    public static final int COMPLEX_RADIX_MASK = 0x3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "DE4669297885AA166F2DBF7AB840547E", hash_generated_field = "2BD0A4F6EBD10CFF9E5898C148064074")

    public static final int COMPLEX_RADIX_23p0 = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "3BB356263D2CA35FEB37E00065DF42B2", hash_generated_field = "284EB73AE7AC497E9C32C025476BD790")

    public static final int COMPLEX_RADIX_16p7 = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "304B46585368E41E1D69293E89BE6B4C", hash_generated_field = "1C20E0A03D90E63067DCDC56F581BC61")

    public static final int COMPLEX_RADIX_8p15 = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "9D11D1C39E10C7D6CCD3461BB3429F3D", hash_generated_field = "8CFCF75116077EFEC228B19E70E43169")

    public static final int COMPLEX_RADIX_0p23 = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "55EE5AF1B778E7DCF387353DC2EF427D", hash_generated_field = "FBEEEEC9611D6D1F217A37104C68D53A")

    public static final int COMPLEX_MANTISSA_SHIFT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "8858F929E7BE57EE95119E0782DF9A69", hash_generated_field = "8FAB9224E953515379052AF1EB535261")

    public static final int COMPLEX_MANTISSA_MASK = 0xffffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "CC1F56922DC38C5FA3D3EF82CEE8CAC5", hash_generated_field = "BD419F64A8258497E9610704C338E564")

    public static final int DENSITY_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "5F5CD84BD00502FA444277E3CC8191F0", hash_generated_field = "BE4AB4EDD127C2D581EAF28ED755B3AC")

    public static final int DENSITY_NONE = 0xffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "AA4C91F4380ECEB180FFD7B6CBC6EF26", hash_generated_field = "816429ADA4869386A788A79FCB2E4862")

    private static final float MANTISSA_MULT = 1.0f / (1<<TypedValue.COMPLEX_MANTISSA_SHIFT);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "21DF1DD7F15079BC90002249B6687148", hash_generated_field = "83BC5619F5931FAE9E79FB481D63FD21")

    private static final float[] RADIX_MULTS = new float[] {
        1.0f*MANTISSA_MULT, 1.0f/(1<<7)*MANTISSA_MULT,
        1.0f/(1<<15)*MANTISSA_MULT, 1.0f/(1<<23)*MANTISSA_MULT
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "53107368CE8606F0D9292252C4472D1E", hash_generated_field = "10C0AF30F876AE259FC47201562554A2")

    private static final String[] DIMENSION_UNIT_STRS = new String[] {
        "px", "dip", "sp", "pt", "in", "mm"
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.455 -0400", hash_original_field = "2725CA0C395C960ABCB5EB52045C4380", hash_generated_field = "1266E200AF087EE20CA300B759679DB6")

    private static final String[] FRACTION_UNIT_STRS = new String[] {
        "%", "%p"
    };
}

