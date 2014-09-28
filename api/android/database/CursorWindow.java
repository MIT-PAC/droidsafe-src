package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.res.Resources;
import android.database.sqlite.SQLiteClosable;
import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import android.util.SparseIntArray;
import dalvik.system.CloseGuard;

import droidsafe.helpers.DSUtils;

public class CursorWindow extends SQLiteClosable implements Parcelable {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCreate(String name, int cursorWindowSize) {
        return (cursorWindowSize + name.getTaintInt());
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCreateFromParcel(Parcel parcel) {
        return parcel.getTaintInt();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeDispose(int windowPtr) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeWriteToParcel(int windowPtr, Parcel parcel) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeClear(int windowPtr) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetNumRows(int windowPtr) {
        return windowPtr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeSetNumColumns(int windowPtr, int columnNum) {
        return toTaintBoolean(windowPtr + columnNum);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativeAllocRow(int windowPtr) {
        return toTaintBoolean(windowPtr); 
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeFreeLastRow(int windowPtr) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeGetType(int windowPtr, int row, int column) {
        return (windowPtr + row + column);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static byte[] nativeGetBlob(int windowPtr, int row, int column) {
        byte[] ret = {(byte)windowPtr};
        ret.addTaint(row + windowPtr + column);
        return ret;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String nativeGetString(int windowPtr, int row, int column) {
        	String ret = new String();
        	ret.addTaint(windowPtr);
        	ret.addTaint(row);
        	ret.addTaint(column);
        	return ret;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static long nativeGetLong(int windowPtr, int row, int column) {
        return (windowPtr + row + column);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static double nativeGetDouble(int windowPtr, int row, int column) {
        return (windowPtr + row + column);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void nativeCopyStringToBuffer(int windowPtr, int row, int column,
            CharArrayBuffer buffer) {

        buffer.addTaint(windowPtr + row + column);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativePutBlob(int windowPtr, byte[] value, int row, int column) {
        return toTaintBoolean(windowPtr + value[0] + row + column + value.getTaintInt());
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativePutString(int windowPtr, String value, int row, int column) {
        return toTaintBoolean(windowPtr + row + column + value.getTaintInt());
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativePutLong(int windowPtr, long value, int row, int column) {
        return toTaintBoolean(windowPtr + row + column + (int)value);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativePutDouble(int windowPtr, double value, int row, int column) {
        return toTaintBoolean(value + windowPtr + row + column );
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean nativePutNull(int windowPtr, int row, int column) {
        return toTaintBoolean(windowPtr + row + column); 
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String nativeGetName(int windowPtr) {
        	String ret =  new String();
        	ret.addTaint(windowPtr);
        	return ret;
    }

    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.238 -0500", hash_original_method = "82A0D8881224A345C7D71889E82FF712", hash_generated_method = "A1F37DF171B5E56C3C2502ADC2995201")
    
public static CursorWindow newFromParcel(Parcel p) {
        return CREATOR.createFromParcel(p);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.040 -0500", hash_original_field = "A7166D91DB41667EF8254B5234098D82", hash_generated_field = "8D10DBBD9161B24BFA923BA8ACB7AE58")

    private static final String STATS_TAG = "CursorWindowStats";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.043 -0500", hash_original_field = "736ADF51A5EC4C83BDF0956352AC8774", hash_generated_field = "BA4FA4A72DC6187CE1C91540199A8E43")

    private static final int sCursorWindowSize =
        Resources.getSystem().getInteger(
                com.android.internal.R.integer.config_cursorWindowSize) * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.754 -0400", hash_original_field = "F4DD3BCA06A6A101A72063C4264660FF", hash_generated_field = "9DA0907775B4EA7DABCE5B56F25B0D3B")

    public static final Parcelable.Creator<CursorWindow> CREATOR
            = new Parcelable.Creator<CursorWindow>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.231 -0500", hash_original_method = "102321E705544E214630A229EBF0AAEA", hash_generated_method = "4EF24EDFF7228ACE6A321698F5E75C1C")
        
public CursorWindow createFromParcel(Parcel source) {
            return new CursorWindow(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.233 -0500", hash_original_method = "22E812BCDE3BA2EC64FA32FE6BB196D2", hash_generated_method = "7007332CAB8AA9734B856C702FF5E16B")
        
public CursorWindow[] newArray(int size) {
            return new CursorWindow[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.249 -0500", hash_original_field = "68CAF1AEF11BFE5DB8C3B09DCA26B261", hash_generated_field = "E194A8535700746837F74D9B692D7DA6")

    private static final SparseIntArray sWindowToPidMap = new SparseIntArray();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.045 -0500", hash_original_field = "893E6C712A17C3652D97D287CE28196E", hash_generated_field = "38FB3A768EF6B5DA39D97BE6BF469283")

    public int mWindowPtr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.047 -0500", hash_original_field = "69DB1DFF5A463D0BEC5675381B562FE3", hash_generated_field = "D37936E7DE7BA2848F09C9211D0F059F")

    private int mStartPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.050 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private  String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.052 -0500", hash_original_field = "6ADAA7D7C1C7D2FB7CE0E7D55A51778B", hash_generated_field = "91705AACD6DDE42AEA628776AF2A3DC6")

    private final CloseGuard mCloseGuard = CloseGuard.get();

    /**
     * Creates a new empty cursor window and gives it a name.
     * <p>
     * The cursor initially has no rows or columns.  Call {@link #setNumColumns(int)} to
     * set the number of columns before adding any rows to the cursor.
     * </p>
     *
     * @param name The name of the cursor window, or null if none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.145 -0500", hash_original_method = "D2526397A12BC25EA910BA6CE9A2504E", hash_generated_method = "562F496DEE1D9893E01E45C945CBDCC4")
    
public CursorWindow(String name) {
        mStartPos = 0;
        mName = name;
        mWindowPtr = nativeCreate(name, sCursorWindowSize);
        if (mWindowPtr == 0) {
            throw new CursorWindowAllocationException("Cursor window allocation of " +
                    (sCursorWindowSize / 1024) + " kb failed. " + printStats());
        }
        mCloseGuard.open("close");
        recordNewWindow(Binder.getCallingPid(), mWindowPtr);
    }

    /**
     * Creates a new empty cursor window.
     * <p>
     * The cursor initially has no rows or columns.  Call {@link #setNumColumns(int)} to
     * set the number of columns before adding any rows to the cursor.
     * </p>
     *
     * @param localWindow True if this window will be used in this process only,
     * false if it might be sent to another processes.  This argument is ignored.
     *
     * @deprecated There is no longer a distinction between local and remote
     * cursor windows.  Use the {@link #CursorWindow(String)} constructor instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.148 -0500", hash_original_method = "CB3D999FBD9663B85250B0069300DD19", hash_generated_method = "D07FD54D6A151858FD91893AD7864534")
    
@Deprecated
    public CursorWindow(boolean localWindow) {
        this((String)null);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.151 -0500", hash_original_method = "2F52A6C89F1D54A86C82C46FF5E1EC25", hash_generated_method = "E11F5BE39FF20AEE597FBD9394CE1422")
    
private CursorWindow(Parcel source) {
        mStartPos = source.readInt();
        mWindowPtr = nativeCreateFromParcel(source);
        if (mWindowPtr == 0) {
            throw new CursorWindowAllocationException("Cursor window could not be "
                    + "created from binder.");
        }
        mName = nativeGetName(mWindowPtr);
        mCloseGuard.open("close");
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.154 -0500", hash_original_method = "896D51A0732498DB684FD2752503707E", hash_generated_method = "DC61EEB9399D0C81EB1A9EBE11C86572")
    
@Override
    protected void finalize() throws Throwable {
        try {
            if (mCloseGuard != null) {
                mCloseGuard.warnIfOpen();
            }
            dispose();
        } finally {
            super.finalize();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.156 -0500", hash_original_method = "DF965B7262A7C1EB6D66FE3F57E4031E", hash_generated_method = "7CCF55D494A31637CF54FDE61D52931F")
    
private void dispose() {
        if (mCloseGuard != null) {
            mCloseGuard.close();
        }
        if (mWindowPtr != 0) {
            recordClosingOfWindow(mWindowPtr);
            nativeDispose(mWindowPtr);
            mWindowPtr = 0;
        }
    }

    /**
     * Gets the name of this cursor window.
     * @hide
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.159 -0500", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "AD920925278DEAFAFBD283F9C2E39E5D")
    
public String getName() {
        return mName;
    }

    /**
     * Closes the cursor window and frees its underlying resources when all other
     * remaining references have been released.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.161 -0500", hash_original_method = "6B12CEFAA1DE3FB86CA989F7EF7D159A", hash_generated_method = "6FE183EFECC3E132BBD8E2651D9788EC")
    
public void close() {
        releaseReference();
    }

    /**
     * Clears out the existing contents of the window, making it safe to reuse
     * for new data.
     * <p>
     * The start position ({@link #getStartPosition()}), number of rows ({@link #getNumRows()}),
     * and number of columns in the cursor are all reset to zero.
     * </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.164 -0500", hash_original_method = "979E75E660A1C8BD17328FDD55823D54", hash_generated_method = "F995A3FAD29FFF94F5C8496867BF085D")
    
public void clear() {
        acquireReference();
        try {
            mStartPos = 0;
            nativeClear(mWindowPtr);
        } finally {
            releaseReference();
        }
    }

    /**
     * Gets the start position of this cursor window.
     * <p>
     * The start position is the zero-based index of the first row that this window contains
     * relative to the entire result set of the {@link Cursor}.
     * </p>
     *
     * @return The zero-based start position.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.166 -0500", hash_original_method = "E83B1D6D3C97BD3B3A2AA134F51457E7", hash_generated_method = "90B665CEA1F698FF9104B3B82D080E5C")
    
public int getStartPosition() {
        return mStartPos;
    }

    /**
     * Sets the start position of this cursor window.
     * <p>
     * The start position is the zero-based index of the first row that this window contains
     * relative to the entire result set of the {@link Cursor}.
     * </p>
     *
     * @param pos The new zero-based start position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.169 -0500", hash_original_method = "A3D22CBF25891D62569B204C4A11C84D", hash_generated_method = "C1850459B93D8B56A14989BF097B304E")
    
public void setStartPosition(int pos) {
        mStartPos = pos;
    }

    /**
     * Gets the number of rows in this window.
     *
     * @return The number of rows in this cursor window.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.172 -0500", hash_original_method = "FEBAC209BE2E731A41AC61FC29EF2631", hash_generated_method = "ABE8F052F2CDECAAA7EACF9221905F35")
    
public int getNumRows() {
        acquireReference();
        try {
            return nativeGetNumRows(mWindowPtr);
        } finally {
            releaseReference();
        }
    }

    /**
     * Sets the number of columns in this window.
     * <p>
     * This method must be called before any rows are added to the window, otherwise
     * it will fail to set the number of columns if it differs from the current number
     * of columns.
     * </p>
     *
     * @param columnNum The new number of columns.
     * @return True if successful.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.174 -0500", hash_original_method = "06070130EC2CA13555B4890F162F9E48", hash_generated_method = "19738671DDFC7425E8FF5F7C79B2DFEF")
    
public boolean setNumColumns(int columnNum) {
        acquireReference();
        try {
            return nativeSetNumColumns(mWindowPtr, columnNum);
        } finally {
            releaseReference();
        }
    }

    /**
     * Allocates a new row at the end of this cursor window.
     *
     * @return True if successful, false if the cursor window is out of memory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.176 -0500", hash_original_method = "EA2451DCCE3D57D72B2D978A02AB8CBE", hash_generated_method = "194B276AA366D5A4E4FE69CFF40373CA")
    
public boolean allocRow(){
        acquireReference();
        try {
            return nativeAllocRow(mWindowPtr);
        } finally {
            releaseReference();
        }
    }

    /**
     * Frees the last row in this cursor window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.178 -0500", hash_original_method = "B379FF08DED00763293DB0E42243B555", hash_generated_method = "518E2784EFC2CD38A3D0129BBD70C017")
    
public void freeLastRow(){
        acquireReference();
        try {
            nativeFreeLastRow(mWindowPtr);
        } finally {
            releaseReference();
        }
    }

    /**
     * Returns true if the field at the specified row and column index
     * has type {@link Cursor#FIELD_TYPE_NULL}.
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return True if the field has type {@link Cursor#FIELD_TYPE_NULL}.
     * @deprecated Use {@link #getType(int, int)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.181 -0500", hash_original_method = "49D7CBD5A9292352030392B89291BE3D", hash_generated_method = "F5F94197CDEBC16AD150ED490EE40334")
    
@Deprecated
    public boolean isNull(int row, int column) {
        return toTaintBoolean(getType(row, column) + Cursor.FIELD_TYPE_NULL);
    }

    /**
     * Returns true if the field at the specified row and column index
     * has type {@link Cursor#FIELD_TYPE_BLOB} or {@link Cursor#FIELD_TYPE_NULL}.
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return True if the field has type {@link Cursor#FIELD_TYPE_BLOB} or
     * {@link Cursor#FIELD_TYPE_NULL}.
     * @deprecated Use {@link #getType(int, int)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.183 -0500", hash_original_method = "C746642EB39EFB60299B9B6078CB8713", hash_generated_method = "455C44B1921BB51FD67693005A7A5E9B")
    
@Deprecated
    public boolean isBlob(int row, int column) {
        int type = getType(row, column);
        return toTaintBoolean(type + Cursor.FIELD_TYPE_BLOB + type + Cursor.FIELD_TYPE_NULL);
    }

    /**
     * Returns true if the field at the specified row and column index
     * has type {@link Cursor#FIELD_TYPE_INTEGER}.
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return True if the field has type {@link Cursor#FIELD_TYPE_INTEGER}.
     * @deprecated Use {@link #getType(int, int)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.187 -0500", hash_original_method = "F41C7C64C57B82BE924AB092481D8C56", hash_generated_method = "475BC3B851C306D19D6858E03AD853A6")
    
@Deprecated
    public boolean isLong(int row, int column) {
        return toTaintBoolean(getType(row, column) + Cursor.FIELD_TYPE_INTEGER);
    }

    /**
     * Returns true if the field at the specified row and column index
     * has type {@link Cursor#FIELD_TYPE_FLOAT}.
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return True if the field has type {@link Cursor#FIELD_TYPE_FLOAT}.
     * @deprecated Use {@link #getType(int, int)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.189 -0500", hash_original_method = "AB10FF6E7457EC84D59F089A4F39FCC7", hash_generated_method = "27742067F596BC19D1F5AC9C840A37C9")
    
@Deprecated
    public boolean isFloat(int row, int column) {
        return toTaintBoolean(getType(row, column) + Cursor.FIELD_TYPE_FLOAT);
    }

    /**
     * Returns true if the field at the specified row and column index
     * has type {@link Cursor#FIELD_TYPE_STRING} or {@link Cursor#FIELD_TYPE_NULL}.
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return True if the field has type {@link Cursor#FIELD_TYPE_STRING}
     * or {@link Cursor#FIELD_TYPE_NULL}.
     * @deprecated Use {@link #getType(int, int)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.192 -0500", hash_original_method = "235C1A23640EE5ABC2401DF58B1A3F61", hash_generated_method = "4999FB82FE3E87086F7ACE2C9471B2B1")
    
@Deprecated
    public boolean isString(int row, int column) {
        int type = getType(row, column);
        return toTaintBoolean(type + Cursor.FIELD_TYPE_STRING + type + Cursor.FIELD_TYPE_NULL);
    }

    /**
     * Returns the type of the field at the specified row and column index.
     * <p>
     * The returned field types are:
     * <ul>
     * <li>{@link Cursor#FIELD_TYPE_NULL}</li>
     * <li>{@link Cursor#FIELD_TYPE_INTEGER}</li>
     * <li>{@link Cursor#FIELD_TYPE_FLOAT}</li>
     * <li>{@link Cursor#FIELD_TYPE_STRING}</li>
     * <li>{@link Cursor#FIELD_TYPE_BLOB}</li>
     * </ul>
     * </p>
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return The field type.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.194 -0500", hash_original_method = "8E937452D8006A30B303869F5FCBB330", hash_generated_method = "E84D4E711B7A7E0C26A351CFC528A2C3")
    
public int getType(int row, int column) {
        acquireReference();
        try {
            return nativeGetType(mWindowPtr, row - mStartPos, column);
        } finally {
            releaseReference();
        }
    }

    /**
     * Gets the value of the field at the specified row and column index as a byte array.
     * <p>
     * The result is determined as follows:
     * <ul>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_NULL}, then the result
     * is <code>null</code>.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_BLOB}, then the result
     * is the blob value.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_STRING}, then the result
     * is the array of bytes that make up the internal representation of the
     * string value.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_INTEGER} or
     * {@link Cursor#FIELD_TYPE_FLOAT}, then a {@link SQLiteException} is thrown.</li>
     * </ul>
     * </p>
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return The value of the field as a byte array.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.197 -0500", hash_original_method = "369AEBF74D7711C2C086D87D281ECBA3", hash_generated_method = "8D17084AD2B218959D95C83ACA25D445")
    
public byte[] getBlob(int row, int column) {
        acquireReference();
        try {
            return nativeGetBlob(mWindowPtr, row - mStartPos, column);
        } finally {
            releaseReference();
        }
    }

    /**
     * Gets the value of the field at the specified row and column index as a string.
     * <p>
     * The result is determined as follows:
     * <ul>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_NULL}, then the result
     * is <code>null</code>.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_STRING}, then the result
     * is the string value.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_INTEGER}, then the result
     * is a string representation of the integer in decimal, obtained by formatting the
     * value with the <code>printf</code> family of functions using
     * format specifier <code>%lld</code>.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_FLOAT}, then the result
     * is a string representation of the floating-point value in decimal, obtained by
     * formatting the value with the <code>printf</code> family of functions using
     * format specifier <code>%g</code>.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_BLOB}, then a
     * {@link SQLiteException} is thrown.</li>
     * </ul>
     * </p>
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return The value of the field as a string.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.199 -0500", hash_original_method = "91E1480DC9AA77B4570FAB2ABB8DFF8A", hash_generated_method = "BD448898E1CEB8E1E549F06CCB9BA5AC")
    
public String getString(int row, int column) {
        acquireReference();
        try {
            return nativeGetString(mWindowPtr, row - mStartPos, column);
        } finally {
            releaseReference();
        }
    }

    /**
     * Copies the text of the field at the specified row and column index into
     * a {@link CharArrayBuffer}.
     * <p>
     * The buffer is populated as follows:
     * <ul>
     * <li>If the buffer is too small for the value to be copied, then it is
     * automatically resized.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_NULL}, then the buffer
     * is set to an empty string.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_STRING}, then the buffer
     * is set to the contents of the string.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_INTEGER}, then the buffer
     * is set to a string representation of the integer in decimal, obtained by formatting the
     * value with the <code>printf</code> family of functions using
     * format specifier <code>%lld</code>.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_FLOAT}, then the buffer is
     * set to a string representation of the floating-point value in decimal, obtained by
     * formatting the value with the <code>printf</code> family of functions using
     * format specifier <code>%g</code>.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_BLOB}, then a
     * {@link SQLiteException} is thrown.</li>
     * </ul>
     * </p>
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @param buffer The {@link CharArrayBuffer} to hold the string.  It is automatically
     * resized if the requested string is larger than the buffer's current capacity.
      */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.202 -0500", hash_original_method = "58A64F01A8AD746344B9549C1A3482B7", hash_generated_method = "643FE172A5A1F488E2D1D0680BC94BEE")
    
public void copyStringToBuffer(int row, int column, CharArrayBuffer buffer) {
        if (buffer == null) {
            throw new IllegalArgumentException("CharArrayBuffer should not be null");
        }
        acquireReference();
        try {
            nativeCopyStringToBuffer(mWindowPtr, row - mStartPos, column, buffer);
        } finally {
            releaseReference();
        }
    }

    /**
     * Gets the value of the field at the specified row and column index as a <code>long</code>.
     * <p>
     * The result is determined as follows:
     * <ul>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_NULL}, then the result
     * is <code>0L</code>.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_STRING}, then the result
     * is the value obtained by parsing the string value with <code>strtoll</code>.
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_INTEGER}, then the result
     * is the <code>long</code> value.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_FLOAT}, then the result
     * is the floating-point value converted to a <code>long</code>.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_BLOB}, then a
     * {@link SQLiteException} is thrown.</li>
     * </ul>
     * </p>
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return The value of the field as a <code>long</code>.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.204 -0500", hash_original_method = "AD6EFD172162F129E252A5B000066DBD", hash_generated_method = "12E72993EFAA287809AB53C55B85206A")
    
public long getLong(int row, int column) {
        acquireReference();
        try {
            return nativeGetLong(mWindowPtr, row - mStartPos, column);
        } finally {
            releaseReference();
        }
    }

    /**
     * Gets the value of the field at the specified row and column index as a
     * <code>double</code>.
     * <p>
     * The result is determined as follows:
     * <ul>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_NULL}, then the result
     * is <code>0.0</code>.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_STRING}, then the result
     * is the value obtained by parsing the string value with <code>strtod</code>.
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_INTEGER}, then the result
     * is the integer value converted to a <code>double</code>.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_FLOAT}, then the result
     * is the <code>double</code> value.</li>
     * <li>If the field is of type {@link Cursor#FIELD_TYPE_BLOB}, then a
     * {@link SQLiteException} is thrown.</li>
     * </ul>
     * </p>
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return The value of the field as a <code>double</code>.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.207 -0500", hash_original_method = "8A6F3264B03417AA20925F57716C63D9", hash_generated_method = "E3C98321222A0CC78973A9C9956891EF")
    
public double getDouble(int row, int column) {
        acquireReference();
        try {
            return nativeGetDouble(mWindowPtr, row - mStartPos, column);
        } finally {
            releaseReference();
        }
    }

    /**
     * Gets the value of the field at the specified row and column index as a
     * <code>short</code>.
     * <p>
     * The result is determined by invoking {@link #getLong} and converting the
     * result to <code>short</code>.
     * </p>
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return The value of the field as a <code>short</code>.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.209 -0500", hash_original_method = "A20DC76A6D7B2E924E48673418BA5751", hash_generated_method = "20741C48C3CED6CC130906E2D7A2DD54")
    
public short getShort(int row, int column) {
        return (short) getLong(row, column);
    }

    /**
     * Gets the value of the field at the specified row and column index as an
     * <code>int</code>.
     * <p>
     * The result is determined by invoking {@link #getLong} and converting the
     * result to <code>int</code>.
     * </p>
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return The value of the field as an <code>int</code>.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.212 -0500", hash_original_method = "551A86F714BE24A79B828A8B72E1E568", hash_generated_method = "5AF1AFE5D5C51ED3AF661655CB96E7C4")
    
public int getInt(int row, int column) {
        return (int) getLong(row, column);
    }

    /**
     * Gets the value of the field at the specified row and column index as a
     * <code>float</code>.
     * <p>
     * The result is determined by invoking {@link #getDouble} and converting the
     * result to <code>float</code>.
     * </p>
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return The value of the field as an <code>float</code>.
     */
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.215 -0500", hash_original_method = "27DD398413CBDB3B58DB63ADFF69899A", hash_generated_method = "618BED85ED74CEF91EFDC8511C41C6F3")
    
public float getFloat(int row, int column) {
        return (float) getDouble(row, column);
    }

    /**
     * Copies a byte array into the field at the specified row and column index.
     *
     * @param value The value to store.
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return True if successful.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.217 -0500", hash_original_method = "6CB3F309867B314299E03BAA3ADD01B0", hash_generated_method = "7F0E77137CFC3A3346F77E5FE852F5A6")
    
public boolean putBlob(byte[] value, int row, int column) {
        acquireReference();
        try {
            return nativePutBlob(mWindowPtr, value, row - mStartPos, column);
        } finally {
            releaseReference();
        }
    }

    /**
     * Copies a string into the field at the specified row and column index.
     *
     * @param value The value to store.
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return True if successful.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.220 -0500", hash_original_method = "6CB1D543D51D5DCA24055F8F53C41BAF", hash_generated_method = "706330AC18A644D47A4038408E2797D5")
    
public boolean putString(String value, int row, int column) {
        acquireReference();
        try {
            return nativePutString(mWindowPtr, value, row - mStartPos, column);
        } finally {
            releaseReference();
        }
    }

    /**
     * Puts a long integer into the field at the specified row and column index.
     *
     * @param value The value to store.
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return True if successful.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.222 -0500", hash_original_method = "2778A952D34B60D93ADEBF86D42CFB13", hash_generated_method = "4D3FFF57EEE098A69A3D7ED6CE9A016A")
    
public boolean putLong(long value, int row, int column) {
        acquireReference();
        try {
            return nativePutLong(mWindowPtr, value, row - mStartPos, column);
        } finally {
            releaseReference();
        }
    }

    /**
     * Puts a double-precision floating point value into the field at the
     * specified row and column index.
     *
     * @param value The value to store.
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return True if successful.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.224 -0500", hash_original_method = "750162916D1917FF199EBD766435A4BC", hash_generated_method = "E1BA738DAB805BEEA27EB43C611A7D52")
    
public boolean putDouble(double value, int row, int column) {
        acquireReference();
        try {
            return nativePutDouble(mWindowPtr, value, row - mStartPos, column);
        } finally {
            releaseReference();
        }
    }

    /**
     * Puts a null value into the field at the specified row and column index.
     *
     * @param row The zero-based row index.
     * @param column The zero-based column index.
     * @return True if successful.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.227 -0500", hash_original_method = "729F260E3687A604BDCEB4B5144460BE", hash_generated_method = "9E3315483A95DC9C427CB6571FD2FB57")
    
public boolean putNull(int row, int column) {
        acquireReference();
        try {
            return nativePutNull(mWindowPtr, row - mStartPos, column);
        } finally {
            releaseReference();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.240 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.244 -0500", hash_original_method = "A351847D47687056BE0F3C5BF172823F", hash_generated_method = "B52703EBD9CAB83469F643132503071B")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mStartPos);
        nativeWriteToParcel(mWindowPtr, dest);

        if ((flags & Parcelable.PARCELABLE_WRITE_RETURN_VALUE) != 0) {
            releaseReference();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.246 -0500", hash_original_method = "9F0DD3DD42B1176D3BFC90E1CC869BD8", hash_generated_method = "D7B27375F65904F13826F02BE2155146")
    
@Override
    protected void onAllReferencesReleased() {
        dispose();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.251 -0500", hash_original_method = "A1A5B0D31D251CEBDD86B0232FAF0913", hash_generated_method = "69E1424A9E4EA73EDE14F0691B295FFA")
    
private void recordNewWindow(int pid, int window) {
        synchronized (sWindowToPidMap) {
            sWindowToPidMap.put(window, pid);
            if (Log.isLoggable(STATS_TAG, Log.VERBOSE)) {
                Log.i(STATS_TAG, "Created a new Cursor. " + printStats());
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.254 -0500", hash_original_method = "35EFD039834BDFB7DFA5FAF4FCFF938C", hash_generated_method = "71ACDCAC4F62F9980332EA65E44A2C32")
    
private void recordClosingOfWindow(int window) {
        synchronized (sWindowToPidMap) {
            if (sWindowToPidMap.size() == 0) {
                // this means we are not in the ContentProvider.
                return;
            }
            sWindowToPidMap.delete(window);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.257 -0500", hash_original_method = "FB6D9C80437A7691015FDFE53D1A15C9", hash_generated_method = "08A818B6B263049C3D5F0FB03B76FFAC")
    
private String printStats() {
        StringBuilder buff = new StringBuilder();
        int myPid = Process.myPid();
        int total = 0;
        SparseIntArray pidCounts = new SparseIntArray();
        synchronized (sWindowToPidMap) {
            int size = sWindowToPidMap.size();
            if (size == 0) {
                // this means we are not in the ContentProvider.
                return "";
            }
            for (int indx = 0; indx < size; indx++) {
                int pid = sWindowToPidMap.valueAt(indx);
                int value = pidCounts.get(pid);
                pidCounts.put(pid, ++value);
            }
        }
        int numPids = pidCounts.size();
        for (int i = 0; i < numPids;i++) {
            buff.append(" (# cursors opened by ");
            int pid = pidCounts.keyAt(i);
            if (pid == myPid) {
                buff.append("this proc=");
            } else {
                buff.append("pid " + pid + "=");
            }
            int num = pidCounts.get(pid);
            buff.append(num + ")");
            total += num;
        }
        // limit the returned string size to 1000
        String s = (buff.length() > 980) ? buff.substring(0, 980) : buff.toString();
        return "# Open Cursors=" + total + s;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:36.260 -0500", hash_original_method = "2B041B6FC7B2CED29CA29EA62E026B41", hash_generated_method = "AC419103525ACF20E21CA3CE49A01E58")
    
@Override
    public String toString() {
        return getName() + " {" + Integer.toHexString(mWindowPtr) + "}";
    }
    // orphaned legacy method
    public CursorWindow createFromParcel(Parcel source) {
            return new CursorWindow(source);
        }
    
    // orphaned legacy method
    public CursorWindow[] newArray(int size) {
            return new CursorWindow[size];
        }
    
}

