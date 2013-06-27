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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.687 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.687 -0400", hash_original_field = "31B55396FDC1E462D428736AFE79C5F1", hash_generated_field = "5B0AA5083BE633511718F93F8CB95A91")

    XmlBlock.Parser mXml;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.688 -0400", hash_original_field = "BCD13DEF7A649738D722B3798B729E0B", hash_generated_field = "A4F8D1E493616053569BD2AC1F0ABB08")

    int[] mRsrcs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.688 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "8C2374D33A80477A0B3E51CE7EB85544")

    int[] mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.688 -0400", hash_original_field = "38E6D9E425A40CF7C8EF997F011F479F", hash_generated_field = "2BB4F4BFBD9E11898040581D9D99B4FA")

    int[] mIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.688 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "FC3D477E7B6A4ACE9A379E6E41129BD1")

    int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.688 -0400", hash_original_field = "89FC4D18C6865D9655DB03AE7EA21F19", hash_generated_field = "654366000D5436FE48B31EFBD0B3756D")

    TypedValue mValue = new TypedValue();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.699 -0400", hash_original_method = "6BEE97C5D6D0C7FC7BA11425183A3047", hash_generated_method = "32DEAC4AB87004418452846E3F423055")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.699 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "9EB220326617E48580014FAE62A57DEE")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570184155 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570184155;
        // ---------- Original Method ----------
        //return mLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.710 -0400", hash_original_method = "E11A0D9421BCBF5642F2B23C8115E006", hash_generated_method = "E775726C795B44E6B818D0DECD03E206")
    public int getIndexCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_253083206 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_253083206;
        // ---------- Original Method ----------
        //return mIndices[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.710 -0400", hash_original_method = "757B3D64706707A79AF98EFF90D4FA5D", hash_generated_method = "DC8DB60B201BDDDB846ED89D18565DC2")
    public int getIndex(int at) {
        addTaint(at);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139091560 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139091560;
        // ---------- Original Method ----------
        //return mIndices[1+at];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.711 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "023514B4CCD9AE41642BB0BF359F0EC6")
    public Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_1482846190 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1482846190 = mResources;
        varB4EAC82CA7396A68D541C85D26508E83_1482846190.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1482846190;
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.739 -0400", hash_original_method = "CED8EF4F9A9EB72D36D43738FFFAF872", hash_generated_method = "2E39CC7F3DBDA52570AE34B344682083")
    public CharSequence getText(int index) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_602584756 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_833371741 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1259076721 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_971339604 = null; //Variable for return #4
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            varB4EAC82CA7396A68D541C85D26508E83_602584756 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_833371741 = loadStringValueAt(index);
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_2013657621 = (getValueAt(index, v));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1259076721 = v.coerceToString();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_971339604 = null;
        addTaint(index);
        CharSequence varA7E53CE21691AB073D9660D615818899_1426101133; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1426101133 = varB4EAC82CA7396A68D541C85D26508E83_602584756;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1426101133 = varB4EAC82CA7396A68D541C85D26508E83_833371741;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1426101133 = varB4EAC82CA7396A68D541C85D26508E83_1259076721;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1426101133 = varB4EAC82CA7396A68D541C85D26508E83_971339604;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1426101133.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1426101133;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.747 -0400", hash_original_method = "CD99FAD2F71E14195C02F12EEC83DB33", hash_generated_method = "DCFB7CDE3F3CC09CF00AD491F39F9ED5")
    public String getString(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1105856657 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_261358630 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_973696725 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1972291477 = null; //Variable for return #4
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            varB4EAC82CA7396A68D541C85D26508E83_1105856657 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_261358630 = loadStringValueAt(index).toString();
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1792372345 = (getValueAt(index, v));
            {
                CharSequence cs;
                cs = v.coerceToString();
                varB4EAC82CA7396A68D541C85D26508E83_973696725 = cs != null ? cs.toString() : null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1972291477 = null;
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1114725933; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1114725933 = varB4EAC82CA7396A68D541C85D26508E83_1105856657;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1114725933 = varB4EAC82CA7396A68D541C85D26508E83_261358630;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1114725933 = varB4EAC82CA7396A68D541C85D26508E83_973696725;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1114725933 = varB4EAC82CA7396A68D541C85D26508E83_1972291477;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1114725933.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1114725933;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.762 -0400", hash_original_method = "F340A97CD447E0B03B345E238525B650", hash_generated_method = "AE415B072FE2362FEC68594A72F7AE3F")
    public String getNonResourceString(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_819514633 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_635697599 = null; //Variable for return #2
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int cookie;
            cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
            {
                varB4EAC82CA7396A68D541C85D26508E83_819514633 = mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]).toString();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_635697599 = null;
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1365445705; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1365445705 = varB4EAC82CA7396A68D541C85D26508E83_819514633;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1365445705 = varB4EAC82CA7396A68D541C85D26508E83_635697599;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1365445705.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1365445705;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.777 -0400", hash_original_method = "5032E8B6CD1C41C8B00D83016FACB488", hash_generated_method = "F6A50BCB43124A8382428652BAFA214D")
    public String getNonConfigurationString(int index, int allowedChangingConfigs) {
        String varB4EAC82CA7396A68D541C85D26508E83_341572707 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_440504281 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1091385461 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1166906030 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1328016614 = null; //Variable for return #5
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            varB4EAC82CA7396A68D541C85D26508E83_341572707 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_440504281 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1091385461 = loadStringValueAt(index).toString();
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1418574036 = (getValueAt(index, v));
            {
                CharSequence cs;
                cs = v.coerceToString();
                varB4EAC82CA7396A68D541C85D26508E83_1166906030 = cs != null ? cs.toString() : null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1328016614 = null;
        addTaint(index);
        addTaint(allowedChangingConfigs);
        String varA7E53CE21691AB073D9660D615818899_518365700; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_518365700 = varB4EAC82CA7396A68D541C85D26508E83_341572707;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_518365700 = varB4EAC82CA7396A68D541C85D26508E83_440504281;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_518365700 = varB4EAC82CA7396A68D541C85D26508E83_1091385461;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_518365700 = varB4EAC82CA7396A68D541C85D26508E83_1166906030;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_518365700 = varB4EAC82CA7396A68D541C85D26508E83_1328016614;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_518365700.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_518365700;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.793 -0400", hash_original_method = "A16CEE5167173C9433B0C8031B10442D", hash_generated_method = "6D0E1A59F7A4196310EB7184F5721548")
    public boolean getBoolean(int index, boolean defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_550873577 = (getValueAt(index, v));
            {
                boolean var1DF74E45E6A82013BAA808D2A0B17270_1868177514 = (XmlUtils.convertValueToBoolean(
                v.coerceToString(), defValue));
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        addTaint(defValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_139046807 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_139046807;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.806 -0400", hash_original_method = "CE7034C3BE6468015CD54232F0A8137A", hash_generated_method = "482CACEDCF58537D5A9612C48FD06BEC")
    public int getInt(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_86700624 = (getValueAt(index, v));
            {
                int varC43D63FC76D52470B82B43CB94577892_2126818789 = (XmlUtils.convertValueToInt(
                v.coerceToString(), defValue));
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090226770 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1090226770;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.825 -0400", hash_original_method = "011758172267C9B5DEB37AE215F4E3BC", hash_generated_method = "A92D4A4F3308E62CD1A13A2CC0C6D5FD")
    public float getFloat(int index, float defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            float var3E5427D1CBE86332C74CFA40E97B9984_559594253 = (Float.intBitsToFloat(data[index+AssetManager.STYLE_DATA]));
        } //End block
        TypedValue v;
        v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_476567501 = (getValueAt(index, v));
            {
                CharSequence str;
                str = v.coerceToString();
                {
                    float varA095623FA4816C8D5F54F27B395BD813_764211131 = (Float.parseFloat(str.toString()));
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        addTaint(defValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1005756257 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1005756257;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.828 -0400", hash_original_method = "7882F59751F929311CA11EC559C5A65E", hash_generated_method = "7DE38612CF548F8532A8E1E6D4730A2E")
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
                boolean varA79D37EDC713ED72ECAC40127D9AD5BF_1005357781 = (getValueAt(index, value));
                {
                    ColorStateList csl;
                    csl = mResources.loadColorStateList(
                        value, value.resourceId);
                    int var9E880B265D1656C4842E5CF05322598D_194799456 = (csl.getDefaultColor());
                } //End block
            } //End collapsed parenthetic
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to color: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316109988 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1316109988;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.829 -0400", hash_original_method = "1A4CBA2C97DB5340F77B643957B9F4A1", hash_generated_method = "C9753586125E93D3A07AC9EE65787769")
    public ColorStateList getColorStateList(int index) {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_924866213 = null; //Variable for return #1
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_97508045 = null; //Variable for return #2
        TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_1205860901 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
            {
                varB4EAC82CA7396A68D541C85D26508E83_924866213 = mResources.loadColorStateList(value, value.resourceId);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_97508045 = null;
        addTaint(index);
        ColorStateList varA7E53CE21691AB073D9660D615818899_236361046; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_236361046 = varB4EAC82CA7396A68D541C85D26508E83_924866213;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_236361046 = varB4EAC82CA7396A68D541C85D26508E83_97508045;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_236361046.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_236361046;
        // ---------- Original Method ----------
        //final TypedValue value = mValue;
        //if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            //return mResources.loadColorStateList(value, value.resourceId);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.850 -0400", hash_original_method = "79362C29C94DC5BFF9E1A7E9D64A3B8E", hash_generated_method = "7699E229BA19152ADF06492F0F3F43B5")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194456429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194456429;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.862 -0400", hash_original_method = "C0FC3CC7AE2D97843F00F5A6AEA9712A", hash_generated_method = "801B3596EA8D88EA1A46A1950AA44500")
    public float getDimension(int index, float defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            float varA1522486184585892ADD51886D88796F_634768550 = (TypedValue.complexToDimension(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1791027453 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1791027453;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.864 -0400", hash_original_method = "77814E0587E00AA950C757CAE37F97F1", hash_generated_method = "432BC2D5BC00C1BBF0ABE20D1531A1BA")
    public int getDimensionPixelOffset(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var4A5F9DBCA23B6EA0EA6FDF95426DA4CC_663330492 = (TypedValue.complexToDimensionPixelOffset(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1164614754 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1164614754;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.877 -0400", hash_original_method = "FEB58959DB31428B407FA8A9132D2CB5", hash_generated_method = "FD8F9E0231B26EE118C49213B6DA52EF")
    public int getDimensionPixelSize(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_198472231 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59420582 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59420582;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.910 -0400", hash_original_method = "DB4A9B1FF17810BF297E37812D056BD1", hash_generated_method = "B423855CFD463ED1E992656AD4E686C0")
    public int getLayoutDimension(int index, String name) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_616857445 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(getPositionDescription()
                + ": You must supply a " + name + " attribute.");
        addTaint(index);
        addTaint(name.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650505346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650505346;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.912 -0400", hash_original_method = "A72B2EF9D0CF1F1E691D4D81DC434823", hash_generated_method = "0536546224355D7E04ABAE3774568AD2")
    public int getLayoutDimension(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_252375897 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343307007 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_343307007;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.921 -0400", hash_original_method = "57D8AC3F2B2D48B77A0EB4868F247839", hash_generated_method = "3A252F8CBB414A8E3334BFCAD57C075C")
    public float getFraction(int index, int base, int pbase, float defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        {
            float var783B7664A89710D9D988B33835D0AC9D_1655852820 = (TypedValue.complexToFraction(
                data[index+AssetManager.STYLE_DATA], base, pbase));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to fraction: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(base);
        addTaint(pbase);
        addTaint(defValue);
        float var546ADE640B6EDFBC8A086EF31347E768_483168517 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_483168517;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:09.923 -0400", hash_original_method = "DF47714E2511EE2CB8E5736FC0D36FFE", hash_generated_method = "B5F3C24BD7D1563BDAD81DA73F60DB16")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653156658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653156658;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.011 -0400", hash_original_method = "4764631566003CBA3FBDF6AEC7E40184", hash_generated_method = "741FE29D5AB716D95DE3383480C28408")
    public Drawable getDrawable(int index) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1309395027 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_529614734 = null; //Variable for return #2
        TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_191236960 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
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
                varB4EAC82CA7396A68D541C85D26508E83_1309395027 = mResources.loadDrawable(value, value.resourceId);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_529614734 = null;
        addTaint(index);
        Drawable varA7E53CE21691AB073D9660D615818899_606406304; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_606406304 = varB4EAC82CA7396A68D541C85D26508E83_1309395027;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_606406304 = varB4EAC82CA7396A68D541C85D26508E83_529614734;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_606406304.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_606406304;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.027 -0400", hash_original_method = "DE841974CEC89F1656E36D821FAC9EE9", hash_generated_method = "AA1CB54AB976E06261D9370F0A35E2FA")
    public CharSequence[] getTextArray(int index) {
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_1841160807 = null; //Variable for return #1
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_650955162 = null; //Variable for return #2
        TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_1010744500 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
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
                varB4EAC82CA7396A68D541C85D26508E83_1841160807 = mResources.getTextArray(value.resourceId);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_650955162 = null;
        addTaint(index);
        CharSequence[] varA7E53CE21691AB073D9660D615818899_1871701756; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1871701756 = varB4EAC82CA7396A68D541C85D26508E83_1841160807;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1871701756 = varB4EAC82CA7396A68D541C85D26508E83_650955162;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1871701756.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1871701756;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.043 -0400", hash_original_method = "0C857F8AC76CD5CFBE7569B581103BDD", hash_generated_method = "D60D0CBF0FBF4BD476D91E5B01015103")
    public boolean getValue(int index, TypedValue outValue) {
        boolean varA337BC1324677280D08B6023F41FDF45_468260465 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue));
        addTaint(index);
        addTaint(outValue.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_579612541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_579612541;
        // ---------- Original Method ----------
        //return getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.044 -0400", hash_original_method = "0EF762AB49E40F4FF6959DF2595733A2", hash_generated_method = "CEEBF382701F9AC8714F213C0E284A9D")
    public boolean hasValue(int index) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        int[] data;
        data = mData;
        int type;
        type = data[index+AssetManager.STYLE_TYPE];
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_518826977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_518826977;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //return type != TypedValue.TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.051 -0400", hash_original_method = "0D8F28067488CFE0F25A0D66713982F4", hash_generated_method = "A748D3457E9451D4183F2442ABD7939E")
    public TypedValue peekValue(int index) {
        TypedValue varB4EAC82CA7396A68D541C85D26508E83_632201267 = null; //Variable for return #1
        TypedValue varB4EAC82CA7396A68D541C85D26508E83_1083958559 = null; //Variable for return #2
        TypedValue value;
        value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_748580754 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
            {
                varB4EAC82CA7396A68D541C85D26508E83_632201267 = value;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1083958559 = null;
        addTaint(index);
        TypedValue varA7E53CE21691AB073D9660D615818899_888277698; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_888277698 = varB4EAC82CA7396A68D541C85D26508E83_632201267;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_888277698 = varB4EAC82CA7396A68D541C85D26508E83_1083958559;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_888277698.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_888277698;
        // ---------- Original Method ----------
        //final TypedValue value = mValue;
        //if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            //return value;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.060 -0400", hash_original_method = "C2A30811E6FAA7EEAF3DDEC09CF05D3C", hash_generated_method = "CCBBC50388296D3BD864071DE20658B6")
    public String getPositionDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_398070209 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_398070209 = mXml != null ? mXml.getPositionDescription() : "<internal>";
        varB4EAC82CA7396A68D541C85D26508E83_398070209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_398070209;
        // ---------- Original Method ----------
        //return mXml != null ? mXml.getPositionDescription() : "<internal>";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.061 -0400", hash_original_method = "A1E6C58584B412829C21C498310464D0", hash_generated_method = "BC4048992AF4E8301F4BD98BC8194937")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.095 -0400", hash_original_method = "7C5221C979A46E52D6E71FCE8A161B4A", hash_generated_method = "AA9787BC9F3A3297B4995CF50CF23037")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961023068 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961023068;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.100 -0400", hash_original_method = "9EED998F765658475A56DE41DA4AC13D", hash_generated_method = "9D6E2652338E5FCA3A3801138950ABC0")
    private CharSequence loadStringValueAt(int index) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1304175638 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_887476112 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1336188229 = null; //Variable for return #3
        int[] data;
        data = mData;
        int cookie;
        cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1304175638 = mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_887476112 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1336188229 = mResources.mAssets.getPooledString(
            cookie, data[index+AssetManager.STYLE_DATA]);
        addTaint(index);
        CharSequence varA7E53CE21691AB073D9660D615818899_724143160; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_724143160 = varB4EAC82CA7396A68D541C85D26508E83_1304175638;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_724143160 = varB4EAC82CA7396A68D541C85D26508E83_887476112;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_724143160 = varB4EAC82CA7396A68D541C85D26508E83_1336188229;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_724143160.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_724143160;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.101 -0400", hash_original_method = "D3700358536036842F849ADB987A26DD", hash_generated_method = "468B116299292EC4140F1787B87601B2")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1389159171 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1389159171 = Arrays.toString(mData);
        varB4EAC82CA7396A68D541C85D26508E83_1389159171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1389159171;
        // ---------- Original Method ----------
        //return Arrays.toString(mData);
    }

    
}

