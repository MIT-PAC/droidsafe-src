package android.content.res;

// Droidsafe Imports
import java.util.Arrays;

import android.graphics.drawable.Drawable;
import android.util.TypedValue;

import com.android.internal.util.XmlUtils;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class TypedArray {
    private final Resources mResources;
    XmlBlock.Parser mXml;
    int[] mRsrcs;
    int[] mData;
    int[] mIndices;
    int mLength;
    TypedValue mValue = new TypedValue();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.519 -0400", hash_original_method = "6BEE97C5D6D0C7FC7BA11425183A3047", hash_generated_method = "B93DD507D81885AF776EBD33CF8CFC9C")
    @DSModeled(DSC.SAFE)
     TypedArray(Resources resources, int[] data, int[] indices, int len) {
        dsTaint.addTaint(resources.dsTaint);
        dsTaint.addTaint(data);
        dsTaint.addTaint(indices);
        dsTaint.addTaint(len);
        mResources = resources;
        // ---------- Original Method ----------
        //mResources = resources;
        //mData = data;
        //mIndices = indices;
        //mLength = len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.519 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "E88F9A3FF76C14C0BB1A084B2CA56712")
    @DSModeled(DSC.SAFE)
    public int length() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.519 -0400", hash_original_method = "E11A0D9421BCBF5642F2B23C8115E006", hash_generated_method = "18400EB66CFD2717DC838C407A304399")
    @DSModeled(DSC.SAFE)
    public int getIndexCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mIndices[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.519 -0400", hash_original_method = "757B3D64706707A79AF98EFF90D4FA5D", hash_generated_method = "D14B8C4274EF3A604F9061135B294E18")
    @DSModeled(DSC.SAFE)
    public int getIndex(int at) {
        dsTaint.addTaint(at);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mIndices[1+at];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.519 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "BFF455DC997197BE3540FCE6012E70CA")
    @DSModeled(DSC.SAFE)
    public Resources getResources() {
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.520 -0400", hash_original_method = "CED8EF4F9A9EB72D36D43738FFFAF872", hash_generated_method = "3A66658A101517C9CFCCF46C60710D33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getText(int index) {
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            CharSequence var9D2D0AEA510028E0BCF732DD316E43E4_1540610300 = (loadStringValueAt(index));
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_694876635 = (getValueAt(index, v));
            {
                CharSequence varF09F63D2BB95783140A4AFBB6A0C287E_1587134883 = (v.coerceToString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.520 -0400", hash_original_method = "CD99FAD2F71E14195C02F12EEC83DB33", hash_generated_method = "2FCBBC6825483C7304545EEFDFADDC80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(int index) {
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            String var7816779A37A8A177E319E524BA0496E8_711969498 = (loadStringValueAt(index).toString());
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1652205200 = (getValueAt(index, v));
            {
                CharSequence cs;
                cs = v.coerceToString();
                {
                    Object var8B35EA4AFCF15806CB69CEFF142F5F2A_2143578143 = (cs.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.520 -0400", hash_original_method = "F340A97CD447E0B03B345E238525B650", hash_generated_method = "209D7DA2115B72C9CDB67DAF8F2C428D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNonResourceString(int index) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            final int cookie;
            cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
            {
                String var0AA537AE0D040B6F611E9273FD3C2D18_1035552141 = (mXml.getPooledString(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.521 -0400", hash_original_method = "5032E8B6CD1C41C8B00D83016FACB488", hash_generated_method = "404BEB3B8C2DFA1289A60B31A137891D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getNonConfigurationString(int index, int allowedChangingConfigs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(index);
        dsTaint.addTaint(allowedChangingConfigs);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            String var7816779A37A8A177E319E524BA0496E8_1295114618 = (loadStringValueAt(index).toString());
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_644401511 = (getValueAt(index, v));
            {
                CharSequence cs;
                cs = v.coerceToString();
                {
                    Object var8B35EA4AFCF15806CB69CEFF142F5F2A_329572654 = (cs.toString());
                } //End flattened ternary
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.521 -0400", hash_original_method = "A16CEE5167173C9433B0C8031B10442D", hash_generated_method = "C10D27978F3826F7DCA970CD14D09B31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoolean(int index, boolean defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_543394376 = (getValueAt(index, v));
            {
                boolean var1DF74E45E6A82013BAA808D2A0B17270_164229461 = (XmlUtils.convertValueToBoolean(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.522 -0400", hash_original_method = "CE7034C3BE6468015CD54232F0A8137A", hash_generated_method = "79B2E03B447077C7BC1EAE3F8FF54B5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(int index, int defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_452668205 = (getValueAt(index, v));
            {
                int varC43D63FC76D52470B82B43CB94577892_570094938 = (XmlUtils.convertValueToInt(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.522 -0400", hash_original_method = "011758172267C9B5DEB37AE215F4E3BC", hash_generated_method = "0C1233B3F689E49A1DDE2A45EA7DDFE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloat(int index, float defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            float var3E5427D1CBE86332C74CFA40E97B9984_942653865 = (Float.intBitsToFloat(data[index+AssetManager.STYLE_DATA]));
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1394727584 = (getValueAt(index, v));
            {
                CharSequence str;
                str = v.coerceToString();
                {
                    float varA095623FA4816C8D5F54F27B395BD813_1113129384 = (Float.parseFloat(str.toString()));
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.523 -0400", hash_original_method = "7882F59751F929311CA11EC559C5A65E", hash_generated_method = "70E74C5CDF0CEF9375DDF912C278B4AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getColor(int index, int defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            final TypedValue value;
            value = mValue;
            {
                boolean varA79D37EDC713ED72ECAC40127D9AD5BF_454392320 = (getValueAt(index, value));
                {
                    ColorStateList csl;
                    csl = mResources.loadColorStateList(
                        value, value.resourceId);
                    int var9E880B265D1656C4842E5CF05322598D_1809630497 = (csl.getDefaultColor());
                } //End block
            } //End collapsed parenthetic
        } //End block
        if (DroidSafeAndroidRuntime.control)throw new UnsupportedOperationException("Can't convert to color: type=0x"
                + Integer.toHexString(type));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.523 -0400", hash_original_method = "1A4CBA2C97DB5340F77B643957B9F4A1", hash_generated_method = "25E150B6087FBDCEF65CF8831C1E0B27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ColorStateList getColorStateList(int index) {
        dsTaint.addTaint(index);
        final TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_1411327142 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
            {
                ColorStateList var9B48CAFCD06FA717163266A71082A7DD_746130713 = (mResources.loadColorStateList(value, value.resourceId));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.523 -0400", hash_original_method = "79362C29C94DC5BFF9E1A7E9D64A3B8E", hash_generated_method = "E29BECDCEF57D739D684A64A49493AD3")
    @DSModeled(DSC.SAFE)
    public int getInteger(int index, int defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        if (DroidSafeAndroidRuntime.control)throw new UnsupportedOperationException("Can't convert to integer: type=0x"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.524 -0400", hash_original_method = "C0FC3CC7AE2D97843F00F5A6AEA9712A", hash_generated_method = "F597B8C2524C9406CF79C0640C08B7DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getDimension(int index, float defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            float varA1522486184585892ADD51886D88796F_496136861 = (TypedValue.complexToDimension(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control)throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.524 -0400", hash_original_method = "77814E0587E00AA950C757CAE37F97F1", hash_generated_method = "3E53E79F8D86134C1072DCA93BC76DD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDimensionPixelOffset(int index, int defValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var4A5F9DBCA23B6EA0EA6FDF95426DA4CC_577345954 = (TypedValue.complexToDimensionPixelOffset(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control)throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.524 -0400", hash_original_method = "FEB58959DB31428B407FA8A9132D2CB5", hash_generated_method = "37FF502ACD51F2207BAAD816708D85C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDimensionPixelSize(int index, int defValue) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_1354299144 = (TypedValue.complexToDimensionPixelSize(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.525 -0400", hash_original_method = "DB4A9B1FF17810BF297E37812D056BD1", hash_generated_method = "66C8E27B205533F3CF88EDBD187E6327")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLayoutDimension(int index, String name) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(name);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_208917126 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control)throw new RuntimeException(getPositionDescription()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.525 -0400", hash_original_method = "A72B2EF9D0CF1F1E691D4D81DC434823", hash_generated_method = "4708FDB4DB69A180BD0D8BE7C16D3D73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLayoutDimension(int index, int defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_1109671266 = (TypedValue.complexToDimensionPixelSize(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.525 -0400", hash_original_method = "57D8AC3F2B2D48B77A0EB4868F247839", hash_generated_method = "6173EB405960CAE93F60FF7AE172CED5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFraction(int index, int base, int pbase, float defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        dsTaint.addTaint(base);
        dsTaint.addTaint(pbase);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            float var783B7664A89710D9D988B33835D0AC9D_1113450453 = (TypedValue.complexToFraction(
                data[index+AssetManager.STYLE_DATA], base, pbase));
        } //End block
        if (DroidSafeAndroidRuntime.control)throw new UnsupportedOperationException("Can't convert to fraction: type=0x"
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.526 -0400", hash_original_method = "DF47714E2511EE2CB8E5736FC0D36FFE", hash_generated_method = "7E84A6AD6C9F83635718CA7699F6ED97")
    @DSModeled(DSC.SAFE)
    public int getResourceId(int index, int defValue) {
        dsTaint.addTaint(defValue);
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        {
            final int resid;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.526 -0400", hash_original_method = "4764631566003CBA3FBDF6AEC7E40184", hash_generated_method = "A9D1266848DA25E1740F614FFC00E25C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable getDrawable(int index) {
        dsTaint.addTaint(index);
        final TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_1741649212 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
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
                Drawable varDD8948F561F497A5B1BBAD8198698B23_1258674950 = (mResources.loadDrawable(value, value.resourceId));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.526 -0400", hash_original_method = "DE841974CEC89F1656E36D821FAC9EE9", hash_generated_method = "A3B38EDBFD8FD58387D844DEEF3CF2AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence[] getTextArray(int index) {
        dsTaint.addTaint(index);
        final TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_1319732917 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
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
                CharSequence[] varA029BC865507B4EEABEBD3F8A88B303C_1122871259 = (mResources.getTextArray(value.resourceId));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.527 -0400", hash_original_method = "0C857F8AC76CD5CFBE7569B581103BDD", hash_generated_method = "279E366F42AAEFE8240EF4C5F9B05A04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getValue(int index, TypedValue outValue) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(outValue.dsTaint);
        boolean varA337BC1324677280D08B6023F41FDF45_1137035513 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.527 -0400", hash_original_method = "0EF762AB49E40F4FF6959DF2595733A2", hash_generated_method = "A685681E6FA5831D6BE868A870A56416")
    @DSModeled(DSC.SAFE)
    public boolean hasValue(int index) {
        dsTaint.addTaint(index);
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data;
        data = mData;
        final int type;
        type = data[index+AssetManager.STYLE_TYPE];
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //return type != TypedValue.TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.527 -0400", hash_original_method = "0D8F28067488CFE0F25A0D66713982F4", hash_generated_method = "93B64220C1D959E55A8D3330EB781137")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypedValue peekValue(int index) {
        dsTaint.addTaint(index);
        final TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_300481389 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
        } //End collapsed parenthetic
        return (TypedValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final TypedValue value = mValue;
        //if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            //return value;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.527 -0400", hash_original_method = "C2A30811E6FAA7EEAF3DDEC09CF05D3C", hash_generated_method = "56A5D0DB704F518B2BBDCE32830187B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPositionDescription() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Object var4E9EB5210FE4CEAE66699CD16114E32B_884505233 = (mXml.getPositionDescription());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mXml != null ? mXml.getPositionDescription() : "<internal>";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.528 -0400", hash_original_method = "A1E6C58584B412829C21C498310464D0", hash_generated_method = "3B2DE736C586EBC5AFBC745B2AEE59DB")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.528 -0400", hash_original_method = "7C5221C979A46E52D6E71FCE8A161B4A", hash_generated_method = "0166095CC9F146C62362BCC1F0C8732D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean getValueAt(int index, TypedValue outValue) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(outValue.dsTaint);
        final int[] data;
        data = mData;
        final int type;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.528 -0400", hash_original_method = "9EED998F765658475A56DE41DA4AC13D", hash_generated_method = "8B10610D4C01C7F02A85D2FF0A35B82B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence loadStringValueAt(int index) {
        dsTaint.addTaint(index);
        final int[] data;
        data = mData;
        final int cookie;
        cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        {
            {
                CharSequence varD5B9DC008EAD2EFD718C642B48F1163B_346587105 = (mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]));
            } //End block
        } //End block
        CharSequence var1CFA30FE661079CA294A9E82FD758F0E_777302187 = (mResources.mAssets.getPooledString(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.529 -0400", hash_original_method = "D3700358536036842F849ADB987A26DD", hash_generated_method = "75D313ECE968641E96C5389263BCC551")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varF5B069219DBBA960F3E0055634B0BBFD_1610690908 = (Arrays.toString(mData));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Arrays.toString(mData);
    }

    
}


