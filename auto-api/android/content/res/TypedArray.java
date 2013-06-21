package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import com.android.internal.util.XmlUtils;
import java.util.Arrays;

public class TypedArray {
    private Resources mResources;
    XmlBlock.Parser mXml;
    int[] mRsrcs;
    int[] mData;
    int[] mIndices;
    int mLength;
    TypedValue mValue = new TypedValue();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.646 -0400", hash_original_method = "6BEE97C5D6D0C7FC7BA11425183A3047", hash_generated_method = "0CB361282363748570B70D3BA1DA2D04")
    @DSModeled(DSC.SAFE)
     TypedArray(Resources resources, int[] data, int[] indices, int len) {
        dsTaint.addTaint(resources.dsTaint);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(indices[0]);
        dsTaint.addTaint(len);
        // ---------- Original Method ----------
        //mResources = resources;
        //mData = data;
        //mIndices = indices;
        //mLength = len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.647 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "223B168FF17CEB39254F4FA4815BC666")
    @DSModeled(DSC.SAFE)
    public int length() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.647 -0400", hash_original_method = "E11A0D9421BCBF5642F2B23C8115E006", hash_generated_method = "AF391D8A6D03A078D5063FB87CE72AA2")
    @DSModeled(DSC.SAFE)
    public int getIndexCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mIndices[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.647 -0400", hash_original_method = "757B3D64706707A79AF98EFF90D4FA5D", hash_generated_method = "7728B4C272E4FF8A55E0CBFB43254DA0")
    @DSModeled(DSC.SAFE)
    public int getIndex(int at) {
        dsTaint.addTaint(at);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mIndices[1+at];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.647 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "6AE48ABE156B960146B435295FB83025")
    @DSModeled(DSC.SAFE)
    public Resources getResources() {
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.648 -0400", hash_original_method = "CED8EF4F9A9EB72D36D43738FFFAF872", hash_generated_method = "F9AF1922847C6DFC67187971182B81A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getText(int index) {
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            CharSequence var9D2D0AEA510028E0BCF732DD316E43E4_1365561683 = (loadStringValueAt(index));
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1359782945 = (getValueAt(index, v));
            {
                CharSequence varF09F63D2BB95783140A4AFBB6A0C287E_1245831634 = (v.coerceToString());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.649 -0400", hash_original_method = "CD99FAD2F71E14195C02F12EEC83DB33", hash_generated_method = "2BB11245A7303E182F466CD007AFD697")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(int index) {
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            String var7816779A37A8A177E319E524BA0496E8_1109150139 = (loadStringValueAt(index).toString());
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1000907629 = (getValueAt(index, v));
            {
                CharSequence cs;
                cs = v.coerceToString();
                {
                    Object var8B35EA4AFCF15806CB69CEFF142F5F2A_1074142401 = (cs.toString());
                } //End flattened ternary
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.650 -0400", hash_original_method = "F340A97CD447E0B03B345E238525B650", hash_generated_method = "980F92DE015C881468B6E0AA11DFFB5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNonResourceString(int index) {
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int cookie;
            cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
            {
                String var0AA537AE0D040B6F611E9273FD3C2D18_450798315 = (mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]).toString());
            } //End block
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.650 -0400", hash_original_method = "5032E8B6CD1C41C8B00D83016FACB488", hash_generated_method = "0FBF9448D350364B8C2ADD051073661A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNonConfigurationString(int index, int allowedChangingConfigs) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(allowedChangingConfigs);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            String var7816779A37A8A177E319E524BA0496E8_659163753 = (loadStringValueAt(index).toString());
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_297257970 = (getValueAt(index, v));
            {
                CharSequence cs;
                cs = v.coerceToString();
                {
                    Object var8B35EA4AFCF15806CB69CEFF142F5F2A_1516513079 = (cs.toString());
                } //End flattened ternary
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.651 -0400", hash_original_method = "A16CEE5167173C9433B0C8031B10442D", hash_generated_method = "B9546510BC1D848BCB3D778E84D452D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoolean(int index, boolean defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_210981474 = (getValueAt(index, v));
            {
                boolean var1DF74E45E6A82013BAA808D2A0B17270_139977795 = (XmlUtils.convertValueToBoolean(
                v.coerceToString(), defValue));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.651 -0400", hash_original_method = "CE7034C3BE6468015CD54232F0A8137A", hash_generated_method = "1CADDF531F7DD7B8FC9CBCE2EE6FFB70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(int index, int defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_715661853 = (getValueAt(index, v));
            {
                int varC43D63FC76D52470B82B43CB94577892_340336948 = (XmlUtils.convertValueToInt(
                v.coerceToString(), defValue));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.653 -0400", hash_original_method = "011758172267C9B5DEB37AE215F4E3BC", hash_generated_method = "47C8C4D4C9FA33E8A793EE534680FD8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloat(int index, float defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            float var3E5427D1CBE86332C74CFA40E97B9984_1635432847 = (Float.intBitsToFloat(data[index+AssetManager.STYLE_DATA]));
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1698165505 = (getValueAt(index, v));
            {
                CharSequence str;
                str = v.coerceToString();
                {
                    float varA095623FA4816C8D5F54F27B395BD813_893849620 = (Float.parseFloat(str.toString()));
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.654 -0400", hash_original_method = "7882F59751F929311CA11EC559C5A65E", hash_generated_method = "37109FA0789159946ABB8C9A0D39CCE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColor(int index, int defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            TypedValue value;
            value = mValue;
            {
                boolean varA79D37EDC713ED72ECAC40127D9AD5BF_1800925760 = (getValueAt(index, value));
                {
                    ColorStateList csl;
                    csl = mResources.loadColorStateList(
                        value, value.resourceId);
                    int var9E880B265D1656C4842E5CF05322598D_1703679498 = (csl.getDefaultColor());
                } //End block
            } //End collapsed parenthetic
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to color: type=0x"
                + Integer.toHexString(type));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.656 -0400", hash_original_method = "1A4CBA2C97DB5340F77B643957B9F4A1", hash_generated_method = "D25DABF3E351547091A94DDF866EC9BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ColorStateList getColorStateList(int index) {
        dsTaint.addTaint(index);
        TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_98581318 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
            {
                ColorStateList var9B48CAFCD06FA717163266A71082A7DD_1152824458 = (mResources.loadColorStateList(value, value.resourceId));
            } //End block
        } //End collapsed parenthetic
        return (ColorStateList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final TypedValue value = mValue;
        //if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            //return mResources.loadColorStateList(value, value.resourceId);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.671 -0400", hash_original_method = "79362C29C94DC5BFF9E1A7E9D64A3B8E", hash_generated_method = "FB0FEB115681CB9153D8CF8B528DC035")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInteger(int index, int defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to integer: type=0x"
                + Integer.toHexString(type));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.672 -0400", hash_original_method = "C0FC3CC7AE2D97843F00F5A6AEA9712A", hash_generated_method = "3A248CAC48BEDEFEB0385A0C37E0C74B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getDimension(int index, float defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            float varA1522486184585892ADD51886D88796F_2145174704 = (TypedValue.complexToDimension(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        return dsTaint.getTaintFloat();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.677 -0400", hash_original_method = "77814E0587E00AA950C757CAE37F97F1", hash_generated_method = "0DC96B46510CB10C9B450315D56F1839")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDimensionPixelOffset(int index, int defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var4A5F9DBCA23B6EA0EA6FDF95426DA4CC_1195702810 = (TypedValue.complexToDimensionPixelOffset(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.678 -0400", hash_original_method = "FEB58959DB31428B407FA8A9132D2CB5", hash_generated_method = "EEF0B470BCCE444F231C88B2847AA55D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDimensionPixelSize(int index, int defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_1435647877 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.678 -0400", hash_original_method = "DB4A9B1FF17810BF297E37812D056BD1", hash_generated_method = "635929DF7F5BEC3FE27E100CE3DE57BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLayoutDimension(int index, String name) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(name);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_1759005430 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(getPositionDescription()
                + ": You must supply a " + name + " attribute.");
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.679 -0400", hash_original_method = "A72B2EF9D0CF1F1E691D4D81DC434823", hash_generated_method = "0FF9E51FAB5B09C129F59D0454D8D96E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLayoutDimension(int index, int defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_1235671334 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.682 -0400", hash_original_method = "57D8AC3F2B2D48B77A0EB4868F247839", hash_generated_method = "C283DF72266C48AE30492EC825AA106D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFraction(int index, int base, int pbase, float defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        dsTaint.addTaint(base);
        dsTaint.addTaint(pbase);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            float var783B7664A89710D9D988B33835D0AC9D_1844413522 = (TypedValue.complexToFraction(
                data[index+AssetManager.STYLE_DATA], base, pbase));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to fraction: type=0x"
                + Integer.toHexString(type));
        return dsTaint.getTaintFloat();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.683 -0400", hash_original_method = "DF47714E2511EE2CB8E5736FC0D36FFE", hash_generated_method = "ACE75FAAD4DAEF57206A64F39026BC58")
    @DSModeled(DSC.SAFE)
    public int getResourceId(int index, int defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        {
            int resid;
            resid = data[index+AssetManager.STYLE_RESOURCE_ID];
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.684 -0400", hash_original_method = "4764631566003CBA3FBDF6AEC7E40184", hash_generated_method = "4ECDF67D35E2EFD6E01042BE56EBB4E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getDrawable(int index) {
        dsTaint.addTaint(index);
        TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_84945159 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
            {
                {
                    System.out.println("******************************************************************");
                    System.out.println("Got drawable resource: type="
                                   + value.type
                                   + " str=" + value.string
                                   + " int=0x" + Integer.toHexString(value.data)
                                   + " cookie=" + value.assetCookie);
                    System.out.println("******************************************************************");
                } //End block
                Drawable varDD8948F561F497A5B1BBAD8198698B23_321300667 = (mResources.loadDrawable(value, value.resourceId));
            } //End block
        } //End collapsed parenthetic
        return (Drawable)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.685 -0400", hash_original_method = "DE841974CEC89F1656E36D821FAC9EE9", hash_generated_method = "AF6C528CF3A4BD41D00BC560AB4FB242")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence[] getTextArray(int index) {
        dsTaint.addTaint(index);
        TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_1787168853 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
            {
                {
                    System.out.println("******************************************************************");
                    System.out.println("Got drawable resource: type="
                                   + value.type
                                   + " str=" + value.string
                                   + " int=0x" + Integer.toHexString(value.data)
                                   + " cookie=" + value.assetCookie);
                    System.out.println("******************************************************************");
                } //End block
                CharSequence[] varA029BC865507B4EEABEBD3F8A88B303C_1976732127 = (mResources.getTextArray(value.resourceId));
            } //End block
        } //End collapsed parenthetic
        CharSequence[] retVal = new CharSequence[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.686 -0400", hash_original_method = "0C857F8AC76CD5CFBE7569B581103BDD", hash_generated_method = "9C88ED081AAE96E0A036DE7FDB6F13A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getValue(int index, TypedValue outValue) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(outValue.dsTaint);
        boolean varA337BC1324677280D08B6023F41FDF45_1988210483 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.686 -0400", hash_original_method = "0EF762AB49E40F4FF6959DF2595733A2", hash_generated_method = "E74BEC9471CE22BA101A73AD6BA6A0E7")
    @DSModeled(DSC.SAFE)
    public boolean hasValue(int index) {
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //return type != TypedValue.TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.687 -0400", hash_original_method = "0D8F28067488CFE0F25A0D66713982F4", hash_generated_method = "09D96C85B936A4D071FD0D30CC0CCAB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypedValue peekValue(int index) {
        dsTaint.addTaint(index);
        TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_1325326328 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
        } //End collapsed parenthetic
        return (TypedValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final TypedValue value = mValue;
        //if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            //return value;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.688 -0400", hash_original_method = "C2A30811E6FAA7EEAF3DDEC09CF05D3C", hash_generated_method = "D799B6FA457B1C14095590312973143A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPositionDescription() {
        {
            Object var4E9EB5210FE4CEAE66699CD16114E32B_1939328778 = (mXml.getPositionDescription());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mXml != null ? mXml.getPositionDescription() : "<internal>";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.688 -0400", hash_original_method = "A1E6C58584B412829C21C498310464D0", hash_generated_method = "BC4048992AF4E8301F4BD98BC8194937")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void recycle() {
        {
            TypedArray cached;
            cached = mResources.mCachedStyledAttributes;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.689 -0400", hash_original_method = "7C5221C979A46E52D6E71FCE8A161B4A", hash_generated_method = "9674134C3ACBC393FC9EE5BBF3E01276")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean getValueAt(int index, TypedValue outValue) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(outValue.dsTaint);
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        outValue.type = type;
        outValue.data = data[index+AssetManager.STYLE_DATA];
        outValue.assetCookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        outValue.resourceId = data[index+AssetManager.STYLE_RESOURCE_ID];
        outValue.changingConfigurations = data[index+AssetManager.STYLE_CHANGING_CONFIGURATIONS];
        outValue.density = data[index+AssetManager.STYLE_DENSITY];
        outValue.string = (type == TypedValue.TYPE_STRING) ? loadStringValueAt(index) : null;
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.689 -0400", hash_original_method = "9EED998F765658475A56DE41DA4AC13D", hash_generated_method = "3E5BA8D1CBD3DC2166A471D500B3DA80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence loadStringValueAt(int index) {
        dsTaint.addTaint(index);
        int[] data;
        data = mData;
        int cookie;
        cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        {
            {
                CharSequence varD5B9DC008EAD2EFD718C642B48F1163B_2005403732 = (mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]));
            } //End block
        } //End block
        CharSequence var1CFA30FE661079CA294A9E82FD758F0E_1850238117 = (mResources.mAssets.getPooledString(
            cookie, data[index+AssetManager.STYLE_DATA]));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.690 -0400", hash_original_method = "D3700358536036842F849ADB987A26DD", hash_generated_method = "3F469A4AEE0F35EABD7B6FE8C8918F65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varF5B069219DBBA960F3E0055634B0BBFD_1932085963 = (Arrays.toString(mData));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Arrays.toString(mData);
    }

    
}

