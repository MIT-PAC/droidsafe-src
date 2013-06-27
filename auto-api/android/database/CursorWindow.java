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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.971 -0400", hash_original_field = "0513C934C32593F0CDE478394F5606CD", hash_generated_field = "38FB3A768EF6B5DA39D97BE6BF469283")

    public int mWindowPtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.971 -0400", hash_original_field = "4770B54049ADFE51BD91A1F9D13B56D1", hash_generated_field = "D37936E7DE7BA2848F09C9211D0F059F")

    private int mStartPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.971 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.971 -0400", hash_original_field = "FAB63045DAC8675C1DE9648413C0413D", hash_generated_field = "8ABB9EA4A0BD4BB4F6031F5BD3618F43")

    private CloseGuard mCloseGuard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.994 -0400", hash_original_method = "D2526397A12BC25EA910BA6CE9A2504E", hash_generated_method = "7C450B22A4DE3CA3D195D3B166A99664")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:10.995 -0400", hash_original_method = "CB3D999FBD9663B85250B0069300DD19", hash_generated_method = "D08F1A46F0A4CBA01B58E03B3B15ABD8")
    @Deprecated
    public  CursorWindow(boolean localWindow) {
        this((String)null);
        addTaint(localWindow);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.013 -0400", hash_original_method = "2F52A6C89F1D54A86C82C46FF5E1EC25", hash_generated_method = "9CB142BDB609683CB1078BB44AFE7DFE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.052 -0400", hash_original_method = "896D51A0732498DB684FD2752503707E", hash_generated_method = "0752F4C2ECB81F09870F8C2C0033EA08")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.064 -0400", hash_original_method = "DF965B7262A7C1EB6D66FE3F57E4031E", hash_generated_method = "9080E454EBBC0348075C834CDD8ACAC3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.066 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "55388C99FD5D4C49C304277C09DB0550")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_50966581 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_50966581 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_50966581.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_50966581;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.079 -0400", hash_original_method = "6B12CEFAA1DE3FB86CA989F7EF7D159A", hash_generated_method = "138BAE56F7E233D621D61B747D55599C")
    public void close() {
        releaseReference();
        // ---------- Original Method ----------
        //releaseReference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.080 -0400", hash_original_method = "979E75E660A1C8BD17328FDD55823D54", hash_generated_method = "1A43E506686E999BD298E5363FB767E7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.081 -0400", hash_original_method = "E83B1D6D3C97BD3B3A2AA134F51457E7", hash_generated_method = "AD3637F7AFA5CF0F2F3215DFC7E14D8B")
    public int getStartPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330156346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_330156346;
        // ---------- Original Method ----------
        //return mStartPos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.081 -0400", hash_original_method = "A3D22CBF25891D62569B204C4A11C84D", hash_generated_method = "494AFECC1CA5EB1938A9EB7987E5F3E4")
    public void setStartPosition(int pos) {
        mStartPos = pos;
        // ---------- Original Method ----------
        //mStartPos = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.082 -0400", hash_original_method = "FEBAC209BE2E731A41AC61FC29EF2631", hash_generated_method = "032A660ABCA325A19AAAD0D0D65BDE3B")
    public int getNumRows() {
        acquireReference();
        try 
        {
            int var414F51D82D9BF7C55CA2723FC84CAD14_128917098 = (nativeGetNumRows(mWindowPtr));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1793238607 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1793238607;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetNumRows(mWindowPtr);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.106 -0400", hash_original_method = "06070130EC2CA13555B4890F162F9E48", hash_generated_method = "D9D3E5D138CB813CC9FFDBFB0258CD21")
    public boolean setNumColumns(int columnNum) {
        acquireReference();
        try 
        {
            boolean var1AD4C2C634C3D9AB4728527E89734163_896065097 = (nativeSetNumColumns(mWindowPtr, columnNum));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(columnNum);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1967742424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1967742424;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeSetNumColumns(mWindowPtr, columnNum);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.113 -0400", hash_original_method = "EA2451DCCE3D57D72B2D978A02AB8CBE", hash_generated_method = "65A4ED4E57E5663179F77F82F1E4D578")
    public boolean allocRow() {
        acquireReference();
        try 
        {
            boolean var01A0BA1F86225288F569462FC8FBBF5E_1043471667 = (nativeAllocRow(mWindowPtr));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93921865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_93921865;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeAllocRow(mWindowPtr);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.115 -0400", hash_original_method = "B379FF08DED00763293DB0E42243B555", hash_generated_method = "55E5FB6178C783385D74EF917B74755D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.116 -0400", hash_original_method = "49D7CBD5A9292352030392B89291BE3D", hash_generated_method = "F72AFBB5A9E479D24BFAE37F7C6DF0BC")
    @Deprecated
    public boolean isNull(int row, int column) {
        boolean var97A1C67CC6DAFD00A3A8F4664D9EE64B_293565749 = (getType(row, column) == Cursor.FIELD_TYPE_NULL);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598775529 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598775529;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.132 -0400", hash_original_method = "C746642EB39EFB60299B9B6078CB8713", hash_generated_method = "035306BD70F47A1A0627BAA8A35B0EF0")
    @Deprecated
    public boolean isBlob(int row, int column) {
        int type;
        type = getType(row, column);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1998268716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1998268716;
        // ---------- Original Method ----------
        //int type = getType(row, column);
        //return type == Cursor.FIELD_TYPE_BLOB || type == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.137 -0400", hash_original_method = "F41C7C64C57B82BE924AB092481D8C56", hash_generated_method = "51CC86987EB4727ABF93F3113D03A67C")
    @Deprecated
    public boolean isLong(int row, int column) {
        boolean var1DB86FDE6B4703FBCFBD16036E160C9C_916966877 = (getType(row, column) == Cursor.FIELD_TYPE_INTEGER);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513493587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_513493587;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.139 -0400", hash_original_method = "AB10FF6E7457EC84D59F089A4F39FCC7", hash_generated_method = "1F692554D36DCF8528E467BFF072822B")
    @Deprecated
    public boolean isFloat(int row, int column) {
        boolean var6554498C7E79ED2247913695DFC28232_1215738341 = (getType(row, column) == Cursor.FIELD_TYPE_FLOAT);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_319572698 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_319572698;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.153 -0400", hash_original_method = "235C1A23640EE5ABC2401DF58B1A3F61", hash_generated_method = "AACC08466A9284F18F58F03060DF4067")
    @Deprecated
    public boolean isString(int row, int column) {
        int type;
        type = getType(row, column);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_388163326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_388163326;
        // ---------- Original Method ----------
        //int type = getType(row, column);
        //return type == Cursor.FIELD_TYPE_STRING || type == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.154 -0400", hash_original_method = "8E937452D8006A30B303869F5FCBB330", hash_generated_method = "2EBBA19C795421E759BCFB04D24C234D")
    public int getType(int row, int column) {
        acquireReference();
        try 
        {
            int var71CCA26C17E48AE0D0877F9F348F7D74_166189347 = (nativeGetType(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1545651946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1545651946;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetType(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.155 -0400", hash_original_method = "369AEBF74D7711C2C086D87D281ECBA3", hash_generated_method = "74D419C08260ED380A4BA52A81A6F90D")
    public byte[] getBlob(int row, int column) {
        acquireReference();
        try 
        {
            byte[] varBD638E3555273746DC3865B80681F60E_1607806625 = (nativeGetBlob(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1025042921 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1025042921;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetBlob(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.156 -0400", hash_original_method = "91E1480DC9AA77B4570FAB2ABB8DFF8A", hash_generated_method = "4E50256562A537C270CBA933DCB3F7AE")
    public String getString(int row, int column) {
        String varB4EAC82CA7396A68D541C85D26508E83_2107396798 = null; //Variable for return #1
        acquireReference();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2107396798 = nativeGetString(mWindowPtr, row - mStartPos, column);
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        varB4EAC82CA7396A68D541C85D26508E83_2107396798.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2107396798;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetString(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.170 -0400", hash_original_method = "58A64F01A8AD746344B9549C1A3482B7", hash_generated_method = "1EFC31AA95A6ED8056B5D86874A5A6F7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.171 -0400", hash_original_method = "AD6EFD172162F129E252A5B000066DBD", hash_generated_method = "482415502A1C6C3E2694A3FF3781A7DE")
    public long getLong(int row, int column) {
        acquireReference();
        try 
        {
            long var168504F324B8494AD63EF9400F960BF4_888006019 = (nativeGetLong(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_800434007 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_800434007;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetLong(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.197 -0400", hash_original_method = "8A6F3264B03417AA20925F57716C63D9", hash_generated_method = "8DA578571343FCC279FAFD5B582B76AA")
    public double getDouble(int row, int column) {
        acquireReference();
        try 
        {
            double var664302859858AF173EF357CBCF35091D_1338789051 = (nativeGetDouble(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1231441120 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1231441120;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetDouble(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.211 -0400", hash_original_method = "A20DC76A6D7B2E924E48673418BA5751", hash_generated_method = "54E6E01BA1323640149BB97AA0F693CA")
    public short getShort(int row, int column) {
        short var5F63A2F12068779C1BB1A99745C9CAB9_1246890246 = ((short) getLong(row, column));
        addTaint(row);
        addTaint(column);
        short var4F09DAA9D95BCB166A302407A0E0BABE_498886184 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_498886184;
        // ---------- Original Method ----------
        //return (short) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.212 -0400", hash_original_method = "551A86F714BE24A79B828A8B72E1E568", hash_generated_method = "18D03036746446EE6C369F4FD0F7B8F2")
    public int getInt(int row, int column) {
        int varEE76896E32EEB64BFB310F2A5B6E4AE8_34739249 = ((int) getLong(row, column));
        addTaint(row);
        addTaint(column);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_345820696 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_345820696;
        // ---------- Original Method ----------
        //return (int) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.213 -0400", hash_original_method = "27DD398413CBDB3B58DB63ADFF69899A", hash_generated_method = "4AAE7AD94E6C45FDD0C609263504D140")
    public float getFloat(int row, int column) {
        float varD967860490A37C92BE233D56CF4148A1_1463466146 = ((float) getDouble(row, column));
        addTaint(row);
        addTaint(column);
        float var546ADE640B6EDFBC8A086EF31347E768_486828981 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_486828981;
        // ---------- Original Method ----------
        //return (float) getDouble(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.230 -0400", hash_original_method = "6CB3F309867B314299E03BAA3ADD01B0", hash_generated_method = "9C906DFF028C27F6502DF64B13D490CC")
    public boolean putBlob(byte[] value, int row, int column) {
        acquireReference();
        try 
        {
            boolean varDBF02A91A7F9FB2B44A262BEC4A20A1D_1365559475 = (nativePutBlob(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(value[0]);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1570831935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1570831935;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutBlob(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.238 -0400", hash_original_method = "6CB1D543D51D5DCA24055F8F53C41BAF", hash_generated_method = "AEDF562FE91B89A4DFA6A51B1A35B442")
    public boolean putString(String value, int row, int column) {
        acquireReference();
        try 
        {
            boolean varEC5141FBADFF6FC9B99D1AD371FD7973_914664885 = (nativePutString(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(value.getTaint());
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_551888093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_551888093;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutString(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.240 -0400", hash_original_method = "2778A952D34B60D93ADEBF86D42CFB13", hash_generated_method = "4AC4DC8E7E04F15D232EE64A036469C9")
    public boolean putLong(long value, int row, int column) {
        acquireReference();
        try 
        {
            boolean var7996BC4E6D3BD70C3EF52496645FC6D8_1286908296 = (nativePutLong(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(value);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1294342735 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1294342735;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutLong(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.258 -0400", hash_original_method = "750162916D1917FF199EBD766435A4BC", hash_generated_method = "E01F5CA038C7B16E1D3E4FDCB11DA460")
    public boolean putDouble(double value, int row, int column) {
        acquireReference();
        try 
        {
            boolean var8E20548EEFA5A64A44A4E184ABC6FC3B_1247641305 = (nativePutDouble(mWindowPtr, value, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(value);
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2015251281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2015251281;
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutDouble(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.259 -0400", hash_original_method = "729F260E3687A604BDCEB4B5144460BE", hash_generated_method = "08DE2F5E54E2D497AA2BD49F8CB5F4FE")
    public boolean putNull(int row, int column) {
        acquireReference();
        try 
        {
            boolean varEDCC8D3EE34F721869F33D574DB972AA_218865911 = (nativePutNull(mWindowPtr, row - mStartPos, column));
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        addTaint(row);
        addTaint(column);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_832116844 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_832116844;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.272 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "21D0143479FDBB324C50601604743C92")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1298546787 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1298546787;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.273 -0400", hash_original_method = "A351847D47687056BE0F3C5BF172823F", hash_generated_method = "FB78C116F0841F48D0ED81095B54A7C5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.274 -0400", hash_original_method = "9F0DD3DD42B1176D3BFC90E1CC869BD8", hash_generated_method = "FA9613911A2A6B53687A115BA4086A12")
    @Override
    protected void onAllReferencesReleased() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dispose();
        // ---------- Original Method ----------
        //dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.281 -0400", hash_original_method = "A1A5B0D31D251CEBDD86B0232FAF0913", hash_generated_method = "4C6BBB835F65624250535DA3CD6078DC")
    private void recordNewWindow(int pid, int window) {
        {
            sWindowToPidMap.put(window, pid);
            {
                boolean varC36DF1398F4EE2BD3893C3E1F97813EC_1187202701 = (Log.isLoggable(STATS_TAG, Log.VERBOSE));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.299 -0400", hash_original_method = "35EFD039834BDFB7DFA5FAF4FCFF938C", hash_generated_method = "883EDF5B1AECF6F490CD3706E3D727F3")
    private void recordClosingOfWindow(int window) {
        {
            {
                boolean var1E358411B44E94E4F474E426A793D087_2018243822 = (sWindowToPidMap.size() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.318 -0400", hash_original_method = "FB6D9C80437A7691015FDFE53D1A15C9", hash_generated_method = "C09D2D9AF96F10549285845852FA8A55")
    private String printStats() {
        String varB4EAC82CA7396A68D541C85D26508E83_1011263573 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1634699998 = null; //Variable for return #2
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
                varB4EAC82CA7396A68D541C85D26508E83_1011263573 = "";
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
        boolean var73BE181800F050B89C23EBA00B9AC3AE_522034448 = ((buff.length() > 980));
        s = buff.substring(0, 980);
        s = buff.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1634699998 = "# Open Cursors=" + total + s;
        String varA7E53CE21691AB073D9660D615818899_738721427; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_738721427 = varB4EAC82CA7396A68D541C85D26508E83_1011263573;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_738721427 = varB4EAC82CA7396A68D541C85D26508E83_1634699998;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_738721427.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_738721427;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.340 -0400", hash_original_method = "2B041B6FC7B2CED29CA29EA62E026B41", hash_generated_method = "2C25461108A5047705BE11BCF23B973D")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_735342569 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_735342569 = getName() + " {" + Integer.toHexString(mWindowPtr) + "}";
        varB4EAC82CA7396A68D541C85D26508E83_735342569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_735342569;
        // ---------- Original Method ----------
        //return getName() + " {" + Integer.toHexString(mWindowPtr) + "}";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.340 -0400", hash_original_field = "5B3E3E3506C786C5E8C89033AAFE5334", hash_generated_field = "C1524E39D72DDB8B2BEBE20C12A76BB6")

    private static String STATS_TAG = "CursorWindowStats";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.340 -0400", hash_original_field = "3B37C53C1B3E3C57E085C22B6489179B", hash_generated_field = "3898573D803534CFD6E1B18BF7696D14")

    private static int sCursorWindowSize = Resources.getSystem().getInteger(
                com.android.internal.R.integer.config_cursorWindowSize) * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.341 -0400", hash_original_field = "F4DD3BCA06A6A101A72063C4264660FF", hash_generated_field = "9DA0907775B4EA7DABCE5B56F25B0D3B")

    public static final Parcelable.Creator<CursorWindow> CREATOR
            = new Parcelable.Creator<CursorWindow>() {
        public CursorWindow createFromParcel(Parcel source) {
            return new CursorWindow(source);
        }

        public CursorWindow[] newArray(int size) {
            return new CursorWindow[size];
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:11.341 -0400", hash_original_field = "E92F2862489B24AFB0331EE5C78DA3B9", hash_generated_field = "8545FAEC10A144A5925FBB73E75CDCAC")

    private static SparseIntArray sWindowToPidMap = new SparseIntArray();
}

