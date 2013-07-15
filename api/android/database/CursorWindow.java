package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.142 -0400", hash_original_field = "0513C934C32593F0CDE478394F5606CD", hash_generated_field = "38FB3A768EF6B5DA39D97BE6BF469283")

    public int mWindowPtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.142 -0400", hash_original_field = "4770B54049ADFE51BD91A1F9D13B56D1", hash_generated_field = "D37936E7DE7BA2848F09C9211D0F059F")

    private int mStartPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.142 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.143 -0400", hash_original_field = "FAB63045DAC8675C1DE9648413C0413D", hash_generated_field = "91705AACD6DDE42AEA628776AF2A3DC6")

    private final CloseGuard mCloseGuard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.144 -0400", hash_original_method = "D2526397A12BC25EA910BA6CE9A2504E", hash_generated_method = "0A588155715EB24E3CF86E6EB68779E4")
    public  CursorWindow(String name) {
        mStartPos = 0;
        mName = name;
        mWindowPtr = nativeCreate(name, sCursorWindowSize);
    if(mWindowPtr == 0)        
        {
            CursorWindowAllocationException var9F3A43773F1FDEA127DCC735B98E13D1_1653458277 = new CursorWindowAllocationException("Cursor window allocation of " +
                    (sCursorWindowSize / 1024) + " kb failed. " + printStats());
            var9F3A43773F1FDEA127DCC735B98E13D1_1653458277.addTaint(taint);
            throw var9F3A43773F1FDEA127DCC735B98E13D1_1653458277;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.144 -0400", hash_original_method = "CB3D999FBD9663B85250B0069300DD19", hash_generated_method = "D08F1A46F0A4CBA01B58E03B3B15ABD8")
    @Deprecated
    public  CursorWindow(boolean localWindow) {
        this((String)null);
        addTaint(localWindow);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.145 -0400", hash_original_method = "2F52A6C89F1D54A86C82C46FF5E1EC25", hash_generated_method = "CF96D44156EBC604C59612B028EFABB8")
    private  CursorWindow(Parcel source) {
        mStartPos = source.readInt();
        mWindowPtr = nativeCreateFromParcel(source);
    if(mWindowPtr == 0)        
        {
            CursorWindowAllocationException varCFAE9E34368B5907724045AC19C45F58_97979132 = new CursorWindowAllocationException("Cursor window could not be "
                    + "created from binder.");
            varCFAE9E34368B5907724045AC19C45F58_97979132.addTaint(taint);
            throw varCFAE9E34368B5907724045AC19C45F58_97979132;
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

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreate(String name, int cursorWindowSize) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeCreateFromParcel(Parcel parcel) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDispose(int windowPtr) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeWriteToParcel(int windowPtr, Parcel parcel) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeClear(int windowPtr) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetNumRows(int windowPtr) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeSetNumColumns(int windowPtr, int columnNum) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeAllocRow(int windowPtr) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeFreeLastRow(int windowPtr) {
    }

    
    @DSModeled(DSC.SAFE)
    private static int nativeGetType(int windowPtr, int row, int column) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static byte[] nativeGetBlob(int windowPtr, int row, int column) {
        byte[] ret = {DSUtils.UNKNOWN_BYTE};
        return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static String nativeGetString(int windowPtr, int row, int column) {
        	String ret = new String();
        	ret.addTaint(windowPtr);
        	ret.addTaint(row);
        	ret.addTaint(column);
        	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static long nativeGetLong(int windowPtr, int row, int column) {
        return DSUtils.UNKNOWN_LONG;
    }

    
    @DSModeled(DSC.SAFE)
    private static double nativeGetDouble(int windowPtr, int row, int column) {
        return DSUtils.UNKNOWN_DOUBLE;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeCopyStringToBuffer(int windowPtr, int row, int column,
            CharArrayBuffer buffer) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativePutBlob(int windowPtr, byte[] value, int row, int column) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativePutString(int windowPtr, String value, int row, int column) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativePutLong(int windowPtr, long value, int row, int column) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativePutDouble(int windowPtr, double value, int row, int column) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativePutNull(int windowPtr, int row, int column) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSModeled(DSC.SAFE)
    private static String nativeGetName(int windowPtr) {
        	String ret =  new String();
        	ret.addTaint(windowPtr);
        	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.152 -0400", hash_original_method = "896D51A0732498DB684FD2752503707E", hash_generated_method = "DB8F6E7E5ED2C98BDE10FDF8BC3B292D")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
    if(mCloseGuard != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.153 -0400", hash_original_method = "DF965B7262A7C1EB6D66FE3F57E4031E", hash_generated_method = "0C43514FB3CDD1C17CE65F13DE837159")
    private void dispose() {
    if(mCloseGuard != null)        
        {
            mCloseGuard.close();
        } //End block
    if(mWindowPtr != 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.153 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "1017747B3DD425566EC6FF588AC3E42C")
    public String getName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_911961869 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_911961869.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_911961869;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.154 -0400", hash_original_method = "6B12CEFAA1DE3FB86CA989F7EF7D159A", hash_generated_method = "138BAE56F7E233D621D61B747D55599C")
    public void close() {
        releaseReference();
        // ---------- Original Method ----------
        //releaseReference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.154 -0400", hash_original_method = "979E75E660A1C8BD17328FDD55823D54", hash_generated_method = "1A43E506686E999BD298E5363FB767E7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.155 -0400", hash_original_method = "E83B1D6D3C97BD3B3A2AA134F51457E7", hash_generated_method = "BB57CD42F8ED3EDEE79EC7C187ADC667")
    public int getStartPosition() {
        int var4770B54049ADFE51BD91A1F9D13B56D1_825639039 = (mStartPos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067775876 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067775876;
        // ---------- Original Method ----------
        //return mStartPos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.155 -0400", hash_original_method = "A3D22CBF25891D62569B204C4A11C84D", hash_generated_method = "494AFECC1CA5EB1938A9EB7987E5F3E4")
    public void setStartPosition(int pos) {
        mStartPos = pos;
        // ---------- Original Method ----------
        //mStartPos = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.156 -0400", hash_original_method = "FEBAC209BE2E731A41AC61FC29EF2631", hash_generated_method = "493C29B34D12DA2BB883FF940C802145")
    public int getNumRows() {
        acquireReference();
        try 
        {
            int varECCCA87025DAF7CA96BA5CFCF53434E4_517294303 = (nativeGetNumRows(mWindowPtr));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986273888 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_986273888;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetNumRows(mWindowPtr);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.156 -0400", hash_original_method = "06070130EC2CA13555B4890F162F9E48", hash_generated_method = "6A47A116D93F205360DCBE3EA634DC1A")
    public boolean setNumColumns(int columnNum) {
        addTaint(columnNum);
        acquireReference();
        try 
        {
            boolean var32D4895C0E5D1BA8692A534544D13625_1942869858 = (nativeSetNumColumns(mWindowPtr, columnNum));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115669210 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_115669210;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeSetNumColumns(mWindowPtr, columnNum);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.157 -0400", hash_original_method = "EA2451DCCE3D57D72B2D978A02AB8CBE", hash_generated_method = "3128B3E11C14D7A42088FF4A203C2CA2")
    public boolean allocRow() {
        acquireReference();
        try 
        {
            boolean var66288317AE79A865CFA73B4BAD2CCC53_124893164 = (nativeAllocRow(mWindowPtr));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402550428 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402550428;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeAllocRow(mWindowPtr);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.157 -0400", hash_original_method = "B379FF08DED00763293DB0E42243B555", hash_generated_method = "55E5FB6178C783385D74EF917B74755D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.158 -0400", hash_original_method = "49D7CBD5A9292352030392B89291BE3D", hash_generated_method = "CBA338F8F1B4ED655170DDAFEF67EF23")
    @Deprecated
    public boolean isNull(int row, int column) {
        addTaint(column);
        addTaint(row);
        boolean varD9E577A16DD92A666B091378B37A8947_1845258682 = (getType(row, column) == Cursor.FIELD_TYPE_NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1255562780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1255562780;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.158 -0400", hash_original_method = "C746642EB39EFB60299B9B6078CB8713", hash_generated_method = "FAB4D7F098E339D4E8903239C72B2044")
    @Deprecated
    public boolean isBlob(int row, int column) {
        addTaint(column);
        addTaint(row);
        int type = getType(row, column);
        boolean varAC6860B478F79D5CC19963B77A38387D_1059413100 = (type == Cursor.FIELD_TYPE_BLOB || type == Cursor.FIELD_TYPE_NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2003063243 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2003063243;
        // ---------- Original Method ----------
        //int type = getType(row, column);
        //return type == Cursor.FIELD_TYPE_BLOB || type == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.158 -0400", hash_original_method = "F41C7C64C57B82BE924AB092481D8C56", hash_generated_method = "AA0C4E7AB5F080229D04E8CB592B9702")
    @Deprecated
    public boolean isLong(int row, int column) {
        addTaint(column);
        addTaint(row);
        boolean varFC1415BBD761192486068FE788910809_281682591 = (getType(row, column) == Cursor.FIELD_TYPE_INTEGER);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024544103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024544103;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.159 -0400", hash_original_method = "AB10FF6E7457EC84D59F089A4F39FCC7", hash_generated_method = "E95B6317E6B8E94247BB6DFF3DCDF81E")
    @Deprecated
    public boolean isFloat(int row, int column) {
        addTaint(column);
        addTaint(row);
        boolean varFC4BA1D26B8B81B405D2CD6089ADAE34_1730883451 = (getType(row, column) == Cursor.FIELD_TYPE_FLOAT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1724437088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1724437088;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.159 -0400", hash_original_method = "235C1A23640EE5ABC2401DF58B1A3F61", hash_generated_method = "79EBC3FB29C0B11CFE02AD037FB1B427")
    @Deprecated
    public boolean isString(int row, int column) {
        addTaint(column);
        addTaint(row);
        int type = getType(row, column);
        boolean var5523DB8D784D42EE7EDA5F9F7F6DA34B_1071739681 = (type == Cursor.FIELD_TYPE_STRING || type == Cursor.FIELD_TYPE_NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128584832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_128584832;
        // ---------- Original Method ----------
        //int type = getType(row, column);
        //return type == Cursor.FIELD_TYPE_STRING || type == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.160 -0400", hash_original_method = "8E937452D8006A30B303869F5FCBB330", hash_generated_method = "9E42FC9BBAB912D5921BC55A34705F25")
    public int getType(int row, int column) {
        addTaint(column);
        addTaint(row);
        acquireReference();
        try 
        {
            int var51F8F671E60B09C02F4B22CF9527E4DD_149567092 = (nativeGetType(mWindowPtr, row - mStartPos, column));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_54593489 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_54593489;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetType(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.160 -0400", hash_original_method = "369AEBF74D7711C2C086D87D281ECBA3", hash_generated_method = "E24BC793D0ED4FB291401402177AAEDB")
    public byte[] getBlob(int row, int column) {
        addTaint(column);
        addTaint(row);
        acquireReference();
        try 
        {
            byte[] varB4D4264AAFAD1B56BC567BF536895595_574937485 = (nativeGetBlob(mWindowPtr, row - mStartPos, column));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1973069831 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1973069831;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetBlob(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.161 -0400", hash_original_method = "91E1480DC9AA77B4570FAB2ABB8DFF8A", hash_generated_method = "F51FC1BB5736A54831BBF7ECC8F1555F")
    public String getString(int row, int column) {
        addTaint(column);
        addTaint(row);
        acquireReference();
        try 
        {
String var4AA4DA86C222170F791223A95D3AFE2E_925422375 =             nativeGetString(mWindowPtr, row - mStartPos, column);
            var4AA4DA86C222170F791223A95D3AFE2E_925422375.addTaint(taint);
            return var4AA4DA86C222170F791223A95D3AFE2E_925422375;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetString(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.161 -0400", hash_original_method = "58A64F01A8AD746344B9549C1A3482B7", hash_generated_method = "AAED3B3AE1FC1F4D6F45BF5FEEBC6DB0")
    public void copyStringToBuffer(int row, int column, CharArrayBuffer buffer) {
        addTaint(buffer.getTaint());
        addTaint(column);
        addTaint(row);
    if(buffer == null)        
        {
            IllegalArgumentException var5AC2B0CABEFCBDA1206A5F559E6EECE5_1409715101 = new IllegalArgumentException("CharArrayBuffer should not be null");
            var5AC2B0CABEFCBDA1206A5F559E6EECE5_1409715101.addTaint(taint);
            throw var5AC2B0CABEFCBDA1206A5F559E6EECE5_1409715101;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.162 -0400", hash_original_method = "AD6EFD172162F129E252A5B000066DBD", hash_generated_method = "3FB0A8049E2FB72705AF1B6D7008B4DF")
    public long getLong(int row, int column) {
        addTaint(column);
        addTaint(row);
        acquireReference();
        try 
        {
            long varA7B49C3DCEF3B19E8E18DB79BF1DDD02_1906514876 = (nativeGetLong(mWindowPtr, row - mStartPos, column));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1036688917 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1036688917;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetLong(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.162 -0400", hash_original_method = "8A6F3264B03417AA20925F57716C63D9", hash_generated_method = "579EAA7F5004A5BE447BB5D42217B7A5")
    public double getDouble(int row, int column) {
        addTaint(column);
        addTaint(row);
        acquireReference();
        try 
        {
            double varC3438CE738FED57E283C7769EF26B2B0_1439091147 = (nativeGetDouble(mWindowPtr, row - mStartPos, column));
                        double varE8CD7DA078A86726031AD64F35F5A6C0_2091322453 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_2091322453;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativeGetDouble(mWindowPtr, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.163 -0400", hash_original_method = "A20DC76A6D7B2E924E48673418BA5751", hash_generated_method = "57CA71C5C333C0305FBBB6CCB3C431F5")
    public short getShort(int row, int column) {
        addTaint(column);
        addTaint(row);
        short varDD4B7D998BD5EE95A3B18ACF7E07F711_1254292618 = ((short) getLong(row, column));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1715404064 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1715404064;
        // ---------- Original Method ----------
        //return (short) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.163 -0400", hash_original_method = "551A86F714BE24A79B828A8B72E1E568", hash_generated_method = "EE03165238F7D928223EEB53FCC7A5B0")
    public int getInt(int row, int column) {
        addTaint(column);
        addTaint(row);
        int var570BF59F4ECF79754240FA49F2D9942C_1267145069 = ((int) getLong(row, column));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77275371 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77275371;
        // ---------- Original Method ----------
        //return (int) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.164 -0400", hash_original_method = "27DD398413CBDB3B58DB63ADFF69899A", hash_generated_method = "A8BDCD6F0446CAE5E1FA0BDCCCBAD96B")
    public float getFloat(int row, int column) {
        addTaint(column);
        addTaint(row);
        float varCE108B6AE2FBC10AAC0BC5EFB0DFD8B3_1650666336 = ((float) getDouble(row, column));
                float var546ADE640B6EDFBC8A086EF31347E768_92050288 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_92050288;
        // ---------- Original Method ----------
        //return (float) getDouble(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.164 -0400", hash_original_method = "6CB3F309867B314299E03BAA3ADD01B0", hash_generated_method = "8C4BD98A213474007827D83C62B9060A")
    public boolean putBlob(byte[] value, int row, int column) {
        addTaint(column);
        addTaint(row);
        addTaint(value[0]);
        acquireReference();
        try 
        {
            boolean var281493367E51644F927F5A4E4CE5C662_121417501 = (nativePutBlob(mWindowPtr, value, row - mStartPos, column));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1841538854 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1841538854;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutBlob(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.165 -0400", hash_original_method = "6CB1D543D51D5DCA24055F8F53C41BAF", hash_generated_method = "0654DDEF0FC151B0F1DA06F9EEA8EACA")
    public boolean putString(String value, int row, int column) {
        addTaint(column);
        addTaint(row);
        addTaint(value.getTaint());
        acquireReference();
        try 
        {
            boolean var993B1768A8DBD25360BBC4FA02587341_50786697 = (nativePutString(mWindowPtr, value, row - mStartPos, column));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_799763634 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_799763634;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutString(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.166 -0400", hash_original_method = "2778A952D34B60D93ADEBF86D42CFB13", hash_generated_method = "22E7DEC63D999282842835059231AD89")
    public boolean putLong(long value, int row, int column) {
        addTaint(column);
        addTaint(row);
        addTaint(value);
        acquireReference();
        try 
        {
            boolean var626D37D337F333A657284CF674CFB1D4_1308761324 = (nativePutLong(mWindowPtr, value, row - mStartPos, column));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1244992308 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1244992308;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutLong(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.167 -0400", hash_original_method = "750162916D1917FF199EBD766435A4BC", hash_generated_method = "68DD8D0BB1AB9F6B2191298F3266DFFD")
    public boolean putDouble(double value, int row, int column) {
        addTaint(column);
        addTaint(row);
        addTaint(value);
        acquireReference();
        try 
        {
            boolean varDD6F700A323109807DA26C250DA583B7_1317111907 = (nativePutDouble(mWindowPtr, value, row - mStartPos, column));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1345868817 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1345868817;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
        // ---------- Original Method ----------
        //acquireReference();
        //try {
            //return nativePutDouble(mWindowPtr, value, row - mStartPos, column);
        //} finally {
            //releaseReference();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.167 -0400", hash_original_method = "729F260E3687A604BDCEB4B5144460BE", hash_generated_method = "2C488B99D1CACF028B40B1F362F24D60")
    public boolean putNull(int row, int column) {
        addTaint(column);
        addTaint(row);
        acquireReference();
        try 
        {
            boolean varC7A6517D8EAB40C53ADC69104226C91A_723118954 = (nativePutNull(mWindowPtr, row - mStartPos, column));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1417291644 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1417291644;
        } //End block
        finally 
        {
            releaseReference();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.168 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BA562CDCE9C6D94D1559AE20C0D33BA0")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_589340360 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1864606687 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1864606687;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.168 -0400", hash_original_method = "A351847D47687056BE0F3C5BF172823F", hash_generated_method = "3647A7B48C2E71F8F65852265DE0289D")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mStartPos);
        nativeWriteToParcel(mWindowPtr, dest);
    if((flags & Parcelable.PARCELABLE_WRITE_RETURN_VALUE) != 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.169 -0400", hash_original_method = "9F0DD3DD42B1176D3BFC90E1CC869BD8", hash_generated_method = "FA9613911A2A6B53687A115BA4086A12")
    @Override
    protected void onAllReferencesReleased() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dispose();
        // ---------- Original Method ----------
        //dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.169 -0400", hash_original_method = "A1A5B0D31D251CEBDD86B0232FAF0913", hash_generated_method = "441934865EFC76AD1BB40C3EFED93A45")
    private void recordNewWindow(int pid, int window) {
        addTaint(window);
        addTaint(pid);
        synchronized
(sWindowToPidMap)        {
            sWindowToPidMap.put(window, pid);
    if(Log.isLoggable(STATS_TAG, Log.VERBOSE))            
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (sWindowToPidMap) {
            //sWindowToPidMap.put(window, pid);
            //if (Log.isLoggable(STATS_TAG, Log.VERBOSE)) {
                //Log.i(STATS_TAG, "Created a new Cursor. " + printStats());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.170 -0400", hash_original_method = "35EFD039834BDFB7DFA5FAF4FCFF938C", hash_generated_method = "2E3089DDBA93EB46C131D7D4FF2CBDCF")
    private void recordClosingOfWindow(int window) {
        addTaint(window);
        synchronized
(sWindowToPidMap)        {
    if(sWindowToPidMap.size() == 0)            
            {
                return;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.170 -0400", hash_original_method = "FB6D9C80437A7691015FDFE53D1A15C9", hash_generated_method = "BF7A74EC02E0F5CD3D5749DED562D862")
    private String printStats() {
        StringBuilder buff = new StringBuilder();
        int myPid = Process.myPid();
        int total = 0;
        SparseIntArray pidCounts = new SparseIntArray();
        synchronized
(sWindowToPidMap)        {
            int size = sWindowToPidMap.size();
    if(size == 0)            
            {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_51537888 =                 "";
                var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_51537888.addTaint(taint);
                return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_51537888;
            } //End block
for(int indx = 0;indx < size;indx++)
            {
                int pid = sWindowToPidMap.valueAt(indx);
                int value = pidCounts.get(pid);
                pidCounts.put(pid, ++value);
            } //End block
        } //End block
        int numPids = pidCounts.size();
for(int i = 0;i < numPids;i++)
        {
            buff.append(" (# cursors opened by ");
            int pid = pidCounts.keyAt(i);
    if(pid == myPid)            
            {
                buff.append("this proc=");
            } //End block
            else
            {
                buff.append("pid " + pid + "=");
            } //End block
            int num = pidCounts.get(pid);
            buff.append(num + ")");
            total += num;
        } //End block
        String s = (buff.length() > 980) ? buff.substring(0, 980) : buff.toString();
String varD669198966AE1D11824B74353EFDF302_1918044678 =         "# Open Cursors=" + total + s;
        varD669198966AE1D11824B74353EFDF302_1918044678.addTaint(taint);
        return varD669198966AE1D11824B74353EFDF302_1918044678;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.171 -0400", hash_original_method = "2B041B6FC7B2CED29CA29EA62E026B41", hash_generated_method = "6A6B61E8F5F8E3D39B63E0A8090E56C8")
    @Override
    public String toString() {
String var3E9B70506FB423FE6C7A32E2D683FA47_1578629003 =         getName() + " {" + Integer.toHexString(mWindowPtr) + "}";
        var3E9B70506FB423FE6C7A32E2D683FA47_1578629003.addTaint(taint);
        return var3E9B70506FB423FE6C7A32E2D683FA47_1578629003;
        // ---------- Original Method ----------
        //return getName() + " {" + Integer.toHexString(mWindowPtr) + "}";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.171 -0400", hash_original_field = "5B3E3E3506C786C5E8C89033AAFE5334", hash_generated_field = "8D10DBBD9161B24BFA923BA8ACB7AE58")

    private static final String STATS_TAG = "CursorWindowStats";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.171 -0400", hash_original_field = "3B37C53C1B3E3C57E085C22B6489179B", hash_generated_field = "BA4FA4A72DC6187CE1C91540199A8E43")

    private static final int sCursorWindowSize = Resources.getSystem().getInteger(
                com.android.internal.R.integer.config_cursorWindowSize) * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.171 -0400", hash_original_field = "F4DD3BCA06A6A101A72063C4264660FF", hash_generated_field = "9DA0907775B4EA7DABCE5B56F25B0D3B")

    public static final Parcelable.Creator<CursorWindow> CREATOR
            = new Parcelable.Creator<CursorWindow>() {
        public CursorWindow createFromParcel(Parcel source) {
            return new CursorWindow(source);
        }

        public CursorWindow[] newArray(int size) {
            return new CursorWindow[size];
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.171 -0400", hash_original_field = "E92F2862489B24AFB0331EE5C78DA3B9", hash_generated_field = "E194A8535700746837F74D9B692D7DA6")

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

