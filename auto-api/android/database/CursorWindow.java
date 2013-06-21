package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.CloseGuard;
import android.content.res.Resources;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import android.util.SparseIntArray;

public class CursorWindow extends SQLiteClosable implements Parcelable {
    public int mWindowPtr;
    private int mStartPos;
    private String mName;
    private CloseGuard mCloseGuard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.076 -0400", hash_original_method = "D2526397A12BC25EA910BA6CE9A2504E", hash_generated_method = "A07F888180BC9F9A49736788547BCAA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CursorWindow(String name) {
        dsTaint.addTaint(name);
        mStartPos = 0;
        mWindowPtr = nativeCreate(name, sCursorWindowSize);
        {
            if (DroidSafeAndroidRuntime.control) throw new CursorWindowAllocationException("Cursor window allocation of " +
                    (sCursorWindowSize / 1024) + " kb failed. " + printStats());
        } //End block
        mCloseGuard.open("close");
        recordNewWindow(Binder.getCallingPid(), mWindowPtr);
        // ---------- Original Method ----------
        //mStartPos = 0;
        //mName = name;
        //mWindowPtr = nativeCreate(name, sCursorWindowSize);
        //if (mWindowPtr == 0) {
            //throw new CursorWindowAllocationException("Cursor window allocation of " +
                    //(sCursorWindowSize / 1024) + " kb failed. " + printStats());
        //}
        //mCloseGuard.open("close");
        //recordNewWindow(Binder.getCallingPid(), mWindowPtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.076 -0400", hash_original_method = "CB3D999FBD9663B85250B0069300DD19", hash_generated_method = "ADF3FDCB807C017C7BDE011B6F44BA6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public CursorWindow(boolean localWindow) {
        this((String)null);
        dsTaint.addTaint(localWindow);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.076 -0400", hash_original_method = "2F52A6C89F1D54A86C82C46FF5E1EC25", hash_generated_method = "5687E07C92F17773F434B93974748B10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CursorWindow(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        mStartPos = source.readInt();
        mWindowPtr = nativeCreateFromParcel(source);
        {
            if (DroidSafeAndroidRuntime.control) throw new CursorWindowAllocationException("Cursor window could not be "
                    + "created from binder.");
        } //End block
        mName = nativeGetName(mWindowPtr);
        mCloseGuard.open("close");
        // ---------- Original Method ----------
        //mStartPos = source.readInt();
        //mWindowPtr = nativeCreateFromParcel(source);
        //if (mWindowPtr == 0) {
            //throw new CursorWindowAllocationException("Cursor window could not be "
                    //+ "created from binder.");
        //}
        //mName = nativeGetName(mWindowPtr);
        //mCloseGuard.open("close");
    }

    
        private static int nativeCreate(String name, int cursorWindowSize) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int nativeCreateFromParcel(Parcel parcel) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeDispose(int windowPtr) {
    }

    
        private static void nativeWriteToParcel(int windowPtr, Parcel parcel) {
    }

    
        private static void nativeClear(int windowPtr) {
    }

    
        private static int nativeGetNumRows(int windowPtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static boolean nativeSetNumColumns(int windowPtr, int columnNum) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean nativeAllocRow(int windowPtr) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void nativeFreeLastRow(int windowPtr) {
    }

    
        private static int nativeGetType(int windowPtr, int row, int column) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static byte[] nativeGetBlob(int windowPtr, int row, int column) {
        byte[] retVal = {DSUtils.UNKNOWN_BYTE};
        return retVal;
    }

    
        private static String nativeGetString(int windowPtr, int row, int column) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        private static long nativeGetLong(int windowPtr, int row, int column) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        private static double nativeGetDouble(int windowPtr, int row, int column) {
        return DSUtils.UNKNOWN_DOUBLE;
    }

    
        private static void nativeCopyStringToBuffer(int windowPtr, int row, int column,
            CharArrayBuffer buffer) {
    }

    
        private static boolean nativePutBlob(int windowPtr, byte[] value, int row, int column) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean nativePutString(int windowPtr, String value, int row, int column) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean nativePutLong(int windowPtr, long value, int row, int column) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean nativePutDouble(int windowPtr, double value, int row, int column) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static boolean nativePutNull(int windowPtr, int row, int column) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static String nativeGetName(int windowPtr) {
        return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.080 -0400", hash_original_method = "896D51A0732498DB684FD2752503707E", hash_generated_method = "0752F4C2ECB81F09870F8C2C0033EA08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                mCloseGuard.warnIfOpen();
            } //End block
            dispose();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (mCloseGuard != null) {
                //mCloseGuard.warnIfOpen();
            //}
            //dispose();
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.080 -0400", hash_original_method = "DF965B7262A7C1EB6D66FE3F57E4031E", hash_generated_method = "9080E454EBBC0348075C834CDD8ACAC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dispose() {
        {
            mCloseGuard.close();
        } //End block
        {
            recordClosingOfWindow(mWindowPtr);
            nativeDispose(mWindowPtr);
            mWindowPtr = 0;
        } //End block
        // ---------- Original Method ----------
        //if (mCloseGuard != null) {
            //mCloseGuard.close();
        //}
        //if (mWindowPtr != 0) {
            //recordClosingOfWindow(mWindowPtr);
            //nativeDispose(mWindowPtr);
            //mWindowPtr = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.080 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "1698AF415E3250D582962C1A88D4A564")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.081 -0400", hash_original_method = "6B12CEFAA1DE3FB86CA989F7EF7D159A", hash_generated_method = "138BAE56F7E233D621D61B747D55599C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        releaseReference();
        // ---------- Original Method ----------
        //releaseReference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.081 -0400", hash_original_method = "979E75E660A1C8BD17328FDD55823D54", hash_generated_method = "1A43E506686E999BD298E5363FB767E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        acquireReference();
        try 
        {
            mStartPos = 0;
            nativeClear(mWindowPtr);
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //mStartPos = 0;
            //nativeClear(mWindowPtr);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.081 -0400", hash_original_method = "E83B1D6D3C97BD3B3A2AA134F51457E7", hash_generated_method = "9B20BD9A96D63981E0DEF42621EF0974")
    @DSModeled(DSC.SAFE)
    public int getStartPosition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStartPos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.082 -0400", hash_original_method = "A3D22CBF25891D62569B204C4A11C84D", hash_generated_method = "289BB9D2BA6B9B2E3BAA62705C3D9700")
    @DSModeled(DSC.SAFE)
    public void setStartPosition(int pos) {
        dsTaint.addTaint(pos);
        // ---------- Original Method ----------
        //mStartPos = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.082 -0400", hash_original_method = "FEBAC209BE2E731A41AC61FC29EF2631", hash_generated_method = "E5579EE98CB0BC97B8535C9167D56DA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getNumRows() {
        acquireReference();
        try 
        {
            int var414F51D82D9BF7C55CA2723FC84CAD14_941891312 = (nativeGetNumRows(mWindowPtr));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetNumRows(mWindowPtr);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.082 -0400", hash_original_method = "06070130EC2CA13555B4890F162F9E48", hash_generated_method = "9109E26554B6A053806FAD4D2C162BD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setNumColumns(int columnNum) {
        dsTaint.addTaint(columnNum);
        acquireReference();
        try 
        {
            boolean var1AD4C2C634C3D9AB4728527E89734163_1055940337 = (nativeSetNumColumns(mWindowPtr, columnNum));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeSetNumColumns(mWindowPtr, columnNum);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.083 -0400", hash_original_method = "EA2451DCCE3D57D72B2D978A02AB8CBE", hash_generated_method = "59839807658E4E9742017D9CC262012E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean allocRow() {
        acquireReference();
        try 
        {
            boolean var01A0BA1F86225288F569462FC8FBBF5E_866169650 = (nativeAllocRow(mWindowPtr));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeAllocRow(mWindowPtr);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.083 -0400", hash_original_method = "B379FF08DED00763293DB0E42243B555", hash_generated_method = "55E5FB6178C783385D74EF917B74755D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void freeLastRow() {
        acquireReference();
        try 
        {
            nativeFreeLastRow(mWindowPtr);
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //nativeFreeLastRow(mWindowPtr);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.083 -0400", hash_original_method = "49D7CBD5A9292352030392B89291BE3D", hash_generated_method = "0070EF7CD70EA9CE3F88B32FB362A6AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isNull(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        boolean var97A1C67CC6DAFD00A3A8F4664D9EE64B_68536008 = (getType(row, column) == Cursor.FIELD_TYPE_NULL);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.083 -0400", hash_original_method = "C746642EB39EFB60299B9B6078CB8713", hash_generated_method = "4DCB58AA066CF136281D8A235AECF51D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isBlob(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        int type;
        type = getType(row, column);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int type = getType(row, column);
        //return type == Cursor.FIELD_TYPE_BLOB || type == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.084 -0400", hash_original_method = "F41C7C64C57B82BE924AB092481D8C56", hash_generated_method = "FA092EB3103F071B0EAEDA5B31A699C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isLong(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        boolean var1DB86FDE6B4703FBCFBD16036E160C9C_918147066 = (getType(row, column) == Cursor.FIELD_TYPE_INTEGER);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.084 -0400", hash_original_method = "AB10FF6E7457EC84D59F089A4F39FCC7", hash_generated_method = "1000F927EB1BDF315EE8D064328B130E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isFloat(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        boolean var6554498C7E79ED2247913695DFC28232_1345510355 = (getType(row, column) == Cursor.FIELD_TYPE_FLOAT);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.084 -0400", hash_original_method = "235C1A23640EE5ABC2401DF58B1A3F61", hash_generated_method = "52C6282F7B7FC05BAF2045DFBA9806A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isString(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        int type;
        type = getType(row, column);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int type = getType(row, column);
        //return type == Cursor.FIELD_TYPE_STRING || type == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.085 -0400", hash_original_method = "8E937452D8006A30B303869F5FCBB330", hash_generated_method = "179789F6BC50109AAB6FD07305F7ACF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getType(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            int var71CCA26C17E48AE0D0877F9F348F7D74_965694470 = (nativeGetType(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetType(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.085 -0400", hash_original_method = "369AEBF74D7711C2C086D87D281ECBA3", hash_generated_method = "3EEADBAAB60FDB5D5D41CAC578993541")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getBlob(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            byte[] varBD638E3555273746DC3865B80681F60E_302823402 = (nativeGetBlob(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetBlob(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.085 -0400", hash_original_method = "91E1480DC9AA77B4570FAB2ABB8DFF8A", hash_generated_method = "6468DDAA38E798E3B2467F315808B4F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            String var0B1EF07AA5FFF7722F982EF0A8E837E4_901011031 = (nativeGetString(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetString(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.086 -0400", hash_original_method = "58A64F01A8AD746344B9549C1A3482B7", hash_generated_method = "16C632F823362E03EBB1107638C6140D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void copyStringToBuffer(int row, int column, CharArrayBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("CharArrayBuffer should not be null");
        } //End block
        acquireReference();
        try 
        {
            nativeCopyStringToBuffer(mWindowPtr, row - mStartPos, column, buffer);
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new IllegalArgumentException("CharArrayBuffer should not be null");
        //}
        //acquireReference();
        //try {
            //nativeCopyStringToBuffer(mWindowPtr, row - mStartPos, column, buffer);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.087 -0400", hash_original_method = "AD6EFD172162F129E252A5B000066DBD", hash_generated_method = "1039F8E51B0D1EAC77E6774530A80D8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            long var168504F324B8494AD63EF9400F960BF4_1616298585 = (nativeGetLong(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetLong(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.087 -0400", hash_original_method = "8A6F3264B03417AA20925F57716C63D9", hash_generated_method = "C62C3372615952DFEEC3DE99243ADD2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDouble(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            double var664302859858AF173EF357CBCF35091D_2031483551 = (nativeGetDouble(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetDouble(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.087 -0400", hash_original_method = "A20DC76A6D7B2E924E48673418BA5751", hash_generated_method = "B6380F868FC62FE90081F1F5A2A381C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short getShort(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        short var5F63A2F12068779C1BB1A99745C9CAB9_1208661406 = ((short) getLong(row, column));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return (short) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.087 -0400", hash_original_method = "551A86F714BE24A79B828A8B72E1E568", hash_generated_method = "028DFEE8200F98B1BDBBC9E450F9398A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        int varEE76896E32EEB64BFB310F2A5B6E4AE8_1511868374 = ((int) getLong(row, column));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.088 -0400", hash_original_method = "27DD398413CBDB3B58DB63ADFF69899A", hash_generated_method = "740760876F1BFB9E823B1C02C7968E08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloat(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        float varD967860490A37C92BE233D56CF4148A1_1831199199 = ((float) getDouble(row, column));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (float) getDouble(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.088 -0400", hash_original_method = "6CB3F309867B314299E03BAA3ADD01B0", hash_generated_method = "FDDB07B9A9735B6D37A5B27B40AA2698")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean putBlob(byte[] value, int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(value[0]);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            boolean varDBF02A91A7F9FB2B44A262BEC4A20A1D_1432583263 = (nativePutBlob(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutBlob(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.088 -0400", hash_original_method = "6CB1D543D51D5DCA24055F8F53C41BAF", hash_generated_method = "84B6908CB9A1FFEB7A987EAD601D78AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean putString(String value, int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(value);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            boolean varEC5141FBADFF6FC9B99D1AD371FD7973_159919334 = (nativePutString(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutString(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.089 -0400", hash_original_method = "2778A952D34B60D93ADEBF86D42CFB13", hash_generated_method = "CDF09F2A131F81D8BD19C4A91E946446")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean putLong(long value, int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(value);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            boolean var7996BC4E6D3BD70C3EF52496645FC6D8_2044723935 = (nativePutLong(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutLong(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.089 -0400", hash_original_method = "750162916D1917FF199EBD766435A4BC", hash_generated_method = "330E2491BF7D34DD3510B8B7602944E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean putDouble(double value, int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(value);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            boolean var8E20548EEFA5A64A44A4E184ABC6FC3B_1618202702 = (nativePutDouble(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutDouble(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.089 -0400", hash_original_method = "729F260E3687A604BDCEB4B5144460BE", hash_generated_method = "E1688BE18B87E0EE8F3704B6106E181A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean putNull(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            boolean varEDCC8D3EE34F721869F33D574DB972AA_867874847 = (nativePutNull(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutNull(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
        public static CursorWindow newFromParcel(Parcel p) {
        return CREATOR.createFromParcel(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.090 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.090 -0400", hash_original_method = "A351847D47687056BE0F3C5BF172823F", hash_generated_method = "BE6DD5283F10F03229F50F48C02C7C25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mStartPos);
        nativeWriteToParcel(mWindowPtr, dest);
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //dest.writeInt(mStartPos);
        //nativeWriteToParcel(mWindowPtr, dest);
        //if ((flags & Parcelable.PARCELABLE_WRITE_RETURN_VALUE) != 0) {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.090 -0400", hash_original_method = "9F0DD3DD42B1176D3BFC90E1CC869BD8", hash_generated_method = "FA9613911A2A6B53687A115BA4086A12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onAllReferencesReleased() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dispose();
        // ---------- Original Method ----------
        //dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.090 -0400", hash_original_method = "A1A5B0D31D251CEBDD86B0232FAF0913", hash_generated_method = "36091680F02A62469D2EDFA202673C13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void recordNewWindow(int pid, int window) {
        dsTaint.addTaint(window);
        dsTaint.addTaint(pid);
        {
            sWindowToPidMap.put(window, pid);
            {
                boolean varC36DF1398F4EE2BD3893C3E1F97813EC_349959410 = (Log.isLoggable(STATS_TAG, Log.VERBOSE));
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (sWindowToPidMap) {
            //sWindowToPidMap.put(window, pid);
            //if (Log.isLoggable(STATS_TAG, Log.VERBOSE)) {
                //Log.i(STATS_TAG, "Created a new Cursor. " + printStats());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.091 -0400", hash_original_method = "35EFD039834BDFB7DFA5FAF4FCFF938C", hash_generated_method = "F1A2214182D37A188A946DAB645464AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void recordClosingOfWindow(int window) {
        dsTaint.addTaint(window);
        {
            {
                boolean var1E358411B44E94E4F474E426A793D087_420196550 = (sWindowToPidMap.size() == 0);
            } //End collapsed parenthetic
            sWindowToPidMap.delete(window);
        } //End block
        // ---------- Original Method ----------
        //synchronized (sWindowToPidMap) {
            //if (sWindowToPidMap.size() == 0) {
                //return;
            //}
            //sWindowToPidMap.delete(window);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.091 -0400", hash_original_method = "FB6D9C80437A7691015FDFE53D1A15C9", hash_generated_method = "5C929C7D3C820BF0746A232905E76A9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String printStats() {
        StringBuilder buff;
        buff = new StringBuilder();
        int myPid;
        myPid = Process.myPid();
        int total;
        total = 0;
        SparseIntArray pidCounts;
        pidCounts = new SparseIntArray();
        {
            int size;
            size = sWindowToPidMap.size();
            {
                int indx;
                indx = 0;
                {
                    int pid;
                    pid = sWindowToPidMap.valueAt(indx);
                    int value;
                    value = pidCounts.get(pid);
                    pidCounts.put(pid, ++value);
                } //End block
            } //End collapsed parenthetic
        } //End block
        int numPids;
        numPids = pidCounts.size();
        {
            int i;
            i = 0;
            {
                buff.append(" (# cursors opened by ");
                int pid;
                pid = pidCounts.keyAt(i);
                {
                    buff.append("this proc=");
                } //End block
                {
                    buff.append("pid " + pid + "=");
                } //End block
                int num;
                num = pidCounts.get(pid);
                buff.append(num + ")");
                total += num;
            } //End block
        } //End collapsed parenthetic
        String s;
        boolean var73BE181800F050B89C23EBA00B9AC3AE_1693407991 = ((buff.length() > 980));
        s = buff.substring(0, 980);
        s = buff.toString();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.092 -0400", hash_original_method = "2B041B6FC7B2CED29CA29EA62E026B41", hash_generated_method = "F62374D1FC2FD4BE590D9114244B59AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varF798FCF7A644093E19C7A8E7330F4FA3_1013615007 = (getName() + " {" + Integer.toHexString(mWindowPtr) + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getName() + " {" + Integer.toHexString(mWindowPtr) + "}";
    }

    
    private static final String STATS_TAG = "CursorWindowStats";
    private static final int sCursorWindowSize =
        Resources.getSystem().getInteger(
                com.android.internal.R.integer.config_cursorWindowSize) * 1024;
    public static final Parcelable.Creator<CursorWindow> CREATOR = new Parcelable.Creator<CursorWindow>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.092 -0400", hash_original_method = "102321E705544E214630A229EBF0AAEA", hash_generated_method = "33B0DDD5994DECBDD7C261CC10969434")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CursorWindow createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            CursorWindow var5F738796A68656655920A89AC2959FF7_1550573432 = (new CursorWindow(source));
            return (CursorWindow)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CursorWindow(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.093 -0400", hash_original_method = "22E812BCDE3BA2EC64FA32FE6BB196D2", hash_generated_method = "C96AF79680E9A8ADF72D0A7175CE7132")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CursorWindow[] newArray(int size) {
            dsTaint.addTaint(size);
            CursorWindow[] var76784B0EBB5D811C862190008498A797_1766801130 = (new CursorWindow[size]);
            return (CursorWindow[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CursorWindow[size];
        }

        
}; //Transformed anonymous class
    private static final SparseIntArray sWindowToPidMap = new SparseIntArray();
}

