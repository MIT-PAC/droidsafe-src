package android.content.res;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.690 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.690 -0400", hash_original_field = "31B55396FDC1E462D428736AFE79C5F1", hash_generated_field = "5B0AA5083BE633511718F93F8CB95A91")

    XmlBlock.Parser mXml;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.690 -0400", hash_original_field = "BCD13DEF7A649738D722B3798B729E0B", hash_generated_field = "A4F8D1E493616053569BD2AC1F0ABB08")

    int[] mRsrcs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.691 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "8C2374D33A80477A0B3E51CE7EB85544")

    int[] mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.691 -0400", hash_original_field = "38E6D9E425A40CF7C8EF997F011F479F", hash_generated_field = "2BB4F4BFBD9E11898040581D9D99B4FA")

    int[] mIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.691 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "FC3D477E7B6A4ACE9A379E6E41129BD1")

    int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.691 -0400", hash_original_field = "89FC4D18C6865D9655DB03AE7EA21F19", hash_generated_field = "654366000D5436FE48B31EFBD0B3756D")

    TypedValue mValue = new TypedValue();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.692 -0400", hash_original_method = "6BEE97C5D6D0C7FC7BA11425183A3047", hash_generated_method = "32DEAC4AB87004418452846E3F423055")
      TypedArray(Resources resources, int[] data, int[] indices, int len) {
        mResources = resources;
        mData = data;
        mIndices = indices;
        mLength = len;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.693 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "339E3E5DAFF848E35C2FE2F7C23E257D")
    public int length() {
        int var429F431E8CD8AC287AA27460675EAEFE_1384299439 = (mLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92674839 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92674839;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.693 -0400", hash_original_method = "E11A0D9421BCBF5642F2B23C8115E006", hash_generated_method = "9FECEAFC8ECC1A4C6198ABD3E6FAF6A4")
    public int getIndexCount() {
        int varCBCFD99B62F4085DE81B9C51AEF99317_1678511388 = (mIndices[0]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2077411590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2077411590;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.694 -0400", hash_original_method = "757B3D64706707A79AF98EFF90D4FA5D", hash_generated_method = "1268861A5FB745CFC1FCC11EAE9DB90C")
    public int getIndex(int at) {
        addTaint(at);
        int var6A0A6F300283CFEE125F1300DD149243_744285628 = (mIndices[1+at]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905750004 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905750004;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.694 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "5268A35CD79309A892F5BE570F6F694E")
    public Resources getResources() {
Resources var346B953D96D762F7FED561E83C1656CA_1086665936 =         mResources;
        var346B953D96D762F7FED561E83C1656CA_1086665936.addTaint(taint);
        return var346B953D96D762F7FED561E83C1656CA_1086665936;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.695 -0400", hash_original_method = "CED8EF4F9A9EB72D36D43738FFFAF872", hash_generated_method = "5154FA2632506526753064FE2D102CA9")
    public CharSequence getText(int index) {
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if(type == TypedValue.TYPE_NULL)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_557612171 =             null;
            var540C13E9E156B687226421B24F2DF178_557612171.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_557612171;
        } 
        else
    if(type == TypedValue.TYPE_STRING)        
        {
CharSequence varFE71F37E0231268B2ED63AD36D2E0D73_1794209829 =             loadStringValueAt(index);
            varFE71F37E0231268B2ED63AD36D2E0D73_1794209829.addTaint(taint);
            return varFE71F37E0231268B2ED63AD36D2E0D73_1794209829;
        } 
        TypedValue v = mValue;
    if(getValueAt(index, v))        
        {
CharSequence var2C8E21343D2B0A4401FE2DCD0A0846DE_1219433951 =             v.coerceToString();
            var2C8E21343D2B0A4401FE2DCD0A0846DE_1219433951.addTaint(taint);
            return var2C8E21343D2B0A4401FE2DCD0A0846DE_1219433951;
        } 
CharSequence var540C13E9E156B687226421B24F2DF178_1045508302 =         null;
        var540C13E9E156B687226421B24F2DF178_1045508302.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1045508302;
        
        
        
        
        
            
        
            
        
        
        
            
            
        
        
              
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.696 -0400", hash_original_method = "CD99FAD2F71E14195C02F12EEC83DB33", hash_generated_method = "547B2FCC30698F8C74A8B4D4BBCB566D")
    public String getString(int index) {
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if(type == TypedValue.TYPE_NULL)        
        {
String var540C13E9E156B687226421B24F2DF178_1738622276 =             null;
            var540C13E9E156B687226421B24F2DF178_1738622276.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1738622276;
        } 
        else
    if(type == TypedValue.TYPE_STRING)        
        {
String var64A041B790F9314358723EB5F60631DA_1290507739 =             loadStringValueAt(index).toString();
            var64A041B790F9314358723EB5F60631DA_1290507739.addTaint(taint);
            return var64A041B790F9314358723EB5F60631DA_1290507739;
        } 
        TypedValue v = mValue;
    if(getValueAt(index, v))        
        {
            CharSequence cs = v.coerceToString();
String var48C761D210B750355CBC7ACAC2081BD2_89565136 =             cs != null ? cs.toString() : null;
            var48C761D210B750355CBC7ACAC2081BD2_89565136.addTaint(taint);
            return var48C761D210B750355CBC7ACAC2081BD2_89565136;
        } 
String var540C13E9E156B687226421B24F2DF178_116365074 =         null;
        var540C13E9E156B687226421B24F2DF178_116365074.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_116365074;
        
        
        
        
        
            
        
            
        
        
        
            
            
            
        
        
              
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.696 -0400", hash_original_method = "F340A97CD447E0B03B345E238525B650", hash_generated_method = "B9B0DD0DA7FBDFBD294E54D6278E7866")
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
String varB9449F2AA54F253D8A562BA43198C02C_1802089509 =                 mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]).toString();
                varB9449F2AA54F253D8A562BA43198C02C_1802089509.addTaint(taint);
                return varB9449F2AA54F253D8A562BA43198C02C_1802089509;
            } 
        } 
String var540C13E9E156B687226421B24F2DF178_44763598 =         null;
        var540C13E9E156B687226421B24F2DF178_44763598.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_44763598;
        
        
        
        
        
            
            
                
                    
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.697 -0400", hash_original_method = "5032E8B6CD1C41C8B00D83016FACB488", hash_generated_method = "B6EEAAF749DCC4FFA819DFE383C3ACA6")
    public String getNonConfigurationString(int index, int allowedChangingConfigs) {
        addTaint(allowedChangingConfigs);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if((data[index+AssetManager.STYLE_CHANGING_CONFIGURATIONS]&~allowedChangingConfigs) != 0)        
        {
String var540C13E9E156B687226421B24F2DF178_1348867894 =             null;
            var540C13E9E156B687226421B24F2DF178_1348867894.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1348867894;
        } 
    if(type == TypedValue.TYPE_NULL)        
        {
String var540C13E9E156B687226421B24F2DF178_1797425493 =             null;
            var540C13E9E156B687226421B24F2DF178_1797425493.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1797425493;
        } 
        else
    if(type == TypedValue.TYPE_STRING)        
        {
String var64A041B790F9314358723EB5F60631DA_448625258 =             loadStringValueAt(index).toString();
            var64A041B790F9314358723EB5F60631DA_448625258.addTaint(taint);
            return var64A041B790F9314358723EB5F60631DA_448625258;
        } 
        TypedValue v = mValue;
    if(getValueAt(index, v))        
        {
            CharSequence cs = v.coerceToString();
String var48C761D210B750355CBC7ACAC2081BD2_406654713 =             cs != null ? cs.toString() : null;
            var48C761D210B750355CBC7ACAC2081BD2_406654713.addTaint(taint);
            return var48C761D210B750355CBC7ACAC2081BD2_406654713;
        } 
String var540C13E9E156B687226421B24F2DF178_915011578 =         null;
        var540C13E9E156B687226421B24F2DF178_915011578.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_915011578;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.698 -0400", hash_original_method = "A16CEE5167173C9433B0C8031B10442D", hash_generated_method = "3154F92B835341CACB1C95D078A2DEB3")
    public boolean getBoolean(int index, boolean defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if(type == TypedValue.TYPE_NULL)        
        {
            boolean var0C005749B1246DFDB5F6909C34026193_1373940264 = (defValue);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1739129037 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1739129037;
        } 
        else
    if(type >= TypedValue.TYPE_FIRST_INT
            && type <= TypedValue.TYPE_LAST_INT)        
        {
            boolean var0CE8B984FD52D0D9D4884EBD54C45C32_1772918139 = (data[index+AssetManager.STYLE_DATA] != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_323321367 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_323321367;
        } 
        TypedValue v = mValue;
    if(getValueAt(index, v))        
        {
            boolean varB39FBB646575158FECB38BC18FF05BC9_1935672938 = (XmlUtils.convertValueToBoolean(
                v.coerceToString(), defValue));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432657887 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432657887;
        } 
        boolean var0C005749B1246DFDB5F6909C34026193_166663975 = (defValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1450833324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1450833324;
        
        
        
        
        
            
        
            
            
        
        
        
            
            
                
        
        
              
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.699 -0400", hash_original_method = "CE7034C3BE6468015CD54232F0A8137A", hash_generated_method = "06574403B829F2128F487C02223D4D69")
    public int getInt(int index, int defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if(type == TypedValue.TYPE_NULL)        
        {
            int var0C005749B1246DFDB5F6909C34026193_1075288056 = (defValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2059963583 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2059963583;
        } 
        else
    if(type >= TypedValue.TYPE_FIRST_INT
            && type <= TypedValue.TYPE_LAST_INT)        
        {
            int varFDFFC91BD3522FF60D6A3BB8827668A7_2111406464 = (data[index+AssetManager.STYLE_DATA]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055912274 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055912274;
        } 
        TypedValue v = mValue;
    if(getValueAt(index, v))        
        {
            int var7C0F02E8C82C7DA46920D32043E092A8_1635618455 = (XmlUtils.convertValueToInt(
                v.coerceToString(), defValue));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_875379980 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_875379980;
        } 
        int var0C005749B1246DFDB5F6909C34026193_1591891459 = (defValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624895252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624895252;
        
        
        
        
        
            
        
            
            
        
        
        
            
            
                
        
        
              
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.700 -0400", hash_original_method = "011758172267C9B5DEB37AE215F4E3BC", hash_generated_method = "CD078B0C6BF4C67B1DFE130BE55F2ACA")
    public float getFloat(int index, float defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if(type == TypedValue.TYPE_NULL)        
        {
            float var0C005749B1246DFDB5F6909C34026193_1330309162 = (defValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_1655132645 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1655132645;
        } 
        else
    if(type == TypedValue.TYPE_FLOAT)        
        {
            float varA40169C04CC424FE29909E57764E1240_1368191697 = (Float.intBitsToFloat(data[index+AssetManager.STYLE_DATA]));
                        float var546ADE640B6EDFBC8A086EF31347E768_1264190988 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1264190988;
        } 
        else
    if(type >= TypedValue.TYPE_FIRST_INT
            && type <= TypedValue.TYPE_LAST_INT)        
        {
            float varFDFFC91BD3522FF60D6A3BB8827668A7_1309732580 = (data[index+AssetManager.STYLE_DATA]);
                        float var546ADE640B6EDFBC8A086EF31347E768_1914167758 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1914167758;
        } 
        TypedValue v = mValue;
    if(getValueAt(index, v))        
        {
            CharSequence str = v.coerceToString();
    if(str != null)            
            {
                float var7262E3EE64C63FD62BA0CAE0EA220541_275365929 = (Float.parseFloat(str.toString()));
                                float var546ADE640B6EDFBC8A086EF31347E768_1871706499 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1871706499;
            } 
        } 
        float var0C005749B1246DFDB5F6909C34026193_643107852 = (defValue);
                float var546ADE640B6EDFBC8A086EF31347E768_926986163 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_926986163;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.701 -0400", hash_original_method = "7882F59751F929311CA11EC559C5A65E", hash_generated_method = "61F0E16577EC3B054811594BEAD5D814")
    public int getColor(int index, int defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if(type == TypedValue.TYPE_NULL)        
        {
            int var0C005749B1246DFDB5F6909C34026193_78749979 = (defValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177695803 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177695803;
        } 
        else
    if(type >= TypedValue.TYPE_FIRST_INT
            && type <= TypedValue.TYPE_LAST_INT)        
        {
            int varFDFFC91BD3522FF60D6A3BB8827668A7_1184527912 = (data[index+AssetManager.STYLE_DATA]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439973622 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439973622;
        } 
        else
    if(type == TypedValue.TYPE_STRING)        
        {
            final TypedValue value = mValue;
    if(getValueAt(index, value))            
            {
                ColorStateList csl = mResources.loadColorStateList(
                        value, value.resourceId);
                int var90DA607A89399855C664ACB81336CEB7_777874496 = (csl.getDefaultColor());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635790147 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1635790147;
            } 
            int var0C005749B1246DFDB5F6909C34026193_965854290 = (defValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017345169 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2017345169;
        } 
        UnsupportedOperationException var71470B063586A7B6099980B20674FC5B_1833430522 = new UnsupportedOperationException("Can't convert to color: type=0x"
                + Integer.toHexString(type));
        var71470B063586A7B6099980B20674FC5B_1833430522.addTaint(taint);
        throw var71470B063586A7B6099980B20674FC5B_1833430522;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.702 -0400", hash_original_method = "1A4CBA2C97DB5340F77B643957B9F4A1", hash_generated_method = "5B2542027BC8A24EB577C2A9B41B6C7D")
    public ColorStateList getColorStateList(int index) {
        addTaint(index);
        final TypedValue value = mValue;
    if(getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value))        
        {
ColorStateList var7C9C7C605F72EFD6C3AEEFB96F806FB5_1109317845 =             mResources.loadColorStateList(value, value.resourceId);
            var7C9C7C605F72EFD6C3AEEFB96F806FB5_1109317845.addTaint(taint);
            return var7C9C7C605F72EFD6C3AEEFB96F806FB5_1109317845;
        } 
ColorStateList var540C13E9E156B687226421B24F2DF178_586706768 =         null;
        var540C13E9E156B687226421B24F2DF178_586706768.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_586706768;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.703 -0400", hash_original_method = "79362C29C94DC5BFF9E1A7E9D64A3B8E", hash_generated_method = "D92C5044F085175EFF9FA37C389091E2")
    public int getInteger(int index, int defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if(type == TypedValue.TYPE_NULL)        
        {
            int var0C005749B1246DFDB5F6909C34026193_2019616056 = (defValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328708922 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328708922;
        } 
        else
    if(type >= TypedValue.TYPE_FIRST_INT
            && type <= TypedValue.TYPE_LAST_INT)        
        {
            int varFDFFC91BD3522FF60D6A3BB8827668A7_799028881 = (data[index+AssetManager.STYLE_DATA]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_762498537 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_762498537;
        } 
        UnsupportedOperationException var8C8AB64BD80FA7B626E771A9DDA3439B_895694037 = new UnsupportedOperationException("Can't convert to integer: type=0x"
                + Integer.toHexString(type));
        var8C8AB64BD80FA7B626E771A9DDA3439B_895694037.addTaint(taint);
        throw var8C8AB64BD80FA7B626E771A9DDA3439B_895694037;
        
        
        
        
        
            
        
            
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.704 -0400", hash_original_method = "C0FC3CC7AE2D97843F00F5A6AEA9712A", hash_generated_method = "53C23FCFA48B068A348067182848B6D6")
    public float getDimension(int index, float defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if(type == TypedValue.TYPE_NULL)        
        {
            float var0C005749B1246DFDB5F6909C34026193_522378277 = (defValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_388218885 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_388218885;
        } 
        else
    if(type == TypedValue.TYPE_DIMENSION)        
        {
            float varC68BC678885371EC1DF2E25CF7D8D14C_1111411991 = (TypedValue.complexToDimension(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
                        float var546ADE640B6EDFBC8A086EF31347E768_603785348 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_603785348;
        } 
        UnsupportedOperationException var60E90C7265C27F9135089FD1FAE1F298_2073365260 = new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        var60E90C7265C27F9135089FD1FAE1F298_2073365260.addTaint(taint);
        throw var60E90C7265C27F9135089FD1FAE1F298_2073365260;
        
        
        
        
        
            
        
            
                
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.705 -0400", hash_original_method = "77814E0587E00AA950C757CAE37F97F1", hash_generated_method = "8A66CFE2D14A101B3AEE6C2F3FCB823A")
    public int getDimensionPixelOffset(int index, int defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if(type == TypedValue.TYPE_NULL)        
        {
            int var0C005749B1246DFDB5F6909C34026193_1439705831 = (defValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052386866 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052386866;
        } 
        else
    if(type == TypedValue.TYPE_DIMENSION)        
        {
            int varB51CE27A1C43B19BB608E3E6CF9DBA8B_571064892 = (TypedValue.complexToDimensionPixelOffset(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_503121637 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_503121637;
        } 
        UnsupportedOperationException var60E90C7265C27F9135089FD1FAE1F298_1128566817 = new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        var60E90C7265C27F9135089FD1FAE1F298_1128566817.addTaint(taint);
        throw var60E90C7265C27F9135089FD1FAE1F298_1128566817;
        
        
        
        
        
            
        
            
                
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.707 -0400", hash_original_method = "FEB58959DB31428B407FA8A9132D2CB5", hash_generated_method = "C3EDA9FFFE06964936D502D43591001C")
    public int getDimensionPixelSize(int index, int defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if(type == TypedValue.TYPE_NULL)        
        {
            int var0C005749B1246DFDB5F6909C34026193_437539535 = (defValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627016767 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1627016767;
        } 
        else
    if(type == TypedValue.TYPE_DIMENSION)        
        {
            int var8E99B144C6D8C2AA2554740CD4F18B6B_1951406931 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640138413 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640138413;
        } 
        UnsupportedOperationException var60E90C7265C27F9135089FD1FAE1F298_888784543 = new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        var60E90C7265C27F9135089FD1FAE1F298_888784543.addTaint(taint);
        throw var60E90C7265C27F9135089FD1FAE1F298_888784543;
        
        
        
        
        
            
        
            
                
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.708 -0400", hash_original_method = "DB4A9B1FF17810BF297E37812D056BD1", hash_generated_method = "98565AE78BB69E4629174FB651203C99")
    public int getLayoutDimension(int index, String name) {
        addTaint(name.getTaint());
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if(type >= TypedValue.TYPE_FIRST_INT
                && type <= TypedValue.TYPE_LAST_INT)        
        {
            int varFDFFC91BD3522FF60D6A3BB8827668A7_717683612 = (data[index+AssetManager.STYLE_DATA]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692684802 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692684802;
        } 
        else
    if(type == TypedValue.TYPE_DIMENSION)        
        {
            int var8E99B144C6D8C2AA2554740CD4F18B6B_1644955106 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1612759390 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1612759390;
        } 
        RuntimeException var51FA9FB57E57B0746BFCE79AEF53EEAE_311218485 = new RuntimeException(getPositionDescription()
                + ": You must supply a " + name + " attribute.");
        var51FA9FB57E57B0746BFCE79AEF53EEAE_311218485.addTaint(taint);
        throw var51FA9FB57E57B0746BFCE79AEF53EEAE_311218485;
        
        
        
        
        
                
            
        
            
                
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.709 -0400", hash_original_method = "A72B2EF9D0CF1F1E691D4D81DC434823", hash_generated_method = "76796DDC442C6D789E1CD724E3760EFF")
    public int getLayoutDimension(int index, int defValue) {
        addTaint(defValue);
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if(type >= TypedValue.TYPE_FIRST_INT
                && type <= TypedValue.TYPE_LAST_INT)        
        {
            int varFDFFC91BD3522FF60D6A3BB8827668A7_489746039 = (data[index+AssetManager.STYLE_DATA]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736818953 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736818953;
        } 
        else
    if(type == TypedValue.TYPE_DIMENSION)        
        {
            int var8E99B144C6D8C2AA2554740CD4F18B6B_626290657 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222050305 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222050305;
        } 
        int var0C005749B1246DFDB5F6909C34026193_547175916 = (defValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474628389 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1474628389;
        
        
        
        
        
                
            
        
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.710 -0400", hash_original_method = "57D8AC3F2B2D48B77A0EB4868F247839", hash_generated_method = "26800E39FD7D545F496382EE8065DF14")
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
            float var0C005749B1246DFDB5F6909C34026193_1331880292 = (defValue);
                        float var546ADE640B6EDFBC8A086EF31347E768_1576880914 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1576880914;
        } 
        else
    if(type == TypedValue.TYPE_FRACTION)        
        {
            float var8A54764FBAFB3D02129FEF8A8E5CA579_2126315759 = (TypedValue.complexToFraction(
                data[index+AssetManager.STYLE_DATA], base, pbase));
                        float var546ADE640B6EDFBC8A086EF31347E768_1441441671 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1441441671;
        } 
        UnsupportedOperationException varCF896F22EB53276BC9ADA3E6A43FC9FA_606060900 = new UnsupportedOperationException("Can't convert to fraction: type=0x"
                + Integer.toHexString(type));
        varCF896F22EB53276BC9ADA3E6A43FC9FA_606060900.addTaint(taint);
        throw varCF896F22EB53276BC9ADA3E6A43FC9FA_606060900;
        
        
        
        
        
            
        
            
                
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.711 -0400", hash_original_method = "DF47714E2511EE2CB8E5736FC0D36FFE", hash_generated_method = "663937278DC662A10D210FF72DFD7377")
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
                int var9C5DC71F9C3AB4FEBAA17E7B42553A5B_812925222 = (resid);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608147271 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608147271;
            } 
        } 
        int var0C005749B1246DFDB5F6909C34026193_550507397 = (defValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799886684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799886684;
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.712 -0400", hash_original_method = "4764631566003CBA3FBDF6AEC7E40184", hash_generated_method = "A1D6C151001CBE25CD3FFE7691B530D8")
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
            } 
Drawable var9CD9F2C7F5CF532C97D6207826992225_997814796 =             mResources.loadDrawable(value, value.resourceId);
            var9CD9F2C7F5CF532C97D6207826992225_997814796.addTaint(taint);
            return var9CD9F2C7F5CF532C97D6207826992225_997814796;
        } 
Drawable var540C13E9E156B687226421B24F2DF178_199963215 =         null;
        var540C13E9E156B687226421B24F2DF178_199963215.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_199963215;
        
        
        
            
                
                
                                   
                                   
                                   
                                   
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.713 -0400", hash_original_method = "DE841974CEC89F1656E36D821FAC9EE9", hash_generated_method = "3940C1082987545274339015724BC5AB")
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
            } 
CharSequence[] var9B185D6E2C129A747CB021868828E1FB_1422932018 =             mResources.getTextArray(value.resourceId);
            var9B185D6E2C129A747CB021868828E1FB_1422932018.addTaint(taint);
            return var9B185D6E2C129A747CB021868828E1FB_1422932018;
        } 
CharSequence[] var540C13E9E156B687226421B24F2DF178_712422274 =         null;
        var540C13E9E156B687226421B24F2DF178_712422274.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_712422274;
        
        
        
            
                
                
                                   
                                   
                                   
                                   
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.713 -0400", hash_original_method = "0C857F8AC76CD5CFBE7569B581103BDD", hash_generated_method = "C2C6655C93BFEFD4347418143DDA5F75")
    public boolean getValue(int index, TypedValue outValue) {
        addTaint(outValue.getTaint());
        addTaint(index);
        boolean var22F6889BB5F70FB4653E25BBBCB03D57_1657321985 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1687830874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1687830874;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.714 -0400", hash_original_method = "0EF762AB49E40F4FF6959DF2595733A2", hash_generated_method = "EB4E6201FFC3FA3C784A4190BB714692")
    public boolean hasValue(int index) {
        addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        boolean var8F37846CC3DB18B76C036D1B7DA857FE_1936973446 = (type != TypedValue.TYPE_NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1867190933 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1867190933;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.716 -0400", hash_original_method = "0D8F28067488CFE0F25A0D66713982F4", hash_generated_method = "94184630EC6D41DAED2F23F55225ACD3")
    public TypedValue peekValue(int index) {
        addTaint(index);
        final TypedValue value = mValue;
    if(getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value))        
        {
TypedValue varAF280DA2BC37D8BE783D8499160168DE_1506727484 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_1506727484.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_1506727484;
        } 
TypedValue var540C13E9E156B687226421B24F2DF178_334138567 =         null;
        var540C13E9E156B687226421B24F2DF178_334138567.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_334138567;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.717 -0400", hash_original_method = "C2A30811E6FAA7EEAF3DDEC09CF05D3C", hash_generated_method = "26CBBC5FF5C171548AD7EA018FF58972")
    public String getPositionDescription() {
String var71429891338B1C00981D47483975D6BA_1856794583 =         mXml != null ? mXml.getPositionDescription() : "<internal>";
        var71429891338B1C00981D47483975D6BA_1856794583.addTaint(taint);
        return var71429891338B1C00981D47483975D6BA_1856794583;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.718 -0400", hash_original_method = "A1E6C58584B412829C21C498310464D0", hash_generated_method = "E2D95A3B760CCDC32B6CA5663CCFF342")
    public void recycle() {
        synchronized
(mResources.mTmpValue)        {
            TypedArray cached = mResources.mCachedStyledAttributes;
    if(cached == null || cached.mData.length < mData.length)            
            {
                mXml = null;
                mResources.mCachedStyledAttributes = this;
            } 
        } 
        
        
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.720 -0400", hash_original_method = "7C5221C979A46E52D6E71FCE8A161B4A", hash_generated_method = "2EB6D70FBA7BC76BE30A66AC15D9DADE")
    private boolean getValueAt(int index, TypedValue outValue) {
        addTaint(outValue.getTaint());
        addTaint(index);
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
    if(type == TypedValue.TYPE_NULL)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1815362009 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1881617096 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1881617096;
        } 
        outValue.type = type;
        outValue.data = data[index+AssetManager.STYLE_DATA];
        outValue.assetCookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        outValue.resourceId = data[index+AssetManager.STYLE_RESOURCE_ID];
        outValue.changingConfigurations = data[index+AssetManager.STYLE_CHANGING_CONFIGURATIONS];
        outValue.density = data[index+AssetManager.STYLE_DENSITY];
        outValue.string = (type == TypedValue.TYPE_STRING) ? loadStringValueAt(index) : null;
        boolean varB326B5062B2F0E69046810717534CB09_325892382 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905745811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_905745811;
        
        
        
        
            
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.721 -0400", hash_original_method = "9EED998F765658475A56DE41DA4AC13D", hash_generated_method = "F7D7719722A84A16AE889D496EC75E8A")
    private CharSequence loadStringValueAt(int index) {
        addTaint(index);
        final int[] data = mData;
        final int cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
    if(cookie < 0)        
        {
    if(mXml != null)            
            {
CharSequence var1909CA0A0B5F4C1B88AD901A4800961A_1446956895 =                 mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]);
                var1909CA0A0B5F4C1B88AD901A4800961A_1446956895.addTaint(taint);
                return var1909CA0A0B5F4C1B88AD901A4800961A_1446956895;
            } 
CharSequence var540C13E9E156B687226421B24F2DF178_2016971983 =             null;
            var540C13E9E156B687226421B24F2DF178_2016971983.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2016971983;
        } 
CharSequence var13AA805861FD730A1B588C60D1E7C7D9_942308515 =         mResources.mAssets.getPooledString(
            cookie, data[index+AssetManager.STYLE_DATA]);
        var13AA805861FD730A1B588C60D1E7C7D9_942308515.addTaint(taint);
        return var13AA805861FD730A1B588C60D1E7C7D9_942308515;
        
        
        
        
            
                
                    
            
            
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.721 -0400", hash_original_method = "D3700358536036842F849ADB987A26DD", hash_generated_method = "0A5BC28D4694D1264972E0175066A325")
    public String toString() {
String var4F18F58D2FA16042CB301516796544BC_778451210 =         Arrays.toString(mData);
        var4F18F58D2FA16042CB301516796544BC_778451210.addTaint(taint);
        return var4F18F58D2FA16042CB301516796544BC_778451210;
        
        
    }

    
}

