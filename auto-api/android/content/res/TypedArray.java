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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.180 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.181 -0400", hash_original_field = "31B55396FDC1E462D428736AFE79C5F1", hash_generated_field = "5B0AA5083BE633511718F93F8CB95A91")

    XmlBlock.Parser mXml;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.181 -0400", hash_original_field = "BCD13DEF7A649738D722B3798B729E0B", hash_generated_field = "A4F8D1E493616053569BD2AC1F0ABB08")

    int[] mRsrcs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.181 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "8C2374D33A80477A0B3E51CE7EB85544")

    int[] mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.181 -0400", hash_original_field = "38E6D9E425A40CF7C8EF997F011F479F", hash_generated_field = "2BB4F4BFBD9E11898040581D9D99B4FA")

    int[] mIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.182 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "FC3D477E7B6A4ACE9A379E6E41129BD1")

    int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.182 -0400", hash_original_field = "89FC4D18C6865D9655DB03AE7EA21F19", hash_generated_field = "654366000D5436FE48B31EFBD0B3756D")

    TypedValue mValue = new TypedValue();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.211 -0400", hash_original_method = "6BEE97C5D6D0C7FC7BA11425183A3047", hash_generated_method = "32DEAC4AB87004418452846E3F423055")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.212 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "A05D6A45FC03371DCC727C766304B6B1")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2060385208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2060385208;
        // ---------- Original Method ----------
        //return mLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.212 -0400", hash_original_method = "E11A0D9421BCBF5642F2B23C8115E006", hash_generated_method = "E4D8FF75EF867DFC5AD51010FE0EB447")
    public int getIndexCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181522608 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181522608;
        // ---------- Original Method ----------
        //return mIndices[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.224 -0400", hash_original_method = "757B3D64706707A79AF98EFF90D4FA5D", hash_generated_method = "2D134588FD6346D908B27A30F34A3443")
    public int getIndex(int at) {
        addTaint(at);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919856534 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919856534;
        // ---------- Original Method ----------
        //return mIndices[1+at];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.225 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "DFB52B5C113ABA5AA4FA21CC8E88AC2E")
    public Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_414977075 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_414977075 = mResources;
        varB4EAC82CA7396A68D541C85D26508E83_414977075.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_414977075;
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.232 -0400", hash_original_method = "CED8EF4F9A9EB72D36D43738FFFAF872", hash_generated_method = "A38D78BA32D7E3C7DE981E7D1D6D6BEF")
    public CharSequence getText(int index) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_299931258 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2106906138 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_521105983 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1660386107 = null; //Variable for return #4
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            varB4EAC82CA7396A68D541C85D26508E83_299931258 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2106906138 = loadStringValueAt(index);
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1807466202 = (getValueAt(index, v));
            {
                varB4EAC82CA7396A68D541C85D26508E83_521105983 = v.coerceToString();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1660386107 = null;
        addTaint(index);
        CharSequence varA7E53CE21691AB073D9660D615818899_1656537339; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1656537339 = varB4EAC82CA7396A68D541C85D26508E83_299931258;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1656537339 = varB4EAC82CA7396A68D541C85D26508E83_2106906138;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1656537339 = varB4EAC82CA7396A68D541C85D26508E83_521105983;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1656537339 = varB4EAC82CA7396A68D541C85D26508E83_1660386107;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1656537339.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1656537339;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.251 -0400", hash_original_method = "CD99FAD2F71E14195C02F12EEC83DB33", hash_generated_method = "EEF1D604DF57F82C4E5A0846CAA98453")
    public String getString(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_2075354240 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1937189301 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_459032658 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_917886305 = null; //Variable for return #4
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            varB4EAC82CA7396A68D541C85D26508E83_2075354240 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1937189301 = loadStringValueAt(index).toString();
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_925211285 = (getValueAt(index, v));
            {
                CharSequence cs;
                cs = v.coerceToString();
                varB4EAC82CA7396A68D541C85D26508E83_459032658 = cs != null ? cs.toString() : null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_917886305 = null;
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_162775593; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_162775593 = varB4EAC82CA7396A68D541C85D26508E83_2075354240;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_162775593 = varB4EAC82CA7396A68D541C85D26508E83_1937189301;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_162775593 = varB4EAC82CA7396A68D541C85D26508E83_459032658;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_162775593 = varB4EAC82CA7396A68D541C85D26508E83_917886305;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_162775593.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_162775593;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.273 -0400", hash_original_method = "F340A97CD447E0B03B345E238525B650", hash_generated_method = "81A7D8F20D9AFBF827B0EE9BED0D0D81")
    public String getNonResourceString(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_301629228 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1430314693 = null; //Variable for return #2
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int cookie;
            cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
            {
                varB4EAC82CA7396A68D541C85D26508E83_301629228 = mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]).toString();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1430314693 = null;
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_2104719080; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2104719080 = varB4EAC82CA7396A68D541C85D26508E83_301629228;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2104719080 = varB4EAC82CA7396A68D541C85D26508E83_1430314693;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2104719080.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2104719080;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.299 -0400", hash_original_method = "5032E8B6CD1C41C8B00D83016FACB488", hash_generated_method = "1DC402C31C61B281AFF41E3EE1E0AE54")
    public String getNonConfigurationString(int index, int allowedChangingConfigs) {
        String varB4EAC82CA7396A68D541C85D26508E83_306474785 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_938954166 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1236814269 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1576125088 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1012743511 = null; //Variable for return #5
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            varB4EAC82CA7396A68D541C85D26508E83_306474785 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_938954166 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1236814269 = loadStringValueAt(index).toString();
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1955231154 = (getValueAt(index, v));
            {
                CharSequence cs;
                cs = v.coerceToString();
                varB4EAC82CA7396A68D541C85D26508E83_1576125088 = cs != null ? cs.toString() : null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1012743511 = null;
        addTaint(index);
        addTaint(allowedChangingConfigs);
        String varA7E53CE21691AB073D9660D615818899_2111535762; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2111535762 = varB4EAC82CA7396A68D541C85D26508E83_306474785;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2111535762 = varB4EAC82CA7396A68D541C85D26508E83_938954166;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2111535762 = varB4EAC82CA7396A68D541C85D26508E83_1236814269;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2111535762 = varB4EAC82CA7396A68D541C85D26508E83_1576125088;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2111535762 = varB4EAC82CA7396A68D541C85D26508E83_1012743511;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2111535762.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2111535762;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.313 -0400", hash_original_method = "A16CEE5167173C9433B0C8031B10442D", hash_generated_method = "2EADD624C0F219B4208AB27824BAEA11")
    public boolean getBoolean(int index, boolean defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1599293709 = (getValueAt(index, v));
            {
                boolean var1DF74E45E6A82013BAA808D2A0B17270_239427101 = (XmlUtils.convertValueToBoolean(
                v.coerceToString(), defValue));
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        addTaint(defValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1460768345 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1460768345;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.316 -0400", hash_original_method = "CE7034C3BE6468015CD54232F0A8137A", hash_generated_method = "7F8EC86771C1A8A59928DC075051521A")
    public int getInt(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_189472288 = (getValueAt(index, v));
            {
                int varC43D63FC76D52470B82B43CB94577892_1714179526 = (XmlUtils.convertValueToInt(
                v.coerceToString(), defValue));
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_617424850 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_617424850;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.336 -0400", hash_original_method = "011758172267C9B5DEB37AE215F4E3BC", hash_generated_method = "810D73493AEDDEA3B5476D4E34C83B11")
    public float getFloat(int index, float defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            float var3E5427D1CBE86332C74CFA40E97B9984_1404528166 = (Float.intBitsToFloat(data[index+AssetManager.STYLE_DATA]));
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_809078794 = (getValueAt(index, v));
            {
                CharSequence str;
                str = v.coerceToString();
                {
                    float varA095623FA4816C8D5F54F27B395BD813_1011702474 = (Float.parseFloat(str.toString()));
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        addTaint(defValue);
        float var546ADE640B6EDFBC8A086EF31347E768_60254397 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_60254397;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.344 -0400", hash_original_method = "7882F59751F929311CA11EC559C5A65E", hash_generated_method = "07D28F08584AEF77092976CE9D19F75C")
    public int getColor(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            TypedValue value;
            value = mValue;
            {
                boolean varA79D37EDC713ED72ECAC40127D9AD5BF_1100724654 = (getValueAt(index, value));
                {
                    ColorStateList csl;
                    csl = mResources.loadColorStateList(
                        value, value.resourceId);
                    int var9E880B265D1656C4842E5CF05322598D_767426610 = (csl.getDefaultColor());
                } //End block
            } //End collapsed parenthetic
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to color: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1654543214 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1654543214;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.364 -0400", hash_original_method = "1A4CBA2C97DB5340F77B643957B9F4A1", hash_generated_method = "54B47C393D8BE736D242085D2B4124C0")
    public ColorStateList getColorStateList(int index) {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_1876098662 = null; //Variable for return #1
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_762675990 = null; //Variable for return #2
        TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_247916154 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1876098662 = mResources.loadColorStateList(value, value.resourceId);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_762675990 = null;
        addTaint(index);
        ColorStateList varA7E53CE21691AB073D9660D615818899_678607459; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_678607459 = varB4EAC82CA7396A68D541C85D26508E83_1876098662;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_678607459 = varB4EAC82CA7396A68D541C85D26508E83_762675990;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_678607459.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_678607459;
        // ---------- Original Method ----------
        //final TypedValue value = mValue;
        //if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            //return mResources.loadColorStateList(value, value.resourceId);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.368 -0400", hash_original_method = "79362C29C94DC5BFF9E1A7E9D64A3B8E", hash_generated_method = "3AD0854417F05ECF81AA22A770118FE8")
    public int getInteger(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to integer: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417522180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1417522180;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.380 -0400", hash_original_method = "C0FC3CC7AE2D97843F00F5A6AEA9712A", hash_generated_method = "4D321B54820CEDF66FA3FE495E2CA0D0")
    public float getDimension(int index, float defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            float varA1522486184585892ADD51886D88796F_1825217711 = (TypedValue.complexToDimension(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        float var546ADE640B6EDFBC8A086EF31347E768_823331917 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_823331917;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.398 -0400", hash_original_method = "77814E0587E00AA950C757CAE37F97F1", hash_generated_method = "1C12314DC619A29F5F998868EB76C82C")
    public int getDimensionPixelOffset(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var4A5F9DBCA23B6EA0EA6FDF95426DA4CC_1503270811 = (TypedValue.complexToDimensionPixelOffset(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586178038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586178038;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.404 -0400", hash_original_method = "FEB58959DB31428B407FA8A9132D2CB5", hash_generated_method = "A953B3CBEB299E393424DD4A034D7A68")
    public int getDimensionPixelSize(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_185356065 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1666393515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1666393515;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.418 -0400", hash_original_method = "DB4A9B1FF17810BF297E37812D056BD1", hash_generated_method = "933D6BA7B7EB88693F0D6D3A278C614E")
    public int getLayoutDimension(int index, String name) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_235042247 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(getPositionDescription()
                + ": You must supply a " + name + " attribute.");
        addTaint(index);
        addTaint(name.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62886232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62886232;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.430 -0400", hash_original_method = "A72B2EF9D0CF1F1E691D4D81DC434823", hash_generated_method = "92688C5F161AA2D9F50F3A2B3618FCBE")
    public int getLayoutDimension(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_798685587 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1714757335 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1714757335;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.434 -0400", hash_original_method = "57D8AC3F2B2D48B77A0EB4868F247839", hash_generated_method = "25AC32371D168E4B3F33A0A1DF762FED")
    public float getFraction(int index, int base, int pbase, float defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            float var783B7664A89710D9D988B33835D0AC9D_2096413616 = (TypedValue.complexToFraction(
                data[index+AssetManager.STYLE_DATA], base, pbase));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to fraction: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(base);
        addTaint(pbase);
        addTaint(defValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1023114899 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1023114899;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.454 -0400", hash_original_method = "DF47714E2511EE2CB8E5736FC0D36FFE", hash_generated_method = "D365626ECECA7FE02F3A20401CF39013")
    public int getResourceId(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        {
            int resid;
            resid = data[index+AssetManager.STYLE_RESOURCE_ID];
        } //End block
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2084082249 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2084082249;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.457 -0400", hash_original_method = "4764631566003CBA3FBDF6AEC7E40184", hash_generated_method = "954F448D6368C36256C5BBAA9CCAC1D0")
    public Drawable getDrawable(int index) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_244750945 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1116803756 = null; //Variable for return #2
        TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_1956291939 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
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
                varB4EAC82CA7396A68D541C85D26508E83_244750945 = mResources.loadDrawable(value, value.resourceId);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1116803756 = null;
        addTaint(index);
        Drawable varA7E53CE21691AB073D9660D615818899_1196352916; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1196352916 = varB4EAC82CA7396A68D541C85D26508E83_244750945;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1196352916 = varB4EAC82CA7396A68D541C85D26508E83_1116803756;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1196352916.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1196352916;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.479 -0400", hash_original_method = "DE841974CEC89F1656E36D821FAC9EE9", hash_generated_method = "00E1702D44A7204EDF84F86DEA99F95B")
    public CharSequence[] getTextArray(int index) {
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_194760703 = null; //Variable for return #1
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_2037338202 = null; //Variable for return #2
        TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_968119610 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
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
                varB4EAC82CA7396A68D541C85D26508E83_194760703 = mResources.getTextArray(value.resourceId);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2037338202 = null;
        addTaint(index);
        CharSequence[] varA7E53CE21691AB073D9660D615818899_503129922; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_503129922 = varB4EAC82CA7396A68D541C85D26508E83_194760703;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_503129922 = varB4EAC82CA7396A68D541C85D26508E83_2037338202;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_503129922.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_503129922;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.496 -0400", hash_original_method = "0C857F8AC76CD5CFBE7569B581103BDD", hash_generated_method = "39A90FDF418ECAAACA9A321A4C6CFE55")
    public boolean getValue(int index, TypedValue outValue) {
        boolean varA337BC1324677280D08B6023F41FDF45_222632053 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue));
        addTaint(index);
        addTaint(outValue.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_869544581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_869544581;
        // ---------- Original Method ----------
        //return getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.498 -0400", hash_original_method = "0EF762AB49E40F4FF6959DF2595733A2", hash_generated_method = "CD50BDDFE158D04F7F8E13E09A5DDB81")
    public boolean hasValue(int index) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1305566572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1305566572;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //return type != TypedValue.TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.499 -0400", hash_original_method = "0D8F28067488CFE0F25A0D66713982F4", hash_generated_method = "C76823BF316524BA549260F411D98110")
    public TypedValue peekValue(int index) {
        TypedValue varB4EAC82CA7396A68D541C85D26508E83_1755378526 = null; //Variable for return #1
        TypedValue varB4EAC82CA7396A68D541C85D26508E83_1938569717 = null; //Variable for return #2
        TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_1231662019 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1755378526 = value;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1938569717 = null;
        addTaint(index);
        TypedValue varA7E53CE21691AB073D9660D615818899_1758123563; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1758123563 = varB4EAC82CA7396A68D541C85D26508E83_1755378526;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1758123563 = varB4EAC82CA7396A68D541C85D26508E83_1938569717;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1758123563.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1758123563;
        // ---------- Original Method ----------
        //final TypedValue value = mValue;
        //if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            //return value;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.500 -0400", hash_original_method = "C2A30811E6FAA7EEAF3DDEC09CF05D3C", hash_generated_method = "53B274179E7D91A85DDCBE05BC579134")
    public String getPositionDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_882706645 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_882706645 = mXml != null ? mXml.getPositionDescription() : "<internal>";
        varB4EAC82CA7396A68D541C85D26508E83_882706645.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_882706645;
        // ---------- Original Method ----------
        //return mXml != null ? mXml.getPositionDescription() : "<internal>";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.521 -0400", hash_original_method = "A1E6C58584B412829C21C498310464D0", hash_generated_method = "BC4048992AF4E8301F4BD98BC8194937")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.539 -0400", hash_original_method = "7C5221C979A46E52D6E71FCE8A161B4A", hash_generated_method = "276A82F991D35B9D00BD0EE3252A290C")
    private boolean getValueAt(int index, TypedValue outValue) {
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
        addTaint(index);
        addTaint(outValue.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1524591556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1524591556;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.553 -0400", hash_original_method = "9EED998F765658475A56DE41DA4AC13D", hash_generated_method = "0D3031C21185EA54039FD788DDD3F9A5")
    private CharSequence loadStringValueAt(int index) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_186378485 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1663342618 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_92017946 = null; //Variable for return #3
        int[] data;
        data = mData;
        int cookie;
        cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_186378485 = mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1663342618 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_92017946 = mResources.mAssets.getPooledString(
            cookie, data[index+AssetManager.STYLE_DATA]);
        addTaint(index);
        CharSequence varA7E53CE21691AB073D9660D615818899_799724385; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_799724385 = varB4EAC82CA7396A68D541C85D26508E83_186378485;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_799724385 = varB4EAC82CA7396A68D541C85D26508E83_1663342618;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_799724385 = varB4EAC82CA7396A68D541C85D26508E83_92017946;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_799724385.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_799724385;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:08.554 -0400", hash_original_method = "D3700358536036842F849ADB987A26DD", hash_generated_method = "C4E99548A244FDA9539A72681274E944")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_115899129 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_115899129 = Arrays.toString(mData);
        varB4EAC82CA7396A68D541C85D26508E83_115899129.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_115899129;
        // ---------- Original Method ----------
        //return Arrays.toString(mData);
    }

    
}

