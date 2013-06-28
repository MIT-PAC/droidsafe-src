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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.777 -0400", hash_original_field = "0513C934C32593F0CDE478394F5606CD", hash_generated_field = "38FB3A768EF6B5DA39D97BE6BF469283")

    public int mWindowPtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.777 -0400", hash_original_field = "4770B54049ADFE51BD91A1F9D13B56D1", hash_generated_field = "D37936E7DE7BA2848F09C9211D0F059F")

    private int mStartPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.777 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.777 -0400", hash_original_field = "FAB63045DAC8675C1DE9648413C0413D", hash_generated_field = "91705AACD6DDE42AEA628776AF2A3DC6")

    private final CloseGuard mCloseGuard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.778 -0400", hash_original_method = "D2526397A12BC25EA910BA6CE9A2504E", hash_generated_method = "7C450B22A4DE3CA3D195D3B166A99664")
    public  CursorWindow(String name) {
        mStartPos = 0;
        mName = name;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.778 -0400", hash_original_method = "CB3D999FBD9663B85250B0069300DD19", hash_generated_method = "D08F1A46F0A4CBA01B58E03B3B15ABD8")
    @Deprecated
    public  CursorWindow(boolean localWindow) {
        this((String)null);
        addTaint(localWindow);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.779 -0400", hash_original_method = "2F52A6C89F1D54A86C82C46FF5E1EC25", hash_generated_method = "9CB142BDB609683CB1078BB44AFE7DFE")
    private  CursorWindow(Parcel source) {
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
        byte[] ret = {DSUtils.UNKNOWN_BYTE};
        return ret;
    }

    
    private static String nativeGetString(int windowPtr, int row, int column) {
        	String ret = new String();
        	ret.addTaint(windowPtr);
        	ret.addTaint(row);
        	ret.addTaint(column);
        	return ret;
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
        	String ret =  new String();
        	ret.addTaint(windowPtr);
        	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.785 -0400", hash_original_method = "896D51A0732498DB684FD2752503707E", hash_generated_method = "0752F4C2ECB81F09870F8C2C0033EA08")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.785 -0400", hash_original_method = "DF965B7262A7C1EB6D66FE3F57E4031E", hash_generated_method = "9080E454EBBC0348075C834CDD8ACAC3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.786 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "FBAA6690035CD56CC59F9731C4304ACB")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1008289281 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1008289281 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_1008289281.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1008289281;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.787 -0400", hash_original_method = "6B12CEFAA1DE3FB86CA989F7EF7D159A", hash_generated_method = "138BAE56F7E233D621D61B747D55599C")
    public void close() {
        releaseReference();
        // ---------- Original Method ----------
        //releaseReference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.788 -0400", hash_original_method = "979E75E660A1C8BD17328FDD55823D54", hash_generated_method = "1A43E506686E999BD298E5363FB767E7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.788 -0400", hash_original_method = "E83B1D6D3C97BD3B3A2AA134F51457E7", hash_generated_method = "2F6EE15EED9163B7AB6DFE7BD6C0EE9E")
    public int getStartPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310553591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_310553591;
        // ---------- Original Method ----------
        //return mStartPos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.789 -0400", hash_original_method = "A3D22CBF25891D62569B204C4A11C84D", hash_generated_method = "494AFECC1CA5EB1938A9EB7987E5F3E4")
    public void setStartPosition(int pos) {
        mStartPos = pos;
        // ---------- Original Method ----------
        //mStartPos = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.789 -0400", hash_original_method = "FEBAC209BE2E731A41AC61FC29EF2631", hash_generated_method = "8A5407BC6FEBACB4C67D05CB81A0AEE6")
    public int getNumRows() {
        acquireReference();
        try 
        {
            int var414F51D82D9BF7C55CA2723FC84CAD14_153033771 = (nativeGetNumRows(mWindowPtr));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939787470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1939787470;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetNumRows(mWindowPtr);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.790 -0400", hash_original_method = "06070130EC2CA13555B4890F162F9E48", hash_generated_method = "010347418A69093373B8D4AE461D7327")
    public boolean setNumColumns(int columnNum) {
        acquireReference();
        try 
        {
            boolean var1AD4C2C634C3D9AB4728527E89734163_886661946 = (nativeSetNumColumns(mWindowPtr, columnNum));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(columnNum);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_686744631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_686744631;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeSetNumColumns(mWindowPtr, columnNum);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.790 -0400", hash_original_method = "EA2451DCCE3D57D72B2D978A02AB8CBE", hash_generated_method = "BDBF5AD434F96FE94765F3DB9B51212B")
    public boolean allocRow() {
        acquireReference();
        try 
        {
            boolean var01A0BA1F86225288F569462FC8FBBF5E_237784282 = (nativeAllocRow(mWindowPtr));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_629426352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_629426352;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeAllocRow(mWindowPtr);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.791 -0400", hash_original_method = "B379FF08DED00763293DB0E42243B555", hash_generated_method = "55E5FB6178C783385D74EF917B74755D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.792 -0400", hash_original_method = "49D7CBD5A9292352030392B89291BE3D", hash_generated_method = "B23CA6542A648D903B34BC4D5CAE4904")
    @Deprecated
    public boolean isNull(int row, int column) {
        boolean var97A1C67CC6DAFD00A3A8F4664D9EE64B_214455625 = (getType(row, column) == Cursor.FIELD_TYPE_NULL);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1426466557 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1426466557;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.793 -0400", hash_original_method = "C746642EB39EFB60299B9B6078CB8713", hash_generated_method = "BAAC5058C452371F53A7FB4C4C495CE1")
    @Deprecated
    public boolean isBlob(int row, int column) {
        int type = getType(row, column);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_280953246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_280953246;
        // ---------- Original Method ----------
        //int type = getType(row, column);
        //return type == Cursor.FIELD_TYPE_BLOB || type == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.794 -0400", hash_original_method = "F41C7C64C57B82BE924AB092481D8C56", hash_generated_method = "BAA21FB8145974FE5D3E60DC868F36BA")
    @Deprecated
    public boolean isLong(int row, int column) {
        boolean var1DB86FDE6B4703FBCFBD16036E160C9C_591176422 = (getType(row, column) == Cursor.FIELD_TYPE_INTEGER);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_444719887 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_444719887;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.795 -0400", hash_original_method = "AB10FF6E7457EC84D59F089A4F39FCC7", hash_generated_method = "BA2C1158AA4A5F540A8260CE295725E1")
    @Deprecated
    public boolean isFloat(int row, int column) {
        boolean var6554498C7E79ED2247913695DFC28232_1237117360 = (getType(row, column) == Cursor.FIELD_TYPE_FLOAT);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1600172423 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1600172423;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.795 -0400", hash_original_method = "235C1A23640EE5ABC2401DF58B1A3F61", hash_generated_method = "A6ED86E0C671237D80E82064C9A07293")
    @Deprecated
    public boolean isString(int row, int column) {
        int type = getType(row, column);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_616458553 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_616458553;
        // ---------- Original Method ----------
        //int type = getType(row, column);
        //return type == Cursor.FIELD_TYPE_STRING || type == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.796 -0400", hash_original_method = "8E937452D8006A30B303869F5FCBB330", hash_generated_method = "294356994ECD8A8AB25958C53CFB7217")
    public int getType(int row, int column) {
        acquireReference();
        try 
        {
            int var71CCA26C17E48AE0D0877F9F348F7D74_1137691561 = (nativeGetType(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182674202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182674202;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetType(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.796 -0400", hash_original_method = "369AEBF74D7711C2C086D87D281ECBA3", hash_generated_method = "073B97F6A87BBA35852E769E184578BC")
    public byte[] getBlob(int row, int column) {
        acquireReference();
        try 
        {
            byte[] varBD638E3555273746DC3865B80681F60E_2139947729 = (nativeGetBlob(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1963096298 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1963096298;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetBlob(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.797 -0400", hash_original_method = "91E1480DC9AA77B4570FAB2ABB8DFF8A", hash_generated_method = "F2AC40AA3E588B3EF6963AFD9F5F504F")
    public String getString(int row, int column) {
        String varB4EAC82CA7396A68D541C85D26508E83_639254317 = null; //Variable for return #1
        acquireReference();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_639254317 = nativeGetString(mWindowPtr, row - mStartPos, column);
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        varB4EAC82CA7396A68D541C85D26508E83_639254317.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_639254317;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetString(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.797 -0400", hash_original_method = "58A64F01A8AD746344B9549C1A3482B7", hash_generated_method = "1EFC31AA95A6ED8056B5D86874A5A6F7")
    public void copyStringToBuffer(int row, int column, CharArrayBuffer buffer) {
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
        addTaint(row);
        addTaint(column);
        addTaint(buffer.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.798 -0400", hash_original_method = "AD6EFD172162F129E252A5B000066DBD", hash_generated_method = "95F39C85D2D8FD430B98705CE234239F")
    public long getLong(int row, int column) {
        acquireReference();
        try 
        {
            long var168504F324B8494AD63EF9400F960BF4_1089461615 = (nativeGetLong(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1049253706 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1049253706;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetLong(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.798 -0400", hash_original_method = "8A6F3264B03417AA20925F57716C63D9", hash_generated_method = "DAE5A24BB4BE79711A4797000E4E2313")
    public double getDouble(int row, int column) {
        acquireReference();
        try 
        {
            double var664302859858AF173EF357CBCF35091D_50697500 = (nativeGetDouble(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1628806011 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1628806011;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetDouble(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.799 -0400", hash_original_method = "A20DC76A6D7B2E924E48673418BA5751", hash_generated_method = "6F8E16DFDA0F239DF6F09DDCF0D02000")
    public short getShort(int row, int column) {
        short var5F63A2F12068779C1BB1A99745C9CAB9_1208376841 = ((short) getLong(row, column));
        addTaint(row);
        addTaint(column);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1669267531 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1669267531;
        // ---------- Original Method ----------
        //return (short) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.799 -0400", hash_original_method = "551A86F714BE24A79B828A8B72E1E568", hash_generated_method = "819C94DF9A538AD736D803F7C97D6DA1")
    public int getInt(int row, int column) {
        int varEE76896E32EEB64BFB310F2A5B6E4AE8_1636836777 = ((int) getLong(row, column));
        addTaint(row);
        addTaint(column);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_595968463 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_595968463;
        // ---------- Original Method ----------
        //return (int) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.800 -0400", hash_original_method = "27DD398413CBDB3B58DB63ADFF69899A", hash_generated_method = "501BB8F1D4A73BA2AB8D8B85A68EF866")
    public float getFloat(int row, int column) {
        float varD967860490A37C92BE233D56CF4148A1_1746724467 = ((float) getDouble(row, column));
        addTaint(row);
        addTaint(column);
        float var546ADE640B6EDFBC8A086EF31347E768_347464460 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_347464460;
        // ---------- Original Method ----------
        //return (float) getDouble(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.801 -0400", hash_original_method = "6CB3F309867B314299E03BAA3ADD01B0", hash_generated_method = "CDE431197DDAF7B67554BF1A4CE72519")
    public boolean putBlob(byte[] value, int row, int column) {
        acquireReference();
        try 
        {
            boolean varDBF02A91A7F9FB2B44A262BEC4A20A1D_232873044 = (nativePutBlob(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(value[0]);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_54356943 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_54356943;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutBlob(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.801 -0400", hash_original_method = "6CB1D543D51D5DCA24055F8F53C41BAF", hash_generated_method = "0B34CDA4D140A54B893953797386B2BE")
    public boolean putString(String value, int row, int column) {
        acquireReference();
        try 
        {
            boolean varEC5141FBADFF6FC9B99D1AD371FD7973_1165475994 = (nativePutString(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(value.getTaint());
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_495264304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_495264304;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutString(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.803 -0400", hash_original_method = "2778A952D34B60D93ADEBF86D42CFB13", hash_generated_method = "8E615C98FA832B97339C83DC281C5B88")
    public boolean putLong(long value, int row, int column) {
        acquireReference();
        try 
        {
            boolean var7996BC4E6D3BD70C3EF52496645FC6D8_635579518 = (nativePutLong(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(value);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1763583296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1763583296;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutLong(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.804 -0400", hash_original_method = "750162916D1917FF199EBD766435A4BC", hash_generated_method = "3069F6582542F153866B2B566DC75FA6")
    public boolean putDouble(double value, int row, int column) {
        acquireReference();
        try 
        {
            boolean var8E20548EEFA5A64A44A4E184ABC6FC3B_1310286896 = (nativePutDouble(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(value);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672238560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672238560;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutDouble(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.804 -0400", hash_original_method = "729F260E3687A604BDCEB4B5144460BE", hash_generated_method = "9415EF69AE27EC243618852A674D3B9A")
    public boolean putNull(int row, int column) {
        acquireReference();
        try 
        {
            boolean varEDCC8D3EE34F721869F33D574DB972AA_1210065735 = (nativePutNull(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2090793701 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2090793701;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.805 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BCD101AD6872563EC2216320AACC1890")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1098831131 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1098831131;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.805 -0400", hash_original_method = "A351847D47687056BE0F3C5BF172823F", hash_generated_method = "FB78C116F0841F48D0ED81095B54A7C5")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mStartPos);
        nativeWriteToParcel(mWindowPtr, dest);
        {
            releaseReference();
        } //End block
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mStartPos);
        //nativeWriteToParcel(mWindowPtr, dest);
        //if ((flags & Parcelable.PARCELABLE_WRITE_RETURN_VALUE) != 0) {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.806 -0400", hash_original_method = "9F0DD3DD42B1176D3BFC90E1CC869BD8", hash_generated_method = "FA9613911A2A6B53687A115BA4086A12")
    @Override
    protected void onAllReferencesReleased() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dispose();
        // ---------- Original Method ----------
        //dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.806 -0400", hash_original_method = "A1A5B0D31D251CEBDD86B0232FAF0913", hash_generated_method = "0339CD783A0DEE30CD26035E51191F0D")
    private void recordNewWindow(int pid, int window) {
        {
            sWindowToPidMap.put(window, pid);
            {
                boolean varC36DF1398F4EE2BD3893C3E1F97813EC_325912179 = (Log.isLoggable(STATS_TAG, Log.VERBOSE));
            } //End collapsed parenthetic
        } //End block
        addTaint(pid);
        addTaint(window);
        // ---------- Original Method ----------
        //synchronized (sWindowToPidMap) {
            //sWindowToPidMap.put(window, pid);
            //if (Log.isLoggable(STATS_TAG, Log.VERBOSE)) {
                //Log.i(STATS_TAG, "Created a new Cursor. " + printStats());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.806 -0400", hash_original_method = "35EFD039834BDFB7DFA5FAF4FCFF938C", hash_generated_method = "CF04122387C1002AAA313BC3EDB697E2")
    private void recordClosingOfWindow(int window) {
        {
            {
                boolean var1E358411B44E94E4F474E426A793D087_633554215 = (sWindowToPidMap.size() == 0);
            } //End collapsed parenthetic
            sWindowToPidMap.delete(window);
        } //End block
        addTaint(window);
        // ---------- Original Method ----------
        //synchronized (sWindowToPidMap) {
            //if (sWindowToPidMap.size() == 0) {
                //return;
            //}
            //sWindowToPidMap.delete(window);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.807 -0400", hash_original_method = "FB6D9C80437A7691015FDFE53D1A15C9", hash_generated_method = "53889CE067323AE5916AC28611D44B7E")
    private String printStats() {
        String varB4EAC82CA7396A68D541C85D26508E83_1039189745 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1370148725 = null; //Variable for return #2
        StringBuilder buff = new StringBuilder();
        int myPid = Process.myPid();
        int total = 0;
        SparseIntArray pidCounts = new SparseIntArray();
        {
            int size = sWindowToPidMap.size();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1039189745 = "";
            } //End block
            {
                int indx = 0;
                {
                    int pid = sWindowToPidMap.valueAt(indx);
                    int value = pidCounts.get(pid);
                    pidCounts.put(pid, ++value);
                } //End block
            } //End collapsed parenthetic
        } //End block
        int numPids = pidCounts.size();
        {
            int i = 0;
            {
                buff.append(" (# cursors opened by ");
                int pid = pidCounts.keyAt(i);
                {
                    buff.append("this proc=");
                } //End block
                {
                    buff.append("pid " + pid + "=");
                } //End block
                int num = pidCounts.get(pid);
                buff.append(num + ")");
                total += num;
            } //End block
        } //End collapsed parenthetic
        String s;
        boolean var73BE181800F050B89C23EBA00B9AC3AE_1753472006 = ((buff.length() > 980));
        s = buff.substring(0, 980);
        s = buff.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1370148725 = "# Open Cursors=" + total + s;
        String varA7E53CE21691AB073D9660D615818899_821443556; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_821443556 = varB4EAC82CA7396A68D541C85D26508E83_1039189745;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_821443556 = varB4EAC82CA7396A68D541C85D26508E83_1370148725;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_821443556.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_821443556;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.808 -0400", hash_original_method = "2B041B6FC7B2CED29CA29EA62E026B41", hash_generated_method = "9AA512E29E584FECB3862190292951A9")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_894021449 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_894021449 = getName() + " {" + Integer.toHexString(mWindowPtr) + "}";
        varB4EAC82CA7396A68D541C85D26508E83_894021449.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_894021449;
        // ---------- Original Method ----------
        //return getName() + " {" + Integer.toHexString(mWindowPtr) + "}";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.808 -0400", hash_original_field = "5B3E3E3506C786C5E8C89033AAFE5334", hash_generated_field = "8D10DBBD9161B24BFA923BA8ACB7AE58")

    private static final String STATS_TAG = "CursorWindowStats";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.808 -0400", hash_original_field = "3B37C53C1B3E3C57E085C22B6489179B", hash_generated_field = "BA4FA4A72DC6187CE1C91540199A8E43")

    private static final int sCursorWindowSize = Resources.getSystem().getInteger(
                com.android.internal.R.integer.config_cursorWindowSize) * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.808 -0400", hash_original_field = "F4DD3BCA06A6A101A72063C4264660FF", hash_generated_field = "9DA0907775B4EA7DABCE5B56F25B0D3B")

    public static final Parcelable.Creator<CursorWindow> CREATOR
            = new Parcelable.Creator<CursorWindow>() {
        public CursorWindow createFromParcel(Parcel source) {
            return new CursorWindow(source);
        }

        public CursorWindow[] newArray(int size) {
            return new CursorWindow[size];
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.809 -0400", hash_original_field = "E92F2862489B24AFB0331EE5C78DA3B9", hash_generated_field = "E194A8535700746837F74D9B692D7DA6")

    private static final SparseIntArray sWindowToPidMap = new SparseIntArray();
    // orphaned legacy method
    public CursorWindow createFromParcel(Parcel source) {
            return new CursorWindow(source);
        }
    
    // orphaned legacy method
    public CursorWindow[] newArray(int size) {
            return new CursorWindow[size];
        }
    
}

