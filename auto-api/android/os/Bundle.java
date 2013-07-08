package android.os;


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
		
        
        
        
        
		
		
		
		
	}
	
	@DSModeled(DSC.SAFE)
	Bundle(Parcel parcelledData){
		readFromParcel(parcelledData);
		
	}
	
	@DSModeled(DSC.SAFE)
	Bundle(Parcel parcelledData, int length){
		readFromParcelInner(parcelledData, length);
		
	}
	
	@DSModeled(DSC.BAN)
	public Bundle(ClassLoader loader){
		mClassLoader = loader;  
		
	}
	
	@DSModeled(DSC.BAN)
	public Bundle(int capacity){
		
		
		
	}
	
	@DSModeled(DSC.SAFE)
	public Bundle(Bundle b){
		addTaint(b.getTaint());
		
	}
	
	public static Bundle forPair(String key, String value){
		Bundle b = new Bundle(1);
        b.putString(key, value);
        return b;
		
		
	}
	
	public String getPairValue(){
        String str = new String();
        str.addTaint(getTaint());
        return str;
		
		
	}
	
	public void setClassLoader(ClassLoader loader){
		mClassLoader = loader;  
		
		
		
		
	}
	
	public ClassLoader getClassLoader(){
		return mClassLoader;
		
		
		
	}
	
	public boolean setAllowFds(boolean allowFds){
		addTaint(allowFds);
		return getTaintBoolean();
		
		
		
	}
	
	@Override public Object clone(){
		return new Bundle(this);
		
		
	}
	
	synchronized void unparcel(){
		
		
		
		
		
	}
	
	public int size(){
		return getTaintInt();
		
		
	}
	
	public boolean isEmpty(){
		return getTaintBoolean();
		
		
	}
	
	public void clear(){
		
		
		
	}
	
	public boolean containsKey(String key){
		return getTaintBoolean();
		
		
	}
	
	public Object get(String key){
		return getTaint();
		
		
	}
	
	public void remove(String key){
		
		
		
	}
	
	public void putAll(Bundle map){
		addTaint(map.getTaint());
		
		
		
	}
	
	public Set<String> keySet(){
		Set<String> keys = new HashSet<String>();
		keys.addTaint(getTaint());
		return keys;
		
		
	}
	
	@DSModeled(DSC.SPEC)
    public boolean hasFileDescriptors(){
		return getTaintBoolean();
		
		
		
	}
	
	private String mKey; 
	
	public void putBoolean(String key, boolean value){
		mKey = key;
		addTaint(value);
		
		
		
	}
	
	public void putByte(String key, byte value){
		mKey = key;
		addTaint(value);
		
		
		
	}
	
	public void putChar(String key, char value){
		mKey = key;
		addTaint(value);
		
		
		
	}
	
	public void putShort(String key, short value){
		mKey = key;
		addTaint(value);
		
		
		
	}
	
	public void putInt(String key, int value){
		mKey = key;
		addTaint(value);
		
		
		
	}
	
	public void putLong(String key, long value){
		mKey = key;
		addTaint(value);
		
		
		
	}
	
	public void putFloat(String key, float value){
		mKey = key;
		addTaint(value);
		
		
		
	}
	
	private double mValueDouble;
	
	public void putDouble(String key, double value){
		mKey = key;
		mValueDouble = value; 
		
		
		
		
	}
	
	private String mValueString;
	
	@DSModeled(DSC.SAFE)
	public void putString(String key, String value){
		mKey = key;
		mValueString = value;
		
		
		
	}
	
	private CharSequence mValueCharSequence;
	
	public void putCharSequence(String key, CharSequence value){
		mKey = key;
		mValueCharSequence = value;
		
		
		
	}
	
	private Parcelable mValueParcelable;
	
	public void putParcelable(String key, Parcelable value){
		mKey = key;
		mValueParcelable = value;
		
		
		
		
	}
	
	private Parcelable[] mValueParcelableArray;
	
	public void putParcelableArray(String key, Parcelable[] value){
		mKey = key;
		mValueParcelableArray = value;
		
		
		
		
	}
	
	private ArrayList<? extends Parcelable> mValueParcelableArrayList;
	
	public void putParcelableArrayList(String key,
        ArrayList<? extends Parcelable> value){
		mKey = key;
		mValueParcelableArrayList = value;
		
		
		
		
	}
	
	SparseArray<? extends Parcelable> mValueSparseParcelableArray;
	
	public void putSparseParcelableArray(String key,
            SparseArray<? extends Parcelable> value){
		mKey = key;
		mValueSparseParcelableArray = value;
		
		
		
		
	}
	
	private ArrayList<Integer> mValueArrayList;
	
	public void putIntegerArrayList(String key, ArrayList<Integer> value){
		mKey = key;
		mValueArrayList = value;
		
		
		
	}
	
	private ArrayList<String> mValueStringArrayList;
	
	public void putStringArrayList(String key, ArrayList<String> value){
		mKey = key;
		mValueStringArrayList = value;
		
		
		
		
	}
	
	private ArrayList<CharSequence> mValueCharSequenceArrayList;
	
	public void putCharSequenceArrayList(String key, ArrayList<CharSequence> value){
		mKey = key;
		mValueCharSequenceArrayList = value;
		
		
		
		
	}
	
	private Serializable mValueSerializable;
	
	@DSModeled(DSC.SAFE)
	public void putSerializable(String key, Serializable value){
		mKey = key;
		mValueSerializable = value;
		
		
		
		
	}
	
	private boolean[] mValueBooleanArray;
	
	public void putBooleanArray(String key, boolean[] value){
		mKey = key;
		mValueBooleanArray = value;
		
		
		
		
	}
	
	private byte[] mValueByteArray;
	
	public void putByteArray(String key, byte[] value){
		mKey = key;
		mValueByteArray = value;
		
		
		
		
	}
	
	private short[] mValueShortArray;
	
	public void putShortArray(String key, short[] value){
		mKey = key;
		mValueShortArray = value;
		
		
		
		
	}
	
	private char[] mValueCharArray;
	
	public void putCharArray(String key, char[] value){
		mKey = key;
		mValueCharArray = value;
		
		
		
		
	}
	
	private int[] mValueIntArray;
	
	public void putIntArray(String key, int[] value){
		mKey = key;
		mValueIntArray = value;
		
		
		
		
	}
	
	private long[] mValueLongArray;
	
	public void putLongArray(String key, long[] value){
		mKey = key;
		mValueLongArray = value;
		
		
		
		
	}
	
	private float[] mValueFloatArray;
	
	public void putFloatArray(String key, float[] value){
		mKey = key;
		mValueFloatArray = value;
		
		
		
		
	}
	
	private double[] mValueDoubleArray;
	
	public void putDoubleArray(String key, double[] value){
		mKey = key;
		mValueDoubleArray = value;
		
		
		
		
	}
	
	private String[] mValueStringArray;
	
	public void putStringArray(String key, String[] value){
		mKey = key;
		mValueStringArray = value;
		
		
		
	}
	
	private CharSequence[] mValueCharSequenceArray;
	
	public void putCharSequenceArray(String key, CharSequence[] value){
		mKey = key;
		mValueCharSequenceArray = value;
		
		
		
		
	}
	
	private Bundle mValueBundle;
	
	public void putBundle(String key, Bundle value){
		mKey = key;
		mValueBundle = value;
		
		
		
		
	}
	
	private IBinder mValueIBinder;
	
	@Deprecated public void putIBinder(String key, IBinder value){
		mKey = key;
		mValueIBinder = value;
		
		
		
		
	}
	
	public boolean getBoolean(String key){
		return getTaintBoolean();
		
		
	}
	
	private void typeWarning(String key, Object value, String className,
        Object defaultValue, ClassCastException e){
		
		
		
		
	}
	
	private void typeWarning(String key, Object value, String className,
        ClassCastException e){
		
		
		
		
	}
	
	public boolean getBoolean(String key, boolean defaultValue){
		return getTaintBoolean();
		
		
	}
	
	public byte getByte(String key){
		return getTaintByte();
		
		
	}
	
	public Byte getByte(String key, byte defaultValue){
		return getTaintByte();
		
		
	}
	
	public char getChar(String key){
		return getTaintChar();
		
		
	}
	
	public char getChar(String key, char defaultValue){
		return getTaintChar();
		
		
	}
	
	public short getShort(String key){
		return getTaintShort();
		
		
	}
	
	public short getShort(String key, short defaultValue){
		return getTaintShort();
		
		
	}
	
	public int getInt(String key){
		return getTaintInt();
		
		
	}
	
	public int getInt(String key, int defaultValue){
		return getTaintInt();
		
		
	}
	
	public long getLong(String key){
		return getTaintInt();
		
		
	}
	
	public long getLong(String key, long defaultValue){
		return getTaintInt();
		
		
	}
	
	public float getFloat(String key){
		return getTaintFloat();
		
		
	}
	
	public float getFloat(String key, float defaultValue){
		return getTaintFloat();
		
		
	}
	
	public double getDouble(String key){
		return getTaintFloat();
		
		
	}
	
	public double getDouble(String key, double defaultValue){
		return getTaintFloat();
		
		
	}
	
	public String getString(String key){
		return mValueString;
		
		
		
	}
	
	public String getString(String key, String defaultValue){
		return mValueString;
		
		
		
	}
	
	public CharSequence getCharSequence(String key){
		return mValueCharSequence;
		
		
		
	}
	
	public CharSequence getCharSequence(String key, CharSequence defaultValue){
		return mValueCharSequence;
		
		
		
	}
	
	public Bundle getBundle(String key){
		return mValueBundle;
		
		
		
	}
	
	@DSModeled(DSC.SAFE)
	public <T extends Parcelable> T getParcelable(String key) {
		return (T)mValueParcelable;
		
		
		
	}
	
	public Parcelable[] getParcelableArray(String key){
		return mValueParcelableArray;
		
		
		
	}
	
	public <T extends Parcelable> ArrayList<T> getParcelableArrayList(String key) {
        return (ArrayList<T>) mValueParcelableArrayList;
		
		
	}
	
	public <T extends Parcelable> SparseArray<T> getSparseParcelableArray(String key) {
		return (SparseArray<T>) mValueSparseParcelableArray;
		
		
	}
	
	public Serializable getSerializable(String key){
		return mValueSerializable;
		
		
		
	}
	
	public ArrayList<Integer> getIntegerArrayList(String key) {
		return mValueArrayList;
		
		
		
	}
	
	public ArrayList<String> getStringArrayList(String key){
		return mValueStringArrayList;
		
		
		
	}
	
	public ArrayList<CharSequence> getCharSequenceArrayList(String key){
		return mValueCharSequenceArrayList;
		
		
		
	}
	
	public boolean[] getBooleanArray(String key){
		return mValueBooleanArray;
		
		
		
	}
	
	public byte[] getByteArray(String key){
		return mValueByteArray;
		
		
		
	}
	
	public short[] getShortArray(String key){
		return mValueShortArray;
		
		
		
	}
	
	public char[] getCharArray(String key){
		return mValueCharArray;
		
		
		
	}
	
	public int[] getIntArray(String key){
		return mValueIntArray;
		
		
		
	}
	
	public long[] getLongArray(String key){
		return mValueLongArray;
		
		
		
	}
	
	public float[] getFloatArray(String key){
		return mValueFloatArray;
		
		
		
	}
	
	public double[] getDoubleArray(String key){
		return mValueDoubleArray;
		
		
		
	}
	
	public String[] getStringArray(String key){
		return mValueStringArray;
		
		
		
	}
	
	public CharSequence[] getCharSequenceArray(String key){
		return mValueCharSequenceArray;
		
		
		
	}
	
	@Deprecated public IBinder getIBinder(String key){
		return mValueIBinder;
		
		
		
	}
	
	
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
		return getTaintInt();
		
		
	}
	
	public void writeToParcel(Parcel parcel, int flags){
		
		
		
		
	}
	
	public void readFromParcel(Parcel parcel){
		readFromParcelInner(parcel, 0);
		
		
		
	}
	
	void readFromParcelInner(Parcel parcel, int length){
		
		
		
		
	}
	
	@Override public synchronized String toString(){
        String str = new String();
        str.addTaint(getTaint());
        return str;
		
		
	}
}

