package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class Bundle implements Parcelable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.995 -0400", hash_original_field = "6C9D7AEB7CF5AE9F2141CB23F95F4D45", hash_generated_field = "6C79F547522536A208CAFCE9016DC05F")

    Map<String, Object> mMap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.995 -0400", hash_original_field = "6F0688E91A01AD80018225C89D147561", hash_generated_field = "E5162DF86C59E17EA59FEBB7EF559274")

    Parcel mParcelledData = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.995 -0400", hash_original_field = "9BDF733D1D0EFCF06F719222F55E0B82", hash_generated_field = "118C47CE2184B36A84368A2523875D08")

    private boolean mHasFds = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.995 -0400", hash_original_field = "93BA40E6351E40670C537B5E15D7DF94", hash_generated_field = "9003EC392C88BA1EADB5D26698887EBB")

    private boolean mFdsKnown = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.995 -0400", hash_original_field = "C459D1B5B4B22FFBFAEDCC421A1613ED", hash_generated_field = "C91DCF8BDF06F4CA952EC1031BBDC33F")

    private boolean mAllowFds = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.995 -0400", hash_original_field = "334890635C1887AB66991B9374637EE6", hash_generated_field = "ABE17DFC947454E8F85FE66E61741F7A")

    private ClassLoader mClassLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.995 -0400", hash_original_method = "40BE022BD5AEEE3B1F4C24A599FDBBB4", hash_generated_method = "D0B412F9D9C998F60A5827E098F54A80")
    public  Bundle() {
        mMap = new HashMap<String, Object>();
        mClassLoader = getClass().getClassLoader();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>();
        //mClassLoader = getClass().getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.996 -0400", hash_original_method = "DB07395F523937B25016D60988A66D69", hash_generated_method = "4F493D4EDE24A291FE82ADFB785F281A")
      Bundle(Parcel parcelledData) {
        readFromParcel(parcelledData);
        addTaint(parcelledData.getTaint());
        // ---------- Original Method ----------
        //readFromParcel(parcelledData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.996 -0400", hash_original_method = "4CBA8A75160127E76B9D77B8452C524A", hash_generated_method = "262D038D796E6FD0D31B80F71E99B9C8")
      Bundle(Parcel parcelledData, int length) {
        readFromParcelInner(parcelledData, length);
        addTaint(parcelledData.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //readFromParcelInner(parcelledData, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.996 -0400", hash_original_method = "ED19BD28A9BE16566DAB3F7BC8440A20", hash_generated_method = "54C66743395BE4AB6BAD14CE7AE27455")
    public  Bundle(ClassLoader loader) {
        mMap = new HashMap<String, Object>();
        mClassLoader = loader;
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>();
        //mClassLoader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.997 -0400", hash_original_method = "1CEDEB07DCD1E2A2BE2C52C76F89017C", hash_generated_method = "2B27A067BF7B2EDAA4C66221F6D6260E")
    public  Bundle(int capacity) {
        mMap = new HashMap<String, Object>(capacity);
        mClassLoader = getClass().getClassLoader();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>(capacity);
        //mClassLoader = getClass().getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:41.997 -0400", hash_original_method = "418D42BD4A8F16B387F3064B9218EE53", hash_generated_method = "94AFCA0B5F6517208A0414B1B3E22A6A")
    public  Bundle(Bundle b) {
        {
            mParcelledData = Parcel.obtain();
            mParcelledData.appendFrom(b.mParcelledData, 0, b.mParcelledData.dataSize());
            mParcelledData.setDataPosition(0);
        } //End block
        {
            mParcelledData = null;
        } //End block
        {
            mMap = new HashMap<String, Object>(b.mMap);
        } //End block
        {
            mMap = null;
        } //End block
        mHasFds = b.mHasFds;
        mFdsKnown = b.mFdsKnown;
        mClassLoader = b.mClassLoader;
        // ---------- Original Method ----------
        //if (b.mParcelledData != null) {
            //mParcelledData = Parcel.obtain();
            //mParcelledData.appendFrom(b.mParcelledData, 0, b.mParcelledData.dataSize());
            //mParcelledData.setDataPosition(0);
        //} else {
            //mParcelledData = null;
        //}
        //if (b.mMap != null) {
            //mMap = new HashMap<String, Object>(b.mMap);
        //} else {
            //mMap = null;
        //}
        //mHasFds = b.mHasFds;
        //mFdsKnown = b.mFdsKnown;
        //mClassLoader = b.mClassLoader;
    }

    
    public static Bundle forPair(String key, String value) {
        Bundle b = new Bundle(1);
        b.putString(key, value);
        return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.001 -0400", hash_original_method = "B3609B2F52C0BA6BE21E26730F76FD99", hash_generated_method = "495C880E3698EB8D11651DAF6158208E")
    public String getPairValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_22723747 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1849817418 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_578349738 = null; //Variable for return #3
        unparcel();
        int size = mMap.size();
        {
            varB4EAC82CA7396A68D541C85D26508E83_22723747 = null;
        } //End block
        Object o = mMap.values().iterator().next();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1849817418 = (String) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning("getPairValue()", o, "String", e);
            varB4EAC82CA7396A68D541C85D26508E83_578349738 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1363799999; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1363799999 = varB4EAC82CA7396A68D541C85D26508E83_22723747;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1363799999 = varB4EAC82CA7396A68D541C85D26508E83_1849817418;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1363799999 = varB4EAC82CA7396A68D541C85D26508E83_578349738;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1363799999.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1363799999;
        // ---------- Original Method ----------
        //unparcel();
        //int size = mMap.size();
        //if (size > 1) {
            //Log.w(LOG_TAG, "getPairValue() used on Bundle with multiple pairs.");
        //}
        //if (size == 0) {
            //return null;
        //}
        //Object o = mMap.values().iterator().next();
        //try {
            //return (String) o;
        //} catch (ClassCastException e) {
            //typeWarning("getPairValue()", o, "String", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.002 -0400", hash_original_method = "98C9A117007F79899B5BBD029ABFD6B8", hash_generated_method = "1DFA79725EDD590714D0602080EA4C5B")
    public void setClassLoader(ClassLoader loader) {
        mClassLoader = loader;
        // ---------- Original Method ----------
        //mClassLoader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.002 -0400", hash_original_method = "DF35DB07DA97BBA7096331B39E871560", hash_generated_method = "5DFD7E4FDB76273439B351DEECA1AAC2")
    public ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_234503477 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_234503477 = mClassLoader;
        varB4EAC82CA7396A68D541C85D26508E83_234503477.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_234503477;
        // ---------- Original Method ----------
        //return mClassLoader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.003 -0400", hash_original_method = "3A854A40DC72470BF5CA49CF20D41873", hash_generated_method = "8CE4F6DB4C962C042F9C2C10BA519DEB")
    public boolean setAllowFds(boolean allowFds) {
        boolean orig = mAllowFds;
        mAllowFds = allowFds;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1158982645 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1158982645;
        // ---------- Original Method ----------
        //boolean orig = mAllowFds;
        //mAllowFds = allowFds;
        //return orig;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.003 -0400", hash_original_method = "8ED269C57B5B4F834AF78EEAE05F20CC", hash_generated_method = "CFACC4D4F558E297EC12F317AEEA510B")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_730617399 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_730617399 = new Bundle(this);
        varB4EAC82CA7396A68D541C85D26508E83_730617399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_730617399;
        // ---------- Original Method ----------
        //return new Bundle(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.004 -0400", hash_original_method = "C84307F15A2AB40D2A9CA51D74C5FD0F", hash_generated_method = "6244B10BEFA4BD01AD2B167E5F67F7D3")
    synchronized void unparcel() {
        int N = mParcelledData.readInt();
        {
            mMap = new HashMap<String, Object>();
        } //End block
        mParcelledData.readMapInternal(mMap, N, mClassLoader);
        mParcelledData.recycle();
        mParcelledData = null;
        // ---------- Original Method ----------
        //if (mParcelledData == null) {
            //return;
        //}
        //int N = mParcelledData.readInt();
        //if (N < 0) {
            //return;
        //}
        //if (mMap == null) {
            //mMap = new HashMap<String, Object>();
        //}
        //mParcelledData.readMapInternal(mMap, N, mClassLoader);
        //mParcelledData.recycle();
        //mParcelledData = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.004 -0400", hash_original_method = "89E974D778C485ED4A98439CDF5961E3", hash_generated_method = "198E4BBE42D0211760B0328EBCABF7B4")
    public int size() {
        unparcel();
        int varEB72A5C76BB8A5CD8667491C4358251D_831929933 = (mMap.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393605279 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393605279;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.004 -0400", hash_original_method = "8B93AFDE665AAAFE98B5EE9FD5355D4B", hash_generated_method = "53D062F709E5ECC3A30E9645D8BD69C0")
    public boolean isEmpty() {
        unparcel();
        boolean varCFBB58DB314314B44F78CC84300FBF36_334821769 = (mMap.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560263982 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_560263982;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.005 -0400", hash_original_method = "9DC77B5F54151FE5CD815F7C8172B2ED", hash_generated_method = "E511022D09E81C4678253AC729CF8B7F")
    public void clear() {
        unparcel();
        mMap.clear();
        mHasFds = false;
        mFdsKnown = true;
        // ---------- Original Method ----------
        //unparcel();
        //mMap.clear();
        //mHasFds = false;
        //mFdsKnown = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.005 -0400", hash_original_method = "F5C0B952F7E6EDB282A82D73FA397DBD", hash_generated_method = "7BE80917D318D7444522C71E66280688")
    public boolean containsKey(String key) {
        unparcel();
        boolean var3CCD836522265B0EF3CEF15E617425E2_1306076125 = (mMap.containsKey(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1563677036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1563677036;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.006 -0400", hash_original_method = "E6C9158A697ED4C4296ED4A1595BA584", hash_generated_method = "0AF8F4B655ED4C98D00082492B416A53")
    public Object get(String key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_403456608 = null; //Variable for return #1
        unparcel();
        varB4EAC82CA7396A68D541C85D26508E83_403456608 = mMap.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_403456608.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_403456608;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.006 -0400", hash_original_method = "717A16AB4D98DDB60DEBCEA5CDF9B0B2", hash_generated_method = "DF4FBD191E1E4047653C75195B2DF6DC")
    public void remove(String key) {
        unparcel();
        mMap.remove(key);
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.006 -0400", hash_original_method = "F30E47B42E381C2413B1100E1A47D1F8", hash_generated_method = "19C8D719C8CECA801C0058973A2CCB2F")
    public void putAll(Bundle map) {
        unparcel();
        map.unparcel();
        mMap.putAll(map.mMap);
        mHasFds |= map.mHasFds;
        mFdsKnown = mFdsKnown && map.mFdsKnown;
        // ---------- Original Method ----------
        //unparcel();
        //map.unparcel();
        //mMap.putAll(map.mMap);
        //mHasFds |= map.mHasFds;
        //mFdsKnown = mFdsKnown && map.mFdsKnown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.007 -0400", hash_original_method = "00E2D8861948F8DB601BFD39768039D0", hash_generated_method = "C55800930AF111C97C30254D065E369C")
    public Set<String> keySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1094405538 = null; //Variable for return #1
        unparcel();
        varB4EAC82CA7396A68D541C85D26508E83_1094405538 = mMap.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_1094405538.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1094405538;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.008 -0400", hash_original_method = "4B0480B2866CB29DA37F7AEC68A5E217", hash_generated_method = "EA75F2CAA3DF826154559ED0BFA91D8D")
    public boolean hasFileDescriptors() {
        {
            boolean fdFound = false;
            {
                {
                    boolean varE7E90B5396C9FB1A90488751D202C0DE_615847147 = (mParcelledData.hasFileDescriptors());
                    {
                        fdFound = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                Iterator<Map.Entry<String, Object>> iter = mMap.entrySet().iterator();
                {
                    boolean var3C9C2559EA47B4922E81E22A4D970516_388498521 = (!fdFound && iter.hasNext());
                    {
                        Object obj = iter.next().getValue();
                        {
                            {
                                boolean var3B3CD3B239B9599F818BBBB4D19F1B2A_416509023 = ((((Parcelable)obj).describeContents()
                                & Parcelable.CONTENTS_FILE_DESCRIPTOR) != 0);
                                {
                                    fdFound = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            Parcelable[] array = (Parcelable[]) obj;
                            {
                                int n = array.length - 1;
                                {
                                    {
                                        boolean var33811AA2303D21D7631EEBA0E4C5547F_2126747846 = ((array[n].describeContents()
                                    & Parcelable.CONTENTS_FILE_DESCRIPTOR) != 0);
                                        {
                                            fdFound = true;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            SparseArray<? extends Parcelable> array = (SparseArray<? extends Parcelable>) obj;
                            {
                                int n = array.size() - 1;
                                {
                                    {
                                        boolean var70216DAA8A60B74EE111A55FCE3E036D_274714856 = ((array.get(n).describeContents()
                                    & Parcelable.CONTENTS_FILE_DESCRIPTOR) != 0);
                                        {
                                            fdFound = true;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            ArrayList array = (ArrayList) obj;
                            {
                                boolean var01F44C1854281F36799A73E27E5377CB_602528498 = ((array.size() > 0)
                                && (array.get(0) instanceof Parcelable));
                                {
                                    {
                                        int n = array.size() - 1;
                                        {
                                            Parcelable p = (Parcelable) array.get(n);
                                            {
                                                boolean varB72014908EB71D72428783AAB42D64BD_1542468235 = (p != null && ((p.describeContents()
                                        & Parcelable.CONTENTS_FILE_DESCRIPTOR) != 0));
                                                {
                                                    fdFound = true;
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            mHasFds = fdFound;
            mFdsKnown = true;
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764446513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764446513;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.009 -0400", hash_original_method = "94490DFEC498722DA435B9597CF0EDDE", hash_generated_method = "494AB25FA6A81D96516162AA6A9D1B9B")
    public void putBoolean(String key, boolean value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.010 -0400", hash_original_method = "60D945D31D7D04981E268C4CC855B009", hash_generated_method = "DB58D69051013C99B29E0CDCA52C51B9")
    public void putByte(String key, byte value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.011 -0400", hash_original_method = "C6C3CAC58AEE8EB92E7D233D1233B510", hash_generated_method = "42F76C1D0264FA9CAB3150F183581F56")
    public void putChar(String key, char value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.011 -0400", hash_original_method = "48338BC49C4A94D5C3F73368CEF11822", hash_generated_method = "4C0874B7B8A54699830F32CC32C43359")
    public void putShort(String key, short value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.012 -0400", hash_original_method = "C2DD503B984E96C46288CB6F7C364E09", hash_generated_method = "5D3E666E5FDCB6BA807C0EDD04871858")
    public void putInt(String key, int value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.012 -0400", hash_original_method = "32D4E331D0F655A9205640C19ABF2B58", hash_generated_method = "C0AA1D9348779BCBED0D770DF5DF9CD4")
    public void putLong(String key, long value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.013 -0400", hash_original_method = "292C24CEC676EE3F6A373A1AE7371B82", hash_generated_method = "2E845DA9BB168C72F06E8BE4742A1D79")
    public void putFloat(String key, float value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.013 -0400", hash_original_method = "1F6C5CEB9374270482ED4835594D6EF1", hash_generated_method = "71003B4C7F25080872872AFB0EE5C2AA")
    public void putDouble(String key, double value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.013 -0400", hash_original_method = "E7336EB9055C9F862A0B8D336BB5AE0F", hash_generated_method = "7816AC3BB90926D49A526B6EC283C598")
    public void putString(String key, String value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.014 -0400", hash_original_method = "23A8E01E039C76712F2C134222EAC45B", hash_generated_method = "46A172DF81D81C96F22CB347403CCE82")
    public void putCharSequence(String key, CharSequence value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.014 -0400", hash_original_method = "F17082A305780CE778B93F20A20D0318", hash_generated_method = "97B87056F9E9E578C0288E3B1B1AC30E")
    public void putParcelable(String key, Parcelable value) {
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
        //mFdsKnown = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.014 -0400", hash_original_method = "1666E21FDEAC3D0C57D8E38C022A7AD2", hash_generated_method = "AB3493F683AF138DFFECDC97CFA63471")
    public void putParcelableArray(String key, Parcelable[] value) {
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
        addTaint(key.getTaint());
        addTaint(value[0].getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
        //mFdsKnown = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.015 -0400", hash_original_method = "C07428EAC6D62CA3DF6F67489B512A7E", hash_generated_method = "BCCC9435D6AB39DA30787AAC1241646C")
    public void putParcelableArrayList(String key,
        ArrayList<? extends Parcelable> value) {
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
        //mFdsKnown = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.015 -0400", hash_original_method = "93FD4CBDA1682EAF0E9F2535BF397F65", hash_generated_method = "1C95511FD52FD3883F61813628F41E09")
    public void putSparseParcelableArray(String key,
            SparseArray<? extends Parcelable> value) {
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
        //mFdsKnown = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.015 -0400", hash_original_method = "6C90B1571D2A36769CB59FB958C842F7", hash_generated_method = "33A49484B3903C40530A39873BF05318")
    public void putIntegerArrayList(String key, ArrayList<Integer> value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.016 -0400", hash_original_method = "ABD9DF23A5A8A0A83F11C474E2CAFB17", hash_generated_method = "EED67E59E8EF89327B3FE4FFF12A8F5B")
    public void putStringArrayList(String key, ArrayList<String> value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.016 -0400", hash_original_method = "C0F2E9DF48888A828D6640DBBB8ADDE5", hash_generated_method = "90DB59B439C94CE30326EDE54E889BE1")
    public void putCharSequenceArrayList(String key, ArrayList<CharSequence> value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.016 -0400", hash_original_method = "C647C81034119067E2383CA02CF65D5F", hash_generated_method = "2DA89C2C68C1A78D7D29D3EA69888266")
    public void putSerializable(String key, Serializable value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.016 -0400", hash_original_method = "8E721A4E4DD3EA40820BFACA50BE3D1C", hash_generated_method = "B193962005F024D6B35BA1C05CB5F256")
    public void putBooleanArray(String key, boolean[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.017 -0400", hash_original_method = "1C56E40FECAB1AC7C31C1D64DCBF74F0", hash_generated_method = "EF58BE1AF605747C5F24DE666B17280D")
    public void putByteArray(String key, byte[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.017 -0400", hash_original_method = "2FF709A9E88600F14AEB34FA372FB7A3", hash_generated_method = "0D16F8DFC75EBEF3B15A6FCE4CC0B13D")
    public void putShortArray(String key, short[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.018 -0400", hash_original_method = "5BBE3077A529F887080D848A31F1E40F", hash_generated_method = "26C2ADE47A5F58F5B454842FE0891C8D")
    public void putCharArray(String key, char[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.018 -0400", hash_original_method = "6E03156089AB80D54004D251F8CBA9A8", hash_generated_method = "DE6C9E68B50D52B95903B2BAC3553073")
    public void putIntArray(String key, int[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.018 -0400", hash_original_method = "749D6A41C446C63F668941511653896B", hash_generated_method = "377BBB9FF2626B758A3D8599BAE29FF9")
    public void putLongArray(String key, long[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.019 -0400", hash_original_method = "6C49285A06086C4B176330EBC83C2D3B", hash_generated_method = "8617DFDF7A371A58C45590FF69D6C55A")
    public void putFloatArray(String key, float[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.019 -0400", hash_original_method = "BF0DED73B6BC272CA81A76D665AF3892", hash_generated_method = "AA6007DD29FFD4C5E982FE0DE9F5318E")
    public void putDoubleArray(String key, double[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.020 -0400", hash_original_method = "3F318C6E0F37B53192FF4A33987FF921", hash_generated_method = "878351A3EA1C3DAF2EF1E19856E3AFA5")
    public void putStringArray(String key, String[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0].getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.021 -0400", hash_original_method = "D442CACA5F4C37E249E32A5FC3EA1B00", hash_generated_method = "FE4707CAA813DDE0EE06E3FE02A6912E")
    public void putCharSequenceArray(String key, CharSequence[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0].getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.021 -0400", hash_original_method = "8FC0D5E8787A84A268AF6F8743FC18A2", hash_generated_method = "E032378C3A88AE79BCE1A35FAEB24389")
    public void putBundle(String key, Bundle value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.021 -0400", hash_original_method = "0DA9D5A0C7EE7D2AFD4BCC53AD3802F3", hash_generated_method = "141E1EF0A46C9B3C0CC36B149F5FE6DC")
    @Deprecated
    public void putIBinder(String key, IBinder value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.022 -0400", hash_original_method = "44491868325766EC5AED04910C3A4D05", hash_generated_method = "7815A9C902D223E1D20FCE4B6D8C8AA2")
    public boolean getBoolean(String key) {
        unparcel();
        boolean var4C9107722E78C3479502DC8113A34442_1095491562 = (getBoolean(key, false));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_787236289 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_787236289;
        // ---------- Original Method ----------
        //unparcel();
        //return getBoolean(key, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.022 -0400", hash_original_method = "017EA18B11E7843C44A73EB9482CE841", hash_generated_method = "8CCC4C6317B2F0FCE02777974BCD8EC6")
    private void typeWarning(String key, Object value, String className,
        Object defaultValue, ClassCastException e) {
        StringBuilder sb = new StringBuilder();
        sb.append("Key ");
        sb.append(key);
        sb.append(" expected ");
        sb.append(className);
        sb.append(" but value was a ");
        sb.append(value.getClass().getName());
        sb.append(".  The default value ");
        sb.append(defaultValue);
        sb.append(" was returned.");
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        addTaint(className.getTaint());
        addTaint(defaultValue.getTaint());
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append("Key ");
        //sb.append(key);
        //sb.append(" expected ");
        //sb.append(className);
        //sb.append(" but value was a ");
        //sb.append(value.getClass().getName());
        //sb.append(".  The default value ");
        //sb.append(defaultValue);
        //sb.append(" was returned.");
        //Log.w(LOG_TAG, sb.toString());
        //Log.w(LOG_TAG, "Attempt to cast generated internal exception:", e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.023 -0400", hash_original_method = "AA5C4C6D2863DB47E466486DB4471393", hash_generated_method = "80390375825A47B320F6385F7290E5D7")
    private void typeWarning(String key, Object value, String className,
        ClassCastException e) {
        typeWarning(key, value, className, "<null>", e);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        addTaint(className.getTaint());
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //typeWarning(key, value, className, "<null>", e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.023 -0400", hash_original_method = "62E0EA051DB8CF7BEF8CA2ACB88171F1", hash_generated_method = "85D9A4AD2C256A954599BF2069D45AB2")
    public boolean getBoolean(String key, boolean defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_790252916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_790252916;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Boolean) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Boolean", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.024 -0400", hash_original_method = "E9711B4A318F78DD358F0F07FAB02724", hash_generated_method = "07EF691A63A9CAFD35FC6AF6F64D6498")
    public byte getByte(String key) {
        unparcel();
        byte varF5DF8FD13401C680C4079E46D48E559E_1520264076 = (getByte(key, (byte) 0));
        addTaint(key.getTaint());
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1796264847 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1796264847;
        // ---------- Original Method ----------
        //unparcel();
        //return getByte(key, (byte) 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.024 -0400", hash_original_method = "44660F005C21F1E59A8F3EDCC4F5A0ED", hash_generated_method = "810AE40E9E6353CE8ABCD354E02DA964")
    public Byte getByte(String key, byte defaultValue) {
        Byte varB4EAC82CA7396A68D541C85D26508E83_141144577 = null; //Variable for return #1
        Byte varB4EAC82CA7396A68D541C85D26508E83_1077360664 = null; //Variable for return #2
        Byte varB4EAC82CA7396A68D541C85D26508E83_865636664 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_141144577 = defaultValue;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1077360664 = (Byte) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Byte", defaultValue, e);
            varB4EAC82CA7396A68D541C85D26508E83_865636664 = defaultValue;
        } //End block
        addTaint(key.getTaint());
        addTaint(defaultValue);
        Byte varA7E53CE21691AB073D9660D615818899_929024303; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_929024303 = varB4EAC82CA7396A68D541C85D26508E83_141144577;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_929024303 = varB4EAC82CA7396A68D541C85D26508E83_1077360664;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_929024303 = varB4EAC82CA7396A68D541C85D26508E83_865636664;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_929024303.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_929024303;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Byte) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Byte", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.025 -0400", hash_original_method = "82E77139364787BB6587747BA780C45B", hash_generated_method = "0B12DEA1B318FC14A0C42896E3F308CF")
    public char getChar(String key) {
        unparcel();
        char var27F1A2D2AC9426CDE46A1342145F88A3_564063900 = (getChar(key, (char) 0));
        addTaint(key.getTaint());
        char varA87DEB01C5F539E6BDA34829C8EF2368_1190483128 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1190483128;
        // ---------- Original Method ----------
        //unparcel();
        //return getChar(key, (char) 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.025 -0400", hash_original_method = "1B86701C5E776F178851B3C57F1F092F", hash_generated_method = "34239A23FDD9C2ABE529C84029A2CA1D")
    public char getChar(String key, char defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        char varA87DEB01C5F539E6BDA34829C8EF2368_702350660 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_702350660;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Character) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Character", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.025 -0400", hash_original_method = "949AF94B781EE8B084883F15F1BA2BF2", hash_generated_method = "D76C20683D8067F4CEF6BCA224CC422A")
    public short getShort(String key) {
        unparcel();
        short varC3D9771DE8675C9D280694DECEDD0AFB_1806028155 = (getShort(key, (short) 0));
        addTaint(key.getTaint());
        short var4F09DAA9D95BCB166A302407A0E0BABE_1797370716 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1797370716;
        // ---------- Original Method ----------
        //unparcel();
        //return getShort(key, (short) 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.026 -0400", hash_original_method = "CB97516320C4B19AFFFFC9855DAD2391", hash_generated_method = "3F18285E68887FB989C36E51FC36AA57")
    public short getShort(String key, short defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1930484325 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1930484325;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Short) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Short", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.026 -0400", hash_original_method = "E147114FE6EABC6FAB98EAC3907FD421", hash_generated_method = "C682493DBEA0DD1A925A1FA369B2CB37")
    public int getInt(String key) {
        unparcel();
        int var8CD2947803356231BBC241492425AC77_1509881708 = (getInt(key, 0));
        addTaint(key.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_493602882 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_493602882;
        // ---------- Original Method ----------
        //unparcel();
        //return getInt(key, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.026 -0400", hash_original_method = "83073F806AC00C1E2EC4E710A5472BFA", hash_generated_method = "267F8D999E1B4EC67353376C77BCFE6B")
    public int getInt(String key, int defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_395413942 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_395413942;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Integer) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Integer", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.027 -0400", hash_original_method = "0CFFDE7713416A17E206C69E138AC0FF", hash_generated_method = "01EC4D0F26B80A8181D0F5E22EA44938")
    public long getLong(String key) {
        unparcel();
        long var979CD6852D7A16006D946D82F7EF4D0A_699926243 = (getLong(key, 0L));
        addTaint(key.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2060228083 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2060228083;
        // ---------- Original Method ----------
        //unparcel();
        //return getLong(key, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.027 -0400", hash_original_method = "84BBB1371E3F4460B78F31822950EAAA", hash_generated_method = "015B267716FF489385492B6FD266ED70")
    public long getLong(String key, long defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_631921548 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_631921548;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Long) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Long", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.028 -0400", hash_original_method = "0D69D7EB25C8E886B27D28B7A30E217C", hash_generated_method = "834C5B813F9CB3F463CD9002F05DBE82")
    public float getFloat(String key) {
        unparcel();
        float var1F2989949A680EEB88317D0F20C8813F_327358447 = (getFloat(key, 0.0f));
        addTaint(key.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_1354652078 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1354652078;
        // ---------- Original Method ----------
        //unparcel();
        //return getFloat(key, 0.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.028 -0400", hash_original_method = "8162EC4F2AE30557D489C5C6263EB256", hash_generated_method = "98676B219616C0CA4611E75C8C1333A5")
    public float getFloat(String key, float defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1646320157 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1646320157;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Float) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Float", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.029 -0400", hash_original_method = "F5086ED2941BC7C3CB9930D22842FA44", hash_generated_method = "C762ACA27ABB9B34AB0131A54459B627")
    public double getDouble(String key) {
        unparcel();
        double varAF1883587E9789F106C3A6801CFE65B3_1350660588 = (getDouble(key, 0.0));
        addTaint(key.getTaint());
        double varE8CD7DA078A86726031AD64F35F5A6C0_2045490694 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_2045490694;
        // ---------- Original Method ----------
        //unparcel();
        //return getDouble(key, 0.0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.029 -0400", hash_original_method = "172C416958EF64BBE0F98CDA39B416EB", hash_generated_method = "248EAC6672514BD959EA6A4D7A829AD0")
    public double getDouble(String key, double defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        double varE8CD7DA078A86726031AD64F35F5A6C0_2030986106 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_2030986106;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (Double) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Double", defaultValue, e);
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.031 -0400", hash_original_method = "51BC83F6E10D252B7C417A14343A53BE", hash_generated_method = "4B31B16940200E0F8F4FB3BE188D3E18")
    public String getString(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_1588508063 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_548922152 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1524777962 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1588508063 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_548922152 = (String) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "String", e);
            varB4EAC82CA7396A68D541C85D26508E83_1524777962 = null;
        } //End block
        addTaint(key.getTaint());
        String varA7E53CE21691AB073D9660D615818899_389196778; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_389196778 = varB4EAC82CA7396A68D541C85D26508E83_1588508063;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_389196778 = varB4EAC82CA7396A68D541C85D26508E83_548922152;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_389196778 = varB4EAC82CA7396A68D541C85D26508E83_1524777962;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_389196778.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_389196778;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (String) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "String", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.032 -0400", hash_original_method = "BC80281EBAB10986EFB226B5D89A6368", hash_generated_method = "62DED05086B59418304D7081BB678B8E")
    public String getString(String key, String defaultValue) {
        String varB4EAC82CA7396A68D541C85D26508E83_293022478 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_115143417 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_479767726 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_293022478 = defaultValue;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_115143417 = (String) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "String", e);
            varB4EAC82CA7396A68D541C85D26508E83_479767726 = defaultValue;
        } //End block
        addTaint(key.getTaint());
        addTaint(defaultValue.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1758514006; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1758514006 = varB4EAC82CA7396A68D541C85D26508E83_293022478;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1758514006 = varB4EAC82CA7396A68D541C85D26508E83_115143417;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1758514006 = varB4EAC82CA7396A68D541C85D26508E83_479767726;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1758514006.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1758514006;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (String) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "String", e);
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.033 -0400", hash_original_method = "4D51A99620432005EDE9794C44D49E24", hash_generated_method = "5C74DC2EC9144466B0F4254DA08C6477")
    public CharSequence getCharSequence(String key) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1066318019 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_315166299 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_765060045 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1066318019 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_315166299 = (CharSequence) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "CharSequence", e);
            varB4EAC82CA7396A68D541C85D26508E83_765060045 = null;
        } //End block
        addTaint(key.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1205042885; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1205042885 = varB4EAC82CA7396A68D541C85D26508E83_1066318019;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1205042885 = varB4EAC82CA7396A68D541C85D26508E83_315166299;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1205042885 = varB4EAC82CA7396A68D541C85D26508E83_765060045;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1205042885.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1205042885;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (CharSequence) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "CharSequence", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.035 -0400", hash_original_method = "C5E593A01F019636F8A087C171F20745", hash_generated_method = "F5B1FA39BE63D79866E5007F6F90B9B4")
    public CharSequence getCharSequence(String key, CharSequence defaultValue) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_690689571 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1345491454 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_546415167 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_690689571 = defaultValue;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1345491454 = (CharSequence) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "CharSequence", e);
            varB4EAC82CA7396A68D541C85D26508E83_546415167 = defaultValue;
        } //End block
        addTaint(key.getTaint());
        addTaint(defaultValue.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1132808510; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1132808510 = varB4EAC82CA7396A68D541C85D26508E83_690689571;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1132808510 = varB4EAC82CA7396A68D541C85D26508E83_1345491454;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1132808510 = varB4EAC82CA7396A68D541C85D26508E83_546415167;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1132808510.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1132808510;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return defaultValue;
        //}
        //try {
            //return (CharSequence) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "CharSequence", e);
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.036 -0400", hash_original_method = "7BDB21170493B124DD321ED35C766BAB", hash_generated_method = "A5C0E5B7F6037C1AD34C020FF90D6E14")
    public Bundle getBundle(String key) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_277799113 = null; //Variable for return #1
        Bundle varB4EAC82CA7396A68D541C85D26508E83_530522655 = null; //Variable for return #2
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1478400387 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_277799113 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_530522655 = (Bundle) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Bundle", e);
            varB4EAC82CA7396A68D541C85D26508E83_1478400387 = null;
        } //End block
        addTaint(key.getTaint());
        Bundle varA7E53CE21691AB073D9660D615818899_355428543; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_355428543 = varB4EAC82CA7396A68D541C85D26508E83_277799113;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_355428543 = varB4EAC82CA7396A68D541C85D26508E83_530522655;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_355428543 = varB4EAC82CA7396A68D541C85D26508E83_1478400387;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_355428543.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_355428543;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (Bundle) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Bundle", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.036 -0400", hash_original_method = "3B646958426B4FA703D61CD64DB4127C", hash_generated_method = "9FAAFDBF67A98FA03633862DFFA6AC8E")
    public <T extends Parcelable> T getParcelable(String key) {
        T varB4EAC82CA7396A68D541C85D26508E83_1216044678 = null; //Variable for return #1
        T varB4EAC82CA7396A68D541C85D26508E83_368220658 = null; //Variable for return #2
        T varB4EAC82CA7396A68D541C85D26508E83_1078113752 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1216044678 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_368220658 = (T) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Parcelable", e);
            varB4EAC82CA7396A68D541C85D26508E83_1078113752 = null;
        } //End block
        addTaint(key.getTaint());
        T varA7E53CE21691AB073D9660D615818899_1596746617; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1596746617 = varB4EAC82CA7396A68D541C85D26508E83_1216044678;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1596746617 = varB4EAC82CA7396A68D541C85D26508E83_368220658;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1596746617 = varB4EAC82CA7396A68D541C85D26508E83_1078113752;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1596746617.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1596746617;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (T) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Parcelable", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.037 -0400", hash_original_method = "ACB5B2AD81C8600B2F6954C0DE15936B", hash_generated_method = "4A3D235064E8A484CFF44BAB45E25887")
    public Parcelable[] getParcelableArray(String key) {
        Parcelable[] varB4EAC82CA7396A68D541C85D26508E83_240225177 = null; //Variable for return #1
        Parcelable[] varB4EAC82CA7396A68D541C85D26508E83_1957120974 = null; //Variable for return #2
        Parcelable[] varB4EAC82CA7396A68D541C85D26508E83_1856696053 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_240225177 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1957120974 = (Parcelable[]) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Parcelable[]", e);
            varB4EAC82CA7396A68D541C85D26508E83_1856696053 = null;
        } //End block
        addTaint(key.getTaint());
        Parcelable[] varA7E53CE21691AB073D9660D615818899_834104469; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_834104469 = varB4EAC82CA7396A68D541C85D26508E83_240225177;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_834104469 = varB4EAC82CA7396A68D541C85D26508E83_1957120974;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_834104469 = varB4EAC82CA7396A68D541C85D26508E83_1856696053;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_834104469.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_834104469;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (Parcelable[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Parcelable[]", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.039 -0400", hash_original_method = "4066E862ACF29CBEB786556AAFBFC58D", hash_generated_method = "B41BC4B67607CEC8CFC1C0E802F78A40")
    public <T extends Parcelable> ArrayList<T> getParcelableArrayList(String key) {
        ArrayList<T> varB4EAC82CA7396A68D541C85D26508E83_1160757281 = null; //Variable for return #1
        ArrayList<T> varB4EAC82CA7396A68D541C85D26508E83_1182832274 = null; //Variable for return #2
        ArrayList<T> varB4EAC82CA7396A68D541C85D26508E83_461312121 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1160757281 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1182832274 = (ArrayList<T>) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList", e);
            varB4EAC82CA7396A68D541C85D26508E83_461312121 = null;
        } //End block
        addTaint(key.getTaint());
        ArrayList<T> varA7E53CE21691AB073D9660D615818899_188724509; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_188724509 = varB4EAC82CA7396A68D541C85D26508E83_1160757281;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_188724509 = varB4EAC82CA7396A68D541C85D26508E83_1182832274;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_188724509 = varB4EAC82CA7396A68D541C85D26508E83_461312121;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_188724509.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_188724509;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (ArrayList<T>) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "ArrayList", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.041 -0400", hash_original_method = "F3D4EB475C3465E3892E6091F83F5D92", hash_generated_method = "1ED39E312528E109D923263BF8A2DE35")
    public <T extends Parcelable> SparseArray<T> getSparseParcelableArray(String key) {
        SparseArray<T> varB4EAC82CA7396A68D541C85D26508E83_577275466 = null; //Variable for return #1
        SparseArray<T> varB4EAC82CA7396A68D541C85D26508E83_320182314 = null; //Variable for return #2
        SparseArray<T> varB4EAC82CA7396A68D541C85D26508E83_1196241209 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_577275466 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_320182314 = (SparseArray<T>) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "SparseArray", e);
            varB4EAC82CA7396A68D541C85D26508E83_1196241209 = null;
        } //End block
        addTaint(key.getTaint());
        SparseArray<T> varA7E53CE21691AB073D9660D615818899_1766988720; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1766988720 = varB4EAC82CA7396A68D541C85D26508E83_577275466;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1766988720 = varB4EAC82CA7396A68D541C85D26508E83_320182314;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1766988720 = varB4EAC82CA7396A68D541C85D26508E83_1196241209;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1766988720.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1766988720;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (SparseArray<T>) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "SparseArray", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.042 -0400", hash_original_method = "3E1FB271E8FDF7CD375ECA97D496DB8C", hash_generated_method = "EF03893CCFB7700B2CCC2208A8F407C9")
    public Serializable getSerializable(String key) {
        Serializable varB4EAC82CA7396A68D541C85D26508E83_1668559702 = null; //Variable for return #1
        Serializable varB4EAC82CA7396A68D541C85D26508E83_42247488 = null; //Variable for return #2
        Serializable varB4EAC82CA7396A68D541C85D26508E83_608690037 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1668559702 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_42247488 = (Serializable) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Serializable", e);
            varB4EAC82CA7396A68D541C85D26508E83_608690037 = null;
        } //End block
        addTaint(key.getTaint());
        Serializable varA7E53CE21691AB073D9660D615818899_1982162597; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1982162597 = varB4EAC82CA7396A68D541C85D26508E83_1668559702;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1982162597 = varB4EAC82CA7396A68D541C85D26508E83_42247488;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1982162597 = varB4EAC82CA7396A68D541C85D26508E83_608690037;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1982162597.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1982162597;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (Serializable) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "Serializable", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.043 -0400", hash_original_method = "129B869D98875CE72FDC17E4CC2A1579", hash_generated_method = "EDB4E78E312AAD769C20D769D8BD365E")
    public ArrayList<Integer> getIntegerArrayList(String key) {
        ArrayList<Integer> varB4EAC82CA7396A68D541C85D26508E83_420434838 = null; //Variable for return #1
        ArrayList<Integer> varB4EAC82CA7396A68D541C85D26508E83_151210861 = null; //Variable for return #2
        ArrayList<Integer> varB4EAC82CA7396A68D541C85D26508E83_1433358836 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_420434838 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_151210861 = (ArrayList<Integer>) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList<Integer>", e);
            varB4EAC82CA7396A68D541C85D26508E83_1433358836 = null;
        } //End block
        addTaint(key.getTaint());
        ArrayList<Integer> varA7E53CE21691AB073D9660D615818899_1516840572; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1516840572 = varB4EAC82CA7396A68D541C85D26508E83_420434838;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1516840572 = varB4EAC82CA7396A68D541C85D26508E83_151210861;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1516840572 = varB4EAC82CA7396A68D541C85D26508E83_1433358836;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1516840572.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1516840572;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (ArrayList<Integer>) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "ArrayList<Integer>", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.044 -0400", hash_original_method = "2869BDF5623DD5162F6A69DFD2D1F8AB", hash_generated_method = "343F166EB73D8027BF513D4652442E6B")
    public ArrayList<String> getStringArrayList(String key) {
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_1654669419 = null; //Variable for return #1
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_1850454274 = null; //Variable for return #2
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_1163987700 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1654669419 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1850454274 = (ArrayList<String>) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList<String>", e);
            varB4EAC82CA7396A68D541C85D26508E83_1163987700 = null;
        } //End block
        addTaint(key.getTaint());
        ArrayList<String> varA7E53CE21691AB073D9660D615818899_1779878944; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1779878944 = varB4EAC82CA7396A68D541C85D26508E83_1654669419;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1779878944 = varB4EAC82CA7396A68D541C85D26508E83_1850454274;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1779878944 = varB4EAC82CA7396A68D541C85D26508E83_1163987700;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1779878944.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1779878944;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (ArrayList<String>) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "ArrayList<String>", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.045 -0400", hash_original_method = "9A13BDFEA4BB8512D10DFA31FFDE883A", hash_generated_method = "ED9CBD413EF025BAC3E06435AE5456C3")
    public ArrayList<CharSequence> getCharSequenceArrayList(String key) {
        ArrayList<CharSequence> varB4EAC82CA7396A68D541C85D26508E83_951173753 = null; //Variable for return #1
        ArrayList<CharSequence> varB4EAC82CA7396A68D541C85D26508E83_747706745 = null; //Variable for return #2
        ArrayList<CharSequence> varB4EAC82CA7396A68D541C85D26508E83_940839484 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_951173753 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_747706745 = (ArrayList<CharSequence>) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList<CharSequence>", e);
            varB4EAC82CA7396A68D541C85D26508E83_940839484 = null;
        } //End block
        addTaint(key.getTaint());
        ArrayList<CharSequence> varA7E53CE21691AB073D9660D615818899_1348754753; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1348754753 = varB4EAC82CA7396A68D541C85D26508E83_951173753;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1348754753 = varB4EAC82CA7396A68D541C85D26508E83_747706745;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1348754753 = varB4EAC82CA7396A68D541C85D26508E83_940839484;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1348754753.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1348754753;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (ArrayList<CharSequence>) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "ArrayList<CharSequence>", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.045 -0400", hash_original_method = "2242EDC01DC8898E91E207F436901294", hash_generated_method = "B76508C9AD43CA720CFE8D89931A8BA0")
    public boolean[] getBooleanArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_1539429241 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1539429241;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (boolean[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "byte[]", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.045 -0400", hash_original_method = "61BA553FC99180BEC5D34878EFD2124D", hash_generated_method = "8A41E75B38B32DA92497A38DEBC8887F")
    public byte[] getByteArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_817978865 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_817978865;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (byte[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "byte[]", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.046 -0400", hash_original_method = "7BB50DA07B268F9685287E0D939131D4", hash_generated_method = "CE9C051D241659991D3DEBB7333BE829")
    public short[] getShortArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        short[] var48EE7E2DDF8A83602BC526873BD0F875_1722401678 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_1722401678;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (short[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "short[]", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.046 -0400", hash_original_method = "E77DD9D06089068562F2943DA73C8461", hash_generated_method = "DA686E5A7EE44A547687BF09FCCA3DCC")
    public char[] getCharArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1981857777 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1981857777;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (char[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "char[]", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.047 -0400", hash_original_method = "85622F3A5EF64119863AB7B7CCBF9703", hash_generated_method = "AACB7F044C5F511E2397D887A5828FA9")
    public int[] getIntArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_361815956 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_361815956;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (int[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "int[]", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.047 -0400", hash_original_method = "27B2CD54F5F69E8E74D59A821000C81A", hash_generated_method = "E0B70C5623150F2731BF45DE9E1AE418")
    public long[] getLongArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_301363995 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_301363995;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (long[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "long[]", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.048 -0400", hash_original_method = "CF7D6838E0F23E6456879FF35A2AC714", hash_generated_method = "DC055B731492E356A32F66669A7C114D")
    public float[] getFloatArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        float[] varB2C245003BAB9224CFB496218F7DAFE0_16378967 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_16378967;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (float[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "float[]", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.049 -0400", hash_original_method = "3231DDBB4D17868FEAA7FF4365CACCDA", hash_generated_method = "BB853980AA337182BA3A28350427B075")
    public double[] getDoubleArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        addTaint(key.getTaint());
        double[] var74D44D7D9EE6FE6C3433D694F869E521_395937165 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_395937165;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (double[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "double[]", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.050 -0400", hash_original_method = "00D6B9CB5DC261567748885D1CE89780", hash_generated_method = "7E6A97B7F79BC62BDE588A727ADAF343")
    public String[] getStringArray(String key) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1458071350 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_275409690 = null; //Variable for return #2
        String[] varB4EAC82CA7396A68D541C85D26508E83_1851116226 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1458071350 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_275409690 = (String[]) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "String[]", e);
            varB4EAC82CA7396A68D541C85D26508E83_1851116226 = null;
        } //End block
        addTaint(key.getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_1774315888; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1774315888 = varB4EAC82CA7396A68D541C85D26508E83_1458071350;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1774315888 = varB4EAC82CA7396A68D541C85D26508E83_275409690;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1774315888 = varB4EAC82CA7396A68D541C85D26508E83_1851116226;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1774315888.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1774315888;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (String[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "String[]", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.051 -0400", hash_original_method = "E55D822FE040164347A1371A3EEFE758", hash_generated_method = "7D13B7251D25708ECCB7E90CC211B2DF")
    public CharSequence[] getCharSequenceArray(String key) {
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_548613163 = null; //Variable for return #1
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_18647419 = null; //Variable for return #2
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_692045596 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_548613163 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_18647419 = (CharSequence[]) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "CharSequence[]", e);
            varB4EAC82CA7396A68D541C85D26508E83_692045596 = null;
        } //End block
        addTaint(key.getTaint());
        CharSequence[] varA7E53CE21691AB073D9660D615818899_1484397045; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1484397045 = varB4EAC82CA7396A68D541C85D26508E83_548613163;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1484397045 = varB4EAC82CA7396A68D541C85D26508E83_18647419;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1484397045 = varB4EAC82CA7396A68D541C85D26508E83_692045596;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1484397045.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1484397045;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (CharSequence[]) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "CharSequence[]", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.052 -0400", hash_original_method = "D295BFB1D3C25A7A56AF1D8267856D3B", hash_generated_method = "FAD573F894DF907EB0FFA25C88CA86B8")
    @Deprecated
    public IBinder getIBinder(String key) {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_79061966 = null; //Variable for return #1
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1818055752 = null; //Variable for return #2
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1797944572 = null; //Variable for return #3
        unparcel();
        Object o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_79061966 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1818055752 = (IBinder) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "IBinder", e);
            varB4EAC82CA7396A68D541C85D26508E83_1797944572 = null;
        } //End block
        addTaint(key.getTaint());
        IBinder varA7E53CE21691AB073D9660D615818899_288779827; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_288779827 = varB4EAC82CA7396A68D541C85D26508E83_79061966;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_288779827 = varB4EAC82CA7396A68D541C85D26508E83_1818055752;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_288779827 = varB4EAC82CA7396A68D541C85D26508E83_1797944572;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_288779827.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_288779827;
        // ---------- Original Method ----------
        //unparcel();
        //Object o = mMap.get(key);
        //if (o == null) {
            //return null;
        //}
        //try {
            //return (IBinder) o;
        //} catch (ClassCastException e) {
            //typeWarning(key, o, "IBinder", e);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.053 -0400", hash_original_method = "E95F1FE0EF3EE3193ED648BBE2C98991", hash_generated_method = "EB860D69A7D6B516AC757C7CC0A36DA1")
    public int describeContents() {
        int mask = 0;
        {
            boolean varADA79EE0A477F90AF032C4198B610819_1130388461 = (hasFileDescriptors());
            {
                mask |= Parcelable.CONTENTS_FILE_DESCRIPTOR;
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108500884 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108500884;
        // ---------- Original Method ----------
        //int mask = 0;
        //if (hasFileDescriptors()) {
            //mask |= Parcelable.CONTENTS_FILE_DESCRIPTOR;
        //}
        //return mask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.054 -0400", hash_original_method = "90A94F467F11AD2B1AEECA4B5BC07A1D", hash_generated_method = "0266C4C4C1C24CE261363F825B86A978")
    public void writeToParcel(Parcel parcel, int flags) {
        final boolean oldAllowFds = parcel.pushAllowFds(mAllowFds);
        try 
        {
            {
                int length = mParcelledData.dataSize();
                parcel.writeInt(length);
                parcel.writeInt(0x4C444E42);
                parcel.appendFrom(mParcelledData, 0, length);
            } //End block
            {
                parcel.writeInt(-1);
                parcel.writeInt(0x4C444E42);
                int oldPos = parcel.dataPosition();
                parcel.writeMapInternal(mMap);
                int newPos = parcel.dataPosition();
                parcel.setDataPosition(oldPos - 8);
                int length = newPos - oldPos;
                parcel.writeInt(length);
                parcel.setDataPosition(newPos);
            } //End block
        } //End block
        finally 
        {
            parcel.restoreAllowFds(oldAllowFds);
        } //End block
        addTaint(parcel.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.054 -0400", hash_original_method = "046D2D4D1B8612C0E98B2174C0C88DC5", hash_generated_method = "DBC64C5BF90C6BB6CD60669849F82BC2")
    public void readFromParcel(Parcel parcel) {
        int length = parcel.readInt();
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Bad length in parcel: " + length);
        } //End block
        readFromParcelInner(parcel, length);
        addTaint(parcel.getTaint());
        // ---------- Original Method ----------
        //int length = parcel.readInt();
        //if (length < 0) {
            //throw new RuntimeException("Bad length in parcel: " + length);
        //}
        //readFromParcelInner(parcel, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.055 -0400", hash_original_method = "BA7474E49C1BD74E29BF5B4706535141", hash_generated_method = "6D4B5189272CCB1D4E88E19172282A49")
     void readFromParcelInner(Parcel parcel, int length) {
        int magic = parcel.readInt();
        {
            String st = Log.getStackTraceString(new RuntimeException());
        } //End block
        int offset = parcel.dataPosition();
        parcel.setDataPosition(offset + length);
        Parcel p = Parcel.obtain();
        p.setDataPosition(0);
        p.appendFrom(parcel, offset, length);
        p.setDataPosition(0);
        mParcelledData = p;
        mHasFds = p.hasFileDescriptors();
        mFdsKnown = true;
        addTaint(parcel.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //int magic = parcel.readInt();
        //if (magic != 0x4C444E42) {
            //String st = Log.getStackTraceString(new RuntimeException());
            //Log.e("Bundle", "readBundle: bad magic number");
            //Log.e("Bundle", "readBundle: trace = " + st);
        //}
        //int offset = parcel.dataPosition();
        //parcel.setDataPosition(offset + length);
        //Parcel p = Parcel.obtain();
        //p.setDataPosition(0);
        //p.appendFrom(parcel, offset, length);
        //p.setDataPosition(0);
        //mParcelledData = p;
        //mHasFds = p.hasFileDescriptors();
        //mFdsKnown = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.055 -0400", hash_original_method = "6D3D0FD7A771D9A5F3ECAE6DEB73615C", hash_generated_method = "60061F5525264A2E703521026B8CE3CA")
    @Override
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_356174807 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1645961735 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_356174807 = "Bundle[mParcelledData.dataSize=" +
                    mParcelledData.dataSize() + "]";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1645961735 = "Bundle[" + mMap.toString() + "]";
        String varA7E53CE21691AB073D9660D615818899_1174291900; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1174291900 = varB4EAC82CA7396A68D541C85D26508E83_356174807;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1174291900 = varB4EAC82CA7396A68D541C85D26508E83_1645961735;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1174291900.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1174291900;
        // ---------- Original Method ----------
        //if (mParcelledData != null) {
            //return "Bundle[mParcelledData.dataSize=" +
                    //mParcelledData.dataSize() + "]";
        //}
        //return "Bundle[" + mMap.toString() + "]";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.056 -0400", hash_original_field = "9D5F877D7AA7E8D8702157333DF2C046", hash_generated_field = "B4A59EF1F4C419B90A176C13462BE720")

    private static final String LOG_TAG = "Bundle";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.056 -0400", hash_original_field = "BA2B45BDC11E2A4A6E86AAB2AC693CBB", hash_generated_field = "801351E620DCAB87B984F712F19DA2C3")

    public static final Bundle EMPTY;
    static {
        EMPTY = new Bundle();
        EMPTY.mMap = Collections.unmodifiableMap(new HashMap<String, Object>());
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.056 -0400", hash_original_field = "B4FE070174283716AFC584FD34F1BAE3", hash_generated_field = "C6D8CFB9909EC6A413DB28D9E9FEC6F2")

    public static final Parcelable.Creator<Bundle> CREATOR =
        new Parcelable.Creator<Bundle>() {
        public Bundle createFromParcel(Parcel in) {
            return in.readBundle();
        }

        public Bundle[] newArray(int size) {
            return new Bundle[size];
        }
    };
    // orphaned legacy method
    public Bundle createFromParcel(Parcel in) {
            return in.readBundle();
        }
    
    // orphaned legacy method
    public Bundle[] newArray(int size) {
            return new Bundle[size];
        }
    
}

