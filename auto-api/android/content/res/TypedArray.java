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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.335 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.336 -0400", hash_original_field = "31B55396FDC1E462D428736AFE79C5F1", hash_generated_field = "5B0AA5083BE633511718F93F8CB95A91")

    XmlBlock.Parser mXml;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.336 -0400", hash_original_field = "BCD13DEF7A649738D722B3798B729E0B", hash_generated_field = "A4F8D1E493616053569BD2AC1F0ABB08")

    int[] mRsrcs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.336 -0400", hash_original_field = "B7DE4FF1B7CCEFDA36733D8B6DFF2904", hash_generated_field = "8C2374D33A80477A0B3E51CE7EB85544")

    int[] mData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.336 -0400", hash_original_field = "38E6D9E425A40CF7C8EF997F011F479F", hash_generated_field = "2BB4F4BFBD9E11898040581D9D99B4FA")

    int[] mIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.336 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "FC3D477E7B6A4ACE9A379E6E41129BD1")

    int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.336 -0400", hash_original_field = "89FC4D18C6865D9655DB03AE7EA21F19", hash_generated_field = "654366000D5436FE48B31EFBD0B3756D")

    TypedValue mValue = new TypedValue();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.336 -0400", hash_original_method = "6BEE97C5D6D0C7FC7BA11425183A3047", hash_generated_method = "32DEAC4AB87004418452846E3F423055")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.337 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "98052EEA65E589320BDBB898234656CB")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1607897145 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1607897145;
        // ---------- Original Method ----------
        //return mLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.337 -0400", hash_original_method = "E11A0D9421BCBF5642F2B23C8115E006", hash_generated_method = "46EE56A32966ABA5ABBF822B0D24026C")
    public int getIndexCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_204443745 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_204443745;
        // ---------- Original Method ----------
        //return mIndices[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.338 -0400", hash_original_method = "757B3D64706707A79AF98EFF90D4FA5D", hash_generated_method = "977771BB5D831DF1E8960DB278F2F3BB")
    public int getIndex(int at) {
        addTaint(at);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116453767 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116453767;
        // ---------- Original Method ----------
        //return mIndices[1+at];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.339 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "C41E40E509B9B1CBCCE3E521EC1C6699")
    public Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_1458871943 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1458871943 = mResources;
        varB4EAC82CA7396A68D541C85D26508E83_1458871943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1458871943;
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.340 -0400", hash_original_method = "CED8EF4F9A9EB72D36D43738FFFAF872", hash_generated_method = "0FA684417D95400FA533B0D530FFF218")
    public CharSequence getText(int index) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1208170909 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2079086690 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_786175622 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1886532498 = null; //Variable for return #4
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        {
            varB4EAC82CA7396A68D541C85D26508E83_1208170909 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2079086690 = loadStringValueAt(index);
        } //End block
        TypedValue v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1103989105 = (getValueAt(index, v));
            {
                varB4EAC82CA7396A68D541C85D26508E83_786175622 = v.coerceToString();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1886532498 = null;
        addTaint(index);
        CharSequence varA7E53CE21691AB073D9660D615818899_748570518; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_748570518 = varB4EAC82CA7396A68D541C85D26508E83_1208170909;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_748570518 = varB4EAC82CA7396A68D541C85D26508E83_2079086690;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_748570518 = varB4EAC82CA7396A68D541C85D26508E83_786175622;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_748570518 = varB4EAC82CA7396A68D541C85D26508E83_1886532498;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_748570518.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_748570518;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.342 -0400", hash_original_method = "CD99FAD2F71E14195C02F12EEC83DB33", hash_generated_method = "A96E361C5061FA90D79AD345CB076FB1")
    public String getString(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_809079353 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1331182871 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1495013916 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1245063560 = null; //Variable for return #4
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        {
            varB4EAC82CA7396A68D541C85D26508E83_809079353 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1331182871 = loadStringValueAt(index).toString();
        } //End block
        TypedValue v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1268599391 = (getValueAt(index, v));
            {
                CharSequence cs = v.coerceToString();
                varB4EAC82CA7396A68D541C85D26508E83_1495013916 = cs != null ? cs.toString() : null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1245063560 = null;
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1470792385; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1470792385 = varB4EAC82CA7396A68D541C85D26508E83_809079353;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1470792385 = varB4EAC82CA7396A68D541C85D26508E83_1331182871;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1470792385 = varB4EAC82CA7396A68D541C85D26508E83_1495013916;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1470792385 = varB4EAC82CA7396A68D541C85D26508E83_1245063560;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1470792385.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1470792385;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.343 -0400", hash_original_method = "F340A97CD447E0B03B345E238525B650", hash_generated_method = "9A5B00D9418E88AA86605A1462F37D05")
    public String getNonResourceString(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1814947072 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1391593887 = null; //Variable for return #2
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        {
            final int cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
            {
                varB4EAC82CA7396A68D541C85D26508E83_1814947072 = mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]).toString();
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1391593887 = null;
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_2127429751; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2127429751 = varB4EAC82CA7396A68D541C85D26508E83_1814947072;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2127429751 = varB4EAC82CA7396A68D541C85D26508E83_1391593887;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2127429751.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2127429751;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.344 -0400", hash_original_method = "5032E8B6CD1C41C8B00D83016FACB488", hash_generated_method = "AD5B3CAD5F67A6440A8142B8D8E6AFDA")
    public String getNonConfigurationString(int index, int allowedChangingConfigs) {
        String varB4EAC82CA7396A68D541C85D26508E83_1761247781 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1906206505 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1485831924 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1550493659 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1288185803 = null; //Variable for return #5
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        {
            varB4EAC82CA7396A68D541C85D26508E83_1761247781 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1906206505 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1485831924 = loadStringValueAt(index).toString();
        } //End block
        TypedValue v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_637722876 = (getValueAt(index, v));
            {
                CharSequence cs = v.coerceToString();
                varB4EAC82CA7396A68D541C85D26508E83_1550493659 = cs != null ? cs.toString() : null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1288185803 = null;
        addTaint(index);
        addTaint(allowedChangingConfigs);
        String varA7E53CE21691AB073D9660D615818899_2082757108; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2082757108 = varB4EAC82CA7396A68D541C85D26508E83_1761247781;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2082757108 = varB4EAC82CA7396A68D541C85D26508E83_1906206505;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2082757108 = varB4EAC82CA7396A68D541C85D26508E83_1485831924;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2082757108 = varB4EAC82CA7396A68D541C85D26508E83_1550493659;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2082757108 = varB4EAC82CA7396A68D541C85D26508E83_1288185803;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2082757108.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2082757108;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.345 -0400", hash_original_method = "A16CEE5167173C9433B0C8031B10442D", hash_generated_method = "659833F99229647C9B5B62E7F3D0E9D8")
    public boolean getBoolean(int index, boolean defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        TypedValue v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1866658769 = (getValueAt(index, v));
            {
                boolean var1DF74E45E6A82013BAA808D2A0B17270_370066922 = (XmlUtils.convertValueToBoolean(
                v.coerceToString(), defValue));
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        addTaint(defValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1985730357 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1985730357;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.346 -0400", hash_original_method = "CE7034C3BE6468015CD54232F0A8137A", hash_generated_method = "D53F16F4CCA0BEEA8D5195CA2587BCF8")
    public int getInt(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        TypedValue v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_49311814 = (getValueAt(index, v));
            {
                int varC43D63FC76D52470B82B43CB94577892_590556764 = (XmlUtils.convertValueToInt(
                v.coerceToString(), defValue));
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025755347 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025755347;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.346 -0400", hash_original_method = "011758172267C9B5DEB37AE215F4E3BC", hash_generated_method = "DC29D919F258C5FB12680BCDC45D2885")
    public float getFloat(int index, float defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        {
            float var3E5427D1CBE86332C74CFA40E97B9984_765323630 = (Float.intBitsToFloat(data[index+AssetManager.STYLE_DATA]));
        } //End block
        TypedValue v = mValue;
        {
            boolean varC077D91E50ABAB34FC57F7B260E457C3_1317404886 = (getValueAt(index, v));
            {
                CharSequence str = v.coerceToString();
                {
                    float varA095623FA4816C8D5F54F27B395BD813_174665741 = (Float.parseFloat(str.toString()));
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        addTaint(defValue);
        float var546ADE640B6EDFBC8A086EF31347E768_561456163 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_561456163;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.347 -0400", hash_original_method = "7882F59751F929311CA11EC559C5A65E", hash_generated_method = "56AF5BB8183C06F8BA576098EBA6943B")
    public int getColor(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        {
            final TypedValue value = mValue;
            {
                boolean varA79D37EDC713ED72ECAC40127D9AD5BF_990003951 = (getValueAt(index, value));
                {
                    ColorStateList csl = mResources.loadColorStateList(
                        value, value.resourceId);
                    int var9E880B265D1656C4842E5CF05322598D_645829682 = (csl.getDefaultColor());
                } //End block
            } //End collapsed parenthetic
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to color: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260250688 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260250688;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.348 -0400", hash_original_method = "1A4CBA2C97DB5340F77B643957B9F4A1", hash_generated_method = "DDC5AEF12FDDB9A104E9C5E5F349E97B")
    public ColorStateList getColorStateList(int index) {
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_1039996699 = null; //Variable for return #1
        ColorStateList varB4EAC82CA7396A68D541C85D26508E83_1962507985 = null; //Variable for return #2
        final TypedValue value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_1738918512 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1039996699 = mResources.loadColorStateList(value, value.resourceId);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1962507985 = null;
        addTaint(index);
        ColorStateList varA7E53CE21691AB073D9660D615818899_1689733581; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1689733581 = varB4EAC82CA7396A68D541C85D26508E83_1039996699;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1689733581 = varB4EAC82CA7396A68D541C85D26508E83_1962507985;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1689733581.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1689733581;
        // ---------- Original Method ----------
        //final TypedValue value = mValue;
        //if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            //return mResources.loadColorStateList(value, value.resourceId);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.349 -0400", hash_original_method = "79362C29C94DC5BFF9E1A7E9D64A3B8E", hash_generated_method = "2BB7F5A9ECFA05B50F60C82C1B2DF1AE")
    public int getInteger(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to integer: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75754416 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75754416;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.350 -0400", hash_original_method = "C0FC3CC7AE2D97843F00F5A6AEA9712A", hash_generated_method = "2AD105BAE89E9936898564E8DE84C769")
    public float getDimension(int index, float defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        {
            float varA1522486184585892ADD51886D88796F_310407762 = (TypedValue.complexToDimension(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        float var546ADE640B6EDFBC8A086EF31347E768_557794437 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_557794437;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.351 -0400", hash_original_method = "77814E0587E00AA950C757CAE37F97F1", hash_generated_method = "08A0A988C20EF1A6A79FFC3605EB07FA")
    public int getDimensionPixelOffset(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        {
            int var4A5F9DBCA23B6EA0EA6FDF95426DA4CC_1629085639 = (TypedValue.complexToDimensionPixelOffset(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556417201 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556417201;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.352 -0400", hash_original_method = "FEB58959DB31428B407FA8A9132D2CB5", hash_generated_method = "B6DA30F99C37A14DBAFD9FB47E7A60D4")
    public int getDimensionPixelSize(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_723795305 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314074862 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314074862;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.353 -0400", hash_original_method = "DB4A9B1FF17810BF297E37812D056BD1", hash_generated_method = "233A039EE7222465C2671E491366701D")
    public int getLayoutDimension(int index, String name) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_484385695 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(getPositionDescription()
                + ": You must supply a " + name + " attribute.");
        addTaint(index);
        addTaint(name.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_685863323 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_685863323;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.354 -0400", hash_original_method = "A72B2EF9D0CF1F1E691D4D81DC434823", hash_generated_method = "0178B499486C88D81E1B9AA8CE52D196")
    public int getLayoutDimension(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        {
            int var922D68BAEC7F02CD7AA1064E49243482_1931492170 = (TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics));
        } //End block
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1752657645 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1752657645;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.354 -0400", hash_original_method = "57D8AC3F2B2D48B77A0EB4868F247839", hash_generated_method = "A5649F49147E8EB474D14551072EBFC7")
    public float getFraction(int index, int base, int pbase, float defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        {
            float var783B7664A89710D9D988B33835D0AC9D_360235684 = (TypedValue.complexToFraction(
                data[index+AssetManager.STYLE_DATA], base, pbase));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Can't convert to fraction: type=0x"
                + Integer.toHexString(type));
        addTaint(index);
        addTaint(base);
        addTaint(pbase);
        addTaint(defValue);
        float var546ADE640B6EDFBC8A086EF31347E768_595773990 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_595773990;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.355 -0400", hash_original_method = "DF47714E2511EE2CB8E5736FC0D36FFE", hash_generated_method = "93E40159E4A91BC6FB375E14B7C0CED8")
    public int getResourceId(int index, int defValue) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        {
            final int resid = data[index+AssetManager.STYLE_RESOURCE_ID];
        } //End block
        addTaint(index);
        addTaint(defValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372971428 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372971428;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.356 -0400", hash_original_method = "4764631566003CBA3FBDF6AEC7E40184", hash_generated_method = "44A2BCC74BC114E453A16850DBD30985")
    public Drawable getDrawable(int index) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_340396536 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1337540477 = null; //Variable for return #2
        final TypedValue value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_764837824 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
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
                varB4EAC82CA7396A68D541C85D26508E83_340396536 = mResources.loadDrawable(value, value.resourceId);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1337540477 = null;
        addTaint(index);
        Drawable varA7E53CE21691AB073D9660D615818899_1197525932; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1197525932 = varB4EAC82CA7396A68D541C85D26508E83_340396536;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1197525932 = varB4EAC82CA7396A68D541C85D26508E83_1337540477;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1197525932.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1197525932;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.357 -0400", hash_original_method = "DE841974CEC89F1656E36D821FAC9EE9", hash_generated_method = "AF16DE4741F3AEDB7950CC6DD1797BB5")
    public CharSequence[] getTextArray(int index) {
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_1947935318 = null; //Variable for return #1
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_1246120169 = null; //Variable for return #2
        final TypedValue value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_515917503 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
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
                varB4EAC82CA7396A68D541C85D26508E83_1947935318 = mResources.getTextArray(value.resourceId);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1246120169 = null;
        addTaint(index);
        CharSequence[] varA7E53CE21691AB073D9660D615818899_1924226257; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1924226257 = varB4EAC82CA7396A68D541C85D26508E83_1947935318;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1924226257 = varB4EAC82CA7396A68D541C85D26508E83_1246120169;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1924226257.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1924226257;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.357 -0400", hash_original_method = "0C857F8AC76CD5CFBE7569B581103BDD", hash_generated_method = "71E092A2B596DE9E6476D4DD2D674A82")
    public boolean getValue(int index, TypedValue outValue) {
        boolean varA337BC1324677280D08B6023F41FDF45_1615821093 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue));
        addTaint(index);
        addTaint(outValue.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2025373774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2025373774;
        // ---------- Original Method ----------
        //return getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.358 -0400", hash_original_method = "0EF762AB49E40F4FF6959DF2595733A2", hash_generated_method = "4765E56DC7E3EC32053A528C27D92236")
    public boolean hasValue(int index) {
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_408654732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_408654732;
        // ---------- Original Method ----------
        //index *= AssetManager.STYLE_NUM_ENTRIES;
        //final int[] data = mData;
        //final int type = data[index+AssetManager.STYLE_TYPE];
        //return type != TypedValue.TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.359 -0400", hash_original_method = "0D8F28067488CFE0F25A0D66713982F4", hash_generated_method = "4D7332CEEC75D74FDEA2DA7F6C9820EF")
    public TypedValue peekValue(int index) {
        TypedValue varB4EAC82CA7396A68D541C85D26508E83_1971181427 = null; //Variable for return #1
        TypedValue varB4EAC82CA7396A68D541C85D26508E83_705222162 = null; //Variable for return #2
        final TypedValue value = mValue;
        {
            boolean var2E44B47547B27660D18B43B98A986F1E_520842803 = (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1971181427 = value;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_705222162 = null;
        addTaint(index);
        TypedValue varA7E53CE21691AB073D9660D615818899_398717494; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_398717494 = varB4EAC82CA7396A68D541C85D26508E83_1971181427;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_398717494 = varB4EAC82CA7396A68D541C85D26508E83_705222162;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_398717494.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_398717494;
        // ---------- Original Method ----------
        //final TypedValue value = mValue;
        //if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            //return value;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.360 -0400", hash_original_method = "C2A30811E6FAA7EEAF3DDEC09CF05D3C", hash_generated_method = "C0FE64730ACDEE6DA01F203C88347E6B")
    public String getPositionDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_1456736406 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1456736406 = mXml != null ? mXml.getPositionDescription() : "<internal>";
        varB4EAC82CA7396A68D541C85D26508E83_1456736406.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1456736406;
        // ---------- Original Method ----------
        //return mXml != null ? mXml.getPositionDescription() : "<internal>";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.361 -0400", hash_original_method = "A1E6C58584B412829C21C498310464D0", hash_generated_method = "2D007B4A750B585CF9353575EAB53146")
    public void recycle() {
        {
            TypedArray cached = mResources.mCachedStyledAttributes;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.363 -0400", hash_original_method = "7C5221C979A46E52D6E71FCE8A161B4A", hash_generated_method = "B6E3C42040590E7E98FCB796D49D3259")
    private boolean getValueAt(int index, TypedValue outValue) {
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        outValue.type = type;
        outValue.data = data[index+AssetManager.STYLE_DATA];
        outValue.assetCookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        outValue.resourceId = data[index+AssetManager.STYLE_RESOURCE_ID];
        outValue.changingConfigurations = data[index+AssetManager.STYLE_CHANGING_CONFIGURATIONS];
        outValue.density = data[index+AssetManager.STYLE_DENSITY];
        outValue.string = (type == TypedValue.TYPE_STRING) ? loadStringValueAt(index) : null;
        addTaint(index);
        addTaint(outValue.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_205693754 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_205693754;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.364 -0400", hash_original_method = "9EED998F765658475A56DE41DA4AC13D", hash_generated_method = "13D4AA798E23F63E15AEAC76F001B133")
    private CharSequence loadStringValueAt(int index) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_625875813 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_277196300 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1766866579 = null; //Variable for return #3
        final int[] data = mData;
        final int cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_625875813 = mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_277196300 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1766866579 = mResources.mAssets.getPooledString(
            cookie, data[index+AssetManager.STYLE_DATA]);
        addTaint(index);
        CharSequence varA7E53CE21691AB073D9660D615818899_1018094364; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1018094364 = varB4EAC82CA7396A68D541C85D26508E83_625875813;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1018094364 = varB4EAC82CA7396A68D541C85D26508E83_277196300;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1018094364 = varB4EAC82CA7396A68D541C85D26508E83_1766866579;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1018094364.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1018094364;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.364 -0400", hash_original_method = "D3700358536036842F849ADB987A26DD", hash_generated_method = "3D5C351CC63D3D4D0A971F9F563A5DE9")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1666970656 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1666970656 = Arrays.toString(mData);
        varB4EAC82CA7396A68D541C85D26508E83_1666970656.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1666970656;
        // ---------- Original Method ----------
        //return Arrays.toString(mData);
    }

    
}

