package android.os;

// Droidsafe Imports
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import android.util.SparseArray;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public final class Bundle implements Parcelable, Cloneable {
	
	private static final String LOG_TAG = "Bundle";
	public static final Bundle EMPTY;
	static {
        EMPTY = new Bundle();
        EMPTY.mMap = Collections.unmodifiableMap(new HashMap<String, Object>());
    }
	Map<String, Object> mMap = null;
	Parcel mParcelledData = null;
	private boolean mHasFds = false;
	private boolean mFdsKnown = true;
	private boolean mAllowFds = true;
	private ClassLoader mClassLoader;
	
	@DSModeled(value = DSC.BAN)
	public Bundle(){
		// MIT's comment below...
        //DSModel: Do we need to do something about this class loader
        //we don't allow dynamic class loading, so we should not have to model this
        //all calls that use it should be banned
        //mClassLoader = getClass().getClassLoader();
		
		//mClassLoader = getClass().getClassLoader();
		
		/*
		mMap = new HashMap<String, Object>();
		mClassLoader = getClass().getClassLoader();
		*/
	}
	
	@DSModeled(DSC.SAFE)
	Bundle(Parcel parcelledData){
		readFromParcel(parcelledData);
		/*
		readFromParcel(parcelledData);
		*/
	}
	
	@DSModeled(DSC.SAFE)
	Bundle(Parcel parcelledData, int length){
		readFromParcelInner(parcelledData, length);
		/*
		readFromParcelInner(parcelledData, length);
		*/
	}
	
	@DSModeled(DSC.BAN)
	public Bundle(ClassLoader loader){
		mClassLoader = loader;  //Preserved
		/*
		mMap = new HashMap<String, Object>();
		mClassLoader = loader;
		*/
	}
	
	@DSModeled(DSC.BAN)
	public Bundle(int capacity){
		//mMap = new HashMap<String, Object>();
		//mClassLoader = getClass().getClassLoader();
		/*
		mMap = new HashMap<String, Object>(capacity);
		mClassLoader = getClass().getClassLoader();
		*/
	}
	
	@DSModeled(DSC.SAFE)
	public Bundle(Bundle b){
		dsTaint.addTaint(b.dsTaint);
		/*
		if (b.mParcelledData != null) {
            mParcelledData = Parcel.obtain();
            mParcelledData.appendFrom(b.mParcelledData, 0, b.mParcelledData.dataSize());
            mParcelledData.setDataPosition(0);
        } else {
            mParcelledData = null;
        }
		if (b.mMap != null) {
            mMap = new HashMap<String, Object>(b.mMap);
        } else {
            mMap = null;
        }
		mHasFds = b.mHasFds;
		mFdsKnown = b.mFdsKnown;
		mClassLoader = b.mClassLoader;
		*/
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
	
	private String mKey; //DSFIXME:  Move to top
	
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
	
	private double mValueDouble;
	
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
	
	private String mValueString;
	
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
	
	private CharSequence mValueCharSequence;
	
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
	
	private Parcelable mValueParcelable;
	
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
	
	private Parcelable[] mValueParcelableArray;
	
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
	
	private ArrayList<? extends Parcelable> mValueParcelableArrayList;
	
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
	
	SparseArray<? extends Parcelable> mValueSparseParcelableArray;
	
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
	
	private ArrayList<Integer> mValueArrayList;
	
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
	
	private ArrayList<String> mValueStringArrayList;
	
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
	
	private ArrayList<CharSequence> mValueCharSequenceArrayList;
	
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
	
	private Serializable mValueSerializable;
	
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
	
	private boolean[] mValueBooleanArray;
	
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
	
	private byte[] mValueByteArray;
	
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
	
	private short[] mValueShortArray;
	
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
	
	private char[] mValueCharArray;
	
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
	
	private int[] mValueIntArray;
	
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
	
	private long[] mValueLongArray;
	
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
	
	private float[] mValueFloatArray;
	
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
	
	private double[] mValueDoubleArray;
	
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
	
	private String[] mValueStringArray;
	
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
	
	private CharSequence[] mValueCharSequenceArray;
	
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
	
	private Bundle mValueBundle;
	
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
	
	private IBinder mValueIBinder;
	
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
		return (byte)dsTaint.getTaintInt();
		// Original method
		/*
		{
        unparcel();
        return getByte(key, (byte) 0);
    }
		*/
	}
	
	public Byte getByte(String key, byte defaultValue){
		return (byte)dsTaint.getTaintInt();
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
		return (char)dsTaint.getTaintInt();
		// Original method
		/*
		{
        unparcel();
        return getChar(key, (char) 0);
    }
		*/
	}
	
	public char getChar(String key, char defaultValue){
		return (char)dsTaint.getTaintInt();
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
		return (short)dsTaint.getTaintInt();
		// Original method
		/*
		{
        unparcel();
        return getShort(key, (short) 0);
    }
		*/
	}
	
	public short getShort(String key, short defaultValue){
		return (short)dsTaint.getTaintInt();
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
	
	/** this is added to swapout the annonymous class */
	private static class MyCreator implements Parcelable.Creator<Bundle> {
	    @DSModeled(DSC.SAFE)
	    public MyCreator() {
	    }
	    
	    @DSModeled(DSC.SAFE)
        public Bundle createFromParcel(Parcel in) {
            return in.readBundle();
        }

	    @DSModeled(DSC.SAFE)
        public Bundle[] newArray(int size) {
            return new Bundle[size];
        }	    
	}
	
	public static final Parcelable.Creator<Bundle> CREATOR = new MyCreator();
        
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
}

