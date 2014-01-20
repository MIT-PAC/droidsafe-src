package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

public final class Parcel {
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public static Parcel obtain(){
		return new Parcel(0);
		// Original method
		/*
		{
        final Parcel[] pool = sOwnedPool;
        synchronized (pool) {
            Parcel p;
            for (int i=0; i<POOL_SIZE; i++) {
                p = pool[i];
                if (p != null) {
                    pool[i] = null;
                    if (DEBUG_RECYCLE) {
                        p.mStack = new RuntimeException();
                    }
                    return p;
                }
            }
        }
        return new Parcel(0);
    }
		*/
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static FileDescriptor openFileDescriptor(String file,
            int mode){
		//Formerly a native function
		return new FileDescriptor();
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static FileDescriptor dupFileDescriptor(FileDescriptor orig){
		//Formerly a native function
		return orig;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static void closeFileDescriptor(FileDescriptor desc){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static void clearFileDescriptor(FileDescriptor desc){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    static protected final Parcel obtain(int obj){
		return new Parcel(obj);
		// Original method
		/*
		{
        final Parcel[] pool = sHolderPool;
        synchronized (pool) {
            Parcel p;
            for (int i=0; i<POOL_SIZE; i++) {
                p = pool[i];
                if (p != null) {
                    pool[i] = null;
                    if (DEBUG_RECYCLE) {
                        p.mStack = new RuntimeException();
                    }
                    p.init(obj);
                    return p;
                }
            }
        }
        return new Parcel(obj);
    }
		*/
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.989 -0500", hash_original_field = "5FA4EBA8910C8246CD5330A7878C5E2B", hash_generated_field = "4C4C82AEA5D9854FC45DA5375C35C2B9")

    private static final boolean DEBUG_RECYCLE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.991 -0500", hash_original_field = "ECE0091090C14A39AF4EF00FE87FB1ED", hash_generated_field = "8D4BB406013288DABCF21E3086232FF0")

    private static final String TAG = "Parcel";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.002 -0500", hash_original_field = "255B8CC2A192C047539CE0DFA8D7FD2A", hash_generated_field = "806F090E7CB08EA4F7BB25E21BB089B9")

    private static final int POOL_SIZE = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.004 -0500", hash_original_field = "D3DFB7401AB3E827234BC17332BF00FE", hash_generated_field = "2B06E04682E05687F5FE1F91A80B5001")

    private static final Parcel[] sOwnedPool = new Parcel[POOL_SIZE];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.007 -0500", hash_original_field = "8443E44F95ABF540724E9C5A81DF7CFF", hash_generated_field = "6A8EC49B77FA2982F6172D9088BEE965")

    private static final Parcel[] sHolderPool = new Parcel[POOL_SIZE];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.009 -0500", hash_original_field = "96EFFF59895EEAB0615861612CE08DD0", hash_generated_field = "C083E5876DACD70ACA563A851C9BF80A")

    private static final int VAL_NULL = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.011 -0500", hash_original_field = "720C555A23FD6F10099487B3D8650C8B", hash_generated_field = "45F7F878732CA50D8D10532C9B029700")

    private static final int VAL_STRING = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.013 -0500", hash_original_field = "3B7BBB70B847B4DDC3F2EDEC51BB6F55", hash_generated_field = "3105C6E283A2C8969131A51B9084E315")

    private static final int VAL_INTEGER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.016 -0500", hash_original_field = "0CA5935BC7BA82D6E36493C9F9D76D44", hash_generated_field = "1E3EDA05CA698B82AB90723508DE126A")

    private static final int VAL_MAP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.018 -0500", hash_original_field = "B78094C133970BA2129340A0C8673F7D", hash_generated_field = "77D016C4104C510EB61EAD16649E4B98")

    private static final int VAL_BUNDLE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.020 -0500", hash_original_field = "4E2F3F68C89825497924CF5354118708", hash_generated_field = "A89ABF4349986B7E1CF429EF8B150F43")

    private static final int VAL_PARCELABLE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.023 -0500", hash_original_field = "5A5CDA0159F39EE039E63F6553B1A9A8", hash_generated_field = "97F320554483CFA3BD525573C34EEBF6")

    private static final int VAL_SHORT = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.025 -0500", hash_original_field = "6F3A5BA9F4C1495072EE22CC61489596", hash_generated_field = "F2505784946CF430B6454C933AA64E43")

    private static final int VAL_LONG = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.028 -0500", hash_original_field = "77B9CCC0903582CE006C697C198150CE", hash_generated_field = "15249D8B4B676F2BF7A97F24D427B5AA")

    private static final int VAL_FLOAT = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.030 -0500", hash_original_field = "E5214FC1A6C0077A9B20406AFB6C44E9", hash_generated_field = "1E7C612DDB2B7EF1312E741523E53799")

    private static final int VAL_DOUBLE = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.032 -0500", hash_original_field = "67BF4C57D48E99C96C95B7ED9E3B66C5", hash_generated_field = "E46F341BE0E2D054D53CDEAD96F1959D")

    private static final int VAL_BOOLEAN = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.034 -0500", hash_original_field = "0E5940489DB482E1A608A1429EAC0C87", hash_generated_field = "B7D4E411492999EB4EA9BF2AC586F223")

    private static final int VAL_CHARSEQUENCE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.036 -0500", hash_original_field = "A45233739B5E74601403A8A75FDF70D6", hash_generated_field = "D4F1A8A9E0CE0974E2412812F0DA3F5D")

    private static final int VAL_LIST  = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.038 -0500", hash_original_field = "FBB2CA7C2670F607F4616A23EE40DE4C", hash_generated_field = "A131BD3EB211C05E3C6DF73570243AEC")

    private static final int VAL_SPARSEARRAY = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.041 -0500", hash_original_field = "2095ADF8B52C149986F10C28FA3BF224", hash_generated_field = "B0915F7A6E4DB352FA67870120FDC8AE")

    private static final int VAL_BYTEARRAY = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.044 -0500", hash_original_field = "613E6A58DAEC126F8FD860E34F5E2A8D", hash_generated_field = "076CE7EDAA5BD7403EB30339E6786640")

    private static final int VAL_STRINGARRAY = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.046 -0500", hash_original_field = "EBE69CD9E7D947958B3D10C41B815221", hash_generated_field = "4E84FC4E833FD58450A808B308F569C1")

    private static final int VAL_IBINDER = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.048 -0500", hash_original_field = "8041CF4E9302D6B0E3CCE0A447CD4121", hash_generated_field = "0D7C7CC2E878323D6F87D50D47E3E125")

    private static final int VAL_PARCELABLEARRAY = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.051 -0500", hash_original_field = "768E4A1F344EC30F0B3676965E29D69C", hash_generated_field = "6AC2F3E2A41C5CBB0C87EBFBA40C82C5")

    private static final int VAL_OBJECTARRAY = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.053 -0500", hash_original_field = "FD4615D9996935D2F8F60C850E479ABD", hash_generated_field = "CCE7A715FCB460D5B4607A19AB0D3775")

    private static final int VAL_INTARRAY = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.056 -0500", hash_original_field = "A668CD148C3D0E46783117C1A34C5000", hash_generated_field = "32BC10EA8947FB3B0761472950236075")

    private static final int VAL_LONGARRAY = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.058 -0500", hash_original_field = "9BE6D81CB33AF3EE009076843778C6FF", hash_generated_field = "8007D2C64A8C971CD877A22E5B760585")

    private static final int VAL_BYTE = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.061 -0500", hash_original_field = "D3C211A5A9C9DD4269A987DC69FB8D06", hash_generated_field = "69C2B09C1800B12048056C3570CC73EE")

    private static final int VAL_SERIALIZABLE = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.063 -0500", hash_original_field = "E70844D5FAF56DAC881424E07AC4C5D8", hash_generated_field = "76413C216A3003CB555A68458846A3B3")

    private static final int VAL_SPARSEBOOLEANARRAY = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.065 -0500", hash_original_field = "3E2FA07DD6A432137B974F606DFF8434", hash_generated_field = "59D72A13D8A7453CC576337F712A9C20")

    private static final int VAL_BOOLEANARRAY = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.068 -0500", hash_original_field = "C5A61CBDCFAFDD4813E1951E34065965", hash_generated_field = "9EFA3FF92CCB2C8FEE3D6C5358430431")

    private static final int VAL_CHARSEQUENCEARRAY = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.070 -0500", hash_original_field = "6DB24F660C7F8E7FFFA594AEB2C918CD", hash_generated_field = "A3D419976A9106B09BDA82EB2BFFD162")

    private static final int EX_SECURITY = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.072 -0500", hash_original_field = "03D193E76AF8925C04CA8CA6361D2C6A", hash_generated_field = "F8C2B1DD68AD90CB95C1595F2C9A5242")

    private static final int EX_BAD_PARCELABLE = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.075 -0500", hash_original_field = "8D78533F648B33C086BCDCD4E53130B9", hash_generated_field = "CB37D327BBB5DFC9C44E983C8B41B091")

    private static final int EX_ILLEGAL_ARGUMENT = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.077 -0500", hash_original_field = "16D014F8B61B4C1B28ACE9079E1EC15A", hash_generated_field = "5990AECC0626B57467FE5BBFA45A5C36")

    private static final int EX_NULL_POINTER = -4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.079 -0500", hash_original_field = "C4CCDED77175D5174FC179324FB7B5C5", hash_generated_field = "336D3C5B9AFBD7D73F11E5473530DAD0")

    private static final int EX_ILLEGAL_STATE = -5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.081 -0500", hash_original_field = "E30192DA2CFEC8AF7657DFF008F87FE1", hash_generated_field = "DFC9983F0C453250258C48F81D356118")

    private static final int EX_HAS_REPLY_HEADER = -128;
    public final static Parcelable.Creator<String> STRING_CREATOR
             = new Parcelable.Creator<String>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.084 -0500", hash_original_method = "CF5066ADB23AB15A8F47A7B0F4466503", hash_generated_method = "00F386650A051887ED9112C5F2C23E06")
        
public String createFromParcel(Parcel source) {
            return source.readString();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.087 -0500", hash_original_method = "6691A777569EDCC3CEA07BFC1CA591D5", hash_generated_method = "EC55A39083ADE33958EB94A300AD0C5A")
        
public String[] newArray(int size) {
            return new String[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:31.416 -0500", hash_original_field = "92CA539F70081A1A7ED1F5DB7121AA6E", hash_generated_field = "6A787662DBE18F044602D72270EA27F0")

    // particular classes.  Keys are the names of the classes, values are
    // Method objects.
    private static final HashMap<ClassLoader,HashMap<String,Parcelable.Creator>>
        mCreators = new HashMap<ClassLoader,HashMap<String,Parcelable.Creator>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.993 -0500", hash_original_field = "099BEA65529558F891E66B800CD4AD52", hash_generated_field = "6861EF2C6719FB6BE9580A330103CA5F")

    @SuppressWarnings({"UnusedDeclaration"})
    private int mObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:30.997 -0500", hash_original_field = "CD428A1D2A29D7772981B2F0C2B9C0C8", hash_generated_field = "E2BD6B8F2FA33686C59551B5BF00B3B5")

    @SuppressWarnings({"UnusedDeclaration"})
    private int mOwnObject;
    // orphaned legacy field
    private char[] mValueCharArray;
    
    // orphaned legacy field
    private float[] mValueFloatArray;
    
    // orphaned legacy field
    private int[] mValueIntArray;
    
    // orphaned legacy field
    private byte[] mValueByteArray;
    
    // orphaned legacy field
    private Map mValueMap;
    
    // orphaned legacy field
    private boolean[] mValueBooleanArray;
    
    // orphaned legacy field
    private IBinder mValueIBinder;
    
    // orphaned legacy field
    private List<String> mValueStringList;
    
    // orphaned legacy field
    private long[] mValueLongArray;
    
    // orphaned legacy field
    private List<Parcelable> mValueTypedList;
    
    // orphaned legacy field
    private String[] mValueStringArray;
    
    // orphaned legacy field
    private IBinder[] mValueIBinderArray;
    
    // orphaned legacy field
    private byte[] mData;
    
    // orphaned legacy field
    private SparseArray<Object> mValueSparseArray;
    
    // orphaned legacy field
    private Object[] mValueObjectArray;
    
    // orphaned legacy field
    private IInterface mValueIInterface;
    
    // orphaned legacy field
    private CharSequence mValueCharSequence;
    
    // orphaned legacy field
    private Parcelable[] mValueParcelableArray;
    
    // orphaned legacy field
    private Serializable mValueSerializable;
    
    // orphaned legacy field
    private String mValueString;
    
    // orphaned legacy field
    private Bundle mValueBundle;
    
    // orphaned legacy field
    private List mValueList;
    
    // orphaned legacy field
    private Exception mValueException;
    
    // orphaned legacy field
    private CharSequence[] mValueCharSequenceArray;
    
    // orphaned legacy field
    private Parcelable mValueParcelable;
    
    // orphaned legacy field
    private Object mValueObject;
    
    // orphaned legacy field
    private SparseBooleanArray mValueSparseBooleanArray;
    
    // orphaned legacy field
    private double[] mValueDoubleArray;
    
    // orphaned legacy field
    private FileDescriptor mValueFileDescriptor;
    
    // orphaned legacy field
    private Parcelable[] mValueTypedArray;
    
    // orphaned legacy field
    private List<IBinder> mValueIBinderList;
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private Parcel(int obj){
		init(obj);
		/*
		if (DEBUG_RECYCLE) {
            mStack = new RuntimeException();
        }
		init(obj);
		*/
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final void recycle(){
		// Original method
		/*
		{
        if (DEBUG_RECYCLE) mStack = null;
        freeBuffer();
        final Parcel[] pool = mOwnObject != 0 ? sOwnedPool : sHolderPool;
        synchronized (pool) {
            for (int i=0; i<POOL_SIZE; i++) {
                if (pool[i] == null) {
                    pool[i] = this;
                    return;
                }
            }
        }
    }
		*/
		//Return nothing
	}
    
    public final int dataSize(){
		//Formerly a native function
		return getTaintInt();
	}
    
    public final int dataAvail(){
		//Formerly a native function
		return getTaintInt();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final int dataPosition(){
		//Formerly a native function
		return getTaintInt();
	}
    
    public final int dataCapacity(){
		//Formerly a native function
		return getTaintInt();
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void setDataSize(int size){
		//Formerly a native function
		//Return nothing
		addTaint(size);
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void setDataPosition(int pos){
		//Formerly a native function
		//Return nothing
		addTaint(pos);
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void setDataCapacity(int size){
		//Formerly a native function
		//Return nothing
		addTaint(size);
	}
    
    public final boolean pushAllowFds(boolean allowFds){
		//Formerly a native function
		return getTaintBoolean();
	}
    
    public final void restoreAllowFds(boolean lastValue){
		//Formerly a native function
		//Return nothing
		addTaint(lastValue);
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final byte[] marshall(){
		//Formerly a native function
		return mData;
	}
    
    public final void unmarshall(byte[] data, int offest, int length){
		//Formerly a native function
		//Return nothing
		mData = data;
	}
    
    public final void appendFrom(Parcel parcel, int offset, int length){
		//Formerly a native function
		//Return nothing
		addTaint(parcel.getTaint());
	}
    
    public final boolean hasFileDescriptors(){
		//Formerly a native function
		return getTaintBoolean();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final void writeInterfaceToken(String interfaceName){
		//Formerly a native function
		//Return nothing
		addTaint(interfaceName.getTaint());
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final void enforceInterface(String interfaceName){
		//Formerly a native function
		//Return nothing
		addTaint(interfaceName.getTaint());
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeByteArray(byte[] b){
		mValueByteArray = b;
		// Original method
		/*
		{
        writeByteArray(b, 0, (b != null) ? b.length : 0);
    }
		*/
		//Return nothing
	}
    
    public final void writeByteArray(byte[] b, int offset, int len){
		mValueByteArray = b;
		// Original method
		/*
		{
        if (b == null) {
            writeInt(-1);
            return;
        }
        Arrays.checkOffsetAndCount(b.length, offset, len);
        writeNative(b, offset, len);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void writeNative(byte[] b, int offset, int len){
		mValueByteArray = b;
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final void writeInt(int val){
		//Formerly a native function
		//Return nothing
		addTaint(val);
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public final void writeLong(long val){
		//Formerly a native function
		//Return nothing
		addTaint(val);
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final void writeFloat(float val){
		//Formerly a native function
		//Return nothing
		addTaint(val);
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public final void writeDouble(double val){
		//Formerly a native function
		//Return nothing
		addTaint((float)val);
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public final void writeString(String val){
		//Formerly a native function
		//Return nothing
		mValueString = val;
	}
    
    public final void writeCharSequence(CharSequence val){
		mValueCharSequence = val;
		// Original method
		/*
		{
        TextUtils.writeToParcel(val, this, 0);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final void writeStrongBinder(IBinder val){
		mValueIBinder = val;
		//Formerly a native function
		//Return nothing
	}
    
    public final void writeStrongInterface(IInterface val){
		mValueIInterface = val;
		// Original method
		/*
		{
        writeStrongBinder(val == null ? null : val.asBinder());
    }
		*/
		//Return nothing
	}
    
    public final void writeFileDescriptor(FileDescriptor val){
		mValueFileDescriptor = val;
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeByte(byte val){
		addTaint(val);
		// Original method
		/*
		{
        writeInt(val);
    }
		*/
		//Return nothing
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public final void writeMap(Map val){
		mValueMap = val;
		// Original method
		/*
		{
        writeMapInternal((Map<String,Object>) val);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void writeMapInternal(Map<String,Object> val){
		mValueMap = val;
		// Original method
		/*
		{
        if (val == null) {
            writeInt(-1);
            return;
        }
        Set<Map.Entry<String,Object>> entries = val.entrySet();
        writeInt(entries.size());
        for (Map.Entry<String,Object> e : entries) {
            writeValue(e.getKey());
            writeValue(e.getValue());
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public final void writeBundle(Bundle val){
		mValueBundle = val;
		// Original method
		/*
		{
        if (val == null) {
            writeInt(-1);
            return;
        }
        val.writeToParcel(this, 0);
    }
		*/
		//Return nothing
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public final void writeList(List val){
		mValueList = val;
		// Original method
		/*
		{
        if (val == null) {
            writeInt(-1);
            return;
        }
        int N = val.size();
        int i=0;
        writeInt(N);
        while (i < N) {
            writeValue(val.get(i));
            i++;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeArray(Object[] val){
		mValueObjectArray = val;
		// Original method
		/*
		{
        if (val == null) {
            writeInt(-1);
            return;
        }
        int N = val.length;
        int i=0;
        writeInt(N);
        while (i < N) {
            writeValue(val[i]);
            i++;
        }
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeSparseArray(SparseArray<Object> val){
		mValueSparseArray = val;
		// Original method
		/*
		{
        if (val == null) {
            writeInt(-1);
            return;
        }
        int N = val.size();
        writeInt(N);
        int i=0;
        while (i < N) {
            writeInt(val.keyAt(i));
            writeValue(val.valueAt(i));
            i++;
        }
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeSparseBooleanArray(SparseBooleanArray val){
		mValueSparseBooleanArray = val;
		// Original method
		/*
		{
        if (val == null) {
            writeInt(-1);
            return;
        }
        int N = val.size();
        writeInt(N);
        int i=0;
        while (i < N) {
            writeInt(val.keyAt(i));
            writeByte((byte)(val.valueAt(i) ? 1 : 0));
            i++;
        }
    }
		*/
		//Return nothing
	}
    
    public final void writeBooleanArray(boolean[] val){
		mValueBooleanArray = val;
		// Original method
		/*
		{
        if (val != null) {
            int N = val.length;
            writeInt(N);
            for (int i=0; i<N; i++) {
                writeInt(val[i] ? 1 : 0);
            }
        } else {
            writeInt(-1);
        }
    }
		*/
		//Return nothing
	}
    
    public final boolean[] createBooleanArray(){
		return mValueBooleanArray;
		// Original method
		/*
		{
        int N = readInt();
        if (N >= 0 && N <= (dataAvail() >> 2)) {
            boolean[] val = new boolean[N];
            for (int i=0; i<N; i++) {
                val[i] = readInt() != 0;
            }
            return val;
        } else {
            return null;
        }
    }
		*/
	}
    
    public final void readBooleanArray(boolean[] val){
		val[0] = mValueBooleanArray[0]; //DSFIXME:  Is this the best way?
		// Original method
		/*
		{
        int N = readInt();
        if (N == val.length) {
            for (int i=0; i<N; i++) {
                val[i] = readInt() != 0;
            }
        } else {
            throw new RuntimeException("bad array lengths");
        }
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeCharArray(char[] val){
		mValueCharArray = val;
		// Original method
		/*
		{
        if (val != null) {
            int N = val.length;
            writeInt(N);
            for (int i=0; i<N; i++) {
                writeInt((int)val[i]);
            }
        } else {
            writeInt(-1);
        }
    }
		*/
		//Return nothing
	}
    
    public final char[] createCharArray(){
		return mValueCharArray;
		// Original method
		/*
		{
        int N = readInt();
        if (N >= 0 && N <= (dataAvail() >> 2)) {
            char[] val = new char[N];
            for (int i=0; i<N; i++) {
                val[i] = (char)readInt();
            }
            return val;
        } else {
            return null;
        }
    }
		*/
	}
    
    public final void readCharArray(char[] val){
		val[0] = mValueCharArray[0];
		// Original method
		/*
		{
        int N = readInt();
        if (N == val.length) {
            for (int i=0; i<N; i++) {
                val[i] = (char)readInt();
            }
        } else {
            throw new RuntimeException("bad array lengths");
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeIntArray(int[] val){
		mValueIntArray = val;
		// Original method
		/*
		{
        if (val != null) {
            int N = val.length;
            writeInt(N);
            for (int i=0; i<N; i++) {
                writeInt(val[i]);
            }
        } else {
            writeInt(-1);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public final int[] createIntArray(){
		return mValueIntArray;
		// Original method
		/*
		{
        int N = readInt();
        if (N >= 0 && N <= (dataAvail() >> 2)) {
            int[] val = new int[N];
            for (int i=0; i<N; i++) {
                val[i] = readInt();
            }
            return val;
        } else {
            return null;
        }
    }
		*/
	}
    
    public final void readIntArray(int[] val){
		val[0] = mValueIntArray[0];
		// Original method
		/*
		{
        int N = readInt();
        if (N == val.length) {
            for (int i=0; i<N; i++) {
                val[i] = readInt();
            }
        } else {
            throw new RuntimeException("bad array lengths");
        }
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeLongArray(long[] val){
		mValueLongArray = val;
		// Original method
		/*
		{
        if (val != null) {
            int N = val.length;
            writeInt(N);
            for (int i=0; i<N; i++) {
                writeLong(val[i]);
            }
        } else {
            writeInt(-1);
        }
    }
		*/
		//Return nothing
	}
    
    public final long[] createLongArray(){
		return mValueLongArray;
		// Original method
		/*
		{
        int N = readInt();
        if (N >= 0 && N <= (dataAvail() >> 3)) {
            long[] val = new long[N];
            for (int i=0; i<N; i++) {
                val[i] = readLong();
            }
            return val;
        } else {
            return null;
        }
    }
		*/
	}
    
    public final void readLongArray(long[] val){
		val[0] = mValueLongArray[0];
		// Original method
		/*
		{
        int N = readInt();
        if (N == val.length) {
            for (int i=0; i<N; i++) {
                val[i] = readLong();
            }
        } else {
            throw new RuntimeException("bad array lengths");
        }
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeFloatArray(float[] val){
		mValueFloatArray = val;
		// Original method
		/*
		{
        if (val != null) {
            int N = val.length;
            writeInt(N);
            for (int i=0; i<N; i++) {
                writeFloat(val[i]);
            }
        } else {
            writeInt(-1);
        }
    }
		*/
		//Return nothing
	}
    
    public final float[] createFloatArray(){
		return mValueFloatArray;
		// Original method
		/*
		{
        int N = readInt();
        if (N >= 0 && N <= (dataAvail() >> 2)) {
            float[] val = new float[N];
            for (int i=0; i<N; i++) {
                val[i] = readFloat();
            }
            return val;
        } else {
            return null;
        }
    }
		*/
	}
    
    public final void readFloatArray(float[] val){
		val[0] = mValueFloatArray[0];
		// Original method
		/*
		{
        int N = readInt();
        if (N == val.length) {
            for (int i=0; i<N; i++) {
                val[i] = readFloat();
            }
        } else {
            throw new RuntimeException("bad array lengths");
        }
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeDoubleArray(double[] val){
		mValueDoubleArray = val;
		// Original method
		/*
		{
        if (val != null) {
            int N = val.length;
            writeInt(N);
            for (int i=0; i<N; i++) {
                writeDouble(val[i]);
            }
        } else {
            writeInt(-1);
        }
    }
		*/
		//Return nothing
	}
    
    public final double[] createDoubleArray(){
		return mValueDoubleArray;
		// Original method
		/*
		{
        int N = readInt();
        if (N >= 0 && N <= (dataAvail() >> 3)) {
            double[] val = new double[N];
            for (int i=0; i<N; i++) {
                val[i] = readDouble();
            }
            return val;
        } else {
            return null;
        }
    }
		*/
	}
    
    public final void readDoubleArray(double[] val){
		val[0] = mValueDoubleArray[0];
		// Original method
		/*
		{
        int N = readInt();
        if (N == val.length) {
            for (int i=0; i<N; i++) {
                val[i] = readDouble();
            }
        } else {
            throw new RuntimeException("bad array lengths");
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeStringArray(String[] val){
		mValueStringArray = val;
		// Original method
		/*
		{
        if (val != null) {
            int N = val.length;
            writeInt(N);
            for (int i=0; i<N; i++) {
                writeString(val[i]);
            }
        } else {
            writeInt(-1);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public final String[] createStringArray(){
		return mValueStringArray;
		// Original method
		/*
		{
        int N = readInt();
        if (N >= 0) {
            String[] val = new String[N];
            for (int i=0; i<N; i++) {
                val[i] = readString();
            }
            return val;
        } else {
            return null;
        }
    }
		*/
	}
    
    public final void readStringArray(String[] val){
		val[0] = mValueStringArray[0];
		// Original method
		/*
		{
        int N = readInt();
        if (N == val.length) {
            for (int i=0; i<N; i++) {
                val[i] = readString();
            }
        } else {
            throw new RuntimeException("bad array lengths");
        }
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeBinderArray(IBinder[] val){
		mValueIBinderArray = val;
		// Original method
		/*
		{
        if (val != null) {
            int N = val.length;
            writeInt(N);
            for (int i=0; i<N; i++) {
                writeStrongBinder(val[i]);
            }
        } else {
            writeInt(-1);
        }
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeCharSequenceArray(CharSequence[] val){
		mValueCharSequenceArray = val;
		// Original method
		/*
		{
        if (val != null) {
            int N = val.length;
            writeInt(N);
            for (int i=0; i<N; i++) {
                writeCharSequence(val[i]);
            }
        } else {
            writeInt(-1);
        }
    }
		*/
		//Return nothing
	}
    
    public final IBinder[] createBinderArray(){
		return mValueIBinderArray;
		// Original method
		/*
		{
        int N = readInt();
        if (N >= 0) {
            IBinder[] val = new IBinder[N];
            for (int i=0; i<N; i++) {
                val[i] = readStrongBinder();
            }
            return val;
        } else {
            return null;
        }
    }
		*/
	}
    
    public final void readBinderArray(IBinder[] val){
		val[0] = mValueIBinderArray[0];
		// Original method
		/*
		{
        int N = readInt();
        if (N == val.length) {
            for (int i=0; i<N; i++) {
                val[i] = readStrongBinder();
            }
        } else {
            throw new RuntimeException("bad array lengths");
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public final <T extends Parcelable> void writeTypedList(List<T> val) {
		mValueTypedList = (List<Parcelable>) val;
		// Original method
		/*
		{
        if (val == null) {
            writeInt(-1);
            return;
        }
        int N = val.size();
        int i=0;
        writeInt(N);
        while (i < N) {
            T item = val.get(i);
            if (item != null) {
                writeInt(1);
                item.writeToParcel(this, 0);
            } else {
                writeInt(0);
            }
            i++;
        }
    }
		*/
		//Return nothing
	}
    
    public final void writeStringList(List<String> val){
		mValueStringList = val;
		// Original method
		/*
		{
        if (val == null) {
            writeInt(-1);
            return;
        }
        int N = val.size();
        int i=0;
        writeInt(N);
        while (i < N) {
            writeString(val.get(i));
            i++;
        }
    }
		*/
		//Return nothing
	}
    
    public final void writeBinderList(List<IBinder> val){
		mValueIBinderList = val;
		// Original method
		/*
		{
        if (val == null) {
            writeInt(-1);
            return;
        }
        int N = val.size();
        int i=0;
        writeInt(N);
        while (i < N) {
            writeStrongBinder(val.get(i));
            i++;
        }
    }
		*/
		//Return nothing
	}
    
    public final <T extends Parcelable> void writeTypedArray(T[] val,
            int parcelableFlags){
		mValueTypedArray = val;
		// Original method
		/*
		{
        if (val != null) {
            int N = val.length;
            writeInt(N);
            for (int i=0; i<N; i++) {
                T item = val[i];
                if (item != null) {
                    writeInt(1);
                    item.writeToParcel(this, parcelableFlags);
                } else {
                    writeInt(0);
                }
            }
        } else {
            writeInt(-1);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeValue(Object v){
		mValueObject = v;
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Data serialization/deserialization")
    @DSSpec(DSCat.SERIALIZATION)
    public final void writeParcelable(Parcelable p, int parcelableFlags){
		mValueParcelable = p;
		// Original method
		/*
		{
        if (p == null) {
            writeString(null);
            return;
        }
        String name = p.getClass().getName();
        writeString(name);
        p.writeToParcel(this, parcelableFlags);
    }
		*/
		//Return nothing
	}
    
    public final void writeSerializable(Serializable s){
		mValueSerializable = s;
		// Original method
		/*
		{
        if (s == null) {
            writeString(null);
            return;
        }
        String name = s.getClass().getName();
        writeString(name);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(s);
            oos.close();
            writeByteArray(baos.toByteArray());
        } catch (IOException ioe) {
            throw new RuntimeException("Parcelable encountered " +
                "IOException writing serializable object (name = " + name +
                ")", ioe);
        }
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public final void writeException(Exception e){
		mValueException = e;
		// Original method
		/*
		{
        int code = 0;
        if (e instanceof SecurityException) {
            code = EX_SECURITY;
        } else if (e instanceof BadParcelableException) {
            code = EX_BAD_PARCELABLE;
        } else if (e instanceof IllegalArgumentException) {
            code = EX_ILLEGAL_ARGUMENT;
        } else if (e instanceof NullPointerException) {
            code = EX_NULL_POINTER;
        } else if (e instanceof IllegalStateException) {
            code = EX_ILLEGAL_STATE;
        }
        writeInt(code);
        StrictMode.clearGatheredViolations();
        if (code == 0) {
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            }
            throw new RuntimeException(e);
        }
        writeString(e.getMessage());
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final void writeNoException(){
		// Original method
		/*
		{
        if (StrictMode.hasGatheredViolations()) {
            writeInt(EX_HAS_REPLY_HEADER);
            final int sizePosition = dataPosition();
            writeInt(0);  
            StrictMode.writeGatheredViolationsToParcel(this);
            final int payloadPosition = dataPosition();
            setDataPosition(sizePosition);
            writeInt(payloadPosition - sizePosition);  
            setDataPosition(payloadPosition);
        } else {
            writeInt(0);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final void readException(){
		// Original method
		/*
		{
        int code = readExceptionCode();
        if (code != 0) {
            String msg = readString();
            readException(code, msg);
        }
    }
		*/
		//Return nothing
	}
    
    public final int readExceptionCode(){
		return getTaintInt();
		// Original method
		/*
		{
        int code = readInt();
        if (code == EX_HAS_REPLY_HEADER) {
            int headerSize = readInt();
            if (headerSize == 0) {
                Log.e(TAG, "Unexpected zero-sized Parcel reply header.");
            } else {
                StrictMode.readAndHandleBinderCallViolations(this);
            }
            return 0;
        }
        return code;
    }
		*/
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final void readException(int code, String msg){
		// Original method
		/*
		{
        switch (code) {
            case EX_SECURITY:
                throw new SecurityException(msg);
            case EX_BAD_PARCELABLE:
                throw new BadParcelableException(msg);
            case EX_ILLEGAL_ARGUMENT:
                throw new IllegalArgumentException(msg);
            case EX_NULL_POINTER:
                throw new NullPointerException(msg);
            case EX_ILLEGAL_STATE:
                throw new IllegalStateException(msg);
        }
        throw new RuntimeException("Unknown exception code: " + code
                + " msg " + msg);
    }
		*/
		//Return nothing
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final int readInt(){
		//Formerly a native function
		return getTaintInt();
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public final long readLong(){
		//Formerly a native function
		return getTaintInt();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final float readFloat(){
		//Formerly a native function
		return getTaintFloat();
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public final double readDouble(){
		//Formerly a native function
		return getTaintDouble();
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final String readString(){
		//Formerly a native function
		return mValueString;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final CharSequence readCharSequence(){
		return mValueCharSequence;
		// Original method
		/*
		{
        return TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this);
    }
		*/
	}
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public final IBinder readStrongBinder(){
		//Formerly a native function
		return mValueIBinder;
	}
    
    public final ParcelFileDescriptor readFileDescriptor(){
		return new ParcelFileDescriptor(mValueFileDescriptor);
		// Original method
		/*
		{
        FileDescriptor fd = internalReadFileDescriptor();
        return fd != null ? new ParcelFileDescriptor(fd) : null;
    }
		*/
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private FileDescriptor internalReadFileDescriptor(){
		//Formerly a native function
		return mValueFileDescriptor;
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public final byte readByte(){
		return (byte)getTaintInt();
		// Original method
		/*
		{
        return (byte)(readInt() & 0xff);
    }
		*/
	}
    
    public final void readMap(Map outVal, ClassLoader loader){
		//DSFIXME:  This is going to be difficult to track taint on.  If something
		//calls this function, try and avoid the call and track taint in the higher
		//level call.
		outVal.putAll(mValueMap);
		// Original method
		/*
		{
        int N = readInt();
        readMapInternal(outVal, N, loader);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    public final void readList(List outVal, ClassLoader loader){
		outVal.addAll(mValueList);
		// Original method
		/*
		{
        int N = readInt();
        readListInternal(outVal, N, loader);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    public final HashMap readHashMap(ClassLoader loader){
		return (HashMap)mValueMap;
		// Original method
		/*
		{
        int N = readInt();
        if (N < 0) {
            return null;
        }
        HashMap m = new HashMap(N);
        readMapInternal(m, N, loader);
        return m;
    }
		*/
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public final Bundle readBundle(){
		return mValueBundle;
		// Original method
		/*
		{
        return readBundle(null);
    }
		*/
	}
    
    public final Bundle readBundle(ClassLoader loader){
		return mValueBundle;
		// Original method
		/*
		{
        int length = readInt();
        if (length < 0) {
            return null;
        }
        final Bundle bundle = new Bundle(this, length);
        if (loader != null) {
            bundle.setClassLoader(loader);
        }
        return bundle;
    }
		*/
	}
    
    @DSComment("check any serialization")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final byte[] createByteArray(){
		//Formerly a native function
		return mValueByteArray;
	}
    
    public final void readByteArray(byte[] val){
		val[0] = mValueByteArray[0];
		// Original method
		/*
		{
        byte[] ba = createByteArray();
        if (ba.length == val.length) {
           System.arraycopy(ba, 0, val, 0, ba.length);
        } else {
            throw new RuntimeException("bad array lengths");
        }
    }
		*/
		//Return nothing
	}
    
    public final String[] readStringArray(){
		return mValueStringArray;
		// Original method
		/*
		{
        String[] array = null;
        int length = readInt();
        if (length >= 0)
        {
            array = new String[length];
            for (int i = 0 ; i < length ; i++)
            {
                array[i] = readString();
            }
        }
        return array;
    }
		*/
	}
    
    public final CharSequence[] readCharSequenceArray(){
		return mValueCharSequenceArray;
		// Original method
		/*
		{
        CharSequence[] array = null;
        int length = readInt();
        if (length >= 0)
        {
            array = new CharSequence[length];
            for (int i = 0 ; i < length ; i++)
            {
                array[i] = readCharSequence();
            }
        }
        return array;
    }
		*/
	}
    
    public final ArrayList readArrayList(ClassLoader loader){
		return (ArrayList) mValueList;
		// Original method
		/*
		{
        int N = readInt();
        if (N < 0) {
            return null;
        }
        ArrayList l = new ArrayList(N);
        readListInternal(l, N, loader);
        return l;
    }
		*/
	}
    
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    public final Object[] readArray(ClassLoader loader){
		return mValueObjectArray;
		// Original method
		/*
		{
        int N = readInt();
        if (N < 0) {
            return null;
        }
        Object[] l = new Object[N];
        readArrayInternal(l, N, loader);
        return l;
    }
		*/
	}
    
    public final SparseArray readSparseArray(ClassLoader loader){
		return mValueSparseArray;
		// Original method
		/*
		{
        int N = readInt();
        if (N < 0) {
            return null;
        }
        SparseArray sa = new SparseArray(N);
        readSparseArrayInternal(sa, N, loader);
        return sa;
    }
		*/
	}
    
    public final SparseBooleanArray readSparseBooleanArray(){
		return mValueSparseBooleanArray;
		// Original method
		/*
		{
        int N = readInt();
        if (N < 0) {
            return null;
        }
        SparseBooleanArray sa = new SparseBooleanArray(N);
        readSparseBooleanArrayInternal(sa, N);
        return sa;
    }
		*/
	}
    
    public final <T> ArrayList<T> createTypedArrayList(Parcelable.Creator<T> c) {
		return (ArrayList<T>)mValueList;
		// Original method
		/*
		{
        int N = readInt();
        if (N < 0) {
            return null;
        }
        ArrayList<T> l = new ArrayList<T>(N);
        while (N > 0) {
            if (readInt() != 0) {
                l.add(c.createFromParcel(this));
            } else {
                l.add(null);
            }
            N--;
        }
        return l;
    }
		*/
	}
    
    public final <T> void readTypedList(List<T> list, Parcelable.Creator<T> c) {
		list.addAll(mValueList);
		// Original method
		/*
		{
        int M = list.size();
        int N = readInt();
        int i = 0;
        for (; i < M && i < N; i++) {
            if (readInt() != 0) {
                list.set(i, c.createFromParcel(this));
            } else {
                list.set(i, null);
            }
        }
        for (; i<N; i++) {
            if (readInt() != 0) {
                list.add(c.createFromParcel(this));
            } else {
                list.add(null);
            }
        }
        for (; i<M; i++) {
            list.remove(N);
        }
    }
		*/
		//Return nothing
	}
    
    public final ArrayList<String> createStringArrayList(){
		return (ArrayList)mValueStringList;
		// Original method
		/*
		{
        int N = readInt();
        if (N < 0) {
            return null;
        }
        ArrayList<String> l = new ArrayList<String>(N);
        while (N > 0) {
            l.add(readString());
            N--;
        }
        return l;
    }
		*/
	}
    
    public final ArrayList<IBinder> createBinderArrayList(){
		return (ArrayList<IBinder>)this.mValueIBinderList;
		// Original method
		/*
		{
        int N = readInt();
        if (N < 0) {
            return null;
        }
        ArrayList<IBinder> l = new ArrayList<IBinder>(N);
        while (N > 0) {
            l.add(readStrongBinder());
            N--;
        }
        return l;
    }
		*/
	}
    
    public final void readStringList(List<String> list){
		list.addAll(this.mValueStringList);
		// Original method
		/*
		{
        int M = list.size();
        int N = readInt();
        int i = 0;
        for (; i < M && i < N; i++) {
            list.set(i, readString());
        }
        for (; i<N; i++) {
            list.add(readString());
        }
        for (; i<M; i++) {
            list.remove(N);
        }
    }
		*/
		//Return nothing
	}
    
    public final void readBinderList(List<IBinder> list){
		list.addAll(mValueIBinderList);
		// Original method
		/*
		{
        int M = list.size();
        int N = readInt();
        int i = 0;
        for (; i < M && i < N; i++) {
            list.set(i, readStrongBinder());
        }
        for (; i<N; i++) {
            list.add(readStrongBinder());
        }
        for (; i<M; i++) {
            list.remove(N);
        }
    }
		*/
		//Return nothing
	}
    
    public final <T> T[] createTypedArray(Parcelable.Creator<T> c) {
		return (T[]) this.mValueTypedArray;
		// Original method
		/*
		{
        int N = readInt();
        if (N < 0) {
            return null;
        }
        T[] l = c.newArray(N);
        for (int i=0; i<N; i++) {
            if (readInt() != 0) {
                l[i] = c.createFromParcel(this);
            }
        }
        return l;
    }
		*/
	}
    
    public final <T> void readTypedArray(T[] val, Parcelable.Creator<T> c) {
		val[0] = (T) this.mValueTypedArray[0];
		// Original method
		/*
		{
        int N = readInt();
        if (N == val.length) {
            for (int i=0; i<N; i++) {
                if (readInt() != 0) {
                    val[i] = c.createFromParcel(this);
                } else {
                    val[i] = null;
                }
            }
        } else {
            throw new RuntimeException("bad array lengths");
        }
    }
		*/
		//Return nothing
	}
    
    @Deprecated public final <T> T[] readTypedArray(Parcelable.Creator<T> c) {
		return createTypedArray(c);
		// Original method
		/*
		{
        return createTypedArray(c);
    }
		*/
	}
    
    public final <T extends Parcelable> void writeParcelableArray(T[] value,
            int parcelableFlags){
		mValueParcelableArray = value;
		// Original method
		/*
		{
        if (value != null) {
            int N = value.length;
            writeInt(N);
            for (int i=0; i<N; i++) {
                writeParcelable(value[i], parcelableFlags);
            }
        } else {
            writeInt(-1);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final Object readValue(ClassLoader loader){
		return mValueObject;
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}
    
    public final <T extends Parcelable> T readParcelable(ClassLoader loader) {
		return (T) mValueParcelable;
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}
    
    public final Parcelable[] readParcelableArray(ClassLoader loader){
		return mValueParcelableArray;
		// Original method
		/*
		{
        int N = readInt();
        if (N < 0) {
            return null;
        }
        Parcelable[] p = new Parcelable[N];
        for (int i = 0; i < N; i++) {
            p[i] = (Parcelable) readParcelable(loader);
        }
        return p;
    }
		*/
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final Serializable readSerializable(){
		return mValueSerializable;
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}
    
    @Override protected void finalize(){
		destroy();
		// Original method
		/*
		{
        if (DEBUG_RECYCLE) {
            if (mStack != null) {
                Log.w(TAG, "Client did not call Parcel.recycle()", mStack);
            }
        }
        destroy();
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void freeBuffer(){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void init(int obj){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void destroy(){
		//Formerly a native function
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void readMapInternal(Map outVal, int N,
        ClassLoader loader){
		// Original method
		/*
		{
        while (N > 0) {
            Object key = readValue(loader);
            Object value = readValue(loader);
            outVal.put(key, value);
            N--;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void readListInternal(List outVal, int N,
        ClassLoader loader){
		// Original method
		/*
		{
        while (N > 0) {
            Object value = readValue(loader);
            outVal.add(value);
            N--;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void readArrayInternal(Object[] outVal, int N,
        ClassLoader loader){
		// Original method
		/*
		{
        for (int i = 0; i < N; i++) {
            Object value = readValue(loader);
            outVal[i] = value;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void readSparseArrayInternal(SparseArray outVal, int N,
        ClassLoader loader){
		// Original method
		/*
		{
        while (N > 0) {
            int key = readInt();
            Object value = readValue(loader);
            outVal.append(key, value);
            N--;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void readSparseBooleanArrayInternal(SparseBooleanArray outVal, int N){
		// Original method
		/*
		{
        while (N > 0) {
            int key = readInt();
            boolean value = this.readByte() == 1;
            outVal.append(key, value);
            N--;
        }
    }
		*/
		//Return nothing
	}
    
}

