package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import android.util.Log;
import java.util.Collections;
import java.util.Set;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.HashMap;
public final class Bundle implements Parcelable, Cloneable {

    /**
     * Make a Bundle for a single key/value pair.
     *
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.420 -0500", hash_original_method = "7228E76FDB53607D003E8E811CE36961", hash_generated_method = "5750746718A1E8C6C2CA1F87F40A83F9")
    
public static Bundle forPair(String key, String value) {
        // TODO: optimize this case.
        Bundle b = new Bundle(1);
        b.putString(key, value);
        return b;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.387 -0500", hash_original_field = "07F897F75D2772CED4A52BA1760A3D18", hash_generated_field = "B4A59EF1F4C419B90A176C13462BE720")

    private static final String LOG_TAG = "Bundle";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.389 -0500", hash_original_field = "96B58C1963D7EFDC9006E7C4C0C6B96C", hash_generated_field = "4A4568FB693A86216C53FDCE59A4411E")

    public static  Bundle EMPTY;
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.831 -0400", hash_original_field = "B4FE070174283716AFC584FD34F1BAE3", hash_generated_field = "C6D8CFB9909EC6A413DB28D9E9FEC6F2")

    public static final Parcelable.Creator<Bundle> CREATOR =
        new Parcelable.Creator<Bundle>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.619 -0500", hash_original_method = "4187614240FC5282A7CB86A3FCAECB06", hash_generated_method = "2886D3B3EE607F31AE6ADF0F5552BE50")
        
public Bundle createFromParcel(Parcel in) {
            return in.readBundle();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.622 -0500", hash_original_method = "5E82917C5DD51CF815A5AE0167A86BCD", hash_generated_method = "A1B84E1D370373495779D4026ECFB2FC")
        
public Bundle[] newArray(int size) {
            return new Bundle[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.392 -0500", hash_original_field = "6C79F547522536A208CAFCE9016DC05F", hash_generated_field = "09043077682E4B16C29DC90BFAB3DAE5")

    // (except inside a call to unparcel)

    @DSVAModeled
    public Map<String, Object> mMap = new HashMap<String, Object>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.394 -0500", hash_original_field = "E5162DF86C59E17EA59FEBB7EF559274", hash_generated_field = "E946E9EF60C24CFB270D51C185FC58B8")

    /* package */ Parcel mParcelledData = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.396 -0500", hash_original_field = "3C6E1DAFF86B5C3AFAC7EFF4C589B67C", hash_generated_field = "118C47CE2184B36A84368A2523875D08")

    private boolean mHasFds = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.398 -0500", hash_original_field = "7CF2780BD59FB07D81DA25AAE5AFB6B0", hash_generated_field = "9003EC392C88BA1EADB5D26698887EBB")

    private boolean mFdsKnown = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.400 -0500", hash_original_field = "679050C68EEC5DDC5DEE2DA338632182", hash_generated_field = "C91DCF8BDF06F4CA952EC1031BBDC33F")

    private boolean mAllowFds = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.403 -0500", hash_original_field = "C796B6EA08214602D7AD9664511F1AF7", hash_generated_field = "ABE17DFC947454E8F85FE66E61741F7A")

    private ClassLoader mClassLoader;

    /**
     * Constructs a new, empty Bundle.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.405 -0500", hash_original_method = "40BE022BD5AEEE3B1F4C24A599FDBBB4", hash_generated_method = "2E4F8DD9FFAB812A4C4E1772928E04E9")
    
public Bundle() {
        mClassLoader = getClass().getClassLoader();
    }

    /**
     * Constructs a Bundle whose data is stored as a Parcel.  The data
     * will be unparcelled on first contact, using the assigned ClassLoader.
     *
     * @param parcelledData a Parcel containing a Bundle
     */
    @DSComment("constructor")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.407 -0500", hash_original_method = "DB07395F523937B25016D60988A66D69", hash_generated_method = "DB07395F523937B25016D60988A66D69")
    
Bundle(Parcel parcelledData) {
        readFromParcel(parcelledData);
    }

    /* package */ @DSComment("constructor")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.409 -0500", hash_original_method = "4CBA8A75160127E76B9D77B8452C524A", hash_generated_method = "4CBA8A75160127E76B9D77B8452C524A")
    
Bundle(Parcel parcelledData, int length) {
        readFromParcelInner(parcelledData, length);
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.032 -0400", hash_original_method = "ED19BD28A9BE16566DAB3F7BC8440A20", hash_generated_method = "54C66743395BE4AB6BAD14CE7AE27455")
    public  Bundle(ClassLoader loader) {
        mMap = new HashMap<String, Object>();
        mClassLoader = loader;
        //addTaint(loader.getTaint());
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>();
        //mClassLoader = loader;
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.042 -0400", hash_original_method = "1CEDEB07DCD1E2A2BE2C52C76F89017C", hash_generated_method = "2B27A067BF7B2EDAA4C66221F6D6260E")
    public  Bundle(int capacity) {
        mMap = new HashMap<String, Object>(capacity);
        mClassLoader = getClass().getClassLoader();
        addTaint(capacity);
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>(capacity);
        //mClassLoader = getClass().getClassLoader();
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.074 -0400", hash_original_method = "418D42BD4A8F16B387F3064B9218EE53", hash_generated_method = "11F544B121F75AF0D84F3AB92D420B7B")
    public  Bundle(Bundle b) {
        if(b.mParcelledData != null)        
        {
            mParcelledData = Parcel.obtain();
            mParcelledData.appendFrom(b.mParcelledData, 0, b.mParcelledData.dataSize());
            mParcelledData.setDataPosition(0);
        } //End block
        else
        {
            mParcelledData = null;
        } //End block
        if(b.mMap != null)        
        {
            mMap = new HashMap<String, Object>(b.mMap);
        } //End block
        else
        {
            mMap = null;
        } //End block
        mHasFds = b.mHasFds;
        mFdsKnown = b.mFdsKnown;
        mClassLoader = b.mClassLoader;
        addTaint(b.getTaint());
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
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.101 -0400", hash_original_method = "B3609B2F52C0BA6BE21E26730F76FD99", hash_generated_method = "9C90301FB89A3A9EB402F91B96770480")
    public String getPairValue() {
        unparcel();
        int size = mMap.size();
        
        Object o = mMap.values().iterator().next();
        
        return (String) o;
        
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
    
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.110 -0400", hash_original_method = "98C9A117007F79899B5BBD029ABFD6B8", hash_generated_method = "1DFA79725EDD590714D0602080EA4C5B")
    public void setClassLoader(ClassLoader loader) {
        mClassLoader = loader;
        //addTaint(loader.getTaint());
        // ---------- Original Method ----------
        //mClassLoader = loader;
    }

    /**
     * Return the ClassLoader currently associated with this Bundle.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.427 -0500", hash_original_method = "DF35DB07DA97BBA7096331B39E871560", hash_generated_method = "666A56A90106E4EA1164F12E6967534C")
    
public ClassLoader getClassLoader() {
        return mClassLoader;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.122 -0400", hash_original_method = "3A854A40DC72470BF5CA49CF20D41873", hash_generated_method = "091591AA36EE67155873DDBC7C2F6F04")
    public boolean setAllowFds(boolean allowFds) {
        boolean orig = mAllowFds;
        mAllowFds = allowFds;
        //addTaint(allowFds);
        boolean var025F253325B46929CD34F2A7C3C55E7C_657424141 = (orig);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839057912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839057912;
        // ---------- Original Method ----------
        //boolean orig = mAllowFds;
        //mAllowFds = allowFds;
        //return orig;
    }

    /**
     * Clones the current Bundle. The internal map is cloned, but the keys and
     * values to which it refers are copied by reference.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.431 -0500", hash_original_method = "8ED269C57B5B4F834AF78EEAE05F20CC", hash_generated_method = "05C0BDAE85DE493D806AFBD3AE58240D")
    
@Override
    public Object clone() {
        return new Bundle(this);
    }

    /**
     * If the underlying data are stored as a Parcel, unparcel them
     * using the currently assigned class loader.
     */
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.433 -0500", hash_original_method = "C84307F15A2AB40D2A9CA51D74C5FD0F", hash_generated_method = "ED5D513DE4FFFE667446D5431C83A8D7")
    
synchronized void unparcel() {
        // if (mParcelledData == null) {
        //     return;
        // }

        // //int N = mParcelledData.readInt();
        // //if (N < 0) {
        // //    return;
        // //}
        // if (mMap == null) {
        //     mMap = new HashMap<String, Object>();
        // }
        // mParcelledData.readMapInternal(mMap, N, mClassLoader);
        // mParcelledData.recycle();
        // mParcelledData = null;
    }
    
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.146 -0400", hash_original_method = "89E974D778C485ED4A98439CDF5961E3", hash_generated_method = "2589B20E3DA759F2944F86B92C96601F")
    public int size() {
        unparcel();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_722182444 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_722182444;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.size();
    }
    
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.152 -0400", hash_original_method = "8B93AFDE665AAAFE98B5EE9FD5355D4B", hash_generated_method = "3DE10A26149EEB2E3D91D31D57ADFD12")
    public boolean isEmpty() {
        unparcel();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436061990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436061990;
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.isEmpty();
    }

    /**
     * Removes all elements from the mapping of this Bundle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.440 -0500", hash_original_method = "9DC77B5F54151FE5CD815F7C8172B2ED", hash_generated_method = "2349A50CCF393CB495DF5F2FA6277027")
    
public void clear() {
        unparcel();
        mMap.clear();
        mHasFds = false;
        mFdsKnown = true;
    }

    /**
     * Returns true if the given key is contained in the mapping
     * of this Bundle.
     *
     * @param key a String key
     * @return true if the key is part of the mapping, false otherwise
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.442 -0500", hash_original_method = "F5C0B952F7E6EDB282A82D73FA397DBD", hash_generated_method = "B78738A491B15050745DD41B2D9BECE8")
    
public boolean containsKey(String key) {
        unparcel();
        return mMap.containsKey(key);
    }

    /**
     * Returns the entry with the given key as an object.
     *
     * @param key a String key
     * @return an Object, or null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.444 -0500", hash_original_method = "E6C9158A697ED4C4296ED4A1595BA584", hash_generated_method = "E7E26841E84A6B6A9D5EC9D7CD01763B")
    
public Object get(String key) {
        unparcel();
        return mMap.get(key);
    }

    /**
     * Removes any entry with the given key from the mapping of this Bundle.
     *
     * @param key a String key
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.446 -0500", hash_original_method = "717A16AB4D98DDB60DEBCEA5CDF9B0B2", hash_generated_method = "AD0429969CFF11E49824D5999E82F350")
    
public void remove(String key) {
        unparcel();
        mMap.remove(key);
    }

    /**
     * Inserts all mappings from the given Bundle into this Bundle.
     *
     * @param map a Bundle
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.448 -0500", hash_original_method = "F30E47B42E381C2413B1100E1A47D1F8", hash_generated_method = "C674B3B3DD0691391001B45F0CE3A9E5")
    
public void putAll(Bundle map) {
        unparcel();
        map.unparcel();
        mMap.putAll(map.mMap);

        // fd state is now known if and only if both bundles already knew
        mHasFds |= map.mHasFds;
        mFdsKnown = mFdsKnown && map.mFdsKnown;
    }

    /**
     * Returns a Set containing the Strings used as keys in this Bundle.
     *
     * @return a Set of String keys
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.450 -0500", hash_original_method = "00E2D8861948F8DB601BFD39768039D0", hash_generated_method = "BE31F1C699094CF6E6C11BAADEFB05F1")
    
public Set<String> keySet() {
        unparcel();
        return mMap.keySet();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.242 -0400", hash_original_method = "4B0480B2866CB29DA37F7AEC68A5E217", hash_generated_method = "5DEF87C3126270DC5B9ED343C95E52E8")
    public boolean hasFileDescriptors() {
        return getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
    /**
     * Inserts a Boolean value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a Boolean, or null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.457 -0500", hash_original_method = "94490DFEC498722DA435B9597CF0EDDE", hash_generated_method = "D06CBF81F2867BB687F3C98679973161")
    
public void putBoolean(String key, boolean value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a byte value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a byte
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.459 -0500", hash_original_method = "60D945D31D7D04981E268C4CC855B009", hash_generated_method = "240CCC45A5DAEB561D1B1CD9883B6407")
    
public void putByte(String key, byte value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a char value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a char, or null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.461 -0500", hash_original_method = "C6C3CAC58AEE8EB92E7D233D1233B510", hash_generated_method = "69802445E72FE1E207C3697FD4610E2E")
    
public void putChar(String key, char value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a short value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a short
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.463 -0500", hash_original_method = "48338BC49C4A94D5C3F73368CEF11822", hash_generated_method = "40E5D56C660E674AEAC1983F06C125A3")
    
public void putShort(String key, short value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts an int value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value an int, or null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.465 -0500", hash_original_method = "C2DD503B984E96C46288CB6F7C364E09", hash_generated_method = "4AC8318C015B20964426413A31217551")
    
public void putInt(String key, int value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a long value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a long
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.467 -0500", hash_original_method = "32D4E331D0F655A9205640C19ABF2B58", hash_generated_method = "8F57D9890D036571C1D1866F6CF386C5")
    
public void putLong(String key, long value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a float value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a float
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.469 -0500", hash_original_method = "292C24CEC676EE3F6A373A1AE7371B82", hash_generated_method = "2FACA41C84A2478691CF5236461898B1")
    
public void putFloat(String key, float value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a double value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key a String, or null
     * @param value a double
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.471 -0500", hash_original_method = "1F6C5CEB9374270482ED4835594D6EF1", hash_generated_method = "877978322BA244A0BEA7112AEE13C2F5")
    
public void putDouble(String key, double value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a String value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a String, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.474 -0500", hash_original_method = "E7336EB9055C9F862A0B8D336BB5AE0F", hash_generated_method = "9B77596588C53FA62A7F6A9D3F01E4F8")
    
public void putString(String key, String value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a CharSequence value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a CharSequence, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.476 -0500", hash_original_method = "23A8E01E039C76712F2C134222EAC45B", hash_generated_method = "EA68455D0713862A2AE3E437A935F177")
    
public void putCharSequence(String key, CharSequence value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a Parcelable value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a Parcelable object, or null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.478 -0500", hash_original_method = "F17082A305780CE778B93F20A20D0318", hash_generated_method = "328E649DB95D7BCD75AD520B7DB513E8")
    
public void putParcelable(String key, Parcelable value) {
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
    }

    /**
     * Inserts an array of Parcelable values into the mapping of this Bundle,
     * replacing any existing value for the given key.  Either key or value may
     * be null.
     *
     * @param key a String, or null
     * @param value an array of Parcelable objects, or null
     */
    @DSComment("Data serialization/deserialization")
    @DSSpec(DSCat.SERIALIZATION)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.480 -0500", hash_original_method = "1666E21FDEAC3D0C57D8E38C022A7AD2", hash_generated_method = "2400F64B7D1A1D47FB478A0CEC8DD502")
    
public void putParcelableArray(String key, Parcelable[] value) {
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
    }

    /**
     * Inserts a List of Parcelable values into the mapping of this Bundle,
     * replacing any existing value for the given key.  Either key or value may
     * be null.
     *
     * @param key a String, or null
     * @param value an ArrayList of Parcelable objects, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.482 -0500", hash_original_method = "C07428EAC6D62CA3DF6F67489B512A7E", hash_generated_method = "D4F0BB866FF91AE238790A8A6EE5AF88")
    
public void putParcelableArrayList(String key,
        ArrayList<? extends Parcelable> value) {
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
    }

    /**
     * Inserts a SparceArray of Parcelable values into the mapping of this
     * Bundle, replacing any existing value for the given key.  Either key
     * or value may be null.
     *
     * @param key a String, or null
     * @param value a SparseArray of Parcelable objects, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.485 -0500", hash_original_method = "93FD4CBDA1682EAF0E9F2535BF397F65", hash_generated_method = "650875F4F65C3A61BA4CCCBEFD84BCF5")
    
public void putSparseParcelableArray(String key,
            SparseArray<? extends Parcelable> value) {
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
    }

    /**
     * Inserts an ArrayList<Integer> value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value an ArrayList<Integer> object, or null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.487 -0500", hash_original_method = "6C90B1571D2A36769CB59FB958C842F7", hash_generated_method = "427819B9974AD331D76B1095B8CA7023")
    
public void putIntegerArrayList(String key, ArrayList<Integer> value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts an ArrayList<String> value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value an ArrayList<String> object, or null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.489 -0500", hash_original_method = "ABD9DF23A5A8A0A83F11C474E2CAFB17", hash_generated_method = "196266A25FB1B61B7E293883A2B18682")
    
public void putStringArrayList(String key, ArrayList<String> value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts an ArrayList<CharSequence> value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value an ArrayList<CharSequence> object, or null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.492 -0500", hash_original_method = "C0F2E9DF48888A828D6640DBBB8ADDE5", hash_generated_method = "D3ABD393302D2F8BD59B3AC7E2DC782D")
    
public void putCharSequenceArrayList(String key, ArrayList<CharSequence> value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a Serializable value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a Serializable object, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.494 -0500", hash_original_method = "C647C81034119067E2383CA02CF65D5F", hash_generated_method = "4BA2962153220EE5043BE8A4597C831E")
    
public void putSerializable(String key, Serializable value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a boolean array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a boolean array object, or null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.496 -0500", hash_original_method = "8E721A4E4DD3EA40820BFACA50BE3D1C", hash_generated_method = "58BD281F5835739A9176EEFBD8CF5219")
    
public void putBooleanArray(String key, boolean[] value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a byte array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a byte array object, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.498 -0500", hash_original_method = "1C56E40FECAB1AC7C31C1D64DCBF74F0", hash_generated_method = "0206D8B9EEFAE3F5D1FE5F44A497BC16")
    
public void putByteArray(String key, byte[] value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a short array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a short array object, or null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.501 -0500", hash_original_method = "2FF709A9E88600F14AEB34FA372FB7A3", hash_generated_method = "BEF718C3C1F07F62E8C1D81C8B2729AD")
    
public void putShortArray(String key, short[] value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a char array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a char array object, or null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.503 -0500", hash_original_method = "5BBE3077A529F887080D848A31F1E40F", hash_generated_method = "3192B333EC6E5C498F80E759DA81C637")
    
public void putCharArray(String key, char[] value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts an int array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value an int array object, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.505 -0500", hash_original_method = "6E03156089AB80D54004D251F8CBA9A8", hash_generated_method = "C0C3A6D4334E11C7E7E55FB20260433D")
    
public void putIntArray(String key, int[] value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a long array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a long array object, or null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.507 -0500", hash_original_method = "749D6A41C446C63F668941511653896B", hash_generated_method = "55879D13B87CD3A5D8B928E5CF1696FB")
    
public void putLongArray(String key, long[] value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a float array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a float array object, or null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.509 -0500", hash_original_method = "6C49285A06086C4B176330EBC83C2D3B", hash_generated_method = "E7FBE6DA0D5B9B10EFF899381DE4E390")
    
public void putFloatArray(String key, float[] value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a double array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a double array object, or null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.512 -0500", hash_original_method = "BF0DED73B6BC272CA81A76D665AF3892", hash_generated_method = "A2076636F5AB03C501737F8FA41B4580")
    
public void putDoubleArray(String key, double[] value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a String array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a String array object, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.514 -0500", hash_original_method = "3F318C6E0F37B53192FF4A33987FF921", hash_generated_method = "FE79E8BA5AF6257B211C93119EFF9427")
    
public void putStringArray(String key, String[] value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a CharSequence array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a CharSequence array object, or null
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.516 -0500", hash_original_method = "D442CACA5F4C37E249E32A5FC3EA1B00", hash_generated_method = "DDBB425D41D43B34CE4517F62847711C")
    
public void putCharSequenceArray(String key, CharSequence[] value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts a Bundle value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value a Bundle object, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.518 -0500", hash_original_method = "8FC0D5E8787A84A268AF6F8743FC18A2", hash_generated_method = "6F7D480D452EFF0784927D78F4534B62")
    
public void putBundle(String key, Bundle value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Inserts an IBinder value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key a String, or null
     * @param value an IBinder object, or null
     *
     * @deprecated
     * @hide
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.520 -0500", hash_original_method = "0DA9D5A0C7EE7D2AFD4BCC53AD3802F3", hash_generated_method = "72956D90BC7B32B0D39A00538E67E3E0")
    
@Deprecated
    public void putIBinder(String key, IBinder value) {
        unparcel();
        mMap.put(key, value);
    }

    /**
     * Returns the value associated with the given key, or false if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a boolean value
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.522 -0500", hash_original_method = "44491868325766EC5AED04910C3A4D05", hash_generated_method = "D1979B14E028B71AE1D6B9674428E0B1")
    
public boolean getBoolean(String key) {
        unparcel();
        return getBoolean(key, false);
    }

    // Log a message if the value was non-null but not of the expected type
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.525 -0500", hash_original_method = "017EA18B11E7843C44A73EB9482CE841", hash_generated_method = "7C692202F11C0AFCA2ED479E051CDCCC")
    
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
        Log.w(LOG_TAG, sb.toString());
        Log.w(LOG_TAG, "Attempt to cast generated internal exception:", e);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.527 -0500", hash_original_method = "AA5C4C6D2863DB47E466486DB4471393", hash_generated_method = "2DD8F779FC54291A2423C235432192F3")
    
private void typeWarning(String key, Object value, String className,
        ClassCastException e) {
        typeWarning(key, value, className, "<null>", e);
    }
    
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.445 -0400", hash_original_method = "62E0EA051DB8CF7BEF8CA2ACB88171F1", hash_generated_method = "85B0E924776CDCBCD46F75FE8DDED70C")
    public boolean getBoolean(String key, boolean defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return defaultValue;
        }
        try {
            return (Boolean) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Boolean", defaultValue, e);
            return defaultValue;
        }
    }
    
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.453 -0400", hash_original_method = "E9711B4A318F78DD358F0F07FAB02724", hash_generated_method = "7CDE4B3DA7CC5151B6E1EE322F54DDC4")
    public byte getByte(String key) {
        return getByte(key, (byte) 0);
    }
    
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.459 -0400", hash_original_method = "44660F005C21F1E59A8F3EDCC4F5A0ED", hash_generated_method = "8AC1CB1AEF35009035F9F39AE8DF8133")
    public Byte getByte(String key, byte defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return defaultValue;
        }
        try {
            return (Byte) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Byte", defaultValue, e);
            return defaultValue;
        }
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.466 -0400", hash_original_method = "82E77139364787BB6587747BA780C45B", hash_generated_method = "F494331CB0DEE0D6602E45E444A2F6C1")
    public char getChar(String key) {
        unparcel();
        return getChar(key, (char) 0);
    }

    /**
     * Returns the value associated with the given key, or (char) 0 if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a char value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.538 -0500", hash_original_method = "1B86701C5E776F178851B3C57F1F092F", hash_generated_method = "403F5ABCD0D6ACA6E4A4CCE1CF295BA6")
    
public char getChar(String key, char defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return defaultValue;
        }
        try {
            return (Character) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Character", defaultValue, e);
            return defaultValue;
        }
    }

    /**
     * Returns the value associated with the given key, or (short) 0 if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a short value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.540 -0500", hash_original_method = "949AF94B781EE8B084883F15F1BA2BF2", hash_generated_method = "B7E5A4C7DFC4E2524881B79F707A82AF")
    
public short getShort(String key) {
        unparcel();
        return getShort(key, (short) 0);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a short value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.542 -0500", hash_original_method = "CB97516320C4B19AFFFFC9855DAD2391", hash_generated_method = "25C0AAB0DC2B2D54D36CE0993C8D6EA4")
    
public short getShort(String key, short defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return defaultValue;
        }
        try {
            return (Short) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Short", defaultValue, e);
            return defaultValue;
        }
    }

    /**
     * Returns the value associated with the given key, or 0 if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return an int value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.545 -0500", hash_original_method = "E147114FE6EABC6FAB98EAC3907FD421", hash_generated_method = "CB945A82DA2C8ED3356E82972EDE1C4A")
    
public int getInt(String key) {
        unparcel();
        return getInt(key, 0);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return an int value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.547 -0500", hash_original_method = "83073F806AC00C1E2EC4E710A5472BFA", hash_generated_method = "B4328D17C93F2CA0559B5562F5AC19F6")
    
public int getInt(String key, int defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return defaultValue;
        }
        try {
            return (Integer) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Integer", defaultValue, e);
            return defaultValue;
        }
    }

    /**
     * Returns the value associated with the given key, or 0L if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a long value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.549 -0500", hash_original_method = "0CFFDE7713416A17E206C69E138AC0FF", hash_generated_method = "280B3B770C86AAD43B0180F3944619B2")
    
public long getLong(String key) {
        unparcel();
        return getLong(key, 0L);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a long value
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.552 -0500", hash_original_method = "84BBB1371E3F4460B78F31822950EAAA", hash_generated_method = "C6EB7F9E11C719D6CA244BE7991CFEB6")
    
public long getLong(String key, long defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return defaultValue;
        }
        try {
            return (Long) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Long", defaultValue, e);
            return defaultValue;
        }
    }

    /**
     * Returns the value associated with the given key, or 0.0f if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a float value
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.555 -0500", hash_original_method = "0D69D7EB25C8E886B27D28B7A30E217C", hash_generated_method = "5DA71DD50FB35EB08C4A643AD592C4BA")
    
public float getFloat(String key) {
        unparcel();
        return getFloat(key, 0.0f);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a float value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.557 -0500", hash_original_method = "8162EC4F2AE30557D489C5C6263EB256", hash_generated_method = "F13375F497615D6D9855025B2EA4E90E")
    
public float getFloat(String key, float defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return defaultValue;
        }
        try {
            return (Float) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Float", defaultValue, e);
            return defaultValue;
        }
    }

    /**
     * Returns the value associated with the given key, or 0.0 if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a double value
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.559 -0500", hash_original_method = "F5086ED2941BC7C3CB9930D22842FA44", hash_generated_method = "6B14D80610B6A994D1F454669DF16088")
    
public double getDouble(String key) {
        unparcel();
        return getDouble(key, 0.0);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a double value
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.561 -0500", hash_original_method = "172C416958EF64BBE0F98CDA39B416EB", hash_generated_method = "131757E610E53BD9778C8E13104DB84B")
    
public double getDouble(String key, double defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return defaultValue;
        }
        try {
            return (Double) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Double", defaultValue, e);
            return defaultValue;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a String value, or null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.563 -0500", hash_original_method = "51BC83F6E10D252B7C417A14343A53BE", hash_generated_method = "DC94B211C8F775E38F2099A496DDDDAB")
    
public String getString(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (String) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "String", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String, or null
     * @param defaultValue Value to return if key does not exist
     * @return a String value, or null
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.566 -0500", hash_original_method = "BC80281EBAB10986EFB226B5D89A6368", hash_generated_method = "17A1039E666A7650DA2AF0A5672C697D")
    
public String getString(String key, String defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return defaultValue;
        }
        try {
            return (String) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "String", e);
            return defaultValue;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a CharSequence value, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.568 -0500", hash_original_method = "4D51A99620432005EDE9794C44D49E24", hash_generated_method = "C749D871CDC137BBDCB4798223006DD3")
    
public CharSequence getCharSequence(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (CharSequence) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "CharSequence", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String, or null
     * @param defaultValue Value to return if key does not exist
     * @return a CharSequence value, or null
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.570 -0500", hash_original_method = "C5E593A01F019636F8A087C171F20745", hash_generated_method = "40CE78F334294202BE659BFDFA1F54A4")
    
public CharSequence getCharSequence(String key, CharSequence defaultValue) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return defaultValue;
        }
        try {
            return (CharSequence) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "CharSequence", e);
            return defaultValue;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a Bundle value, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.572 -0500", hash_original_method = "7BDB21170493B124DD321ED35C766BAB", hash_generated_method = "C59829BF8BA797DC02E79C321DAD4ECD")
    
public Bundle getBundle(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (Bundle) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Bundle", e);
            return null;
        }
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.589 -0400", hash_original_method = "3B646958426B4FA703D61CD64DB4127C", hash_generated_method = "572C7E2ACF1B7DC166C7E159C488DD53")
    public <T extends Parcelable> T getParcelable(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
T var540C13E9E156B687226421B24F2DF178_321169882 =             null;
            var540C13E9E156B687226421B24F2DF178_321169882.addTaint(getTaint());
            return var540C13E9E156B687226421B24F2DF178_321169882;
        } //End block
        try 
        {
T varDD72649790B0E769482C6AFD3C9BD666_938487632 =             (T) o;
            varDD72649790B0E769482C6AFD3C9BD666_938487632.addTaint(getTaint());
            return varDD72649790B0E769482C6AFD3C9BD666_938487632;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "Parcelable", e);
T var540C13E9E156B687226421B24F2DF178_1182490752 =             null;
            var540C13E9E156B687226421B24F2DF178_1182490752.addTaint(getTaint());
            return var540C13E9E156B687226421B24F2DF178_1182490752;
        } //End block
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

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a Parcelable[] value, or null
     */
    @DSComment("Data serialization/deserialization")
    @DSSafe(DSCat.SERIALIZATION)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.577 -0500", hash_original_method = "ACB5B2AD81C8600B2F6954C0DE15936B", hash_generated_method = "45FD4581CE7E9024FA7FADC100EE838C")
    
public Parcelable[] getParcelableArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (Parcelable[]) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Parcelable[]", e);
            return null;
        }
    }
    
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.604 -0400", hash_original_method = "4066E862ACF29CBEB786556AAFBFC58D", hash_generated_method = "000888949C0E1171C26D37E7DD90846A")
    public <T extends Parcelable> ArrayList<T> getParcelableArrayList(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
ArrayList<T> var540C13E9E156B687226421B24F2DF178_806477092 =             null;
            var540C13E9E156B687226421B24F2DF178_806477092.addTaint(getTaint());
            return var540C13E9E156B687226421B24F2DF178_806477092;
        } //End block
        try 
        {
ArrayList<T> var8C4736B669D2FF87EF2D545A6CBB1081_558148862 =             (ArrayList<T>) o;
            var8C4736B669D2FF87EF2D545A6CBB1081_558148862.addTaint(getTaint());
            return var8C4736B669D2FF87EF2D545A6CBB1081_558148862;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "ArrayList", e);
ArrayList<T> var540C13E9E156B687226421B24F2DF178_763858156 =             null;
            var540C13E9E156B687226421B24F2DF178_763858156.addTaint(getTaint());
            return var540C13E9E156B687226421B24F2DF178_763858156;
        } //End block
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
    
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-23 19:32:55.611 -0400", hash_original_method = "F3D4EB475C3465E3892E6091F83F5D92", hash_generated_method = "BCE849B03B3DED85ECE99E857AB69DEB")
    public <T extends Parcelable> SparseArray<T> getSparseParcelableArray(String key) {
        addTaint(key.getTaint());
        unparcel();
        Object o = mMap.get(key);
        if(o == null)        
        {
SparseArray<T> var540C13E9E156B687226421B24F2DF178_438871606 =             null;
            var540C13E9E156B687226421B24F2DF178_438871606.addTaint(getTaint());
            return var540C13E9E156B687226421B24F2DF178_438871606;
        } //End block
        try 
        {
SparseArray<T> varDF1763F4CB2B8A56FADAF6645F7D7547_1869242010 =             (SparseArray<T>) o;
            varDF1763F4CB2B8A56FADAF6645F7D7547_1869242010.addTaint(getTaint());
            return varDF1763F4CB2B8A56FADAF6645F7D7547_1869242010;
        } //End block
        catch (ClassCastException e)
        {
            typeWarning(key, o, "SparseArray", e);
SparseArray<T> var540C13E9E156B687226421B24F2DF178_1931449992 =             null;
            var540C13E9E156B687226421B24F2DF178_1931449992.addTaint(getTaint());
            return var540C13E9E156B687226421B24F2DF178_1931449992;
        } //End block
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

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a Serializable value, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.583 -0500", hash_original_method = "3E1FB271E8FDF7CD375ECA97D496DB8C", hash_generated_method = "B0217288359245D82FE428677F8F5FF2")
    
public Serializable getSerializable(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (Serializable) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Serializable", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return an ArrayList<String> value, or null
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.585 -0500", hash_original_method = "129B869D98875CE72FDC17E4CC2A1579", hash_generated_method = "4A0476877431153D04CBCEC5C6DA6A8B")
    
public ArrayList<Integer> getIntegerArrayList(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (ArrayList<Integer>) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "ArrayList<Integer>", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return an ArrayList<String> value, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.588 -0500", hash_original_method = "2869BDF5623DD5162F6A69DFD2D1F8AB", hash_generated_method = "A38B3BACEDB6F26ECC5AC23BAEDFF3E0")
    
public ArrayList<String> getStringArrayList(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (ArrayList<String>) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "ArrayList<String>", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return an ArrayList<CharSequence> value, or null
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.590 -0500", hash_original_method = "9A13BDFEA4BB8512D10DFA31FFDE883A", hash_generated_method = "23BAEC3568AD3BF79C3FA060C6272547")
    
public ArrayList<CharSequence> getCharSequenceArrayList(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (ArrayList<CharSequence>) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "ArrayList<CharSequence>", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a boolean[] value, or null
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.593 -0500", hash_original_method = "2242EDC01DC8898E91E207F436901294", hash_generated_method = "C4BC1E97D5F4531CF91DD4A2C1D48C93")
    
public boolean[] getBooleanArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (boolean[]) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "byte[]", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a byte[] value, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.595 -0500", hash_original_method = "61BA553FC99180BEC5D34878EFD2124D", hash_generated_method = "E14823F73517A05703F9457CFF4AF591")
    
public byte[] getByteArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (byte[]) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "byte[]", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a short[] value, or null
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.597 -0500", hash_original_method = "7BB50DA07B268F9685287E0D939131D4", hash_generated_method = "E67BE2F4F77612B930FFDC65AF7DB704")
    
public short[] getShortArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (short[]) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "short[]", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a char[] value, or null
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.600 -0500", hash_original_method = "E77DD9D06089068562F2943DA73C8461", hash_generated_method = "E77932C571C2A9C6D0161CA918963F21")
    
public char[] getCharArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (char[]) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "char[]", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return an int[] value, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.602 -0500", hash_original_method = "85622F3A5EF64119863AB7B7CCBF9703", hash_generated_method = "31EEEB18F7D9BB9C51649185024522F8")
    
public int[] getIntArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (int[]) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "int[]", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a long[] value, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.605 -0500", hash_original_method = "27B2CD54F5F69E8E74D59A821000C81A", hash_generated_method = "BE88D5C92732324A1681CD39A146DC06")
    
public long[] getLongArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (long[]) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "long[]", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a float[] value, or null
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.607 -0500", hash_original_method = "CF7D6838E0F23E6456879FF35A2AC714", hash_generated_method = "5F8D8A65D252D6C8AF09A7E22DB0F191")
    
public float[] getFloatArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (float[]) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "float[]", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a double[] value, or null
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.609 -0500", hash_original_method = "3231DDBB4D17868FEAA7FF4365CACCDA", hash_generated_method = "E83E31F4EFDA6E6B782F4ADCE29DB2C8")
    
public double[] getDoubleArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (double[]) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "double[]", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a String[] value, or null
     */
    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.612 -0500", hash_original_method = "00D6B9CB5DC261567748885D1CE89780", hash_generated_method = "A5D3472959DEE1DD04513F9A01144F61")
    
public String[] getStringArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (String[]) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "String[]", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a CharSequence[] value, or null
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.614 -0500", hash_original_method = "E55D822FE040164347A1371A3EEFE758", hash_generated_method = "7EB06F33C6319D9FE03593E24CDED0ED")
    
public CharSequence[] getCharSequenceArray(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (CharSequence[]) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "CharSequence[]", e);
            return null;
        }
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return an IBinder value, or null
     *
     * @deprecated
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.616 -0500", hash_original_method = "D295BFB1D3C25A7A56AF1D8267856D3B", hash_generated_method = "E7CA20643940928A7E9217CDBAEC3E7D")
    
@Deprecated
    public IBinder getIBinder(String key) {
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (IBinder) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "IBinder", e);
            return null;
        }
    }

    /**
     * Report the nature of this Parcelable's contents
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.626 -0500", hash_original_method = "E95F1FE0EF3EE3193ED648BBE2C98991", hash_generated_method = "4ECAF7C88D126E501DD7015D1C03A00B")
    
public int describeContents() {
        int mask = 0;
        if (hasFileDescriptors()) {
            mask |= Parcelable.CONTENTS_FILE_DESCRIPTOR;
        }
        return mask;
    }
    
    /**
     * Writes the Bundle contents to a Parcel, typically in order for
     * it to be passed through an IBinder connection.
     * @param parcel The parcel to copy this bundle to.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.628 -0500", hash_original_method = "90A94F467F11AD2B1AEECA4B5BC07A1D", hash_generated_method = "13FC4A3A2DEAA47DAD8328A7A3631F3B")
    
public void writeToParcel(Parcel parcel, int flags) {
        final boolean oldAllowFds = parcel.pushAllowFds(mAllowFds);
        try {
            if (mParcelledData != null) {
                int length = mParcelledData.dataSize();
                parcel.writeInt(length);
                parcel.writeInt(0x4C444E42); // 'B' 'N' 'D' 'L'
                parcel.appendFrom(mParcelledData, 0, length);
            } else {
                parcel.writeInt(-1); // dummy, will hold length
                parcel.writeInt(0x4C444E42); // 'B' 'N' 'D' 'L'
    
                int oldPos = parcel.dataPosition();
                parcel.writeMapInternal(mMap);
                int newPos = parcel.dataPosition();
    
                // Backpatch length
                parcel.setDataPosition(oldPos - 8);
                int length = newPos - oldPos;
                parcel.writeInt(length);
                parcel.setDataPosition(newPos);
            }
        } finally {
            parcel.restoreAllowFds(oldAllowFds);
        }
    }

    /**
     * Reads the Parcel contents into this Bundle, typically in order for
     * it to be passed through an IBinder connection.
     * @param parcel The parcel to overwrite this bundle from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.631 -0500", hash_original_method = "046D2D4D1B8612C0E98B2174C0C88DC5", hash_generated_method = "CCF966184DD966B4A8431E00C8E0C9B9")
    
public void readFromParcel(Parcel parcel) {
        int length = parcel.readInt();
        if (length < 0) {
            throw new RuntimeException("Bad length in parcel: " + length);
        }
        readFromParcelInner(parcel, length);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.633 -0500", hash_original_method = "BA7474E49C1BD74E29BF5B4706535141", hash_generated_method = "4626EAB7D7A0699ECA6C3A432923F19B")
    
void readFromParcelInner(Parcel parcel, int length) {
        int magic = parcel.readInt();
        if (magic != 0x4C444E42) {
            //noinspection ThrowableInstanceNeverThrown
            String st = Log.getStackTraceString(new RuntimeException());
            Log.e("Bundle", "readBundle: bad magic number");
            Log.e("Bundle", "readBundle: trace = " + st);
        }

        // Advance within this Parcel
        int offset = parcel.dataPosition();
        parcel.setDataPosition(offset + length);

        Parcel p = Parcel.obtain();
        p.setDataPosition(0);
        p.appendFrom(parcel, offset, length);
        p.setDataPosition(0);
        
        mParcelledData = p;
        mHasFds = p.hasFileDescriptors();
        mFdsKnown = true;
    }
    static {
        EMPTY = new Bundle();
        EMPTY.mMap = Collections.unmodifiableMap(new HashMap<String, Object>());
    }

    @DSComment("OS Bundle data structure")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:36.636 -0500", hash_original_method = "6D3D0FD7A771D9A5F3ECAE6DEB73615C", hash_generated_method = "0355024C495606547CD5BFBEF3CBEDE1")
    
@Override
    public synchronized String toString() {
        if (mParcelledData != null) {
            return "Bundle[mParcelledData.dataSize=" +
                    mParcelledData.dataSize() + "]";
        }
        return "Bundle[" + mMap.toString() + "]";
    }
}

