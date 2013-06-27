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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.201 -0400", hash_original_field = "0513C934C32593F0CDE478394F5606CD", hash_generated_field = "38FB3A768EF6B5DA39D97BE6BF469283")

    public int mWindowPtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.201 -0400", hash_original_field = "4770B54049ADFE51BD91A1F9D13B56D1", hash_generated_field = "D37936E7DE7BA2848F09C9211D0F059F")

    private int mStartPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.201 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.201 -0400", hash_original_field = "FAB63045DAC8675C1DE9648413C0413D", hash_generated_field = "8ABB9EA4A0BD4BB4F6031F5BD3618F43")

    private CloseGuard mCloseGuard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.220 -0400", hash_original_method = "D2526397A12BC25EA910BA6CE9A2504E", hash_generated_method = "7C450B22A4DE3CA3D195D3B166A99664")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.222 -0400", hash_original_method = "CB3D999FBD9663B85250B0069300DD19", hash_generated_method = "D08F1A46F0A4CBA01B58E03B3B15ABD8")
    @Deprecated
    public  CursorWindow(boolean localWindow) {
        this((String)null);
        addTaint(localWindow);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.231 -0400", hash_original_method = "2F52A6C89F1D54A86C82C46FF5E1EC25", hash_generated_method = "9CB142BDB609683CB1078BB44AFE7DFE")
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
        return {DSUtils.UNKNOWN_BYTE};
    }

    
        private static String nativeGetString(int windowPtr, int row, int column) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
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
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.289 -0400", hash_original_method = "896D51A0732498DB684FD2752503707E", hash_generated_method = "0752F4C2ECB81F09870F8C2C0033EA08")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.290 -0400", hash_original_method = "DF965B7262A7C1EB6D66FE3F57E4031E", hash_generated_method = "9080E454EBBC0348075C834CDD8ACAC3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.301 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "25970825632C9E820AB393516E4C7B87")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1073896796 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1073896796 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_1073896796.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1073896796;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.302 -0400", hash_original_method = "6B12CEFAA1DE3FB86CA989F7EF7D159A", hash_generated_method = "138BAE56F7E233D621D61B747D55599C")
    public void close() {
        releaseReference();
        // ---------- Original Method ----------
        //releaseReference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.303 -0400", hash_original_method = "979E75E660A1C8BD17328FDD55823D54", hash_generated_method = "1A43E506686E999BD298E5363FB767E7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.310 -0400", hash_original_method = "E83B1D6D3C97BD3B3A2AA134F51457E7", hash_generated_method = "FF7B6084EB77DAC0DB72A53158CF41EA")
    public int getStartPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_896152168 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_896152168;
        // ---------- Original Method ----------
        //return mStartPos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.320 -0400", hash_original_method = "A3D22CBF25891D62569B204C4A11C84D", hash_generated_method = "494AFECC1CA5EB1938A9EB7987E5F3E4")
    public void setStartPosition(int pos) {
        mStartPos = pos;
        // ---------- Original Method ----------
        //mStartPos = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.324 -0400", hash_original_method = "FEBAC209BE2E731A41AC61FC29EF2631", hash_generated_method = "A9AB7D0AB42C6678A5AA9AE0084BE63F")
    public int getNumRows() {
        acquireReference();
        try 
        {
            int var414F51D82D9BF7C55CA2723FC84CAD14_696499274 = (nativeGetNumRows(mWindowPtr));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669952755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_669952755;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetNumRows(mWindowPtr);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.325 -0400", hash_original_method = "06070130EC2CA13555B4890F162F9E48", hash_generated_method = "C2DC57CE2DF1F6006C777F805969D938")
    public boolean setNumColumns(int columnNum) {
        acquireReference();
        try 
        {
            boolean var1AD4C2C634C3D9AB4728527E89734163_1970635119 = (nativeSetNumColumns(mWindowPtr, columnNum));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(columnNum);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1274688935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1274688935;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeSetNumColumns(mWindowPtr, columnNum);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.325 -0400", hash_original_method = "EA2451DCCE3D57D72B2D978A02AB8CBE", hash_generated_method = "9F10A8131F03D89C4769A4C0FDE71615")
    public boolean allocRow() {
        acquireReference();
        try 
        {
            boolean var01A0BA1F86225288F569462FC8FBBF5E_1724960714 = (nativeAllocRow(mWindowPtr));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_944102216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_944102216;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeAllocRow(mWindowPtr);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.350 -0400", hash_original_method = "B379FF08DED00763293DB0E42243B555", hash_generated_method = "55E5FB6178C783385D74EF917B74755D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.361 -0400", hash_original_method = "49D7CBD5A9292352030392B89291BE3D", hash_generated_method = "EE0057B73421B33BF4E07872211C5247")
    @Deprecated
    public boolean isNull(int row, int column) {
        boolean var97A1C67CC6DAFD00A3A8F4664D9EE64B_1886735350 = (getType(row, column) == Cursor.FIELD_TYPE_NULL);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2115285322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2115285322;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.450 -0400", hash_original_method = "C746642EB39EFB60299B9B6078CB8713", hash_generated_method = "5E93D2FA74C5A8CC839803508EC9B03D")
    @Deprecated
    public boolean isBlob(int row, int column) {
        int type;
        type = getType(row, column);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_549934513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_549934513;
        // ---------- Original Method ----------
        //int type = getType(row, column);
        //return type == Cursor.FIELD_TYPE_BLOB || type == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.450 -0400", hash_original_method = "F41C7C64C57B82BE924AB092481D8C56", hash_generated_method = "2D63DDFB43162ACB97AB00DE793D8534")
    @Deprecated
    public boolean isLong(int row, int column) {
        boolean var1DB86FDE6B4703FBCFBD16036E160C9C_1833597656 = (getType(row, column) == Cursor.FIELD_TYPE_INTEGER);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_539514397 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_539514397;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.464 -0400", hash_original_method = "AB10FF6E7457EC84D59F089A4F39FCC7", hash_generated_method = "4E29AEE4F4D3619044CD8E61268ABAA8")
    @Deprecated
    public boolean isFloat(int row, int column) {
        boolean var6554498C7E79ED2247913695DFC28232_2023233179 = (getType(row, column) == Cursor.FIELD_TYPE_FLOAT);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_955479557 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_955479557;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.465 -0400", hash_original_method = "235C1A23640EE5ABC2401DF58B1A3F61", hash_generated_method = "40172AEC4ED077885494368369BD3C19")
    @Deprecated
    public boolean isString(int row, int column) {
        int type;
        type = getType(row, column);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1755843981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1755843981;
        // ---------- Original Method ----------
        //int type = getType(row, column);
        //return type == Cursor.FIELD_TYPE_STRING || type == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.496 -0400", hash_original_method = "8E937452D8006A30B303869F5FCBB330", hash_generated_method = "4C430895B314FDF60801BF656BFA1674")
    public int getType(int row, int column) {
        acquireReference();
        try 
        {
            int var71CCA26C17E48AE0D0877F9F348F7D74_2120127918 = (nativeGetType(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021483303 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021483303;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetType(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.497 -0400", hash_original_method = "369AEBF74D7711C2C086D87D281ECBA3", hash_generated_method = "950E23941BD01F4830C6C3957E9733C1")
    public byte[] getBlob(int row, int column) {
        acquireReference();
        try 
        {
            byte[] varBD638E3555273746DC3865B80681F60E_593595185 = (nativeGetBlob(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_912603109 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_912603109;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetBlob(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.499 -0400", hash_original_method = "91E1480DC9AA77B4570FAB2ABB8DFF8A", hash_generated_method = "952970BD4CDCECD16DAA8DFFD6E4CAE3")
    public String getString(int row, int column) {
        String varB4EAC82CA7396A68D541C85D26508E83_2010848242 = null; //Variable for return #1
        acquireReference();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2010848242 = nativeGetString(mWindowPtr, row - mStartPos, column);
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        varB4EAC82CA7396A68D541C85D26508E83_2010848242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2010848242;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetString(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.516 -0400", hash_original_method = "58A64F01A8AD746344B9549C1A3482B7", hash_generated_method = "1EFC31AA95A6ED8056B5D86874A5A6F7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.517 -0400", hash_original_method = "AD6EFD172162F129E252A5B000066DBD", hash_generated_method = "020586B06402E2531D828F6573F8A7AF")
    public long getLong(int row, int column) {
        acquireReference();
        try 
        {
            long var168504F324B8494AD63EF9400F960BF4_1186085482 = (nativeGetLong(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1833961776 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1833961776;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetLong(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.538 -0400", hash_original_method = "8A6F3264B03417AA20925F57716C63D9", hash_generated_method = "8D7CD451C4ACC5E06CDCE32DEBCFF04D")
    public double getDouble(int row, int column) {
        acquireReference();
        try 
        {
            double var664302859858AF173EF357CBCF35091D_1613409339 = (nativeGetDouble(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1677734328 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1677734328;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetDouble(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.539 -0400", hash_original_method = "A20DC76A6D7B2E924E48673418BA5751", hash_generated_method = "726A3611BD03C3923C3C2638A8411EA3")
    public short getShort(int row, int column) {
        short var5F63A2F12068779C1BB1A99745C9CAB9_1191877208 = ((short) getLong(row, column));
        addTaint(row);
        addTaint(column);
        short var4F09DAA9D95BCB166A302407A0E0BABE_589545297 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_589545297;
        // ---------- Original Method ----------
        //return (short) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.540 -0400", hash_original_method = "551A86F714BE24A79B828A8B72E1E568", hash_generated_method = "D52099F36C1EE0B11802E4DC0B557CE7")
    public int getInt(int row, int column) {
        int varEE76896E32EEB64BFB310F2A5B6E4AE8_1385278402 = ((int) getLong(row, column));
        addTaint(row);
        addTaint(column);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41822368 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41822368;
        // ---------- Original Method ----------
        //return (int) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.542 -0400", hash_original_method = "27DD398413CBDB3B58DB63ADFF69899A", hash_generated_method = "15EF80813364C0D35DEFFDD0286C022C")
    public float getFloat(int row, int column) {
        float varD967860490A37C92BE233D56CF4148A1_756359357 = ((float) getDouble(row, column));
        addTaint(row);
        addTaint(column);
        float var546ADE640B6EDFBC8A086EF31347E768_1993163655 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1993163655;
        // ---------- Original Method ----------
        //return (float) getDouble(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.550 -0400", hash_original_method = "6CB3F309867B314299E03BAA3ADD01B0", hash_generated_method = "C85442F5622E6FB0E335260D379BB1F1")
    public boolean putBlob(byte[] value, int row, int column) {
        acquireReference();
        try 
        {
            boolean varDBF02A91A7F9FB2B44A262BEC4A20A1D_567041711 = (nativePutBlob(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(value[0]);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418716304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_418716304;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutBlob(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.550 -0400", hash_original_method = "6CB1D543D51D5DCA24055F8F53C41BAF", hash_generated_method = "23F62596FC5AA3826F0C33DA99E93616")
    public boolean putString(String value, int row, int column) {
        acquireReference();
        try 
        {
            boolean varEC5141FBADFF6FC9B99D1AD371FD7973_1907173610 = (nativePutString(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(value.getTaint());
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_457917152 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_457917152;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutString(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.576 -0400", hash_original_method = "2778A952D34B60D93ADEBF86D42CFB13", hash_generated_method = "A741661A928BD1035A2B080F76584C91")
    public boolean putLong(long value, int row, int column) {
        acquireReference();
        try 
        {
            boolean var7996BC4E6D3BD70C3EF52496645FC6D8_672284378 = (nativePutLong(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(value);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1842347818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1842347818;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutLong(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.577 -0400", hash_original_method = "750162916D1917FF199EBD766435A4BC", hash_generated_method = "4C23EAB00D36FE89160FB1D46F9FD50A")
    public boolean putDouble(double value, int row, int column) {
        acquireReference();
        try 
        {
            boolean var8E20548EEFA5A64A44A4E184ABC6FC3B_698757945 = (nativePutDouble(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(value);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_106000508 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_106000508;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutDouble(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.578 -0400", hash_original_method = "729F260E3687A604BDCEB4B5144460BE", hash_generated_method = "D60F57AA176ECCFDC12D07F86286F6D5")
    public boolean putNull(int row, int column) {
        acquireReference();
        try 
        {
            boolean varEDCC8D3EE34F721869F33D574DB972AA_2088501559 = (nativePutNull(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1471589981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1471589981;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.578 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BA4CFF9D4D19BEF5747E230506A69052")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401341358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1401341358;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.607 -0400", hash_original_method = "A351847D47687056BE0F3C5BF172823F", hash_generated_method = "FB78C116F0841F48D0ED81095B54A7C5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.608 -0400", hash_original_method = "9F0DD3DD42B1176D3BFC90E1CC869BD8", hash_generated_method = "FA9613911A2A6B53687A115BA4086A12")
    @Override
    protected void onAllReferencesReleased() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dispose();
        // ---------- Original Method ----------
        //dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.609 -0400", hash_original_method = "A1A5B0D31D251CEBDD86B0232FAF0913", hash_generated_method = "68E809107A61223E08BA7BD099857F99")
    private void recordNewWindow(int pid, int window) {
        {
            sWindowToPidMap.put(window, pid);
            {
                boolean varC36DF1398F4EE2BD3893C3E1F97813EC_1066847562 = (Log.isLoggable(STATS_TAG, Log.VERBOSE));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.609 -0400", hash_original_method = "35EFD039834BDFB7DFA5FAF4FCFF938C", hash_generated_method = "8EB80D59329CF48A3A4C361102C5F9D7")
    private void recordClosingOfWindow(int window) {
        {
            {
                boolean var1E358411B44E94E4F474E426A793D087_324684721 = (sWindowToPidMap.size() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.613 -0400", hash_original_method = "FB6D9C80437A7691015FDFE53D1A15C9", hash_generated_method = "D9491619A678CAC4494FAE2E6C3AA52B")
    private String printStats() {
        String varB4EAC82CA7396A68D541C85D26508E83_501480356 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1229575784 = null; //Variable for return #2
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
                varB4EAC82CA7396A68D541C85D26508E83_501480356 = "";
            } //End block
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
        boolean var73BE181800F050B89C23EBA00B9AC3AE_969769506 = ((buff.length() > 980));
        s = buff.substring(0, 980);
        s = buff.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1229575784 = "# Open Cursors=" + total + s;
        String varA7E53CE21691AB073D9660D615818899_490234738; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_490234738 = varB4EAC82CA7396A68D541C85D26508E83_501480356;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_490234738 = varB4EAC82CA7396A68D541C85D26508E83_1229575784;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_490234738.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_490234738;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.638 -0400", hash_original_method = "2B041B6FC7B2CED29CA29EA62E026B41", hash_generated_method = "500774C4BDE31F49B20DD86D1CA21784")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1603854908 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1603854908 = getName() + " {" + Integer.toHexString(mWindowPtr) + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1603854908.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1603854908;
        // ---------- Original Method ----------
        //return getName() + " {" + Integer.toHexString(mWindowPtr) + "}";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.638 -0400", hash_original_field = "5B3E3E3506C786C5E8C89033AAFE5334", hash_generated_field = "C1524E39D72DDB8B2BEBE20C12A76BB6")

    private static String STATS_TAG = "CursorWindowStats";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.639 -0400", hash_original_field = "3B37C53C1B3E3C57E085C22B6489179B", hash_generated_field = "3898573D803534CFD6E1B18BF7696D14")

    private static int sCursorWindowSize = Resources.getSystem().getInteger(
                com.android.internal.R.integer.config_cursorWindowSize) * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.639 -0400", hash_original_field = "F4DD3BCA06A6A101A72063C4264660FF", hash_generated_field = "9DA0907775B4EA7DABCE5B56F25B0D3B")

    public static final Parcelable.Creator<CursorWindow> CREATOR
            = new Parcelable.Creator<CursorWindow>() {
        public CursorWindow createFromParcel(Parcel source) {
            return new CursorWindow(source);
        }

        public CursorWindow[] newArray(int size) {
            return new CursorWindow[size];
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.639 -0400", hash_original_field = "E92F2862489B24AFB0331EE5C78DA3B9", hash_generated_field = "8545FAEC10A144A5925FBB73E75CDCAC")

    private static SparseIntArray sWindowToPidMap = new SparseIntArray();
}

