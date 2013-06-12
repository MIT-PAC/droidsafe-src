package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.731 -0400", hash_original_method = "87598253341A04422FF4D21C2BB371F4", hash_generated_method = "070D97F4A600E62F2376B27B5AA4F86D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getBlob(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        byte[] var39FD5C6F5EEE292DAA371D30702452CA_913622564 = (mWindow.getBlob(mPos, columnIndex));
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getBlob(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.743 -0400", hash_original_method = "80DC04F99A2A57F6C5D41327EC1C50ED", hash_generated_method = "D15F9A3F5C05EC78E590BE069AA4EA3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getString(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        String varB8FBBEEC991B42F64E01A6646AF9D8B4_1117898133 = (mWindow.getString(mPos, columnIndex));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getString(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.760 -0400", hash_original_method = "7A0E01C330FD8C9E9BBB19344D3EAAEA", hash_generated_method = "B21B73104BD2884F67AB95182CD0CD55")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.771 -0400", hash_original_method = "831E6CBBE62E24F365C378674B05306E", hash_generated_method = "7790C651AC2F9A573777E7566B7882B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public short getShort(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        short var33D291ABA4A9FF3F3B0A08FA7044AC09_1816388008 = (mWindow.getShort(mPos, columnIndex));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getShort(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.791 -0400", hash_original_method = "A77BC22B3B7D8AA9E2F50FAA1FFFE93C", hash_generated_method = "73227F28B6A35ECCE25613FA84B13159")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getInt(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        int varBF0BF538CDEEB1D98B0D0E7C018BDC71_1695667063 = (mWindow.getInt(mPos, columnIndex));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getInt(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.803 -0400", hash_original_method = "32AD2A447F72132C95E38AB4CD7276EC", hash_generated_method = "BB68406890EF900C97EE01795B9343CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getLong(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        long varFA2C7C48C4088D541253B207931A64FB_1798575739 = (mWindow.getLong(mPos, columnIndex));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getLong(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.811 -0400", hash_original_method = "97A96E7B6D9585C7632D24C9ACC936B0", hash_generated_method = "CF15DCA7D3A9D3A094A5EC7FF6B9B263")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public float getFloat(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        float varB8D197C8B9C000D5F71776D01520E3DC_684240398 = (mWindow.getFloat(mPos, columnIndex));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getFloat(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.820 -0400", hash_original_method = "5EA94253BE97AB01CBE30DAF30AB624B", hash_generated_method = "E0C668B99E7CB372B155FCD52A0DDBE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public double getDouble(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        double var07BF2FFD7FAADC555D8393932B080255_1320115805 = (mWindow.getDouble(mPos, columnIndex));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getDouble(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.839 -0400", hash_original_method = "6A9D95B36787857467112609FB3E833C", hash_generated_method = "935FC7F9D581DE290F2C70C9724FEA22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isNull(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        boolean var8ECA20BFB733E435005F16959D7BD187_1002145021 = (mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex) == Cursor.FIELD_TYPE_NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.846 -0400", hash_original_method = "8C706BE21B67BF56FAAF00C967A8C37B", hash_generated_method = "37128A9EF7926A890F1B7DDDE0DB4F2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isBlob(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        boolean varF7680A757356092A9E6DEAF98C515184_2028656081 = (getType(columnIndex) == Cursor.FIELD_TYPE_BLOB);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_BLOB;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.856 -0400", hash_original_method = "BDCD863F6E874A96AC9E7E0E4D765E55", hash_generated_method = "055E6A49ABC1DA6AE46DFF31C4F2B3EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isString(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        boolean var8B4BEEBC34AE9EB53A790B71F8A585F6_100309915 = (getType(columnIndex) == Cursor.FIELD_TYPE_STRING);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_STRING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.868 -0400", hash_original_method = "C215029524CB115AA1C1047DC544E060", hash_generated_method = "FA794888C49475E2762E1B83C1B62A58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isLong(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        boolean var28EDD7C01277563172CDB5F1313EBEF5_488377106 = (getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_INTEGER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.876 -0400", hash_original_method = "C5D9D79A9E5267D689CC2AB9EDF1D366", hash_generated_method = "18801011E2A9A8EB343CF3169907109E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean isFloat(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        boolean var76AADF030CE2B68747D5053865BB78CB_423297446 = (getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getType(columnIndex) == Cursor.FIELD_TYPE_FLOAT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.886 -0400", hash_original_method = "CEEA013C273D2B30A1533873F1614E01", hash_generated_method = "A485739A8DDC2C919633123DB8FECF8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getType(int columnIndex) {
        dsTaint.addTaint(columnIndex);
        checkPosition();
        int var926F08F366F078B1AC685748290DCC25_693619254 = (mWindow.getType(mPos, columnIndex));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkPosition();
        //return mWindow.getType(mPos, columnIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.895 -0400", hash_original_method = "46B0DF4A07DF4EB7D2CA6A3ED3C216CA", hash_generated_method = "4E5EDCFF29F7F6773079568C14019F89")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.902 -0400", hash_original_method = "1266B4A96CD75271FEBF68638404515E", hash_generated_method = "EB71EFC07A4B93BCD4462D3358CD427D")
    @DSModeled(DSC.SAFE)
    @Override
    public CursorWindow getWindow() {
        return (CursorWindow)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.926 -0400", hash_original_method = "EEBD6C49E5EC72817DC3243A2E7FCB7D", hash_generated_method = "6A9636BC1260668853F22EC551DA407D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.939 -0400", hash_original_method = "CE7634279B030B3367B24B82DE682EB0", hash_generated_method = "B0DD2FD7BFB1731322F149E84D4F8415")
    @DSModeled(DSC.SAFE)
    public boolean hasWindow() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mWindow != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.955 -0400", hash_original_method = "53135D68273D9C60BFA0802F12D5EFAC", hash_generated_method = "E334B77C94B2462F8DB10213C5F7FC04")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.975 -0400", hash_original_method = "5B67F8BB651F008F63750FC6E33E54E8", hash_generated_method = "6046E4037AD360417BE073D6C361D361")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:02:03.982 -0400", hash_original_method = "C8847040621704A6986D97364F312269", hash_generated_method = "B43536A79B715941D9227A4B633421F4")
    @DSModeled(DSC.SAFE)
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


