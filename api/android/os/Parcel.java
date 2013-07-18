package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Parcel {
    @SuppressWarnings({"UnusedDeclaration"})
    private int mObject;
    @SuppressWarnings({"UnusedDeclaration"})
    private int mOwnObject;
    private RuntimeException mStack;
    
    private Parcel(int obj){
		init(obj);
		/*
		if (DEBUG_RECYCLE) {
            mStack = new RuntimeException();
        }
		init(obj);
		*/
	}

    
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

    
    public final int dataPosition(){
		//Formerly a native function
		return getTaintInt();
	}

    
    public final int dataCapacity(){
		//Formerly a native function
		return getTaintInt();
	}

    
    public final void setDataSize(int size){
		//Formerly a native function
		//Return nothing
		addTaint(size);
	}

    
    public final void setDataPosition(int pos){
		//Formerly a native function
		//Return nothing
		addTaint(pos);
	}

    
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

    
    public final void writeInterfaceToken(String interfaceName){
		//Formerly a native function
		//Return nothing
		addTaint(interfaceName.getTaint());
	}

    
    public final void enforceInterface(String interfaceName){
		//Formerly a native function
		//Return nothing
		addTaint(interfaceName.getTaint());
	}

    
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

    
    private void writeNative(byte[] b, int offset, int len){
		mValueByteArray = b;
		//Formerly a native function
		//Return nothing
	}

    
    public final void writeInt(int val){
		//Formerly a native function
		//Return nothing
		addTaint(val);
	}

    
    public final void writeLong(long val){
		//Formerly a native function
		//Return nothing
		addTaint(val);
	}

    
    public final void writeFloat(float val){
		//Formerly a native function
		//Return nothing
		addTaint(val);
	}

    
    public final void writeDouble(double val){
		//Formerly a native function
		//Return nothing
		addTaint((float)val);
	}

    
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

    
    public final void writeValue(Object v){
		mValueObject = v;
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
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

    
    public final int readInt(){
		//Formerly a native function
		return getTaintInt();
	}

    
    public final long readLong(){
		//Formerly a native function
		return getTaintInt();
	}

    
    public final float readFloat(){
		//Formerly a native function
		return getTaintFloat();
	}

    
    public final double readDouble(){
		//Formerly a native function
		return 0;
	}

    
    public final String readString(){
		//Formerly a native function
		return mValueString;
	}

    
    public final CharSequence readCharSequence(){
		return mValueCharSequence;
		// Original method
		/*
		{
        return TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this);
    }
		*/
	}

    
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

    
    private FileDescriptor internalReadFileDescriptor(){
		//Formerly a native function
		return mValueFileDescriptor;
	}

    
    static FileDescriptor openFileDescriptor(String file,
            int mode){
		//Formerly a native function
		return new FileDescriptor();
	}

    
    static FileDescriptor dupFileDescriptor(FileDescriptor orig){
		//Formerly a native function
		return orig;
	}

    
    static void closeFileDescriptor(FileDescriptor desc){
		//Formerly a native function
		//Return nothing
	}

    
    static void clearFileDescriptor(FileDescriptor desc){
		//Formerly a native function
		//Return nothing
	}

    
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

    
    public final Serializable readSerializable(){
		return mValueSerializable;
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}

    
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

    
    private void freeBuffer(){
		//Formerly a native function
		//Return nothing
	}

    
    private void init(int obj){
		//Formerly a native function
		//Return nothing
	}

    
    private void destroy(){
		//Formerly a native function
		//Return nothing
	}

    
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

    
    private static final boolean DEBUG_RECYCLE = false;
    private static final String TAG = "Parcel";
    private static final int POOL_SIZE = 6;
    private static final Parcel[] sOwnedPool = new Parcel[POOL_SIZE];
    private static final Parcel[] sHolderPool = new Parcel[POOL_SIZE];
    private static final int VAL_NULL = -1;
    private static final int VAL_STRING = 0;
    private static final int VAL_INTEGER = 1;
    private static final int VAL_MAP = 2;
    private static final int VAL_BUNDLE = 3;
    private static final int VAL_PARCELABLE = 4;
    private static final int VAL_SHORT = 5;
    private static final int VAL_LONG = 6;
    private static final int VAL_FLOAT = 7;
    private static final int VAL_DOUBLE = 8;
    private static final int VAL_BOOLEAN = 9;
    private static final int VAL_CHARSEQUENCE = 10;
    private static final int VAL_LIST  = 11;
    private static final int VAL_SPARSEARRAY = 12;
    private static final int VAL_BYTEARRAY = 13;
    private static final int VAL_STRINGARRAY = 14;
    private static final int VAL_IBINDER = 15;
    private static final int VAL_PARCELABLEARRAY = 16;
    private static final int VAL_OBJECTARRAY = 17;
    private static final int VAL_INTARRAY = 18;
    private static final int VAL_LONGARRAY = 19;
    private static final int VAL_BYTE = 20;
    private static final int VAL_SERIALIZABLE = 21;
    private static final int VAL_SPARSEBOOLEANARRAY = 22;
    private static final int VAL_BOOLEANARRAY = 23;
    private static final int VAL_CHARSEQUENCEARRAY = 24;
    private static final int EX_SECURITY = -1;
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_HAS_REPLY_HEADER = -128;
    public final static Parcelable.Creator<String> STRING_CREATOR
             = new Parcelable.Creator<String>() {
        public String createFromParcel(Parcel source) {
            return source.readString();
        }
        public String[] newArray(int size) {
            return new String[size];
        }
    };
    private static final HashMap<ClassLoader,HashMap<String,Parcelable.Creator>>
        mCreators = new HashMap<ClassLoader,HashMap<String,Parcelable.Creator>>();
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
    
}

