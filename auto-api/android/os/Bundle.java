package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String LOG_TAG = "Bundle";
    public static final Bundle EMPTY;
    Map<String, Object> mMap = null;
    Parcel mParcelledData = null;
    private boolean mHasFds = false;
    private boolean mFdsKnown = true;
    private boolean mAllowFds = true;
    private ClassLoader mClassLoader;
    public static final Parcelable.Creator<Bundle> CREATOR = new Parcelable.Creator<Bundle>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.561 -0400", hash_original_method = "4187614240FC5282A7CB86A3FCAECB06", hash_generated_method = "0768CED48C728202B25EC8A7B25AEF97")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Bundle createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            Bundle var4397E85376BF5EF6C8D33C3D50A4F9DE_232784836 = (in.readBundle());
            return (Bundle)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return in.readBundle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.561 -0400", hash_original_method = "5E82917C5DD51CF815A5AE0167A86BCD", hash_generated_method = "1BDEAB711F72E4B50E426B045F6BD462")
        @DSModeled(DSC.SAFE)
        public Bundle[] newArray(int size) {
            dsTaint.addTaint(size);
            return (Bundle[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Bundle[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.561 -0400", hash_original_method = "40BE022BD5AEEE3B1F4C24A599FDBBB4", hash_generated_method = "C0E94FBB6C7C14A098F1A9CF59DF5EE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle() {
        mMap = new HashMap<String, Object>();
        mClassLoader = getClass().getClassLoader();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>();
        //mClassLoader = getClass().getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.561 -0400", hash_original_method = "DB07395F523937B25016D60988A66D69", hash_generated_method = "869C0A784A580626F71FBB3CA48E22FD")
    @DSModeled(DSC.SAFE)
     Bundle(Parcel parcelledData) {
        dsTaint.addTaint(parcelledData.dsTaint);
        readFromParcel(parcelledData);
        // ---------- Original Method ----------
        //readFromParcel(parcelledData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.561 -0400", hash_original_method = "4CBA8A75160127E76B9D77B8452C524A", hash_generated_method = "ADDF5008F683CC5848D00B4F9F4A5620")
    @DSModeled(DSC.SAFE)
     Bundle(Parcel parcelledData, int length) {
        dsTaint.addTaint(parcelledData.dsTaint);
        dsTaint.addTaint(length);
        readFromParcelInner(parcelledData, length);
        // ---------- Original Method ----------
        //readFromParcelInner(parcelledData, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.561 -0400", hash_original_method = "ED19BD28A9BE16566DAB3F7BC8440A20", hash_generated_method = "0077EE70527BE683387D23498159C0ED")
    @DSModeled(DSC.BAN)
    public Bundle(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        mMap = new HashMap<String, Object>();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>();
        //mClassLoader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.562 -0400", hash_original_method = "1CEDEB07DCD1E2A2BE2C52C76F89017C", hash_generated_method = "C55734C1BF2AD7FC0DD016B5B712C0DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle(int capacity) {
        dsTaint.addTaint(capacity);
        mMap = new HashMap<String, Object>(capacity);
        mClassLoader = getClass().getClassLoader();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>(capacity);
        //mClassLoader = getClass().getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.562 -0400", hash_original_method = "418D42BD4A8F16B387F3064B9218EE53", hash_generated_method = "97375EA1DEB2F4D45D19A25887802B4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle(Bundle b) {
        dsTaint.addTaint(b.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.562 -0400", hash_original_method = "7228E76FDB53607D003E8E811CE36961", hash_generated_method = "8E1D3D0B424BE96BCAAFF48C81128AE7")
    public static Bundle forPair(String key, String value) {
        Bundle b = new Bundle(1);
        b.putString(key, value);
        return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.562 -0400", hash_original_method = "B3609B2F52C0BA6BE21E26730F76FD99", hash_generated_method = "F252D93DD5846CFD927AEADAAD712CBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPairValue() {
        unparcel();
        int size;
        size = mMap.size();
        Object o;
        o = mMap.values().iterator().next();
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.562 -0400", hash_original_method = "98C9A117007F79899B5BBD029ABFD6B8", hash_generated_method = "C953A4ED0CA71338E266C3743DFD9FC4")
    @DSModeled(DSC.BAN)
    public void setClassLoader(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        // ---------- Original Method ----------
        //mClassLoader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.562 -0400", hash_original_method = "DF35DB07DA97BBA7096331B39E871560", hash_generated_method = "B6A32A5AFCF6DDC812895931E7FCBB9E")
    @DSModeled(DSC.BAN)
    public ClassLoader getClassLoader() {
        return (ClassLoader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mClassLoader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.562 -0400", hash_original_method = "3A854A40DC72470BF5CA49CF20D41873", hash_generated_method = "937F99F05B4620A3BBFDC1414A31B91B")
    @DSModeled(DSC.SAFE)
    public boolean setAllowFds(boolean allowFds) {
        dsTaint.addTaint(allowFds);
        boolean orig;
        orig = mAllowFds;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean orig = mAllowFds;
        //mAllowFds = allowFds;
        //return orig;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.563 -0400", hash_original_method = "8ED269C57B5B4F834AF78EEAE05F20CC", hash_generated_method = "86F68F9ECD025E20CF16FED07C8342D9")
    @DSModeled(DSC.SAFE)
    @Override
    public Object clone() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Bundle(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.563 -0400", hash_original_method = "C84307F15A2AB40D2A9CA51D74C5FD0F", hash_generated_method = "FEB0FA33A7CBC29124F7B18C667DE166")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.563 -0400", hash_original_method = "89E974D778C485ED4A98439CDF5961E3", hash_generated_method = "0EDD34D5ECBFBD75B4AFF24C1315F24D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        unparcel();
        int varEB72A5C76BB8A5CD8667491C4358251D_1979280663 = (mMap.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.563 -0400", hash_original_method = "8B93AFDE665AAAFE98B5EE9FD5355D4B", hash_generated_method = "F205796A13A0C967E15D0361C4E197A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        unparcel();
        boolean varCFBB58DB314314B44F78CC84300FBF36_310185445 = (mMap.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.563 -0400", hash_original_method = "9DC77B5F54151FE5CD815F7C8172B2ED", hash_generated_method = "2E15E6F5820756C786319A22240C54FB")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.563 -0400", hash_original_method = "F5C0B952F7E6EDB282A82D73FA397DBD", hash_generated_method = "11A76D5109E20DAF8CFBF294728FB6CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(String key) {
        dsTaint.addTaint(key);
        unparcel();
        boolean var3CCD836522265B0EF3CEF15E617425E2_523253363 = (mMap.containsKey(key));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.563 -0400", hash_original_method = "E6C9158A697ED4C4296ED4A1595BA584", hash_generated_method = "F8F20D520F2BB049C3430C911EC01D05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object get(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object var5945DA3B76AA78BDB4B683EF495397E0_1476391955 = (mMap.get(key));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.563 -0400", hash_original_method = "717A16AB4D98DDB60DEBCEA5CDF9B0B2", hash_generated_method = "463321B86002F747BF2431B9D93EF8BB")
    @DSModeled(DSC.SAFE)
    public void remove(String key) {
        dsTaint.addTaint(key);
        unparcel();
        mMap.remove(key);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.564 -0400", hash_original_method = "F30E47B42E381C2413B1100E1A47D1F8", hash_generated_method = "864A648876F53249F80E714F380D5853")
    @DSModeled(DSC.SAFE)
    public void putAll(Bundle map) {
        dsTaint.addTaint(map.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.564 -0400", hash_original_method = "00E2D8861948F8DB601BFD39768039D0", hash_generated_method = "0ADD9A050F9187A3176DF3BECD8F17B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> keySet() {
        unparcel();
        Set<String> var0BA4B7494E8E3D94A97071297FB3AA79_1856678903 = (mMap.keySet());
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //unparcel();
        //return mMap.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.564 -0400", hash_original_method = "4B0480B2866CB29DA37F7AEC68A5E217", hash_generated_method = "D4268E79E468BBE326A5A621894C4B10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasFileDescriptors() {
        {
            boolean fdFound;
            fdFound = false;
            {
                {
                    boolean varE7E90B5396C9FB1A90488751D202C0DE_835669043 = (mParcelledData.hasFileDescriptors());
                    {
                        fdFound = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                Iterator<Map.Entry<String, Object>> iter;
                iter = mMap.entrySet().iterator();
                {
                    boolean var3C9C2559EA47B4922E81E22A4D970516_1713750645 = (!fdFound && iter.hasNext());
                    {
                        Object obj;
                        obj = iter.next().getValue();
                        {
                            {
                                boolean var3B3CD3B239B9599F818BBBB4D19F1B2A_503256329 = ((((Parcelable)obj).describeContents()
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
                                        boolean var33811AA2303D21D7631EEBA0E4C5547F_844915538 = ((array[n].describeContents()
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
                                        boolean var70216DAA8A60B74EE111A55FCE3E036D_449169546 = ((array.get(n).describeContents()
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
                                boolean var01F44C1854281F36799A73E27E5377CB_1710158531 = ((array.size() > 0)
                                && (array.get(0) instanceof Parcelable));
                                {
                                    {
                                        int n;
                                        n = array.size() - 1;
                                        {
                                            Parcelable p;
                                            p = (Parcelable) array.get(n);
                                            {
                                                boolean varB72014908EB71D72428783AAB42D64BD_1360423740 = (p != null && ((p.describeContents()
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.565 -0400", hash_original_method = "94490DFEC498722DA435B9597CF0EDDE", hash_generated_method = "BE2B646EC4A676318FFF75172B636500")
    @DSModeled(DSC.SAFE)
    public void putBoolean(String key, boolean value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.565 -0400", hash_original_method = "60D945D31D7D04981E268C4CC855B009", hash_generated_method = "2F9C295A742157742BDC28E3D94D91C2")
    @DSModeled(DSC.SAFE)
    public void putByte(String key, byte value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.565 -0400", hash_original_method = "C6C3CAC58AEE8EB92E7D233D1233B510", hash_generated_method = "F25CE371827675A65EB1840D317F9644")
    @DSModeled(DSC.SAFE)
    public void putChar(String key, char value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.565 -0400", hash_original_method = "48338BC49C4A94D5C3F73368CEF11822", hash_generated_method = "069F31BCEF062EA4C8D0C8116B439221")
    @DSModeled(DSC.SAFE)
    public void putShort(String key, short value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.565 -0400", hash_original_method = "C2DD503B984E96C46288CB6F7C364E09", hash_generated_method = "436DDCBE5ED7C5D6343FE4495513AF25")
    @DSModeled(DSC.SAFE)
    public void putInt(String key, int value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.565 -0400", hash_original_method = "32D4E331D0F655A9205640C19ABF2B58", hash_generated_method = "9F2CD7199B429AB5893678C796694D30")
    @DSModeled(DSC.SAFE)
    public void putLong(String key, long value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.565 -0400", hash_original_method = "292C24CEC676EE3F6A373A1AE7371B82", hash_generated_method = "429727356CE546BA64D23FDCC4CBC2EC")
    @DSModeled(DSC.SAFE)
    public void putFloat(String key, float value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.565 -0400", hash_original_method = "1F6C5CEB9374270482ED4835594D6EF1", hash_generated_method = "43894A3C4C33C683F3436882434957D2")
    @DSModeled(DSC.SAFE)
    public void putDouble(String key, double value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.565 -0400", hash_original_method = "E7336EB9055C9F862A0B8D336BB5AE0F", hash_generated_method = "66AB3D55DECFB764F923BD5F036BE4A7")
    @DSModeled(DSC.SAFE)
    public void putString(String key, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.566 -0400", hash_original_method = "23A8E01E039C76712F2C134222EAC45B", hash_generated_method = "627970C74B7B3848BB887C3C500CFB5A")
    @DSModeled(DSC.SAFE)
    public void putCharSequence(String key, CharSequence value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.566 -0400", hash_original_method = "F17082A305780CE778B93F20A20D0318", hash_generated_method = "D11136362F76B8CD6868B3F673E8B8B1")
    @DSModeled(DSC.SAFE)
    public void putParcelable(String key, Parcelable value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
        //mFdsKnown = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.566 -0400", hash_original_method = "1666E21FDEAC3D0C57D8E38C022A7AD2", hash_generated_method = "44E2B3788015ED051124DCC895CF8A67")
    @DSModeled(DSC.SAFE)
    public void putParcelableArray(String key, Parcelable[] value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
        //mFdsKnown = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.566 -0400", hash_original_method = "C07428EAC6D62CA3DF6F67489B512A7E", hash_generated_method = "FFD3781ADE1AC4A092B38F0075D7A1F1")
    @DSModeled(DSC.SAFE)
    public void putParcelableArrayList(String key,
        ArrayList<? extends Parcelable> value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
        //mFdsKnown = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.566 -0400", hash_original_method = "93FD4CBDA1682EAF0E9F2535BF397F65", hash_generated_method = "DD28B4049AF01E49D3D2383E22FDBDA2")
    @DSModeled(DSC.SAFE)
    public void putSparseParcelableArray(String key,
            SparseArray<? extends Parcelable> value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
        //mFdsKnown = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.566 -0400", hash_original_method = "6C90B1571D2A36769CB59FB958C842F7", hash_generated_method = "62107AE5C84B98176451B2267EE4DEE7")
    @DSModeled(DSC.SAFE)
    public void putIntegerArrayList(String key, ArrayList<Integer> value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.566 -0400", hash_original_method = "ABD9DF23A5A8A0A83F11C474E2CAFB17", hash_generated_method = "6E90D7B0B28D2E5A3B47A230C3C5A221")
    @DSModeled(DSC.SAFE)
    public void putStringArrayList(String key, ArrayList<String> value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.566 -0400", hash_original_method = "C0F2E9DF48888A828D6640DBBB8ADDE5", hash_generated_method = "2211A1044186215235FEDD647A79DCAC")
    @DSModeled(DSC.SAFE)
    public void putCharSequenceArrayList(String key, ArrayList<CharSequence> value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.567 -0400", hash_original_method = "C647C81034119067E2383CA02CF65D5F", hash_generated_method = "14281DF9875FB343881479F557E8C4C3")
    @DSModeled(DSC.SAFE)
    public void putSerializable(String key, Serializable value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.567 -0400", hash_original_method = "8E721A4E4DD3EA40820BFACA50BE3D1C", hash_generated_method = "9FE95E8F46C8012AE0433598F1DFC864")
    @DSModeled(DSC.SAFE)
    public void putBooleanArray(String key, boolean[] value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.567 -0400", hash_original_method = "1C56E40FECAB1AC7C31C1D64DCBF74F0", hash_generated_method = "64995F76E272D118A3BE22A56E2D804C")
    @DSModeled(DSC.SAFE)
    public void putByteArray(String key, byte[] value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.567 -0400", hash_original_method = "2FF709A9E88600F14AEB34FA372FB7A3", hash_generated_method = "8D6440578A2AF63F9DFCE384D1D30B62")
    @DSModeled(DSC.SAFE)
    public void putShortArray(String key, short[] value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.567 -0400", hash_original_method = "5BBE3077A529F887080D848A31F1E40F", hash_generated_method = "97427560E79CEBA9D7D79422D3E3FDA7")
    @DSModeled(DSC.SAFE)
    public void putCharArray(String key, char[] value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.567 -0400", hash_original_method = "6E03156089AB80D54004D251F8CBA9A8", hash_generated_method = "D6CA8060562C59EC015E9F398EA6753B")
    @DSModeled(DSC.SAFE)
    public void putIntArray(String key, int[] value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.567 -0400", hash_original_method = "749D6A41C446C63F668941511653896B", hash_generated_method = "1325653A598BB8596BA8E23F3517483D")
    @DSModeled(DSC.SAFE)
    public void putLongArray(String key, long[] value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.567 -0400", hash_original_method = "6C49285A06086C4B176330EBC83C2D3B", hash_generated_method = "66FFA3C022A3CB98A5D24E2FA1192A4C")
    @DSModeled(DSC.SAFE)
    public void putFloatArray(String key, float[] value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.567 -0400", hash_original_method = "BF0DED73B6BC272CA81A76D665AF3892", hash_generated_method = "1349AFAC1745B2245BE312BBA26CDFFF")
    @DSModeled(DSC.SAFE)
    public void putDoubleArray(String key, double[] value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.568 -0400", hash_original_method = "3F318C6E0F37B53192FF4A33987FF921", hash_generated_method = "621FA8EE83714C35C5C461C4A1ADBB80")
    @DSModeled(DSC.SAFE)
    public void putStringArray(String key, String[] value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.568 -0400", hash_original_method = "D442CACA5F4C37E249E32A5FC3EA1B00", hash_generated_method = "C15764C98947D598DC4D827F81004F31")
    @DSModeled(DSC.SAFE)
    public void putCharSequenceArray(String key, CharSequence[] value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.568 -0400", hash_original_method = "8FC0D5E8787A84A268AF6F8743FC18A2", hash_generated_method = "23A6D4E5553102F4C51249C652BA920D")
    @DSModeled(DSC.SAFE)
    public void putBundle(String key, Bundle value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.568 -0400", hash_original_method = "0DA9D5A0C7EE7D2AFD4BCC53AD3802F3", hash_generated_method = "DA254A60272E0556816568C7674F90D4")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void putIBinder(String key, IBinder value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        unparcel();
        mMap.put(key, value);
        // ---------- Original Method ----------
        //unparcel();
        //mMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.568 -0400", hash_original_method = "44491868325766EC5AED04910C3A4D05", hash_generated_method = "A5393CD7C8B60DF478AD01AE3EC191C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoolean(String key) {
        dsTaint.addTaint(key);
        unparcel();
        boolean var4C9107722E78C3479502DC8113A34442_251386246 = (getBoolean(key, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //unparcel();
        //return getBoolean(key, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.568 -0400", hash_original_method = "017EA18B11E7843C44A73EB9482CE841", hash_generated_method = "4255FAC06D53C9C51DEAFBB1E977FF2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void typeWarning(String key, Object value, String className,
        Object defaultValue, ClassCastException e) {
        dsTaint.addTaint(e.dsTaint);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(className);
        dsTaint.addTaint(defaultValue.dsTaint);
        dsTaint.addTaint(key);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.568 -0400", hash_original_method = "AA5C4C6D2863DB47E466486DB4471393", hash_generated_method = "9FBF1AC5BE37DFCC121F8D01A938EFBF")
    @DSModeled(DSC.SAFE)
    private void typeWarning(String key, Object value, String className,
        ClassCastException e) {
        dsTaint.addTaint(e.dsTaint);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(className);
        dsTaint.addTaint(key);
        typeWarning(key, value, className, "<null>", e);
        // ---------- Original Method ----------
        //typeWarning(key, value, className, "<null>", e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.569 -0400", hash_original_method = "62E0EA051DB8CF7BEF8CA2ACB88171F1", hash_generated_method = "E3C01F4D672C8692F0F2CEF7A58A6068")
    @DSModeled(DSC.SAFE)
    public boolean getBoolean(String key, boolean defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.569 -0400", hash_original_method = "E9711B4A318F78DD358F0F07FAB02724", hash_generated_method = "726C0E46BF501383186C5DA4F5530283")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte getByte(String key) {
        dsTaint.addTaint(key);
        unparcel();
        byte varF5DF8FD13401C680C4079E46D48E559E_1477770230 = (getByte(key, (byte) 0));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //unparcel();
        //return getByte(key, (byte) 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.569 -0400", hash_original_method = "44660F005C21F1E59A8F3EDCC4F5A0ED", hash_generated_method = "8482A72E7A6AAFA071FE63A592ABD906")
    @DSModeled(DSC.SAFE)
    public Byte getByte(String key, byte defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return (Byte)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.569 -0400", hash_original_method = "82E77139364787BB6587747BA780C45B", hash_generated_method = "3E9F1AF04EDA2407C35CC71D5DF0D8EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getChar(String key) {
        dsTaint.addTaint(key);
        unparcel();
        char var27F1A2D2AC9426CDE46A1342145F88A3_1785996887 = (getChar(key, (char) 0));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //unparcel();
        //return getChar(key, (char) 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.569 -0400", hash_original_method = "1B86701C5E776F178851B3C57F1F092F", hash_generated_method = "37D18FBB529A8DEBDB93A6F54D2562F7")
    @DSModeled(DSC.SAFE)
    public char getChar(String key, char defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return dsTaint.getTaintChar();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.569 -0400", hash_original_method = "949AF94B781EE8B084883F15F1BA2BF2", hash_generated_method = "CD5B54645589EA08F899A18219D06B34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short getShort(String key) {
        dsTaint.addTaint(key);
        unparcel();
        short varC3D9771DE8675C9D280694DECEDD0AFB_1844353053 = (getShort(key, (short) 0));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //unparcel();
        //return getShort(key, (short) 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.569 -0400", hash_original_method = "CB97516320C4B19AFFFFC9855DAD2391", hash_generated_method = "4A6ED744CC3CA94B220973CE0DFBA899")
    @DSModeled(DSC.SAFE)
    public short getShort(String key, short defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return dsTaint.getTaintShort();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.569 -0400", hash_original_method = "E147114FE6EABC6FAB98EAC3907FD421", hash_generated_method = "74B746EDC1023F78E99A94206F1A805C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(String key) {
        dsTaint.addTaint(key);
        unparcel();
        int var8CD2947803356231BBC241492425AC77_1017212082 = (getInt(key, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //unparcel();
        //return getInt(key, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.570 -0400", hash_original_method = "83073F806AC00C1E2EC4E710A5472BFA", hash_generated_method = "9D1EF2D618CF667D5C94400595EBF247")
    @DSModeled(DSC.SAFE)
    public int getInt(String key, int defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.570 -0400", hash_original_method = "0CFFDE7713416A17E206C69E138AC0FF", hash_generated_method = "204ED2A4A91B19FF62080CB11D5D474D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(String key) {
        dsTaint.addTaint(key);
        unparcel();
        long var979CD6852D7A16006D946D82F7EF4D0A_326301701 = (getLong(key, 0L));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //unparcel();
        //return getLong(key, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.570 -0400", hash_original_method = "84BBB1371E3F4460B78F31822950EAAA", hash_generated_method = "E941F24B53134E03AF2BA339D345CEF6")
    @DSModeled(DSC.SAFE)
    public long getLong(String key, long defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.570 -0400", hash_original_method = "0D69D7EB25C8E886B27D28B7A30E217C", hash_generated_method = "9D94E7B29AE8C14FB40C941E168D182E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloat(String key) {
        dsTaint.addTaint(key);
        unparcel();
        float var1F2989949A680EEB88317D0F20C8813F_1207127564 = (getFloat(key, 0.0f));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //unparcel();
        //return getFloat(key, 0.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.570 -0400", hash_original_method = "8162EC4F2AE30557D489C5C6263EB256", hash_generated_method = "BD387CE574969CB907D19577E707EA9B")
    @DSModeled(DSC.SAFE)
    public float getFloat(String key, float defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return dsTaint.getTaintFloat();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.570 -0400", hash_original_method = "F5086ED2941BC7C3CB9930D22842FA44", hash_generated_method = "7F38C76F5ED95A50A4248C8E59C25019")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDouble(String key) {
        dsTaint.addTaint(key);
        unparcel();
        double varAF1883587E9789F106C3A6801CFE65B3_1633560604 = (getDouble(key, 0.0));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //unparcel();
        //return getDouble(key, 0.0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.570 -0400", hash_original_method = "172C416958EF64BBE0F98CDA39B416EB", hash_generated_method = "6013716ACCCCE417A8CC1DE8B1C719B8")
    @DSModeled(DSC.SAFE)
    public double getDouble(String key, double defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return dsTaint.getTaintDouble();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.571 -0400", hash_original_method = "51BC83F6E10D252B7C417A14343A53BE", hash_generated_method = "F97D33D7BAC4F2E5E97D7650B0A6FCD7")
    @DSModeled(DSC.SAFE)
    public String getString(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.571 -0400", hash_original_method = "BC80281EBAB10986EFB226B5D89A6368", hash_generated_method = "F135C5BDCF2C07A27DA7F447B0E99758")
    @DSModeled(DSC.SAFE)
    public String getString(String key, String defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.571 -0400", hash_original_method = "4D51A99620432005EDE9794C44D49E24", hash_generated_method = "A13F064E13B1FF56980221DCFCA3C846")
    @DSModeled(DSC.SAFE)
    public CharSequence getCharSequence(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.571 -0400", hash_original_method = "C5E593A01F019636F8A087C171F20745", hash_generated_method = "271F562124EB7E76136A33C636826C51")
    @DSModeled(DSC.SAFE)
    public CharSequence getCharSequence(String key, CharSequence defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.571 -0400", hash_original_method = "7BDB21170493B124DD321ED35C766BAB", hash_generated_method = "C08C398804B5BF4FCC30E724E10E3619")
    @DSModeled(DSC.SAFE)
    public Bundle getBundle(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return (Bundle)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.571 -0400", hash_original_method = "3B646958426B4FA703D61CD64DB4127C", hash_generated_method = "83DDE4C1BFAE4C753AC58F719676E83E")
    @DSModeled(DSC.SAFE)
    public <T extends Parcelable> T getParcelable(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return (T)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.572 -0400", hash_original_method = "ACB5B2AD81C8600B2F6954C0DE15936B", hash_generated_method = "01768E726ACADFEF25858B1C909CB7B9")
    @DSModeled(DSC.SAFE)
    public Parcelable[] getParcelableArray(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return (Parcelable[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.572 -0400", hash_original_method = "4066E862ACF29CBEB786556AAFBFC58D", hash_generated_method = "5FBEADFDD87BAEAB05663B617A5B9E3D")
    @DSModeled(DSC.SAFE)
    public <T extends Parcelable> ArrayList<T> getParcelableArrayList(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return (ArrayList<T>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.572 -0400", hash_original_method = "F3D4EB475C3465E3892E6091F83F5D92", hash_generated_method = "26428AE71B78E9C84EA08D9A55ACA3C3")
    @DSModeled(DSC.SAFE)
    public <T extends Parcelable> SparseArray<T> getSparseParcelableArray(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return (SparseArray<T>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.572 -0400", hash_original_method = "3E1FB271E8FDF7CD375ECA97D496DB8C", hash_generated_method = "08197720377227751BC648D91D495FD2")
    @DSModeled(DSC.SAFE)
    public Serializable getSerializable(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return (Serializable)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.572 -0400", hash_original_method = "129B869D98875CE72FDC17E4CC2A1579", hash_generated_method = "25814028C0667E4597D5A6990F9B43A9")
    @DSModeled(DSC.SAFE)
    public ArrayList<Integer> getIntegerArrayList(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return (ArrayList<Integer>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.572 -0400", hash_original_method = "2869BDF5623DD5162F6A69DFD2D1F8AB", hash_generated_method = "18D469837675CF77BF291E86C05245C3")
    @DSModeled(DSC.SAFE)
    public ArrayList<String> getStringArrayList(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return (ArrayList<String>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.572 -0400", hash_original_method = "9A13BDFEA4BB8512D10DFA31FFDE883A", hash_generated_method = "DDAD94F244D7DA0F102C375630386470")
    @DSModeled(DSC.SAFE)
    public ArrayList<CharSequence> getCharSequenceArrayList(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return (ArrayList<CharSequence>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.573 -0400", hash_original_method = "2242EDC01DC8898E91E207F436901294", hash_generated_method = "DDEF496B0E1B8DA5433FD41B7C816F7E")
    @DSModeled(DSC.SAFE)
    public boolean[] getBooleanArray(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.573 -0400", hash_original_method = "61BA553FC99180BEC5D34878EFD2124D", hash_generated_method = "61A3F118A67EA0E43A5ABB56FBAB0507")
    @DSModeled(DSC.SAFE)
    public byte[] getByteArray(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.573 -0400", hash_original_method = "7BB50DA07B268F9685287E0D939131D4", hash_generated_method = "54F2875F7BE4657463F81D95A0DA77D4")
    @DSModeled(DSC.SAFE)
    public short[] getShortArray(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        short[] retVal = new short[1];
        retVal[0] = (short)dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.573 -0400", hash_original_method = "E77DD9D06089068562F2943DA73C8461", hash_generated_method = "B4B0D428ADDCD5ECA7B881A0D9A7E448")
    @DSModeled(DSC.SAFE)
    public char[] getCharArray(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.573 -0400", hash_original_method = "85622F3A5EF64119863AB7B7CCBF9703", hash_generated_method = "C528B379CE9E29FB9A48CF27987E6957")
    @DSModeled(DSC.SAFE)
    public int[] getIntArray(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.573 -0400", hash_original_method = "27B2CD54F5F69E8E74D59A821000C81A", hash_generated_method = "F71F826C31BB694F7FAA76CAFEA24123")
    @DSModeled(DSC.SAFE)
    public long[] getLongArray(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        long[] retVal = new long[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.573 -0400", hash_original_method = "CF7D6838E0F23E6456879FF35A2AC714", hash_generated_method = "066DE3CC23D4C112B9E3876224D99B49")
    @DSModeled(DSC.SAFE)
    public float[] getFloatArray(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        float[] retVal = new float[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.574 -0400", hash_original_method = "3231DDBB4D17868FEAA7FF4365CACCDA", hash_generated_method = "576CC4CEAD956401DCB1E4B461B3399B")
    @DSModeled(DSC.SAFE)
    public double[] getDoubleArray(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        double[] retVal = new double[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.574 -0400", hash_original_method = "00D6B9CB5DC261567748885D1CE89780", hash_generated_method = "0A00022256A3FF8087FEF83232B846E9")
    @DSModeled(DSC.SAFE)
    public String[] getStringArray(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.574 -0400", hash_original_method = "E55D822FE040164347A1371A3EEFE758", hash_generated_method = "130C807A4FA80234D713FBF9D3530DDE")
    @DSModeled(DSC.SAFE)
    public CharSequence[] getCharSequenceArray(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        CharSequence[] retVal = new CharSequence[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.574 -0400", hash_original_method = "D295BFB1D3C25A7A56AF1D8267856D3B", hash_generated_method = "52271AE241B886F1B5AD8DE24015AE78")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public IBinder getIBinder(String key) {
        dsTaint.addTaint(key);
        unparcel();
        Object o;
        o = mMap.get(key);
        return (IBinder)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.574 -0400", hash_original_method = "E95F1FE0EF3EE3193ED648BBE2C98991", hash_generated_method = "93D9E164B811F2A340FCE61269C0DA37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int describeContents() {
        int mask;
        mask = 0;
        {
            boolean varADA79EE0A477F90AF032C4198B610819_2115688412 = (hasFileDescriptors());
            {
                mask |= Parcelable.CONTENTS_FILE_DESCRIPTOR;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int mask = 0;
        //if (hasFileDescriptors()) {
            //mask |= Parcelable.CONTENTS_FILE_DESCRIPTOR;
        //}
        //return mask;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.574 -0400", hash_original_method = "90A94F467F11AD2B1AEECA4B5BC07A1D", hash_generated_method = "B5AA6FD37B711A81AC00135C7CB640DD")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
        final boolean oldAllowFds;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.575 -0400", hash_original_method = "046D2D4D1B8612C0E98B2174C0C88DC5", hash_generated_method = "F300E4AED9CF7772732CB1EF766C21D6")
    @DSModeled(DSC.SAFE)
    public void readFromParcel(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
        int length;
        length = parcel.readInt();
        {
            throw new RuntimeException("Bad length in parcel: " + length);
        } //End block
        readFromParcelInner(parcel, length);
        // ---------- Original Method ----------
        //int length = parcel.readInt();
        //if (length < 0) {
            //throw new RuntimeException("Bad length in parcel: " + length);
        //}
        //readFromParcelInner(parcel, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.575 -0400", hash_original_method = "BA7474E49C1BD74E29BF5B4706535141", hash_generated_method = "3035277B33B665A3FB5B6578822E9E24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void readFromParcelInner(Parcel parcel, int length) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.575 -0400", hash_original_method = "6D3D0FD7A771D9A5F3ECAE6DEB73615C", hash_generated_method = "BB9EAE14ED2A37B2C4138565CEC5B833")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized String toString() {
        {
            String var135AC5C3809206ECA6AF5C5556CFCC0C_1915897532 = ("Bundle[mParcelledData.dataSize=" +
                    mParcelledData.dataSize() + "]");
        } //End block
        String var5ABBDBE14396690E197468A770A91D30_2076242833 = ("Bundle[" + mMap.toString() + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mParcelledData != null) {
            //return "Bundle[mParcelledData.dataSize=" +
                    //mParcelledData.dataSize() + "]";
        //}
        //return "Bundle[" + mMap.toString() + "]";
    }

    
    static {
        EMPTY = new Bundle();
        EMPTY.mMap = Collections.unmodifiableMap(new HashMap<String, Object>());
    }
    
}


