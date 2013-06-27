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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.127 -0400", hash_original_field = "6C9D7AEB7CF5AE9F2141CB23F95F4D45", hash_generated_field = "6C79F547522536A208CAFCE9016DC05F")

    Map<String, Object> mMap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.127 -0400", hash_original_field = "6F0688E91A01AD80018225C89D147561", hash_generated_field = "E5162DF86C59E17EA59FEBB7EF559274")

    Parcel mParcelledData = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.127 -0400", hash_original_field = "9BDF733D1D0EFCF06F719222F55E0B82", hash_generated_field = "118C47CE2184B36A84368A2523875D08")

    private boolean mHasFds = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.127 -0400", hash_original_field = "93BA40E6351E40670C537B5E15D7DF94", hash_generated_field = "9003EC392C88BA1EADB5D26698887EBB")

    private boolean mFdsKnown = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.127 -0400", hash_original_field = "C459D1B5B4B22FFBFAEDCC421A1613ED", hash_generated_field = "C91DCF8BDF06F4CA952EC1031BBDC33F")

    private boolean mAllowFds = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.128 -0400", hash_original_field = "334890635C1887AB66991B9374637EE6", hash_generated_field = "ABE17DFC947454E8F85FE66E61741F7A")

    private ClassLoader mClassLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.129 -0400", hash_original_method = "40BE022BD5AEEE3B1F4C24A599FDBBB4", hash_generated_method = "D0B412F9D9C998F60A5827E098F54A80")
    public  Bundle() {
        mMap = new HashMap<String, Object>();
        mClassLoader = getClass().getClassLoader();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>();
        //mClassLoader = getClass().getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.130 -0400", hash_original_method = "DB07395F523937B25016D60988A66D69", hash_generated_method = "4F493D4EDE24A291FE82ADFB785F281A")
      Bundle(Parcel parcelledData) {
        readFromParcel(parcelledData);
        addTaint(parcelledData.getTaint());
        // ---------- Original Method ----------
        //readFromParcel(parcelledData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.149 -0400", hash_original_method = "4CBA8A75160127E76B9D77B8452C524A", hash_generated_method = "262D038D796E6FD0D31B80F71E99B9C8")
      Bundle(Parcel parcelledData, int length) {
        readFromParcelInner(parcelledData, length);
        addTaint(parcelledData.getTaint());
        addTaint(length);
        // ---------- Original Method ----------
        //readFromParcelInner(parcelledData, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.247 -0400", hash_original_method = "ED19BD28A9BE16566DAB3F7BC8440A20", hash_generated_method = "54C66743395BE4AB6BAD14CE7AE27455")
    public  Bundle(ClassLoader loader) {
        mMap = new HashMap<String, Object>();
        mClassLoader = loader;
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>();
        //mClassLoader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.249 -0400", hash_original_method = "1CEDEB07DCD1E2A2BE2C52C76F89017C", hash_generated_method = "2B27A067BF7B2EDAA4C66221F6D6260E")
    public  Bundle(int capacity) {
        mMap = new HashMap<String, Object>(capacity);
        mClassLoader = getClass().getClassLoader();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>(capacity);
        //mClassLoader = getClass().getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.252 -0400", hash_original_method = "418D42BD4A8F16B387F3064B9218EE53", hash_generated_method = "94AFCA0B5F6517208A0414B1B3E22A6A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.266 -0400", hash_original_method = "B3609B2F52C0BA6BE21E26730F76FD99", hash_generated_method = "6DDB33A95DC750072AB17949E78C78F8")
    public String getPairValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_39046761 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_942043174 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1751899894 = null; //Variable for return #3
        unparcel();
        int size;
        size = mMap.size();
        {
            varB4EAC82CA7396A68D541C85D26508E83_39046761 = null;
        } //End block
        Object o;
        o = mMap.values().iterator().next();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_942043174 = (String) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning("getPairValue()", o, "String", e);
            varB4EAC82CA7396A68D541C85D26508E83_1751899894 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_525742959; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_525742959 = varB4EAC82CA7396A68D541C85D26508E83_39046761;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_525742959 = varB4EAC82CA7396A68D541C85D26508E83_942043174;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_525742959 = varB4EAC82CA7396A68D541C85D26508E83_1751899894;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_525742959.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_525742959;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.267 -0400", hash_original_method = "98C9A117007F79899B5BBD029ABFD6B8", hash_generated_method = "1DFA79725EDD590714D0602080EA4C5B")
    public void setClassLoader(ClassLoader loader) {
        mClassLoader = loader;
        // ---------- Original Method ----------
        //mClassLoader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.268 -0400", hash_original_method = "DF35DB07DA97BBA7096331B39E871560", hash_generated_method = "2BAD29462CB6DFB3093776EB15F400C1")
    public ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_186233999 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_186233999 = mClassLoader;
        varB4EAC82CA7396A68D541C85D26508E83_186233999.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_186233999;
        // ---------- Original Method ----------
        //return mClassLoader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.269 -0400", hash_original_method = "3A854A40DC72470BF5CA49CF20D41873", hash_generated_method = "F473D2B972355DE72E197D0490BB274D")
    public boolean setAllowFds(boolean allowFds) {
        boolean orig;
        orig = mAllowFds;
        mAllowFds = allowFds;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_491892272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_491892272;
        // ---------- Original Method ----------
        //boolean orig = mAllowFds;
        //mAllowFds = allowFds;
        //return orig;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.269 -0400", hash_original_method = "8ED269C57B5B4F834AF78EEAE05F20CC", hash_generated_method = "6EF89EE7C1BA0A3C1F2D704E9EED4F39")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1846572936 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1846572936 = new Bundle(this);
        varB4EAC82CA7396A68D541C85D26508E83_1846572936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1846572936;
        // ---------- Original Method ----------
        //return new Bundle(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.284 -0400", hash_original_method = "C84307F15A2AB40D2A9CA51D74C5FD0F", hash_generated_method = "1AAB81889F454BA9CC6CFB5ECEE0CA0E")
    synchronized void unparcel() {
        int N;
        N = mParcelledData.readInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.286 -0400", hash_original_method = "89E974D778C485ED4A98439CDF5961E3", hash_generated_method = "B916EA06F9AB087855A1CB2CB9BC730C")
    public int size() {
        unparcel();
        int varEB72A5C76BB8A5CD8667491C4358251D_1212220969 = (mMap.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_276372529 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_276372529;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.286 -0400", hash_original_method = "8B93AFDE665AAAFE98B5EE9FD5355D4B", hash_generated_method = "846D8132D6DE8FD45D82F8E3C17DF9EB")
    public boolean isEmpty() {
        unparcel();
        boolean varCFBB58DB314314B44F78CC84300FBF36_1412805449 = (mMap.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_890246525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_890246525;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.298 -0400", hash_original_method = "9DC77B5F54151FE5CD815F7C8172B2ED", hash_generated_method = "E511022D09E81C4678253AC729CF8B7F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.299 -0400", hash_original_method = "F5C0B952F7E6EDB282A82D73FA397DBD", hash_generated_method = "A88F08524C925297D53871D72A3906D7")
    public boolean containsKey(String key) {
        unparcel();
        boolean var3CCD836522265B0EF3CEF15E617425E2_1633713127 = (mMap.containsKey(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231493113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231493113;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.300 -0400", hash_original_method = "E6C9158A697ED4C4296ED4A1595BA584", hash_generated_method = "67E9DDFE4946B942ADFD7B402A141E85")
    public Object get(String key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1062091604 = null; //Variable for return #1
        unparcel();
        varB4EAC82CA7396A68D541C85D26508E83_1062091604 = mMap.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1062091604.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1062091604;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.311 -0400", hash_original_method = "717A16AB4D98DDB60DEBCEA5CDF9B0B2", hash_generated_method = "DF4FBD191E1E4047653C75195B2DF6DC")
    public void remove(String key) {
        unparcel();
        mMap.remove(key);
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.313 -0400", hash_original_method = "F30E47B42E381C2413B1100E1A47D1F8", hash_generated_method = "19C8D719C8CECA801C0058973A2CCB2F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.325 -0400", hash_original_method = "00E2D8861948F8DB601BFD39768039D0", hash_generated_method = "99448751A025A9003441FF2C3892A13E")
    public Set<String> keySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_463486875 = null; //Variable for return #1
        unparcel();
        varB4EAC82CA7396A68D541C85D26508E83_463486875 = mMap.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_463486875.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_463486875;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.329 -0400", hash_original_method = "4B0480B2866CB29DA37F7AEC68A5E217", hash_generated_method = "788A0DBA447EEC646AC7A88622BCBB7C")
    public boolean hasFileDescriptors() {
        {
            boolean fdFound;
            fdFound = false;
            {
                {
                    boolean varE7E90B5396C9FB1A90488751D202C0DE_609138999 = (mParcelledData.hasFileDescriptors());
                    {
                        fdFound = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                Iterator<Map.Entry<String, Object>> iter;
                iter = mMap.entrySet().iterator();
                {
                    boolean var3C9C2559EA47B4922E81E22A4D970516_1072694828 = (!fdFound && iter.hasNext());
                    {
                        Object obj;
                        obj = iter.next().getValue();
                        {
                            {
                                boolean var3B3CD3B239B9599F818BBBB4D19F1B2A_940271506 = ((((Parcelable)obj).describeContents()
                                & Parcelable.CONTENTS_FILE_DESCRIPTOR) != 0);
                                {
                                    fdFound = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            Parcelable[] array;
                            array = (Parcelable[]) obj;
                            {
                                int n;
                                n = array.length - 1;
                                {
                                    {
                                        boolean var33811AA2303D21D7631EEBA0E4C5547F_1114252202 = ((array[n].describeContents()
                                    & Parcelable.CONTENTS_FILE_DESCRIPTOR) != 0);
                                        {
                                            fdFound = true;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            SparseArray<? extends Parcelable> array;
                            array = (SparseArray<? extends Parcelable>) obj;
                            {
                                int n;
                                n = array.size() - 1;
                                {
                                    {
                                        boolean var70216DAA8A60B74EE111A55FCE3E036D_829067464 = ((array.get(n).describeContents()
                                    & Parcelable.CONTENTS_FILE_DESCRIPTOR) != 0);
                                        {
                                            fdFound = true;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            ArrayList array;
                            array = (ArrayList) obj;
                            {
                                boolean var01F44C1854281F36799A73E27E5377CB_1379883736 = ((array.size() > 0)
                                && (array.get(0) instanceof Parcelable));
                                {
                                    {
                                        int n;
                                        n = array.size() - 1;
                                        {
                                            Parcelable p;
                                            p = (Parcelable) array.get(n);
                                            {
                                                boolean varB72014908EB71D72428783AAB42D64BD_1711158165 = (p != null && ((p.describeContents()
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2073676425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2073676425;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.341 -0400", hash_original_method = "94490DFEC498722DA435B9597CF0EDDE", hash_generated_method = "494AB25FA6A81D96516162AA6A9D1B9B")
    public void putBoolean(String key, boolean value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.342 -0400", hash_original_method = "60D945D31D7D04981E268C4CC855B009", hash_generated_method = "DB58D69051013C99B29E0CDCA52C51B9")
    public void putByte(String key, byte value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.342 -0400", hash_original_method = "C6C3CAC58AEE8EB92E7D233D1233B510", hash_generated_method = "42F76C1D0264FA9CAB3150F183581F56")
    public void putChar(String key, char value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.360 -0400", hash_original_method = "48338BC49C4A94D5C3F73368CEF11822", hash_generated_method = "4C0874B7B8A54699830F32CC32C43359")
    public void putShort(String key, short value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.361 -0400", hash_original_method = "C2DD503B984E96C46288CB6F7C364E09", hash_generated_method = "5D3E666E5FDCB6BA807C0EDD04871858")
    public void putInt(String key, int value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.362 -0400", hash_original_method = "32D4E331D0F655A9205640C19ABF2B58", hash_generated_method = "C0AA1D9348779BCBED0D770DF5DF9CD4")
    public void putLong(String key, long value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.362 -0400", hash_original_method = "292C24CEC676EE3F6A373A1AE7371B82", hash_generated_method = "2E845DA9BB168C72F06E8BE4742A1D79")
    public void putFloat(String key, float value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.363 -0400", hash_original_method = "1F6C5CEB9374270482ED4835594D6EF1", hash_generated_method = "71003B4C7F25080872872AFB0EE5C2AA")
    public void putDouble(String key, double value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.375 -0400", hash_original_method = "E7336EB9055C9F862A0B8D336BB5AE0F", hash_generated_method = "7816AC3BB90926D49A526B6EC283C598")
    public void putString(String key, String value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.382 -0400", hash_original_method = "23A8E01E039C76712F2C134222EAC45B", hash_generated_method = "46A172DF81D81C96F22CB347403CCE82")
    public void putCharSequence(String key, CharSequence value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.383 -0400", hash_original_method = "F17082A305780CE778B93F20A20D0318", hash_generated_method = "97B87056F9E9E578C0288E3B1B1AC30E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.384 -0400", hash_original_method = "1666E21FDEAC3D0C57D8E38C022A7AD2", hash_generated_method = "AB3493F683AF138DFFECDC97CFA63471")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.385 -0400", hash_original_method = "C07428EAC6D62CA3DF6F67489B512A7E", hash_generated_method = "BCCC9435D6AB39DA30787AAC1241646C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.385 -0400", hash_original_method = "93FD4CBDA1682EAF0E9F2535BF397F65", hash_generated_method = "1C95511FD52FD3883F61813628F41E09")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.398 -0400", hash_original_method = "6C90B1571D2A36769CB59FB958C842F7", hash_generated_method = "33A49484B3903C40530A39873BF05318")
    public void putIntegerArrayList(String key, ArrayList<Integer> value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.399 -0400", hash_original_method = "ABD9DF23A5A8A0A83F11C474E2CAFB17", hash_generated_method = "EED67E59E8EF89327B3FE4FFF12A8F5B")
    public void putStringArrayList(String key, ArrayList<String> value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.399 -0400", hash_original_method = "C0F2E9DF48888A828D6640DBBB8ADDE5", hash_generated_method = "90DB59B439C94CE30326EDE54E889BE1")
    public void putCharSequenceArrayList(String key, ArrayList<CharSequence> value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.400 -0400", hash_original_method = "C647C81034119067E2383CA02CF65D5F", hash_generated_method = "2DA89C2C68C1A78D7D29D3EA69888266")
    public void putSerializable(String key, Serializable value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.404 -0400", hash_original_method = "8E721A4E4DD3EA40820BFACA50BE3D1C", hash_generated_method = "B193962005F024D6B35BA1C05CB5F256")
    public void putBooleanArray(String key, boolean[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.415 -0400", hash_original_method = "1C56E40FECAB1AC7C31C1D64DCBF74F0", hash_generated_method = "EF58BE1AF605747C5F24DE666B17280D")
    public void putByteArray(String key, byte[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.426 -0400", hash_original_method = "2FF709A9E88600F14AEB34FA372FB7A3", hash_generated_method = "0D16F8DFC75EBEF3B15A6FCE4CC0B13D")
    public void putShortArray(String key, short[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.446 -0400", hash_original_method = "5BBE3077A529F887080D848A31F1E40F", hash_generated_method = "26C2ADE47A5F58F5B454842FE0891C8D")
    public void putCharArray(String key, char[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.447 -0400", hash_original_method = "6E03156089AB80D54004D251F8CBA9A8", hash_generated_method = "DE6C9E68B50D52B95903B2BAC3553073")
    public void putIntArray(String key, int[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.450 -0400", hash_original_method = "749D6A41C446C63F668941511653896B", hash_generated_method = "377BBB9FF2626B758A3D8599BAE29FF9")
    public void putLongArray(String key, long[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.451 -0400", hash_original_method = "6C49285A06086C4B176330EBC83C2D3B", hash_generated_method = "8617DFDF7A371A58C45590FF69D6C55A")
    public void putFloatArray(String key, float[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.452 -0400", hash_original_method = "BF0DED73B6BC272CA81A76D665AF3892", hash_generated_method = "AA6007DD29FFD4C5E982FE0DE9F5318E")
    public void putDoubleArray(String key, double[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0]);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.454 -0400", hash_original_method = "3F318C6E0F37B53192FF4A33987FF921", hash_generated_method = "878351A3EA1C3DAF2EF1E19856E3AFA5")
    public void putStringArray(String key, String[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0].getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.455 -0400", hash_original_method = "D442CACA5F4C37E249E32A5FC3EA1B00", hash_generated_method = "FE4707CAA813DDE0EE06E3FE02A6912E")
    public void putCharSequenceArray(String key, CharSequence[] value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value[0].getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.474 -0400", hash_original_method = "8FC0D5E8787A84A268AF6F8743FC18A2", hash_generated_method = "E032378C3A88AE79BCE1A35FAEB24389")
    public void putBundle(String key, Bundle value) {
        unparcel();
        mMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.476 -0400", hash_original_method = "0DA9D5A0C7EE7D2AFD4BCC53AD3802F3", hash_generated_method = "141E1EF0A46C9B3C0CC36B149F5FE6DC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.476 -0400", hash_original_method = "44491868325766EC5AED04910C3A4D05", hash_generated_method = "F8436ADF9A4087110EF585AFF103F65D")
    public boolean getBoolean(String key) {
        unparcel();
        boolean var4C9107722E78C3479502DC8113A34442_1506694358 = (getBoolean(key, false));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1892999244 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1892999244;
        // ---------- Original Method ----------
        //unparcel();
        //return getBoolean(key, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.490 -0400", hash_original_method = "017EA18B11E7843C44A73EB9482CE841", hash_generated_method = "9BFB16ABE534A75DED2922C625C4963A")
    private void typeWarning(String key, Object value, String className,
        Object defaultValue, ClassCastException e) {
        StringBuilder sb;
        sb = new StringBuilder();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.492 -0400", hash_original_method = "AA5C4C6D2863DB47E466486DB4471393", hash_generated_method = "80390375825A47B320F6385F7290E5D7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.493 -0400", hash_original_method = "62E0EA051DB8CF7BEF8CA2ACB88171F1", hash_generated_method = "192AC5DCAEB353622D204F3DE7794226")
    public boolean getBoolean(String key, boolean defaultValue) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_788108494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_788108494;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.503 -0400", hash_original_method = "E9711B4A318F78DD358F0F07FAB02724", hash_generated_method = "61D4ABF577CCF54D699BFE2B0197EE6F")
    public byte getByte(String key) {
        unparcel();
        byte varF5DF8FD13401C680C4079E46D48E559E_368716020 = (getByte(key, (byte) 0));
        addTaint(key.getTaint());
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1840412123 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1840412123;
        // ---------- Original Method ----------
        //unparcel();
        //return getByte(key, (byte) 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.521 -0400", hash_original_method = "44660F005C21F1E59A8F3EDCC4F5A0ED", hash_generated_method = "22A74B0CAD7D375A556502C6C99DDE2F")
    public Byte getByte(String key, byte defaultValue) {
        Byte varB4EAC82CA7396A68D541C85D26508E83_259234107 = null; //Variable for return #1
        Byte varB4EAC82CA7396A68D541C85D26508E83_1056648961 = null; //Variable for return #2
        Byte varB4EAC82CA7396A68D541C85D26508E83_492877297 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_259234107 = defaultValue;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1056648961 = (Byte) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Byte", defaultValue, e);
            varB4EAC82CA7396A68D541C85D26508E83_492877297 = defaultValue;
        } //End block
        addTaint(key.getTaint());
        addTaint(defaultValue);
        Byte varA7E53CE21691AB073D9660D615818899_1273830416; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1273830416 = varB4EAC82CA7396A68D541C85D26508E83_259234107;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1273830416 = varB4EAC82CA7396A68D541C85D26508E83_1056648961;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1273830416 = varB4EAC82CA7396A68D541C85D26508E83_492877297;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1273830416.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1273830416;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.523 -0400", hash_original_method = "82E77139364787BB6587747BA780C45B", hash_generated_method = "8C3A976C5136C1DED1C4763BA3617799")
    public char getChar(String key) {
        unparcel();
        char var27F1A2D2AC9426CDE46A1342145F88A3_206954578 = (getChar(key, (char) 0));
        addTaint(key.getTaint());
        char varA87DEB01C5F539E6BDA34829C8EF2368_1305377963 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1305377963;
        // ---------- Original Method ----------
        //unparcel();
        //return getChar(key, (char) 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.524 -0400", hash_original_method = "1B86701C5E776F178851B3C57F1F092F", hash_generated_method = "ABBF6C19BD6275BF2905AB8353FF2368")
    public char getChar(String key, char defaultValue) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        char varA87DEB01C5F539E6BDA34829C8EF2368_418086691 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_418086691;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.539 -0400", hash_original_method = "949AF94B781EE8B084883F15F1BA2BF2", hash_generated_method = "57D4AC70DF32F17D7D4B590B43AA091F")
    public short getShort(String key) {
        unparcel();
        short varC3D9771DE8675C9D280694DECEDD0AFB_431533383 = (getShort(key, (short) 0));
        addTaint(key.getTaint());
        short var4F09DAA9D95BCB166A302407A0E0BABE_1331919740 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1331919740;
        // ---------- Original Method ----------
        //unparcel();
        //return getShort(key, (short) 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.541 -0400", hash_original_method = "CB97516320C4B19AFFFFC9855DAD2391", hash_generated_method = "245A790254EF4005EE790FB3B3437D5B")
    public short getShort(String key, short defaultValue) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        short var4F09DAA9D95BCB166A302407A0E0BABE_788137908 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_788137908;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.541 -0400", hash_original_method = "E147114FE6EABC6FAB98EAC3907FD421", hash_generated_method = "58C6BB5B689C440B85CFE86CC0B9B323")
    public int getInt(String key) {
        unparcel();
        int var8CD2947803356231BBC241492425AC77_50927089 = (getInt(key, 0));
        addTaint(key.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1245116070 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1245116070;
        // ---------- Original Method ----------
        //unparcel();
        //return getInt(key, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.543 -0400", hash_original_method = "83073F806AC00C1E2EC4E710A5472BFA", hash_generated_method = "1828BD3BB72E12D8471BF0C233EEBCE9")
    public int getInt(String key, int defaultValue) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593221125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593221125;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.557 -0400", hash_original_method = "0CFFDE7713416A17E206C69E138AC0FF", hash_generated_method = "0BC7F4CC257EBCAB16A5C57B0BF79A40")
    public long getLong(String key) {
        unparcel();
        long var979CD6852D7A16006D946D82F7EF4D0A_548370663 = (getLong(key, 0L));
        addTaint(key.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_112678625 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_112678625;
        // ---------- Original Method ----------
        //unparcel();
        //return getLong(key, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.559 -0400", hash_original_method = "84BBB1371E3F4460B78F31822950EAAA", hash_generated_method = "7D936EE1A13C7C2770DD8A521786DEDB")
    public long getLong(String key, long defaultValue) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1019130270 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1019130270;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.567 -0400", hash_original_method = "0D69D7EB25C8E886B27D28B7A30E217C", hash_generated_method = "65C982960231D84F9647C50E90371402")
    public float getFloat(String key) {
        unparcel();
        float var1F2989949A680EEB88317D0F20C8813F_2136470636 = (getFloat(key, 0.0f));
        addTaint(key.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_266257933 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_266257933;
        // ---------- Original Method ----------
        //unparcel();
        //return getFloat(key, 0.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.576 -0400", hash_original_method = "8162EC4F2AE30557D489C5C6263EB256", hash_generated_method = "4CE54CA3F2D0D51A66E235766222126B")
    public float getFloat(String key, float defaultValue) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1031519015 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1031519015;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.578 -0400", hash_original_method = "F5086ED2941BC7C3CB9930D22842FA44", hash_generated_method = "F624A8461EB2A322871783B2C7150A53")
    public double getDouble(String key) {
        unparcel();
        double varAF1883587E9789F106C3A6801CFE65B3_319557497 = (getDouble(key, 0.0));
        addTaint(key.getTaint());
        double varE8CD7DA078A86726031AD64F35F5A6C0_1969764845 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1969764845;
        // ---------- Original Method ----------
        //unparcel();
        //return getDouble(key, 0.0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.578 -0400", hash_original_method = "172C416958EF64BBE0F98CDA39B416EB", hash_generated_method = "9100E1026EEFF118C29DED67163697AF")
    public double getDouble(String key, double defaultValue) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        addTaint(defaultValue);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1551277181 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1551277181;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.579 -0400", hash_original_method = "51BC83F6E10D252B7C417A14343A53BE", hash_generated_method = "470229DCAC0AB460A1781FA9D997F795")
    public String getString(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_151037796 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_908757900 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_776767843 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_151037796 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_908757900 = (String) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "String", e);
            varB4EAC82CA7396A68D541C85D26508E83_776767843 = null;
        } //End block
        addTaint(key.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1895118442; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1895118442 = varB4EAC82CA7396A68D541C85D26508E83_151037796;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1895118442 = varB4EAC82CA7396A68D541C85D26508E83_908757900;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1895118442 = varB4EAC82CA7396A68D541C85D26508E83_776767843;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1895118442.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1895118442;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.598 -0400", hash_original_method = "BC80281EBAB10986EFB226B5D89A6368", hash_generated_method = "EB8CDC822F253FA164EA63F039808F44")
    public String getString(String key, String defaultValue) {
        String varB4EAC82CA7396A68D541C85D26508E83_781858398 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1176610776 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_751955351 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_781858398 = defaultValue;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1176610776 = (String) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "String", e);
            varB4EAC82CA7396A68D541C85D26508E83_751955351 = defaultValue;
        } //End block
        addTaint(key.getTaint());
        addTaint(defaultValue.getTaint());
        String varA7E53CE21691AB073D9660D615818899_461317869; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_461317869 = varB4EAC82CA7396A68D541C85D26508E83_781858398;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_461317869 = varB4EAC82CA7396A68D541C85D26508E83_1176610776;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_461317869 = varB4EAC82CA7396A68D541C85D26508E83_751955351;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_461317869.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_461317869;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.608 -0400", hash_original_method = "4D51A99620432005EDE9794C44D49E24", hash_generated_method = "72263F732B0150A41565709A99791D12")
    public CharSequence getCharSequence(String key) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1552724191 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1515662995 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_203681015 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1552724191 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1515662995 = (CharSequence) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "CharSequence", e);
            varB4EAC82CA7396A68D541C85D26508E83_203681015 = null;
        } //End block
        addTaint(key.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1314284663; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1314284663 = varB4EAC82CA7396A68D541C85D26508E83_1552724191;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1314284663 = varB4EAC82CA7396A68D541C85D26508E83_1515662995;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1314284663 = varB4EAC82CA7396A68D541C85D26508E83_203681015;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1314284663.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1314284663;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.622 -0400", hash_original_method = "C5E593A01F019636F8A087C171F20745", hash_generated_method = "0E78280EE90FDF59D5F7B5EA4520AF9C")
    public CharSequence getCharSequence(String key, CharSequence defaultValue) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1653398065 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1597823612 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_877842981 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1653398065 = defaultValue;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1597823612 = (CharSequence) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "CharSequence", e);
            varB4EAC82CA7396A68D541C85D26508E83_877842981 = defaultValue;
        } //End block
        addTaint(key.getTaint());
        addTaint(defaultValue.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1078827289; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1078827289 = varB4EAC82CA7396A68D541C85D26508E83_1653398065;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1078827289 = varB4EAC82CA7396A68D541C85D26508E83_1597823612;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1078827289 = varB4EAC82CA7396A68D541C85D26508E83_877842981;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1078827289.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1078827289;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.625 -0400", hash_original_method = "7BDB21170493B124DD321ED35C766BAB", hash_generated_method = "C77797E82DB0DDBA5EFFD56D7B6B087D")
    public Bundle getBundle(String key) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_236368351 = null; //Variable for return #1
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1478902641 = null; //Variable for return #2
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1187715289 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_236368351 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1478902641 = (Bundle) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Bundle", e);
            varB4EAC82CA7396A68D541C85D26508E83_1187715289 = null;
        } //End block
        addTaint(key.getTaint());
        Bundle varA7E53CE21691AB073D9660D615818899_541574784; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_541574784 = varB4EAC82CA7396A68D541C85D26508E83_236368351;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_541574784 = varB4EAC82CA7396A68D541C85D26508E83_1478902641;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_541574784 = varB4EAC82CA7396A68D541C85D26508E83_1187715289;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_541574784.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_541574784;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.642 -0400", hash_original_method = "3B646958426B4FA703D61CD64DB4127C", hash_generated_method = "4BD3F5E5730E382AF48BD8DDA43BC4ED")
    public <T extends Parcelable> T getParcelable(String key) {
        T varB4EAC82CA7396A68D541C85D26508E83_694033066 = null; //Variable for return #1
        T varB4EAC82CA7396A68D541C85D26508E83_337652485 = null; //Variable for return #2
        T varB4EAC82CA7396A68D541C85D26508E83_234310625 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_694033066 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_337652485 = (T) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Parcelable", e);
            varB4EAC82CA7396A68D541C85D26508E83_234310625 = null;
        } //End block
        addTaint(key.getTaint());
        T varA7E53CE21691AB073D9660D615818899_1527645082; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1527645082 = varB4EAC82CA7396A68D541C85D26508E83_694033066;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1527645082 = varB4EAC82CA7396A68D541C85D26508E83_337652485;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1527645082 = varB4EAC82CA7396A68D541C85D26508E83_234310625;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1527645082.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1527645082;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.654 -0400", hash_original_method = "ACB5B2AD81C8600B2F6954C0DE15936B", hash_generated_method = "D85ACA4A51968C1F8436F2305D89F799")
    public Parcelable[] getParcelableArray(String key) {
        Parcelable[] varB4EAC82CA7396A68D541C85D26508E83_1826716064 = null; //Variable for return #1
        Parcelable[] varB4EAC82CA7396A68D541C85D26508E83_2145923044 = null; //Variable for return #2
        Parcelable[] varB4EAC82CA7396A68D541C85D26508E83_1616307385 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1826716064 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2145923044 = (Parcelable[]) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Parcelable[]", e);
            varB4EAC82CA7396A68D541C85D26508E83_1616307385 = null;
        } //End block
        addTaint(key.getTaint());
        Parcelable[] varA7E53CE21691AB073D9660D615818899_655593088; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_655593088 = varB4EAC82CA7396A68D541C85D26508E83_1826716064;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_655593088 = varB4EAC82CA7396A68D541C85D26508E83_2145923044;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_655593088 = varB4EAC82CA7396A68D541C85D26508E83_1616307385;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_655593088.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_655593088;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.667 -0400", hash_original_method = "4066E862ACF29CBEB786556AAFBFC58D", hash_generated_method = "F59EFFB3C9D237EB9C827C1A14350744")
    public <T extends Parcelable> ArrayList<T> getParcelableArrayList(String key) {
        ArrayList<T> varB4EAC82CA7396A68D541C85D26508E83_1885811666 = null; //Variable for return #1
        ArrayList<T> varB4EAC82CA7396A68D541C85D26508E83_754774324 = null; //Variable for return #2
        ArrayList<T> varB4EAC82CA7396A68D541C85D26508E83_310427890 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1885811666 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_754774324 = (ArrayList<T>) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList", e);
            varB4EAC82CA7396A68D541C85D26508E83_310427890 = null;
        } //End block
        addTaint(key.getTaint());
        ArrayList<T> varA7E53CE21691AB073D9660D615818899_2050573575; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2050573575 = varB4EAC82CA7396A68D541C85D26508E83_1885811666;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2050573575 = varB4EAC82CA7396A68D541C85D26508E83_754774324;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2050573575 = varB4EAC82CA7396A68D541C85D26508E83_310427890;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2050573575.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2050573575;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.668 -0400", hash_original_method = "F3D4EB475C3465E3892E6091F83F5D92", hash_generated_method = "6C488996D67D9E38966CB59FAC478ECA")
    public <T extends Parcelable> SparseArray<T> getSparseParcelableArray(String key) {
        SparseArray<T> varB4EAC82CA7396A68D541C85D26508E83_1431054386 = null; //Variable for return #1
        SparseArray<T> varB4EAC82CA7396A68D541C85D26508E83_1390074539 = null; //Variable for return #2
        SparseArray<T> varB4EAC82CA7396A68D541C85D26508E83_1138830478 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1431054386 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1390074539 = (SparseArray<T>) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "SparseArray", e);
            varB4EAC82CA7396A68D541C85D26508E83_1138830478 = null;
        } //End block
        addTaint(key.getTaint());
        SparseArray<T> varA7E53CE21691AB073D9660D615818899_780668988; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_780668988 = varB4EAC82CA7396A68D541C85D26508E83_1431054386;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_780668988 = varB4EAC82CA7396A68D541C85D26508E83_1390074539;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_780668988 = varB4EAC82CA7396A68D541C85D26508E83_1138830478;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_780668988.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_780668988;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.685 -0400", hash_original_method = "3E1FB271E8FDF7CD375ECA97D496DB8C", hash_generated_method = "E18C57B1C55D3F23352E0EEDE5016CF4")
    public Serializable getSerializable(String key) {
        Serializable varB4EAC82CA7396A68D541C85D26508E83_1821033393 = null; //Variable for return #1
        Serializable varB4EAC82CA7396A68D541C85D26508E83_688011773 = null; //Variable for return #2
        Serializable varB4EAC82CA7396A68D541C85D26508E83_1808658542 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1821033393 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_688011773 = (Serializable) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Serializable", e);
            varB4EAC82CA7396A68D541C85D26508E83_1808658542 = null;
        } //End block
        addTaint(key.getTaint());
        Serializable varA7E53CE21691AB073D9660D615818899_1876506526; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1876506526 = varB4EAC82CA7396A68D541C85D26508E83_1821033393;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1876506526 = varB4EAC82CA7396A68D541C85D26508E83_688011773;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1876506526 = varB4EAC82CA7396A68D541C85D26508E83_1808658542;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1876506526.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1876506526;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.686 -0400", hash_original_method = "129B869D98875CE72FDC17E4CC2A1579", hash_generated_method = "6FA86DA81A95F9F012DF5F148028443C")
    public ArrayList<Integer> getIntegerArrayList(String key) {
        ArrayList<Integer> varB4EAC82CA7396A68D541C85D26508E83_1563270675 = null; //Variable for return #1
        ArrayList<Integer> varB4EAC82CA7396A68D541C85D26508E83_2068291538 = null; //Variable for return #2
        ArrayList<Integer> varB4EAC82CA7396A68D541C85D26508E83_1619159894 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1563270675 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2068291538 = (ArrayList<Integer>) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList<Integer>", e);
            varB4EAC82CA7396A68D541C85D26508E83_1619159894 = null;
        } //End block
        addTaint(key.getTaint());
        ArrayList<Integer> varA7E53CE21691AB073D9660D615818899_1081401127; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1081401127 = varB4EAC82CA7396A68D541C85D26508E83_1563270675;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1081401127 = varB4EAC82CA7396A68D541C85D26508E83_2068291538;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1081401127 = varB4EAC82CA7396A68D541C85D26508E83_1619159894;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1081401127.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1081401127;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.688 -0400", hash_original_method = "2869BDF5623DD5162F6A69DFD2D1F8AB", hash_generated_method = "7D0A96C39B0BB2FF2EAB25D39637253D")
    public ArrayList<String> getStringArrayList(String key) {
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_1803116638 = null; //Variable for return #1
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_800959250 = null; //Variable for return #2
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_1199587834 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1803116638 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_800959250 = (ArrayList<String>) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList<String>", e);
            varB4EAC82CA7396A68D541C85D26508E83_1199587834 = null;
        } //End block
        addTaint(key.getTaint());
        ArrayList<String> varA7E53CE21691AB073D9660D615818899_242810739; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_242810739 = varB4EAC82CA7396A68D541C85D26508E83_1803116638;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_242810739 = varB4EAC82CA7396A68D541C85D26508E83_800959250;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_242810739 = varB4EAC82CA7396A68D541C85D26508E83_1199587834;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_242810739.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_242810739;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.706 -0400", hash_original_method = "9A13BDFEA4BB8512D10DFA31FFDE883A", hash_generated_method = "F7FCFEC9E2537AD2CC35B1B665EFA6BD")
    public ArrayList<CharSequence> getCharSequenceArrayList(String key) {
        ArrayList<CharSequence> varB4EAC82CA7396A68D541C85D26508E83_1742600716 = null; //Variable for return #1
        ArrayList<CharSequence> varB4EAC82CA7396A68D541C85D26508E83_795179412 = null; //Variable for return #2
        ArrayList<CharSequence> varB4EAC82CA7396A68D541C85D26508E83_1963704954 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1742600716 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_795179412 = (ArrayList<CharSequence>) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList<CharSequence>", e);
            varB4EAC82CA7396A68D541C85D26508E83_1963704954 = null;
        } //End block
        addTaint(key.getTaint());
        ArrayList<CharSequence> varA7E53CE21691AB073D9660D615818899_159043203; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_159043203 = varB4EAC82CA7396A68D541C85D26508E83_1742600716;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_159043203 = varB4EAC82CA7396A68D541C85D26508E83_795179412;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_159043203 = varB4EAC82CA7396A68D541C85D26508E83_1963704954;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_159043203.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_159043203;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.707 -0400", hash_original_method = "2242EDC01DC8898E91E207F436901294", hash_generated_method = "AE7FEF87905234E4F8ADCDB91AF5DB29")
    public boolean[] getBooleanArray(String key) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_317137983 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_317137983;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.712 -0400", hash_original_method = "61BA553FC99180BEC5D34878EFD2124D", hash_generated_method = "BEF83505DA90B507BA854E051D3E7318")
    public byte[] getByteArray(String key) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_115987117 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_115987117;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.713 -0400", hash_original_method = "7BB50DA07B268F9685287E0D939131D4", hash_generated_method = "0BC57C5D579462C9D8A6E16A8C0F2A4E")
    public short[] getShortArray(String key) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        short[] var48EE7E2DDF8A83602BC526873BD0F875_1799855024 = {getTaintShort()};
        return var48EE7E2DDF8A83602BC526873BD0F875_1799855024;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.713 -0400", hash_original_method = "E77DD9D06089068562F2943DA73C8461", hash_generated_method = "BBD1C0C9BA656EA0FB07BE0D2D97EB22")
    public char[] getCharArray(String key) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1687322350 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1687322350;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.728 -0400", hash_original_method = "85622F3A5EF64119863AB7B7CCBF9703", hash_generated_method = "055AE5CA4F60704B1F13A1F6F75CE8E0")
    public int[] getIntArray(String key) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_684717031 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_684717031;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.729 -0400", hash_original_method = "27B2CD54F5F69E8E74D59A821000C81A", hash_generated_method = "6B3DFFB5953CEB668B08CBC001F49C27")
    public long[] getLongArray(String key) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1661492387 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1661492387;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.730 -0400", hash_original_method = "CF7D6838E0F23E6456879FF35A2AC714", hash_generated_method = "F317AB2E22E938C498BC9A3AD38FCE69")
    public float[] getFloatArray(String key) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        float[] varB2C245003BAB9224CFB496218F7DAFE0_187659489 = {getTaintFloat()};
        return varB2C245003BAB9224CFB496218F7DAFE0_187659489;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.730 -0400", hash_original_method = "3231DDBB4D17868FEAA7FF4365CACCDA", hash_generated_method = "EB7EC728106F50494AC1E714141DAF28")
    public double[] getDoubleArray(String key) {
        unparcel();
        Object o;
        o = mMap.get(key);
        addTaint(key.getTaint());
        double[] var74D44D7D9EE6FE6C3433D694F869E521_632847587 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_632847587;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.731 -0400", hash_original_method = "00D6B9CB5DC261567748885D1CE89780", hash_generated_method = "BE6DE97C6D2D01B7BA03E1E34DC56D05")
    public String[] getStringArray(String key) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1792488813 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_1517871715 = null; //Variable for return #2
        String[] varB4EAC82CA7396A68D541C85D26508E83_163542327 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1792488813 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1517871715 = (String[]) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "String[]", e);
            varB4EAC82CA7396A68D541C85D26508E83_163542327 = null;
        } //End block
        addTaint(key.getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_792204172; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_792204172 = varB4EAC82CA7396A68D541C85D26508E83_1792488813;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_792204172 = varB4EAC82CA7396A68D541C85D26508E83_1517871715;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_792204172 = varB4EAC82CA7396A68D541C85D26508E83_163542327;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_792204172.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_792204172;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.754 -0400", hash_original_method = "E55D822FE040164347A1371A3EEFE758", hash_generated_method = "A6C24535CB0C9AA96F36F1DDA9594D26")
    public CharSequence[] getCharSequenceArray(String key) {
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_120791734 = null; //Variable for return #1
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_1261207838 = null; //Variable for return #2
        CharSequence[] varB4EAC82CA7396A68D541C85D26508E83_814471553 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_120791734 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1261207838 = (CharSequence[]) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "CharSequence[]", e);
            varB4EAC82CA7396A68D541C85D26508E83_814471553 = null;
        } //End block
        addTaint(key.getTaint());
        CharSequence[] varA7E53CE21691AB073D9660D615818899_1509613006; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1509613006 = varB4EAC82CA7396A68D541C85D26508E83_120791734;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1509613006 = varB4EAC82CA7396A68D541C85D26508E83_1261207838;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1509613006 = varB4EAC82CA7396A68D541C85D26508E83_814471553;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1509613006.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1509613006;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.755 -0400", hash_original_method = "D295BFB1D3C25A7A56AF1D8267856D3B", hash_generated_method = "87CD267C3C804590269EE2DD81C3CC0C")
    @Deprecated
    public IBinder getIBinder(String key) {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1892852818 = null; //Variable for return #1
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1236435028 = null; //Variable for return #2
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1702587375 = null; //Variable for return #3
        unparcel();
        Object o;
        o = mMap.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1892852818 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1236435028 = (IBinder) o;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "IBinder", e);
            varB4EAC82CA7396A68D541C85D26508E83_1702587375 = null;
        } //End block
        addTaint(key.getTaint());
        IBinder varA7E53CE21691AB073D9660D615818899_1848000527; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1848000527 = varB4EAC82CA7396A68D541C85D26508E83_1892852818;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1848000527 = varB4EAC82CA7396A68D541C85D26508E83_1236435028;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1848000527 = varB4EAC82CA7396A68D541C85D26508E83_1702587375;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1848000527.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1848000527;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.756 -0400", hash_original_method = "E95F1FE0EF3EE3193ED648BBE2C98991", hash_generated_method = "5306516D7CDA2D513B01E09BBC1943FF")
    public int describeContents() {
        int mask;
        mask = 0;
        {
            boolean varADA79EE0A477F90AF032C4198B610819_1133719697 = (hasFileDescriptors());
            {
                mask |= Parcelable.CONTENTS_FILE_DESCRIPTOR;
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113306163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113306163;
        // ---------- Original Method ----------
        //int mask = 0;
        //if (hasFileDescriptors()) {
            //mask |= Parcelable.CONTENTS_FILE_DESCRIPTOR;
        //}
        //return mask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.764 -0400", hash_original_method = "90A94F467F11AD2B1AEECA4B5BC07A1D", hash_generated_method = "11B9CA7A432E3A23F6E61A33B5F868A8")
    public void writeToParcel(Parcel parcel, int flags) {
        boolean oldAllowFds;
        oldAllowFds = parcel.pushAllowFds(mAllowFds);
        try 
        {
            {
                int length;
                length = mParcelledData.dataSize();
                parcel.writeInt(length);
                parcel.writeInt(0x4C444E42);
                parcel.appendFrom(mParcelledData, 0, length);
            } //End block
            {
                parcel.writeInt(-1);
                parcel.writeInt(0x4C444E42);
                int oldPos;
                oldPos = parcel.dataPosition();
                parcel.writeMapInternal(mMap);
                int newPos;
                newPos = parcel.dataPosition();
                parcel.setDataPosition(oldPos - 8);
                int length;
                length = newPos - oldPos;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.765 -0400", hash_original_method = "046D2D4D1B8612C0E98B2174C0C88DC5", hash_generated_method = "06CDD781796C7DA4618458A604BB1DEA")
    public void readFromParcel(Parcel parcel) {
        int length;
        length = parcel.readInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.766 -0400", hash_original_method = "BA7474E49C1BD74E29BF5B4706535141", hash_generated_method = "EDFD631F877C14CC0E7E55C38AD14497")
     void readFromParcelInner(Parcel parcel, int length) {
        int magic;
        magic = parcel.readInt();
        {
            String st;
            st = Log.getStackTraceString(new RuntimeException());
        } //End block
        int offset;
        offset = parcel.dataPosition();
        parcel.setDataPosition(offset + length);
        Parcel p;
        p = Parcel.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.780 -0400", hash_original_method = "6D3D0FD7A771D9A5F3ECAE6DEB73615C", hash_generated_method = "80DE9EF7DBF55F6BBF677622F33CD5B0")
    @Override
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_620104948 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1649946155 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_620104948 = "Bundle[mParcelledData.dataSize=" +
                    mParcelledData.dataSize() + "]";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1649946155 = "Bundle[" + mMap.toString() + "]";
        String varA7E53CE21691AB073D9660D615818899_1154465004; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1154465004 = varB4EAC82CA7396A68D541C85D26508E83_620104948;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1154465004 = varB4EAC82CA7396A68D541C85D26508E83_1649946155;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1154465004.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1154465004;
        // ---------- Original Method ----------
        //if (mParcelledData != null) {
            //return "Bundle[mParcelledData.dataSize=" +
                    //mParcelledData.dataSize() + "]";
        //}
        //return "Bundle[" + mMap.toString() + "]";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.780 -0400", hash_original_field = "9D5F877D7AA7E8D8702157333DF2C046", hash_generated_field = "ED87FE3BB0CBBE81C8FB2AE2212F9CBE")

    private static String LOG_TAG = "Bundle";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.780 -0400", hash_original_field = "BA2B45BDC11E2A4A6E86AAB2AC693CBB", hash_generated_field = "801351E620DCAB87B984F712F19DA2C3")

    public static final Bundle EMPTY;
    static {
        EMPTY = new Bundle();
        EMPTY.mMap = Collections.unmodifiableMap(new HashMap<String, Object>());
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.780 -0400", hash_original_field = "B4FE070174283716AFC584FD34F1BAE3", hash_generated_field = "C6D8CFB9909EC6A413DB28D9E9FEC6F2")

    public static final Parcelable.Creator<Bundle> CREATOR =
        new Parcelable.Creator<Bundle>() {
        public Bundle createFromParcel(Parcel in) {
            return in.readBundle();
        }

        public Bundle[] newArray(int size) {
            return new Bundle[size];
        }
    };
}

