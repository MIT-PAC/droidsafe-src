package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import com.android.internal.util.XmlUtils;
import java.util.Arrays;

public class TypedArray {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.158 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.158 -0400", hash_original_field = "31B55396FDC1E462D428736AFE79C5F1", hash_generated_field = "5B0AA5083BE633511718F93F8CB95A91")

    XmlBlock.Parser mXml;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.158 -0400", hash_original_field = "BCD13DEF7A649738D722B3798B729E0B", hash_generated_field = "A4F8D1E493616053569BD2AC1F0ABB08")

    int[] mRsrcs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.158 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "8C2374D33A80477A0B3E51CE7EB85544")

    int[] mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.158 -0400", hash_original_field = "38E6D9E425A40CF7C8EF997F011F479F", hash_generated_field = "2BB4F4BFBD9E11898040581D9D99B4FA")

    int[] mIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.159 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "FC3D477E7B6A4ACE9A379E6E41129BD1")

    int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.159 -0400", hash_original_field = "89FC4D18C6865D9655DB03AE7EA21F19", hash_generated_field = "654366000D5436FE48B31EFBD0B3756D")

    TypedValue mValue = new TypedValue();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.160 -0400", hash_original_method = "6BEE97C5D6D0C7FC7BA11425183A3047", hash_generated_method = "32DEAC4AB87004418452846E3F423055")
      TypedArray(Resources resources, int[] data, int[] indices, int len) {
        mResources = resources;
        mData = data;
        mIndices = indices;
        mLength = len;
        // ---------- Original Method ----------
        //mResources = resources;
        //mData = data;
        //mIndices = indices;
        //mLength = len;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.160 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "5F119B44F664D14D616BB9BCB514AD26")
    public int length() {
        int var429F431E8CD8AC287AA27460675EAEFE_1796072547 = (mLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280802400 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_280802400;
        // ---------- Original Method ----------
        //return mLength;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.160 -0400", hash_original_method = "E11A0D9421BCBF5642F2B23C8115E006", hash_generated_method = "29B140B250F0375A67324D2B2DDAA313")
    public int getIndexCount() {
        int varCBCFD99B62F4085DE81B9C51AEF99317_83660806 = (mIndices[0]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735399146 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735399146;
        // ---------- Original Method ----------
        //return mIndices[0];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.161 -0400", hash_original_method = "757B3D64706707A79AF98EFF90D4FA5D", hash_generated_method = "24AB9957796BA22E4B8AE0C0D8E2BE0B")
    public int getIndex(int at) {
        addTaint(at);
        int var6A0A6F300283CFEE125F1300DD149243_878988746 = (mIndices[1+at]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120206230 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120206230;
        // ---------- Original Method ----------
        //return mIndices[1+at];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.162 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "003C8BB2A62F6D5028FEA4AE87C4CEF2")
    public Resources getResources() {
Resources var346B953D96D762F7FED561E83C1656CA_767268109 =         mResources;
        var346B953D96D762F7FED561E83C1656CA_767268109.addTaint(taint);
        return var346B953D96D762F7FED561E83C1656CA_767268109;
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.163 -0400", hash_original_method = "CED8EF4F9A9EB72D36D43738FFFAF872", hash_generated_method = "1A1294EFD661FEDF39BB8994A00123C0")
    public CharSequence getText(int index) {
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type == TypedValue.TYPE_NULL)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_1922702277 =             null;
            var540C13E9E156B687226421B24F2DF178_1922702277.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1922702277;
        } //End block
        else
        if(type == TypedValue.TYPE_STRING)        
        {
CharSequence varFE71F37E0231268B2ED63AD36D2E0D73_1528521357 =             loadStringValueAt(index);
            varFE71F37E0231268B2ED63AD36D2E0D73_1528521357.addTaint(taint);
            return varFE71F37E0231268B2ED63AD36D2E0D73_1528521357;
        } //End block
        TypedValue v = mValue;
        if(getValueAt(index, v))        
        {
CharSequence var2C8E21343D2B0A4401FE2DCD0A0846DE_2047442650 =             v.coerceToString();
            var2C8E21343D2B0A4401FE2DCD0A0846DE_2047442650.addTaint(taint);
            return var2C8E21343D2B0A4401FE2DCD0A0846DE_2047442650;
        } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_1971614534 =         null;
        var540C13E9E156B687226421B24F2DF178_1971614534.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1971614534;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //if (type == TypedValue.TYPE_NULL) {
            //return null;
        //} else if (type == TypedValue.TYPE_STRING) {
            //return loadStringValueAt(index);
        //}
        //TypedValue v = mValue;
        //if (getValueAt(index, v)) {
            //Log.w(Resources.TAG, "Converting to string: " + v);
            //return v.coerceToString();
        //}
        //Log.w(Resources.TAG, "getString of bad type: 0x"
              //+ Integer.toHexString(type));
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.164 -0400", hash_original_method = "CD99FAD2F71E14195C02F12EEC83DB33", hash_generated_method = "86769745142AEAEAACCB4F5F785D76C8")
    public String getString(int index) {
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type == TypedValue.TYPE_NULL)        
        {
String var540C13E9E156B687226421B24F2DF178_1173431755 =             null;
            var540C13E9E156B687226421B24F2DF178_1173431755.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1173431755;
        } //End block
        else
        if(type == TypedValue.TYPE_STRING)        
        {
String var64A041B790F9314358723EB5F60631DA_1171619014 =             loadStringValueAt(index).toString();
            var64A041B790F9314358723EB5F60631DA_1171619014.addTaint(taint);
            return var64A041B790F9314358723EB5F60631DA_1171619014;
        } //End block
        TypedValue v = mValue;
        if(getValueAt(index, v))        
        {
            CharSequence cs = v.coerceToString();
String var48C761D210B750355CBC7ACAC2081BD2_2107111895 =             cs != null ? cs.toString() : null;
            var48C761D210B750355CBC7ACAC2081BD2_2107111895.addTaint(taint);
            return var48C761D210B750355CBC7ACAC2081BD2_2107111895;
        } //End block
String var540C13E9E156B687226421B24F2DF178_525317366 =         null;
        var540C13E9E156B687226421B24F2DF178_525317366.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_525317366;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //if (type == TypedValue.TYPE_NULL) {
            //return null;
        //} else if (type == TypedValue.TYPE_STRING) {
            //return loadStringValueAt(index).toString();
        //}
        //TypedValue v = mValue;
        //if (getValueAt(index, v)) {
            //Log.w(Resources.TAG, "Converting to string: " + v);
            //CharSequence cs = v.coerceToString();
            //return cs != null ? cs.toString() : null;
        //}
        //Log.w(Resources.TAG, "getString of bad type: 0x"
              //+ Integer.toHexString(type));
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.165 -0400", hash_original_method = "F340A97CD447E0B03B345E238525B650", hash_generated_method = "D1C72E91D62CE7DC6C1BE875B589687D")
    public String getNonResourceString(int index) {
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type == TypedValue.TYPE_STRING)        
        {
            final int cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
            if(cookie < 0)            
            {
String varB9449F2AA54F253D8A562BA43198C02C_1047125765 =                 mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]).toString();
                varB9449F2AA54F253D8A562BA43198C02C_1047125765.addTaint(taint);
                return varB9449F2AA54F253D8A562BA43198C02C_1047125765;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_1036591203 =         null;
        var540C13E9E156B687226421B24F2DF178_1036591203.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1036591203;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //if (type == TypedValue.TYPE_STRING) {
            //final int cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
            //if (cookie < 0) {
                //return mXml.getPooledString(
                    //data[index+AssetManager.STYLE_DATA]).toString();
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.166 -0400", hash_original_method = "5032E8B6CD1C41C8B00D83016FACB488", hash_generated_method = "A3FFC58028B892D60C3CE57698D6F93C")
    public String getNonConfigurationString(int index, int allowedChangingConfigs) {
        addTaint(allowedChangingConfigs);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if((data[index+AssetManager.STYLE_CHANGING_CONFIGURATIONS]&~allowedChangingConfigs) != 0)        
        {
String var540C13E9E156B687226421B24F2DF178_599952572 =             null;
            var540C13E9E156B687226421B24F2DF178_599952572.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_599952572;
        } //End block
        if(type == TypedValue.TYPE_NULL)        
        {
String var540C13E9E156B687226421B24F2DF178_1580356650 =             null;
            var540C13E9E156B687226421B24F2DF178_1580356650.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1580356650;
        } //End block
        else
        if(type == TypedValue.TYPE_STRING)        
        {
String var64A041B790F9314358723EB5F60631DA_2062273468 =             loadStringValueAt(index).toString();
            var64A041B790F9314358723EB5F60631DA_2062273468.addTaint(taint);
            return var64A041B790F9314358723EB5F60631DA_2062273468;
        } //End block
        TypedValue v = mValue;
        if(getValueAt(index, v))        
        {
            CharSequence cs = v.coerceToString();
String var48C761D210B750355CBC7ACAC2081BD2_1233358973 =             cs != null ? cs.toString() : null;
            var48C761D210B750355CBC7ACAC2081BD2_1233358973.addTaint(taint);
            return var48C761D210B750355CBC7ACAC2081BD2_1233358973;
        } //End block
String var540C13E9E156B687226421B24F2DF178_1129027490 =         null;
        var540C13E9E156B687226421B24F2DF178_1129027490.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1129027490;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.168 -0400", hash_original_method = "A16CEE5167173C9433B0C8031B10442D", hash_generated_method = "371B3383A4BBC3F013A16FA39DE76B82")
    public boolean getBoolean(int index, boolean defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type == TypedValue.TYPE_NULL)        
        {
            boolean var0C005749B1246DFDB5F6909C34026193_774638701 = (defValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1457257614 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1457257614;
        } //End block
        else
        if(type >= TypedValue.TYPE_FIRST_INT
            && type <= TypedValue.TYPE_LAST_INT)        
        {
            boolean var0CE8B984FD52D0D9D4884EBD54C45C32_97722357 = (data[index+AssetManager.STYLE_DATA] != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_756024168 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_756024168;
        } //End block
        TypedValue v = mValue;
        if(getValueAt(index, v))        
        {
            boolean varB39FBB646575158FECB38BC18FF05BC9_1104332660 = (XmlUtils.convertValueToBoolean(
                v.coerceToString(), defValue));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_39546788 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_39546788;
        } //End block
        boolean var0C005749B1246DFDB5F6909C34026193_983891973 = (defValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69108757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_69108757;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //if (type == TypedValue.TYPE_NULL) {
            //return defValue;
        //} else if (type >= TypedValue.TYPE_FIRST_INT
            //&& type <= TypedValue.TYPE_LAST_INT) {
            //return data[index+AssetManager.STYLE_DATA] != 0;
        //}
        //TypedValue v = mValue;
        //if (getValueAt(index, v)) {
            //Log.w(Resources.TAG, "Converting to boolean: " + v);
            //return XmlUtils.convertValueToBoolean(
                //v.coerceToString(), defValue);
        //}
        //Log.w(Resources.TAG, "getBoolean of bad type: 0x"
              //+ Integer.toHexString(type));
        //return defValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.169 -0400", hash_original_method = "CE7034C3BE6468015CD54232F0A8137A", hash_generated_method = "FE23157025920A9EFBAD71F0E09C69CE")
    public int getInt(int index, int defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type == TypedValue.TYPE_NULL)        
        {
            int var0C005749B1246DFDB5F6909C34026193_1462229286 = (defValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_454160139 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_454160139;
        } //End block
        else
        if(type >= TypedValue.TYPE_FIRST_INT
            && type <= TypedValue.TYPE_LAST_INT)        
        {
            int varFDFFC91BD3522FF60D6A3BB8827668A7_1693649329 = (data[index+AssetManager.STYLE_DATA]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920014247 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920014247;
        } //End block
        TypedValue v = mValue;
        if(getValueAt(index, v))        
        {
            int var7C0F02E8C82C7DA46920D32043E092A8_543701616 = (XmlUtils.convertValueToInt(
                v.coerceToString(), defValue));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_825923820 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_825923820;
        } //End block
        int var0C005749B1246DFDB5F6909C34026193_1710290175 = (defValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1830592302 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1830592302;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //if (type == TypedValue.TYPE_NULL) {
            //return defValue;
        //} else if (type >= TypedValue.TYPE_FIRST_INT
            //&& type <= TypedValue.TYPE_LAST_INT) {
            //return data[index+AssetManager.STYLE_DATA];
        //}
        //TypedValue v = mValue;
        //if (getValueAt(index, v)) {
            //Log.w(Resources.TAG, "Converting to int: " + v);
            //return XmlUtils.convertValueToInt(
                //v.coerceToString(), defValue);
        //}
        //Log.w(Resources.TAG, "getInt of bad type: 0x"
              //+ Integer.toHexString(type));
        //return defValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.170 -0400", hash_original_method = "011758172267C9B5DEB37AE215F4E3BC", hash_generated_method = "5072C278AC0A4FA86ADA82E4CE4A4F11")
    public float getFloat(int index, float defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type == TypedValue.TYPE_NULL)        
        {
            float var0C005749B1246DFDB5F6909C34026193_82329021 = (defValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_1570281868 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1570281868;
        } //End block
        else
        if(type == TypedValue.TYPE_FLOAT)        
        {
            float varA40169C04CC424FE29909E57764E1240_2109373213 = (Float.intBitsToFloat(data[index+AssetManager.STYLE_DATA]));
                        float var546ADE640B6EDFBC8A086EF31347E768_834861165 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_834861165;
        } //End block
        else
        if(type >= TypedValue.TYPE_FIRST_INT
            && type <= TypedValue.TYPE_LAST_INT)        
        {
            float varFDFFC91BD3522FF60D6A3BB8827668A7_552898356 = (data[index+AssetManager.STYLE_DATA]);
                        float var546ADE640B6EDFBC8A086EF31347E768_1142699071 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1142699071;
        } //End block
        TypedValue v = mValue;
        if(getValueAt(index, v))        
        {
            CharSequence str = v.coerceToString();
            if(str != null)            
            {
                float var7262E3EE64C63FD62BA0CAE0EA220541_1554586566 = (Float.parseFloat(str.toString()));
                                float var546ADE640B6EDFBC8A086EF31347E768_1398762792 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1398762792;
            } //End block
        } //End block
        float var0C005749B1246DFDB5F6909C34026193_1322681164 = (defValue);
                float var546ADE640B6EDFBC8A086EF31347E768_1727320230 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1727320230;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.172 -0400", hash_original_method = "7882F59751F929311CA11EC559C5A65E", hash_generated_method = "13ADD0AF36EABDA1070EDB7E9689ECFC")
    public int getColor(int index, int defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type == TypedValue.TYPE_NULL)        
        {
            int var0C005749B1246DFDB5F6909C34026193_1657866760 = (defValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731918421 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731918421;
        } //End block
        else
        if(type >= TypedValue.TYPE_FIRST_INT
            && type <= TypedValue.TYPE_LAST_INT)        
        {
            int varFDFFC91BD3522FF60D6A3BB8827668A7_440746384 = (data[index+AssetManager.STYLE_DATA]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192273716 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_192273716;
        } //End block
        else
        if(type == TypedValue.TYPE_STRING)        
        {
            final TypedValue value = mValue;
            if(getValueAt(index, value))            
            {
                ColorStateList csl = mResources.loadColorStateList(
                        value, value.resourceId);
                int var90DA607A89399855C664ACB81336CEB7_278584384 = (csl.getDefaultColor());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896656811 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896656811;
            } //End block
            int var0C005749B1246DFDB5F6909C34026193_527838709 = (defValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086900633 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086900633;
        } //End block
        UnsupportedOperationException var71470B063586A7B6099980B20674FC5B_33428165 = new UnsupportedOperationException("Can't convert to color: type=0x"
                + Integer.toHexString(type));
        var71470B063586A7B6099980B20674FC5B_33428165.addTaint(taint);
        throw var71470B063586A7B6099980B20674FC5B_33428165;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.174 -0400", hash_original_method = "1A4CBA2C97DB5340F77B643957B9F4A1", hash_generated_method = "309909D2EB93F0C395038D4C59676CE9")
    public ColorStateList getColorStateList(int index) {
        addTaint(index);
        final TypedValue value = mValue;
        if(getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value))        
        {
ColorStateList var7C9C7C605F72EFD6C3AEEFB96F806FB5_505710280 =             mResources.loadColorStateList(value, value.resourceId);
            var7C9C7C605F72EFD6C3AEEFB96F806FB5_505710280.addTaint(taint);
            return var7C9C7C605F72EFD6C3AEEFB96F806FB5_505710280;
        } //End block
ColorStateList var540C13E9E156B687226421B24F2DF178_49388910 =         null;
        var540C13E9E156B687226421B24F2DF178_49388910.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_49388910;
        // ---------- Original Method ----------
        //final TypedValue value = mValue;
        //if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            //return mResources.loadColorStateList(value, value.resourceId);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.175 -0400", hash_original_method = "79362C29C94DC5BFF9E1A7E9D64A3B8E", hash_generated_method = "781BDCAF4301C6290818C5BA9859363C")
    public int getInteger(int index, int defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type == TypedValue.TYPE_NULL)        
        {
            int var0C005749B1246DFDB5F6909C34026193_929056689 = (defValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028166665 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028166665;
        } //End block
        else
        if(type >= TypedValue.TYPE_FIRST_INT
            && type <= TypedValue.TYPE_LAST_INT)        
        {
            int varFDFFC91BD3522FF60D6A3BB8827668A7_1914323684 = (data[index+AssetManager.STYLE_DATA]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341268805 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341268805;
        } //End block
        UnsupportedOperationException var8C8AB64BD80FA7B626E771A9DDA3439B_1424371656 = new UnsupportedOperationException("Can't convert to integer: type=0x"
                + Integer.toHexString(type));
        var8C8AB64BD80FA7B626E771A9DDA3439B_1424371656.addTaint(taint);
        throw var8C8AB64BD80FA7B626E771A9DDA3439B_1424371656;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //if (type == TypedValue.TYPE_NULL) {
            //return defValue;
        //} else if (type >= TypedValue.TYPE_FIRST_INT
            //&& type <= TypedValue.TYPE_LAST_INT) {
            //return data[index+AssetManager.STYLE_DATA];
        //}
        //throw new UnsupportedOperationException("Can't convert to integer: type=0x"
                //+ Integer.toHexString(type));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.177 -0400", hash_original_method = "C0FC3CC7AE2D97843F00F5A6AEA9712A", hash_generated_method = "B63B7E32B282862C0053A9895035C235")
    public float getDimension(int index, float defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type == TypedValue.TYPE_NULL)        
        {
            float var0C005749B1246DFDB5F6909C34026193_70367663 = (defValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_357771940 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_357771940;
        } //End block
        else
        if(type == TypedValue.TYPE_DIMENSION)        
        {
            float varC68BC678885371EC1DF2E25CF7D8D14C_488211457 = (TypedValue.complexToDimension(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
                        float var546ADE640B6EDFBC8A086EF31347E768_2107179151 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_2107179151;
        } //End block
        UnsupportedOperationException var60E90C7265C27F9135089FD1FAE1F298_1241660046 = new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        var60E90C7265C27F9135089FD1FAE1F298_1241660046.addTaint(taint);
        throw var60E90C7265C27F9135089FD1FAE1F298_1241660046;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //if (type == TypedValue.TYPE_NULL) {
            //return defValue;
        //} else if (type == TypedValue.TYPE_DIMENSION) {
            //return TypedValue.complexToDimension(
                //data[index+AssetManager.STYLE_DATA], mResources.mMetrics);
        //}
        //throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                //+ Integer.toHexString(type));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.180 -0400", hash_original_method = "77814E0587E00AA950C757CAE37F97F1", hash_generated_method = "46A4C2E6E78CD20FB7418DD2F2DE3E59")
    public int getDimensionPixelOffset(int index, int defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type == TypedValue.TYPE_NULL)        
        {
            int var0C005749B1246DFDB5F6909C34026193_428865269 = (defValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051243581 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1051243581;
        } //End block
        else
        if(type == TypedValue.TYPE_DIMENSION)        
        {
            int varB51CE27A1C43B19BB608E3E6CF9DBA8B_717094489 = (TypedValue.complexToDimensionPixelOffset(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847900092 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847900092;
        } //End block
        UnsupportedOperationException var60E90C7265C27F9135089FD1FAE1F298_964911156 = new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        var60E90C7265C27F9135089FD1FAE1F298_964911156.addTaint(taint);
        throw var60E90C7265C27F9135089FD1FAE1F298_964911156;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //if (type == TypedValue.TYPE_NULL) {
            //return defValue;
        //} else if (type == TypedValue.TYPE_DIMENSION) {
            //return TypedValue.complexToDimensionPixelOffset(
                //data[index+AssetManager.STYLE_DATA], mResources.mMetrics);
        //}
        //throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                //+ Integer.toHexString(type));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.182 -0400", hash_original_method = "FEB58959DB31428B407FA8A9132D2CB5", hash_generated_method = "1AE4559C317D712758FCBD11DB569934")
    public int getDimensionPixelSize(int index, int defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type == TypedValue.TYPE_NULL)        
        {
            int var0C005749B1246DFDB5F6909C34026193_1310102500 = (defValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1274361056 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1274361056;
        } //End block
        else
        if(type == TypedValue.TYPE_DIMENSION)        
        {
            int var8E99B144C6D8C2AA2554740CD4F18B6B_1713455546 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790915004 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790915004;
        } //End block
        UnsupportedOperationException var60E90C7265C27F9135089FD1FAE1F298_24963069 = new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        var60E90C7265C27F9135089FD1FAE1F298_24963069.addTaint(taint);
        throw var60E90C7265C27F9135089FD1FAE1F298_24963069;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //if (type == TypedValue.TYPE_NULL) {
            //return defValue;
        //} else if (type == TypedValue.TYPE_DIMENSION) {
            //return TypedValue.complexToDimensionPixelSize(
                //data[index+AssetManager.STYLE_DATA], mResources.mMetrics);
        //}
        //throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                //+ Integer.toHexString(type));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.183 -0400", hash_original_method = "DB4A9B1FF17810BF297E37812D056BD1", hash_generated_method = "CA1A6718B5D12E3DD097FC1AB9B01B20")
    public int getLayoutDimension(int index, String name) {
        addTaint(name.getTaint());
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type >= TypedValue.TYPE_FIRST_INT
                && type <= TypedValue.TYPE_LAST_INT)        
        {
            int varFDFFC91BD3522FF60D6A3BB8827668A7_218633428 = (data[index+AssetManager.STYLE_DATA]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183292506 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183292506;
        } //End block
        else
        if(type == TypedValue.TYPE_DIMENSION)        
        {
            int var8E99B144C6D8C2AA2554740CD4F18B6B_103508984 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940084741 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1940084741;
        } //End block
        RuntimeException var51FA9FB57E57B0746BFCE79AEF53EEAE_1839046239 = new RuntimeException(getPositionDescription()
                + ": You must supply a " + name + " attribute.");
        var51FA9FB57E57B0746BFCE79AEF53EEAE_1839046239.addTaint(taint);
        throw var51FA9FB57E57B0746BFCE79AEF53EEAE_1839046239;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //if (type >= TypedValue.TYPE_FIRST_INT
                //&& type <= TypedValue.TYPE_LAST_INT) {
            //return data[index+AssetManager.STYLE_DATA];
        //} else if (type == TypedValue.TYPE_DIMENSION) {
            //return TypedValue.complexToDimensionPixelSize(
                //data[index+AssetManager.STYLE_DATA], mResources.mMetrics);
        //}
        //throw new RuntimeException(getPositionDescription()
                //+ ": You must supply a " + name + " attribute.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.185 -0400", hash_original_method = "A72B2EF9D0CF1F1E691D4D81DC434823", hash_generated_method = "62464DA667F6C6BC2364A013FDB5B79C")
    public int getLayoutDimension(int index, int defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type >= TypedValue.TYPE_FIRST_INT
                && type <= TypedValue.TYPE_LAST_INT)        
        {
            int varFDFFC91BD3522FF60D6A3BB8827668A7_588751355 = (data[index+AssetManager.STYLE_DATA]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587926059 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1587926059;
        } //End block
        else
        if(type == TypedValue.TYPE_DIMENSION)        
        {
            int var8E99B144C6D8C2AA2554740CD4F18B6B_1129928444 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607298381 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607298381;
        } //End block
        int var0C005749B1246DFDB5F6909C34026193_701796123 = (defValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445525900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445525900;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //if (type >= TypedValue.TYPE_FIRST_INT
                //&& type <= TypedValue.TYPE_LAST_INT) {
            //return data[index+AssetManager.STYLE_DATA];
        //} else if (type == TypedValue.TYPE_DIMENSION) {
            //return TypedValue.complexToDimensionPixelSize(
                //data[index+AssetManager.STYLE_DATA], mResources.mMetrics);
        //}
        //return defValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.186 -0400", hash_original_method = "57D8AC3F2B2D48B77A0EB4868F247839", hash_generated_method = "1B579EC6797E9F63005533A0A321EAF1")
    public float getFraction(int index, int base, int pbase, float defValue) {
        addTaint(defValue);
        addTaint(pbase);
        addTaint(base);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type == TypedValue.TYPE_NULL)        
        {
            float var0C005749B1246DFDB5F6909C34026193_1705556290 = (defValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_1519895619 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1519895619;
        } //End block
        else
        if(type == TypedValue.TYPE_FRACTION)        
        {
            float var8A54764FBAFB3D02129FEF8A8E5CA579_1774393820 = (TypedValue.complexToFraction(
                data[index+AssetManager.STYLE_DATA], base, pbase));
                        float var546ADE640B6EDFBC8A086EF31347E768_1919960158 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1919960158;
        } //End block
        UnsupportedOperationException varCF896F22EB53276BC9ADA3E6A43FC9FA_1900785390 = new UnsupportedOperationException("Can't convert to fraction: type=0x"
                + Integer.toHexString(type));
        varCF896F22EB53276BC9ADA3E6A43FC9FA_1900785390.addTaint(taint);
        throw varCF896F22EB53276BC9ADA3E6A43FC9FA_1900785390;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //if (type == TypedValue.TYPE_NULL) {
            //return defValue;
        //} else if (type == TypedValue.TYPE_FRACTION) {
            //return TypedValue.complexToFraction(
                //data[index+AssetManager.STYLE_DATA], base, pbase);
        //}
        //throw new UnsupportedOperationException("Can't convert to fraction: type=0x"
                //+ Integer.toHexString(type));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.187 -0400", hash_original_method = "DF47714E2511EE2CB8E5736FC0D36FFE", hash_generated_method = "25275C2193838EDF20EFAC8724B541FC")
    public int getResourceId(int index, int defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        if(data[index+AssetManager.STYLE_TYPE] != TypedValue.TYPE_NULL)        
        {
            final int resid = data[index+AssetManager.STYLE_RESOURCE_ID];
            if(resid != 0)            
            {
                int var9C5DC71F9C3AB4FEBAA17E7B42553A5B_70059596 = (resid);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733793650 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1733793650;
            } //End block
        } //End block
        int var0C005749B1246DFDB5F6909C34026193_1956131047 = (defValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1985458317 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1985458317;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //if (data[index+AssetManager.STYLE_TYPE] != TypedValue.TYPE_NULL) {
            //final int resid = data[index+AssetManager.STYLE_RESOURCE_ID];
            //if (resid != 0) {
                //return resid;
            //}
        //}
        //return defValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.188 -0400", hash_original_method = "4764631566003CBA3FBDF6AEC7E40184", hash_generated_method = "B0F79E93CEE2A783B4DAC2241B513CBD")
    public Drawable getDrawable(int index) {
        addTaint(index);
        final TypedValue value = mValue;
        if(getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value))        
        {
            if(false)            
            {
                System.out.println("******************************************************************");
                System.out.println("Got drawable resource: type="
                                   + value.type
                                   + " str=" + value.string
                                   + " int=0x" + Integer.toHexString(value.data)
                                   + " cookie=" + value.assetCookie);
                System.out.println("******************************************************************");
            } //End block
Drawable var9CD9F2C7F5CF532C97D6207826992225_176694828 =             mResources.loadDrawable(value, value.resourceId);
            var9CD9F2C7F5CF532C97D6207826992225_176694828.addTaint(taint);
            return var9CD9F2C7F5CF532C97D6207826992225_176694828;
        } //End block
Drawable var540C13E9E156B687226421B24F2DF178_1415811499 =         null;
        var540C13E9E156B687226421B24F2DF178_1415811499.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1415811499;
        // ---------- Original Method ----------
        //final TypedValue value = mValue;
        //if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            //if (false) {
                //System.out.println("******************************************************************");
                //System.out.println("Got drawable resource: type="
                                   //+ value.type
                                   //+ " str=" + value.string
                                   //+ " int=0x" + Integer.toHexString(value.data)
                                   //+ " cookie=" + value.assetCookie);
                //System.out.println("******************************************************************");
            //}
            //return mResources.loadDrawable(value, value.resourceId);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.189 -0400", hash_original_method = "DE841974CEC89F1656E36D821FAC9EE9", hash_generated_method = "062F32BB5B4230D307B31B3F59B0D903")
    public CharSequence[] getTextArray(int index) {
        addTaint(index);
        final TypedValue value = mValue;
        if(getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value))        
        {
            if(false)            
            {
                System.out.println("******************************************************************");
                System.out.println("Got drawable resource: type="
                                   + value.type
                                   + " str=" + value.string
                                   + " int=0x" + Integer.toHexString(value.data)
                                   + " cookie=" + value.assetCookie);
                System.out.println("******************************************************************");
            } //End block
CharSequence[] var9B185D6E2C129A747CB021868828E1FB_805808040 =             mResources.getTextArray(value.resourceId);
            var9B185D6E2C129A747CB021868828E1FB_805808040.addTaint(taint);
            return var9B185D6E2C129A747CB021868828E1FB_805808040;
        } //End block
CharSequence[] var540C13E9E156B687226421B24F2DF178_732027731 =         null;
        var540C13E9E156B687226421B24F2DF178_732027731.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_732027731;
        // ---------- Original Method ----------
        //final TypedValue value = mValue;
        //if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            //if (false) {
                //System.out.println("******************************************************************");
                //System.out.println("Got drawable resource: type="
                                   //+ value.type
                                   //+ " str=" + value.string
                                   //+ " int=0x" + Integer.toHexString(value.data)
                                   //+ " cookie=" + value.assetCookie);
                //System.out.println("******************************************************************");
            //}
            //return mResources.getTextArray(value.resourceId);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.190 -0400", hash_original_method = "0C857F8AC76CD5CFBE7569B581103BDD", hash_generated_method = "FD1BA5E5AC92F38C533439A9329841F9")
    public boolean getValue(int index, TypedValue outValue) {
        addTaint(outValue.getTaint());
        addTaint(index);
        boolean var22F6889BB5F70FB4653E25BBBCB03D57_1805847754 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1570489077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1570489077;
        // ---------- Original Method ----------
        //return getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.191 -0400", hash_original_method = "0EF762AB49E40F4FF6959DF2595733A2", hash_generated_method = "59CAD3B264892F2C434DE3061036CC69")
    public boolean hasValue(int index) {
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        boolean var8F37846CC3DB18B76C036D1B7DA857FE_1723118373 = (type != TypedValue.TYPE_NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_706863998 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_706863998;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //return type != TypedValue.TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.192 -0400", hash_original_method = "0D8F28067488CFE0F25A0D66713982F4", hash_generated_method = "2F9DCF5B586EBCE677190C979FC1509A")
    public TypedValue peekValue(int index) {
        addTaint(index);
        final TypedValue value = mValue;
        if(getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value))        
        {
TypedValue varAF280DA2BC37D8BE783D8499160168DE_1179150193 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_1179150193.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_1179150193;
        } //End block
TypedValue var540C13E9E156B687226421B24F2DF178_1108920510 =         null;
        var540C13E9E156B687226421B24F2DF178_1108920510.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1108920510;
        // ---------- Original Method ----------
        //final TypedValue value = mValue;
        //if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            //return value;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.193 -0400", hash_original_method = "C2A30811E6FAA7EEAF3DDEC09CF05D3C", hash_generated_method = "1102034F0133234885B0DE93A1CE6413")
    public String getPositionDescription() {
String var71429891338B1C00981D47483975D6BA_752087142 =         mXml != null ? mXml.getPositionDescription() : "<internal>";
        var71429891338B1C00981D47483975D6BA_752087142.addTaint(taint);
        return var71429891338B1C00981D47483975D6BA_752087142;
        // ---------- Original Method ----------
        //return mXml != null ? mXml.getPositionDescription() : "<internal>";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.193 -0400", hash_original_method = "A1E6C58584B412829C21C498310464D0", hash_generated_method = "E2D95A3B760CCDC32B6CA5663CCFF342")
    public void recycle() {
        synchronized
(mResources.mTmpValue)        {
            TypedArray cached = mResources.mCachedStyledAttributes;
            if(cached == null || cached.mData.length < mData.length)            
            {
                mXml = null;
                mResources.mCachedStyledAttributes = this;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mResources.mTmpValue) {
            //TypedArray cached = mResources.mCachedStyledAttributes;
            //if (cached == null || cached.mData.length < mData.length) {
                //mXml = null;
                //mResources.mCachedStyledAttributes = this;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.196 -0400", hash_original_method = "7C5221C979A46E52D6E71FCE8A161B4A", hash_generated_method = "AD1B8A0D263BB7699931C6F9EA50F320")
    private boolean getValueAt(int index, TypedValue outValue) {
        addTaint(outValue.getTaint());
        addTaint(index);
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if(type == TypedValue.TYPE_NULL)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1413808687 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972269212 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_972269212;
        } //End block
        outValue.type = type;
        outValue.data = data[index+AssetManager.STYLE_DATA];
        outValue.assetCookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        outValue.resourceId = data[index+AssetManager.STYLE_RESOURCE_ID];
        outValue.changingConfigurations = data[index+AssetManager.STYLE_CHANGING_CONFIGURATIONS];
        outValue.density = data[index+AssetManager.STYLE_DENSITY];
        outValue.string = (type == TypedValue.TYPE_STRING) ? loadStringValueAt(index) : null;
        boolean varB326B5062B2F0E69046810717534CB09_366892871 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1209445830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1209445830;
        // ---------- Original Method ----------
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //if (type == TypedValue.TYPE_NULL) {
            //return false;
        //}
        //outValue.type = type;
        //outValue.data = data[index+AssetManager.STYLE_DATA];
        //outValue.assetCookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        //outValue.resourceId = data[index+AssetManager.STYLE_RESOURCE_ID];
        //outValue.changingConfigurations = data[index+AssetManager.STYLE_CHANGING_CONFIGURATIONS];
        //outValue.density = data[index+AssetManager.STYLE_DENSITY];
        //outValue.string = (type == TypedValue.TYPE_STRING) ? loadStringValueAt(index) : null;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.197 -0400", hash_original_method = "9EED998F765658475A56DE41DA4AC13D", hash_generated_method = "8F2DDEBA103E8FAB6E1C11E0DA22E33D")
    private CharSequence loadStringValueAt(int index) {
        addTaint(index);
        final int[] data = mData;
        final int cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        if(cookie < 0)        
        {
            if(mXml != null)            
            {
CharSequence var1909CA0A0B5F4C1B88AD901A4800961A_735147999 =                 mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]);
                var1909CA0A0B5F4C1B88AD901A4800961A_735147999.addTaint(taint);
                return var1909CA0A0B5F4C1B88AD901A4800961A_735147999;
            } //End block
CharSequence var540C13E9E156B687226421B24F2DF178_1654616293 =             null;
            var540C13E9E156B687226421B24F2DF178_1654616293.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1654616293;
        } //End block
CharSequence var13AA805861FD730A1B588C60D1E7C7D9_339830187 =         mResources.mAssets.getPooledString(
            cookie, data[index+AssetManager.STYLE_DATA]);
        var13AA805861FD730A1B588C60D1E7C7D9_339830187.addTaint(taint);
        return var13AA805861FD730A1B588C60D1E7C7D9_339830187;
        // ---------- Original Method ----------
        //final int[] data = mData;
        //final int cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        //if (cookie < 0) {
            //if (mXml != null) {
                //return mXml.getPooledString(
                    //data[index+AssetManager.STYLE_DATA]);
            //}
            //return null;
        //}
        //return mResources.mAssets.getPooledString(
            //cookie, data[index+AssetManager.STYLE_DATA]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.198 -0400", hash_original_method = "D3700358536036842F849ADB987A26DD", hash_generated_method = "DE5DBCA09472ED4D40320A851DE9A343")
    public String toString() {
String var4F18F58D2FA16042CB301516796544BC_1756078858 =         Arrays.toString(mData);
        var4F18F58D2FA16042CB301516796544BC_1756078858.addTaint(taint);
        return var4F18F58D2FA16042CB301516796544BC_1756078858;
        // ---------- Original Method ----------
        //return Arrays.toString(mData);
    }

    
}

