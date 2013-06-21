package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.844 -0400", hash_original_method = "4DD3601E1CB5867F2A24984596824EE2", hash_generated_method = "4DD3601E1CB5867F2A24984596824EE2")
        public AbstractWindowedCursor ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.846 -0400", hash_original_method = "87598253341A04422FF4D21C2BB371F4", hash_generated_method = "4E134EE66270C402A8D2AA16C3BCF04B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getBlob(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        byte[] var39FD5C6F5EEE292DAA371D30702452CA_429313370 = (mWindow.getBlob(mPos, columnIndex));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getBlob(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.847 -0400", hash_original_method = "80DC04F99A2A57F6C5D41327EC1C50ED", hash_generated_method = "09B40AE2418AF58A3ACA8F14594F306B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getString(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        String varB8FBBEEC991B42F64E01A6646AF9D8B4_765125384 = (mWindow.getString(mPos, columnIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getString(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.847 -0400", hash_original_method = "7A0E01C330FD8C9E9BBB19344D3EAAEA", hash_generated_method = "F52F560FA172914CBBBE077A1CBC4931")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(columnIndex);
        checkPosition();
        mWindow.copyStringToBuffer(mPos, columnIndex, buffer);
        // ---------- Original Method ----------
        //checkPosition();
        //mWindow.copyStringToBuffer(mPos, columnIndex, buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.848 -0400", hash_original_method = "831E6CBBE62E24F365C378674B05306E", hash_generated_method = "27BA65F80D4F64BE0480FF7FA1A0D378")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public short getShort(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        short var33D291ABA4A9FF3F3B0A08FA7044AC09_287592059 = (mWindow.getShort(mPos, columnIndex));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getShort(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.848 -0400", hash_original_method = "A77BC22B3B7D8AA9E2F50FAA1FFFE93C", hash_generated_method = "D670A08A89734670F5C2DD4666B6D38A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getInt(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        int varBF0BF538CDEEB1D98B0D0E7C018BDC71_1987134372 = (mWindow.getInt(mPos, columnIndex));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getInt(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.848 -0400", hash_original_method = "32AD2A447F72132C95E38AB4CD7276EC", hash_generated_method = "C18B75343D7BF2C40976D05641BD81F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getLong(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        long varFA2C7C48C4088D541253B207931A64FB_311780142 = (mWindow.getLong(mPos, columnIndex));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getLong(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.849 -0400", hash_original_method = "97A96E7B6D9585C7632D24C9ACC936B0", hash_generated_method = "E07B55946040C7DC9B5261A3180B81B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public float getFloat(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        float varB8D197C8B9C000D5F71776D01520E3DC_1046090528 = (mWindow.getFloat(mPos, columnIndex));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getFloat(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.849 -0400", hash_original_method = "5EA94253BE97AB01CBE30DAF30AB624B", hash_generated_method = "0D1FC41813145CCE08F77DCEA408FE63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public double getDouble(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        double var07BF2FFD7FAADC555D8393932B080255_1041648269 = (mWindow.getDouble(mPos, columnIndex));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getDouble(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.849 -0400", hash_original_method = "6A9D95B36787857467112609FB3E833C", hash_generated_method = "921F530586A782E7CB7FEB679E90258A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isNull(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        boolean var8ECA20BFB733E435005F16959D7BD187_228299999 = (mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.850 -0400", hash_original_method = "8C706BE21B67BF56FAAF00C967A8C37B", hash_generated_method = "9F9257E0541B32D1C8FC59DC7E09B13C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isBlob(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        boolean varF7680A757356092A9E6DEAF98C515184_597332318 = (getType(columnIndex) == Cursor.FIELD_TYPE_BLOB);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_BLOB;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.850 -0400", hash_original_method = "BDCD863F6E874A96AC9E7E0E4D765E55", hash_generated_method = "5FEF473F0ABEEC6869A0282DAB95483C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isString(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        boolean var8B4BEEBC34AE9EB53A790B71F8A585F6_1449762803 = (getType(columnIndex) == Cursor.FIELD_TYPE_STRING);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.850 -0400", hash_original_method = "C215029524CB115AA1C1047DC544E060", hash_generated_method = "D5A7DE4003797B74F65FDEC6933E6954")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isLong(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        boolean var28EDD7C01277563172CDB5F1313EBEF5_1790525052 = (getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.851 -0400", hash_original_method = "C5D9D79A9E5267D689CC2AB9EDF1D366", hash_generated_method = "257B2803B816F6B50FB8F6ED0A164C0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isFloat(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        boolean var76AADF030CE2B68747D5053865BB78CB_1362343812 = (getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.851 -0400", hash_original_method = "CEEA013C273D2B30A1533873F1614E01", hash_generated_method = "C50243C8DFF750AC1CA6C715447F4DD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getType(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        int var926F08F366F078B1AC685748290DCC25_894759850 = (mWindow.getType(mPos, columnIndex));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.851 -0400", hash_original_method = "46B0DF4A07DF4EB7D2CA6A3ED3C216CA", hash_generated_method = "58764678C2B3816DC53D87F7D957FF78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void checkPosition() {
        super.checkPosition();
        {
            if (DroidSafeAndroidRuntime.control) throw new StaleDataException("Attempting to access a closed CursorWindow." +
                    "Most probable cause: cursor is deactivated prior to calling this method.");
        } //End block
        // ---------- Original Method ----------
        //super.checkPosition();
        //if (mWindow == null) {
            //throw new StaleDataException("Attempting to access a closed CursorWindow." +
                    //"Most probable cause: cursor is deactivated prior to calling this method.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.852 -0400", hash_original_method = "1266B4A96CD75271FEBF68638404515E", hash_generated_method = "2BD5419271E350A76CB46090CA2F1D7F")
    @DSModeled(DSC.SAFE)
    @Override
    public CursorWindow getWindow() {
        return (CursorWindow)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.852 -0400", hash_original_method = "EEBD6C49E5EC72817DC3243A2E7FCB7D", hash_generated_method = "E4768BAEC78DFB93F703D40F2E6E91FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWindow(CursorWindow window) {
        dsTaint.addTaint(window.dsTaint);
        {
            closeWindow();
        } //End block
        // ---------- Original Method ----------
        //if (window != mWindow) {
            //closeWindow();
            //mWindow = window;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.852 -0400", hash_original_method = "CE7634279B030B3367B24B82DE682EB0", hash_generated_method = "7956D7FFE6233542FA2B55040CA01DB3")
    @DSModeled(DSC.SAFE)
    public boolean hasWindow() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWindow != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.853 -0400", hash_original_method = "53135D68273D9C60BFA0802F12D5EFAC", hash_generated_method = "EF65761FAAC84B0E50AC8B689921A05C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void closeWindow() {
        {
            mWindow.close();
            mWindow = null;
        } //End block
        // ---------- Original Method ----------
        //if (mWindow != null) {
            //mWindow.close();
            //mWindow = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.853 -0400", hash_original_method = "5B67F8BB651F008F63750FC6E33E54E8", hash_generated_method = "C6D74D473F0EB3C0334667621408E979")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void clearOrCreateWindow(String name) {
        dsTaint.addTaint(name);
        {
            mWindow = new CursorWindow(name);
        } //End block
        {
            mWindow.clear();
        } //End block
        // ---------- Original Method ----------
        //if (mWindow == null) {
            //mWindow = new CursorWindow(name);
        //} else {
            //mWindow.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.854 -0400", hash_original_method = "C8847040621704A6986D97364F312269", hash_generated_method = "6CD575C7E400F361AFC0582D59EEEF79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onDeactivateOrClose() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDeactivateOrClose();
        closeWindow();
        // ---------- Original Method ----------
        //super.onDeactivateOrClose();
        //closeWindow();
    }

    
}

