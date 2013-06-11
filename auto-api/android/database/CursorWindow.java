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
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class CursorWindow extends SQLiteClosable implements Parcelable {
    private static final String STATS_TAG = "CursorWindowStats";
    private static final int sCursorWindowSize =
        Resources.getSystem().getInteger(
                com.android.internal.R.integer.config_cursorWindowSize) * 1024;
    public int mWindowPtr;
    private int mStartPos;
    private /* final */ String mName = "";
    private final CloseGuard mCloseGuard = CloseGuard.get();
    public static final Parcelable.Creator<CursorWindow> CREATOR = new Parcelable.Creator<CursorWindow>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.604 -0400", hash_original_method = "102321E705544E214630A229EBF0AAEA", hash_generated_method = "9AF79E9E553C446EDD303A01C77D131E")
        @DSModeled(DSC.SAFE)
        public CursorWindow createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (CursorWindow)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CursorWindow(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.604 -0400", hash_original_method = "22E812BCDE3BA2EC64FA32FE6BB196D2", hash_generated_method = "D356E4BBD1557AFB7A6DEF71965DDEDE")
        @DSModeled(DSC.SAFE)
        public CursorWindow[] newArray(int size) {
            dsTaint.addTaint(size);
            return (CursorWindow[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CursorWindow[size];
        }

        
}; //Transformed anonymous class
    private static final SparseIntArray sWindowToPidMap = new SparseIntArray();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.604 -0400", hash_original_method = "D2526397A12BC25EA910BA6CE9A2504E", hash_generated_method = "C935C292E7CBD7A5C79DD9F5305A76A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CursorWindow(String name) {
        dsTaint.addTaint(name);
        mStartPos = 0;
        mWindowPtr = nativeCreate(name, sCursorWindowSize);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new CursorWindowAllocationException("Cursor window allocation of " +
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.604 -0400", hash_original_method = "CB3D999FBD9663B85250B0069300DD19", hash_generated_method = "40EC1460D34B7D29D7A6BEBD11AEA625")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public CursorWindow(boolean localWindow) {
        this((String)null);
        dsTaint.addTaint(localWindow);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.604 -0400", hash_original_method = "2F52A6C89F1D54A86C82C46FF5E1EC25", hash_generated_method = "0CB4A0209C54BCD8E88EED1DA3BBB5B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CursorWindow(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        mStartPos = source.readInt();
        mWindowPtr = nativeCreateFromParcel(source);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new CursorWindowAllocationException("Cursor window could not be "
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.605 -0400", hash_original_method = "501523168FFB51969E73F0E7A0AF122B", hash_generated_method = "05115DC15C3ED72E37E8ACE32D376963")
    private static int nativeCreate(String name, int cursorWindowSize) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.605 -0400", hash_original_method = "CFF7D5B1CFA90D647435737F51BF0270", hash_generated_method = "BEF1D7DDB4C5CE5F313BF844DF2DF161")
    private static int nativeCreateFromParcel(Parcel parcel) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.605 -0400", hash_original_method = "E443BB21CD73385F4E35A9E90576FF35", hash_generated_method = "2B5BA695ECC4E88A9445D39392DED766")
    private static void nativeDispose(int windowPtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.605 -0400", hash_original_method = "52CD486B03995CCA558873837BB97737", hash_generated_method = "023F1F691A0BD50504AE8A8F5F621F22")
    private static void nativeWriteToParcel(int windowPtr, Parcel parcel) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.605 -0400", hash_original_method = "E4B8A070DF1E83528147F1BF3ED349EE", hash_generated_method = "2FEBDE5D89C0DC53347057ADB4404C69")
    private static void nativeClear(int windowPtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.605 -0400", hash_original_method = "0A1D0C97C7EA147FDD9374E2D759E523", hash_generated_method = "9D4289CE42879AF70E6A892F18A09D09")
    private static int nativeGetNumRows(int windowPtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.605 -0400", hash_original_method = "D868B9E1F9DEE546280D91140A2C0B9C", hash_generated_method = "E84EB4DB33DF919528E8B17A0B60133F")
    private static boolean nativeSetNumColumns(int windowPtr, int columnNum) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.606 -0400", hash_original_method = "39120F02867F174AC41350F95C7E4299", hash_generated_method = "A937B5CEF98876649824D9AC0B336EA0")
    private static boolean nativeAllocRow(int windowPtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.606 -0400", hash_original_method = "1AC0269C27731A0686AA276F9C739012", hash_generated_method = "A93C8FCDEBA7EB415035C3577F233F1B")
    private static void nativeFreeLastRow(int windowPtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.606 -0400", hash_original_method = "1E45E1595F369B3ABAE8398712F88EE2", hash_generated_method = "7020AB2FB5BDDD14A17697493545800F")
    private static int nativeGetType(int windowPtr, int row, int column) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.606 -0400", hash_original_method = "B7A033EB62A00FE2231D5B2D7F12DED3", hash_generated_method = "D676F3E86E068EA64C8770589DF6D7E2")
    private static byte[] nativeGetBlob(int windowPtr, int row, int column) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return new byte[]{DSUtils.UNKNOWN_BYTE};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.606 -0400", hash_original_method = "F83986BEDA50A2A960C874D9B0D876E8", hash_generated_method = "86369C792BFDC2295CC6C893F8FA9ACF")
    private static String nativeGetString(int windowPtr, int row, int column) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.606 -0400", hash_original_method = "3D70BB7172270E8733C983DE6345ED7F", hash_generated_method = "BFDE556664FBF26AEFD88F53C949FEB4")
    private static long nativeGetLong(int windowPtr, int row, int column) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_LONG;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.606 -0400", hash_original_method = "FA7C6040C00675B65C5405274D41A0C8", hash_generated_method = "59742A93E69A342D8DC129CC1151E1AC")
    private static double nativeGetDouble(int windowPtr, int row, int column) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_DOUBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.606 -0400", hash_original_method = "FCE436359CB4598E09941852E69908AF", hash_generated_method = "417F50471C1518887604058059D4D02C")
    private static void nativeCopyStringToBuffer(int windowPtr, int row, int column,
            CharArrayBuffer buffer) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.607 -0400", hash_original_method = "BE1869E5B0823DE63098CC0562DBC76E", hash_generated_method = "2A36C8A5CE26AF3013AADE19646398E6")
    private static boolean nativePutBlob(int windowPtr, byte[] value, int row, int column) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.607 -0400", hash_original_method = "321790605EF896E5024DD3A46D54BF99", hash_generated_method = "3E527D8FC25FEDFE886B723977AEB2F0")
    private static boolean nativePutString(int windowPtr, String value, int row, int column) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.607 -0400", hash_original_method = "C6693C3E04413D578E2160003FA3F945", hash_generated_method = "F73A783AA2B25AB5EFE3A5553CE2BE94")
    private static boolean nativePutLong(int windowPtr, long value, int row, int column) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.607 -0400", hash_original_method = "68A21BD41C5F661D84F45A330A11F1C1", hash_generated_method = "539594543DD5F34EC8C338C8B67EC401")
    private static boolean nativePutDouble(int windowPtr, double value, int row, int column) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.607 -0400", hash_original_method = "10F2A3DB7868688C26145A753D34435F", hash_generated_method = "54BF46EEAE61D67881C3685B780CD3B3")
    private static boolean nativePutNull(int windowPtr, int row, int column) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.607 -0400", hash_original_method = "E12DB547300BD77B2F54DC927EA6FF66", hash_generated_method = "9A67FE6523CF099E0E5D5D1999622B4A")
    private static String nativeGetName(int windowPtr) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.608 -0400", hash_original_method = "896D51A0732498DB684FD2752503707E", hash_generated_method = "F80AC2F1DBB093BE242B3E7337C4818D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.608 -0400", hash_original_method = "DF965B7262A7C1EB6D66FE3F57E4031E", hash_generated_method = "4F49E85F3D722463409B1DEE512EF5D3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.608 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "5B64F8F5AC7FE997D96CC003BA212E34")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.608 -0400", hash_original_method = "6B12CEFAA1DE3FB86CA989F7EF7D159A", hash_generated_method = "5AF8DA4597B493058D0E8C89DD1D6B19")
    @DSModeled(DSC.SAFE)
    public void close() {
        releaseReference();
        // ---------- Original Method ----------
        //releaseReference();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.608 -0400", hash_original_method = "979E75E660A1C8BD17328FDD55823D54", hash_generated_method = "6EF3A418A2E766668A721856B7A4864F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.608 -0400", hash_original_method = "E83B1D6D3C97BD3B3A2AA134F51457E7", hash_generated_method = "D26F4934983F820CC189CA9D52247979")
    @DSModeled(DSC.SAFE)
    public int getStartPosition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStartPos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.609 -0400", hash_original_method = "A3D22CBF25891D62569B204C4A11C84D", hash_generated_method = "9464DE73C81F7B8595B238D218754719")
    @DSModeled(DSC.SAFE)
    public void setStartPosition(int pos) {
        dsTaint.addTaint(pos);
        // ---------- Original Method ----------
        //mStartPos = pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.609 -0400", hash_original_method = "FEBAC209BE2E731A41AC61FC29EF2631", hash_generated_method = "F4C464A27ABAD548F16BAB985C6717EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getNumRows() {
        acquireReference();
        try 
        {
            int var414F51D82D9BF7C55CA2723FC84CAD14_78201685 = (nativeGetNumRows(mWindowPtr));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.609 -0400", hash_original_method = "06070130EC2CA13555B4890F162F9E48", hash_generated_method = "6E9E60513A0B0521E5892C5768E12102")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setNumColumns(int columnNum) {
        dsTaint.addTaint(columnNum);
        acquireReference();
        try 
        {
            boolean var1AD4C2C634C3D9AB4728527E89734163_1659256442 = (nativeSetNumColumns(mWindowPtr, columnNum));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.609 -0400", hash_original_method = "EA2451DCCE3D57D72B2D978A02AB8CBE", hash_generated_method = "3292661A0218C791EE3B8B32EC61BEF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean allocRow() {
        acquireReference();
        try 
        {
            boolean var01A0BA1F86225288F569462FC8FBBF5E_1434062208 = (nativeAllocRow(mWindowPtr));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.609 -0400", hash_original_method = "B379FF08DED00763293DB0E42243B555", hash_generated_method = "140D6293813E8DBA80984E63CD2CE609")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.610 -0400", hash_original_method = "49D7CBD5A9292352030392B89291BE3D", hash_generated_method = "72EBF08979F6BD891E7DA8A980E4F274")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isNull(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        boolean var97A1C67CC6DAFD00A3A8F4664D9EE64B_1261949687 = (getType(row, column) == Cursor.FIELD_TYPE_NULL);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.610 -0400", hash_original_method = "C746642EB39EFB60299B9B6078CB8713", hash_generated_method = "8CDD9ED1A98EA8CE1A4C2E88D19E2A04")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.610 -0400", hash_original_method = "F41C7C64C57B82BE924AB092481D8C56", hash_generated_method = "A86003C19336A64F4107A93A3FBF172D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isLong(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        boolean var1DB86FDE6B4703FBCFBD16036E160C9C_1750862991 = (getType(row, column) == Cursor.FIELD_TYPE_INTEGER);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.610 -0400", hash_original_method = "AB10FF6E7457EC84D59F089A4F39FCC7", hash_generated_method = "C5BA42F1F22BD3B5CA987DBF392DC92F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isFloat(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        boolean var6554498C7E79ED2247913695DFC28232_1457248629 = (getType(row, column) == Cursor.FIELD_TYPE_FLOAT);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(row, column) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.611 -0400", hash_original_method = "235C1A23640EE5ABC2401DF58B1A3F61", hash_generated_method = "C54007C9535D6EF30ACD2E652F4EE8E6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.611 -0400", hash_original_method = "8E937452D8006A30B303869F5FCBB330", hash_generated_method = "C2260AEEEEAA1128A921B6293D1AF38B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getType(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            int var71CCA26C17E48AE0D0877F9F348F7D74_223157665 = (nativeGetType(mWindowPtr, row - mStartPos, column));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.611 -0400", hash_original_method = "369AEBF74D7711C2C086D87D281ECBA3", hash_generated_method = "96E3675073F49EAF5A32DAD203083DC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getBlob(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            byte[] varBD638E3555273746DC3865B80681F60E_1136925676 = (nativeGetBlob(mWindowPtr, row - mStartPos, column));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.611 -0400", hash_original_method = "91E1480DC9AA77B4570FAB2ABB8DFF8A", hash_generated_method = "5710B7E1667FE714C79E27EAE9DEAB77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            String var0B1EF07AA5FFF7722F982EF0A8E837E4_1169934883 = (nativeGetString(mWindowPtr, row - mStartPos, column));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.612 -0400", hash_original_method = "58A64F01A8AD746344B9549C1A3482B7", hash_generated_method = "C79B2E0549AB10025089A1170487DD25")
    @DSModeled(DSC.SAFE)
    public void copyStringToBuffer(int row, int column, CharArrayBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new IllegalArgumentException("CharArrayBuffer should not be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.612 -0400", hash_original_method = "AD6EFD172162F129E252A5B000066DBD", hash_generated_method = "F6A7E8BF9CE6EA0185FBCBE820461D1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            long var168504F324B8494AD63EF9400F960BF4_2051179138 = (nativeGetLong(mWindowPtr, row - mStartPos, column));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.612 -0400", hash_original_method = "8A6F3264B03417AA20925F57716C63D9", hash_generated_method = "9A74F0E34987B478F8E3FACDC22D9561")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDouble(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            double var664302859858AF173EF357CBCF35091D_2144555208 = (nativeGetDouble(mWindowPtr, row - mStartPos, column));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.612 -0400", hash_original_method = "A20DC76A6D7B2E924E48673418BA5751", hash_generated_method = "683F1E68F657766724F5DA67DDB85BAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short getShort(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        short var5F63A2F12068779C1BB1A99745C9CAB9_1849460010 = ((short) getLong(row, column));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return (short) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.612 -0400", hash_original_method = "551A86F714BE24A79B828A8B72E1E568", hash_generated_method = "95F797900D1B25E597AF94992A9276B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        int varEE76896E32EEB64BFB310F2A5B6E4AE8_226168157 = ((int) getLong(row, column));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (int) getLong(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.613 -0400", hash_original_method = "27DD398413CBDB3B58DB63ADFF69899A", hash_generated_method = "3AF4ACDD43C969D66838E01B35F64CA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloat(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        float varD967860490A37C92BE233D56CF4148A1_2013217979 = ((float) getDouble(row, column));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return (float) getDouble(row, column);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.613 -0400", hash_original_method = "6CB3F309867B314299E03BAA3ADD01B0", hash_generated_method = "0E403848074D5CCA2083D2C6ADD1FB92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean putBlob(byte[] value, int row, int column) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            boolean varDBF02A91A7F9FB2B44A262BEC4A20A1D_1057930182 = (nativePutBlob(mWindowPtr, value, row - mStartPos, column));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.613 -0400", hash_original_method = "6CB1D543D51D5DCA24055F8F53C41BAF", hash_generated_method = "9D97FCDCA7413E2316253956174AEF57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean putString(String value, int row, int column) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            boolean varEC5141FBADFF6FC9B99D1AD371FD7973_42969434 = (nativePutString(mWindowPtr, value, row - mStartPos, column));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.613 -0400", hash_original_method = "2778A952D34B60D93ADEBF86D42CFB13", hash_generated_method = "91AD214FFEEEB2A86FBEEC9FDFE0A542")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean putLong(long value, int row, int column) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            boolean var7996BC4E6D3BD70C3EF52496645FC6D8_1977135165 = (nativePutLong(mWindowPtr, value, row - mStartPos, column));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.614 -0400", hash_original_method = "750162916D1917FF199EBD766435A4BC", hash_generated_method = "F130A3AAE51B6D0199D44E0EC39FAF59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean putDouble(double value, int row, int column) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            boolean var8E20548EEFA5A64A44A4E184ABC6FC3B_1981831893 = (nativePutDouble(mWindowPtr, value, row - mStartPos, column));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.614 -0400", hash_original_method = "729F260E3687A604BDCEB4B5144460BE", hash_generated_method = "37FCDF292C6E3E86C6D090560830EB43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean putNull(int row, int column) {
        dsTaint.addTaint(column);
        dsTaint.addTaint(row);
        acquireReference();
        try 
        {
            boolean varEDCC8D3EE34F721869F33D574DB972AA_2045842548 = (nativePutNull(mWindowPtr, row - mStartPos, column));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.614 -0400", hash_original_method = "82A0D8881224A345C7D71889E82FF712", hash_generated_method = "A1F37DF171B5E56C3C2502ADC2995201")
    public static CursorWindow newFromParcel(Parcel p) {
        return CREATOR.createFromParcel(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.614 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.614 -0400", hash_original_method = "A351847D47687056BE0F3C5BF172823F", hash_generated_method = "F65BAB456EAE075CD38EA9F9F111CD44")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.615 -0400", hash_original_method = "9F0DD3DD42B1176D3BFC90E1CC869BD8", hash_generated_method = "FECD9B58493D9408A6DC20A2C3620B7D")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onAllReferencesReleased() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dispose();
        // ---------- Original Method ----------
        //dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.615 -0400", hash_original_method = "A1A5B0D31D251CEBDD86B0232FAF0913", hash_generated_method = "446E1D11A803D4E95A331AF9CF52482F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void recordNewWindow(int pid, int window) {
        dsTaint.addTaint(window);
        dsTaint.addTaint(pid);
        {
            sWindowToPidMap.put(window, pid);
            {
                boolean varC36DF1398F4EE2BD3893C3E1F97813EC_1131174386 = (Log.isLoggable(STATS_TAG, Log.VERBOSE));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.615 -0400", hash_original_method = "35EFD039834BDFB7DFA5FAF4FCFF938C", hash_generated_method = "21266F87F7753EEBD8FC721DCC84CE42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void recordClosingOfWindow(int window) {
        dsTaint.addTaint(window);
        {
            {
                boolean var1E358411B44E94E4F474E426A793D087_1101284688 = (sWindowToPidMap.size() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.616 -0400", hash_original_method = "FB6D9C80437A7691015FDFE53D1A15C9", hash_generated_method = "C3581FCEE7D66E1505686EA6FC7665D1")
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
        boolean var73BE181800F050B89C23EBA00B9AC3AE_218207526 = ((buff.length() > 980));
        s = buff.substring(0, 980);
        s = buff.toString();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.616 -0400", hash_original_method = "2B041B6FC7B2CED29CA29EA62E026B41", hash_generated_method = "6D324203DC0FDB39541C6AC981FAFC00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varF798FCF7A644093E19C7A8E7330F4FA3_284619939 = (getName() + " {" + Integer.toHexString(mWindowPtr) + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getName() + " {" + Integer.toHexString(mWindowPtr) + "}";
    }

    
}


