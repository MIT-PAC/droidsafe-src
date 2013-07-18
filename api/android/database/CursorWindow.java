package android.database;

// Droidsafe Imports
import android.content.res.Resources;
import android.database.sqlite.SQLiteClosable;
import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import android.util.SparseIntArray;
import dalvik.system.CloseGuard;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

public class CursorWindow extends SQLiteClosable implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.717 -0400", hash_original_field = "0513C934C32593F0CDE478394F5606CD", hash_generated_field = "38FB3A768EF6B5DA39D97BE6BF469283")

    public int mWindowPtr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.717 -0400", hash_original_field = "4770B54049ADFE51BD91A1F9D13B56D1", hash_generated_field = "D37936E7DE7BA2848F09C9211D0F059F")

    private int mStartPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.717 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.717 -0400", hash_original_field = "FAB63045DAC8675C1DE9648413C0413D", hash_generated_field = "91705AACD6DDE42AEA628776AF2A3DC6")

    private final CloseGuard mCloseGuard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.718 -0400", hash_original_method = "D2526397A12BC25EA910BA6CE9A2504E", hash_generated_method = "EBC092545ED0903AEE1DB06FB6809DDD")
    public  CursorWindow(String name) {
        mStartPos = 0;
        mName = name;
        mWindowPtr = nativeCreate(name, sCursorWindowSize);
        if(mWindowPtr == 0)        
        {
            CursorWindowAllocationException var9F3A43773F1FDEA127DCC735B98E13D1_1473447083 = new CursorWindowAllocationException("Cursor window allocation of " +
                    (sCursorWindowSize / 1024) + " kb failed. " + printStats());
            var9F3A43773F1FDEA127DCC735B98E13D1_1473447083.addTaint(taint);
            throw var9F3A43773F1FDEA127DCC735B98E13D1_1473447083;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.718 -0400", hash_original_method = "CB3D999FBD9663B85250B0069300DD19", hash_generated_method = "D08F1A46F0A4CBA01B58E03B3B15ABD8")
    @Deprecated
    public  CursorWindow(boolean localWindow) {
        this((String)null);
        addTaint(localWindow);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.719 -0400", hash_original_method = "2F52A6C89F1D54A86C82C46FF5E1EC25", hash_generated_method = "A6D530AB8F68F628B90E02AB82F602A3")
    private  CursorWindow(Parcel source) {
        mStartPos = source.readInt();
        mWindowPtr = nativeCreateFromParcel(source);
        if(mWindowPtr == 0)        
        {
            CursorWindowAllocationException varCFAE9E34368B5907724045AC19C45F58_1829236382 = new CursorWindowAllocationException("Cursor window could not be "
                    + "created from binder.");
            varCFAE9E34368B5907724045AC19C45F58_1829236382.addTaint(taint);
            throw varCFAE9E34368B5907724045AC19C45F58_1829236382;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.727 -0400", hash_original_method = "896D51A0732498DB684FD2752503707E", hash_generated_method = "DB8F6E7E5ED2C98BDE10FDF8BC3B292D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.728 -0400", hash_original_method = "DF965B7262A7C1EB6D66FE3F57E4031E", hash_generated_method = "0C43514FB3CDD1C17CE65F13DE837159")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.729 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "D2CDAAEA0A06E67BE1D914B20E1A52F5")
    public String getName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_1679548868 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_1679548868.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_1679548868;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.730 -0400", hash_original_method = "6B12CEFAA1DE3FB86CA989F7EF7D159A", hash_generated_method = "138BAE56F7E233D621D61B747D55599C")
    public void close() {
        releaseReference();
        // ---------- Original Method ----------
        //releaseReference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.730 -0400", hash_original_method = "979E75E660A1C8BD17328FDD55823D54", hash_generated_method = "1A43E506686E999BD298E5363FB767E7")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.731 -0400", hash_original_method = "E83B1D6D3C97BD3B3A2AA134F51457E7", hash_generated_method = "294A15977FF8904478B6049B94390A67")
    public int getStartPosition() {
        int var4770B54049ADFE51BD91A1F9D13B56D1_919369163 = (mStartPos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034935362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034935362;
        // ---------- Original Method ----------
        //return mStartPos;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.732 -0400", hash_original_method = "A3D22CBF25891D62569B204C4A11C84D", hash_generated_method = "494AFECC1CA5EB1938A9EB7987E5F3E4")
    public void setStartPosition(int pos) {
        mStartPos = pos;
        // ---------- Original Method ----------
        //mStartPos = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.732 -0400", hash_original_method = "FEBAC209BE2E731A41AC61FC29EF2631", hash_generated_method = "FF60956C96211BF5C1B5F6DE8FB0DE08")
    public int getNumRows() {
        acquireReference();
        try 
        {
            int varECCCA87025DAF7CA96BA5CFCF53434E4_332997267 = (nativeGetNumRows(mWindowPtr));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2077167715 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2077167715;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.733 -0400", hash_original_method = "06070130EC2CA13555B4890F162F9E48", hash_generated_method = "EBCFF96C7F69428B08EEEFDC76B62997")
    public boolean setNumColumns(int columnNum) {
        addTaint(columnNum);
        acquireReference();
        try 
        {
            boolean var32D4895C0E5D1BA8692A534544D13625_1028815147 = (nativeSetNumColumns(mWindowPtr, columnNum));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_590309474 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_590309474;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.734 -0400", hash_original_method = "EA2451DCCE3D57D72B2D978A02AB8CBE", hash_generated_method = "520BF208F6BA46D5D20CCF2F4941CE13")
    public boolean allocRow() {
        acquireReference();
        try 
        {
            boolean var66288317AE79A865CFA73B4BAD2CCC53_1331381268 = (nativeAllocRow(mWindowPtr));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1437203141 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1437203141;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.735 -0400", hash_original_method = "B379FF08DED00763293DB0E42243B555", hash_generated_method = "55E5FB6178C783385D74EF917B74755D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.736 -0400", hash_original_method = "49D7CBD5A9292352030392B89291BE3D", hash_generated_method = "F66A9E428FF40DC8E7E52F5DAE43A7EB")
    @Deprecated
    public boolean isNull(int row, int column) {
        addTaint(column);
        addTaint(row);
        boolean varD9E577A16DD92A666B091378B37A8947_302163355 = (getType(row, column) == Cursor.FIELD_TYPE_NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1397973375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1397973375;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.737 -0400", hash_original_method = "C746642EB39EFB60299B9B6078CB8713", hash_generated_method = "5E1F643070F85101BA96C8EAE28B61CC")
    @Deprecated
    public boolean isBlob(int row, int column) {
        addTaint(column);
        addTaint(row);
        int type = getType(row, column);
        boolean varAC6860B478F79D5CC19963B77A38387D_449070329 = (type == Cursor.FIELD_TYPE_BLOB || type == Cursor.FIELD_TYPE_NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1120471708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1120471708;
        // ---------- Original Method ----------
        //int type = getType(row, column);
        //return type == Cursor.FIELD_TYPE_BLOB || type == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.738 -0400", hash_original_method = "F41C7C64C57B82BE924AB092481D8C56", hash_generated_method = "A9C58506C94F4B7CE4F4ADFF03839C43")
    @Deprecated
    public boolean isLong(int row, int column) {
        addTaint(column);
        addTaint(row);
        boolean varFC1415BBD761192486068FE788910809_1388445575 = (getType(row, column) == Cursor.FIELD_TYPE_INTEGER);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856765434 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856765434;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.738 -0400", hash_original_method = "AB10FF6E7457EC84D59F089A4F39FCC7", hash_generated_method = "4495021732F84DC91761F7ADA075CD2E")
    @Deprecated
    public boolean isFloat(int row, int column) {
        addTaint(column);
        addTaint(row);
        boolean varFC4BA1D26B8B81B405D2CD6089ADAE34_1088269668 = (getType(row, column) == Cursor.FIELD_TYPE_FLOAT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013343587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013343587;
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.739 -0400", hash_original_method = "235C1A23640EE5ABC2401DF58B1A3F61", hash_generated_method = "48E53DC6809B6102516EC64C4F6F9B50")
    @Deprecated
    public boolean isString(int row, int column) {
        addTaint(column);
        addTaint(row);
        int type = getType(row, column);
        boolean var5523DB8D784D42EE7EDA5F9F7F6DA34B_1055050593 = (type == Cursor.FIELD_TYPE_STRING || type == Cursor.FIELD_TYPE_NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1899259024 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1899259024;
        // ---------- Original Method ----------
        //int type = getType(row, column);
        //return type == Cursor.FIELD_TYPE_STRING || type == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.740 -0400", hash_original_method = "8E937452D8006A30B303869F5FCBB330", hash_generated_method = "1D8E2557F9BF605D7AC8009C274231A8")
    public int getType(int row, int column) {
        addTaint(column);
        addTaint(row);
        acquireReference();
        try 
        {
            int var51F8F671E60B09C02F4B22CF9527E4DD_717613118 = (nativeGetType(mWindowPtr, row - mStartPos, column));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_604043672 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_604043672;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.741 -0400", hash_original_method = "369AEBF74D7711C2C086D87D281ECBA3", hash_generated_method = "082C33DE55C76F15B19512258CE92C9F")
    public byte[] getBlob(int row, int column) {
        addTaint(column);
        addTaint(row);
        acquireReference();
        try 
        {
            byte[] varB4D4264AAFAD1B56BC567BF536895595_1971825582 = (nativeGetBlob(mWindowPtr, row - mStartPos, column));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_390880992 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_390880992;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.742 -0400", hash_original_method = "91E1480DC9AA77B4570FAB2ABB8DFF8A", hash_generated_method = "D8C480D878935632ED75A683A2903CFB")
    public String getString(int row, int column) {
        addTaint(column);
        addTaint(row);
        acquireReference();
        try 
        {
String var4AA4DA86C222170F791223A95D3AFE2E_192721827 =             nativeGetString(mWindowPtr, row - mStartPos, column);
            var4AA4DA86C222170F791223A95D3AFE2E_192721827.addTaint(taint);
            return var4AA4DA86C222170F791223A95D3AFE2E_192721827;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.742 -0400", hash_original_method = "58A64F01A8AD746344B9549C1A3482B7", hash_generated_method = "E662B9381AB2E3B7AA0672AC50856B4A")
    public void copyStringToBuffer(int row, int column, CharArrayBuffer buffer) {
        addTaint(buffer.getTaint());
        addTaint(column);
        addTaint(row);
        if(buffer == null)        
        {
            IllegalArgumentException var5AC2B0CABEFCBDA1206A5F559E6EECE5_663227085 = new IllegalArgumentException("CharArrayBuffer should not be null");
            var5AC2B0CABEFCBDA1206A5F559E6EECE5_663227085.addTaint(taint);
            throw var5AC2B0CABEFCBDA1206A5F559E6EECE5_663227085;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.743 -0400", hash_original_method = "AD6EFD172162F129E252A5B000066DBD", hash_generated_method = "F9A6612F3E9C4EE5D599A469286217F5")
    public long getLong(int row, int column) {
        addTaint(column);
        addTaint(row);
        acquireReference();
        try 
        {
            long varA7B49C3DCEF3B19E8E18DB79BF1DDD02_570430475 = (nativeGetLong(mWindowPtr, row - mStartPos, column));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1930730041 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1930730041;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.743 -0400", hash_original_method = "8A6F3264B03417AA20925F57716C63D9", hash_generated_method = "AF9E1DE46F4CA6F4A0121AA0282798A1")
    public double getDouble(int row, int column) {
        addTaint(column);
        addTaint(row);
        acquireReference();
        try 
        {
            double varC3438CE738FED57E283C7769EF26B2B0_830956964 = (nativeGetDouble(mWindowPtr, row - mStartPos, column));
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1127225207 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1127225207;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.744 -0400", hash_original_method = "A20DC76A6D7B2E924E48673418BA5751", hash_generated_method = "7FCD5F5E152FE808A47DA609767D50DB")
    public short getShort(int row, int column) {
        addTaint(column);
        addTaint(row);
        short varDD4B7D998BD5EE95A3B18ACF7E07F711_531522770 = ((short) getLong(row, column));
                short var4F09DAA9D95BCB166A302407A0E0BABE_241980267 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_241980267;
        // ---------- Original Method ----------
        //return (short) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.744 -0400", hash_original_method = "551A86F714BE24A79B828A8B72E1E568", hash_generated_method = "1B0402E9F4A8955301DEF6C1411C0F70")
    public int getInt(int row, int column) {
        addTaint(column);
        addTaint(row);
        int var570BF59F4ECF79754240FA49F2D9942C_2021347678 = ((int) getLong(row, column));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070245293 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070245293;
        // ---------- Original Method ----------
        //return (int) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.745 -0400", hash_original_method = "27DD398413CBDB3B58DB63ADFF69899A", hash_generated_method = "3B9FC6625748387A1C517933964779ED")
    public float getFloat(int row, int column) {
        addTaint(column);
        addTaint(row);
        float varCE108B6AE2FBC10AAC0BC5EFB0DFD8B3_362910417 = ((float) getDouble(row, column));
                float var546ADE640B6EDFBC8A086EF31347E768_1963886666 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1963886666;
        // ---------- Original Method ----------
        //return (float) getDouble(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.745 -0400", hash_original_method = "6CB3F309867B314299E03BAA3ADD01B0", hash_generated_method = "6DE079A658D094166383209D9CA6DB20")
    public boolean putBlob(byte[] value, int row, int column) {
        addTaint(column);
        addTaint(row);
        addTaint(value[0]);
        acquireReference();
        try 
        {
            boolean var281493367E51644F927F5A4E4CE5C662_496003500 = (nativePutBlob(mWindowPtr, value, row - mStartPos, column));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_318204010 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_318204010;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.746 -0400", hash_original_method = "6CB1D543D51D5DCA24055F8F53C41BAF", hash_generated_method = "B5DF2CA52B369B6C002B4E47B4D16441")
    public boolean putString(String value, int row, int column) {
        addTaint(column);
        addTaint(row);
        addTaint(value.getTaint());
        acquireReference();
        try 
        {
            boolean var993B1768A8DBD25360BBC4FA02587341_713362118 = (nativePutString(mWindowPtr, value, row - mStartPos, column));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_444951618 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_444951618;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.747 -0400", hash_original_method = "2778A952D34B60D93ADEBF86D42CFB13", hash_generated_method = "C34571A9F760175AD8F2685151CD6757")
    public boolean putLong(long value, int row, int column) {
        addTaint(column);
        addTaint(row);
        addTaint(value);
        acquireReference();
        try 
        {
            boolean var626D37D337F333A657284CF674CFB1D4_1740329216 = (nativePutLong(mWindowPtr, value, row - mStartPos, column));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_327720170 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_327720170;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.748 -0400", hash_original_method = "750162916D1917FF199EBD766435A4BC", hash_generated_method = "626FC033D95181D0488BAE68A9CCDE3D")
    public boolean putDouble(double value, int row, int column) {
        addTaint(column);
        addTaint(row);
        addTaint(value);
        acquireReference();
        try 
        {
            boolean varDD6F700A323109807DA26C250DA583B7_1699096291 = (nativePutDouble(mWindowPtr, value, row - mStartPos, column));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1287513314 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1287513314;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.749 -0400", hash_original_method = "729F260E3687A604BDCEB4B5144460BE", hash_generated_method = "74D171A066EB121D82059CEA30EE0870")
    public boolean putNull(int row, int column) {
        addTaint(column);
        addTaint(row);
        acquireReference();
        try 
        {
            boolean varC7A6517D8EAB40C53ADC69104226C91A_1519208147 = (nativePutNull(mWindowPtr, row - mStartPos, column));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_918591177 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_918591177;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.750 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "82DB0EE080F3E2F7E0F72B61C191A000")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_250492050 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_489162326 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_489162326;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.750 -0400", hash_original_method = "A351847D47687056BE0F3C5BF172823F", hash_generated_method = "3647A7B48C2E71F8F65852265DE0289D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.751 -0400", hash_original_method = "9F0DD3DD42B1176D3BFC90E1CC869BD8", hash_generated_method = "FA9613911A2A6B53687A115BA4086A12")
    @Override
    protected void onAllReferencesReleased() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dispose();
        // ---------- Original Method ----------
        //dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.751 -0400", hash_original_method = "A1A5B0D31D251CEBDD86B0232FAF0913", hash_generated_method = "441934865EFC76AD1BB40C3EFED93A45")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.752 -0400", hash_original_method = "35EFD039834BDFB7DFA5FAF4FCFF938C", hash_generated_method = "2E3089DDBA93EB46C131D7D4FF2CBDCF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.753 -0400", hash_original_method = "FB6D9C80437A7691015FDFE53D1A15C9", hash_generated_method = "8108349B8F14A9FD7E444DB38884D567")
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
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_176362418 =                 "";
                var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_176362418.addTaint(taint);
                return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_176362418;
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
String varD669198966AE1D11824B74353EFDF302_1395191806 =         "# Open Cursors=" + total + s;
        varD669198966AE1D11824B74353EFDF302_1395191806.addTaint(taint);
        return varD669198966AE1D11824B74353EFDF302_1395191806;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.754 -0400", hash_original_method = "2B041B6FC7B2CED29CA29EA62E026B41", hash_generated_method = "D4058BB7031DEE79BA386EC360C1CDEE")
    @Override
    public String toString() {
String var3E9B70506FB423FE6C7A32E2D683FA47_1785310248 =         getName() + " {" + Integer.toHexString(mWindowPtr) + "}";
        var3E9B70506FB423FE6C7A32E2D683FA47_1785310248.addTaint(taint);
        return var3E9B70506FB423FE6C7A32E2D683FA47_1785310248;
        // ---------- Original Method ----------
        //return getName() + " {" + Integer.toHexString(mWindowPtr) + "}";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.754 -0400", hash_original_field = "5B3E3E3506C786C5E8C89033AAFE5334", hash_generated_field = "8D10DBBD9161B24BFA923BA8ACB7AE58")

    private static final String STATS_TAG = "CursorWindowStats";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.754 -0400", hash_original_field = "3B37C53C1B3E3C57E085C22B6489179B", hash_generated_field = "BA4FA4A72DC6187CE1C91540199A8E43")

    private static final int sCursorWindowSize = Resources.getSystem().getInteger(
                com.android.internal.R.integer.config_cursorWindowSize) * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.754 -0400", hash_original_field = "F4DD3BCA06A6A101A72063C4264660FF", hash_generated_field = "9DA0907775B4EA7DABCE5B56F25B0D3B")

    public static final Parcelable.Creator<CursorWindow> CREATOR
            = new Parcelable.Creator<CursorWindow>() {
        public CursorWindow createFromParcel(Parcel source) {
            return new CursorWindow(source);
        }

        public CursorWindow[] newArray(int size) {
            return new CursorWindow[size];
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.754 -0400", hash_original_field = "E92F2862489B24AFB0331EE5C78DA3B9", hash_generated_field = "E194A8535700746837F74D9B692D7DA6")

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

