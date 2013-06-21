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
    Map<String, Object> mMap = null;
    Parcel mParcelledData = null;
    private boolean mHasFds = false;
    private boolean mFdsKnown = true;
    private boolean mAllowFds = true;
    private ClassLoader mClassLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.957 -0400", hash_original_method = "40BE022BD5AEEE3B1F4C24A599FDBBB4", hash_generated_method = "D0B412F9D9C998F60A5827E098F54A80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle() {
        mMap = new HashMap<String, Object>();
        mClassLoader = getClass().getClassLoader();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>();
        //mClassLoader = getClass().getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.958 -0400", hash_original_method = "DB07395F523937B25016D60988A66D69", hash_generated_method = "12DD4DB4F44B1ACC51BE4D395BB5B55F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Bundle(Parcel parcelledData) {
        dsTaint.addTaint(parcelledData.dsTaint);
        readFromParcel(parcelledData);
        // ---------- Original Method ----------
        //readFromParcel(parcelledData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.959 -0400", hash_original_method = "4CBA8A75160127E76B9D77B8452C524A", hash_generated_method = "91B4CBE2C8FD3DC388FA6A405E5D3F6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Bundle(Parcel parcelledData, int length) {
        dsTaint.addTaint(parcelledData.dsTaint);
        dsTaint.addTaint(length);
        readFromParcelInner(parcelledData, length);
        // ---------- Original Method ----------
        //readFromParcelInner(parcelledData, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.961 -0400", hash_original_method = "ED19BD28A9BE16566DAB3F7BC8440A20", hash_generated_method = "2A3BC7D2796F92F69637AEF67061EDE4")
    @DSModeled(DSC.BAN)
    public Bundle(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        mMap = new HashMap<String, Object>();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>();
        //mClassLoader = loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.963 -0400", hash_original_method = "1CEDEB07DCD1E2A2BE2C52C76F89017C", hash_generated_method = "CD3E93741435EBF9034D3BDE42493C8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bundle(int capacity) {
        dsTaint.addTaint(capacity);
        mMap = new HashMap<String, Object>(capacity);
        mClassLoader = getClass().getClassLoader();
        // ---------- Original Method ----------
        //mMap = new HashMap<String, Object>(capacity);
        //mClassLoader = getClass().getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:01.965 -0400", hash_original_method = "418D42BD4A8F16B387F3064B9218EE53", hash_generated_method = "4CDA59540563FAB688E0FE76F696825B")
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

    
    public static Bundle forPair(String key, String value){
		Bundle b = new Bundle(1);
        b.putString(key, value);
        return b;
		// Original method
		/*
		{
        Bundle b = new Bundle(1);
        b.putString(key, value);
        return b;
    }
		*/
	}

    
    public String getPairValue(){
		return dsTaint.getTaintString();
		// Original method
		/*
		{
        unparcel();
        int size = mMap.size();
        if (size > 1) {
            Log.w(LOG_TAG, "getPairValue() used on Bundle with multiple pairs.");
        }
        if (size == 0) {
            return null;
        }
        Object o = mMap.values().iterator().next();
        try {
            return (String) o;
        } catch (ClassCastException e) {
            typeWarning("getPairValue()", o, "String", e);
            return null;
        }
    }
		*/
	}

    
    public void setClassLoader(ClassLoader loader){
		mClassLoader = loader;  //Preserved
		// Original method
		/*
		{
        mClassLoader = loader;
    }
		*/
		//Return nothing
	}

    
    public ClassLoader getClassLoader(){
		return mClassLoader;
		// Original method
		/*
		{
        return mClassLoader;
    }
		*/
	}

    
    public boolean setAllowFds(boolean allowFds){
		dsTaint.addTaint(allowFds);
		return dsTaint.getTaintBoolean();
		// Original method
		/*
		{
        boolean orig = mAllowFds;
        mAllowFds = allowFds;
        return orig;
    }
		*/
	}

    
    @Override public Object clone(){
		return new Bundle(this);
		// Original method
		/*
		{
        return new Bundle(this);
    }
		*/
	}

    
    synchronized void unparcel(){
		// We are handling the taint when the mParcelledData is assigned
		/*
		int N = mParcelledData.readInt();
		mMap = new HashMap<String, Object>();
		mParcelledData.readMapInternal(mMap, N, mClassLoader);
		mParcelledData.recycle();
		mParcelledData = null;
		*/
		// Original method
		/*
		{
        if (mParcelledData == null) {
            return;
        }
        int N = mParcelledData.readInt();
        if (N < 0) {
            return;
        }
        if (mMap == null) {
            mMap = new HashMap<String, Object>();
        }
        mParcelledData.readMapInternal(mMap, N, mClassLoader);
        mParcelledData.recycle();
        mParcelledData = null;
    }
		*/
		//Return nothing
	}

    
    public int size(){
		return dsTaint.getTaintInt();
		// Original method
		/*
		{
        unparcel();
        return mMap.size();
    }
		*/
	}

    
    public boolean isEmpty(){
		return dsTaint.getTaintBoolean();
		// Original method
		/*
		{
        unparcel();
        return mMap.isEmpty();
    }
		*/
	}

    
    public void clear(){
		// Original method
		/*
		{
        unparcel();
        mMap.clear();
        mHasFds = false;
        mFdsKnown = true;
    }
		*/
		//Return nothing
	}

    
    public boolean containsKey(String key){
		return dsTaint.getTaintBoolean();
		// Original method
		/*
		{
        unparcel();
        return mMap.containsKey(key);
    }
		*/
	}

    
    public Object get(String key){
		return dsTaint.getTaint();
		// Original method
		/*
		{
        unparcel();
        return mMap.get(key);
    }
		*/
	}

    
    public void remove(String key){
		// Original method
		/*
		{
        unparcel();
        mMap.remove(key);
    }
		*/
		//Return nothing
	}

    
    public void putAll(Bundle map){
		dsTaint.addTaint(map.dsTaint);
		// Original method
		/*
		{
        unparcel();
        map.unparcel();
        mMap.putAll(map.mMap);
        mHasFds |= map.mHasFds;
        mFdsKnown = mFdsKnown && map.mFdsKnown;
    }
		*/
		//Return nothing
	}

    
    public Set<String> keySet(){
		Set<String> retVal = new HashSet<String>();
		retVal.add(dsTaint.getTaintString());
		return retVal;
		// Original method
		/*
		{
        unparcel();
        return mMap.keySet();
    }
		*/
	}

    
    public boolean hasFileDescriptors(){
		return dsTaint.getTaintBoolean();
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}

    
    public void putBoolean(String key, boolean value){
		mKey = key;
		dsTaint.addTaint(value);
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putByte(String key, byte value){
		mKey = key;
		dsTaint.addTaint(value);
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putChar(String key, char value){
		mKey = key;
		dsTaint.addTaint(value);
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putShort(String key, short value){
		mKey = key;
		dsTaint.addTaint(value);
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putInt(String key, int value){
		mKey = key;
		dsTaint.addTaint(value);
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putLong(String key, long value){
		mKey = key;
		dsTaint.addTaint(value);
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putFloat(String key, float value){
		mKey = key;
		dsTaint.addTaint(value);
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putDouble(String key, double value){
		mKey = key;
		mValueDouble = value; //DSFIXME:  Temporary fix (see below)
		//dsTaint.addTaint(value); //DSFIXME:  Need to add another addTaint method that takes a double
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public void putString(String key, String value){
		mKey = key;
		mValueString = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putCharSequence(String key, CharSequence value){
		mKey = key;
		mValueCharSequence = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putParcelable(String key, Parcelable value){
		mKey = key;
		mValueParcelable = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
    }
		*/
		//Return nothing
	}

    
    public void putParcelableArray(String key, Parcelable[] value){
		mKey = key;
		mValueParcelableArray = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
    }
		*/
		//Return nothing
	}

    
    public void putParcelableArrayList(String key,
        ArrayList<? extends Parcelable> value){
		mKey = key;
		mValueParcelableArrayList = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
    }
		*/
		//Return nothing
	}

    
    public void putSparseParcelableArray(String key,
            SparseArray<? extends Parcelable> value){
		mKey = key;
		mValueSparseParcelableArray = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
        mFdsKnown = false;
    }
		*/
		//Return nothing
	}

    
    public void putIntegerArrayList(String key, ArrayList<Integer> value){
		mKey = key;
		mValueArrayList = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putStringArrayList(String key, ArrayList<String> value){
		mKey = key;
		mValueStringArrayList = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putCharSequenceArrayList(String key, ArrayList<CharSequence> value){
		mKey = key;
		mValueCharSequenceArrayList = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
	public void putSerializable(String key, Serializable value){
		mKey = key;
		mValueSerializable = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putBooleanArray(String key, boolean[] value){
		mKey = key;
		mValueBooleanArray = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putByteArray(String key, byte[] value){
		mKey = key;
		mValueByteArray = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putShortArray(String key, short[] value){
		mKey = key;
		mValueShortArray = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putCharArray(String key, char[] value){
		mKey = key;
		mValueCharArray = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putIntArray(String key, int[] value){
		mKey = key;
		mValueIntArray = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putLongArray(String key, long[] value){
		mKey = key;
		mValueLongArray = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putFloatArray(String key, float[] value){
		mKey = key;
		mValueFloatArray = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putDoubleArray(String key, double[] value){
		mKey = key;
		mValueDoubleArray = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putStringArray(String key, String[] value){
		mKey = key;
		mValueStringArray = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putCharSequenceArray(String key, CharSequence[] value){
		mKey = key;
		mValueCharSequenceArray = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public void putBundle(String key, Bundle value){
		mKey = key;
		mValueBundle = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    @Deprecated public void putIBinder(String key, IBinder value){
		mKey = key;
		mValueIBinder = value;
		// Original method
		/*
		{
        unparcel();
        mMap.put(key, value);
    }
		*/
		//Return nothing
	}

    
    public boolean getBoolean(String key){
		return dsTaint.getTaintBoolean();
		// Original method
		/*
		{
        unparcel();
        return getBoolean(key, false);
    }
		*/
	}

    
    private void typeWarning(String key, Object value, String className,
        Object defaultValue, ClassCastException e){
		// Original method
		/*
		{
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
		*/
		//Return nothing
	}

    
    private void typeWarning(String key, Object value, String className,
        ClassCastException e){
		// Original method
		/*
		{
        typeWarning(key, value, className, "<null>", e);
    }
		*/
		//Return nothing
	}

    
    public boolean getBoolean(String key, boolean defaultValue){
		return dsTaint.getTaintBoolean();
		// Original method
		/*
		{
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
		*/
	}

    
    public byte getByte(String key){
		return dsTaint.getTaintByte();
		// Original method
		/*
		{
        unparcel();
        return getByte(key, (byte) 0);
    }
		*/
	}

    
    public Byte getByte(String key, byte defaultValue){
		return dsTaint.getTaintByte();
		// Original method
		/*
		{
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
		*/
	}

    
    public char getChar(String key){
		return dsTaint.getTaintChar();
		// Original method
		/*
		{
        unparcel();
        return getChar(key, (char) 0);
    }
		*/
	}

    
    public char getChar(String key, char defaultValue){
		return dsTaint.getTaintChar();
		// Original method
		/*
		{
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
		*/
	}

    
    public short getShort(String key){
		return dsTaint.getTaintShort();
		// Original method
		/*
		{
        unparcel();
        return getShort(key, (short) 0);
    }
		*/
	}

    
    public short getShort(String key, short defaultValue){
		return dsTaint.getTaintShort();
		// Original method
		/*
		{
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
		*/
	}

    
    public int getInt(String key){
		return dsTaint.getTaintInt();
		// Original method
		/*
		{
        unparcel();
        return getInt(key, 0);
    }
		*/
	}

    
    public int getInt(String key, int defaultValue){
		return dsTaint.getTaintInt();
		// Original method
		/*
		{
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
		*/
	}

    
    public long getLong(String key){
		return dsTaint.getTaintInt();
		// Original method
		/*
		{
        unparcel();
        return getLong(key, 0L);
    }
		*/
	}

    
    public long getLong(String key, long defaultValue){
		return dsTaint.getTaintInt();
		// Original method
		/*
		{
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
		*/
	}

    
    public float getFloat(String key){
		return dsTaint.getTaintFloat();
		// Original method
		/*
		{
        unparcel();
        return getFloat(key, 0.0f);
    }
		*/
	}

    
    public float getFloat(String key, float defaultValue){
		return dsTaint.getTaintFloat();
		// Original method
		/*
		{
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
		*/
	}

    
    public double getDouble(String key){
		return dsTaint.getTaintFloat();
		// Original method
		/*
		{
        unparcel();
        return getDouble(key, 0.0);
    }
		*/
	}

    
    public double getDouble(String key, double defaultValue){
		return dsTaint.getTaintFloat();
		// Original method
		/*
		{
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
		*/
	}

    
    public String getString(String key){
		return mValueString;
		// Original method
		/*
		{
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
		*/
	}

    
    public String getString(String key, String defaultValue){
		return mValueString;
		// Original method
		/*
		{
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
		*/
	}

    
    public CharSequence getCharSequence(String key){
		return mValueCharSequence;
		// Original method
		/*
		{
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
		*/
	}

    
    public CharSequence getCharSequence(String key, CharSequence defaultValue){
		return mValueCharSequence;
		// Original method
		/*
		{
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
		*/
	}

    
    public Bundle getBundle(String key){
		return mValueBundle;
		// Original method
		/*
		{
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
		*/
	}

    
    @DSModeled(DSC.SAFE)
	public <T extends Parcelable> T getParcelable(String key) {
		return (T)mValueParcelable;
		// Original method
		/*
		{
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (T) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "Parcelable", e);
            return null;
        }
    }
		*/
	}

    
    public Parcelable[] getParcelableArray(String key){
		return mValueParcelableArray;
		// Original method
		/*
		{
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
		*/
	}

    
    public <T extends Parcelable> ArrayList<T> getParcelableArrayList(String key) {
        return (ArrayList<T>) mValueParcelableArrayList;
		// Original method
		/*
		{
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (ArrayList<T>) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "ArrayList", e);
            return null;
        }
    }
		*/
	}

    
    public <T extends Parcelable> SparseArray<T> getSparseParcelableArray(String key) {
		return (SparseArray<T>) mValueSparseParcelableArray;
		// Original method
		/*
		{
        unparcel();
        Object o = mMap.get(key);
        if (o == null) {
            return null;
        }
        try {
            return (SparseArray<T>) o;
        } catch (ClassCastException e) {
            typeWarning(key, o, "SparseArray", e);
            return null;
        }
    }
		*/
	}

    
    public Serializable getSerializable(String key){
		return mValueSerializable;
		// Original method
		/*
		{
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
		*/
	}

    
    public ArrayList<Integer> getIntegerArrayList(String key) {
		return mValueArrayList;
		// Original method
		/*
		{
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
		*/
	}

    
    public ArrayList<String> getStringArrayList(String key){
		return mValueStringArrayList;
		// Original method
		/*
		{
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
		*/
	}

    
    public ArrayList<CharSequence> getCharSequenceArrayList(String key){
		return mValueCharSequenceArrayList;
		// Original method
		/*
		{
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
		*/
	}

    
    public boolean[] getBooleanArray(String key){
		return mValueBooleanArray;
		// Original method
		/*
		{
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
		*/
	}

    
    public byte[] getByteArray(String key){
		return mValueByteArray;
		// Original method
		/*
		{
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
		*/
	}

    
    public short[] getShortArray(String key){
		return mValueShortArray;
		// Original method
		/*
		{
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
		*/
	}

    
    public char[] getCharArray(String key){
		return mValueCharArray;
		// Original method
		/*
		{
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
		*/
	}

    
    public int[] getIntArray(String key){
		return mValueIntArray;
		// Original method
		/*
		{
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
		*/
	}

    
    public long[] getLongArray(String key){
		return mValueLongArray;
		// Original method
		/*
		{
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
		*/
	}

    
    public float[] getFloatArray(String key){
		return mValueFloatArray;
		// Original method
		/*
		{
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
		*/
	}

    
    public double[] getDoubleArray(String key){
		return mValueDoubleArray;
		// Original method
		/*
		{
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
		*/
	}

    
    public String[] getStringArray(String key){
		return mValueStringArray;
		// Original method
		/*
		{
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
		*/
	}

    
    public CharSequence[] getCharSequenceArray(String key){
		return mValueCharSequenceArray;
		// Original method
		/*
		{
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
		*/
	}

    
    @Deprecated public IBinder getIBinder(String key){
		return mValueIBinder;
		// Original method
		/*
		{
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
		*/
	}

    
    public int describeContents(){
		return dsTaint.getTaintInt();
		// Original method
		/*
		{
        int mask = 0;
        if (hasFileDescriptors()) {
            mask |= Parcelable.CONTENTS_FILE_DESCRIPTOR;
        }
        return mask;
    }
		*/
	}

    
    public void writeToParcel(Parcel parcel, int flags){
		//parcel.dsTaint.addTaint(dsTaint);
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    public void readFromParcel(Parcel parcel){
		readFromParcelInner(parcel, 0);
		// Original method
		/*
		{
        int length = parcel.readInt();
        if (length < 0) {
            throw new RuntimeException("Bad length in parcel: " + length);
        }
        readFromParcelInner(parcel, length);
    }
		*/
		//Return nothing
	}

    
    void readFromParcelInner(Parcel parcel, int length){
		//dsTaint.addTaint(parcel.dsTaint);  //DSFIXME:  Add taint to parcel and uncomment this line
		// Original method
		/*
		{
        int magic = parcel.readInt();
        if (magic != 0x4C444E42) {
            String st = Log.getStackTraceString(new RuntimeException());
            Log.e("Bundle", "readBundle: bad magic number");
            Log.e("Bundle", "readBundle: trace = " + st);
        }
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
		*/
		//Return nothing
	}

    
    @Override public synchronized String toString(){
		return dsTaint.getTaintString();
		// Original method
		/*
		{
        if (mParcelledData != null) {
            return "Bundle[mParcelledData.dataSize=" +
                    mParcelledData.dataSize() + "]";
        }
        return "Bundle[" + mMap.toString() + "]";
    }
		*/
	}

    
    private static final String LOG_TAG = "Bundle";
    public static final Bundle EMPTY;
    static {
        EMPTY = new Bundle();
        EMPTY.mMap = Collections.unmodifiableMap(new HashMap<String, Object>());
    }
    
    public static final Parcelable.Creator<Bundle> CREATOR = new Parcelable.Creator<Bundle>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.000 -0400", hash_original_method = "4187614240FC5282A7CB86A3FCAECB06", hash_generated_method = "CBA6F36F6CF23023E6E0CCCDB662157F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Bundle createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            Bundle var4397E85376BF5EF6C8D33C3D50A4F9DE_1713809666 = (in.readBundle());
            return (Bundle)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return in.readBundle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:41:02.001 -0400", hash_original_method = "5E82917C5DD51CF815A5AE0167A86BCD", hash_generated_method = "D0AE2D245BC671CFCB18185645FF90D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Bundle[] newArray(int size) {
            dsTaint.addTaint(size);
            Bundle[] var75FE56B662CBE80413B5617E4AB0158B_515527399 = (new Bundle[size]);
            return (Bundle[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Bundle[size];
        }

        
}; //Transformed anonymous class
}

